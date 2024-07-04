package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.Menu;
import com.pojo.User;
import com.util.BaseServlet;
import com.util.InitJson;
import com.util.Result;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static com.util.Vessel.menuService;

@WebServlet("/menu")
public class MenuServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return MenuServlet.class;
    }

    //获取所有目录
    public void selectMenu(HttpServletRequest request, HttpServletResponse response){
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

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/systemManage/system/menuList";
    }

    public ResultData selectMenuById(HttpServletRequest request, HttpServletResponse response){
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
        int id = Integer.parseInt(request.getParameter("id"));
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
}
