package com.servlet;

import com.pojo.User;
import com.util.BaseServlet;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.util.Vessel.userService;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
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
        ResultData resultData = new ResultData();
        resultData = Result.resultStatus(login);
        return resultData;
    }
}
