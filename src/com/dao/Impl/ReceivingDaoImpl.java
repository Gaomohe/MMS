package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.ReceivingDao;
import com.util.JDBC;

import java.sql.ResultSet;


public class ReceivingDaoImpl extends InitDaoImpl implements ReceivingDao {

    @Override
    public ResultSet getAllSup(String supply) {
        String sql = "select sum(totlNumber) from stockinform where manufactor = ? and storageStatus='已入库'";
        Object[] objects = new Object[]{supply};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet GSPGetNum(String time) {
        String sql = "select sum(rNum) from stockinform where stockInTime like '"+time+"%'";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getChoise01(String unit) {
        String sql = "select sum(rNum) from stockinform where  unit = ?";
        Object[] objects = new Object[]{unit};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet getChoise02(String mName) {
        String sql = "select sum(rNum) from stockinform where   rName = ?";
        Object[] objects = new Object[]{mName};
        return JDBC.select(sql,objects);
    }
}
