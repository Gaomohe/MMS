package com.service.Impl;

import com.dao.Impl.WarnDaoImpl;
import com.dao.WarnDao;
import com.pojo.*;
import com.service.WarnService;
import com.util.GetTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.util.SQLtoString.getSQL;
import static com.util.Vessel.*;
import static com.util.Vessel.warnDao;

public class WarnServiceImpl implements WarnService {

    WarnDao warnDao = new WarnDaoImpl();
    @Override
    public int addWarn(Warn warn,String usefulLife) {
        //时间
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        Medicine medicine = medicineDao.getMedicine(warn.getTableCoding());
        Warn warn1 = new Warn();
        warn1.setTableCoding(medicine.getTableCoding());
        warn1.setmName(medicine.getmName());
        warn1.setTime(format);
        warn1.setuId(warn.getuId());
        warn1.setName(warn.getName());
        warn1.setTolNumber(medicine.getNumber()+warn.getTolNumber());
        warnDao.addWarn(warn1);
        //添加警告细节
        int lastWarnId = warnDao.getLastWarnId();
        WarnDetail warnDetail = new WarnDetail();
        warnDetail.setuName(warn.getName());
        warnDetail.setuId(warn.getuId());
        warnDetail.setTime(format);
        warnDetail.setNumber(warn.getTolNumber());
        warnDetail.setUsefulLife(usefulLife);
        warnDetail.setWid(lastWarnId);
        //改变药品数量
        medicine.setNumber(warn1.getTolNumber());
        medicineDao.updateMedicineNumber(medicine);
        return warnDao.addWarnDetail(warnDetail);
    }

    @Override
    public int getWarns() {
        return warnDao.getWarns();
    }

    @Override
    public List<Warn> getWarns(int page,int limit) {
        page = (page-1)*limit;
        return warnDao.getWarns(page,limit);
    }

    @Override
    public List<Warn> getWarns(int page, int limit, String title, String order) {
        page = (page-1)*limit;
        return warnDao.getWarns(page,limit,title,order);
    }

    @Override
    public List<Warn> getWarnsByTime(String time) {
        return warnDao.getWarnsByTime(time);
    }

    @Override
    public List<Warn> getWarnsByMname(String name) {
        return warnDao.getWarnsByMname(name);
    }

    @Override
    public int getWarnDetails() {
        return warnDao.getWarnDetails();
    }

    @Override
    public List<WarnDetail> getWarnDetails(int page, int limit, String title, String order) {
        return warnDao.getWarnDetails(page,limit,title,order);
    }

    @Override
    public List<WarnDetail> getWarnDetails(int page,int limit) {
        page = (page-1)*limit;
        return warnDao.getWarnDetails(page,limit);
    }

    @Override
    public Warn getWarnsById(int id) {
        return warnDao.getWarnsById(id);
    }

    @Override
    public List<WarnDetail> getWarnDetailsByWId(int wid) {
        return warnDao.getWarnDetailsByWId(wid);
    }

    @Override
    public int delWarn(int id) {
        return warnDao.delWarn(id);
    }

    @Override
    public int delWarnDetail(int id) {
        return warnDao.delWarnDetail(id);
    }

    @Override
    public int getLastWarnId() {
        return warnDao.getLastWarnId();
    }

    public void upWarnTime(Warn warn){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        warn.setTime(format);
        warnDao.upWarnTime(warn);
    }
    @Override
    public int upWarnWNumber(Warn warn) {
        upWarnTime(warn);
        return warnDao.upWarnWNumber(warn);
    }

    @Override
    public int upWarnTotlNumber(Warn warn,String usefulLife) {
        Warn warn1 = warnDao.getWarnsById(warn.getId());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        //更新时间
        warn1.setName(warn.getName());
        warn1.setuId(warn.getuId());
        upWarnTime(warn1);
        //添加细节
        Medicine medicine = medicineDao.getMedicine(warn1.getTableCoding());
        medicine.setNumber(medicine.getNumber()+warn.getTolNumber());
        medicineDao.updateMedicineNumber(medicine);
        WarnDetail warnDetail = new WarnDetail();
        warnDetail.setuName(warn.getName());
        warnDetail.setuId(warn.getuId());
        warnDetail.setTime(format);
        warnDetail.setNumber(medicine.getNumber());
        warnDetail.setUsefulLife(usefulLife);
        warnDetail.setWid(warn.getId());
        warnDao.addWarnDetail(warnDetail);
        warn1.setTolNumber(medicine.getNumber());
        return warnDao.upWarnTotlNumber(warn1);
    }

