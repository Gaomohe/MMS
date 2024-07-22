package com.servlet;

import com.pojo.Menu;
import com.pojo.User;
import com.pojo.Warn;
import com.util.BaseServlet;
import com.util.LayuiTable;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;


@WebServlet("/warning")
public class WarnServlet extends BaseServlet {

    @Override
    public Class getServlet() {
        return WarnServlet.class;
    }

    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","临期预警","获取界面所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "界面";
    }

    //获取所有Warn值
    public LayuiTable<Warn> getWarnAll(HttpServletRequest request,HttpServletResponse response){
        return null;
    }

}
