package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.PurchaseDao;
import com.util.JDBC;

import java.sql.ResultSet;

public class PurchaseDaoImpl extends InitDaoImpl implements PurchaseDao {
    @Override
    public ResultSet getAppointList() {
        String sql = "select * from apply \n" +
                "where pharmacistApprove = '未审阅';";
        Object[] obj = new Object[1];
        obj[0] = 0;
        return JDBC.select(sql, obj);
    }
}
