package com.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.Log;
import com.pojo.Medicine;
import com.pojo.Patient;
import com.pojo.User;
import com.service.OutpatientService;
import com.util.GetTime;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.SQLtoString;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.util.Vessel.*;

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

    //条件查询药品列表
    @Override
    public LayuiTable<Medicine> getMedicineList(Medicine medicine) {
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        String[] keys = {"goodsType","mType","unit"};
        Object[] values = {medicine.getGoodsType(),medicine.getmType(),medicine.getUnit()};
        String sql = SQLtoString.setSQL(keys, values, "dictionary");
        if (medicine.getmName() != null && medicine.getmType() != null || medicine.getUnit() != null || medicine.getGoodsType()!=null){
            sql += " and mName LIKE %" + medicine.getmName() +"%";
        }
        if (medicine.getmName() != null && medicine.getmType() == null && medicine.getUnit() == null && medicine.getGoodsType()==null){
            sql += " where mName LIKE '%" + medicine.getmName() +"%'";
        }
        List<Medicine> medicineList = outpatientDao.getMedicineList(sql);
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(medicineCount);
        layuiTable.setData(medicineList);
        return layuiTable;
    }

    //回显病患信息
    @Override
    public Patient backValues(int id) {
        Patient patient = new Patient();
        patient.setDiagnosticTime(GetTime.getTime());
        return outpatientDao.backValues(id);
    }

    //开处方
    @Override
    public int addMedicine(int pId, List<Medicine> medicineList) {
        int i = outpatientDao.addmOrder(pId);
        int orderId = outpatientDao.getOrderId();
        int update = outpatientDao.updatemIdtoPatient(orderId, pId);
        int add = 0;
        int addup = 0;
        for (Medicine medicine : medicineList) {
             add = outpatientDao.addMedicine(orderId, medicine);
             medicine.setTableCoding(medicine.getmId());
            addup = medicineService.updateMedicineNumber(medicine, medicine.getNumber(), pId);
        }
        return add;
    }

    //已选中药品回显
    @Override
    public LayuiTable<Medicine> getPatientMedicine(List<Integer> mIdList,int page,int limit) {
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        List<Medicine> medicineList = new ArrayList<>();
        // 在渲染药品列表时，生成唯一的name属性
        for (int mId : mIdList) {
            Medicine medicine = outpatientDao.getPatientMedicine(mId);
            medicine.setUpdate("<div class=\"layui-input-inline\" style=\"width: 100px;\">\n" +
                    "     <input type=\"number\" name=\"price_min" + mId + "\" placeholder=\"\" autocomplete=\"off\" class=\"layui-input\" min=\"0\" step=\"1\" id=\"price_min" + mId + "\" lay-affix=\"number\">\n" +
                    "</div>");
            medicineList.add(medicine);
        }
        layuiTable.setMsg("");
        layuiTable.setCode(0);
        layuiTable.setCount(medicineList.size());
        layuiTable.setData(medicineList);

        return layuiTable;
    }


}
