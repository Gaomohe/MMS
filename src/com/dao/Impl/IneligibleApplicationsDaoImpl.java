package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.IneligibleApplicationsDao;
import com.pojo.echarts.GetString;
import com.pojo.echarts.Times;
import com.util.JDBC;
import com.util.ResultData;

import java.sql.ResultSet;
import java.util.List;

public class IneligibleApplicationsDaoImpl extends InitDaoImpl implements IneligibleApplicationsDao {
    @Override
    public ResultSet getAll(int pages, int limits) {
    String sql = "select * from applyfailed left join dictionary d on applyfailed.tableCoding=d.tableCoding limit ?,?";
        Object[] objects = new Object[]{pages,limits};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet GSPGetNum(String time) {
        String sql = "select sum(applyfailed.number) from applyfailed left join dictionary d on applyfailed.tableCoding=d.tableCoding where applyTime like '"+time+"%'";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getChoise01(String unit) {
        String sql = "select sum(applyfailed.number) from applyfailed left join dictionary d on applyfailed.tableCoding=d.tableCoding where unit = ?";
        Object[] objects = new Object[]{unit};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet getChoise02(String mName) {
        String sql = "select sum(applyfailed.number) from applyfailed left join dictionary d on applyfailed.tableCoding=d.tableCoding where  applyfailed.mName = ?";
        Object[] objects = new Object[]{mName};
        return JDBC.select(sql,objects);
    }


}
