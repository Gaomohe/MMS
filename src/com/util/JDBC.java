package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC {
    private static  Connection connection =null;
    private static PreparedStatement preparedStatement=null;
    private static  ResultSet resultSet =null;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://rm-bp1ln5cud01u6z7893o.mysql.rds.aliyuncs.com:3306/mms";
            String name="root1";
            String password="MMS_root";
            connection = DriverManager.getConnection(url, name, password);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //通用的查询
    public static ResultSet select(String sql,Object[] objects){
        try {
            preparedStatement = connection.prepareStatement(sql);
            if(objects[0] !=null){
                for (int i=0;i<objects.length;i++){
                    preparedStatement.setObject(i+1,objects[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

    //通用的增，删，改
    public static int update(String sql,Object[] objects){
        int num=0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i=0;i<objects.length;i++){
                preparedStatement.setObject(i+1,objects[i]);
            }
            num = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return num;
    }
}
