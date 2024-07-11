package com.servlet;

import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.Sub_Apply;
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

import static com.util.Vessel.logService;
import static com.util.Vessel.userService;

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
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采购审批","获取所有采购申请信息");
        int[] dataStrings = StringDeal.toArray(request.getParameter("dataString"));
        return approvalService.getAuditId(dataStrings);
    }
    public void search(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采购审批","条件查询审批信息");
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
    //删除审批信息
    public ResultData<Integer> del(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采购审批","删除审批信息");
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

    //提交审批结果
    public ResultData<Integer> submit(HttpServletRequest request, HttpServletResponse response){
        String dataString = request.getParameter("dataString");
        String textareaValue = request.getParameter("textareaValue");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","采购审批","提交审批结果");
        String userName = userService.getUserName(user.getId());
        int[] ints = StringDeal.toArray(dataString);
        return approvalService.nook(ints,userName);

    }
    public ResultData<Integer> noaudit(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采购审批","反审批");
        String dataString = request.getParameter("dataString");
        int[] ints = StringDeal.toArray(dataString);
        return null;
    }
    public ResultData<List<Apply>> getHistory(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采购审批","获取审批历史记录");
        return approvalService.getHistory();
    }

}
