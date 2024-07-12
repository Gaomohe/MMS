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
        try {
            while (resultSet.next()){
                StockInForm stockInForm = new StockInForm();
                stockInForm.setrId(resultSet.getInt(1));
                stockInForm.setStockInNum(resultSet.getString(2));
                stockInForm.setrName(resultSet.getString(3));
                stockInForm.setStandard(resultSet.getString(4));
                stockInForm.setManufactor(resultSet.getString(5));
                stockInForm.setUnit(resultSet.getString(6));
                stockInForm.setrNum(resultSet.getInt(7));
                stockInForm.setCost(resultSet.getInt(8));
                stockInForm.setSalePrice(resultSet.getInt(9));
                stockInForm.setBatchNumber(resultSet.getString(10));
                stockInForm.setProductDate(resultSet.getString(11));
                stockInForm.setExpiration(resultSet.getString(12));
                stockInForm.setStockInTime(resultSet.getString(13));
                stockInForm.setDepartment(resultSet.getString(14));
                stockInForm.setNotes(resultSet.getString(15));
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
                stockInForm.setStockInNum(resultSet.getString(2));
                stockInForm.setrName(resultSet.getString(3));
                stockInForm.setStandard(resultSet.getString(4));
                stockInForm.setManufactor(resultSet.getString(5));
                stockInForm.setUnit(resultSet.getString(6));
                stockInForm.setrNum(resultSet.getInt(7));
                stockInForm.setCost(resultSet.getInt(8));
                stockInForm.setSalePrice(resultSet.getInt(9));
                stockInForm.setBatchNumber(resultSet.getString(10));
                stockInForm.setProductDate(resultSet.getString(11));
                stockInForm.setExpiration(resultSet.getString(12));
                stockInForm.setStockInTime(resultSet.getString(13));
                stockInForm.setDepartment(resultSet.getString(14));
                stockInForm.setNotes(resultSet.getString(15));
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
                stockInForm.setStockInNum(resultSet.getString(2));
                stockInForm.setrName(resultSet.getString(3));
                stockInForm.setStandard(resultSet.getString(4));
                stockInForm.setManufactor(resultSet.getString(5));
                stockInForm.setUnit(resultSet.getString(6));
                stockInForm.setrNum(resultSet.getInt(7));
                stockInForm.setCost(resultSet.getInt(8));
                stockInForm.setSalePrice(resultSet.getInt(9));
                stockInForm.setBatchNumber(resultSet.getString(10));
                stockInForm.setProductDate(resultSet.getString(11));
                stockInForm.setExpiration(resultSet.getString(12));
                stockInForm.setStockInTime(resultSet.getString(13));
                stockInForm.setDepartment(resultSet.getString(14));
                stockInForm.setNotes(resultSet.getString(15));
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
        String sql = "UPDATE StockInForm SET rName=?,stockInNum=?,standard=?,manufactor=?,unit=?,\n" +
                "rNum=?,cost=?,salePrice=?,batchNumber=?,productDate=?,\n" +
                "expiration=?,stockInTime=?,department=?,notes=? WHERE rId = ?;";
        Object[] objects = new Object[15];
        objects[0] = stockInForm.getrName();
        objects[1] = stockInForm.getStockInNum();
        objects[2] = stockInForm.getStandard();
        objects[3] = stockInForm.getManufactor();
        objects[4] = stockInForm.getUnit();
        objects[5] = stockInForm.getrNum();
        objects[6] = stockInForm.getCost();
        objects[7] = stockInForm.getSalePrice();
        objects[8] = stockInForm.getBatchNumber();
        objects[9] = stockInForm.getProductDate();
        objects[10] = stockInForm.getExpiration();
        objects[11] = stockInForm.getStockInTime();
        objects[12] = stockInForm.getDepartment();
        objects[13] = stockInForm.getNotes();
        objects[14] = stockInForm.getrId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int addStockInForm(StockInForm stockInForm) {
        String sql = "INSERT INTO StockInForm (rName,stockInNum,standard,manufactor,unit,rNum,cost,salePrice,batchNumber,productDate,expiration,stockInTime,department,notes) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?);\n";
        Object[] objects = new Object[14];
        objects[0] = stockInForm.getrName();
        objects[1] = stockInForm.getStockInNum();
        objects[2] = stockInForm.getStandard();
        objects[3] = stockInForm.getManufactor();
        objects[4] = stockInForm.getUnit();
        objects[5] = stockInForm.getrNum();
        objects[6] = stockInForm.getCost();
        objects[7] = stockInForm.getSalePrice();
        objects[8] = stockInForm.getBatchNumber();
        objects[9] = stockInForm.getProductDate();
        objects[10] = stockInForm.getExpiration();
        objects[11] = stockInForm.getStockInTime();
        objects[12] = stockInForm.getDepartment();
        objects[13] = stockInForm.getNotes();
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
                stockInForm.setStockInNum(resultSet.getString(2));
                stockInForm.setrName(resultSet.getString(3));
                stockInForm.setStandard(resultSet.getString(4));
                stockInForm.setManufactor(resultSet.getString(5));
                stockInForm.setUnit(resultSet.getString(6));
                stockInForm.setrNum(resultSet.getInt(7));
                stockInForm.setCost(resultSet.getInt(8));
                stockInForm.setSalePrice(resultSet.getInt(9));
                stockInForm.setBatchNumber(resultSet.getString(10));
                stockInForm.setProductDate(resultSet.getString(11));
                stockInForm.setExpiration(resultSet.getString(12));
                stockInForm.setStockInTime(resultSet.getString(13));
                stockInForm.setDepartment(resultSet.getString(14));
                stockInForm.setNotes(resultSet.getString(15));
                stockInFormList.add(stockInForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInFormList;
    }

    //下拉框获取所有药品供应商(不重复)
    @Override
    public List<StockInForm> getManufactorWithNoRepeat() {
        String sql="SELECT MIN(rid) AS rid, manufactor  \n" +
                "FROM stockinform  \n" +
                "GROUP BY manufactor;";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<StockInForm> stockInFormList = new ArrayList<StockInForm>();
        try {
            while (resultSet.next()){
                StockInForm stockInForm = new StockInForm();
                stockInForm.setrId(resultSet.getInt("rid"));
                stockInForm.setManufactor(resultSet.getString("manufactor"));
                stockInFormList.add(stockInForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInFormList;
    }

    //通过供应商查找对应药品(并分页显示)
    @Override
    public List<StockInForm> getDrugNameByManufactor(int page, int limit) {
        String sql="SELECT MIN(rid) AS rid, rName,manufactor\n" +
                "FROM stockinform\n" +
                "GROUP BY rid LIMIT ?,?";
        Object[] objects = new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<StockInForm> stockInFormList = new ArrayList<StockInForm>();
        try {
            while (resultSet.next()){
                StockInForm stockInForm = new StockInForm();
                stockInForm.setrId(resultSet.getInt("rid"));
                stockInForm.setrName(resultSet.getString("rName"));
                stockInForm.setManufactor(resultSet.getString("manufactor"));
                stockInFormList.add(stockInForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInFormList;
    }
}
