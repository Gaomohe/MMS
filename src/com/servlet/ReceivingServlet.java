package com.servlet;


import com.pojo.StockInForm;
import com.pojo.echarts.GetString;
import com.pojo.echarts.Times;
import com.service.Impl.ReceivingServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/receiving")
public class ReceivingServlet extends BaseServlet {

    ReceivingServiceImpl receivingService = new ReceivingServiceImpl();
    @Override
    public Class<?> getServlet() {
        return ReceivingServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/receiving/receivingList";
    }
    public ResultData<List<Times>> getAll(HttpServletRequest request, HttpServletResponse response){
        int day = Integer.parseInt(request.getParameter("day"));
        System.out.println("hello");
        return receivingService.getAll(day);
    }
    public ResultData<List<GetString>> getChoise01(HttpServletRequest request, HttpServletResponse response){
        return receivingService.getChoise01();
    }

    public ResultData<List<GetString>> getChoise02(HttpServletRequest request, HttpServletResponse response){
        return receivingService.getChoise02();
    }
    public void search(HttpServletRequest request, HttpServletResponse response){
        String inputValue = request.getParameter("inputValue");
        String[] keys = {"mName"};
        String[] values = {inputValue};
        LayuiTable<StockInForm> search = receivingService.search(keys, values);
        ToJSON.toJson(response,search);
    }
}
