package com.servlet;


import com.pojo.echarts.GetString;
import com.pojo.echarts.Times;
import com.service.Impl.PharmaceuticalSalesServiceImpl;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


//药品销售
@WebServlet("/pharmaceuticalSales")
public class PharmaceuticalSalesServlet extends BaseServlet {
    PharmaceuticalSalesServiceImpl pharmaceuticalSalesService = new PharmaceuticalSalesServiceImpl();

    @Override
    public Class<?> getServlet() {
        return PharmaceuticalSalesServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/pharmaceuticalSales/pharmaceuticalSalesList";
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;

        ToJSON.toJson(response,pharmaceuticalSalesService.getAll(page,limit));
    }
    public ResultData<List<Times>> getAllDay(HttpServletRequest request, HttpServletResponse response){
        int day = Integer.parseInt(request.getParameter("day"));
        return pharmaceuticalSalesService.getAllDay(day);
    }
    public ResultData<List<GetString>> getChoise01(HttpServletRequest request, HttpServletResponse response){
        return pharmaceuticalSalesService.getChoise01();
    }

    public ResultData<List<GetString>> getChoise02(HttpServletRequest request, HttpServletResponse response){
        return pharmaceuticalSalesService.getChoise02();
    }
}
