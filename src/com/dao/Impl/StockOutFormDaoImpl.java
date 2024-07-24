package com.dao.Impl;

import com.dao.StockOutFormDao;
import com.pojo.NormalStockOut;
import com.pojo.StockInForm;
import com.pojo.StockInWithQuality;
import com.pojo.StockOutForm;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
                stockOutForm.setOutNum(resultSet.getString(2));
                stockOutForm.setTableCoding(resultSet.getInt(3));
                stockOutForm.setoName(resultSet.getString(4));
                stockOutForm.setStandard(resultSet.getString(5));
                stockOutForm.setManufactor(resultSet.getString(6));
                stockOutForm.setUnit(resultSet.getString(7));
                stockOutForm.setoNum(resultSet.getInt(8));
                stockOutForm.setCost(resultSet.getInt(9));
                stockOutForm.setSalePrice(resultSet.getInt(10));
                stockOutForm.setBatchNumber(resultSet.getString(11));
                stockOutForm.setProductDate(resultSet.getString(12));
                stockOutForm.setExpiration(resultSet.getString(13));
                stockOutForm.setStockOutTime(resultSet.getString(14));
                stockOutForm.setDepartment(resultSet.getString(15));
                stockOutForm.setNotes(resultSet.getString(16));
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
                stockOutForm.setOutNum(resultSet.getString(2));
                stockOutForm.setTableCoding(resultSet.getInt(3));
                stockOutForm.setoName(resultSet.getString(4));
                stockOutForm.setStandard(resultSet.getString(5));
                stockOutForm.setManufactor(resultSet.getString(6));
                stockOutForm.setUnit(resultSet.getString(7));
                stockOutForm.setoNum(resultSet.getInt(8));
                stockOutForm.setCost(resultSet.getInt(9));
                stockOutForm.setSalePrice(resultSet.getInt(10));
                stockOutForm.setBatchNumber(resultSet.getString(11));
                stockOutForm.setProductDate(resultSet.getString(12));
                stockOutForm.setExpiration(resultSet.getString(13));
                stockOutForm.setStockOutTime(resultSet.getString(14));
                stockOutForm.setDepartment(resultSet.getString(15));
                stockOutForm.setNotes(resultSet.getString(16));
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
                stockOutForm.setOutNum(resultSet.getString(2));
                stockOutForm.setTableCoding(resultSet.getInt(3));
                stockOutForm.setoName(resultSet.getString(4));
                stockOutForm.setStandard(resultSet.getString(5));
                stockOutForm.setManufactor(resultSet.getString(6));
                stockOutForm.setUnit(resultSet.getString(7));
                stockOutForm.setoNum(resultSet.getInt(8));
                stockOutForm.setCost(resultSet.getInt(9));
                stockOutForm.setSalePrice(resultSet.getInt(10));
                stockOutForm.setBatchNumber(resultSet.getString(11));
                stockOutForm.setProductDate(resultSet.getString(12));
                stockOutForm.setExpiration(resultSet.getString(13));
                stockOutForm.setStockOutTime(resultSet.getString(14));
                stockOutForm.setDepartment(resultSet.getString(15));
                stockOutForm.setNotes(resultSet.getString(16));
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
        String sql = "UPDATE StockOutForm SET outNum=?,oName=?,standard=?,manufactor=?,\n" +
                "unit=?,oNum=?,cost=?,salePrice=?,batchNumber=?,\n" +
                "productDate=?,expiration=?,stockOutTime=?,department=?" +
                "notes=? WHERE outId = ?;";
        Object[] objects = new Object[15];
        objects[0] = stockOutForm.getOutNum();
        objects[1] = stockOutForm.getoName();
        objects[2] = stockOutForm.getStandard();
        objects[3] = stockOutForm.getManufactor();
        objects[4] = stockOutForm.getUnit();
        objects[5] = stockOutForm.getoNum();
        objects[6] = stockOutForm.getCost();
        objects[7] = stockOutForm.getSalePrice();
        objects[8] = stockOutForm.getBatchNumber();
        objects[9] = stockOutForm.getProductDate();
        objects[10] = stockOutForm.getExpiration();
        objects[11] = stockOutForm.getStockOutTime();
        objects[12] = stockOutForm.getDepartment();
        objects[13] = stockOutForm.getNotes();
        objects[14] = stockOutForm.getOutId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public List<NormalStockOut> getNormalStockOut(int page, int limit) {
        String sql = "SELECT p.pid, p.NAME, d.mName,d.`defined`,\n" +
                "m.`number`,m.status,m.`getmTime`\n" +
                "FROM `patient` AS p\n" +
                "LEFT JOIN `medicineorder` AS m \n" +
                "ON p.mid = m.orderId\n" +
                "LEFT JOIN `dictionary` AS d \n" +
                "ON m.mid = d.mid\n" +
                "WHERE m.status = '已取药' LIMIT ?,?;";
        Object[] objects = new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<NormalStockOut> normalStockOutList = new ArrayList<NormalStockOut>();
        try {
            while (resultSet.next()){
                NormalStockOut normalStockOut = new NormalStockOut();
                normalStockOut.setPid(resultSet.getInt(1));
                normalStockOut.setName(resultSet.getString(2));
                normalStockOut.setmName(resultSet.getString(3));
                normalStockOut.setDefined(resultSet.getString(4));
                normalStockOut.setNumber(resultSet.getInt(5));
                normalStockOut.setStatus(resultSet.getString(6));
                normalStockOut.setGetmTime(resultSet.getString(7));
                normalStockOutList.add(normalStockOut);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return normalStockOutList;
    }

    @Override
    public List<NormalStockOut> getNormalStockOut() {
        String sql = "SELECT p.pid, p.NAME, d.mName,d.`defined`,\n" +
                "m.`number`,m.status,m.`getmTime`\n" +
                "FROM `patient` AS p\n" +
                "LEFT JOIN `medicineorder` AS m \n" +
                "ON p.mid = m.orderId\n" +
                "LEFT JOIN `dictionary` AS d \n" +
                "ON m.mid = d.mid\n" +
                "WHERE m.status = '已取药';";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<NormalStockOut> normalStockOutList = new ArrayList<NormalStockOut>();
        try {
            while (resultSet.next()){
                NormalStockOut normalStockOut = new NormalStockOut();
                normalStockOut.setPid(resultSet.getInt(1));
                normalStockOut.setName(resultSet.getString(2));
                normalStockOut.setmName(resultSet.getString(3));
                normalStockOut.setDefined(resultSet.getString(4));
                normalStockOut.setNumber(resultSet.getInt(5));
                normalStockOut.setStatus(resultSet.getString(6));
                normalStockOut.setGetmTime(resultSet.getString(7));
                normalStockOutList.add(normalStockOut);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return normalStockOutList;
    }

    @Override
    public List<StockOutForm> getStockOutFormByQuery(String sql) {
        ResultSet resultSet = JDBC.select(sql, new Objects[1]);
        List<StockOutForm> stockOutFormList = new ArrayList<StockOutForm>();
        try {
            while (resultSet.next()){
                StockOutForm stockOutForm = new StockOutForm();
                stockOutForm.setOutId(resultSet.getInt(1));
                stockOutForm.setOutNum(resultSet.getString(2));
                stockOutForm.setTableCoding(resultSet.getInt(3));
                stockOutForm.setoName(resultSet.getString(4));
                stockOutForm.setStandard(resultSet.getString(5));
                stockOutForm.setManufactor(resultSet.getString(6));
                stockOutForm.setUnit(resultSet.getString(7));
                stockOutForm.setoNum(resultSet.getInt(8));
                stockOutForm.setCost(resultSet.getInt(9));
                stockOutForm.setSalePrice(resultSet.getInt(10));
                stockOutForm.setBatchNumber(resultSet.getString(11));
                stockOutForm.setProductDate(resultSet.getString(12));
                stockOutForm.setExpiration(resultSet.getString(13));
                stockOutForm.setStockOutTime(resultSet.getString(14));
                stockOutForm.setDepartment(resultSet.getString(15));
                stockOutForm.setNotes(resultSet.getString(16));
                stockOutFormList.add(stockOutForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockOutFormList;
    }

//    @Override
//    public int addStockOutForm(StockOutForm stockOutForm) {
//        String sql = "INSERT INTO StockOutForm (outStatus,oDate,oManufactor,oType,oNum,oSalePrice,oAmount,oCost,operator,auditor,auditTime,department) \n" +
//                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);\n";
//        Object[] objects = new Object[12];
//        objects[0] = stockOutForm.getOutStatus();
//        objects[1] = stockOutForm.getoDate();
//        objects[2] = stockOutForm.getoManufactor();
//        objects[3] = stockOutForm.getoType();
//        objects[4] = stockOutForm.getoNum();
//        objects[5] = stockOutForm.getoSalePrice();
//        objects[6] = stockOutForm.getoAmount();
//        objects[7] = stockOutForm.getoCost();
//        objects[8] = stockOutForm.getOperator();
//        objects[9] = stockOutForm.getAuditor();
//        objects[10] = stockOutForm.getAuditTime();
//        objects[11] = stockOutForm.getDepartment();
//        int count= JDBC.update(sql,objects);
//        return count;
//    }
}
