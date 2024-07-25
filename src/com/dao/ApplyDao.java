package com.dao;

import com.pojo.Apply;
import com.pojo.Apporder;
import com.pojo.Orders;

import java.util.List;

public interface ApplyDao {
    //获取所有药品总价格
    public Apply getApplyPrice(Apply apply);

    //添加订单
    public int addApply(Orders orders);

    //将订单表与订单详情表一一对应
    public int addAppOrder(Apporder apporder);

    public int shiftApply(Apply apply);

    //删除已经加入订单的apply订单的表
    public int delApply(Apply apply);
}
