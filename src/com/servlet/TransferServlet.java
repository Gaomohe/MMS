package com.servlet;

import com.pojo.Transfer;
import com.service.Impl.BillServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


@WebServlet("/transfer")
public class TransferServlet extends BaseServlet {
    BillServiceImpl billService = new BillServiceImpl();
    @Override
    public Class<?> getServlet() {
        return TransferServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List<Transfer> finance2 = billService.getFinance2();
        List<Transfer> account2 = billService.getAccount2();
        session.setAttribute("finance2",finance2);
        session.setAttribute("account2",account2);

        return "medicine/financeManage/transfer/transferList";
    }
    public void search_transfer(HttpServletRequest request, HttpServletResponse response){
        String timeElement = request.getParameter("timeElement");
        String idElement = request.getParameter("idElement");
//        String nameElement = request.getParameter("nameElement");

        String financeElement = request.getParameter("financeElement");
        String supplyElement = request.getParameter("supplyElement");
        String[] keys = {"financeTime","applyId","finance","supplier"};
        String[] values = {timeElement,idElement,financeElement,supplyElement};
        List<String[]> twoNotEmpty = StringDeal.getTwoNotEmpty(keys, values);
        LayuiTable<Transfer> transferLayuiTable = billService.search_transfer(twoNotEmpty.get(0), twoNotEmpty.get(1));

        ToJSON.toJson(response,transferLayuiTable);
    }
    public void getAllTransfer(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,billService.getAllTransfer(page,limit));
    }


}
