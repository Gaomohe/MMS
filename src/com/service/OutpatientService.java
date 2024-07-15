package com.service;

import com.pojo.Medicine;
import com.pojo.Patient;
import com.pojo.User;
import com.util.LayuiTable;

import java.util.List;

public interface OutpatientService {
    //获取病患列表
    public LayuiTable<Patient> getPatientList(int page, int limit, User user);

    //条件查询所有患者
    public LayuiTable<Patient> Search(Patient patient);

    //添加患者信息
    public int addPatient(Patient patient);

    //门诊检索查看药品
    public LayuiTable<Medicine> getMedicineList(Medicine medicine);
}
