package com.service.Impl;

import com.dao.Impl.MedicineDaoImpl;
import com.dao.Impl.QualityDaoImpl;
import com.dao.MedicineDao;
import com.dao.QualityDao;
import com.pojo.*;
import com.service.QualityService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.util.SQLtoString.getSQL;
import static com.util.Vessel.*;
import static com.util.Vessel.medicineDao;

public class QualityServiceImpl implements QualityService {

    QualityDao qualityDao = new QualityDaoImpl();
    MedicineDao medicineDao = new MedicineDaoImpl();

    @Override
    public int addQuality(Quality quality) {
        Medicine medicine = medicineDao.getMedicine(quality.getTableCoding());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        quality.setTime(format);
        quality.setStatue(0);
        quality.setStorageStatus("未入库");
        quality.setmId(medicine.getmId());
        quality.setmName(medicine.getmName());
        quality.setGoodsType(medicine.getGoodsType());
        quality.setmType(medicine.getmType());
        quality.setDefind(medicine.getDefined());
        quality.setDrugFrom(medicine.getDrugFrom());
        quality.setSupplier(medicine.getSupplier());
        if (quality.getTotlNumber()<3){
            quality.setSurveyNumber(quality.getTotlNumber());
        }else if(quality.getTotlNumber()>3 && quality.getTotlNumber()<50){
            quality.setSurveyNumber(3);
        }else {
            int totlNumber = quality.getTotlNumber();
            int i = (int) Math.ceil(totlNumber/50);
            quality.setSurveyNumber(3+i);
        }
        quality.setOrderId(qualityDao.getOid());
        return qualityDao.addQuality(quality);
    }

    @Override
    public List<Quality> getQualityBySS(String storageStatus) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        int i = 0;
        for (Quality qualityBySS : qualityDao.getQualityBySS(storageStatus)) {
            try {
                Date parse1 = simpleDateFormat.parse(format);
                Date parse2 = simpleDateFormat.parse(qualityBySS.getTime());
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(parse1);
                calendar.add(Calendar.DAY_OF_MONTH, -10);
                Date DaysAgo = calendar.getTime();
                if (parse2.before(DaysAgo)&&qualityBySS.getStorageStatus().equals("已入库")){
                    qualityBySS.setStatue(0);
                    qualityDao.updateQualityStatue(qualityBySS);
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return qualityDao.getQualityBySS(storageStatus);
    }

    @Override
    public List<Quality> getQualityBySS(String storageStatus, int index, int limit) {
        int page = (index-1)*limit;
        return qualityDao.getQualityBySS(storageStatus,page,limit);
    }

    @Override
    public List<Quality> getQualityBySS(String storageStatus, int index, int limit, String order, String title) {
        int page = (index-1)*limit;
        return qualityDao.getQualityBySS(storageStatus,page,limit,order,title);
    }

    @Override
    public List<Quality> getQualityByTime(String sql, String time) {
        return qualityDao.getQualityByTime(sql, time);
    }

    @Override
    public List<Quality> getQualityByName(String sql, String mName) {
        return qualityDao.getQualityByName(sql, mName);
    }

    @Override
    public List<Quality> getQualityByQuery(String sql,String[] query) {
        int i = 0;
        String[] keys = {"goodsType","mType","defind","drugFrom"};//这里是键
        Object[] values = {query[0],query[1],query[2],query[3]};//这里是值
        String sql1 = getSQL(keys, values, sql);//apply是表名
        return qualityDao.getQualityByQuery(sql1);
    }

    public Quality getQualityByID(Quality quality) {
        Quality quality1 = qualityDao.getQualityByID(quality.getId());
        return quality1;
    }
    @Override
    public int updateQualityStatue(Quality quality) {
        Quality quality1 = qualityDao.getQualityByID(quality.getId());
        quality1.setWarehousingRemarks(quality.getWarehousingRemarks());
        if (quality1.getStatue() == 0){
            quality1.setStatue(1);
        }else {
            quality1.setStatue(0);
        }
        return qualityDao.updateQualityStatue(quality1);
    }


    @Override
    //入库状态改变方法
    public int updateQualitySS(int id,String name,User user) {
        Quality quality1 = qualityDao.getQualityByID(id);
        List<Integer> qualityOid = qualityDao.getQualityOid(quality1.getOrderId());
        for (int i:qualityOid){
            if (i==0){
                return i;
            }
        }
        if (quality1.getStorageStatus().equals("未入库")) {
            quality1.setStorageStatus("已入库");
            ordersService.getOrder(quality1.getOrderId(), name);
        }
        Warn warn = new Warn();
        warn.setTableCoding(quality1.getTableCoding());
        warn.setuId(user.getId());
        warn.setName(name);
        warn.setTolNumber(quality1.getTotlNumber());
        Warn warnsByTableCoding = warnDao.getWarnsByTableCoding(quality1.getTableCoding());
        warn.setId(warnsByTableCoding.getId());
        if (warnsByTableCoding.getmName() != null ){
            warnService.upWarnTotlNumber(warn,quality1.getUsefulLife(),id);
        }else {
            warnService.addWarn(warn,quality1.getUsefulLife(),id);
        }
        Medicine medicine = medicineDao.getMedicine(quality1.getTableCoding());
        medicine.setUsefulLife(quality1.getUsefulLife());
        medicineDao.updateMedicineBasic(medicine);
        return qualityDao.updateQualitySS(quality1);
    }

    @Override
    public int updateQualityTime(Quality quality) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        quality.setTime(format);
        return qualityDao.updateQualityTime(quality);
    }

    @Override
    public int delQuality(int id) {
        return qualityDao.delQuality(id);
    }

    public int delQualityOid(int oid) {
        return qualityDao.delQualityOid(oid);
    }

    @Override
    public int upUsefulLife(Quality quality) {
        return qualityDao.upUsefulLife(quality);
    }

}
