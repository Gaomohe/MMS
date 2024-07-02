package com.dao.Impl;

import com.dao.WarehouseDao;
import com.pojo.User;
import com.pojo.Warehouse;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class WarehouseDaoImpl implements WarehouseDao {
    @Override
    public List<Warehouse> selectWarehouse() {
        String sql=" select * from dictionary?";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Warehouse> warehouseList = new ArrayList<Warehouse>();
        Warehouse warehouse = new Warehouse();
        try {
            while (resultSet.next()){
                warehouse.setmId(resultSet.getInt(1));
                warehouse.setmName(resultSet.getString(2));
                warehouse.setSpecification(resultSet.getString(3));
                warehouse.setManufactor(resultSet.getString(4));
                warehouse.setUnit(resultSet.getString(5));
                warehouse.setDepartment(resultSet.getString(6));
                warehouse.setPosition(resultSet.getString(7));
                warehouse.setNumber(resultSet.getInt(8));
                warehouse.setBatchNumber(resultSet.getString(9));
                warehouse.setUsefulLife(resultSet.getString(10));
                warehouse.setPurchasePrice(resultSet.getInt(11));
                warehouse.setSalePrice(resultSet.getInt(12));
                warehouse.setProductDate(resultSet.getString(13));
                warehouse.setProfits(resultSet.getString(14));
                warehouse.setCode(resultSet.getString(15));
                warehouse.setGoodsType(resultSet.getString(16));
                warehouse.setmType(resultSet.getString(17));
                warehouse.setDefined(resultSet.getString(18));
                warehouse.setSupplier(resultSet.getString(19));
                warehouse.setWarehousingDate(resultSet.getString(20));
                warehouse.setLocationDescription(resultSet.getString(21));
                warehouse.setSign(resultSet.getString(22));
                warehouse.setWarehousingRemarks(resultSet.getString(23));
                warehouse.setDrugFrom(resultSet.getString(24));
                warehouse.setHandlingInformation(resultSet.getString(25));
                warehouse.setApprovalNumber(resultSet.getString(26));
                warehouse.setLastCuringDate(resultSet.getString(27));
                warehouse.setTimesStorage(resultSet.getInt(28));
                warehouse.setDocumentNumber(resultSet.getString(29));
                warehouse.setPlaceOrigin(resultSet.getString(30));
                warehouse.setBatchsNumber(resultSet.getString(31));
                warehouse.setRecordNumber(resultSet.getInt(32));
                warehouseList.add(warehouse);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return warehouseList;
    }

    @Override
    public Warehouse getWarehouseById(int mid) {
        String sql=" select * from dictionary where mId=?";
        Object[]  objects= new Object[1];
        objects[0]=mid;
        ResultSet resultSet = JDBC.select(sql,objects);
        Warehouse warehouse = new Warehouse();
        try {
            while (resultSet.next()){
                warehouse.setmId(resultSet.getInt(1));
                warehouse.setmName(resultSet.getString(2));
                warehouse.setSpecification(resultSet.getString(3));
                warehouse.setManufactor(resultSet.getString(4));
                warehouse.setUnit(resultSet.getString(5));
                warehouse.setDepartment(resultSet.getString(6));
                warehouse.setPosition(resultSet.getString(7));
                warehouse.setNumber(resultSet.getInt(8));
                warehouse.setBatchNumber(resultSet.getString(9));
                warehouse.setUsefulLife(resultSet.getString(10));
                warehouse.setPurchasePrice(resultSet.getInt(11));
                warehouse.setSalePrice(resultSet.getInt(12));
                warehouse.setProductDate(resultSet.getString(13));
                warehouse.setProfits(resultSet.getString(14));
                warehouse.setCode(resultSet.getString(15));
                warehouse.setGoodsType(resultSet.getString(16));
                warehouse.setmType(resultSet.getString(17));
                warehouse.setDefined(resultSet.getString(18));
                warehouse.setSupplier(resultSet.getString(19));
                warehouse.setWarehousingDate(resultSet.getString(20));
                warehouse.setLocationDescription(resultSet.getString(21));
                warehouse.setSign(resultSet.getString(22));
                warehouse.setWarehousingRemarks(resultSet.getString(23));
                warehouse.setDrugFrom(resultSet.getString(24));
                warehouse.setHandlingInformation(resultSet.getString(25));
                warehouse.setApprovalNumber(resultSet.getString(26));
                warehouse.setLastCuringDate(resultSet.getString(27));
                warehouse.setTimesStorage(resultSet.getInt(28));
                warehouse.setDocumentNumber(resultSet.getString(29));
                warehouse.setPlaceOrigin(resultSet.getString(30));
                warehouse.setBatchsNumber(resultSet.getString(31));
                warehouse.setRecordNumber(resultSet.getInt(32));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return warehouse;
    }

    @Override
    public int delWarehouse(int id) {
        String sql=" delete from dictionary where mid=?";
        Object[]  objects= new Object[1];
        objects[0]=id;
        int count = JDBC.update(sql, objects);
        return count;
    }

    @Override
    public int updateWarehouse(Warehouse warehouse) {
        String sql="UPDATE dictionary SET mName = ?, specification = ?, manufactor = ?, unit = ?, department = ?, position = ?, number = ?, batchNumber = ?, usefulLife = ?, purchasePrice = ?, salePrice = ?, productDate = ?, profits = ?, code = ?, goodsType = ?, mType = ?, defined = ?, supplier = ?, warehousingDate = ?, locationDescription = ?, sign = ?, warehousingRemarks = ?, drugFrom = ?, handlingInformation = ?, approvalNumber = ?, LastCuringDate = ?, timesStorage = ?, documentNumber = ?, placeOrigin = ?, batchsNumber = ?, recordNumber = ? WHERE mId = ?;";
        Object[] objects = new Object[32];
        objects[0] = warehouse.getmName();
        objects[1] = warehouse.getSpecification();
        objects[2] = warehouse.getManufactor();
        objects[3] = warehouse.getUnit();
        objects[4] = warehouse.getDepartment();
        objects[5] = warehouse.getPosition();
        objects[6] = warehouse.getNumber();
        objects[7] = warehouse.getBatchNumber();
        objects[8] = warehouse.getUsefulLife();
        objects[9] = warehouse.getPurchasePrice();
        objects[10] = warehouse.getSalePrice();
        objects[11] = warehouse.getProductDate();
        objects[12] = warehouse.getProfits();
        objects[13] = warehouse.getCode();
        objects[14] = warehouse.getGoodsType();
        objects[15] = warehouse.getmType();
        objects[16] = warehouse.getDefined();
        objects[17] = warehouse.getSupplier();
        objects[18] = warehouse.getWarehousingDate();
        objects[19] = warehouse.getLocationDescription();
        objects[20] = warehouse.getSign();
        objects[21] = warehouse.getWarehousingRemarks();
        objects[22] = warehouse.getDrugFrom();
        objects[23] = warehouse.getHandlingInformation();
        objects[24] = warehouse.getApprovalNumber();
        objects[25] = warehouse.getLastCuringDate();
        objects[26] = warehouse.getTimesStorage();
        objects[27] = warehouse.getDocumentNumber();
        objects[28] = warehouse.getPlaceOrigin();
        objects[29] = warehouse.getBatchsNumber();
        objects[30] = warehouse.getRecordNumber();
        objects[31] = warehouse.getmId();
        int count = JDBC.update(sql, objects);
        return count;
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        String sql = "INSERT INTO dictionary (mName, specification, manufactor, unit, department, position, number, batchNumber, usefulLife, purchasePrice, salePrice, productDate, profits, code, goodsType, mType, defined, supplier, warehousingDate, locationDescription, sign, warehousingRemarks, drugFrom, handlingInformation, approvalNumber, LastCuringDate, timesStorage, documentNumber, placeOrigin, batchsNumber, recordNumber, mId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        Object[] objects = new Object[32];
        objects[0] = warehouse.getmName();
        objects[1] = warehouse.getSpecification();
        objects[2] = warehouse.getManufactor();
        objects[3] = warehouse.getUnit();
        objects[4] = warehouse.getDepartment();
        objects[5] = warehouse.getPosition();
        objects[6] = warehouse.getNumber();
        objects[7] = warehouse.getBatchNumber();
        objects[8] = warehouse.getUsefulLife();
        objects[9] = warehouse.getPurchasePrice();
        objects[10] = warehouse.getSalePrice();
        objects[11] = warehouse.getProductDate();
        objects[12] = warehouse.getProfits();
        objects[13] = warehouse.getCode();
        objects[14] = warehouse.getGoodsType();
        objects[15] = warehouse.getmType();
        objects[16] = warehouse.getDefined();
        objects[17] = warehouse.getSupplier();
        objects[18] = warehouse.getWarehousingDate();
        objects[19] = warehouse.getLocationDescription();
        objects[20] = warehouse.getSign();
        objects[21] = warehouse.getWarehousingRemarks();
        objects[22] = warehouse.getDrugFrom();
        objects[23] = warehouse.getHandlingInformation();
        objects[24] = warehouse.getApprovalNumber();
        objects[25] = warehouse.getLastCuringDate();
        objects[26] = warehouse.getTimesStorage();
        objects[27] = warehouse.getDocumentNumber();
        objects[28] = warehouse.getPlaceOrigin();
        objects[29] = warehouse.getBatchsNumber();
        objects[30] = warehouse.getRecordNumber();
        objects[31] = warehouse.getmId();
        int count = JDBC.update(sql, objects);
        return count;
    }
}
