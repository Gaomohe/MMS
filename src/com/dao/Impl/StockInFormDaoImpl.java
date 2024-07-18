package com.dao.Impl;

import com.dao.StockInFormDao;
import com.pojo.Orders;
import com.pojo.StockInForm;
import com.pojo.StockInWithQuality;
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
                stockInForm.setTableCoding(resultSet.getInt(3));
                stockInForm.setrName(resultSet.getString(4));
                stockInForm.setStandard(resultSet.getString(5));
                stockInForm.setManufactor(resultSet.getString(6));
                stockInForm.setUnit(resultSet.getString(7));
                stockInForm.setrNum(resultSet.getInt(8));
                stockInForm.setCost(resultSet.getInt(9));
                stockInForm.setSalePrice(resultSet.getInt(10));
                stockInForm.setBatchNumber(resultSet.getString(11));
                stockInForm.setProductDate(resultSet.getString(12));
                stockInForm.setExpiration(resultSet.getString(13));
                stockInForm.setStockInTime(resultSet.getString(14));
                stockInForm.setDepartment(resultSet.getString(15));
                stockInForm.setNotes(resultSet.getString(16));
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
                stockInForm.setTableCoding(resultSet.getInt(3));
                stockInForm.setrName(resultSet.getString(4));
                stockInForm.setStandard(resultSet.getString(5));
                stockInForm.setManufactor(resultSet.getString(6));
                stockInForm.setUnit(resultSet.getString(7));
                stockInForm.setrNum(resultSet.getInt(8));
                stockInForm.setCost(resultSet.getInt(9));
                stockInForm.setSalePrice(resultSet.getInt(10));
                stockInForm.setBatchNumber(resultSet.getString(11));
                stockInForm.setProductDate(resultSet.getString(12));
                stockInForm.setExpiration(resultSet.getString(13));
                stockInForm.setStockInTime(resultSet.getString(14));
                stockInForm.setDepartment(resultSet.getString(15));
                stockInForm.setNotes(resultSet.getString(16));
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
                stockInForm.setTableCoding(resultSet.getInt(3));
                stockInForm.setrName(resultSet.getString(4));
                stockInForm.setStandard(resultSet.getString(5));
                stockInForm.setManufactor(resultSet.getString(6));
                stockInForm.setUnit(resultSet.getString(7));
                stockInForm.setrNum(resultSet.getInt(8));
                stockInForm.setCost(resultSet.getInt(9));
                stockInForm.setSalePrice(resultSet.getInt(10));
                stockInForm.setBatchNumber(resultSet.getString(11));
                stockInForm.setProductDate(resultSet.getString(12));
                stockInForm.setExpiration(resultSet.getString(13));
                stockInForm.setStockInTime(resultSet.getString(14));
                stockInForm.setDepartment(resultSet.getString(15));
                stockInForm.setNotes(resultSet.getString(16));
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
        String sql = "UPDATE StockInForm SET rName=?,stockInNum=?,tableCoding=?,standard=?,manufactor=?,unit=?,\n" +
                "rNum=?,cost=?,salePrice=?,batchNumber=?,productDate=?,\n" +
                "expiration=?,stockInTime=?,department=?,notes=? WHERE rId = ?;";
        Object[] objects = new Object[16];
        objects[0] = stockInForm.getrName();
        objects[1] = stockInForm.getStockInNum();
        objects[2] = stockInForm.getTableCoding();
        objects[3] = stockInForm.getStandard();
        objects[4] = stockInForm.getManufactor();
        objects[5] = stockInForm.getUnit();
        objects[6] = stockInForm.getrNum();
        objects[7] = stockInForm.getCost();
        objects[8] = stockInForm.getSalePrice();
        objects[9] = stockInForm.getBatchNumber();
        objects[10] = stockInForm.getProductDate();
        objects[11] = stockInForm.getExpiration();
        objects[12] = stockInForm.getStockInTime();
        objects[13] = stockInForm.getDepartment();
        objects[14] = stockInForm.getNotes();
        objects[15] = stockInForm.getrId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int addStockInForm(StockInWithQuality stockInWithQuality) {
        String sql = "INSERT INTO StockInForm (rName, stockInNum, standard, manufactor, unit, rNum, cost, salePrice, batchNumber, productDate, expiration,stockInTime, department,notes) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?);\n";
        Object[] objects = new Object[14];
        objects[0] = stockInWithQuality.getrName();
        objects[1] = stockInWithQuality.getStockInNum();
        objects[2] = stockInWithQuality.getStandard();//
        objects[3] = stockInWithQuality.getManufactor();
        objects[4] = stockInWithQuality.getUnit();//
        objects[5] = stockInWithQuality.getTotlNumber();
        objects[6] = stockInWithQuality.getCost();//
        objects[7] = stockInWithQuality.getSalePrice();
        objects[8] = stockInWithQuality.getBatchNumber();
        objects[9] = stockInWithQuality.getProductDate();
        objects[10] = stockInWithQuality.getExpiration();
        objects[11] = stockInWithQuality.getStockInTime();
        objects[12] = stockInWithQuality.getDepartment();
        objects[13] = stockInWithQuality.getStorageStatus();
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
                stockInForm.setTableCoding(resultSet.getInt(3));
                stockInForm.setrName(resultSet.getString(4));
                stockInForm.setStandard(resultSet.getString(5));
                stockInForm.setManufactor(resultSet.getString(6));
                stockInForm.setUnit(resultSet.getString(7));
                stockInForm.setrNum(resultSet.getInt(8));
                stockInForm.setCost(resultSet.getInt(9));
                stockInForm.setSalePrice(resultSet.getInt(10));
                stockInForm.setBatchNumber(resultSet.getString(11));
                stockInForm.setProductDate(resultSet.getString(12));
                stockInForm.setExpiration(resultSet.getString(13));
                stockInForm.setStockInTime(resultSet.getString(14));
                stockInForm.setDepartment(resultSet.getString(15));
                stockInForm.setNotes(resultSet.getString(16));
                stockInFormList.add(stockInForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInFormList;
    }

    //下拉框获取所有药品供应商(不重复)，在orders表里获取
    @Override
    public List<Orders> getManufactorWithNoRepeat() {
        String sql="SELECT manufactor FROM orders\n" +
                "GROUP BY manufactor";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Orders> stockInFormList = new ArrayList<Orders>();
        try {
            while (resultSet.next()){
                Orders orders = new Orders();
//                orders.setoId(resultSet.getInt("oId"));
                orders.setManufactor(resultSet.getString("manufactor"));
                stockInFormList.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockInFormList;
    }

    //通过供应商和其药品名称查询“未入库”的入库单(并分页显示)
    /*连接入库单表和质量检测表查询，入库单表显示药品id，名称，供货商
      质量检测表显示待入库总数和入库状态（默认为0）
      只有当质量检测状态为1同时入库状态为0的时候我点添加才会入库成功*/
    @Override
    public List<StockInWithQuality> getStockInFormByManufactorAndDrugName(int page, int limit,String manufactor,String rName) {
        String sql="SELECT \n" +
                "    s.rid,\n" +
                "    s.rName,\n" +
                "    s.standard,\n" +
                "    s.unit,\n" +
                "    s.cost,\n" +
                "    s.salePrice,\n" +
                "    s.batchNumber,\n" +
                "    s.productDate,\n" +
                "    s.expiration,\n" +
                "    s.manufactor,\n" +
                "    s.department,\n" +
                "    q.totlNumber, \n" +
                "    q.statue,      \n" +
                "    q.storageStatus        \n" +
                "FROM stockinform AS s\n" +
                "JOIN quality AS q \n" +
                "ON s.tablecoding = q.tablecoding\n" +
                "WHERE q.statue = 1 AND q.storageStatus = 0\n" +
                "AND manufactor = ? AND rName = ?\n" +
                "AND storageStatus = '未入库' LIMIT ?,?";

        Object[] objects = new Object[4];
        objects[0]=manufactor;
        objects[1]=rName;
        objects[2]=page;
        objects[3]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<StockInWithQuality> qualityList = new ArrayList<StockInWithQuality>();
        try {
            while (resultSet.next()){
                StockInWithQuality stockInWithQuality = new StockInWithQuality();
                stockInWithQuality.setrId(resultSet.getInt(1));
                stockInWithQuality.setrName(resultSet.getString(2));
                stockInWithQuality.setStandard(resultSet.getString(3));
                stockInWithQuality.setUnit(resultSet.getString(4));
                stockInWithQuality.setCost(resultSet.getInt(5));
                stockInWithQuality.setSalePrice(resultSet.getInt(6));
                stockInWithQuality.setBatchNumber(resultSet.getString(7));
                stockInWithQuality.setProductDate(resultSet.getString(8));
                stockInWithQuality.setExpiration(resultSet.getString(9));
                stockInWithQuality.setManufactor(resultSet.getString(10));
                stockInWithQuality.setDepartment(resultSet.getString(11));
                stockInWithQuality.setTotlNumber(resultSet.getInt(12));
                stockInWithQuality.setStatue(resultSet.getInt(13));
                stockInWithQuality.setStorageStatus(resultSet.getString(14));
                qualityList.add(stockInWithQuality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return qualityList;
    }

    @Override
    public List<StockInWithQuality> getStockInFormByManufactorAndDrugName() {
        String sql="SELECT \n" +
                "    s.rid,\n" +
                "    s.rName,\n" +
                "    s.standard,\n" +
                "    s.unit,\n" +
                "    s.cost,\n" +
                "    s.salePrice,\n" +
                "    s.batchNumber,\n" +
                "    s.productDate,\n" +
                "    s.expiration,\n" +
                "    s.manufactor,\n" +
                "    s.department,\n" +
                "    q.totlNumber, \n" +
                "    q.statue,      \n" +
                "    q.storageStatus        \n" +
                "FROM stockinform AS s\n" +
                "JOIN quality AS q \n" +
                "ON s.tablecoding = q.tablecoding\n" +
                "WHERE q.statue = 1 AND q.storageStatus = 0\n" +
                "AND manufactor = '江西科睿药业有限公司' AND rName = '普瑞巴林口服溶液'\n" +
                "AND storageStatus = '未入库'";

        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        List<StockInWithQuality> qualityList = new ArrayList<StockInWithQuality>();
        try {
            while (resultSet.next()){
                StockInWithQuality stockInWithQuality = new StockInWithQuality();
                stockInWithQuality.setrId(resultSet.getInt(1));
                stockInWithQuality.setrName(resultSet.getString(2));
                stockInWithQuality.setStandard(resultSet.getString(3));
                stockInWithQuality.setUnit(resultSet.getString(4));
                stockInWithQuality.setCost(resultSet.getInt(5));
                stockInWithQuality.setSalePrice(resultSet.getInt(6));
                stockInWithQuality.setBatchNumber(resultSet.getString(7));
                stockInWithQuality.setProductDate(resultSet.getString(8));
                stockInWithQuality.setExpiration(resultSet.getString(9));
                stockInWithQuality.setManufactor(resultSet.getString(10));
                stockInWithQuality.setDepartment(resultSet.getString(11));
                stockInWithQuality.setTotlNumber(resultSet.getInt(12));
                stockInWithQuality.setStatue(resultSet.getInt(13));
                stockInWithQuality.setStorageStatus(resultSet.getString(14));
                qualityList.add(stockInWithQuality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return qualityList;
    }

    @Override
    public List<StockInWithQuality> getAllStockForm(int page, int limit) {
        String sql="SELECT \n" +
                "    s.rid,\n" +
                "    s.rName,\n" +
                "    s.standard,\n" +
                "    s.unit,\n" +
                "    s.cost,\n" +
                "    s.salePrice,\n" +
                "    s.batchNumber,\n" +
                "    s.productDate,\n" +
                "    s.expiration,\n" +
                "    s.manufactor,\n" +
                "    s.department,\n" +
                "    q.totlNumber, \n" +
                "    q.statue,      \n" +
                "    q.storageStatus        \n" +
                "FROM stockinform AS s\n" +
                "JOIN quality AS q \n" +
                "ON s.tablecoding = q.tablecoding\n" +
                "WHERE q.statue = 1 AND q.storageStatus = 0 LIMIT ? , ?";
        Object[] objects = new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<StockInWithQuality> qualityList = new ArrayList<StockInWithQuality>();
        try {
            while (resultSet.next()){
                StockInWithQuality stockInWithQuality = new StockInWithQuality();
                stockInWithQuality.setrId(resultSet.getInt(1));
                stockInWithQuality.setrName(resultSet.getString(2));
                stockInWithQuality.setStandard(resultSet.getString(3));
                stockInWithQuality.setUnit(resultSet.getString(4));
                stockInWithQuality.setCost(resultSet.getInt(5));
                stockInWithQuality.setSalePrice(resultSet.getInt(6));
                stockInWithQuality.setBatchNumber(resultSet.getString(7));
                stockInWithQuality.setProductDate(resultSet.getString(8));
                stockInWithQuality.setExpiration(resultSet.getString(9));
                stockInWithQuality.setManufactor(resultSet.getString(10));
                stockInWithQuality.setDepartment(resultSet.getString(11));
                stockInWithQuality.setTotlNumber(resultSet.getInt(12));
                stockInWithQuality.setStatue(resultSet.getInt(13));
                stockInWithQuality.setStorageStatus(resultSet.getString(14));
                qualityList.add(stockInWithQuality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return qualityList;
    }

    @Override
    public List<StockInWithQuality> getAllStockForm() {
        String sql="SELECT \n" +
                "    s.rid,\n" +
                "    s.rName,\n" +
                "    s.standard,\n" +
                "    s.unit,\n" +
                "    s.cost,\n" +
                "    s.salePrice,\n" +
                "    s.batchNumber,\n" +
                "    s.productDate,\n" +
                "    s.expiration,\n" +
                "    s.manufactor,\n" +
                "    s.department,\n" +
                "    q.totlNumber, \n" +
                "    q.statue,      \n" +
                "    q.storageStatus        \n" +
                "FROM stockinform AS s\n" +
                "JOIN quality AS q \n" +
                "ON s.tablecoding = q.tablecoding\n" +
                "WHERE q.statue = 1 AND q.storageStatus = 0";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<StockInWithQuality> qualityList = new ArrayList<StockInWithQuality>();
        try {
            while (resultSet.next()){
                StockInWithQuality stockInWithQuality = new StockInWithQuality();
                stockInWithQuality.setrId(resultSet.getInt(1));
                stockInWithQuality.setrName(resultSet.getString(2));
                stockInWithQuality.setStandard(resultSet.getString(3));
                stockInWithQuality.setUnit(resultSet.getString(4));
                stockInWithQuality.setCost(resultSet.getInt(5));
                stockInWithQuality.setSalePrice(resultSet.getInt(6));
                stockInWithQuality.setBatchNumber(resultSet.getString(7));
                stockInWithQuality.setProductDate(resultSet.getString(8));
                stockInWithQuality.setExpiration(resultSet.getString(9));
                stockInWithQuality.setManufactor(resultSet.getString(10));
                stockInWithQuality.setDepartment(resultSet.getString(11));
                stockInWithQuality.setTotlNumber(resultSet.getInt(12));
                stockInWithQuality.setStatue(resultSet.getInt(13));
                stockInWithQuality.setStorageStatus(resultSet.getString(14));
                qualityList.add(stockInWithQuality);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return qualityList;
    }
}
