package com.service.Impl;

import com.pojo.Middleman;
import com.pojo.Orders;
import com.pojo.Role;
import com.service.OrdersService;
import com.util.LayuiTable;

import java.util.List;

import static com.util.Vessel.ordersDao;
import static com.util.Vessel.ordersService;

public class OrdersServiceImpl implements OrdersService {
    @Override
    public List<Orders> getOrdersList() {
        return ordersDao.selectOrders();
    }

    @Override
    public LayuiTable<Orders> selectOrders(int page, int limit) {
       return ordersDao.selectOrders(page, limit);
    }

    @Override
    public Orders getOrdersById(int id) {
        return ordersDao.getOrdersById(id);
    }

    @Override
    public int delOrdersById(int id) {
        return ordersDao.delOrders(id);
    }

    @Override
    public int updateDoOrders(Orders orders) {
        return ordersDao.updateOrders(orders);
    }

    @Override
    public int addDoOrders(Orders orders) {
        return ordersDao.addOrders(orders);
    }
    @Override
    public int isUname(Orders orders) {
        return ordersDao.isUname(orders);
    }
}
