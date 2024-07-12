package com.servlet;

import com.pojo.Apply;
import com.pojo.Menu;
import com.pojo.User;
import com.service.AppointService;
import com.service.Impl.AppointServiceImpl;
import com.util.*;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/appoint")
public class AppointServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return AppointServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","采购申请","获取界面所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/shoppingManage/appointmentOrder/appointList";
    }

    //获取所有采购申请信息
    public void getAllAppoint(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采用申请","获取所有采购申请信息");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,appointService.getAppointList(page,limit));
    }

    //删除采购申请
    public ResultData delAppoint(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采用申请","删除采购申请");
        String ids = request.getParameter("ids");
        System.out.println(ids.toString());
        int mId = Integer.parseInt(ids);
        int i = appointService.delAppoint(mId);
        return Result.resultStatus(i);
    }

    //采购申请
    public ResultData addAppoint(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","采用申请","提交采购申请");
        String[] idStr = request.getParameterValues("idsList");
        List<Integer> idList = Format.StringToInt(idStr);
        int i = appointService.addAppoint(idList);
        return Result.resultStatus(i);
    }

    //获取供应商
    public void getSupplier(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,appointService.getSupplier());
    }

    //获取药品类型
    public void getmType(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,appointService.getmType());
    }

    //获取药品名称
    public void getmName(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,appointService.getmName());
    }

    //条件查询所有预购表信息
    public void Search(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        String pageStr = request.getParameter("page");
        String limitStr = request.getParameter("limit");
        int page = Integer.parseInt(pageStr);
        int limit = Integer.parseInt(limitStr);
        logService.setLog(name,"查询","预购订单","查询预购订单表");
        String supplierName = request.getParameter("supplierName");
        String mTypeName = request.getParameter("mTypeName");
        String mNameName = request.getParameter("mNameName");
        Apply apply = new Apply();
        apply.setSupplier(supplierName);
        apply.setmType(mTypeName);
        apply.setmName(mNameName);
        page = (page-1)*limit;
        LayuiTable<Apply> search = appointService.Search(apply, page, limit);
        ToJSON.toJson(response,search);
    }
}