package com.service.Impl;

import com.pojo.Apply;
import com.pojo.Orders;
import com.service.OrdersService;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.SQLtoString;

import java.util.Collections;
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

    //获取所有订单(财务）
    @Override
    public LayuiTable<Orders> getOrders(int page, int limit) {
        int curePage = (page-1)*limit;
        List<Orders> ordersAll = ordersDao.getOrders(curePage, limit);
        LayuiTable<Orders> ordersLayuiTable = new LayuiTable<Orders>();
        ordersLayuiTable.setMsg("");
        ordersLayuiTable.setCode(0);
        ordersLayuiTable.setCount(ordersAll.size());
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
        if (!orders.getShippingTime().isEmpty()){
            orders.setAdvanceStatus("已付款");
        }
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

    //获取订单详情
    @Override
    public LayuiTable<Apply> getOrderDetails(int oId,int page,int limit) {
        List<Apply> applyList = ordersDao.getOrderDetails(oId,page,limit);
        LayuiTable<Apply> applyLayuiTable = new LayuiTable<>();
        applyLayuiTable.setMsg("");
        applyLayuiTable.setCode(0);
        applyLayuiTable.setCount(applyList.size());
        applyLayuiTable.setData(applyList);
        return applyLayuiTable;
    }

    //退款
    @Override
    public int backOrder(int oId,String username) {
        return ordersDao.backOrder(oId,username);
    }

    //入库
    @Override
    public int getOrder(int oId,String username) {
        return ordersDao.getOrder(oId,username);
    }

    //获取供应商列表
    @Override
    public List<Orders> getOrderList() {
        int i = 0;
        List<Orders> ordersList = ordersDao.getOrderList();
        for (Orders orders : ordersList) {
            orders.setoId(i);
            i++;
        }
        return ordersList;
    }

    @Override
    public List<Orders> getOrderList1() {
        int i = 0;
        List<Orders> ordersList = ordersDao.getOrderList1();
        for (Orders orders : ordersList) {
            orders.setoId(i);
            i++;
        }
        return ordersList;
    }

    @Override
    public List<Orders> getOrderList2() {
        int i = 0;
        List<Orders> ordersList = ordersDao.getOrderList2();
        for (Orders orders : ordersList) {
            orders.setoId(i);
            i++;
        }
        return ordersList;
    }

    //条件查询订单表
    @Override
    public LayuiTable<Orders> Search(Orders order) {
        String[] keys = {"manufactor","statement","buyer"};
        Object[] values = {order.getManufactor(),order.getStatement(),order.getBuyer()};
        String sql = SQLtoString.getSQL(keys, values, "orders");
        List<Orders> orders = ordersDao.Search(sql);
        LayuiTable<Orders> ordersLayuiTable = new LayuiTable<>();
        ordersLayuiTable.setMsg("");
        ordersLayuiTable.setCode(0);
        ordersLayuiTable.setCount(orders.size());
        ordersLayuiTable.setData(orders);
        return ordersLayuiTable;
    }
}
