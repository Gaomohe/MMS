package com.servlet;

import com.pojo.echarts.GetString;
import com.pojo.echarts.Times;
import com.service.Impl.IneligibleApplicationsServiceImpl;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public ResultData<List<Times>> getllDay(HttpServletRequest request, HttpServletResponse response){
        int day = Integer.parseInt(request.getParameter("day"));
        return ineligibleApplicationsService.getAllDay(day);
    }
    public ResultData<List<GetString>> getChoise01(HttpServletRequest request, HttpServletResponse response){
        return ineligibleApplicationsService.getChoise01();
    }

    public ResultData<List<GetString>> getChoise02(HttpServletRequest request, HttpServletResponse response){
        return ineligibleApplicationsService.getChoise02();
    }
}
