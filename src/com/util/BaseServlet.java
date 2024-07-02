package com.util;

import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    public abstract Class getServlet();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println(action);
        response.setCharacterEncoding("UTF-8");
        try{
            Object obj = getServlet().newInstance();
            Method method = getServlet().getMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            Object invoke = method.invoke(obj,request,response);
            if (invoke instanceof String){
                String str = (String)invoke;
                request.getRequestDispatcher(str + ".jsp").forward(request,response);
            }else if(invoke instanceof ResultData){
                ResultData resultData=(ResultData)invoke;
                //json字符串-->，字符串，对象，数组，集合，map
                String string = JSON.toJSONString(resultData);
                PrintWriter writer = response.getWriter();
                writer.write(string);
                writer.flush();
                writer.close();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}