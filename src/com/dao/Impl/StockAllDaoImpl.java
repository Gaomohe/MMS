package com.dao.Impl;

import com.dao.StockAllDao;
import com.pojo.StockAllForm;
import com.pojo.StockInForm;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StockAllDaoImpl implements StockAllDao {
    @Override
    public List<StockAllForm> selectStockAllForm() {
        String sql=" select * from dictionary";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<StockAllForm> stockAllFormList = new ArrayList<StockAllForm>();
        try {
            while (resultSet.next()){
                StockAllForm stockAllForm = new StockAllForm();
                stockAllForm.setmId(resultSet.getInt(1));
                stockAllForm.setmName(resultSet.getString(2));
                stockAllForm.setSpecification(resultSet.getString(3));
                stockAllForm.setManufactor(resultSet.getString(4));
                stockAllForm.setUnit(resultSet.getString(5));
                stockAllForm.setDepartment(resultSet.getString(6));
                stockAllForm.setPosition(resultSet.getString(7));
                stockAllForm.setNumber(resultSet.getInt(8));
                stockAllForm.setBatchNumber(resultSet.getString(9));
                stockAllForm.setUsefulLife(resultSet.getString(10));
                stockAllForm.setPurchasePrice(resultSet.getInt(11));
                stockAllForm.setSalePrice(resultSet.getInt(12));
                stockAllForm.setProductDate(resultSet.getString(13));
                stockAllForm.setProfits(resultSet.getString(14));
                stockAllForm.setCode(resultSet.getString(15));
                stockAllForm.setGoodsType(resultSet.getString(16));
                stockAllForm.setmType(resultSet.getString(17));
                stockAllForm.setDefined(resultSet.getString(18));
                stockAllForm.setSupplier(resultSet.getString(19));
                stockAllForm.setWarehousingDate(resultSet.getString(20));
                stockAllForm.setLocationDescription(resultSet.getString(21));
                stockAllForm.setSign(resultSet.getString(22));
                stockAllForm.setWarehousingRemarks(resultSet.getString(23));
                stockAllForm.setDrugFrom(resultSet.getString(24));
                stockAllForm.setHandlingInformation(resultSet.getString(25));
                stockAllForm.setApprovalNumber(resultSet.getString(26));
                stockAllForm.setLastCuringDate(resultSet.getString(27));
                stockAllForm.setTimesStorage(resultSet.getInt(28));
                stockAllForm.setDocumentNumber(resultSet.getString(29));
                stockAllForm.setPlaceOrigin(resultSet.getString(30));
                stockAllForm.setBatchsNumber(resultSet.getString(31));
                stockAllForm.setRecordNumber(resultSet.getInt(32));
                stockAllForm.setTableCoding(resultSet.getInt(33));
                stockAllFormList.add(stockAllForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockAllFormList;
    }

    @Override
    public List<StockAllForm> selectStockAllForm(int page, int limit) {
        String sql=" select * from dictionary limit ?,?";
        Object[] objects= new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<StockAllForm> list = new ArrayList<StockAllForm>();
        try {
            while (resultSet.next()){
                StockAllForm stockAllForm = new StockAllForm();
                stockAllForm.setmId(resultSet.getInt(1));
                stockAllForm.setmName(resultSet.getString(2));
                stockAllForm.setSpecification(resultSet.getString(3));
                stockAllForm.setManufactor(resultSet.getString(4));
                stockAllForm.setUnit(resultSet.getString(5));
                stockAllForm.setDepartment(resultSet.getString(6));
                stockAllForm.setPosition(resultSet.getString(7));
                stockAllForm.setNumber(resultSet.getInt(8));
                stockAllForm.setBatchNumber(resultSet.getString(9));
                stockAllForm.setUsefulLife(resultSet.getString(10));
                stockAllForm.setPurchasePrice(resultSet.getInt(11));
                stockAllForm.setSalePrice(resultSet.getInt(12));
                stockAllForm.setProductDate(resultSet.getString(13));
                stockAllForm.setProfits(resultSet.getString(14));
                stockAllForm.setCode(resultSet.getString(15));
                stockAllForm.setGoodsType(resultSet.getString(16));
                stockAllForm.setmType(resultSet.getString(17));
                stockAllForm.setDefined(resultSet.getString(18));
                stockAllForm.setSupplier(resultSet.getString(19));
                stockAllForm.setWarehousingDate(resultSet.getString(20));
                stockAllForm.setLocationDescription(resultSet.getString(21));
                stockAllForm.setSign(resultSet.getString(22));
                stockAllForm.setWarehousingRemarks(resultSet.getString(23));
                stockAllForm.setDrugFrom(resultSet.getString(24));
                stockAllForm.setHandlingInformation(resultSet.getString(25));
                stockAllForm.setApprovalNumber(resultSet.getString(26));
                stockAllForm.setLastCuringDate(resultSet.getString(27));
                stockAllForm.setTimesStorage(resultSet.getInt(28));
                stockAllForm.setDocumentNumber(resultSet.getString(29));
                stockAllForm.setPlaceOrigin(resultSet.getString(30));
                stockAllForm.setBatchsNumber(resultSet.getString(31));
                stockAllForm.setRecordNumber(resultSet.getInt(32));
                stockAllForm.setTableCoding(resultSet.getInt(33));
                list.add(stockAllForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public StockAllForm getStockAllFormById(int mid) {
        String sql=" select * from dictionary where mId=?";
        Object[]  objects= new Object[1];
        objects[0]=mid;
        ResultSet resultSet = JDBC.select(sql,objects);
        StockAllForm stockAllForm = new StockAllForm();
        try {
            while (resultSet.next()){
                stockAllForm.setmId(resultSet.getInt(1));
                stockAllForm.setmName(resultSet.getString(2));
                stockAllForm.setSpecification(resultSet.getString(3));
                stockAllForm.setManufactor(resultSet.getString(4));
                stockAllForm.setUnit(resultSet.getString(5));
                stockAllForm.setDepartment(resultSet.getString(6));
                stockAllForm.setPosition(resultSet.getString(7));
                stockAllForm.setNumber(resultSet.getInt(8));
                stockAllForm.setBatchNumber(resultSet.getString(9));
                stockAllForm.setUsefulLife(resultSet.getString(10));
                stockAllForm.setPurchasePrice(resultSet.getInt(11));
                stockAllForm.setSalePrice(resultSet.getInt(12));
                stockAllForm.setProductDate(resultSet.getString(13));
                stockAllForm.setProfits(resultSet.getString(14));
                stockAllForm.setCode(resultSet.getString(15));
                stockAllForm.setGoodsType(resultSet.getString(16));
                stockAllForm.setmType(resultSet.getString(17));
                stockAllForm.setDefined(resultSet.getString(18));
                stockAllForm.setSupplier(resultSet.getString(19));
                stockAllForm.setWarehousingDate(resultSet.getString(20));
                stockAllForm.setLocationDescription(resultSet.getString(21));
                stockAllForm.setSign(resultSet.getString(22));
                stockAllForm.setWarehousingRemarks(resultSet.getString(23));
                stockAllForm.setDrugFrom(resultSet.getString(24));
                stockAllForm.setHandlingInformation(resultSet.getString(25));
                stockAllForm.setApprovalNumber(resultSet.getString(26));
                stockAllForm.setLastCuringDate(resultSet.getString(27));
                stockAllForm.setTimesStorage(resultSet.getInt(28));
                stockAllForm.setDocumentNumber(resultSet.getString(29));
                stockAllForm.setPlaceOrigin(resultSet.getString(30));
                stockAllForm.setBatchsNumber(resultSet.getString(31));
                stockAllForm.setRecordNumber(resultSet.getInt(32));
                stockAllForm.setTableCoding(resultSet.getInt(33));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockAllForm;
    }

    @Override
    public List<StockAllForm> getStockAllFormByQuery(String sql) {
        ResultSet resultSet = JDBC.select(sql, new Objects[1]);
        List<StockAllForm> stockAllFormList = new ArrayList<StockAllForm>();
        try {
            while (resultSet.next()){
                StockAllForm stockAllForm = new StockAllForm();
                stockAllForm.setmId(resultSet.getInt(1));
                stockAllForm.setmName(resultSet.getString(2));
                stockAllForm.setSpecification(resultSet.getString(3));
                stockAllForm.setManufactor(resultSet.getString(4));
                stockAllForm.setUnit(resultSet.getString(5));
                stockAllForm.setDepartment(resultSet.getString(6));
                stockAllForm.setPosition(resultSet.getString(7));
                stockAllForm.setNumber(resultSet.getInt(8));
                stockAllForm.setBatchNumber(resultSet.getString(9));
                stockAllForm.setUsefulLife(resultSet.getString(10));
                stockAllForm.setPurchasePrice(resultSet.getInt(11));
                stockAllForm.setSalePrice(resultSet.getInt(12));
                stockAllForm.setProductDate(resultSet.getString(13));
                stockAllForm.setProfits(resultSet.getString(14));
                stockAllForm.setCode(resultSet.getString(15));
                stockAllForm.setGoodsType(resultSet.getString(16));
                stockAllForm.setmType(resultSet.getString(17));
                stockAllForm.setDefined(resultSet.getString(18));
                stockAllForm.setSupplier(resultSet.getString(19));
                stockAllForm.setWarehousingDate(resultSet.getString(20));
                stockAllForm.setLocationDescription(resultSet.getString(21));
                stockAllForm.setSign(resultSet.getString(22));
                stockAllForm.setWarehousingRemarks(resultSet.getString(23));
                stockAllForm.setDrugFrom(resultSet.getString(24));
                stockAllForm.setHandlingInformation(resultSet.getString(25));
                stockAllForm.setApprovalNumber(resultSet.getString(26));
                stockAllForm.setLastCuringDate(resultSet.getString(27));
                stockAllForm.setTimesStorage(resultSet.getInt(28));
                stockAllForm.setDocumentNumber(resultSet.getString(29));
                stockAllForm.setPlaceOrigin(resultSet.getString(30));
                stockAllForm.setBatchsNumber(resultSet.getString(31));
                stockAllForm.setRecordNumber(resultSet.getInt(32));
                stockAllForm.setTableCoding(resultSet.getInt(33));
                stockAllFormList.add(stockAllForm);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stockAllFormList;
    }

    @Override
    public int delStockAllForm(int id) {
        String sql=" delete from dictionary where mid=?";
        Object[]  objects= new Object[1];
        objects[0]=id;
        int count = JDBC.update(sql, objects);
        return count;
    }

    @Override
    public int updateStockAllForm(StockAllForm stockAllForm) {
        String sql="UPDATE dictionary SET mName = ?, specification = ?, manufactor = ?, unit = ?, department = ?, position = ?, number = ?, batchNumber = ?, usefulLife = ?, purchasePrice = ?, salePrice = ?, productDate = ?, profits = ?, code = ?, goodsType = ?, mType = ?, defined = ?, supplier = ?, warehousingDate = ?, locationDescription = ?, sign = ?, warehousingRemarks = ?, drugFrom = ?, handlingInformation = ?, approvalNumber = ?, LastCuringDate = ?, timesStorage = ?, documentNumber = ?, placeOrigin = ?, batchsNumber = ?, recordNumber = ? WHERE mId = ?;";
        Object[] objects = new Object[33];
        objects[0] = stockAllForm.getmName();
        objects[1] = stockAllForm.getSpecification();
        objects[2] = stockAllForm.getManufactor();
        objects[3] = stockAllForm.getUnit();
        objects[4] = stockAllForm.getDepartment();
        objects[5] = stockAllForm.getPosition();
        objects[6] = stockAllForm.getNumber();
        objects[7] = stockAllForm.getBatchNumber();
        objects[8] = stockAllForm.getUsefulLife();
        objects[9] = stockAllForm.getPurchasePrice();
        objects[10] = stockAllForm.getSalePrice();
        objects[11] = stockAllForm.getProductDate();
        objects[12] = stockAllForm.getProfits();
        objects[13] = stockAllForm.getCode();
        objects[14] = stockAllForm.getGoodsType();
        objects[15] = stockAllForm.getmType();
        objects[16] = stockAllForm.getDefined();
        objects[17] = stockAllForm.getSupplier();
        objects[18] = stockAllForm.getWarehousingDate();
        objects[19] = stockAllForm.getLocationDescription();
        objects[20] = stockAllForm.getSign();
        objects[21] = stockAllForm.getWarehousingRemarks();
        objects[22] = stockAllForm.getDrugFrom();
        objects[23] = stockAllForm.getHandlingInformation();
        objects[24] = stockAllForm.getApprovalNumber();
        objects[25] = stockAllForm.getLastCuringDate();
        objects[26] = stockAllForm.getTimesStorage();
        objects[27] = stockAllForm.getDocumentNumber();
        objects[28] = stockAllForm.getPlaceOrigin();
        objects[29] = stockAllForm.getBatchsNumber();
        objects[30] = stockAllForm.getRecordNumber();
        objects[31] = stockAllForm.getTableCoding();
        objects[32] = stockAllForm.getmId();
        int count = JDBC.update(sql, objects);
        return count;
    }

    @Override
    public int addStockAllForm(StockAllForm stockAllForm) {
        String sql = "INSERT INTO dictionary \n" +
                "    (mName, specification, manufactor, unit, \n" +
                "    department, POSITION, number, batchNumber, \n" +
                "    usefulLife, purchasePrice, salePrice, productDate,\n" +
                "     profits, CODE, goodsType, mType, defined, supplier, \n" +
                "     warehousingDate, locationDescription, SIGN, warehousingRemarks,\n" +
                "      drugFrom, handingInformation, approvalNumber, LastCuringDate,\n" +
                "       timesStorage, documentNumber, placeOrigin, batchsNumber, recordNumber) \n" +
                "VALUES \n" +
                "    (?, ?, ?, \n" +
                "    ?, ?, ?, ?, \n" +
                "    ?, ?, ?, ?, ?, \n" +
                "    ?, ?,?, ?, \n" +
                "    ?, ?, ?, \n" +
                "    ?, ?,\n" +
                "     ?, ?, \n" +
                "     ?, ?, \n" +
                "     ?, ?, ?, ?,\n" +
                "      ?, ?);";
        Object[] objects = new Object[31];
        objects[0] = stockAllForm.getmName();
        objects[1] = stockAllForm.getSpecification();
        objects[2] = stockAllForm.getManufactor();
        objects[3] = stockAllForm.getUnit();
        objects[4] = stockAllForm.getDepartment();
        objects[5] = stockAllForm.getPosition();
        objects[6] = stockAllForm.getNumber();
        objects[7] = stockAllForm.getBatchNumber();
        objects[8] = stockAllForm.getUsefulLife();
        objects[9] = stockAllForm.getPurchasePrice();
        objects[10] = stockAllForm.getSalePrice();
        objects[11] = stockAllForm.getProductDate();
        objects[12] = stockAllForm.getProfits();
        objects[13] = stockAllForm.getCode();
        objects[14] = stockAllForm.getGoodsType();
        objects[15] = stockAllForm.getmType();
        objects[16] = stockAllForm.getDefined();
        objects[17] = stockAllForm.getSupplier();
        objects[18] = stockAllForm.getWarehousingDate();
        objects[19] = stockAllForm.getLocationDescription();
        objects[20] = stockAllForm.getSign();
        objects[21] = stockAllForm.getWarehousingRemarks();
        objects[22] = stockAllForm.getDrugFrom();
        objects[23] = stockAllForm.getHandlingInformation();
        objects[24] = stockAllForm.getApprovalNumber();
        objects[25] = stockAllForm.getLastCuringDate();
        objects[26] = stockAllForm.getTimesStorage();
        objects[27] = stockAllForm.getDocumentNumber();
        objects[28] = stockAllForm.getPlaceOrigin();
        objects[29] = stockAllForm.getBatchsNumber();
        objects[30] = stockAllForm.getRecordNumber();
        int count = JDBC.update(sql, objects);
        return count;
    }
}
