package com.servlet;

import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reportProcure")
public class ReportFormsServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return ReportFormsServlet.class;
    }
public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){

        return "medicine/GSPReportFormsManage/reportProcure/reportProcureList";
}

}
