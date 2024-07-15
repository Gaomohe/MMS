package com.servlet;

import com.service.Impl.BillServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bill")
public class BillServlet extends BaseServlet {
    BillServiceImpl billService = new BillServiceImpl();
    @Override
    public Class<?> getServlet() {
        return BillServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/financeManage/bill/financeList01";
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        LayuiTable<String> stringLayuiTable = new LayuiTable<String>();
        List<String> list = new ArrayList<>();
        stringLayuiTable.setMsg("");
        stringLayuiTable.setCount(0);
        stringLayuiTable.setData(list);
        ToJSON.toJson(response,stringLayuiTable);
    }
    public void search(HttpServletRequest request, HttpServletResponse response){
        String nameElement = request.getParameter("nameElement");
        String idElement = request.getParameter("idElement");
        String supplyElement = request.getParameter("supplyElement");
        String operaElement = request.getParameter("operaElement");
        String financeElement = request.getParameter("financeElement");
        String startElement = request.getParameter("startElement");
        String endElement = request.getParameter("endElement");
        String accountElement = request.getParameter("accountElement");
        String stateElement = request.getParameter("stateElement");
        String kindElement = request.getParameter("kindElement");
        String[] keys = {"nameElement","idElement","supplyElement","operaElement","financeElement","startElement","endElement","accountElement","stateElement","kindElement"};
        String[] values = {nameElement,idElement,supplyElement,operaElement,financeElement,startElement,endElement,accountElement,stateElement,kindElement};
        List<String[]> twoNotEmpty = StringDeal.getTwoNotEmpty(keys, values);

    }
    public ResultData<Integer>  del(HttpServletRequest request, HttpServletResponse response){
        String dataString = request.getParameter("dataString");
        return billService.del(StringDeal.toArray(dataString));
    }


}
