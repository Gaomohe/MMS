package com.dao;

import com.dao.Impl.init.InitDaoImpl;
import com.pojo.Medicine;
import com.pojo.Patient;
import com.pojo.User;

import java.util.List;

public interface OutpatientDao {
    //获取病患列表
    public List<Patient> getPatientList(int page, int limit);

    //条件查询所有病人列表
    public List<Patient> Search(String sql);

    //添加患者信息
    public int addPatient(Patient patient);

    //门诊医生条件查询所有药品
    public List<Medicine> getMedicineList(String sql);

    //回显病患信息
    public Patient backValues(int id);

    //添加处方
    public int addmOrder(int pId);

    //获取处方id
    public int getOrderId();

    //绑定病人与处方
    public int updatemIdtoPatient(int orderId,int pId);

    //绑定处方与处方详情表
    public int addMedicine(int orderId,Medicine medicine);

    //已选中药品回显
    public Medicine getPatientMedicine(int mId);
}
