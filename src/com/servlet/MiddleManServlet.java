package com.servlet;

import com.pojo.Menu;
import com.pojo.Middleman;
import com.pojo.User;
import com.service.Impl.MiddlemanServiceImpl;
import com.util.BaseServlet;
import com.util.ResultData;
import com.util.init.ToJSON;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/middleMan")
public class MiddleManServlet extends BaseServlet {
    MiddlemanServiceImpl middlemanService = new MiddlemanServiceImpl();
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","信息管理","获取所有按钮");
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/infoManage/middleManManage/middleManList";
    }

    @Override
    public Class getServlet() {
        return MiddleManServlet.class;
    }

    public void selectMiddleMan(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","信息管理","获取所有药品经手人信息");
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        ToJSON.toJson(response,middlemanService.selectMiddleMan(page,limit));
    }

    //删除药品经手人信息
    public ResultData delMiddleMan(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","信息管理","删除药品经手人信息");
        return middlemanService.delMiddleMan(Integer.parseInt(request.getParameter("workId")));
    }

    //根据id获取药品经手人信息
    public ResultData selectMiddleManById(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","信息管理","根据id获取药品经手人信息");
        return middlemanService.selectMiddleManById(Integer.parseInt(request.getParameter("workId")));
    }

    //根据姓名获取药品经手人员信息
    public ResultData checkMiddleManName(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","信息管理","根据姓名获取药品经手人员信息");
        return middlemanService.checkMiddleManName(request.getParameter("mname"));
    }

    //更新药品经手人信息
    public ResultData updateMiddleMan(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","信息管理","更新药品经手人信息");
        Middleman middleman = new Middleman();
        middleman.setmName(request.getParameter("mname"));
        middleman.setWorkId(Integer.parseInt(request.getParameter("workId")));
        middleman.setMedNum(Integer.parseInt(request.getParameter("medNum")));
        middleman.setTel(request.getParameter("tel"));
        middleman.setEmail(request.getParameter("email"));
        middleman.setDepartment(request.getParameter("department"));
        middleman.setMedName(request.getParameter("medName"));
        middleman.setStandard(request.getParameter("standard"));
        middleman.setDate(request.getParameter("date"));
        middleman.setPlace(request.getParameter("place"));
        return middlemanService.updateMiddleMan(middleman);
    }
    public ResultData isUname(HttpServletRequest request, HttpServletResponse response){
        return middlemanService.checkMiddleManName(request.getParameter("mname"));
    }

    //添加药品经手人信息
    public ResultData addMiddleMan(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","信息管理","添加药品经手人信息");
        Middleman middleman = new Middleman();
        middleman.setmName(request.getParameter("mname"));
        middleman.setMedNum(Integer.parseInt(request.getParameter("medNum")));
        middleman.setTel(request.getParameter("tel"));
        middleman.setEmail(request.getParameter("email"));
        middleman.setDepartment(request.getParameter("department"));
        middleman.setMedName(request.getParameter("medName"));
        middleman.setStandard(request.getParameter("standard"));
        middleman.setDate(request.getParameter("date"));
        middleman.setPlace(request.getParameter("place"));
        middleman.setSupplierName(request.getParameter("supplierName"));
        return middlemanService.addMiddleMan(middleman);
    }


}
