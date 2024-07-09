package com.servlet;

import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.User;
import com.service.Impl.ApprovalServiceImpl;
import com.service.Impl.UserServiceImpl;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/approval")
public class ApprovalServlet extends BaseServlet {
    ApprovalServiceImpl approvalService = new ApprovalServiceImpl();
    UserServiceImpl userService = new UserServiceImpl();
    @Override
    public Class<?> getServlet() {
        return ApprovalServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        List<User> applyUser = approvalService.getApplyUser();
        List<User> phaName = userService.getPhaName();
        List<User> finName = userService.getFinName();
        session.setAttribute("applyUser",applyUser);
        session.setAttribute("phaName",phaName);
        session.setAttribute("finName",finName);
        return "medicine/approveManage/purchaseApproval/purchaseList";
    }
    public void getAll(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,null);
    }
    public ResultData<List<Appointment>> getAuditId(HttpServletRequest request, HttpServletResponse response){
        int[] dataStrings = StringDeal.toArray(request.getParameter("dataString"));
        return approvalService.getAuditId(dataStrings);
    }
    public void search(HttpServletRequest request, HttpServletResponse response){
        String idValue = request.getParameter("idValue");
        int id = 0;
        String nameValue = request.getParameter("nameValue");
        String timeValue = request.getParameter("timeValue");
        String applyuser = request.getParameter("applyuser");
        String state = request.getParameter("state");
        String macuser = request.getParameter("macuser");
        String cw = request.getParameter("cw");
        if (!idValue.equals("")){
            id=Integer.parseInt(idValue);
        }
    }}
