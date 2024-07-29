package com.dao;

import com.pojo.Apply;
import com.util.ResultData;
import com.util.init.StringDeal;

import java.sql.ResultSet;
import java.util.List;

public interface PurchaseDao {
    //获取所有未批订单
    public ResultSet getAppointList();

    public ResultSet getId(int id);

    public boolean isok(int id, String name);

    public boolean noPass(int id,String values);

    //通过消息
    public boolean isOK_msg(int id,String okType,String detail,int send,int receivePeo);

    public boolean notOK_msg(int id,String okType,int send,int receivePeo);
}
