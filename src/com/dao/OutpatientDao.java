package com.dao;

import com.pojo.Medicine;
import com.pojo.Patient;
import com.pojo.User;

import java.util.List;

public interface OutpatientDao {
    //获取病患列表
    public List<Patient> getPatientList(int page, int limit, User user);

    //条件查询所有病人列表
    public List<Patient> Search(String sql);

    //添加患者信息
    public int addPatient(Patient patient);

    //门诊医生条件查询所有药品
    public List<Medicine> getMedicineList(String sql);
}
