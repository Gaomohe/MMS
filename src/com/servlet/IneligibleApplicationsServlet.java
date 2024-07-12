package com.servlet;

import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//不合格申请报表
@WebServlet("/ineligibleApplications")
public class IneligibleApplicationsServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return IneligibleApplicationsServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/ineligibleApplications/ineligibleApplicationsList";
    }
}
