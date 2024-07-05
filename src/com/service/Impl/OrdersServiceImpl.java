package com.service.Impl;

import com.pojo.Orders;
import com.service.OrdersService;
import com.util.LayuiTable;
import com.util.ResultData;

import java.util.List;

import static com.util.Vessel.ordersDao;

public class OrdersServiceImpl implements OrdersService {
    @Override
    public List<Orders> getOrdersList() {
        return ordersDao.selectOrders();
    }

    @Override
    public LayuiTable<Orders> selectOrders(int page, int limit) {
        int curePage = (page-1)*limit;
        List<Orders> ordersAll = ordersDao.selectOrders(curePage, limit);
        LayuiTable<Orders> ordersLayuiTable = new LayuiTable<Orders>();
        ordersLayuiTable.setMsg("");
        ordersLayuiTable.setCode(0);
        ordersLayuiTable.setCount(ordersDao.selectOrders().size());
        ordersLayuiTable.setData(ordersAll);
        return ordersLayuiTable;
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
