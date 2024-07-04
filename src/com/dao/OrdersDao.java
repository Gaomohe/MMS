package com.dao;

import com.pojo.Middleman;
import com.pojo.Orders;
import com.pojo.Role;
import com.pojo.User;
import com.util.LayuiTable;

import java.util.List;

public interface OrdersDao {
    //查询全部采购订单
    public List<Orders> selectOrders();
    //按id查询全部订单
    public Orders getOrdersById(int id);
    //分页
    public List<Orders> selectOrders(int page, int limit);
    //删除订单
    public int delOrders(int id);
    //更新订单
    public int updateOrders(Orders orders);
    //添加订单
    public int addOrders(Orders orders);
    //重名验证
    public int isUname(Orders orders);
}
