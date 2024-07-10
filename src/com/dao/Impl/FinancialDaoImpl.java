package com.dao.Impl;

import com.dao.FinancialDao;
import com.pojo.Apply;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinancialDaoImpl implements FinancialDao {
    @Override
    public List<Apply> getPurchaseList(String sql) {
        sql += " and applyId > ?";
        Object[] obj = new Object[1];
        obj[0] = 0;
        ResultSet resultSet = JDBC.select(sql, obj);
        List<Apply> list = new ArrayList<>();
        try{
            while (resultSet.next()) {
                Apply apply1 = new Apply();
                apply1.setApplyId(resultSet.getInt(1));
                apply1.setmId(resultSet.getInt(2));
                apply1.setmName(resultSet.getString(3));
                apply1.setSpecification(resultSet.getString(4));
                apply1.setManufactor(resultSet.getString(5));
                apply1.setUnit(resultSet.getString(6));
                apply1.setDepartment(resultSet.getString(7));
                apply1.setNumber(resultSet.getInt(8));
                apply1.setApplyNumber(resultSet.getInt(9));
                apply1.setPurchasePrice(resultSet.getDouble(10));
                apply1.setCode(resultSet.getString(11));
                apply1.setmType(resultSet.getString(12));
                apply1.setSupplier(resultSet.getString(13));
                apply1.setApprovalNumber(resultSet.getString(14));
                apply1.setPlaceOrigin(resultSet.getString(15));
                apply1.setApplyUser(resultSet.getString(16));
                apply1.setApplyTime(resultSet.getString(17));
                apply1.setPharmacist(resultSet.getString(18));
                apply1.setPharmacistApprove(resultSet.getString(19));
                apply1.setPharmacistTime(resultSet.getString(20));
                apply1.setFinance(resultSet.getString(21));
                apply1.setFinanceApprove(resultSet.getString(22));
                apply1.setFinanceTime(resultSet.getString(23));
                apply1.setTableCoding(resultSet.getInt(24));
                list.add(apply1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delApply(int id) {
        String sql = "delete from apply where applyId=?";
        Object[] obj = new Object[1];
        obj[0] = id;
        int update = JDBC.update(sql, obj);
        return update;
    }

    //财务审核
    @Override
    public int setApply(Apply apply) {
        String sql = "UPDATE apply\n" +
                "SET financeApprove = '已审阅通过',financeTime = ?,finance=?\n" +
                "WHERE applyId = ?;";
        Object[] obj = new Object[3];
        obj[0] = apply.getFinanceTime();
        obj[1] = apply.getApplyUser();
        obj[2] = apply.getApplyId();
        int update = JDBC.update(sql, obj);
        return update;
    }

    //财务反审核
    @Override
    public int setUnApprove(Apply apply) {
        String sql = "UPDATE apply\n" +
                "SET financeApprove = '已审阅未通过',financeTime = ?,finance=?\n" +
                "WHERE applyId = ?;";
        Object[] obj = new Object[3];
        obj[0] = apply.getFinanceTime();
        obj[1] = apply.getApplyUser();
        obj[2] = apply.getApplyId();
        int update = JDBC.update(sql, obj);
        return update;
    }
}
