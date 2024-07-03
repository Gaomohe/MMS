package com.servlet;

import com.alibaba.fastjson.JSON;
import com.dao.Impl.init.InitDaoImpl;
import com.pojo.Menu;
import com.pojo.Role;
import com.pojo.User;
import com.service.Impl.RoleServiceImpl;
import com.service.RoleService;
import com.util.*;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.util.Vessel.menuService;

@WebServlet("/role")
public class RoleServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return RoleServlet.class;
    }

    RoleService roleService = new RoleServiceImpl();
    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/systemManage/role/roleList";
    }
    //获取所有role
    public void getRoleList(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            List<Role> roleAll = roleService.getRoleList();
            TableJSON tableJSON = new TableJSON();
            tableJSON.setCode(0);
            tableJSON.setCount(roleAll.size());
            tableJSON.setMsg("");
            tableJSON.setData(roleAll);
            ToJSON.toJson(response,tableJSON);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //根据ID获取角色
    public ResultData<Role> getRoleById(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Role roleById = roleService.getRoleById(id);
        ResultData<Role> resultData = new ResultData<>();
        resultData.setData(roleById);
        return resultData;
    }
    //删除角色与其对应的权限
    public ResultData<Role> delRole(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        int i = roleService.delRoleById(id);
        ResultData<Role> resultData = new ResultData<>();
        resultData = Result.resultStatus(i);
        return resultData;
    }
    //更新角色
    public ResultData<Role> updateRole(HttpServletRequest request, HttpServletResponse response){
        ResultData<Role> resultData = new ResultData<>();
        try{
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
            int id = Integer.parseInt(request.getParameter("id"));
            int state = Integer.parseInt(request.getParameter("state"));
            String name = request.getParameter("name");
            String roleKey = request.getParameter("roleKey");
            String description = request.getParameter("description");
            Role role = new Role();
            role.setId(id);
            role.setState(state);
            role.setName(name);
            role.setRoleKey(roleKey);
            role.setDescription(description);
            int i = roleService.updateDoRole(role);
            if(i>0){
                resultData.setMsg("角色修改成功");
                resultData.setStatus(200);
            }else {
                resultData.setMsg("角色修改失败");
                resultData.setStatus(500);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return resultData;
    }
    //新增角色
    public ResultData<Role> addRole(HttpServletRequest request, HttpServletResponse response){
        try{
            request.setCharacterEncoding("utf-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        int state = Integer.parseInt(request.getParameter("state"));
        String name = request.getParameter("name");
        String roleKey = request.getParameter("roleKey");
        String description = request.getParameter("description");
        Role role = new Role();
        role.setState(state);
        role.setName(name);
        role.setRoleKey(roleKey);
        role.setDescription(description);
        int i = roleService.addDoRole(role);
        return Result.resultStatus(i);
    }
    public ResultData<Role> checkUname(HttpServletRequest request, HttpServletResponse response){
        String rname = request.getParameter("name");
        Role role = new Role();
        role.setName(rname);
        int uname = roleService.isUname(role);
        return Result.resultNameStatus(uname);
    }

    //获取全部权限信息
    public void MenuDtree(HttpServletRequest request, HttpServletResponse response){
        try {
            LayuiTable<Dtree> treeTableList = roleService.getMenus();
            String string = JSON.toJSONString(treeTableList);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //回显角色已有权限
    public void menuByRoleId(HttpServletRequest request, HttpServletResponse response){
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);
        List<Menu> list = roleService.menuByRoleid(id);
        try {
            String string = JSON.toJSONString(list);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //修改角色绑定的权限
    public ResultData UpdateRoleMenu(HttpServletRequest request, HttpServletResponse response){
        String roleid = request.getParameter("roleid");
        int id = Integer.parseInt(roleid);
        String[] arrays = request.getParameterValues("array");
        System.out.println(arrays.toString());
        int[] arrayInts = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            arrayInts[i] = Integer.parseInt(arrays[i]);
        }
        int i = roleService.UpdateRoleMenu(id, arrayInts);
        ResultData resultData = new ResultData();
        resultData = Result.resultStatus(i);
        return resultData;
    }
}
