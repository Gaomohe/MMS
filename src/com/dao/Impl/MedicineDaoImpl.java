package com.dao.Impl;

import com.dao.MedicineDao;
import com.pojo.Medicine;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {

    //新药添加(库存新添+药品新添)
    @Override
    public int addMedicine(Medicine medicine) {
        String sql = "INSERT INTO `dictionary`\n" +
                "(\n" +
                "`mName`,`specification`,`manufactor`,`unit`,`department`,`position`,`number`,`batchNumber`,\n" +
                "`usefulLife`,`purchasePrice`,`salePrice`,`productDate`,`profits`,`code`,`goodsType`,`mType`,\n" +
                "`defined`,`supplier`,`warehousingDate`,`locationDescription`,`sign`,`warehousingRemarks`,`drugFrom`,\n" +
                "`handlingInformation`,`approvalNumber`,`LastCuringDate`,`timesStorage`,`documentNumber`,`placeOrigin`,\n" +
                "`batchsNumber`,`recordNumber`,`mId`\n" +
                ")\n" +
                "VALUES \n" +
                "(\n" +
                "?,?,?,?,?,?,?,?,\n" +
                "?,?,?,?,?,?,?,?,\n" +
                "?,?,?,?,?,?,?,\n" +
                "?,?,?,?,?,?,\n" +
                "?,?,?\n" +
                ")";
        Object[] objects= new Object[32];
        objects[0] = medicine.getmName();
        objects[1] = medicine.getSpecification();
        objects[2] = medicine.getManufactor();
        objects[3] = medicine.getUnit();
        objects[4] = medicine.getDepartment();
        objects[5] = medicine.getPosition();
        objects[6] = medicine.getNumber();
        objects[7] = medicine.getBatchNumber();
        objects[8] = medicine.getUsefulLife();
        objects[9] = medicine.getPurchasePrice();
        objects[10] = medicine.getSalePrice();
        objects[11] = medicine.getProductDate();
        objects[12] = medicine.getProfits();
        objects[13] = medicine.getCode();
        objects[14] = medicine.getGoodsType();
        objects[15] = medicine.getmType();
        objects[16] = medicine.getDefined();
        objects[17] = medicine.getSupplier();
        objects[18] = medicine.getWarehousingDate();
        objects[19] = medicine.getLocationDescription();
        objects[20] = medicine.getSign();
        objects[21] = medicine.getWarehousingRemarks();
        objects[22] = medicine.getDrugFrom();
        objects[23] = medicine.getHandlingInformation();
        objects[24] = medicine.getApprovalNumber();
        objects[25] = "未养护";
        objects[26] = medicine.getTimesStorage();
        objects[27] = medicine.getDocumentNumber();
        objects[28] = medicine.getPlaceOrigin();
        objects[29] = medicine.getBatchsNumber();
        objects[30] = medicine.getRecordNumber();
        objects[31] = medicine.getmId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    //删除药品
    @Override
    public int delMedicine(int tableCoding) {
        String sql="DELETE FROM `dictionary` WHERE `tableCoding` = ?;";
        Object[]  objects= new Object[1];
        objects[0]=tableCoding;
        int count= JDBC.update(sql,objects);
        return count;
    }

    //根据mid删除药品
    @Override
    public int delMedicineByMId(int mid) {
        String sql="DELETE FROM `dictionary` WHERE `mId` = ?;";
        Object[]  objects= new Object[1];
        objects[0]=mid;
        int count= JDBC.update(sql,objects);
        return count;
    }

    //更新药品售价
    @Override
    public int updateMedicinePrice(Medicine medicine) {
        String sql="UPDATE `dictionary` SET `salePrice` = ? WHERE `mId`=?";
        Object[]  objects= new Object[2];
        objects[0] = medicine.getSalePrice();
        objects[1] = medicine.getmId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    //更新药品养护信息
    @Override
    public int updateMedicineLastCuringDate(Medicine medicine) {
        String sql="UPDATE `dictionary` SET `LastCuringDate` = ? WHERE `tableCoding`=?";
        Object[]  objects= new Object[2];
        objects[0] = medicine.getLastCuringDate();
        objects[1] = medicine.getTableCoding();
        int count= JDBC.update(sql,objects);
        return count;
    }
    //更新药品入库时间
    @Override
    public int updateMedicineWarehousingDate(Medicine medicine) {
        String sql="UPDATE `dictionary` SET `WarehousingDate` = ? WHERE `tableCoding`=?";
        Object[]  objects= new Object[2];
        objects[0] = medicine.getWarehousingDate();
        objects[1] = medicine.getTableCoding();
        int count= JDBC.update(sql,objects);
        return count;
    }
    //更新药品库存数量
    @Override
    public int updateMedicineNumber(Medicine medicine) {
        String sql="UPDATE `dictionary` SET `Number` = ? WHERE `tableCoding`=?";
        Object[]  objects= new Object[2];
        objects[0] = medicine.getLastCuringDate();
        objects[1] = medicine.getTableCoding();
        int count= JDBC.update(sql,objects);
        return count;
    }

    //更新药品基本信息
    @Override
    public int updateMedicineBasic(Medicine medicine) {
        String sql = "UPDATE `dictionary` SET \n" +
                "`mName`=?,`specification`=?,`manufactor`=?,`unit`=?,`department`=?,\n" +
                "`position`=?,`number`=?,`batchNumber`=?,`usefulLife`=?,`purchasePrice`=?,`salePrice`=?,\n" +
                "`productDate`=?,`profits`=?,`code`=?,`goodsType`=?,`mType`=?,`defined`=?,\n" +
                "`supplier`=?,`warehousingDate`=?,`locationDescription`=?,`sign`=?,`warehousingRemarks`=?,`drugFrom`=?,\n" +
                "`handlingInformation`=?,`approvalNumber`=?,`LastCuringDate`=?,`timesStorage`=?,`documentNumber`=?,`placeOrigin`=?,\n" +
                "`batchsNumber`=?,`recordNumber`=?,`mId`=?\n" +
                "WHERE `tableCoding` =?";
        Object[] objects = new Object[33];
        objects[0] = medicine.getmName();
        objects[1] = medicine.getSpecification();
        objects[2] = medicine.getManufactor();
        objects[3] = medicine.getUnit();
        objects[4] = medicine.getDepartment();
        objects[5] = medicine.getPosition();
        objects[6] = medicine.getNumber();
        objects[7] = medicine.getBatchNumber();
        objects[8] = medicine.getUsefulLife();
        objects[9] = medicine.getPurchasePrice();
        objects[10] = medicine.getSalePrice();
        objects[11] = medicine.getProductDate();
        objects[12] = medicine.getProfits();
        objects[13] = medicine.getCode();
        objects[14] = medicine.getGoodsType();
        objects[15] = medicine.getmType();
        objects[16] = medicine.getDefined();
        objects[17] = medicine.getSupplier();
        objects[18] = medicine.getWarehousingDate();
        objects[19] = medicine.getLocationDescription();
        objects[20] = medicine.getSign();
        objects[21] = medicine.getWarehousingRemarks();
        objects[22] = medicine.getDrugFrom();
        objects[23] = medicine.getHandlingInformation();
        objects[24] = medicine.getApprovalNumber();
        objects[25] = medicine.getLastCuringDate();
        objects[26] = medicine.getTimesStorage();
        objects[27] = medicine.getDocumentNumber();
        objects[28] = medicine.getPlaceOrigin();
        objects[29] = medicine.getBatchsNumber();
        objects[30] = medicine.getRecordNumber();
        objects[31] = medicine.getmId();
        objects[32] = medicine.getTableCoding();
        int count= JDBC.update(sql,objects);
        return count;
    }

    //查找所有药品的所有信息
    @Override
    public List<Medicine> getAllMedicine(int index, int limit) {
        String sql = "SELECT * FROM `dictionary` limit ?,? ";
        Object[] objects = new Object[2];
        objects[0] = index;
        objects[1] = limit;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Medicine> medicines = new ArrayList<Medicine>();
        try{
            while(resultSet.next()){
                Medicine medicine = new Medicine();
                medicine.setmId(resultSet.getInt(1));
                medicine.setmName(resultSet.getString(2));
                medicine.setSpecification(resultSet.getString(3));
                medicine.setManufactor(resultSet.getString(4));
                medicine.setUnit(resultSet.getString(5));
                medicine.setDepartment(resultSet.getString(6));
                medicine.setPosition(resultSet.getString(7));
                medicine.setNumber(resultSet.getInt(8));
                medicine.setBatchNumber(resultSet.getString(9));
                medicine.setUsefulLife(resultSet.getString(10));
                medicine.setPurchasePrice(resultSet.getInt(11));
                medicine.setSalePrice(resultSet.getInt(12));
                medicine.setProductDate(resultSet.getString(13));
                medicine.setProfits(resultSet.getString(14));
                medicine.setCode(resultSet.getString(15));
                medicine.setGoodsType(resultSet.getString(16));
                medicine.setmType(resultSet.getString(17));
                medicine.setDefined(resultSet.getString(18));
                medicine.setSupplier(resultSet.getString(19));
                medicine.setWarehousingDate(resultSet.getString(20));
                medicine.setLocationDescription(resultSet.getString(21));
                medicine.setSign(resultSet.getString(22));
                medicine.setWarehousingRemarks(resultSet.getString(23));
                medicine.setDrugFrom(resultSet.getString(24));
                medicine.setHandlingInformation(resultSet.getString(25));
                medicine.setApprovalNumber(resultSet.getString(26));
                medicine.setLastCuringDate(resultSet.getString(27));
                medicine.setTimesStorage(resultSet.getInt(28));
                medicine.setDocumentNumber(resultSet.getString(29));
                medicine.setPlaceOrigin(resultSet.getString(30));
                medicine.setBatchsNumber(resultSet.getString(31));
                medicine.setRecordNumber(resultSet.getInt(32));
                medicine.setTableCoding(resultSet.getInt(33));
                medicines.add(medicine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return medicines;
    }

    //根据药品编码药品的数据
    @Override
    public List<Medicine> getMedicineByMId(int mId) {
        String sql = "SELECT * FROM `dictionary` WHERE `mId`= ?";
        Object[] objects = new Object[1];
        objects[0] = mId;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Medicine> medicines = new ArrayList<Medicine>();
        try{
            while(resultSet.next()){
                Medicine medicine = new Medicine();
                medicine.setmId(resultSet.getInt(1));
                medicine.setmName(resultSet.getString(2));
                medicine.setSpecification(resultSet.getString(3));
                medicine.setManufactor(resultSet.getString(4));
                medicine.setUnit(resultSet.getString(5));
                medicine.setDepartment(resultSet.getString(6));
                medicine.setPosition(resultSet.getString(7));
                medicine.setNumber(resultSet.getInt(8));
                medicine.setBatchNumber(resultSet.getString(9));
                medicine.setUsefulLife(resultSet.getString(10));
                medicine.setPurchasePrice(resultSet.getInt(11));
                medicine.setSalePrice(resultSet.getInt(12));
                medicine.setProductDate(resultSet.getString(13));
                medicine.setProfits(resultSet.getString(14));
                medicine.setCode(resultSet.getString(15));
                medicine.setGoodsType(resultSet.getString(16));
                medicine.setmType(resultSet.getString(17));
                medicine.setDefined(resultSet.getString(18));
                medicine.setSupplier(resultSet.getString(19));
                medicine.setWarehousingDate(resultSet.getString(20));
                medicine.setLocationDescription(resultSet.getString(21));
                medicine.setSign(resultSet.getString(22));
                medicine.setWarehousingRemarks(resultSet.getString(23));
                medicine.setDrugFrom(resultSet.getString(24));
                medicine.setHandlingInformation(resultSet.getString(25));
                medicine.setApprovalNumber(resultSet.getString(26));
                medicine.setLastCuringDate(resultSet.getString(27));
                medicine.setTimesStorage(resultSet.getInt(28));
                medicine.setDocumentNumber(resultSet.getString(29));
                medicine.setPlaceOrigin(resultSet.getString(30));
                medicine.setBatchsNumber(resultSet.getString(31));
                medicine.setRecordNumber(resultSet.getInt(32));
                medicine.setTableCoding(resultSet.getInt(33));
                medicines.add(medicine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return medicines;
    }

    //药品的回显或按照主键查询药品
    @Override
    public Medicine getMedicine(int tableCoding) {
        String sql = "SELECT * FROM `dictionary` WHERE `tableCoding`= ?";
        Object[] objects = new Object[1];
        objects[0] = tableCoding;
        ResultSet resultSet = JDBC.select(sql,objects);
        Medicine medicine = new Medicine();
        try{
            while(resultSet.next()){
                medicine.setmId(resultSet.getInt(1));
                medicine.setmName(resultSet.getString(2));
                medicine.setSpecification(resultSet.getString(3));
                medicine.setManufactor(resultSet.getString(4));
                medicine.setUnit(resultSet.getString(5));
                medicine.setDepartment(resultSet.getString(6));
                medicine.setPosition(resultSet.getString(7));
                medicine.setNumber(resultSet.getInt(8));
                medicine.setBatchNumber(resultSet.getString(9));
                medicine.setUsefulLife(resultSet.getString(10));
                medicine.setPurchasePrice(resultSet.getInt(11));
                medicine.setSalePrice(resultSet.getInt(12));
                medicine.setProductDate(resultSet.getString(13));
                medicine.setProfits(resultSet.getString(14));
                medicine.setCode(resultSet.getString(15));
                medicine.setGoodsType(resultSet.getString(16));
                medicine.setmType(resultSet.getString(17));
                medicine.setDefined(resultSet.getString(18));
                medicine.setSupplier(resultSet.getString(19));
                medicine.setWarehousingDate(resultSet.getString(20));
                medicine.setLocationDescription(resultSet.getString(21));
                medicine.setSign(resultSet.getString(22));
                medicine.setWarehousingRemarks(resultSet.getString(23));
                medicine.setDrugFrom(resultSet.getString(24));
                medicine.setHandlingInformation(resultSet.getString(25));
                medicine.setApprovalNumber(resultSet.getString(26));
                medicine.setLastCuringDate(resultSet.getString(27));
                medicine.setTimesStorage(resultSet.getInt(28));
                medicine.setDocumentNumber(resultSet.getString(29));
                medicine.setPlaceOrigin(resultSet.getString(30));
                medicine.setBatchsNumber(resultSet.getString(31));
                medicine.setRecordNumber(resultSet.getInt(32));
                medicine.setTableCoding(resultSet.getInt(33));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return medicine;
    }

    //根据药品名称，商品类型，药品功效，剂型查找药品
    @Override
    public List<Medicine> getMedicineByQuery(String[] query) {
        String sql = "SELECT * FROM `dictionary` \n" +
                "WHERE  `mName` LIKE ?\n" +
                "AND `goodsType` LIKE ?\n" +
                "AND `mType` LIKE ?\n" +
                "AND `drugFrom` LIKE ?";
        Object[] objects = new Object[4];
        objects[0] = "%"+query[0]+"%";
        objects[1] = "%"+query[1]+"%";
        objects[2] = "%"+query[2]+"%";
        objects[3] = "%"+query[3]+"%";
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Medicine> medicines = new ArrayList<Medicine>();
        try{
            while(resultSet.next()){
                Medicine medicine = new Medicine();
                medicine.setmId(resultSet.getInt(1));
                medicine.setmName(resultSet.getString(2));
                medicine.setSpecification(resultSet.getString(3));
                medicine.setManufactor(resultSet.getString(4));
                medicine.setUnit(resultSet.getString(5));
                medicine.setDepartment(resultSet.getString(6));
                medicine.setPosition(resultSet.getString(7));
                medicine.setNumber(resultSet.getInt(8));
                medicine.setBatchNumber(resultSet.getString(9));
                medicine.setUsefulLife(resultSet.getString(10));
                medicine.setPurchasePrice(resultSet.getInt(11));
                medicine.setSalePrice(resultSet.getInt(12));
                medicine.setProductDate(resultSet.getString(13));
                medicine.setProfits(resultSet.getString(14));
                medicine.setCode(resultSet.getString(15));
                medicine.setGoodsType(resultSet.getString(16));
                medicine.setmType(resultSet.getString(17));
                medicine.setDefined(resultSet.getString(18));
                medicine.setSupplier(resultSet.getString(19));
                medicine.setWarehousingDate(resultSet.getString(20));
                medicine.setLocationDescription(resultSet.getString(21));
                medicine.setSign(resultSet.getString(22));
                medicine.setWarehousingRemarks(resultSet.getString(23));
                medicine.setDrugFrom(resultSet.getString(24));
                medicine.setHandlingInformation(resultSet.getString(25));
                medicine.setApprovalNumber(resultSet.getString(26));
                medicine.setLastCuringDate(resultSet.getString(27));
                medicine.setTimesStorage(resultSet.getInt(28));
                medicine.setDocumentNumber(resultSet.getString(29));
                medicine.setPlaceOrigin(resultSet.getString(30));
                medicine.setBatchsNumber(resultSet.getString(31));
                medicine.setRecordNumber(resultSet.getInt(32));
                medicine.setTableCoding(resultSet.getInt(33));
                medicines.add(medicine);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return medicines;
    }
}
