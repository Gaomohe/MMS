package com.servlet;


import com.pojo.StockInForm;
import com.pojo.echarts.GetString;
import com.pojo.echarts.Sale;
import com.pojo.echarts.Times;
import com.service.Impl.PrescriptionSalesServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


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
    public ResultData<List<Times>> getAllDay(HttpServletRequest request, HttpServletResponse response){
        int day = Integer.parseInt(request.getParameter("day"));
        return prescriptionSalesService.getAllDay(day);
    }
    public ResultData<List<GetString>> getChoise01(HttpServletRequest request, HttpServletResponse response){
        return prescriptionSalesService.getChoise01();
    }

    public ResultData<List<GetString>> getChoise02(HttpServletRequest request, HttpServletResponse response){
        return prescriptionSalesService.getChoise02();
    }
    public void search(HttpServletRequest request, HttpServletResponse response){
        String inputValue = request.getParameter("inputValue");
        String[] keys = {"mName"};
        String[] values = {inputValue};

        LayuiTable<Sale> search = prescriptionSalesService.search(keys, values);
        ToJSON.toJson(response,search);
    }
}
