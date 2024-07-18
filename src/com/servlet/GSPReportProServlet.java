package com.servlet;

import com.pojo.Appointment;
import com.pojo.echarts.GSPSupply;
import com.pojo.echarts.GetString;
import com.pojo.echarts.Times;
import com.service.Impl.GSPReportProServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/gspReport")
public class GSPReportProServlet extends BaseServlet {
    GSPReportProServiceImpl gspReportProService = new GSPReportProServiceImpl();
    @Override
    public Class<?> getServlet() {
        return GSPReportProServlet.class;
    }

    public ResultData<List<Times>> getll(HttpServletRequest request, HttpServletResponse response){
        int day = Integer.parseInt(request.getParameter("day"));
        return gspReportProService.reTimes(day);
    }
    public ResultData<List<GSPSupply>> getAllSup(HttpServletRequest request, HttpServletResponse response){
        return gspReportProService.getAllSup();
    }
    public ResultData<List<GetString>> getChoise01(HttpServletRequest request, HttpServletResponse response){
        return gspReportProService.getChoise01();
    }
    public ResultData<List<GetString>> getChoise02(HttpServletRequest request, HttpServletResponse response){
        return gspReportProService.getChoise02();
    }
    public ResultData<List<GetString>> getChoise03(HttpServletRequest request, HttpServletResponse response){
        return null;
    }
    public void search(HttpServletRequest request, HttpServletResponse response){
        String inputValue = request.getParameter("inputValue");
        String[] keys = {"mName"};
        String[] values = {inputValue};
        LayuiTable<Appointment> search = gspReportProService.search(keys, values);
        ToJSON.toJson(response,search);
    }
}
