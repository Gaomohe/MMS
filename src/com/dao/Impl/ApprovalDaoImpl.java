package com.dao.Impl;

import com.dao.ApprovalDao;
import com.dao.Impl.init.InitDaoImpl;
import com.util.JDBC;
import com.util.init.StringDeal;

import java.sql.ResultSet;

public class ApprovalDaoImpl extends InitDaoImpl implements ApprovalDao {

    @Override
    public boolean isok(int id,String userName) {
        String sql = "update apply set pharmacistApprove='已审阅通过',pharmacistTime= NOW(),pharmacist = ? where applyId=? ";
        Object[] objects = new Object[]{userName,id};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public boolean nook(int id,String userName) {
        String sql = "update apply set pharmacistApprove='已审阅未通过' ,pharmacistTime= NOW(),pharmacist = ? where applyId=?";
        Object[] objects = new Object[]{userName,id};
        return JDBC.update(sql,objects) > 0;
    }

    @Override
    public boolean noaudit(int id, String name) {
    String sql = "update orders set oName = '未审阅' , specification = ? where oId = ?";
        Object[] objects = new Object[]{name,id};
        return JDBC.update(sql,objects) > 0;
    }
}
