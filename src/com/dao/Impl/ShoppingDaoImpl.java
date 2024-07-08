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

    @Override
    public ResultSet memoryList() {
        String sql = "select * from dictionary\n" +
                "where tableCoding in (\n" +
                "    select mId from sub_apply\n" +
                "    where approve = ?\n" +
                "    );";
        Object[] objects = new Object[1];
        objects[0] = 0;
        return JDBC.select(sql,objects);
    }

    //生成转存表2
    @Override
    public ResultSet subApplyList() {
        String sql = "select * from sub_apply where approve = ?";
        Object[] objects = new Object[1];
        objects[0] = 0;
        return JDBC.select(sql,objects);
    }
}
