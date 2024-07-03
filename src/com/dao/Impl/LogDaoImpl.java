package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.LogDao;
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

}
