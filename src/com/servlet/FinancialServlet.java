package com.servlet;

import com.pojo.Apply;
import com.pojo.Menu;
import com.pojo.User;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/financial")
public class FinancialServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return FinancialServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        logService.setLog("打开页面","打开","财务审批");
        return "medicine/approveManage/financialApproval/financialApprovalList";
    }

    //条件查询
    public void Search(HttpServletRequest request, HttpServletResponse response){
        String limitStr = request.getParameter("limit");
        String pageStr = request.getParameter("page");
        int limit = Integer.parseInt(limitStr);
        int page = Integer.parseInt(pageStr);
        String applyCode = request.getParameter("applyCode");
        int applyId =0;
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
        apply.setApplyId(applyId);
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
}
