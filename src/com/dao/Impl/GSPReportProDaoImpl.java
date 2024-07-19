package com.dao.Impl;

import com.dao.GSPReportProDao;
import com.dao.Impl.init.InitDaoImpl;
import com.util.JDBC;
import com.util.init.StringDeal;

import java.sql.ResultSet;

public class GSPReportProDaoImpl extends InitDaoImpl implements GSPReportProDao {

    @Override
    public ResultSet GSPGetTimes() {
        String sql = "SELECT distinct DATE_FORMAT(applyTime, '%Y-%m-%d') AS formattedDate FROM apply";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet GSPGetNum(String time) {
        String sql = "select sum(applyNumber) from apply where applyTime like '"+time+"%'";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getAllSup(String supply) {
        String sql = "select sum(applyNumber) from apply where supplier = ?";
        Object[] objects = new Object[]{supply};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet getChoise01(String unit) {
        String sql = "select sum(applyNumber) from apply where unit = ?";
        Object[] objects = new Object[]{unit};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet getChoise02(String mName) {
        String sql = "select sum(applyNumber) from apply where mName = ?";
        Object[] objects = new Object[]{mName};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet getChoise03(String mName) {
        String sql = "select sum(applyNumber) from apply where mName = ?";
        Object[] objects = new Object[]{mName};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet getChoiseKind03(String time) {
        String sql = "select distinct mName from apply where applyTime like '"+time+"%'";
        return JDBC.select(sql,new Object[1]);
    }
}
