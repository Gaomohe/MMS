package com.dao.Impl;

import com.dao.OutpatientDao;
import com.pojo.Patient;
import com.pojo.User;
import com.util.JDBC;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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
                patient.setAddress(resultSet.getString(9));
                patient.setPhone(resultSet.getString(10));
                patient.setDiagnosticTime(resultSet.getString(11));
                patient.setAllergy(resultSet.getString(12));
                patient.setDoctorAdvice(resultSet.getString(13));
                patient.setdName(resultSet.getString(14));
                list.add(patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
