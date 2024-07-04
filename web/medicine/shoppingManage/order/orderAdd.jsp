<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>新增供应商</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">

    <div class="layui-form-item">
        <label class="layui-form-label">药品名</label>
        <div class="layui-input-inline">
            <input type="text" name="oName" id="oName" lay-verify="required" placeholder="请输入药品名" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">规格</label>
        <div class="layui-input-inline">
            <input type="text" name="specification" id="specification" lay-verify="required" placeholder="请输入规格" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">生产企业</label>
        <div class="layui-input-inline">
            <input type="text" name="manufactor" id="manufactor" lay-verify="required" placeholder="请输入生产企业" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单位</label>
        <div class="layui-input-inline">
            <input type="text" name="unit" id="unit" lay-verify="required" placeholder="请输入单位" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">订单数量</label>
        <div class="layui-input-inline">
            <input type="text" name="oNum" id="oNum" lay-verify="required" placeholder="请输入订单数量" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
    <label class="layui-form-label">采购单价</label>
    <div class="layui-input-inline">
        <input type="text" name="salePrice" id="salePrice" lay-verify="required" placeholder="请输入采购单价" autocomplete="off" class="layui-input">
    </div>
    </div>

    <div class="layui-form-item">
    <label class="layui-form-label">发货地址</label>
    <div class="layui-input-inline">
        <input type="text" name="shippingAddress" id="shippingAddress" lay-verify="required" placeholder="请输入发货地址" autocomplete="off" class="layui-input">
    </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">收货地址</label>
        <div class="layui-input-inline">
            <input type="text" name="deliveryAddress" id="deliveryAddress" lay-verify="required" placeholder="请输入收货地址" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">发货时间</label>
        <div class="layui-input-inline">
            <input type="text" name="shippingTime" id="shippingTime" lay-verify="required" placeholder="请输入发货时间" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">发货方式</label>
        <div class="layui-input-inline">
            <input type="text" name="shippingWay" id="shippingWay" lay-verify="required" placeholder="请输入发货方式" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">温控方式</label>
        <div class="layui-input-inline">
            <input type="text" name="tempControlWay" id="tempControlWay" lay-verify="required" placeholder="请输入温控方式" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">到货时间</label>
        <div class="layui-input-inline">
            <input type="text" name="deliveryTime" id="deliveryTime" lay-verify="required" placeholder="请输入到货时间" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">到货温度</label>
        <div class="layui-input-inline">
            <input type="text" name="deliveryTemp" id="deliveryTemp" lay-verify="required" placeholder="请输入到货温度" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">关联附件</label>
        <div class="layui-input-inline">
            <input type="text" name="attachment" id="attachment" lay-verify="required" placeholder="请输入关联附件" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">供货单位业务员</label>
        <div class="layui-input-inline">
            <input type="text" name="salesman" id="salesman" lay-verify="required" placeholder="请输入供货单位业务员" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">采购人</label>
        <div class="layui-input-inline">
            <input type="text" name="buyer" id="buyer" lay-verify="required" placeholder="请输入采购人" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">收货人</label>
        <div class="layui-input-inline">
            <input type="text" name="recipient" id="recipient" lay-verify="required" placeholder="请输入收货人" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">收货状态</label>
        <div class="layui-input-inline">
            <input type="text" name="condition" id="condition" lay-verify="required" placeholder="请输入收货状态" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">收货说明</label>
        <div class="layui-input-inline">
            <input type="text" name="statement" id="statement" lay-verify="required" placeholder="请输入收货说明" autocomplete="off" class="layui-input">
        </div>
    </div>

    <br/><br/>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="addOrders">新增采购订单</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/shoppingManagejs/order/addOrder.js"></script>
</body>
</html>