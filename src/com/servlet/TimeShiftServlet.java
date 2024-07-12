package com.servlet;

import com.pojo.Menu;
import com.pojo.User;
import com.util.BaseServlet;
import com.util.ResultData;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

import static com.util.Vessel.*;

@WebServlet("/data")
public class TimeShiftServlet extends BaseServlet {
    private static Connection connection =null;
    private static PreparedStatement preparedStatement=null;
    private static ResultSet resultSet =null;


    @Override
    public Class getServlet() {
        return TimeShiftServlet.class;
    }

    //获取所有按钮
    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"打开","数据备份","进入数据备份页面，获取所有按钮");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "medicine/systemManage/log/logList";
    }

    public ResultData dataBackup(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"打开","数据备份","进行数据备份");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String JDBC_URL = "jdbc:mysql://rm-bp1ln5cud01u6z7893o.mysql.rds.aliyuncs.com:3306/mms";
            String JDBC_USER = "root1";
            String JDBC_PASSWORD = "MMS_root";
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        ResultData resultData = new ResultData();
        return resultData;
    }

    public ResultData dataRestore(HttpServletRequest request,HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"打开","数据备份","进行数据恢复");
//        Class.forName("com.mysql.cj.jdbc.Driver");
        String JDBC_URL = "jdbc:mysql://rm-bp1ln5cud01u6z7893o.mysql.rds.aliyuncs.com:3306/mms";
        String JDBC_USER = "root1";
        String JDBC_PASSWORD = "MMS_root";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");
             PrintWriter out = new PrintWriter(new FileWriter("/path/to/backup.sql"))) {

            while (rs.next()) {
                // Assuming a simple table structure for illustration
                out.printf("INSERT INTO your_table VALUES ('%s', '%s', '%s');%n",
                        rs.getString("column1"),
                        rs.getString("column2"),
                        rs.getString("column3"));
            }
            response.getWriter().write("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResultData resultData = new ResultData();
        return resultData;
    }



    /*
    import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/backup")
public class BackupServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://your-rds-endpoint:3306/your-database";
    private static final String JDBC_USER = "your-username";
    private static final String JDBC_PASSWORD = "your-password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");
             PrintWriter out = new PrintWriter(new FileWriter("/path/to/backup.sql"))) {

            while (rs.next()) {
                // Assuming a simple table structure for illustration
                out.printf("INSERT INTO your_table VALUES ('%s', '%s', '%s');%n",
                        rs.getString("column1"),
                        rs.getString("column2"),
                        rs.getString("column3"));
            }

            response.getWriter().write("Success");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: " + e.getMessage());
        }
    }
}

    * */



    /*
    import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/restore")
public class RestoreServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://your-rds-endpoint:3306/your-database";
    private static final String JDBC_USER = "your-username";
    private static final String JDBC_PASSWORD = "your-password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
             Statement stmt = conn.createStatement();
             BufferedReader in = new BufferedReader(new FileReader("/path/to/backup.sql"))) {

            String line;
            while ((line = in.readLine()) != null) {
                stmt.executeUpdate(line);
            }

            response.getWriter().write("Success");
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error: " + e.getMessage());
        }
    }
}

    * */
}
