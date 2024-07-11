package com.servlet;

import com.pojo.Log;
import com.pojo.Menu;
import com.pojo.User;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/log")
public class LogServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return LogServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","日志管理","获取所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/systemManage/log/logList";
    }

    //获取日志列表
    public void getLogList(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","日志管理","获取日志列表");
        page = (page-1)*limit;
        ToJSON.toJson(response,logService.getLogList(page,limit));
    }

    //获取事务类型
    public void getLogItem(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,logService.getLogItem());
    }

    //获取日志动作类型
    public void getLogAction(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,logService.getLogAction());
    }

    //获取操作描述
    public void getLogOperate(HttpServletRequest request, HttpServletResponse response){
        ToJSON.toJson(response,logService.getLogOperate());
    }

    //日志条件查询
    public void Search(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"查询","日志管理","条件查询所有日志信息");
        String logName = request.getParameter("LogName");
        String action = request.getParameter("action1");
        String limitStr = request.getParameter("limit");
        String pageStr = request.getParameter("page");
        int limit = Integer.parseInt(limitStr);
        int page = Integer.parseInt(pageStr);
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String logUser = request.getParameter("logUser");
        String operate = request.getParameter("operate");
        Log log = new Log();
        log.setItem(logName);
        log.setAction(action);
        log.setName(logUser);
        log.setOperate(operate);

        page = (page-1)*limit;
        LayuiTable<Log> search = logService.Search(log, startTime, endTime, page, limit);
        ToJSON.toJson(response,search);
    }

    public ResultData delLog(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"删除","日志管理","删除查询日志信息");
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        int i = logService.delLog(id);
        ResultData resultData = Result.resultStatus(i);
        return resultData;
    }
}
