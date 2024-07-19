package com.servlet;


import com.service.Impl.PrescriptionSalesServiceImpl;
import com.util.BaseServlet;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//处方销售记录
@WebServlet("/prescriptionSales")
public class PrescriptionSalesServlet extends BaseServlet {
    PrescriptionSalesServiceImpl prescriptionSalesService = new PrescriptionSalesServiceImpl();
    @Override
    public Class<?> getServlet() {
        return PrescriptionSalesServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/prescriptionSales/prescriptionSalesList";
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,prescriptionSalesService.getAll(page,limit));
    }
}
