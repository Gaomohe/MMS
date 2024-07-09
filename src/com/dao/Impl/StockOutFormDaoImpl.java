package com.dao.Impl;

import com.dao.StockOutFormDao;
import com.pojo.StockInForm;
import com.pojo.StockOutForm;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StockOutFormDaoImpl implements StockOutFormDao {
    @Override
    public List<StockOutForm> selectStockOutForm() {
        String sql=" select * from StockOutForm";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<StockOutForm> StockOutFormList = new ArrayList<StockOutForm>();
        StockOutForm stockOutForm = new StockOutForm();
        try {
            while (resultSet.next()){
                stockOutForm.setOutId(resultSet.getInt(1));
                stockOutForm.setOutStatus(resultSet.getString(2));
                stockOutForm.setoDate(resultSet.getString(3));
                stockOutForm.setoManufactor(resultSet.getString(4));
                stockOutForm.setoType(resultSet.getString(5));
                stockOutForm.setoNum(resultSet.getInt(6));
                stockOutForm.setoSalePrice(resultSet.getInt(7));
                stockOutForm.setoAmount(resultSet.getInt(8));
                stockOutForm.setoCost(resultSet.getInt(9));
                stockOutForm.setOperator(resultSet.getString(10));
                stockOutForm.setAuditor(resultSet.getString(11));
                stockOutForm.setAuditTime(resultSet.getString(12));
                stockOutForm.setDepartment(resultSet.getString(13));
                StockOutFormList.add(stockOutForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return StockOutFormList;
    }

    @Override
    public StockOutForm getStockOutFormById(int id) {
        String sql=" select * from StockOutForm where outId=?";
        Object[] objects = new Object[1];
        objects[0]=id;
        ResultSet resultSet = JDBC.select(sql, objects);
        StockOutForm stockOutForm = new StockOutForm();
        try {
            while (resultSet.next()){
                stockOutForm.setOutId(resultSet.getInt(1));
                stockOutForm.setOutStatus(resultSet.getString(2));
                stockOutForm.setoDate(resultSet.getString(3));
                stockOutForm.setoManufactor(resultSet.getString(4));
                stockOutForm.setoType(resultSet.getString(5));
                stockOutForm.setoNum(resultSet.getInt(6));
                stockOutForm.setoSalePrice(resultSet.getInt(7));
                stockOutForm.setoAmount(resultSet.getInt(8));
                stockOutForm.setoCost(resultSet.getInt(9));
                stockOutForm.setOperator(resultSet.getString(10));
                stockOutForm.setAuditor(resultSet.getString(11));
                stockOutForm.setAuditTime(resultSet.getString(12));
                stockOutForm.setDepartment(resultSet.getString(13));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockOutForm;
    }

    @Override
    public List<StockOutForm> selectStockOutForm(int page, int limit) {
        String sql=" select * from StockOutForm limit ?,?";
        Object[] objects= new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<StockOutForm> list = new ArrayList<StockOutForm>();
        try {
            while (resultSet.next()){
                StockOutForm stockOutForm = new StockOutForm();
                stockOutForm.setOutId(resultSet.getInt(1));
                stockOutForm.setOutStatus(resultSet.getString(2));
                stockOutForm.setoDate(resultSet.getString(3));
                stockOutForm.setoManufactor(resultSet.getString(4));
                stockOutForm.setoType(resultSet.getString(5));
                stockOutForm.setoNum(resultSet.getInt(6));
                stockOutForm.setoSalePrice(resultSet.getInt(7));
                stockOutForm.setoAmount(resultSet.getInt(8));
                stockOutForm.setoCost(resultSet.getInt(9));
                stockOutForm.setOperator(resultSet.getString(10));
                stockOutForm.setAuditor(resultSet.getString(11));
                stockOutForm.setAuditTime(resultSet.getString(12));
                stockOutForm.setDepartment(resultSet.getString(13));
                list.add(stockOutForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delStockOutForm(int id) {
        String sql=" delete from StockOutForm where outId=?";
        Object[] objects= new Object[1];
        objects[0]=id;
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int updateStockOutForm(StockOutForm stockOutForm) {
        String sql = "UPDATE StockOutForm SET outStatus=?,oDate=?,oManufactor=?,oType=?,\n" +
                "oNum=?,oSalePrice=?,oAmount=?,oCost=?,operator=?,\n" +
                "auditor=?,auditTime=?,department=? WHERE outId = ?;";
        Object[] objects = new Object[13];
        objects[0] = stockOutForm.getOutStatus();
        objects[1] = stockOutForm.getoDate();
        objects[2] = stockOutForm.getoManufactor();
        objects[3] = stockOutForm.getoType();
        objects[4] = stockOutForm.getoNum();
        objects[5] = stockOutForm.getoSalePrice();
        objects[6] = stockOutForm.getoAmount();
        objects[7] = stockOutForm.getoCost();
        objects[8] = stockOutForm.getOperator();
        objects[9] = stockOutForm.getAuditor();
        objects[10] = stockOutForm.getAuditTime();
        objects[11] = stockOutForm.getDepartment();
        objects[12] = stockOutForm.getOutId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int addStockOutForm(StockOutForm stockOutForm) {
        String sql = "INSERT INTO StockOutForm (outStatus,oDate,oManufactor,oType,oNum,oSalePrice,oAmount,oCost,operator,auditor,auditTime,department) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);\n";
        Object[] objects = new Object[12];
        objects[0] = stockOutForm.getOutStatus();
        objects[1] = stockOutForm.getoDate();
        objects[2] = stockOutForm.getoManufactor();
        objects[3] = stockOutForm.getoType();
        objects[4] = stockOutForm.getoNum();
        objects[5] = stockOutForm.getoSalePrice();
        objects[6] = stockOutForm.getoAmount();
        objects[7] = stockOutForm.getoCost();
        objects[8] = stockOutForm.getOperator();
        objects[9] = stockOutForm.getAuditor();
        objects[10] = stockOutForm.getAuditTime();
        objects[11] = stockOutForm.getDepartment();
        int count= JDBC.update(sql,objects);
        return count;
    }
}
