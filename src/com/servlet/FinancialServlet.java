package com.servlet;

import com.pojo.Menu;
import com.pojo.User;
import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.logService;
import static com.util.Vessel.menuService;

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
}
