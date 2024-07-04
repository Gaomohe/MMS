package com.dao.Impl;

import com.dao.AppointDao;
import com.dao.Impl.init.InitDaoImpl;
import com.util.JDBC;

import java.sql.ResultSet;

public class AppointDaoImpl extends InitDaoImpl implements AppointDao {
    @Override
    public int delAppoint(int id) {
        String sql = "delete from appoint where mId=?";
        Object[] obj = new Object[1];
        obj[0] = id;
        int update = JDBC.update(sql, obj);
        return update;
    }

    //获取所有已批申请
    @Override
    public ResultSet getAppointList() {
        String sql = "select * from appoint \n" +
                "where pharmacistApprove = '已批准' and financeApprove = '已批准';";
        Object[] obj = new Object[1];
        obj[0] = 0;
        return JDBC.select(sql, obj);
    }
}
