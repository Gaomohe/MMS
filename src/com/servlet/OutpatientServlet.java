package com.servlet;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pojo.*;
import com.util.*;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.util.Vessel.*;

@WebServlet("/patient")
public class OutpatientServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return OutpatientServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        logService.setLog(name,"点击","门诊管理","获取所有按钮");
        return "medicine/outpatientManager/outpatient/outpatientList";
    }


    //获取所有按钮
    public String getAddMenuBtn(HttpServletRequest request, HttpServletResponse response){
        String idStr = request.getParameter("pId");
        int thePId = Integer.parseInt(idStr);
        patientId = thePId;
        int resId = 180;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("thePId",thePId);
        session.setAttribute("menuList",menuList);
        logService.setLog(name,"点击","门诊管理","打开开处方界面");
        return "medicine/outpatientManager/outpatient/addMedicine";
    }

    //获取所有按钮
    public String getMenuBtn1(HttpServletRequest request, HttpServletResponse response){
        String mIdListStr = request.getParameter("mIdList");
        List<Integer> integers = new ArrayList<>();
        if (mIdListStr != null && !mIdListStr.isEmpty()) {
            String[] mIdListArray = mIdListStr.split(",");
            for (String idStr : mIdListArray) {
                integers.add(Integer.parseInt(idStr));
            }
        }
        intList = integers;
        int resId = 253;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","开处方","获取所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        session.setAttribute("integers",integers);
        return "medicine/outpatientManager/outpatient/medicineList";
    }

    //获取病患列表
    public void getPatientList(HttpServletRequest request, HttpServletResponse response){
        String limitStr = request.getParameter("limit");
        String pageStr = request.getParameter("page");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        user.setUserName(name);
        logService.setLog(name,"点击","开处方","查看个人患者列表");
        int page = Integer.parseInt(pageStr);
        int limit = Integer.parseInt(limitStr);
        page = (page - 1) * limit;
        LayuiTable<Patient> patientList = outpatientService.getPatientList(page, limit);
        try{
            String string = JSON.toJSONString(patientList);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取所有个人诊断患者
    /*public void Search(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        user.setUserName(name);
        logService.setLog(name,"查询","门诊管理","条件查看个人患者列表");

        String pIdStr = request.getParameter("pId");
        int pId = 0;
        if (pIdStr != null){
            pId = Integer.parseInt(pIdStr);
        }
        String pName = request.getParameter("pName");
        String pSex = request.getParameter("pSex");
        String pAgeStr = request.getParameter("pAge");
        int pAge = 0;
        if(pAgeStr != null && !pAgeStr.isEmpty()){
            pAge = Integer.parseInt(pAgeStr);
        }
        String pWeightStr = request.getParameter("pWeight");
        double pWeight = 0;
        if (pWeightStr != null){
            pWeight = Double.parseDouble(pWeightStr);
        }
        String pAddress = request.getParameter("pAddress");
        String pPhone = request.getParameter("pPhone");
        String pAllergy = request.getParameter("pAllergy");
        String doctorAdvice = request.getParameter("doctorAdvice");
        String lastTime = request.getParameter("lastTime");
        String disease = request.getParameter("disease");

        Patient patient = new Patient();
        patient.setpId(pId);
        patient.setdId(user.getId());
        patient.setName(pName);
        patient.setSex(pSex);
        patient.setAge(pAge);
        patient.setWeight(pWeight);
        patient.setAddress(pAddress);
        patient.setPhone(pPhone);
        patient.setAllergy(pAllergy);
        patient.setDoctorAdvice(doctorAdvice);
        patient.setdName(name);
        patient.setLastDiaTime(lastTime);
        patient.setDisease(disease);
        LayuiTable layuitable = outpatientService.Search(patient);
        ToJSON.toJson(response,layuitable);
    }*/
    public void Search(HttpServletRequest request, HttpServletResponse response) {
        // 获取所有请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 存储解析后的搜索条件
        Map<String, Object> searchCriteria = new HashMap<>();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();

            if (values != null && values.length > 0) {
                String value = values[0];
                try {
                    // 尝试将值解析为整数
                    int intValue = Integer.parseInt(value);
                    searchCriteria.put(key, intValue);
                } catch (NumberFormatException e1) {
                    try {
                        // 尝试将值解析为双精度浮点数
                        double doubleValue = Double.parseDouble(value);
                        searchCriteria.put(key, doubleValue);
                    } catch (NumberFormatException e2) {
                        // 如果无法解析为整数或双精度浮点数，默认将值作为字符串处理
                        searchCriteria.put(key, value);
                    }
                }
            }
        }

        // 输出解析后的搜索条件
        LayuiTable<Patient> layuiTable = patientService.selectPatient(searchCriteria);
        ToJSON.toJson(response,layuiTable);
    }


    //添加病患信息
    public ResultData addPatient(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        user.setUserName(name);
        logService.setLog(name,"添加","门诊管理","添加病患信息");

        String pName = request.getParameter("pName");
        String pSex = request.getParameter("pSex");
        String pAgeStr = request.getParameter("pAge");
        int pAge = 0;
        if(pAgeStr != null && !pAgeStr.isEmpty()){
            pAge = Integer.parseInt(pAgeStr);
        }
        String pWeightStr = request.getParameter("pWeight");
        double pWeight = 0;
        if (pWeightStr != null){
            pWeight = Double.parseDouble(pWeightStr);
        }
        String pAddress = request.getParameter("pAddress");
        String pPhone = request.getParameter("pPhone");
        String pAllergy = request.getParameter("pAllergy");
        String doctorAdvice = request.getParameter("doctorAdvice");
        String disease = request.getParameter("disease");
        String lastTime = request.getParameter("lastTime");

        Patient patient = new Patient();
        patient.setdId(user.getId());
        patient.setName(pName);
        patient.setSex(pSex);
        patient.setAge(pAge);
        patient.setWeight(pWeight);
        patient.setAddress(pAddress);
        patient.setPhone(pPhone);
        patient.setAllergy(pAllergy);
        patient.setDoctorAdvice(doctorAdvice);
        patient.setDisease(disease);
        patient.setdName(name);
        if (lastTime != null){
            patient.setLastDiaTime(lastTime);
        }
        int i = outpatientService.addPatient(patient);
        ResultData resultData = Result.resultStatus(i);
        return resultData;
    }

    //获取功效类型
    public void getmPower(HttpServletRequest request,HttpServletResponse response){
        List<Type> allGoodsType = typeService.getAllGoodsType();
        ToJSON.toJson(response,allGoodsType);
    }

    //获取药品类型
    public void getmType(HttpServletRequest request,HttpServletResponse response){
        List<Type> allMType = typeService.getAllMType();
        ToJSON.toJson(response,allMType);
    }

    //药品规格
    public void getUnit(HttpServletRequest request,HttpServletResponse response){
        List<Type> alldosage = typeService.getAlldosage();
        ToJSON.toJson(response,alldosage);
    }

    //门诊中医生查药
    public void getMedicineList(HttpServletRequest request,HttpServletResponse response){
        String mPower = request.getParameter("mPower");
        String mType = request.getParameter("mType");
        String unit = request.getParameter("Unit");
        String mName = request.getParameter("mName");

        Medicine medicine = new Medicine();
        medicine.setGoodsType(mPower);
        medicine.setUnit(unit);
        medicine.setmType(mType);
        medicine.setmName(mName);

        LayuiTable<Medicine> medicineList = outpatientService.getMedicineList(medicine);
        ToJSON.toJson(response,medicineList);

    }


    //病患信息回显
    public void getPatientInfo(HttpServletRequest request,HttpServletResponse response){
        String pIdSre = request.getParameter("pId");
        int pId = Integer.parseInt(pIdSre);
        Patient patient = outpatientService.backValues(pId);
        ToJSON.toJson(response,patient);
    }

    /*//开处方（添加处方）
    public ResultData addMedicine(HttpServletRequest request,HttpServletResponse response){
        String[] mIdLists = request.getParameterValues("mIdList");
        List<Integer> integers = Format.StringToInt(mIdLists);
        String pIdStr = request.getParameter("pId");
        int pId = Integer.parseInt(pIdStr);
        int i = outpatientService.addMedicine(pId, integers);
        ResultData resultData = Result.resultStatus(i);
        return resultData;
    }*/

    //回显已选药品
    public void getPatientMedicine(HttpServletRequest request ,HttpServletResponse response){
        String pageStr = request.getParameter("page");
        int page = Integer.parseInt(pageStr);
        String limitStr = request.getParameter("limit");
        int limit = Integer.parseInt(limitStr);
        page = (page - 1) * limit;
        LayuiTable<Medicine> patientMedicine = outpatientService.getPatientMedicine(intList,page,limit);
        ToJSON.toJson(response,patientMedicine);
    }


    //确认开处方
    public ResultData submit(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        user.setUserName(name);
        logService.setLog(name,"点击","开处方","确认开处方");

        int thePId = (Integer)session.getAttribute("thePId");

        StringBuilder jsonBuffer = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = jsonBuffer.toString();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> priceList = null;
        try {
            priceList = mapper.readValue(jsonString, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Medicine> medicineList = new ArrayList<>();
        if (priceList != null) {
            for (Map.Entry<String, String> entry : priceList.entrySet()) {
                Medicine medicine = new Medicine();
                String keyStr = entry.getKey();
                String valueStr = entry.getValue();
                int Key = Integer.parseInt(keyStr);
                int Value = Integer.parseInt(valueStr);
                medicine.setmId(Key);
                medicine.setNumber(Value);
                medicineList.add(medicine);
            }
        }

        int i = outpatientService.addMedicine(thePId,medicineList);
        ResultData resultData = Result.resultStatus(i);
        return resultData;
    }

    public void searchMedicine(HttpServletRequest request,HttpServletResponse response){
        String searchData = request.getParameter("inputVal");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        System.out.println(searchData);
        // 输出解析后的搜索条件
        LayuiTable<Medicine> layuiTable = outpatientService.searchMedicine(searchData,page,limit);
        ToJSON.toJson(response,layuiTable);
    }

}
