package com.servlet;

import com.pojo.Advance;
import com.pojo.Income;
import com.pojo.Spend;
import com.pojo.Transfer;
import com.service.Impl.BillServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = request.getSession();
//        //供应商
        List<Income> supply1 = billService.getSupply1();
        List<Spend> supply2 = billService.getSupply2();
        List<Advance> supply3 = billService.getSupply3();
        session.setAttribute("supply1",supply1);
        session.setAttribute("supply2",supply2);
        session.setAttribute("supply3",supply3);

        //财务人员





        return "medicine/financeManage/bill/financeList01";
    }

    //初始化一些东西
    public ResultData<Integer> Init(HttpServletRequest request, HttpServletResponse response){
        ResultData<Integer> integerResultData = new ResultData<>();

//
//
//        //操作员
//        List<?> opera1 = billService.getOpera1();
//        session.setAttribute("opera1",opera1);
//
//        //财务人员
//        List<?> finance1 = billService.getFinance1();
//        session.setAttribute("finance1",finance1);
//
//
//
//        //账户
//        List<?> account1 = billService.getAccount1();
//        session.setAttribute("account1",account1);




        integerResultData.setStatus(200);
        return integerResultData;
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
    public void search01(HttpServletRequest request, HttpServletResponse response){
        String nameElement = request.getParameter("nameElement");
        String idElement = request.getParameter("idElement");
        String supplyElement = request.getParameter("supplyElement");
        String startElement = request.getParameter("startElement");
//        String endElement = request.getParameter("endElement");
        String[] keys = {"mName","orderId","supplier","diagnosticTime"};
        String[] values = {nameElement,idElement,supplyElement,startElement};
        List<String[]> twoNotEmpty = StringDeal.getTwoNotEmpty(keys, values);
        LayuiTable<Income> incomeLayuiTable = billService.search01(twoNotEmpty.get(0), twoNotEmpty.get(1));
        ToJSON.toJson(response,incomeLayuiTable);
    }

    public ResultData<Integer>  del(HttpServletRequest request, HttpServletResponse response){
        String dataString = request.getParameter("dataString");
        return billService.del(StringDeal.toArray(dataString));
    }

    public void getAllIncome(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,billService.getAllIncome());
    }

    public void getAllSpend(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,billService.getAllSpend(page,limit));
    }
    public void getAllAdvance(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,billService.getAllAdvance(page,limit));
    }

    public void search02(HttpServletRequest request, HttpServletResponse response){
        String nameElement = request.getParameter("nameElement");
        String idElement = request.getParameter("idElement");
        String supplyElement = request.getParameter("supplyElement");
//        String startElement = request.getParameter("startElement");
//        String endElement = request.getParameter("endElement");
        String[] keys = {"mName","oId","supplier"};
        String[] values = {nameElement,idElement,supplyElement};
        List<String[]> twoNotEmpty = StringDeal.getTwoNotEmpty(keys, values);
        LayuiTable<Spend> spendLayuiTable = billService.search02(twoNotEmpty.get(0), twoNotEmpty.get(1));
        ToJSON.toJson(response,spendLayuiTable);
    }
    public void search03(HttpServletRequest request, HttpServletResponse response){
        String nameElement = request.getParameter("nameElement");
        String idElement = request.getParameter("idElement");
        String supplyElement = request.getParameter("supplyElement");
//        String startElement = request.getParameter("startElement");
//        String endElement = request.getParameter("endElement");
        String[] keys = {"mName","oId","supplier"};
        String[] values = {nameElement,idElement,supplyElement};
        List<String[]> twoNotEmpty = StringDeal.getTwoNotEmpty(keys, values);
        LayuiTable<Advance> advanceLayuiTable = billService.search03(twoNotEmpty.get(0), twoNotEmpty.get(1));
        ToJSON.toJson(response,advanceLayuiTable);
    }





}
