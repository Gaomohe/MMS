package com.servlet;

import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/role")
public class RoleServlet extends BaseServlet {
    @Override
    public Class getServlet() {
        return RoleServlet.class;
    }
}
