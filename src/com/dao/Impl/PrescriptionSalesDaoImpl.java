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
}
