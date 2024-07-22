package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.PharmaceuticalSalesDao;
import com.util.JDBC;

import java.sql.ResultSet;

public class PharmaceuticalSalesDaoImpl extends InitDaoImpl implements PharmaceuticalSalesDao {
    @Override
    public ResultSet getAll(int pages, int limits) {
        String sql = "select * from medicineorder left join dictionary dic on dic.mId=medicineorder.mId where status = '已取药' limit ?,?";
        Object[] objects = new Object[]{pages,limits};
        return JDBC.select(sql,objects);
    }
}
