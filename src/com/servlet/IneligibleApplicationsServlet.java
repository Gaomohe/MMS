package com.servlet;

import com.service.Impl.IneligibleApplicationsServiceImpl;
import com.util.BaseServlet;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//不合格申请报表
@WebServlet("/ineligibleApplications")
public class IneligibleApplicationsServlet extends BaseServlet {
    IneligibleApplicationsServiceImpl ineligibleApplicationsService = new IneligibleApplicationsServiceImpl();
    @Override
    public Class<?> getServlet() {
        return IneligibleApplicationsServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/ineligibleApplications/ineligibleApplicationsList";
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,ineligibleApplicationsService.getAll(page,limit));


    }
}
