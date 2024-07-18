package com.dao;

import com.pojo.Apply;
import com.pojo.Orders;

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

    //获取订单详情
    public List<Apply> getOrderDetails(int oId,int page,int limit);

    //订单退款
    public int backOrder(int oId,String username);

    //订单确认
    public int getOrder(int oId,String username);

    //获取供应商列表
    public List<Orders> getOrderList();//获取供应商列表
    public List<Orders> getOrderList1();//获取供应商列表
    public List<Orders> getOrderList2();

    //条件查询订单表
    public List<Orders> Search(String sql);
}
