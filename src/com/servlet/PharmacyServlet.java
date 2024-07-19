package com.servlet;


import com.pojo.Menu;
import com.pojo.Pharmacy;
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

@WebServlet("/pharmacy")
public class PharmacyServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return PharmacyServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","门诊管理","药师审查取药");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/outpatientManager/pharmacy/pharmacyList";
    }

    //获取所有按钮
    public String getMenuBtn1(HttpServletRequest request, HttpServletResponse response){
        int phId = Integer.parseInt(request.getParameter("phId"));
        int resId = 306;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","门诊管理","审查处方详情");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        session.setAttribute("phId",phId);
        return "medicine/outpatientManager/pharmacy/checkPharmacy";
    }

    //获取处方表
    public void getPharmacyList(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","门诊管理","获取处方表");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page - 1) * limit;
        LayuiTable<Pharmacy> layuiTable = pharmacyService.getPharmacyList(page,limit);
        ToJSON.toJson(response,layuiTable);
    }

    //处方审核
    public void Check(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int phId = (Integer)session.getAttribute("phId");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","门诊管理","审查处方详情");


    }
}
