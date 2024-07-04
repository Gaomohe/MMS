package com.service;

import com.pojo.Middleman;
import com.pojo.Orders;
import com.pojo.Role;
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
}
