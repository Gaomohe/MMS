package com.dao;

import com.pojo.Apply;

import java.sql.ResultSet;
import java.util.List;

public interface PurchaseDao {
    //获取所有未批订单
    public ResultSet getAppointList();

}
