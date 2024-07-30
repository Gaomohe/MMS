package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.*;
import com.util.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/menu")
public class MenuServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return MenuServlet.class;
    }

    //获取所有目录
    public void selectMenu(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","获取所有目录");
        WarnServlet warnServlet = new WarnServlet();
        warnServlet.getTitle(request,response);
        firstPage(request,response);
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute("user");
            InitJson initJson = menuService.getMenuList(user.getId());
            String string = JSON.toJSONString(initJson);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取所有目录权限
    public void getResource(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","获取所有目录权限");
        try {
            LayuiTable<TreeTable> treeTableList = menuService.getMenus();
            String string = JSON.toJSONString(treeTableList);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","获取所有按钮");
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/systemManage/system/menuList";
    }

    //通过id获取所有
    public ResultData selectMenuById(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","通过id获取所有");
        try {
            request.setCharacterEncoding("utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Menu menuById = menuService.getMenuById(id);
        return Result.resultData(menuById);
    }

    //添加新菜单
    public ResultData<Menu> addMenu(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","添加新菜单");
        try{
            request.setCharacterEncoding("utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name");
        int parentId = Integer.parseInt(request.getParameter("parentId"));
        String resKey = request.getParameter("resKey");
        int type = Integer.parseInt(request.getParameter("type"));
        String resUrl = request.getParameter("resUrl");
        int level = Integer.parseInt(request.getParameter("level"));
        String icon = request.getParameter("icon");
        String description = request.getParameter("description");
        String btn = request.getParameter("btn");

        Menu menus = new Menu();
        menus.setName(name);
        if(type==2){
            menus.setResUrl(resUrl);
        }else if(type==3){
            menus.setResUrl(btn);
        }
        menus.setResKey(resKey);
        menus.setIcon(icon);
        menus.setType(type-1);
        menus.setParentId(parentId);
        menus.setLevel(level);
        menus.setDescription(description);
        ResultData<Menu> resultData = new ResultData<Menu>();
        int i = menuService.addMenu(menus);
        if(i>0){
            resultData.setMsg("权限添加成功");
            resultData.setStatus(200);
        }else {
            resultData.setMsg("权限添加失败");
            resultData.setStatus(500);
        }
        return resultData;
    }

    //删除菜单
    public ResultData<Menu> delMenu(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","删除菜单");
        int id = Integer.parseInt(request.getParameter("menuid"));
        int i = menuService.delMenu(id);
        ResultData<Menu> resultData = new ResultData<>();
        if(i>0){
            resultData.setMsg("权限删除成功");
            resultData.setStatus(200);
        }else {
            resultData.setMsg("权限删除失败");
            resultData.setStatus(500);
        }
        return resultData;
    }

    //修改菜单
    public ResultData<Menu> updateMenu(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","修改菜单");
        try {
            request.setCharacterEncoding("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int parentId = Integer.parseInt(request.getParameter("parentId"));
        String resKey = request.getParameter("resKey");
        int type = Integer.parseInt(request.getParameter("type"));
        String resUrl = request.getParameter("resUrl");
        int level = Integer.parseInt(request.getParameter("level"));
        String icon = request.getParameter("icon");
        String description = request.getParameter("description");

        Menu menus = new Menu();
        menus.setResId(id);
        menus.setName(name);
        menus.setResKey(resKey);
        menus.setParentId(parentId);
        menus.setType(type - 1);
        menus.setResUrl(resUrl);
        menus.setLevel(level);
        menus.setIcon(icon);
        menus.setDescription(description);
        ResultData<Menu> resultData = new ResultData<>();
        int i = menuService.updateMenu(menus);
        if(i>0){
            resultData.setMsg("权限修改成功");
            resultData.setStatus(200);
        }else {
            resultData.setMsg("权限修改失败");
            resultData.setStatus(500);
        }
        return resultData;
    }
    //根据唯一标识判断是否存在
    public ResultData<Menu> selectMenuByResKey(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","根据唯一标识判断是否存在");
        ResultData<Menu> resultData = new ResultData<>();
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            String resKey = request.getParameter("resKey");
            boolean exist = menuService.isExist(resKey);
            if (exist == true){
                resultData.setMsg("此标识已存在");
                resultData.setStatus(500);
            }else {
                resultData.setStatus(200);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       return resultData;
    }


    //根据类型获取所有按钮
    public void allButtonType(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","根据类型获取所有按钮");
        try {
            List<Btn> btnList = menuService.getBtnAll();
            String string = JSON.toJSONString(btnList);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //通过类型获取所有菜单
    public void menuByType(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","根据类型获取所有按钮");
        try {
            String typeStr = request.getParameter("mtype");
            int type = Integer.parseInt(typeStr);
            List<Menu> menuList = menuService.getMenuByType(type);
            String string = JSON.toJSONString(menuList);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //添加权限
    public ResultData addResources(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","添加权限");
        String mname = request.getParameter("mname");
        String mfunction = request.getParameter("mfunction");
        String type2 = request.getParameter("type2");
        int type = Integer.parseInt(type2);
        String icon = request.getParameter("icon");
        String resUrl = request.getParameter("resUrl");
        String mbtn = request.getParameter("mbtn");
        String fatherStr = request.getParameter("father");
        int father = Integer.parseInt(fatherStr);

        Menu menu = new Menu();
        menu.setName(mname);
        menu.setResKey(mfunction);
        menu.setType(type-1);
        menu.setIcon(icon);

        if (menu.getType()==2){
            menu.setResUrl(mbtn);
        }else if (menu.getType()==1){
            menu.setResUrl(resUrl);
        }
        menu.setParentId(father);

        int i = 0;
        ResultData resultData = new ResultData();
        i = menuService.addMenu(menu);
        if (i > 0){
            try{
                resultData.setMsg("add success");
                resultData.setStatus(200);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            try{
                resultData.setMsg("add fail");
                resultData.setStatus(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return resultData;
    }

    //根据id获取所有菜单目录
    public ResultData allMenuById(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","根据id获取所有菜单目录");
        String menuid = request.getParameter("menuid");
        int mid = Integer.parseInt(menuid);
        Menu menu1 = new Menu();
        menu1.setResId(mid);
        Menu menu = new Menu();
        menu = menuService.allMenuById(menu1);
        ResultData resultData = new ResultData();
        try{
            resultData.setMsg("all menu ok");
            resultData.setStatus(200);
            resultData.setData(menu);
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    //验证权限名是否存在
    public ResultData isMenuName(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","验证权限名是否存在");
        String name = request.getParameter("name");
        Menu menu = new Menu();
        menu.setName(name);
        int i = 0;
        i = menuService.isMenuName(menu);

        ResultData resultData = new ResultData();

        try {
            if (i > 0){
                resultData.setMsg("is menu ok");
                resultData.setStatus(200);
            }else {
                resultData.setMsg("is menu fail");
                resultData.setStatus(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    //验证请求路径是否存在
    public ResultData isMenuUrl(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","验证请求路径是否存在");
        String url = request.getParameter("url");
        Menu menu = new Menu();
        menu.setResUrl(url);
        int i = 0;
        i = menuService.isMenuUrl(menu);

        ResultData resultData = new ResultData();

        try {
            if (i > 0){
                resultData.setMsg("is menu ok");
                resultData.setStatus(200);
            }else {
                resultData.setMsg("is menu fail");
                resultData.setStatus(100);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    //修改权限
    public ResultData upMenu(HttpServletRequest request, HttpServletResponse response){
        HttpSession session9 = request.getSession();
        User user9 = (User)session9.getAttribute("user");
        String name9 = userService.getName(user9.getId());
        logService.setLog(name9,"点击","系统配置","修改权限");
        String midStr = request.getParameter("mid");
        int mid = Integer.parseInt(midStr);
        String mname = request.getParameter("mname");
        String resKey = request.getParameter("mfunction");
        String type2 = request.getParameter("type2");
        int type = Integer.parseInt(type2);
        String icon = request.getParameter("icon");
        String father = request.getParameter("father");
        int presentId = Integer.parseInt(father);
        String mbtn = request.getParameter("mbtn");

        Menu menu = new Menu();
        menu.setResId(mid);
        menu.setName(mname);
        menu.setResKey(resKey);
        menu.setType(type-1);
        menu.setIcon(icon);
        menu.setResUrl(mbtn);
        menu.setParentId(presentId);

        ResultData resultData = new ResultData();

        int i = 0;
        i = menuService.updateMenu(menu);
        try {
            if (i > 0){
                resultData.setMsg("update success");
                resultData.setStatus(200);
            }else {
                resultData.setMsg("update fail");
                resultData.setStatus(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultData;
    }

    //获取首页数据
    public void firstPage(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        HttpSession session1 = request.getSession();
        HttpSession session2 = request.getSession();
        int failedNumber = firstPageService.getFailedNumber();
        int returnNumber = firstPageService.getReturnNumber();
        int unPayed = firstPageService.getUnPayed();
        session.setAttribute("fNumber",failedNumber);
        session1.setAttribute("rNumber",returnNumber);
        session2.setAttribute("uNumber",unPayed);
    }

    //获取首页预警数据
    public ResultData getWarnForFirst(HttpServletRequest request, HttpServletResponse response){
        List<FirstPage> warnMsg = firstPageService.getWarnMsg();
        return Result.resultData(warnMsg);
    }
    //获取首页采购数据
    public ResultData getOrderMsg(HttpServletRequest request, HttpServletResponse response){
        List<Orders> orderMsg = firstPageService.getOrderMsg();
        return Result.resultData(orderMsg);
    }



}