    public int getOutUserfulLife(){
        List<WarnDetail> warndetailsAll = warnDao.getWarndetailsAll();
        int i=0;
        for (WarnDetail warnDetail:warndetailsAll){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDate expirationDate = LocalDate.parse(warnDetail.getUsefulLife(),formatter);
            // 获取当前日期
            LocalDate currentDate = LocalDate.now();
            // 判断是否过期
            if (expirationDate.isBefore(currentDate)) {
                i++;
            }
        }
        return i;
    }
    public int getNeedBuy(){
        int i = 0;
        List<Warn> warnsAll = warnDao.getWarnsAll();
        for (Warn warn:warnsAll){
            if (warn.getWarnNumber()<=warn.getTolNumber()){
                i++;
            }
        }
        return i;
    }

    @Override
    public int upWarnDetailNumber(WarnDetail warnDetail) {
        upWarnDetailTime(warnDetail);
        return warnDao.upWarnDetailTime(warnDetail);
    }

    @Override
    public int upWarnDetailTime(WarnDetail warnDetail) {
        warnDetail.setTime(GetTime.getTime());
        return warnDao.upWarnDetailTime(warnDetail);
    }

    public String delNumber(Medicine medicine1,int number,User user){
        //获取变量
        String time = GetTime.getTime();
        //过滤最佳药品
        List<WarnDetail> warnList = new ArrayList<>();
        //预警总表发出信息
        Warn warnsByTableCoding1 = warnDao.getWarnsByTableCoding(medicine1.getTableCoding());
        int i = warnsByTableCoding1.getTolNumber() - warnsByTableCoding1.getWarnNumber();
        if (i<0){
            Message message = new Message();
            message.setuId(user.getId());
            message.setuName(user.getUserName());
            message.setwId(warnsByTableCoding1.getId());
            message.setMessage(medicine1.getmName() + "药品已到临期值请补充药品");
            messageService.addMessage(message);
        }else if(warnsByTableCoding1.getTolNumber() == 0){
            return "药品无库存";
        }

        if (warnsByTableCoding1.getTolNumber()<number){
            return "药品库存不足";
        }
        //进行库存批次有效期比较，得到从短到长有效期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<WarnDetail> warnDetailsByWId1 = warnDao.getWarnDetailsByWId(warnsByTableCoding1.getId());
        List<WarnDetail> sortedWarnDetails = warnDetailsByWId1.stream()
                .sorted(Comparator.comparing(WarnDetail::getUsefulLife)) // 假设 getTime() 是获取时间的方法
                .collect(Collectors.toList());
        int useNumber = 0;
        for (WarnDetail warnDetail:sortedWarnDetails){
            String time1=warnDetail.getUsefulLife();
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, formatter);
            LocalDateTime dateTime2 = LocalDateTime.parse(time, formatter);
            if (dateTime1.isAfter(dateTime2)) {
                warnList.add(warnDetail);
                useNumber+=warnDetail.getNumber();
            }
        }
        if (useNumber < number){
            return "有效期未过药品数量不足";
        }
        warnsByTableCoding1.setTolNumber(warnsByTableCoding1.getTolNumber()-number);
        medicine1.setNumber(medicine1.getNumber()-number);
        //减去总库存
        warnDao.upWarnTotlNumber(warnsByTableCoding1);
        medicineDao.updateMedicineNumber(medicine1);
        //减去库存
        for (WarnDetail warnDetail:warnList){
            if (number > warnDetail.getNumber()){
                int k = warnDetail.getNumber();
                number -= k;
                warnDetail.setNumber(0);
                warnDetail.setTime(time);
                warnDao.upWarnDetailNumber(warnDetail);
            }else {
                int k = warnDetail.getNumber();
                warnDetail.setNumber(warnDetail.getNumber()-number);
                number -= k;
                warnDetail.setTime(time);
                warnDao.upWarnDetailNumber(warnDetail);
                if (number <= 0){
                    return "出库成功";
                }
            }
        }
        return "出错了";
    }

}
