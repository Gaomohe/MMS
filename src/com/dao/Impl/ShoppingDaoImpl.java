package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.ShoppingDao;
import com.util.JDBC;

import javax.jws.Oneway;
import java.sql.ResultSet;

public class ShoppingDaoImpl extends InitDaoImpl implements ShoppingDao {
    @Override
    public ResultSet likeSelect(String like) {
        String sql = "select * from dictionary where mName like '%"+like+"%'";
        return JDBC.select(sql,new Object[1]);
    }
}
