package com.dao;

import java.sql.ResultSet;

public interface PurchaseDao {
    //获取所有未批订单
    public ResultSet getAppointList();
}
