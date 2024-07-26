package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.PurchaseDao;
import com.pojo.Apply;
import com.util.JDBC;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchaseDaoImpl extends InitDaoImpl implements PurchaseDao {
    @Override
    public ResultSet getAppointList() {
        String sql = "select * from apply \n" +
                "where pharmacistApprove = '未审阅';";
        Object[] obj = new Object[1];
        obj[0] = 0;
        return JDBC.select(sql, obj);
    }

    @Override
    public ResultSet getId(int id) {
        String sql = "select mId,applyBuyNumber,mName,specification,manufactor,unit,department,purchasePrice,salePrice,productDate,goodsType,mType,defined from dictionary right join (select aId,applyBuyNumber from app_order where oId = ?) ord1 on ord1.aId=dictionary.mId";
        Object[] objects = new Object[]{id};
        return JDBC.select(sql, objects);
    }

    @Override
    public boolean isok(int id,String name) {
        String sql = "update orders set oName = '已审阅通过',specification = ? where oId = ?";
        Object[] objects = new Object[]{name,id};
        return JDBC.update(sql,objects) > 0;
    }


}
