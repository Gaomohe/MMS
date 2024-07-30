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

    public boolean isok(int id, String name,String times);

    public boolean noPass(int id,String name,String values,String times);

    //通过消息
    public boolean isOK_msg(long bath,String okType,String detail,int send,int receivePeo);

    public boolean notOK_msg(int id,long bath,String NotType,int send,int receivePeo);

    //获取消息
    public ResultSet getMsg(String name);
}
