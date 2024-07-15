package com.dao.Impl;

import com.dao.OutpatientDao;
import com.pojo.Patient;
import com.pojo.User;
import com.util.JDBC;
import jdk.nashorn.internal.scripts.JD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OutpatientDaoImpl implements OutpatientDao {

    //获取病患列表
    @Override
    public List<Patient> getPatientList(int page, int limit, User user) {
        String sql = "SELECT * FROM patient\n" +
                "WHERE dId=? and dName=?\n" +
                "limit ?,?";
        Object[] objects = new Object[4];
        objects[0] = user.getId();
        objects[1] = user.getUserName();
        objects[2] = page;
        objects[3] = limit;
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
        sql += " and dId > ?";
        Object[] objects = new Object[1];
        objects[0] = 0;
        ResultSet resultSet = JDBC.select(sql, objects);
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
        String sql = "INSERT INTO patient(dId, name, sex, age, weight, address, phone, diagnosticTime, allergy, doctorAdvice, dName, lastDiaTime) \n" +
                "    VALUE (?,?,?,?,?,?,?,?,?,?,?,?);";
        Object[] objects = new Object[12];
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
        int i = 0;
        i = JDBC.update(sql,objects);
        return i;
    }
}
