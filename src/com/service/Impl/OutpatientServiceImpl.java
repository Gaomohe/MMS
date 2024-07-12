package com.service.Impl;

import com.pojo.Patient;
import com.pojo.User;
import com.service.OutpatientService;
import com.util.LayuiTable;

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
}
