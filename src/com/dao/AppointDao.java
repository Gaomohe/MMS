package com.dao;


import com.pojo.*;

import java.sql.ResultSet;
import java.util.List;

public interface AppointDao {
    //删除预购药品
    public int delAppoint(int id);

    //获取所有已批订单
    public ResultSet getAppointList();

    //生成订单
    public int addOrder(buyOrder buyorder);

    //获取最新订单id
    public int getOrderId();

    //绑定订单订单详情表
    public int addAppoint(int id, int bId,int applyBuyNumber);

    //返回价格数量
    public Appointment getAppoint(int id);

    //填充apply表数据
    public int insertApply(Apply apply);

    //获取供应商
    public List<Apply> getSupplier();

    //获取药品类型
    public List<Apply> getmType();

    //获取药品名称
    public List<Apply> getmName();

    //条件查询预购订单表
    public List<Apply> Search(String sql);

    //获取药品数量
    public int getNumber(int id);

    //获取供货商
    public Apply getManufactor(int mId);

    //订单信息填充
    public int insertOrder(Orders orders);
}
