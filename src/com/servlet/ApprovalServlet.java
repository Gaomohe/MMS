package com.servlet;

import com.pojo.Apply;
import com.pojo.Appointment;
import com.service.Impl.ApprovalServiceImpl;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/approval")
public class ApprovalServlet extends BaseServlet {
    ApprovalServiceImpl approvalService = new ApprovalServiceImpl();
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
    public ResultData<List<Appointment>> getAuditId(HttpServletRequest request, HttpServletResponse response){
        int[] dataStrings = StringDeal.toArray(request.getParameter("dataString"));
        return approvalService.getAuditId(dataStrings);
    }
}
