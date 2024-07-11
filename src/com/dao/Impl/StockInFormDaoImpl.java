package com.dao.Impl;

import com.dao.StockInFormDao;
import com.pojo.StockInForm;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StockInFormDaoImpl implements StockInFormDao {
    @Override
    public List<StockInForm> selectStockInForm() {
        String sql=" select * from StockInForm";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<StockInForm> stockInFormList = new ArrayList<StockInForm>();
        StockInForm stockInForm = new StockInForm();
        try {
            while (resultSet.next()){
                stockInForm.setrId(resultSet.getInt(1));
                stockInForm.setrName(resultSet.getString(2));
                stockInForm.setStandard(resultSet.getString(3));
                stockInForm.setManufactor(resultSet.getString(4));
                stockInForm.setUnit(resultSet.getString(5));
                stockInForm.setrNum(resultSet.getInt(6));
                stockInForm.setCost(resultSet.getInt(7));
                stockInForm.setSalePrice(resultSet.getInt(8));
                stockInForm.setBatchNumber(resultSet.getString(9));
                stockInForm.setProductDate(resultSet.getString(10));
                stockInForm.setExpiration(resultSet.getString(11));
                stockInForm.setStockInTime(resultSet.getString(12));
                stockInForm.setDepartment(resultSet.getString(13));
                stockInForm.setNotes(resultSet.getString(14));
                stockInFormList.add(stockInForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInFormList;
    }

    @Override
    public StockInForm getStockInFormById(int id) {
        String sql=" select * from StockInForm where rId=?";
        Object[] objects = new Object[1];
        objects[0]=id;
        ResultSet resultSet = JDBC.select(sql, objects);
        StockInForm stockInForm = new StockInForm();
        try {
            while (resultSet.next()){
                stockInForm.setrId(resultSet.getInt(1));
                stockInForm.setrName(resultSet.getString(2));
                stockInForm.setStandard(resultSet.getString(3));
                stockInForm.setManufactor(resultSet.getString(4));
                stockInForm.setUnit(resultSet.getString(5));
                stockInForm.setrNum(resultSet.getInt(6));
                stockInForm.setCost(resultSet.getInt(7));
                stockInForm.setSalePrice(resultSet.getInt(8));
                stockInForm.setBatchNumber(resultSet.getString(9));
                stockInForm.setProductDate(resultSet.getString(10));
                stockInForm.setExpiration(resultSet.getString(11));
                stockInForm.setStockInTime(resultSet.getString(12));
                stockInForm.setDepartment(resultSet.getString(13));
                stockInForm.setNotes(resultSet.getString(14));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInForm;
    }

    @Override
    public List<StockInForm> selectStockInForm(int page, int limit) {
        String sql=" select * from StockInForm limit ?,?";
        Object[] objects= new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<StockInForm> list = new ArrayList<StockInForm>();
        try {
            while (resultSet.next()){
                StockInForm stockInForm = new StockInForm();
                stockInForm.setrId(resultSet.getInt(1));
                stockInForm.setrName(resultSet.getString(2));
                stockInForm.setStandard(resultSet.getString(3));
                stockInForm.setManufactor(resultSet.getString(4));
                stockInForm.setUnit(resultSet.getString(5));
                stockInForm.setrNum(resultSet.getInt(6));
                stockInForm.setCost(resultSet.getInt(7));
                stockInForm.setSalePrice(resultSet.getInt(8));
                stockInForm.setBatchNumber(resultSet.getString(9));
                stockInForm.setProductDate(resultSet.getString(10));
                stockInForm.setExpiration(resultSet.getString(11));
                stockInForm.setStockInTime(resultSet.getString(12));
                stockInForm.setDepartment(resultSet.getString(13));
                stockInForm.setNotes(resultSet.getString(14));
                list.add(stockInForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delStockInForm(int id) {
        String sql=" delete from StockInForm where rId=?";
        Object[] objects= new Object[1];
        objects[0]=id;
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int updateStockInForm(StockInForm stockInForm) {
        String sql = "UPDATE StockInForm SET rName=?,standard=?,manufactor=?,unit=?,\n" +
                "rNum=?,cost=?,salePrice=?,batchNumber=?,productDate=?,\n" +
                "expiration=?,stockInTime=?,department=?,notes=? WHERE rId = ?;";
        Object[] objects = new Object[14];
        objects[0] = stockInForm.getrName();
        objects[1] = stockInForm.getStandard();
        objects[2] = stockInForm.getManufactor();
        objects[3] = stockInForm.getUnit();
        objects[4] = stockInForm.getrNum();
        objects[5] = stockInForm.getCost();
        objects[6] = stockInForm.getSalePrice();
        objects[7] = stockInForm.getBatchNumber();
        objects[8] = stockInForm.getProductDate();
        objects[9] = stockInForm.getExpiration();
        objects[10] = stockInForm.getStockInTime();
        objects[11] = stockInForm.getDepartment();
        objects[12] = stockInForm.getNotes();
        objects[13] = stockInForm.getrId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int addStockInForm(StockInForm stockInForm) {
        String sql = "INSERT INTO StockInForm (rName,standard,manufactor,unit,rNum,cost,salePrice,batchNumber,productDate,expiration,stockInTime,department,notes) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);\n";
        Object[] objects = new Object[13];
        objects[0] = stockInForm.getrName();
        objects[1] = stockInForm.getStandard();
        objects[2] = stockInForm.getManufactor();
        objects[3] = stockInForm.getUnit();
        objects[4] = stockInForm.getrNum();
        objects[5] = stockInForm.getCost();
        objects[6] = stockInForm.getSalePrice();
        objects[7] = stockInForm.getBatchNumber();
        objects[8] = stockInForm.getProductDate();
        objects[9] = stockInForm.getExpiration();
        objects[10] = stockInForm.getStockInTime();
        objects[11] = stockInForm.getDepartment();
        objects[12] = stockInForm.getNotes();
        int count= JDBC.update(sql,objects);
        return count;
    }

    //根据入库单号，药品名称，入库日期区间查询
    @Override
    public List<StockInForm> getStockInFormByQuery(String sql) {
        ResultSet resultSet = JDBC.select(sql, new Objects[1]);
        List<StockInForm> stockInFormList = new ArrayList<StockInForm>();
        try {
            while (resultSet.next()){
                StockInForm stockInForm = new StockInForm();
                stockInForm.setrId(resultSet.getInt(1));
                stockInForm.setrName(resultSet.getString(2));
                stockInForm.setStandard(resultSet.getString(3));
                stockInForm.setManufactor(resultSet.getString(4));
                stockInForm.setUnit(resultSet.getString(5));
                stockInForm.setrNum(resultSet.getInt(6));
                stockInForm.setCost(resultSet.getInt(7));
                stockInForm.setSalePrice(resultSet.getInt(8));
                stockInForm.setBatchNumber(resultSet.getString(9));
                stockInForm.setProductDate(resultSet.getString(10));
                stockInForm.setExpiration(resultSet.getString(11));
                stockInForm.setStockInTime(resultSet.getString(12));
                stockInForm.setDepartment(resultSet.getString(13));
                stockInForm.setNotes(resultSet.getString(14));
                stockInFormList.add(stockInForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInFormList;
    }
}
