package com.service;

import com.pojo.Patient;
import com.pojo.User;
import com.util.LayuiTable;

import java.util.List;

public interface OutpatientService {
    //获取病患列表
    public LayuiTable<Patient> getPatientList(int page, int limit, User user);

    //条件查询所有患者
    public List<Patient> Search(Patient patient);
}
