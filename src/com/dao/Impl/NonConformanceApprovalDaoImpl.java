package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.NonConformanceApprovalDao;
import com.util.JDBC;

import java.sql.ResultSet;

public class NonConformanceApprovalDaoImpl extends InitDaoImpl implements  NonConformanceApprovalDao {
    @Override
    public ResultSet getAll(int pages,int limits) {
        String sql = "select * from applyfailed left join dictionary d on applyfailed.tableCoding=d.tableCoding limit ?,?";
        Object[] objects = new Object[]{pages,limits};
        return JDBC.select(sql,objects);
    }
}
