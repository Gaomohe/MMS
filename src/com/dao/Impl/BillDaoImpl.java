package com.dao.Impl;

import com.dao.BillDao;
import com.dao.Impl.init.InitDaoImpl;
import com.util.JDBC;

import java.sql.ResultSet;

public class BillDaoImpl extends InitDaoImpl implements BillDao {
    @Override
    public ResultSet getAllIncome() {
        String sql = "select * from patient left join medicineorder m on patient.mId = m.orderId left join dictionary d on m.mId = d.mId";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getSupply1() {
        String sql = "select distinct supplier from patient left join medicineorder on patient.mId = medicineorder.orderId left join dictionary on medicineorder.mId = dictionary.tableCoding where status='已取药'";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getSupply2() {
        String sql = "select distinct supplier from app_order left join dictionary on app_order.aId=dictionary.mId";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getSupply3() {
        String sql = "select distinct quality.supplier from quality left join dictionary on quality.tableCoding=dictionary.tableCoding where oId is not null";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getFinance2() {
        String sql = "select distinct finance from apply where financeApprove ='已审阅通过'";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getAccount2() {
        String sql = "select  distinct manufactor from apply where financeApprove ='已审阅通过' ";
        return JDBC.select(sql,new Object[1]);
    }

    @Override
    public ResultSet getAllTransfer(int page,int limit) {
        String sql = "select * from apply where financeApprove ='已审阅通过' limit ?,?";
        Object[] objects = new Object[]{page,limit};
        return JDBC.select(sql,objects);
    }

}
