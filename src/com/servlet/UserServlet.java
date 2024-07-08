package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Menu;
import com.pojo.User;
import com.service.Impl.UserServiceImpl;
import com.util.*;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
import java.util.List;

import static com.util.Vessel.menuService;
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
    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/infoManage/userManage/userList";
    }

    //删除一个人
    public ResultData delUser(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        return userService.delUser(id);
    }

    public ResultData allUserByUserid(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("userid"));
        return userService.allUserByUserid(id);
    }

    public ResultData allRole(HttpServletRequest request, HttpServletResponse response){
        return userService.allRole();
    }

    public ResultData queryUserIsRole(HttpServletRequest request, HttpServletResponse response){
        return userService.queryUserIsRole(Integer.parseInt(request.getParameter("userid")));
    }

    public ResultData doUpdateUser(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setUserName(request.getParameter("name"));
        user.setPassword(request.getParameter("pass"));
        user.setTelNumber(request.getParameter("telNumber"));
        user.setAddress(request.getParameter("address"));
        user.setSex(request.getParameter("sex"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setBirthday(request.getParameter("birthday"));
        user.setCreateDate(request.getParameter("createDate"));
        user.setWechat(request.getParameter("wechat"));
        return userService.doUpdateUser(user);
    }

    public ResultData isUname(HttpServletRequest request, HttpServletResponse response){
        return userService.isUname(request.getParameter("uname"));
    }

    public ResultData addUser(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        user.setUserName(request.getParameter("name"));
        user.setPassword(request.getParameter("pass"));
        user.setTelNumber(request.getParameter("telNumber"));
        user.setAddress(request.getParameter("address"));
        user.setSex(request.getParameter("sex"));
        user.setAge(Integer.parseInt(request.getParameter("age")));
        user.setBirthday(request.getParameter("birthday"));
        user.setCreateDate(request.getParameter("createDate"));
        user.setWechat(request.getParameter("wechat"));
        return userService.addUser(user);
    }

    //申请人姓名回显
    public void getAppUser(HttpServletRequest request, HttpServletResponse response){
        List<User> userList = userService.getAppUser();
        ToJSON.toJson(response,userList);
    }

    //药师姓名的回显
    public void getPhaName(HttpServletRequest request, HttpServletResponse response){
        List<User> userList = userService.getPhaName();
        ToJSON.toJson(response,userList);
    }

    //财务姓名的回显
    public void getFinName(HttpServletRequest request, HttpServletResponse response){
        List<User> userList = userService.getFinName();
        ToJSON.toJson(response,userList);
    }
}
