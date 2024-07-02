package com.servlet;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import com.util.BaseServlet;
import com.util.InitJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

import static com.util.Vessel.menuService;

@WebServlet("/menu")
public class MenuServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return MenuServlet.class;
    }

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
}
