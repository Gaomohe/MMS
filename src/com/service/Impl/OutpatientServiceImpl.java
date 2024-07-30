package com.service.Impl;

import com.dao.ApplyDao;
import com.dao.Impl.OutpatientDaoImpl;
import com.dao.OutpatientDao;
import com.dao.PatientDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.pojo.Log;
import com.pojo.Medicine;
import com.pojo.Patient;
import com.pojo.User;
import com.service.OutpatientService;
import com.util.*;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.util.Vessel.*;

public class OutpatientServiceImpl implements OutpatientService {
    OutpatientDaoImpl outpatientDaoImpl = new OutpatientDaoImpl();
    //获取病患列表
    @Override
    public LayuiTable<Patient> getPatientList(int page, int limit) {
        LayuiTable<Patient> layuiTable = new LayuiTable<>();
//        List<Patient> patientList = outpatientDao.getPatientList(page, limit);

        ResultSet resultSet = outpatientDaoImpl.getAll(page,limit,"patient");
        List<Patient> patientList = new ArrayList<Patient>();
        try{
            while (resultSet.next()) {
                Patient patient = new Patient();
                patient.setpId(resultSet.getInt(1));
                patient.setdId(resultSet.getInt(2));
                patient.setmId(resultSet.getInt(3));
                patient.setName(resultSet.getString(4));
                patient.setSex(resultSet.getString(5));
                patient.setAge(resultSet.getInt(6));
                patient.setWeight(resultSet.getInt(7));
                patient.setAddress(resultSet.getString(8));
                patient.setPhone(resultSet.getString(9));
                patient.setDiagnosticTime(resultSet.getString(10));
                patient.setAllergy(resultSet.getString(11));
                patient.setDoctorAdvice(resultSet.getString(12));
                patient.setdName(resultSet.getString(13));
                patient.setLastDiaTime(resultSet.getString(14));
                patient.setDisease(resultSet.getString(15));
                patientList.add(patient);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
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

    //单框查询药品
    @Override
    public LayuiTable<Medicine> searchMedicine(String search, int page, int limit) {
        PageHelper.startPage(page,limit);
        SqlSession session = BaseDao.getSqlSession();
        List<Medicine> list = session.getMapper(PatientDao.class).searchMedicine(search);
        LayuiTable<Medicine> layuiTable = new LayuiTable<>();
        layuiTable.setMsg("");
        layuiTable.setCode(200);
        layuiTable.setCount(list.size());
        layuiTable.setData(list);
        return layuiTable;
    }


}
