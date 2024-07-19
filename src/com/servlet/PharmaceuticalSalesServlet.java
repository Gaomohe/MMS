package com.servlet;


import com.service.Impl.PharmaceuticalSalesServiceImpl;
import com.util.BaseServlet;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
}
