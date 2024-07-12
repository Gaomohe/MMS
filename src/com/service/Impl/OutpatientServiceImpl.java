package com.service.Impl;

import com.pojo.Patient;
import com.pojo.User;
import com.service.OutpatientService;
import com.util.LayuiTable;

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

    @Override
    public List<Patient> Search(Patient patient) {
        String[] keys = {"name","sex","age","age","weight","address","phone","diagnosticTime","allergy","doctorAdvice","dName","lastDiaTime"};

        return Collections.emptyList();
    }
}
