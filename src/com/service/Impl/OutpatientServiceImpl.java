package com.service.Impl;

import com.pojo.Log;
import com.pojo.Patient;
import com.pojo.User;
import com.service.OutpatientService;
import com.util.GetTime;
import com.util.LayuiTable;
import com.util.SQLtoString;

import java.util.Collections;
import java.util.List;

import static com.util.Vessel.outpatientDao;

public class OutpatientServiceImpl implements OutpatientService {
    //获取病患列表
    @Override
    public LayuiTable<Patient> getPatientList(int page, int limit, User user) {
        LayuiTable<Patient> layuiTable = new LayuiTable<>();
        List<Patient> patientList = outpatientDao.getPatientList(page, limit, user);
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(patientList.size());
        layuiTable.setData(patientList);
        return layuiTable;
    }

    //条件查询所有病人列表
    @Override
    public LayuiTable<Patient> Search(Patient patient) {
        String sql = "";
        if (patient.getpId() == 0){
            String[] keys = {"name","sex","age","age","address","phone","allergy","doctorAdvice","dName","lastDiaTime"};
            Object[] values = {patient.getName(),patient.getSex(),patient.getAge(),patient.getAddress(),patient.getPhone(),patient.getAllergy(),patient.getDoctorAdvice(),patient.getdName(),patient.getLastDiaTime()};
            sql = SQLtoString.getSQL(keys,values,"patient");
        }else if(patient.getpId() > 0){
            String[] keys = {"pId","name","sex","address","phone","allergy","doctorAdvice","dName","lastDiaTime"};
            Object[] values = {patient.getpId(),patient.getName(),patient.getSex(),patient.getAddress(),patient.getPhone(),patient.getAllergy(),patient.getDoctorAdvice(),patient.getdName(),patient.getLastDiaTime()};
            sql = SQLtoString.getSQL(keys,values,"patient");
        }
        List<Patient> patientList = outpatientDao.Search(sql);
        LayuiTable<Patient> layuiTable = new LayuiTable<>();
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(patientList.size());
        layuiTable.setData(patientList);


        return layuiTable;
    }

    //添加患者信息
    @Override
    public int addPatient(Patient patient) {
        patient.setDiagnosticTime(GetTime.getTime());
        return outpatientDao.addPatient(patient);
    }
}
