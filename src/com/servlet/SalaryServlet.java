package com.servlet;

import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/salary")
public class SalaryServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return SalaryServlet.class;
    }

    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/financeManage/salary/salaryList";
    }

}
