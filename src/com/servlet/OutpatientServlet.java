package com.servlet;

import com.pojo.Menu;
import com.pojo.Patient;
import com.pojo.User;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public String getMenuBtn1(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","开处方","获取所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
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
        LayuiTable<Patient> patientList = outpatientService.getPatientList(page, limit, user);
        ToJSON.toJson(response,patientList);
    }
    //获取所有个人诊断患者
    public void Search(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        user.setUserName(name);
        logService.setLog(name,"查询","门诊管理","条件查看个人患者列表");

        String pIdStr = request.getParameter("pId");
        int pId = Integer.parseInt(pIdStr);
        String pName = request.getParameter("pName");
        String pSex = request.getParameter("pSex");
        String pAgeStr = request.getParameter("pAge");
        int pAge = Integer.parseInt(pAgeStr);
        String pWeightStr = request.getParameter("pWeight");
        double pWeight = Double.parseDouble(pWeightStr);
        String pAddress = request.getParameter("pAddress");
        String pPhone = request.getParameter("pPhone");
        String pAllergy = request.getParameter("pAllergy");
        String doctorAdvice = request.getParameter("doctorAdvice");
        String lastTime = request.getParameter("lastTime");

        Patient patient = new Patient();
        patient.setpId(pId);
        patient.setdId(user.getId());
        patient.setdName(pName);
        patient.setSex(pSex);
        patient.setAge(pAge);
        patient.setWeight(pWeight);
        patient.setAddress(pAddress);
        patient.setPhone(pPhone);
        patient.setAllergy(pAllergy);
        patient.setDoctorAdvice(doctorAdvice);
        patient.setdName(name);
        patient.setLastDiaTime(lastTime);

        ToJSON.toJson(response,outpatientService.Search(patient));



    }


}
