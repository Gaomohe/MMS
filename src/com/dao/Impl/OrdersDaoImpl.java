package com.dao.Impl;

import com.dao.Impl.init.InitDaoImpl;
import com.dao.OrdersDao;
import com.pojo.Orders;
import com.pojo.Role;
import com.pojo.User;
import com.util.JDBC;
import com.util.LayuiTable;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao{

    @Override
    public List<Orders> selectOrders() {
        String sql=" select * from orders";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Orders> ordersList = new ArrayList<Orders>();
        Orders orders = new Orders();
        try {
            while (resultSet.next()){
                orders.setoId(resultSet.getInt("oId")); // 采购单号
                orders.setoName(resultSet.getString("oName")); // 药品名
                orders.setSpecification(resultSet.getString("specification")); // 规格
                orders.setManufactor(resultSet.getString("manufactor")); // 生产企业
                orders.setUnit(resultSet.getString("unit")); // 单位
                orders.setoNum(resultSet.getInt("oNum")); // 订单数量
                orders.setSalePrice(resultSet.getDouble("salePrice")); // 采购单价
                orders.setShippingAddress(resultSet.getString("shippingAddress")); // 发货地址
                orders.setDeliveryAddress(resultSet.getString("deliveryAddress")); // 收货地址
                orders.setShippingTime(resultSet.getString("shippingTime")); // 发货时间
                orders.setShippingWay(resultSet.getString("shippingWay")); // 发货方式
                orders.setTempControlWay(resultSet.getString("tempControlWay")); // 温控方式
                orders.setDeliveryTime(resultSet.getString("deliveryTime")); // 到货时间
                orders.setDeliveryTemp(resultSet.getString("deliveryTemp")); // 到货温度
                orders.setAttachment(resultSet.getString("attachment")); // 关联附件
                orders.setSalesman(resultSet.getString("salesman")); // 供货单位业务员
                orders.setBuyer(resultSet.getString("buyer")); // 采购人
                orders.setRecipient(resultSet.getString("recipient")); // 收货人
                orders.setCondition(resultSet.getString("condition")); // 收货状态
                orders.setStatement(resultSet.getString("statement")); // 收货说明
                ordersList.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ordersList;
    }

    @Override
    public Orders getOrdersById(int id) {
        String sql=" select * from orders where oid=?";
        Object[] objects = new Object[1];
        objects[0]=id;
        ResultSet resultSet = JDBC.select(sql, objects);
        Orders orders = new Orders();
        try {
            while (resultSet.next()){
                orders.setoId(resultSet.getInt("oId")); // 采购单号
                orders.setoName(resultSet.getString("oName")); // 药品名
                orders.setSpecification(resultSet.getString("specification")); // 规格
                orders.setManufactor(resultSet.getString("manufactor")); // 生产企业
                orders.setUnit(resultSet.getString("unit")); // 单位
                orders.setoNum(resultSet.getInt("oNum")); // 订单数量
                orders.setSalePrice(resultSet.getDouble("salePrice")); // 采购单价
                orders.setShippingAddress(resultSet.getString("shippingAddress")); // 发货地址
                orders.setDeliveryAddress(resultSet.getString("deliveryAddress")); // 收货地址
                orders.setShippingTime(resultSet.getString("shippingTime")); // 发货时间
                orders.setShippingWay(resultSet.getString("shippingWay")); // 发货方式
                orders.setTempControlWay(resultSet.getString("tempControlWay")); // 温控方式
                orders.setDeliveryTime(resultSet.getString("deliveryTime")); // 到货时间
                orders.setDeliveryTemp(resultSet.getString("deliveryTemp")); // 到货温度
                orders.setAttachment(resultSet.getString("attachment")); // 关联附件
                orders.setSalesman(resultSet.getString("salesman")); // 供货单位业务员
                orders.setBuyer(resultSet.getString("buyer")); // 采购人
                orders.setRecipient(resultSet.getString("recipient")); // 收货人
                orders.setCondition(resultSet.getString("condition")); // 收货状态
                orders.setStatement(resultSet.getString("statement")); // 收货说明
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public LayuiTable<Orders> selectOrders(int page, int limit) {
        String sql=" select * from orders limit ?,?";
        Object[] objects= new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<Orders> list = new ArrayList<Orders>();
        LayuiTable<Orders> layuiTable = new LayuiTable<Orders>();
        try {
            while (resultSet.next()){
                Orders orders = new Orders();
                orders.setoId(resultSet.getInt("oId")); // 采购单号
                orders.setoName(resultSet.getString("oName")); // 药品名
                orders.setSpecification(resultSet.getString("specification")); // 规格
                orders.setManufactor(resultSet.getString("manufactor")); // 生产企业
                orders.setUnit(resultSet.getString("unit")); // 单位
                orders.setoNum(resultSet.getInt("oNum")); // 订单数量
                orders.setSalePrice(resultSet.getDouble("salePrice")); // 采购单价
                orders.setShippingAddress(resultSet.getString("shippingAddress")); // 发货地址
                orders.setDeliveryAddress(resultSet.getString("deliveryAddress")); // 收货地址
                orders.setShippingTime(resultSet.getString("shippingTime")); // 发货时间
                orders.setShippingWay(resultSet.getString("shippingWay")); // 发货方式
                orders.setTempControlWay(resultSet.getString("tempControlWay")); // 温控方式
                orders.setDeliveryTime(resultSet.getString("deliveryTime")); // 到货时间
                orders.setDeliveryTemp(resultSet.getString("deliveryTemp")); // 到货温度
                orders.setAttachment(resultSet.getString("attachment")); // 关联附件
                orders.setSalesman(resultSet.getString("salesman")); // 供货单位业务员
                orders.setBuyer(resultSet.getString("buyer")); // 采购人
                orders.setRecipient(resultSet.getString("recipient")); // 收货人
                orders.setCondition(resultSet.getString("condition")); // 收货状态
                orders.setStatement(resultSet.getString("statement")); // 收货说明
                list.add(orders);
            }
            layuiTable.setData(list);
        }catch (Exception e){
            e.printStackTrace();
        }
        return layuiTable;
    }

    @Override
    public int delOrders(int id) {
        String sql=" delete from orders where oId=?";
        Object[] objects= new Object[1];
        objects[0]=id;
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int updateOrders(Orders orders) {
        String sql="UPDATE orders SET oName = ?,specification = ?,manufactor = ?,unit = ?,oNum = ?,saleprice = ?,shippingAddress = ?,deliveryAddress = ?,shippingTime = ?,shippingWay = ?,tempControlWay = ?,deliveryTime = ?,deliveryTemp = ?,attachment = ?,salesman = ?,buyer = ?,recipient = ?,condition = ?,statement = ? WHERE oId = ?";
        Object[] objects = new Object[20];
        objects[0] = orders.getoName();
        objects[1] = orders.getSpecification();
        objects[2] = orders.getManufactor();
        objects[3] = orders.getUnit();
        objects[4] = orders.getoNum();
        objects[5] = orders.getSalePrice();
        objects[6] = orders.getShippingAddress();
        objects[7] = orders.getDeliveryAddress();
        objects[8] = orders.getShippingTime();
        objects[9] = orders.getShippingWay();
        objects[10] = orders.getTempControlWay();
        objects[11] = orders.getDeliveryTime();
        objects[12] = orders.getDeliveryTemp();
        objects[13] = orders.getAttachment();
        objects[14] = orders.getSalesman();
        objects[15] = orders.getBuyer();
        objects[16] = orders.getRecipient();
        objects[17] = orders.getCondition();
        objects[18] = orders.getStatement();
        objects[19] = orders.getoId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int addOrders(Orders orders) {
        String sql = "insert into orders (oName,specification,manufactor,unit,oNum,saleprice,shippingAddress,deliveryAddress,shippingTime,shippingWay,tempControlWay,deliveryTime,deliveryTemp,attachment,salesman,buyer,recipient,condition,statement) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        Object[] objects = new Object[20];
        objects[0] = orders.getoName();
        objects[1] = orders.getSpecification();
        objects[2] = orders.getManufactor();
        objects[3] = orders.getUnit();
        objects[4] = orders.getoNum();
        objects[5] = orders.getSalePrice();
        objects[6] = orders.getShippingAddress();
        objects[7] = orders.getDeliveryAddress();
        objects[8] = orders.getShippingTime();
        objects[9] = orders.getShippingWay();
        objects[10] = orders.getTempControlWay();
        objects[11] = orders.getDeliveryTime();
        objects[12] = orders.getDeliveryTemp();
        objects[13] = orders.getAttachment();
        objects[14] = orders.getSalesman();
        objects[15] = orders.getBuyer();
        objects[16] = orders.getRecipient();
        objects[17] = orders.getCondition();
        objects[18] = orders.getStatement();
        objects[19] = orders.getoId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int isUname(Orders orders) {
        String sql="select * from orders where oName=?";
        Object[] objects= new Object[1];
        objects[0]=orders.getoName();
        ResultSet resultSet = JDBC.select(sql, objects);
        int i = 0;
        try {
            while(resultSet.next()){
                Orders orders1 = new Orders();
                orders1.setoId(resultSet.getInt(1));
                i = orders1.getoId();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return i;
    }
}
