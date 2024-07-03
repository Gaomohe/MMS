package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.service.Impl.UserServiceImpl;
import com.util.*;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

import static com.util.Vessel.userService;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public Class getServlet() {
        return UserServlet.class;
    }

    //登录
    public ResultData Login(HttpServletRequest request, HttpServletResponse response) {
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        String password = request.getParameter("password");
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        int login = 0;
        login = userService.login(user);
        if (login > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
        }
        ResultData resultData = new ResultData();
        resultData = Result.resultStatus(login);
        return resultData;
    }
    public void getAllUser(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,userService.getAllUser(page,limit));
    }
}
