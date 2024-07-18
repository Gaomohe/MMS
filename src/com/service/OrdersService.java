package com.service;

import com.pojo.Apply;
import com.pojo.Orders;
import com.util.LayuiTable;

import java.util.List;

public interface OrdersService {
    public List<Orders> getOrdersList();
    public LayuiTable<Orders> selectOrders(int page, int limit);
    public Orders getOrdersById(int id);
    public int delOrdersById(int id);
    public int updateDoOrders(Orders orders);
    public int addDoOrders(Orders orders);
    public int isUname(Orders orders);

    //获取订单详情
    public LayuiTable<Apply> getOrderDetails(int oId,int page,int limit);

    //订单退货
    public int backOrder(int oId,String username);

    //订单确认
    public int getOrder(int oId,String username);

    //获取供应商列表
    public List<Orders> getOrderList();
    public List<Orders> getOrderList1();
    public List<Orders> getOrderList2();

    //条件查询订单表
    public LayuiTable<Orders> Search(Orders order);
}
