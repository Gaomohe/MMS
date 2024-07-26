package com.service.Impl;

import com.dao.Impl.WarnDaoImpl;
import com.dao.WarnDao;
import com.pojo.Medicine;
import com.pojo.User;
import com.pojo.Warn;
import com.pojo.WarnDetail;
import com.service.WarnService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static com.util.Vessel.medicineDao;

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
        warnDetail.setNumber(warn.getTolNumber());
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

}
