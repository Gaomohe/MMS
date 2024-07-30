package com.dao.Impl;

import com.dao.OrdersDao;
import com.pojo.Apply;
import com.pojo.Orders;
import com.util.JDBC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
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
                orders.setoNum(resultSet.getString("oNum")); // 订单数量
                orders.setSalePrice(resultSet.getString("salePrice")); // 采购单价
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
                orders.setOrderCondition(resultSet.getString("orderCondition")); // 收货状态
                orders.setStatement(resultSet.getString("statement")); // 收货说明
                orders.setAllPrice(resultSet.getDouble("allPrice"));
                orders.setAdvance(resultSet.getDouble("advance"));
                orders.setAdvanceStatus(resultSet.getString("advanceStatus"));
                orders.setFinals(resultSet.getDouble("finals"));
                orders.setFinalsStatus(resultSet.getString("finalsStatus"));
                ordersList.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ordersList;
    }

    @Override
    public Orders getOrdersById(int id) {
        String sql=" select * from orders where oId=?";
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
                orders.setoNum(resultSet.getString("oNum")); // 订单数量
                orders.setSalePrice(resultSet.getString("salePrice")); // 采购单价
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
                orders.setOrderCondition(resultSet.getString("orderCondition")); // 收货状态
                orders.setStatement(resultSet.getString("statement")); // 收货说明
                orders.setAllPrice(resultSet.getDouble("allPrice"));
                orders.setAdvance(resultSet.getDouble("advance"));
                orders.setAdvanceStatus(resultSet.getString("advanceStatus"));
                orders.setFinals(resultSet.getDouble("finals"));
                orders.setFinalsStatus(resultSet.getString("finalsStatus"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Orders> selectOrders(int page, int limit) {
        String sql=" select * from orders limit ?,?";
        Object[] objects= new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<Orders> list = new ArrayList<Orders>();
        try {
            while (resultSet.next()){
                Orders orders = new Orders();
                orders.setoId(resultSet.getInt("oId")); // 采购单号
                orders.setoName(resultSet.getString("oName")); // 药品名
                orders.setSpecification(resultSet.getString("specification")); // 规格
                orders.setManufactor(resultSet.getString("manufactor")); // 生产企业
                orders.setUnit(resultSet.getString("unit")); // 单位
                orders.setoNum(resultSet.getString("oNum")); // 订单数量
                orders.setSalePrice(resultSet.getString("salePrice")); // 采购单价
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
                orders.setOrderCondition(resultSet.getString("orderCondition")); // 收货状态
                orders.setStatement(resultSet.getString("statement")); // 收货说明
                orders.setAllPrice(resultSet.getDouble("allPrice"));
                orders.setAdvance(resultSet.getDouble("advance"));
                orders.setAdvanceStatus(resultSet.getString("advanceStatus"));
                orders.setFinals(resultSet.getDouble("finals"));
                orders.setFinalsStatus(resultSet.getString("finalsStatus"));
                list.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //获取所有订单（财务）
    @Override
    public List<Orders> getOrders(int page, int limit) {
        String sql="select * from orders\n" +
                "where oName='已审阅通过'\n" +
                "limit ?,?;";
        Object[] objects= new Object[2];
        objects[0]=page;
        objects[1]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<Orders> list = new ArrayList<Orders>();
        try {
            while (resultSet.next()){
                Orders orders = new Orders();
                orders.setoId(resultSet.getInt("oId")); // 采购单号
                orders.setoName(resultSet.getString("oName")); // 药品名
                orders.setSpecification(resultSet.getString("specification")); // 规格
                orders.setManufactor(resultSet.getString("manufactor")); // 生产企业
                orders.setUnit(resultSet.getString("unit")); // 单位
                orders.setoNum(resultSet.getString("oNum")); // 订单数量
                orders.setSalePrice(resultSet.getString("salePrice")); // 采购单价
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
                orders.setOrderCondition(resultSet.getString("orderCondition")); // 收货状态
                orders.setStatement(resultSet.getString("statement")); // 收货说明
                orders.setAllPrice(resultSet.getDouble("allPrice"));
                orders.setAdvance(resultSet.getDouble("advance"));
                orders.setAdvanceStatus(resultSet.getString("advanceStatus"));
                orders.setFinals(resultSet.getDouble("finals"));
                orders.setFinalsStatus(resultSet.getString("finalsStatus"));
                list.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public List<Orders> getOrders() {
        String sql=" select oId from orders";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Orders> list = new ArrayList<Orders>();
        try {
            while (resultSet.next()){
                Orders orders = new Orders();
                orders.setoId(resultSet.getInt(1)); // 采购单号
                list.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
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
        String sql="UPDATE orders SET manufactor=?,shippingAddress=?,deliveryAddress=?,shippingTime=?,shippingWay=?,tempControlWay=?,\n" +
                "deliveryTime=?,deliveryTemp=?,attachment=?,salesman=?,buyer=?,recipient=?,statement=?,allPrice=?,\n" +
                "advance=?,advanceStatus=?,finals=?,finalsStatus=?\n" +
                "WHERE oId = ?;";
        Object[] objects = new Object[19];

        objects[0] = orders.getManufactor();
        objects[1] = orders.getShippingAddress();
        objects[2] = orders.getDeliveryAddress();
        objects[3] = orders.getShippingTime();
        objects[4] = orders.getShippingWay();
        objects[5] = orders.getTempControlWay();
        objects[6] = orders.getDeliveryTime();
        objects[7] = orders.getDeliveryTemp();
        objects[8] = orders.getAttachment();
        objects[9] = orders.getSalesman();
        objects[10] = orders.getBuyer();
        objects[11] = orders.getRecipient();
        objects[12] = orders.getStatement();
        objects[13] = orders.getAllPrice();
        objects[14] = orders.getAdvance();
        objects[15] = orders.getAdvanceStatus();
        objects[16] = orders.getFinals();
        objects[17] = orders.getFinalsStatus();
        objects[18] = orders.getoId();
        int count= JDBC.update(sql,objects);
        return count;
    }

    @Override
    public int addOrders(Orders orders) {
        String sql = "INSERT INTO orders (oName, specification, manufactor, unit, oNum, saleprice, shippingAddress, deliveryAddress, shippingTime, shippingWay, tempControlWay, deliveryTime, deliveryTemp, attachment, salesman, buyer, recipient, `CONDITION`, statement, oId) \n" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?);\n";
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
        objects[17] = orders.getOrderCondition();
        objects[18] = orders.getStatement();
        objects[19] = orders.getoId();
        int count = JDBC.update(sql, objects);
        return count;
    }

    @Override
    public int isUname(Orders orders) {
        String sql="select count(*) as count from orders where oName=?";
        Object[] objects= new Object[1];
        objects[0]=orders.getoName();
        ResultSet resultSet = JDBC.select(sql, objects);
        int count=0;
        try {
            while(resultSet.next()){
                count=resultSet.getInt("count");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }

    //获取订单详情
    @Override
    public List<Apply> getOrderDetails(int oId,int page,int limit) {
        String sql = "select * from appoint\n" +
                "left join app_order on appoint.applyId = app_order.applyId\n" +
                "where app_order.oId = ?\n" +
                "limit ?,?;";
        Object[] objects = new Object[3];
        objects[0]=oId;
        objects[1]=page;
        objects[2]=limit;
        ResultSet resultSet = JDBC.select(sql, objects);
        List<Apply> list = new ArrayList<>();
        try{
            while (resultSet.next()){
                Apply apply=new Apply();
                apply.setApplyId(resultSet.getInt(1));
                apply.setmId(resultSet.getInt(2));
                apply.setmName(resultSet.getString(3));
                apply.setSpecification(resultSet.getString(4));
                apply.setManufactor(resultSet.getString(5));
                apply.setUnit(resultSet.getString(6));
                apply.setDepartment(resultSet.getString(7));
                apply.setNumber(resultSet.getInt(8));
                apply.setApplyNumber(resultSet.getInt(9));
                apply.setPurchasePrice(resultSet.getDouble(10));
                apply.setCode(resultSet.getString(11));
                apply.setmType(resultSet.getString(12));
                apply.setSupplier(resultSet.getString(13));
                apply.setApprovalNumber(resultSet.getString(14));
                apply.setPlaceOrigin(resultSet.getString(15));
                apply.setApplyUser(resultSet.getString(16));
                apply.setApplyTime(resultSet.getString(17));
                apply.setPharmacist(resultSet.getString(18));
                apply.setPharmacistApprove(resultSet.getString(19));
                apply.setPharmacistTime(resultSet.getString(20));
                apply.setFinance(resultSet.getString(21));
                apply.setFinanceApprove(resultSet.getString(22));
                apply.setFinanceTime(resultSet.getString(23));
                apply.setTableCoding(resultSet.getInt(24));
                list.add(apply);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    //订单退退货
    @Override
    public int backOrder(int oId,String username) {
        String sql = "update orders set statement='退货',recipient = ?\n" +
                "where oId = ?;";
        Object[] objects = new Object[2];
        objects[0] = username;
        objects[1]=oId;
        int result = JDBC.update(sql, objects);
        return result;
    }

    //订单确认
    @Override
    public int getOrder(int oId,String username) {
        String sql = "update orders set statement='已完成',recipient = ?\n" +
                "where oId = ?;";
        Object[] objects = new Object[2];
        objects[0] = username;
        objects[1]=oId;
        int result = JDBC.update(sql, objects);
        return result;
    }

    @Override
    public List<Orders> getOrderList() {
        String sql = "select manufactor from orders\n" +
                "group by manufactor;";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Orders> list = new ArrayList<>();
        try{
            while (resultSet.next()){
                Orders orders=new Orders();
                orders.setManufactor(resultSet.getString("manufactor")); // 生产企业
                list.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }@Override
    public List<Orders> getOrderList1() {
        String sql = "select buyer from orders\n" +
                "group by buyer";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Orders> list = new ArrayList<>();
        try{
            while (resultSet.next()){
                Orders orders=new Orders();
                orders.setBuyer(resultSet.getString("buyer")); // 采购人
                list.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public List<Orders> getOrderList2() {
        String sql = "select statement from orders\n" +
                "group by statement;";
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Orders> list = new ArrayList<>();
        try{
            while (resultSet.next()){
                Orders orders=new Orders();
                orders.setStatement(resultSet.getString("statement")); // 收货说明

                list.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Orders> Search(String sql) {
        ResultSet resultSet = JDBC.select(sql, new Object[1]);
        List<Orders> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                Orders orders = new Orders();
                orders.setoId(resultSet.getInt("oId")); // 采购单号
                orders.setoName(resultSet.getString("oName")); // 药品名
                orders.setSpecification(resultSet.getString("specification")); // 规格
                orders.setManufactor(resultSet.getString("manufactor")); // 生产企业
                orders.setUnit(resultSet.getString("unit")); // 单位
                orders.setoNum(resultSet.getString("oNum")); // 订单数量
                orders.setSalePrice(resultSet.getString("salePrice")); // 采购单价
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
                orders.setOrderCondition(resultSet.getString("orderCondition")); // 收货状态
                orders.setStatement(resultSet.getString("statement")); // 收货说明
                orders.setAllPrice(resultSet.getDouble("allPrice"));
                orders.setAdvance(resultSet.getDouble("advance"));
                orders.setAdvanceStatus(resultSet.getString("advanceStatus"));
                orders.setFinals(resultSet.getDouble("finals"));
                orders.setFinalsStatus(resultSet.getString("finalsStatus"));
                list.add(orders);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
