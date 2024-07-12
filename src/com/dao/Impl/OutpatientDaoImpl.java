package com.dao.Impl;

import com.dao.OutpatientDao;
import com.pojo.Patient;
import com.pojo.User;

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

        return Collections.emptyList();
    }
}
