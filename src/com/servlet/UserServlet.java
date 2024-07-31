package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Menu;
import com.pojo.OnlineUser;
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

import static com.util.Vessel.*;
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
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","系统管理","登录");
        int login = 0;
        login = userService.login(user);
        if (login > 0) {
            HttpSession session = request.getSession();
            user.setUserName(userDao.getUserName(user.getId()));
            session.setAttribute("user",user);
        }
        upOnlineTime(request,response);
        user.setCode(1);
        userService.upCode(user);
        ResultData resultData = new ResultData();
        resultData = Result.resultStatus(login);
        return resultData;
    }

    //获取所有用户列表
    public void getAllUser(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,userService.getAllUser(page,limit));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"打开","信息管理","获取所有用户列表");
    }
    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","信息管理","获取所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/infoManage/userManage/userList";
    }

    //删除一个人
    public ResultData delUser(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"删除","信息管理","根据id删除用户");
        int id = Integer.parseInt(request.getParameter("id"));
        return userService.delUser(id);
    }

    public ResultData allUserByUserid(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","信息管理","根据id获取用户所有信息");
        int id = Integer.parseInt(request.getParameter("userid"));
        return userService.allUserByUserid(id);
    }

    public ResultData allRole(HttpServletRequest request, HttpServletResponse response){
        return userService.allRole();
    }

    public ResultData queryUserIsRole(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","信息管理","获取用户角色身份");
        return userService.queryUserIsRole(Integer.parseInt(request.getParameter("userid")));
    }

    public ResultData doUpdateUser(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","信息管理","修改用户信息");
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
        HttpSession session = request.getSession();
        User user1 = (User)session.getAttribute("user");
        String name = userService.getName(user1.getId());
        logService.setLog(name,"点击","信息管理","添加用户信息");
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

    //获取在线人
    public ResultData<OnlineUser> getOnlineUser(HttpServletRequest request, HttpServletResponse response){
        List<OnlineUser> userList = userService.getActiveUser();
        return Result.resultData(userList);
    }
    //修改在线时间
    public ResultData upOnlineTime(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return Result.resultStatus(userService.upUserOnlineTime(user.getId()));
    }
    //修改退出状态
    public ResultData upCode(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setCode(0);
        return Result.resultStatus(userService.upCode(user));
    }
}
