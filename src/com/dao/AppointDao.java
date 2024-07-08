package com.dao;


import com.pojo.Apply;
import com.pojo.Appointment;
import com.pojo.Medicine;
import com.pojo.buyOrder;

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
    public int addAppoint(int id, int bId);

    //返回价格数量
    public Appointment getAppoint(int id);

    //填充apply表数据
    public int insertApply(Apply apply);
}
