package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.QualityDao;
import com.pojo.Quality;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QualityDaoImpl implements QualityDao {
    @Override
    public int addQuality(Quality quality) {
        String sql="INSERT INTO `quality` \n" +
                "(`statue`,`tableCoding`,`mId`,`mNme`,`totlNumber`,\n" +
                "`surveyNumber`,`goodsType`,`mType`,`defind`,`drugFrom`,\n" +
                "`warehousingRemarks`,`storageStatus`,`time`,supplier,oId)\n" +
                "VALUES \n" +
                "(?,?,?,?,?,\n" +
                "?,?,?,?,?,\n" +
                "?,?,?,?,?) ";
        Object[] objects = new Object[15];
        objects[0] = quality.getStatue();
        objects[1] = quality.getTableCoding();
        objects[2] = quality.getmId();
        objects[3] = quality.getmName();
        objects[4] = quality.getTotlNumber();
        objects[5] = quality.getSurveyNumber();
        objects[6] = quality.getGoodsType();
        objects[7] = quality.getmType();
        objects[8] = quality.getDefind();
        objects[9] = quality.getDrugFrom();
        objects[10] = quality.getWarehousingRemarks();
        objects[11] = quality.getStorageStatus();
        objects[12] = quality.getTime();
        objects[13] = quality.getSupplier();
        objects[14] = quality.getOrderId();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public Quality getQualityByID(int id) {
        String sql="SELECT * FROM `quality` WHERE `id`=?;";
        Quality quality = new Quality();
        Object[] objects = new Object[]{id};
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){
                quality.setId(resultSet.getInt(1));
                quality.setStatue(resultSet.getInt(2));
                quality.setTableCoding(resultSet.getInt(3));
                quality.setmId(resultSet.getInt(4));
                quality.setmName(resultSet.getString(5));
                quality.setTotlNumber(resultSet.getInt(6));
                quality.setSurveyNumber(resultSet.getInt(7));
                quality.setGoodsType(resultSet.getString(8));
                quality.setmType(resultSet.getString(9));
                quality.setDefind(resultSet.getString(10));
                quality.setDrugFrom(resultSet.getString(11));
                quality.setWarehousingRemarks(resultSet.getString(12));
                quality.setStorageStatus(resultSet.getString(13));
                quality.setTime(resultSet.getString(14));
                quality.setSupplier(resultSet.getString(15));
                quality.setOrderId(resultSet.getInt(16));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return quality;
    }

    @Override
    public List<Quality> getQualityBySS(String storageStatus) {
        String sql="SELECT * FROM `quality` WHERE `storageStatus`=?;";
        List<Quality> list = new ArrayList<>();
        Object[] objects = new Object[]{storageStatus};
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){
                Quality quality = new Quality();
                quality.setId(resultSet.getInt(1));
                quality.setStatue(resultSet.getInt(2));
                quality.setTableCoding(resultSet.getInt(3));
                quality.setmId(resultSet.getInt(4));
                quality.setmName(resultSet.getString(5));
                quality.setTotlNumber(resultSet.getInt(6));
                quality.setSurveyNumber(resultSet.getInt(7));
                quality.setGoodsType(resultSet.getString(8));
                quality.setmType(resultSet.getString(9));
                quality.setDefind(resultSet.getString(10));
                quality.setDrugFrom(resultSet.getString(11));
                quality.setWarehousingRemarks(resultSet.getString(12));
                quality.setStorageStatus(resultSet.getString(13));
                quality.setTime(resultSet.getString(14));
                quality.setSupplier(resultSet.getString(15));
                quality.setOrderId(resultSet.getInt(16));
                list.add(quality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Quality> getQualityBySS(String storageStatus, int index, int limit) {
        String sql="SELECT * FROM `quality` WHERE `storageStatus`=?\n" +
                "LIMIT ?,?;";
        List<Quality> list = new ArrayList<>();
        Object[] objects = new Object[]{storageStatus,index,limit};
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){
                Quality quality = new Quality();
                quality.setId(resultSet.getInt(1));
                quality.setStatue(resultSet.getInt(2));
                quality.setTableCoding(resultSet.getInt(3));
                quality.setmId(resultSet.getInt(4));
                quality.setmName(resultSet.getString(5));
                quality.setTotlNumber(resultSet.getInt(6));
                quality.setSurveyNumber(resultSet.getInt(7));
                quality.setGoodsType(resultSet.getString(8));
                quality.setmType(resultSet.getString(9));
                quality.setDefind(resultSet.getString(10));
                quality.setDrugFrom(resultSet.getString(11));
                quality.setWarehousingRemarks(resultSet.getString(12));
                quality.setStorageStatus(resultSet.getString(13));
                quality.setTime(resultSet.getString(14));
                quality.setSupplier(resultSet.getString(15));
                quality.setOrderId(resultSet.getInt(16));
                list.add(quality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Quality> getQualityBySS(String storageStatus, int index, int limit, String order, String title) {
        String sql="SELECT * FROM (SELECT * FROM `quality` ORDER BY "+title+" "+order+" LIMIT ?,?) AS a \n" +
                "WHERE `storageStatus`=?";
        List<Quality> list = new ArrayList<>();
        Object[] objects = new Object[]{index,limit,storageStatus};
        ResultSet resultSet = JDBC.select(sql, objects);
        try {
            while (resultSet.next()){
                Quality quality = new Quality();
                quality.setId(resultSet.getInt(1));
                quality.setStatue(resultSet.getInt(2));
                quality.setTableCoding(resultSet.getInt(3));
                quality.setmId(resultSet.getInt(4));
                quality.setmName(resultSet.getString(5));
                quality.setTotlNumber(resultSet.getInt(6));
                quality.setSurveyNumber(resultSet.getInt(7));
                quality.setGoodsType(resultSet.getString(8));
                quality.setmType(resultSet.getString(9));
                quality.setDefind(resultSet.getString(10));
                quality.setDrugFrom(resultSet.getString(11));
                quality.setWarehousingRemarks(resultSet.getString(12));
                quality.setStorageStatus(resultSet.getString(13));
                quality.setTime(resultSet.getString(14));
                quality.setSupplier(resultSet.getString(15));
                quality.setOrderId(resultSet.getInt(16));
                list.add(quality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Quality> getQualityByTime(String sql, String time) {
        String sql1="SELECT * FROM ("+sql+") WHERE `time` like ?;";
        List<Quality> list = new ArrayList<>();
        Object[] objects = new Object[]{"%"+time+"%"};
        ResultSet resultSet = JDBC.select(sql1, objects);
        try {
            while (resultSet.next()){
                Quality quality = new Quality();
                quality.setId(resultSet.getInt(1));
                quality.setStatue(resultSet.getInt(2));
                quality.setTableCoding(resultSet.getInt(3));
                quality.setmId(resultSet.getInt(4));
                quality.setmName(resultSet.getString(5));
                quality.setTotlNumber(resultSet.getInt(6));
                quality.setSurveyNumber(resultSet.getInt(7));
                quality.setGoodsType(resultSet.getString(8));
                quality.setmType(resultSet.getString(9));
                quality.setDefind(resultSet.getString(10));
                quality.setDrugFrom(resultSet.getString(11));
                quality.setWarehousingRemarks(resultSet.getString(12));
                quality.setStorageStatus(resultSet.getString(13));
                quality.setTime(resultSet.getString(14));
                quality.setSupplier(resultSet.getString(15));
                quality.setOrderId(resultSet.getInt(16));
                list.add(quality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Quality> getQualityByName(String sql, String mName) {
        String sql1="SELECT * FROM ("+sql+") WHERE `mNme` like ?;";
        List<Quality> list = new ArrayList<>();
        Object[] objects = new Object[]{"%"+mName+"%"};
        ResultSet resultSet = JDBC.select(sql1, objects);
        try {
            while (resultSet.next()){
                Quality quality = new Quality();
                quality.setId(resultSet.getInt(1));
                quality.setStatue(resultSet.getInt(2));
                quality.setTableCoding(resultSet.getInt(3));
                quality.setmId(resultSet.getInt(4));
                quality.setmName(resultSet.getString(5));
                quality.setTotlNumber(resultSet.getInt(6));
                quality.setSurveyNumber(resultSet.getInt(7));
                quality.setGoodsType(resultSet.getString(8));
                quality.setmType(resultSet.getString(9));
                quality.setDefind(resultSet.getString(10));
                quality.setDrugFrom(resultSet.getString(11));
                quality.setWarehousingRemarks(resultSet.getString(12));
                quality.setStorageStatus(resultSet.getString(13));
                quality.setTime(resultSet.getString(14));
                quality.setSupplier(resultSet.getString(15));
                quality.setOrderId(resultSet.getInt(16));
                list.add(quality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Quality> getQualityByQuery(String sql) {
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        List<Quality> list = new ArrayList<Quality>();
        try {
            while (resultSet.next()){
                Quality quality = new Quality();
                quality.setId(resultSet.getInt(1));
                quality.setStatue(resultSet.getInt(2));
                quality.setTableCoding(resultSet.getInt(3));
                quality.setmId(resultSet.getInt(4));
                quality.setmName(resultSet.getString(5));
                quality.setTotlNumber(resultSet.getInt(6));
                quality.setSurveyNumber(resultSet.getInt(7));
                quality.setGoodsType(resultSet.getString(8));
                quality.setmType(resultSet.getString(9));
                quality.setDefind(resultSet.getString(10));
                quality.setDrugFrom(resultSet.getString(11));
                quality.setWarehousingRemarks(resultSet.getString(12));
                quality.setStorageStatus(resultSet.getString(13));
                quality.setTime(resultSet.getString(14));
                quality.setSupplier(resultSet.getString(15));
                quality.setOrderId(resultSet.getInt(16));
                list.add(quality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateQualityStatue(Quality quality) {
        String sql="UPDATE `quality` SET `statue` = ? WHERE `id` = ?";
        Object[] objects = new Object[2];
        objects[0] = quality.getStatue();
        objects[1] = quality.getId();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int updateQualitySS(Quality quality) {
        String sql="UPDATE `quality` SET `storageStatus` = ? WHERE `id` = ?";
        Object[] objects = new Object[2];
        objects[0] = quality.getStatue();
        objects[1] = quality.getId();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int updateQualityTime(Quality quality) {
        String sql="UPDATE `quality` SET `time` = ? WHERE `id` = ?";
        Object[] objects = new Object[2];
        objects[0] = quality.getTime();
        objects[1] = quality.getId();
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int delQuality(int id) {
        InitDaoImpl initDao = new InitDaoImpl();
        boolean b = initDao.delOne(id, "id", "quality");
        int i = 0;
        if (b){
            i = 1;
        }
        return i;
    }

    //获取最新的oid
    public int getOid() {
        String sql="SELECT * FROM `app_order` \n" +
                "ORDER BY `oId` DESC\n" +
                "LIMIT 1;";
        int oid = 0;
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        try {
            while (resultSet.next()){
                oid = resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return oid;
    }
}
