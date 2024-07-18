package com.servlet;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.pojo.*;
import com.service.OrdersService;
import com.util.BaseServlet;
import com.util.LayuiTable;
import com.util.ResultData;
import com.util.TableJSON;
import com.util.init.ToJSON;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.util.Vessel.*;
import static com.util.Vessel.logService;

@WebServlet("/orders")
public class OrdersServlet extends BaseServlet {

    @Override
    public Class getServlet() {
        return OrdersServlet.class;
    }

    public String getMenuBtn(HttpServletRequest request, HttpServletResponse response){
        int resId = Integer.parseInt(request.getParameter("resId"));
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        return "/medicine/shoppingManage/order/orderList";
    }

    public String getMenuBtn1(HttpServletRequest request, HttpServletResponse response){
        String oIdStr = request.getParameter("oId");
        int theoId = Integer.parseInt(oIdStr);
        int resId = 288;
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Menu> menuList = menuService.getMenuBtn(user.getId(), resId);
        session.setAttribute("menuList",menuList);
        session.setAttribute("theoId",theoId);
        return "/medicine/shoppingManage/order/orderDetail";
    }

    //获取所有订单
    public void selectOrders(HttpServletRequest request, HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        ToJSON.toJson(response, ordersService.selectOrders(page,limit));
    }
    public ResultData isUname(HttpServletRequest request, HttpServletResponse response){
        String oName = request.getParameter("oName");
        Orders orders = new Orders();
        orders.setoName(oName);
        int uname = ordersService.isUname(orders);
        ResultData<Orders> resultData = new ResultData<Orders>();
        if (uname>0){
            resultData.setStatus(400);
            resultData.setMsg("有重复");
            resultData.setData(orders);
        }else {
            resultData.setStatus(200);
            resultData.setMsg("无重复");
            resultData.setData(orders);
        }
        return resultData;
    }
    public ResultData checkOrdersName(HttpServletRequest request, HttpServletResponse response){
        String oName = request.getParameter("oName");
        Orders orders = new Orders();
        orders.setoName(oName);
        int uname = ordersService.isUname(orders);
        ResultData<Orders> resultData = new ResultData<Orders>();
        if (uname>0){
            resultData.setStatus(400);
            resultData.setMsg("有重复");
            resultData.setData(orders);
        }else {
            resultData.setStatus(200);
            resultData.setMsg("无重复");
            resultData.setData(orders);
        }
        return resultData;
    }
    public ResultData addOrders(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        Orders orders = new Orders();
        orders.setoId(Integer.parseInt(request.getParameter("oId")));
        orders.setoName(request.getParameter("oName")); // 药品名
        orders.setSpecification(request.getParameter("Specification")); // 规格
        orders.setManufactor(request.getParameter("Manufactor")); // 生产企业
        orders.setUnit(request.getParameter("Unit")); // 单位
        orders.setoNum(Integer.parseInt(request.getParameter("oNum"))); // 订单数量
        orders.setSalePrice(Integer.parseInt(request.getParameter("salePrice"))); // 采购单价
        orders.setShippingAddress(request.getParameter("ShippingAddress")); // 发货地址
        orders.setDeliveryAddress(request.getParameter("DeliveryAddress")); // 收货地址
        orders.setShippingTime(request.getParameter("ShippingTime")); // 发货时间
        orders.setShippingWay(request.getParameter("ShippingWay")); // 发货方式
        orders.setTempControlWay(request.getParameter("TempControlWay")); // 温控方式
        orders.setDeliveryTime(request.getParameter("DeliveryTime")); // 到货时间
        orders.setDeliveryTemp(request.getParameter("DeliveryTemp")); // 到货温度
        orders.setAttachment(request.getParameter("Attachment")); // 关联附件
        orders.setSalesman(request.getParameter("Salesman")); // 供货单位业务员
        orders.setBuyer(request.getParameter("Buyer")); // 采购人
        orders.setRecipient(request.getParameter("Recipient")); // 收货人
        orders.setOrderCondition(request.getParameter("orderCondition")); // 收货状态
        orders.setStatement(request.getParameter("Statement")); // 收货说明
        int i = ordersService.addDoOrders(orders);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("添加成功");
            resultData.setData(orders);
        }
        return resultData;
    }
    public ResultData delOrders(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("oId"));
        ResultData resultData = new ResultData();
        int i = ordersService.delOrdersById(id);
        Orders orders = new Orders();
        orders.setoId(id);
        if (i>0){
            resultData.setMsg("删除成功");
            resultData.setStatus(200);
            resultData.setData(orders);
        }
        return resultData;
    }
    public ResultData selectOrdersById(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        int oId =Integer.parseInt(request.getParameter("oId"));
        Orders orders = ordersService.getOrdersById(oId);
        if (oId>0){
            resultData.setStatus(200);
            resultData.setMsg("");
            resultData.setData(orders);
        }
        return resultData;
    }

    public ResultData updateOrders(HttpServletRequest request, HttpServletResponse response){
        ResultData resultData = new ResultData();
        Orders orders = new Orders();
        orders.setoId(Integer.parseInt(request.getParameter("oId")));
        orders.setoName(request.getParameter("oName")); // 药品名
        orders.setSpecification(request.getParameter("specification")); // 规格
        orders.setManufactor(request.getParameter("manufactor")); // 生产企业
        orders.setUnit(request.getParameter("unit")); // 单位
        orders.setoNum(Integer.parseInt(request.getParameter("oNum"))); // 订单数量
        orders.setSalePrice(Integer.parseInt(request.getParameter("salePrice"))); // 采购单价
        orders.setShippingAddress(request.getParameter("shippingAddress")); // 发货地址
        orders.setDeliveryAddress(request.getParameter("deliveryAddress")); // 收货地址
        orders.setShippingTime(request.getParameter("shippingTime")); // 发货时间
        orders.setShippingWay(request.getParameter("shippingWay")); // 发货方式
        orders.setTempControlWay(request.getParameter("tempControlWay")); // 温控方式
        orders.setDeliveryTime(request.getParameter("deliveryTime")); // 到货时间
        orders.setDeliveryTemp(request.getParameter("deliveryTemp")); // 到货温度
        orders.setAttachment(request.getParameter("attachment")); // 关联附件
        orders.setSalesman(request.getParameter("salesman")); // 供货单位业务员
        orders.setBuyer(request.getParameter("buyer")); // 采购人
        orders.setRecipient(request.getParameter("recipient")); // 收货人
        orders.setOrderCondition(request.getParameter("orderCondition")); // 收货状态
        orders.setStatement(request.getParameter("statement")); // 收货说明
        int i = ordersService.updateDoOrders(orders);
        if (i>0){
            resultData.setStatus(200);
            resultData.setMsg("修改成功");
            resultData.setData(orders);
        }
        return resultData;
    }

    //获取订单详情
    public void getOrderDetails(HttpServletRequest request,HttpServletResponse response){
        int page = Integer.parseInt(request.getParameter("page"));
        int limit = Integer.parseInt(request.getParameter("limit"));
        page = (page-1)*limit;
        HttpSession session = request.getSession();
        int oId = (Integer) session.getAttribute("theoId");
        LayuiTable<Apply> layuiTable = ordersService.getOrderDetails(oId,page,limit);
        ToJSON.toJson(response,layuiTable);
    }

    //获取供应商
    public void getOrderList(HttpServletRequest request,HttpServletResponse response){
        List<Orders> orderList = ordersService.getOrderList();
        ToJSON.toJson(response,orderList);
    }
    public void getOrderList1(HttpServletRequest request,HttpServletResponse response){
        List<Orders> orderList = ordersService.getOrderList1();
        ToJSON.toJson(response,orderList);
    }
    public void getOrderList2(HttpServletRequest request,HttpServletResponse response){
        List<Orders> orderList = ordersService.getOrderList2();
        ToJSON.toJson(response,orderList);
    }

    //条件查询表
    public void Search(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        String name = userService.getName(user.getId());
        logService.setLog(name,"点击","采购管理","条件查询所有采购订单");
        String supplier = request.getParameter("supplier");
        String buyUser = request.getParameter("buyUser");
        String status = request.getParameter("status");
        Orders order = new Orders();
        order.setManufactor(supplier);
        order.setBuyer(buyUser);
        order.setStatement(status);
        LayuiTable<Orders> layuiTable = ordersService.Search(order);
        ToJSON.toJson(response,layuiTable);
    }


}
