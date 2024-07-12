package com.servlet;


import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//药品销售
@WebServlet("/pharmaceuticalSales")
public class PharmaceuticalSalesServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return PharmaceuticalSalesServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/pharmaceuticalSales/pharmaceuticalSalesList";
    }
}
