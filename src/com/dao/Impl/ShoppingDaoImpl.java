package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.ShoppingDao;
import com.pojo.Sub_Apply;
import com.util.JDBC;
import com.util.init.StringDeal;

import javax.jws.Oneway;
import java.sql.ResultSet;

public class ShoppingDaoImpl extends InitDaoImpl implements ShoppingDao {
    @Override
    public ResultSet likeSelect(String like) {
        String sql = "select * from dictionary where mName like '%"+like+"%'";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public boolean addSub_Apply(Sub_Apply sub_apply) {
        String sql = "insert into sub_apply(mid, applynum, applytime, applyuserid) values (?,?,?,?)";
        Object[] objects = new Object[]{sub_apply.getMid(),sub_apply.getApplynum(),sub_apply.getApplytime(),sub_apply.getApplyuserid()};
        return JDBC.update(sql,objects) > 0;
    }
}
