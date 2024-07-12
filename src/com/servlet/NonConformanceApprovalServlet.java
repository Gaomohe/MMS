package com.servlet;


import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//不合格审批
@WebServlet("/nonConformanceApproval")
public class NonConformanceApprovalServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return NonConformanceApprovalServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/nonConformanceApproval/nonConformanceApprovalList";
    }
}
