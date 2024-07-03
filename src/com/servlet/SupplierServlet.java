package com.servlet;

import com.pojo.Menu;
import com.pojo.User;
import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.menuService;
@WebServlet("/supplier")
public class SupplierServlet extends BaseServlet {
    //获取供应商所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/infoManage/supplierManage/supplierList";
    }
    @Override
    public Class getServlet() {
        return SupplierServlet.class;
    }
}
