package com.util.init;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ToJSON {

    //简单封装转成JSON字符串
    public static void toJson(HttpServletResponse response, Object obj){
        try {
            String string = JSON.toJSONString(obj);
            PrintWriter writer = response.getWriter();
            writer.write(string);
            writer.flush();
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
