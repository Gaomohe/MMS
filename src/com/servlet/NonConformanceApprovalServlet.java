package com.servlet;


import com.service.Impl.NonConformanceApprovalServiceImpl;
import com.util.BaseServlet;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//不合格审批
@WebServlet("/nonConformanceApproval")
public class NonConformanceApprovalServlet extends BaseServlet {
    NonConformanceApprovalServiceImpl nonConformanceApprovalService = new NonConformanceApprovalServiceImpl();
    @Override
    public Class<?> getServlet() {
        return NonConformanceApprovalServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/nonConformanceApproval/nonConformanceApprovalList";
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,nonConformanceApprovalService.getAll(page,limit));
    }
}
