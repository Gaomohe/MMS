package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.PrescriptionSalesDao;
import com.util.JDBC;

import java.sql.ResultSet;

public class PrescriptionSalesDaoImpl extends InitDaoImpl implements PrescriptionSalesDao {
    @Override
    public ResultSet getAll(int pages, int limits) {
        String sql = "select * from medicineorder left join dictionary dic on dic.mId=medicineorder.mId where status = '已取药' and defined = '处方药' limit ?,?";
        Object[] objects = new Object[]{pages,limits};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet GSPGetNum(String time) {
        String sql = "select sum(medicineorder.number) from medicineorder where getmTime like '"+time+"%'";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getChoise01(String unit) {
        String sql = "select sum(medicineorder.number) from medicineorder left join dictionary dic on dic.mId=medicineorder.mId where status = '已取药' and defined = '处方药' and unit = ?";
        Object[] objects = new Object[]{unit};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet getChoise02(String mName) {
        String sql = "select sum(medicineorder.number) from medicineorder left join dictionary dic on dic.mId=medicineorder.mId where status = '已取药' and defined = '处方药' and mName = ?";
        Object[] objects = new Object[]{mName};
        return JDBC.select(sql,objects);
    }

    @Override
    public ResultSet getKing01() {
        String sql = "select distinct unit from medicineorder left join dictionary dic on dic.mId=medicineorder.mId where status = '已取药' and defined = '处方药'";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getKing02() {
        String sql = "select distinct mName from medicineorder left join dictionary dic on dic.mId=medicineorder.mId where status = '已取药' and defined = '处方药'";
        return JDBC.select(sql,new Object[1]);
    }
}
