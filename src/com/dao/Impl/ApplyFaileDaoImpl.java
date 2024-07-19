package com.dao.Impl;

import com.dao.ApplyFailedDao;
import com.dao.Impl.init.InitDaoImpl;
import com.pojo.ApplyFailed;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ApplyFaileDaoImpl implements ApplyFailedDao {
    @Override
    public int addFailed(ApplyFailed applyFailed) {
        String sql = "INSERT INTO `applyfailed`\n" +
                "(`tableCoding`,`mId`,`mName`,`specification`,\n" +
                "`manufactor`,`number`,`purchasePrice`,`code`,\n" +
                "`mType`,`supplier`,`approvalNumber`,`placeOrigin`,\n" +
                "`applyUser`,`applyTime`,`pharmacist`,\n" +
                "`pharmacistTime`,`cause`)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] objects = new Object[]{applyFailed.getTableCoding(),applyFailed.getmId(),
                applyFailed.getmName(),applyFailed.getSpecification(),
                applyFailed.getManufactor(),applyFailed.getNumber(),
                applyFailed.getPurchasePrice(),applyFailed.getCode(),
                applyFailed.getmType(),applyFailed.getSupplier(),
                applyFailed.getApprovalNumber(),applyFailed.getPlaceOrigin(),
                applyFailed.getApplyUser(), applyFailed.getApplyTime(),
                applyFailed.getPharmacist(),
                applyFailed.getPharmacistTime(), applyFailed.getCause()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int getAll() {
        String sql = "SELECT `applyId` FROM `applyfailed`";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        int i = 0;
        try {
            while (resultSet.next()){
                i++;
            }
        }catch (Exception e){

        }
        return i;
    }

    @Override
    public List<ApplyFailed> getAll(int page, int limit) {
        String sql = "SELECT * FROM `applyfailed` LIMIT ?,?";
        Object[] objects = new Object[]{page,limit};
        ResultSet resultSet = JDBC.select(sql, objects);
        List<ApplyFailed> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                ApplyFailed applyFailed = new ApplyFailed();
                applyFailed.setApplyId(resultSet.getInt(1));
                applyFailed.setTableCoding(resultSet.getInt(2));
                applyFailed.setmId(resultSet.getInt(3));
                applyFailed.setmName(resultSet.getString(4));
                applyFailed.setSpecification(resultSet.getString(5));
                applyFailed.setManufactor(resultSet.getString(6));
                applyFailed.setNumber(resultSet.getInt(7));
                applyFailed.setPurchasePrice(resultSet.getInt(8));
                applyFailed.setCode(resultSet.getString(9));
                applyFailed.setmType(resultSet.getString(10));
                applyFailed.setSupplier(resultSet.getString(11));
                applyFailed.setApprovalNumber(resultSet.getString(12));
                applyFailed.setPlaceOrigin(resultSet.getString(13));
                applyFailed.setApplyUser(resultSet.getString(14));
                applyFailed.setApplyTime(resultSet.getString(15));
                applyFailed.setPharmacist(resultSet.getString(16));
                applyFailed.setPharmacistApprove(resultSet.getString(17));
                applyFailed.setPharmacistTime(resultSet.getString(18));
                applyFailed.setCause(resultSet.getString(19));
                list.add(applyFailed);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public List<ApplyFailed> getAll(int page, int limit, String title, String sort) {
        String sql = "SELECT * FROM `applyfailed` ORDER BY "+title+" "+sort+" LIMIT ?,? ";
        Object[] objects = new Object[]{page,limit};
        ResultSet resultSet = JDBC.select(sql, objects);
        List<ApplyFailed> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                ApplyFailed applyFailed = new ApplyFailed();
                applyFailed.setApplyId(resultSet.getInt(1));
                applyFailed.setTableCoding(resultSet.getInt(2));
                applyFailed.setmId(resultSet.getInt(3));
                applyFailed.setmName(resultSet.getString(4));
                applyFailed.setSpecification(resultSet.getString(5));
                applyFailed.setManufactor(resultSet.getString(6));
                applyFailed.setNumber(resultSet.getInt(7));
                applyFailed.setPurchasePrice(resultSet.getInt(8));
                applyFailed.setCode(resultSet.getString(9));
                applyFailed.setmType(resultSet.getString(10));
                applyFailed.setSupplier(resultSet.getString(11));
                applyFailed.setApprovalNumber(resultSet.getString(12));
                applyFailed.setPlaceOrigin(resultSet.getString(13));
                applyFailed.setApplyUser(resultSet.getString(14));
                applyFailed.setApplyTime(resultSet.getString(15));
                applyFailed.setPharmacist(resultSet.getString(16));
                applyFailed.setPharmacistApprove(resultSet.getString(17));
                applyFailed.setPharmacistTime(resultSet.getString(18));
                applyFailed.setCause(resultSet.getString(19));
                list.add(applyFailed);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public ApplyFailed getApplyFailedByAId(int applyId) {
        String sql = "SELECT * FROM `applyfailed` WHERE `applyId` = ?";
        Object[] objects = new Object[]{applyId};
        ResultSet resultSet = JDBC.select(sql, objects);
        ApplyFailed applyFailed = new ApplyFailed();
        try {
            while (resultSet.next()){
                applyFailed.setApplyId(resultSet.getInt(1));
                applyFailed.setTableCoding(resultSet.getInt(2));
                applyFailed.setmId(resultSet.getInt(3));
                applyFailed.setmName(resultSet.getString(4));
                applyFailed.setSpecification(resultSet.getString(5));
                applyFailed.setManufactor(resultSet.getString(6));
                applyFailed.setNumber(resultSet.getInt(7));
                applyFailed.setPurchasePrice(resultSet.getInt(8));
                applyFailed.setCode(resultSet.getString(9));
                applyFailed.setmType(resultSet.getString(10));
                applyFailed.setSupplier(resultSet.getString(11));
                applyFailed.setApprovalNumber(resultSet.getString(12));
                applyFailed.setPlaceOrigin(resultSet.getString(13));
                applyFailed.setApplyUser(resultSet.getString(14));
                applyFailed.setApplyTime(resultSet.getString(15));
                applyFailed.setPharmacist(resultSet.getString(16));
                applyFailed.setPharmacistApprove(resultSet.getString(17));
                applyFailed.setPharmacistTime(resultSet.getString(18));
                applyFailed.setCause(resultSet.getString(19));
            }
        }catch (Exception e){

        }
        return applyFailed;
    }

    @Override
    public List<ApplyFailed> getApplyFailedByMName(String name) {
        String sql = "SELECT * FROM `applyfailed` WHERE `mName` like ?";
        Object[] objects = new Object[]{"%"+name+"%"};
        ResultSet resultSet = JDBC.select(sql, objects);
        List<ApplyFailed> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                ApplyFailed applyFailed = new ApplyFailed();
                applyFailed.setApplyId(resultSet.getInt(1));
                applyFailed.setTableCoding(resultSet.getInt(2));
                applyFailed.setmId(resultSet.getInt(3));
                applyFailed.setmName(resultSet.getString(4));
                applyFailed.setSpecification(resultSet.getString(5));
                applyFailed.setManufactor(resultSet.getString(6));
                applyFailed.setNumber(resultSet.getInt(7));
                applyFailed.setPurchasePrice(resultSet.getInt(8));
                applyFailed.setCode(resultSet.getString(9));
                applyFailed.setmType(resultSet.getString(10));
                applyFailed.setSupplier(resultSet.getString(11));
                applyFailed.setApprovalNumber(resultSet.getString(12));
                applyFailed.setPlaceOrigin(resultSet.getString(13));
                applyFailed.setApplyUser(resultSet.getString(14));
                applyFailed.setApplyTime(resultSet.getString(15));
                applyFailed.setPharmacist(resultSet.getString(16));
                applyFailed.setPharmacistApprove(resultSet.getString(17));
                applyFailed.setPharmacistTime(resultSet.getString(18));
                applyFailed.setCause(resultSet.getString(19));
                list.add(applyFailed);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public List<String> getMType() {
        String sql = "SELECT DISTINCT `mType` FROM `applyfailed`";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<String> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                String mType = resultSet.getString(10);
                list.add(mType);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public List<ApplyFailed> getApplyFailedByMType(String mType) {
        String sql = "SELECT * FROM `applyfailed` WHERE `mType` = ?";
        Object[] objects = new Object[]{mType};
        ResultSet resultSet = JDBC.select(sql, objects);
        List<ApplyFailed> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                ApplyFailed applyFailed = new ApplyFailed();
                applyFailed.setApplyId(resultSet.getInt(1));
                applyFailed.setTableCoding(resultSet.getInt(2));
                applyFailed.setmId(resultSet.getInt(3));
                applyFailed.setmName(resultSet.getString(4));
                applyFailed.setSpecification(resultSet.getString(5));
                applyFailed.setManufactor(resultSet.getString(6));
                applyFailed.setNumber(resultSet.getInt(7));
                applyFailed.setPurchasePrice(resultSet.getInt(8));
                applyFailed.setCode(resultSet.getString(9));
                applyFailed.setmType(resultSet.getString(10));
                applyFailed.setSupplier(resultSet.getString(11));
                applyFailed.setApprovalNumber(resultSet.getString(12));
                applyFailed.setPlaceOrigin(resultSet.getString(13));
                applyFailed.setApplyUser(resultSet.getString(14));
                applyFailed.setApplyTime(resultSet.getString(15));
                applyFailed.setPharmacist(resultSet.getString(16));
                applyFailed.setPharmacistApprove(resultSet.getString(17));
                applyFailed.setPharmacistTime(resultSet.getString(18));
                applyFailed.setCause(resultSet.getString(19));
                list.add(applyFailed);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public List<String> getAllManufactor() {
        String sql = "SELECT DISTINCT `manufactor` FROM `applyfailed`";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<String> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                String manufactor = resultSet.getString(10);
                list.add(manufactor);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public List<ApplyFailed> getApplyFailedByManufactor(String manufactor) {
        String sql = "SELECT * FROM `applyfailed` WHERE `manufactor` = ?";
        Object[] objects = new Object[]{manufactor};
        ResultSet resultSet = JDBC.select(sql, objects);
        List<ApplyFailed> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                ApplyFailed applyFailed = new ApplyFailed();
                applyFailed.setApplyId(resultSet.getInt(1));
                applyFailed.setTableCoding(resultSet.getInt(2));
                applyFailed.setmId(resultSet.getInt(3));
                applyFailed.setmName(resultSet.getString(4));
                applyFailed.setSpecification(resultSet.getString(5));
                applyFailed.setManufactor(resultSet.getString(6));
                applyFailed.setNumber(resultSet.getInt(7));
                applyFailed.setPurchasePrice(resultSet.getInt(8));
                applyFailed.setCode(resultSet.getString(9));
                applyFailed.setmType(resultSet.getString(10));
                applyFailed.setSupplier(resultSet.getString(11));
                applyFailed.setApprovalNumber(resultSet.getString(12));
                applyFailed.setPlaceOrigin(resultSet.getString(13));
                applyFailed.setApplyUser(resultSet.getString(14));
                applyFailed.setApplyTime(resultSet.getString(15));
                applyFailed.setPharmacist(resultSet.getString(16));
                applyFailed.setPharmacistApprove(resultSet.getString(17));
                applyFailed.setPharmacistTime(resultSet.getString(18));
                applyFailed.setCause(resultSet.getString(19));
                list.add(applyFailed);
            }
        }catch (Exception e){

        }
        return list;
    }

    @Override
    public int delApplyFailed(int applyId) {
        InitDaoImpl initDao = new InitDaoImpl();
        boolean b = initDao.delOne(applyId, "applyId", "applyfailed");
        if (b){
            return 1;
        }
        return 0;
    }

    @Override
    public int updateAppFailed(ApplyFailed applyFailed) {
        String sql = "UPDATE `applyfailed` SET `pharmacist`=?,`pharmacistApprove`='已审阅通过',`pharmacistTime`=? WHERE `applyId`=?";
        Object[] objects = new Object[]{applyFailed.getPharmacist(),applyFailed.getPharmacistTime(),applyFailed.getApplyId()};
        int i = JDBC.update(sql, objects);
        return i;
    }

    @Override
    public int updateCause(String cause,int applyId) {
        String sql = "UPDATE `applyfailed` SET `cause`=? WHERE `applyId`=?";
        Object[] objects = new Object[]{cause,applyId};
        int i = JDBC.update(sql, objects);
        return i;
    }

    public int addCause(int applyId,String date,String cause){
        String sql = "INSERT INTO `cause` (`id`,`time`,`cause`) VALUES (?,?,?)";
        Object[] objects = new Object[]{applyId,date,cause};
        int i = JDBC.update(sql, objects);
        return i;
    }
    public int delCause(int applyId){
        String sql = "delete from cause where id = ?";
        Object[] objects = new Object[]{applyId};
        int i = JDBC.update(sql, objects);
        return i;
    }
    public List<ApplyFailed> getCause(int applyId){
        String sql = "SELECT * FROM `cause` where id = ?";
        Object[] objects = new Object[]{applyId};
        ResultSet resultSet = JDBC.select(sql, objects);
        List<ApplyFailed> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                ApplyFailed applyFailed = new ApplyFailed();
                applyFailed.setApplyId(resultSet.getInt(1));
                applyFailed.setApplyTime(resultSet.getString(2));
                applyFailed.setCause(resultSet.getString(3));
                list.add(applyFailed);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public int getLastApplyId(){
        String sql = "SELECT applyId FROM `applyfailed` \n" +
                "ORDER BY `applyId`  DESC\n" +
                "LIMIT 1";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<ApplyFailed> list = new ArrayList<>();
        int applyId = 0;
        try {
            while (resultSet.next()){
                applyId = resultSet.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return applyId;
    }
}
