package com.servlet;

import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bill")
public class BillServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return BillServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/financeManage/bill/financeList";
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        LayuiTable<String> stringLayuiTable = new LayuiTable<String>();
        List<String> list = new ArrayList<>();
        stringLayuiTable.setMsg("");
        stringLayuiTable.setCount(0);
        stringLayuiTable.setData(list);
        ToJSON.toJson(response,stringLayuiTable);
    }

}
