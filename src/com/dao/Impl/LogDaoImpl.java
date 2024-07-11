package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.LogDao;
import com.pojo.Log;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogDaoImpl extends InitDaoImpl implements LogDao {

    @Override
    public ResultSet getLogList() {
        String sql = "select * from log";
        Object[] objects = new Object[1];
        objects[0] = 0;
        return JDBC.select(sql,objects);
    }

    @Override
    public int setLog(Log log) {
        String sql = "insert into log(time,name,action,item,operate) values(?,?,?,?,?)";
        Object[] objects = new Object[5];
        objects[0] = log.getTime();
        objects[1] = log.getName();
        objects[2] = log.getAction();
        objects[3] = log.getItem();
        objects[4] = log.getOperate();
        int add = JDBC.update(sql,objects);
        return add;
    }

    @Override
    public List<Log> getLogItem() {
        String sql = "select item\n" +
                "from log\n" +
                "where logId > ?\n" +
                "group by item;";
        Object[] objects = new Object[1];
        objects[0] = 0;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Log> list = new ArrayList<Log>();
        try{
            while(resultSet.next()){
                Log log = new Log();
                log.setItem(resultSet.getString("item"));
                list.add(log);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //获取日志动作类型
    @Override
    public List<Log> getLogAction() {
        String sql = "select action\n" +
                "from log\n" +
                "where logId > ?\n" +
                "group by action;";
        Object[] objects = new Object[1];
        objects[0] = 0;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Log> list = new ArrayList<Log>();
        try{
            while(resultSet.next()){
                Log log = new Log();
                log.setAction(resultSet.getString("action"));
                list.add(log);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Log> getLogOperate() {
        String sql = "select operate\n" +
                "from log\n" +
                "where logId > ?\n" +
                "group by operate;";
        Object[] objects = new Object[1];
        objects[0] = 0;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Log> list = new ArrayList<Log>();
        try{
            while(resultSet.next()){
                Log log = new Log();
                log.setOperate(resultSet.getString("operate"));
                list.add(log);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Log> Search(String sql) {
        sql += " and logId > ?";
        Object[] objects = new Object[1];
        objects[0] = 0;
        ResultSet resultSet = JDBC.select(sql,objects);
        List<Log> list = new ArrayList<>();
        try{
            while (resultSet.next()) {
                Log log = new Log();
                log.setLogId(resultSet.getInt(1));
                log.setTime(resultSet.getString(2));
                log.setName(resultSet.getString(3));
                log.setAction(resultSet.getString(4));
                log.setItem(resultSet.getString(5));
                log.setOperate(resultSet.getString(6));
                list.add(log);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int delLog(int id) {
        String sql = "delete from log where logId = ?";
        Object[] objects = new Object[1];
        objects[0] = id;
        int del = JDBC.update(sql,objects);
        return del;
    }

}
