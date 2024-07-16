package com.service.Impl;

import com.dao.Impl.MedicineDaoImpl;
import com.dao.Impl.QualityDaoImpl;
import com.dao.MedicineDao;
import com.dao.QualityDao;
import com.pojo.Medicine;
import com.pojo.Quality;
import com.service.QualityService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.util.SQLtoString.getSQL;

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
        quality.setWarehousingRemarks(medicine.getWarehousingRemarks());
        return qualityDao.addQuality(quality);
    }

    @Override
    public List<Quality> getQualityBySS(String storageStatus) {
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
        String[] keys = {"goodsType","mType","defined","drugFrom"};//这里是键
        Object[] values = {query[0],query[1],query[2],query[3]};//这里是值
        String sql1 = getSQL(keys, values, sql);//apply是表名
        return qualityDao.getQualityByQuery(sql1);
    }

    @Override
    public int updateQualityStatue(Quality quality) {
        Quality quality1 = qualityDao.getQualityByID(quality.getId());
        if (quality1.getStatue() == 0){
            quality1.setStatue(1);
        }else {
            quality1.setStatue(0);
        }
        System.out.println(quality1.getStatue());
        return qualityDao.updateQualityStatue(quality1);
    }

    @Override
    public int updateQualitySS(Quality quality) {
        Quality quality1 = qualityDao.getQualityByID(quality.getId());
        if (quality1.getStorageStatus().equals("未入库")){
            quality1.setStorageStatus("已入库");
        }else {
            quality1.setStorageStatus("未入库");
        }
        return qualityDao.updateQualitySS(quality1);
    }

    @Override
    public int updateQualityTime(Quality quality) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
        quality.setTime(format);
        return qualityDao.updateQualityTime(quality);
    }

    @Override
    public int delQuality(int id) {
        return qualityDao.delQuality(id);
    }
}
