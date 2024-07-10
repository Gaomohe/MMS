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
        String nameValue = request.getParameter("nameValue");
        String timeValue = request.getParameter("timeValue");
        String applyuser = request.getParameter("applyuser");
        String state = request.getParameter("state");
        String macuser = request.getParameter("macuser");
        String cw = request.getParameter("cw");
        String[] values = {idValue,nameValue,timeValue,applyuser,state,macuser,cw};
        String[] keys = {"applyId","mName","applyTime","applyUser","pharmacistApprove","pharmacist","finance"};
        ToJSON.toJson(response,approvalService.search(keys,values));
    }
    public ResultData<Integer> del(HttpServletRequest request, HttpServletResponse response){
        String dataString = request.getParameter("dataString");
        int[] ints = StringDeal.toArray(dataString);
        return approvalService.del(ints);
    }

    public ResultData<Integer> isok(HttpServletRequest request, HttpServletResponse response){
        String dataString = request.getParameter("dataString");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String userName = userService.getUserName(user.getId());
        int[] ints = StringDeal.toArray(dataString);
        return approvalService.isok(ints,userName);
    }
    public ResultData<Integer> submit(HttpServletRequest request, HttpServletResponse response){
        String dataString = request.getParameter("dataString");
        String textareaValue = request.getParameter("textareaValue");
        int[] ints = StringDeal.toArray(dataString);
        return approvalService.nook(ints);

    }

}
