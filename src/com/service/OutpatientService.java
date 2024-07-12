package com.service;

import com.pojo.Patient;
import com.pojo.User;
import com.util.LayuiTable;

public interface OutpatientService {
    //获取病患列表
    public LayuiTable<Patient> getPatientList(int page, int limit, User user);
}
