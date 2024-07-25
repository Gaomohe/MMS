package com.servlet;

import com.pojo.Menu;
import com.pojo.User;
import com.pojo.Warn;
import com.pojo.WarnDetail;
import com.service.Impl.WarnServiceImpl;
import com.service.WarnService;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;


@WebServlet("/warning")
public class WarnServlet extends BaseServlet {

    WarnService warnService = new WarnServiceImpl();

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
        return "medicine/qualityManage/imminentWarning/warnList";
    }

    //获取所有Warn值
    public LayuiTable<Warn> getWarnAll(HttpServletRequest request,HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        List<Warn> warns = warnService.getWarns(page,limit);
        LayuiTable<Warn> layuiTable = new LayuiTable<>();
        layuiTable.setCount(warnService.getWarns());
        layuiTable.setData(warns);
        return layuiTable;
    }
    //根据时间获取
    public ResultData<Warn> getWarnsByTime(HttpServletRequest request,HttpServletResponse response){
        String time = request.getParameter("time");
        List<Warn> warns = warnService.getWarnsByTime(time);
        return Result.resultData(warns);
    }
    //根据药品名称获取
    public ResultData<Warn> getWarnsByMname(HttpServletRequest request,HttpServletResponse response){
        String mName = request.getParameter("mName");
        List<Warn> warns = warnService.getWarnsByMname(mName);
        return Result.resultData(warns);
    }
    //获取所有WarnDetails
    public LayuiTable<WarnDetail> getWarnDatailAll(HttpServletRequest request,HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        List<WarnDetail> warns = warnService.getWarnDetails(page,limit);
        LayuiTable<WarnDetail> layuiTable = new LayuiTable<>();
        layuiTable.setCount(warnService.getWarnDetails());
        layuiTable.setData(warns);
        return layuiTable;
    }
    //根据id获取预警数据（总表）
    public ResultData<Warn> getWarnsById(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        Warn warnsById = warnService.getWarnsById(Integer.parseInt(id));
        return Result.resultData(warnsById);
    }
    //根据总预警数据获取预警细节
    public LayuiTable<WarnDetail> getWarnDatailByWid(HttpServletRequest request,HttpServletResponse response){
        String wId = request.getParameter("wId");
        List<WarnDetail> warns = warnService.getWarnDetailsByWId(Integer.parseInt(wId));
        LayuiTable<WarnDetail> layuiTable = new LayuiTable<>();
        layuiTable.setData(warns);
        return layuiTable;
    }
    //新增预警数据
    public ResultData<Warn> addWarn(HttpServletRequest request, HttpServletResponse response){
        String tableCoding = request.getParameter("tableCoding");
        String tolNumber = request.getParameter("tolNumber");
        String usefulLife = request.getParameter("usefulLife");
        /*User user = new User();
        user.setId(12);
        user.setUserName("李四");*/
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Warn warn = new Warn();
        warn.setuId(user.getId());
        warn.setName(user.getUserName());
        warn.setTolNumber(Integer.parseInt(tolNumber));
        warn.setTableCoding(Integer.parseInt(tableCoding));
        int i = warnService.addWarn(warn, usefulLife);
        return Result.resultStatus(i);
    }
    //删除预警数据
    public ResultData<Warn> delWarn(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        int i = warnService.delWarn(Integer.parseInt(id));
        if(i==1){
            warnService.delWarnDetail(Integer.parseInt(id));
        }
        return Result.resultStatus(i);
    }
    //修改总表预警值
    public ResultData<Warn> upWarnWNumber(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String warnNumber = request.getParameter("warnNumber");
        /*User user = new User();
        user.setId(12);
        user.setUserName("李四");*/
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Warn warn = new Warn();
        warn.setId(Integer.parseInt(id));
        warn.setWarnNumber(Integer.parseInt(warnNumber));
        warn.setuId(user.getId());
        warn.setName(user.getUserName());
        int i = warnService.upWarnWNumber(warn);
        return Result.resultStatus(i);
    }
    //修改总表总数(入库处理)
    public ResultData<Warn> upWarnTotlNumber(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String tolNumber = request.getParameter("tolNumber");
        String usefulLife = request.getParameter("usefulLife");
        /*User user = new User();
        user.setId(12);
        user.setUserName("李四");*/
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Warn warn = new Warn();
        warn.setId(Integer.parseInt(id));
        warn.setuId(user.getId());
        warn.setName(user.getUserName());
        warn.setTolNumber(Integer.parseInt(tolNumber));
        int i = warnService.upWarnTotlNumber(warn,usefulLife);
        return Result.resultStatus(i);
    }
}
