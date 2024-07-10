package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.LogDao;
import com.pojo.Log;
import com.util.JDBC;

import java.sql.ResultSet;

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
        String sql = "insert into log(time,name,action,item) values(?,?,?,?,?)";
        Object[] objects = new Object[5];
        objects[0] = log.getTime();
        objects[1] = log.getName();
        objects[2] = log.getAction();
        objects[3] = log.getItem();
        objects[4] = log.getOperate();
        int add = JDBC.update(sql,objects);
        return add;
    }

}
