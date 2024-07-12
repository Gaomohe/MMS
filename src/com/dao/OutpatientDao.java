package com.dao;

import com.pojo.Patient;
import com.pojo.User;

import java.util.List;

public interface OutpatientDao {
    //获取病患列表
    public List<Patient> getPatientList(int page, int limit, User user);
}
