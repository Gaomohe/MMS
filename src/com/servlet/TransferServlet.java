package com.servlet;

import com.util.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/transfer")
public class TransferServlet extends BaseServlet {
    @Override
    public Class<?> getServlet() {
        return TransferServlet.class;
    }
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        return "medicine/financeManage/transfer/transferList";
    }

}
