package com.servlet;

import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.Menu;
import com.pojo.User;
import com.service.Impl.ApprovalServiceImpl;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;
import com.util.init.StringDeal;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/financial")
public class FinancialServlet extends BaseServlet {
    ApprovalServiceImpl approvalService = new ApprovalServiceImpl();
    @Override
    public Class getServlet() {
        return FinancialServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        logService.setLog(name,"打开","财务审批","获取所有按钮");
        return "medicine/approveManage/financialApproval/financialApprovalList";
    }

    //条件查询
    public void Search(HttpServletRequest request, HttpServletResponse response){
        String limitStr = request.getParameter("limit");
        String pageStr = request.getParameter("page");
        int limit = Integer.parseInt(limitStr);
        int page = Integer.parseInt(pageStr);
        String applyCode = request.getParameter("applyCode");
        int applyId = 0;
        if (applyCode != null && !applyCode.trim().isEmpty()) {
            applyId = Integer.parseInt(applyCode);
        }

        String mName = request.getParameter("mName");
        String applyTime = request.getParameter("applyTime");
        String status = request.getParameter("status");
        String applyName = request.getParameter("applyName");
        String phaName = request.getParameter("phaName");
        String finName = request.getParameter("finName");

        Apply apply = new Apply();
        if (applyId > 0){
            apply.setApplyId(applyId);
        }
        System.out.println(apply.getApplyId());
        apply.setmName(mName != null ? mName : "");
        apply.setApplyTime(applyTime != null ? applyTime : "");
        apply.setFinanceApprove(status != null ? status : "");
        apply.setApplyUser(applyName != null ? applyName : "");
        apply.setPharmacist(phaName != null ? phaName : "");
        apply.setFinance(finName != null ? finName : "");

        page = (page-1)*limit;
        ToJSON.toJson(response,financialService.getAppointList(limit, page, apply));
        System.out.println("ssssssssss");
    }

    //删除申请
    public ResultData delApply(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("ids"));
        int i = financialService.delApply(id);
        ResultData resultData = new ResultData();
        resultData = Result.resultStatus(i);
        return resultData;
    }

    //获取批准全部信息
    public ResultData<List<Appointment>> getApproveById(HttpServletRequest request, HttpServletResponse response){
        int[] dataStrings = StringDeal.toArray(request.getParameter("dataString"));
        ResultData<List<Appointment>> resultData = new ResultData();
        resultData = approvalService.getAuditId(dataStrings);
        return resultData;
    }

    //财务审核
    public ResultData setApply(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        ResultData resultData = new ResultData();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int i = financialService.setApply(id,user);
        resultData = Result.resultStatus(i);
        return resultData;
    }

    //财务反审核
    public ResultData setUnApprove(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        ResultData resultData = new ResultData();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int i = financialService.setUnApprove(id,user);
        resultData = Result.resultStatus(i);
        return resultData;
    }
}
