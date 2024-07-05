package com.servlet;

import com.pojo.Menu;
import com.pojo.User;
import com.service.AppointService;
import com.service.Impl.AppointServiceImpl;
import com.util.BaseServlet;
import com.util.Format;
import com.util.Result;
import com.util.ResultData;
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
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/shoppingManage/appointmentOrder/appointList";
    }

    public void getAllAppoint(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,appointService.getAppointList(page,limit));
    }

    public ResultData delAppoint(HttpServletRequest request, HttpServletResponse response){
        String ids = request.getParameter("ids");
        System.out.println(ids.toString());
        int mId = Integer.parseInt(ids);
        int i = appointService.delAppoint(mId);
        return Result.resultStatus(i);
    }

    public ResultData addAppoint(HttpServletRequest request, HttpServletResponse response){
        String[] idStr = request.getParameterValues("idsList");
        List<Integer> idList = Format.StringToInt(idStr);
        int i = appointService.addAppoint(idList);
        return Result.resultStatus(i);
    }
}