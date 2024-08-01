package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.MedicineDao;
import com.pojo.Curing;
import com.pojo.DicNum;
import com.pojo.Medicine;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MedicineDaoImpl implements MedicineDao {

    //新药添加(库存新添+药品新添)
    @Override
    public int addMedicine(Medicine medicine) {
        String sql = "INSERT INTO `dictionary` (`mName`,`specification`,`manufactor`,`unit`,`department`,`position`,`number`,`batchNumber`,`usefulLife`,`purchasePrice`,`salePrice`,`productDate`,`profits`,`code`,`goodsType`,`mType`,`defined`,`supplier`,`warehousingDate`,`locationDescription`,`sign`,`warehousingRemarks`,`drugFrom`,`handingInformation`,`approvalNumber`,`LastCuringDate`,`timesStorage`,`documentNumber`,`placeOrigin`,`batchsNumber`,`recordNumber`,`mId`)\n" +
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
        objects[25] = medicine.getLastCuringDate();
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
        String sql="UPDATE `dictionary` SET `salePrice` = ? WHERE `tableCoding`=?";
        Object[]  objects= new Object[2];
        objects[0] = medicine.getSalePrice();
        objects[1] = medicine.getTableCoding();
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
        objects[0] = medicine.getNumber();
        objects[1] = medicine.getTableCoding();
        int count= JDBC.update(sql,objects);
        return count;
    }

    //药品回滚删除
    @Override
    public int delMedicineByTableCoding(int mId,int oId) {
        String sql="delete from medicineorder where status='未取药' AND orderId = ?";
        Object[]  objects= new Object[1];
        objects[0]=oId;
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
                "`handingInformation`=?,`approvalNumber`=?,`LastCuringDate`=?,`timesStorage`=?,`documentNumber`=?,`placeOrigin`=?,\n" +
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
                medicine.setLastCuringDate(resultSet.getString("LastCuringDate"));
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

    @Override
    public List<Medicine> getAllMedicine(int index, int limit, String order, String title) {
        String sql = "SELECT * FROM (SELECT * FROM `dictionary` limit ?,?) AS a ORDER BY "+title+" "+order;
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

    public int getAllMedicine() {
        String sql = "SELECT tableCoding FROM `dictionary`";
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        /*List<Medicine> medicines = new ArrayList<Medicine>();*/
        int i = 0;
        try{
            while(resultSet.next()){
                i++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
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

    @Override
    public List<Medicine> getMedicine(String mName) {
        String sql = "SELECT * FROM `dictionary` WHERE `mName` LIKE ?";
        Object[] objects = new Object[1];
        objects[0] = "%"+mName+"%";
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

    //根据商品类型，药品功效，剂型查找药品
    @Override
    public List<Medicine> getMedicineByQuery(String sql) {
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
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

    public List<Medicine> getMidicineByTime(String time) {
        InitDaoImpl initDao = new InitDaoImpl();
        String[] keys = new String[]{"LastCuringDate"};
        String[] values = new String[]{time};
        String table = "dictionary";
        ResultSet resultSet = initDao.search(keys,values,table);
        List<Medicine> medicines = new ArrayList<>();
        try {
            while (resultSet.next()){
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicines;
    }

    @Override
    public int addDic_Num(Medicine medicine, int patientId, int number) {
        String sql="INSERT INTO `dic_num` (`tableCoding`,`number`,`statue`,`patientId`,time)VALUES(?,?,?,?,NOW())";
        Object[] objects= new Object[4];
        objects[0] = medicine.getTableCoding();
        objects[1] = number;
        objects[2] = "未付款";
        objects[3] = patientId;
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public DicNum getDic_Num(int tableCoding, int patientId) {
        String sql = "SELECT * FROM `dic_num` WHERE `tableCoding`= ? AND `patientId`=?";
        Object[] objects = new Object[2];
        objects[0] = tableCoding;
        objects[1] = patientId;
        ResultSet resultSet = JDBC.select(sql, objects);
        DicNum dicNum = new DicNum();
        try{
            while(resultSet.next()){
                dicNum.setTableCoding(resultSet.getInt(2));
                dicNum.setNumber(resultSet.getInt(3));
                dicNum.setStatue(resultSet.getString(4));
                dicNum.setPatientId(resultSet.getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return dicNum;
    }

    @Override
    public List<DicNum> getDic_Num() {
        String sql = "SELECT * FROM `dic_num` WHERE `statue`='未付款'";
        List<DicNum> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        try{
            while(resultSet.next()){
                DicNum dicNum = new DicNum();
                dicNum.setId(resultSet.getInt(1));
                dicNum.setTableCoding(resultSet.getInt(2));
                dicNum.setNumber(resultSet.getInt(3));
                dicNum.setStatue(resultSet.getString(4));
                dicNum.setPatientId(resultSet.getInt(5));
                dicNum.setTime(resultSet.getString(6));
                list.add(dicNum);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<DicNum> getDic_Num(int pId) {
        String sql = "SELECT * FROM `dic_num` WHERE `statue`='未付款' AND patientId=?";
        List<DicNum> list = new ArrayList<>();
        Object[] objects = new Object[1];
        objects[0] = pId;
        ResultSet resultSet = JDBC.select(sql,objects);
        try{
            while(resultSet.next()){
                DicNum dicNum = new DicNum();
                dicNum.setId(resultSet.getInt(1));
                dicNum.setTableCoding(resultSet.getInt(2));
                dicNum.setNumber(resultSet.getInt(3));
                dicNum.setStatue(resultSet.getString(4));
                dicNum.setPatientId(resultSet.getInt(5));
                dicNum.setTime(resultSet.getString(6));
                list.add(dicNum);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<DicNum> getDic_Num(String yifukuan) {
        String sql = "SELECT * FROM `dic_num` WHERE `statue`='已付款'";
        List<DicNum> list = new ArrayList<>();
        ResultSet resultSet = JDBC.select(sql,new Object[1]);
        try{
            while(resultSet.next()){
                DicNum dicNum = new DicNum();
                dicNum.setId(resultSet.getInt(1));
                dicNum.setTableCoding(resultSet.getInt(2));
                dicNum.setNumber(resultSet.getInt(3));
                dicNum.setStatue(resultSet.getString(4));
                dicNum.setPatientId(resultSet.getInt(5));
                dicNum.setTime(resultSet.getString(6));
                list.add(dicNum);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateDic_Num(DicNum dicNum) {
        String sql="UPDATE `dic_num` SET `statue`=? WHERE `tableCoding`=? AND `patientId`=?";
        Object[] objects= new Object[3];
        objects[0] = dicNum.getStatue();
        objects[1] = dicNum.getTableCoding();
        objects[2] = dicNum.getPatientId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int delDic_Num(int id) {
        InitDaoImpl initDao = new InitDaoImpl();
        boolean b = initDao.delOne(id, "id", "dic_num");
        if (b){
            return 1;
        }
        return 0;
    }

    @Override
    public int getMId(int pId) {
        String sql = "select mId from patient where pId = ?;";
        Object[] objects = new Object[1];
        objects[0] = pId;
        ResultSet resultSet = JDBC.select(sql,objects);
        int i = 0;
        try{
            while(resultSet.next()){
                int mId = resultSet.getInt("mId");
                i = mId;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
