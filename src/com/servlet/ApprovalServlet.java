package com.servlet;

import com.util.BaseServlet;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/approval")
public class ApprovalServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return ApprovalServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/approveManage/purchaseApproval/purchaseList";
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,null);
    }

}
