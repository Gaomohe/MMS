package com.servlet;


import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//医疗器械入库
@WebServlet("/medicalDevices")
public class MedicalDevices extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return MedicalDevices.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/medicalDevices/medicalDevicesList";
    }
}
