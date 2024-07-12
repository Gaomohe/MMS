package com.servlet;


import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/receiving")
public class ReceivingServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return ReceivingServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/GSPReportFormsManage/receiving/receivingList";
    }
}
