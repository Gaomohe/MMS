package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.OutpatientDao;
import com.pojo.Medicine;
import com.pojo.Patient;
import com.pojo.User;
import com.util.JDBC;
import jdk.nashorn.internal.scripts.JD;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.util.Vessel.medicineCount;

public class OutpatientDaoImpl extends InitDaoImpl implements OutpatientDao {

    //获取病患列表
    @Override
    public List<Patient> getPatientList(int page, int limit) {
        String sql = "SELECT * FROM patient\n" +
                "limit ?,?";
        Object[] objects = new Object[2];
        objects[0] = page;
        objects[1] = limit;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Patient> list = new ArrayList<Patient>();
        try{
            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setpId(resultSet.getInt(1));
                patient.setdId(resultSet.getInt(2));
                patient.setmId(resultSet.getInt(3));
                patient.setName(resultSet.getString(4));
                patient.setSex(resultSet.getString(5));
                patient.setAge(resultSet.getInt(6));
                patient.setWeight(resultSet.getInt(7));
                patient.setAddress(resultSet.getString(8));
                patient.setPhone(resultSet.getString(9));
                patient.setDiagnosticTime(resultSet.getString(10));
                patient.setAllergy(resultSet.getString(11));
                patient.setDoctorAdvice(resultSet.getString(12));
                patient.setdName(resultSet.getString(13));
                patient.setLastDiaTime(resultSet.getString(14));
                patient.setDisease(resultSet.getString(15));
                list.add(patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //条件查询所有病人列表
    @Override
    public List<Patient> Search(String sql) {
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Patient> list = new ArrayList<Patient>();
        try{
            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setpId(resultSet.getInt(1));
                patient.setdId(resultSet.getInt(2));
                patient.setmId(resultSet.getInt(3));
                patient.setName(resultSet.getString(4));
                patient.setSex(resultSet.getString(5));
                patient.setAge(resultSet.getInt(6));
                patient.setWeight(resultSet.getInt(7));
                patient.setAddress(resultSet.getString(8));
                patient.setPhone(resultSet.getString(9));
                patient.setDiagnosticTime(resultSet.getString(10));
                patient.setAllergy(resultSet.getString(11));
                patient.setDoctorAdvice(resultSet.getString(12));
                patient.setdName(resultSet.getString(13));
                patient.setLastDiaTime(resultSet.getString(14));
                patient.setDisease(resultSet.getString(15));
                list.add(patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //添加患者信息
    @Override
    public int addPatient(Patient patient) {
        String sql = "INSERT INTO patient(dId, name, sex, age, weight, address, phone, diagnosticTime, allergy, doctorAdvice, dName, lastDiaTime,disease) \n" +
                "    VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        Object[] objects = new Object[13];
        objects[0] = patient.getdId();
        objects[1] = patient.getName();
        objects[2] = patient.getSex();
        objects[3] = patient.getAge();
        objects[4] = patient.getWeight();
        objects[5] = patient.getAddress();
        objects[6] = patient.getPhone();
        objects[7] = patient.getDiagnosticTime();
        objects[8] = patient.getAllergy();
        objects[9] = patient.getDoctorAdvice();
        objects[10] = patient.getdName();
        objects[11] = patient.getLastDiaTime();
        objects[12] = patient.getDisease();
        int i = 0;
        i = JDBC.update(sql,objects);
        return i;
    }

    //门诊医生条件查询所有药品
    @Override
    public List<Medicine> getMedicineList(String sql) {
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Medicine> medicines = new ArrayList<>();
        medicineCount = 0;
        try {
            while (resultSet.next()){
                Medicine medicine = new Medicine();
                medicine.setmId(resultSet.getInt("mId"));
                medicine.setmName(resultSet.getString("mName"));
                medicine.setSpecification(resultSet.getString("specification"));
//                medicine.setManufactor(resultSet.getString(4));
                medicine.setUnit(resultSet.getString("unit"));
                /*medicine.setDepartment(resultSet.getString(6));
                medicine.setPosition(resultSet.getString(7));*/
                medicine.setNumber(resultSet.getInt("number"));
                /*medicine.setBatchNumber(resultSet.getString(9));
                medicine.setUsefulLife(resultSet.getString(10));
                medicine.setPurchasePrice(resultSet.getInt(11));*/
                medicine.setSalePrice(resultSet.getInt("salePrice"));
                medicine.setProductDate(resultSet.getString("productDate"));
                /*medicine.setProfits(resultSet.getString(14));
                medicine.setCode(resultSet.getString(15));*/
                medicine.setGoodsType(resultSet.getString("goodsType"));
                medicine.setmType(resultSet.getString("mType"));
                /*medicine.setDefined(resultSet.getString(18));
                medicine.setSupplier(resultSet.getString(19));
                medicine.setWarehousingDate(resultSet.getString(20));
                medicine.setLocationDescription(resultSet.getString(21));
                medicine.setSign(resultSet.getString(22));
                medicine.setWarehousingRemarks(resultSet.getString(23));*/
                medicine.setDrugFrom(resultSet.getString("drugFrom"));
//                medicine.setHandlingInformation(resultSet.getString(25));
                medicine.setApprovalNumber(resultSet.getString("approvalNumber"));
                /*medicine.setLastCuringDate(resultSet.getString(27));
                medicine.setTimesStorage(resultSet.getInt(28));
                medicine.setDocumentNumber(resultSet.getString(29));
                medicine.setPlaceOrigin(resultSet.getString(30));
                medicine.setBatchsNumber(resultSet.getString(31));
                medicine.setRecordNumber(resultSet.getInt(32));*/
                medicine.setTableCoding(resultSet.getInt("tableCoding"));
                medicineCount++;
                medicines.add(medicine);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicines;
    }

    @Override
    public Patient backValues(int id) {
        String sql = "select * from patient where pId = ?";
        Object[] objects = new Object[1];
        objects[0] = id;
        ResultSet resultSet = JDBC.select(sql,objects);
        Patient patient = new Patient();
        try{
            while (resultSet.next()) {
                patient.setpId(resultSet.getInt(1));
                patient.setdId(resultSet.getInt(2));
                patient.setmId(resultSet.getInt(3));
                patient.setName(resultSet.getString(4));
                patient.setSex(resultSet.getString(5));
                patient.setAge(resultSet.getInt(6));
                patient.setWeight(resultSet.getInt(7));
                patient.setAddress(resultSet.getString(8));
                patient.setPhone(resultSet.getString(9));
                patient.setDiagnosticTime(resultSet.getString(10));
                patient.setAllergy(resultSet.getString(11));
                patient.setDoctorAdvice(resultSet.getString(12));
                patient.setdName(resultSet.getString(13));
                patient.setLastDiaTime(resultSet.getString(14));
                patient.setDisease(resultSet.getString(15));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return patient;
    }

    @Override
    public int addmOrder(int pId) {
        String sql = "insert into morder(pId) value(?)";
        Object[] objects = new Object[1];
        objects[0] = pId;
        int result = JDBC.update(sql, objects);
        return result;
    }

    @Override
    public int getOrderId() {
        String sql = "SELECT orderId FROM morder ORDER BY orderId DESC LIMIT 1\n";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        int orderId = 0;
        try{
            while (resultSet.next()) {

                orderId = resultSet.getInt("orderId");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderId;
    }

    @Override
    public int updatemIdtoPatient(int orderId, int pId) {
        String sql = "update patient set mId = ? where pId = ?";
        Object[] objects = new Object[2];
        objects[0] = orderId;
        objects[1] = pId;
        int result = JDBC.update(sql, objects);
        return result;
    }

    @Override
    public int addMedicine(int orderId, Medicine medicine) {
        String sql = "insert into medicineorder(mId,orderId,number) values(?,?,?)";
        Object[] objects = new Object[3];
        objects[0] = medicine.getmId();
        objects[1] = orderId;
        objects[2] = medicine.getNumber();
        int result = JDBC.update(sql, objects);
        return result;
    }

    //已选中药品回显
    @Override
    public Medicine getPatientMedicine(int mId) {
        String sql = "select * from dictionary where mId = ?";
        Object[] objects = new Object[1];
        objects[0] = mId;
        ResultSet resultSet = JDBC.select(sql, objects);
        Medicine medicine = new Medicine();
        try{
            while (resultSet.next()) {
                medicine.setmId(resultSet.getInt("mId"));
                medicine.setmName(resultSet.getString("mName"));
                medicine.setSpecification(resultSet.getString("specification"));
                medicine.setUnit(resultSet.getString("unit"));
                medicine.setNumber(resultSet.getInt("number"));
                medicine.setSalePrice(resultSet.getInt("salePrice"));
                medicine.setProductDate(resultSet.getString("productDate"));
                medicine.setGoodsType(resultSet.getString("goodsType"));
                medicine.setmType(resultSet.getString("mType"));
                medicine.setDrugFrom(resultSet.getString("drugFrom"));
                medicine.setApprovalNumber(resultSet.getString("approvalNumber"));
                medicine.setTableCoding(resultSet.getInt("tableCoding"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return medicine;
    }
}
