<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>采购订单管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body class="childrenBody">

<div class="layuimini-container">
    <div class="layuimini-main">
        <blockquote class="layui-elem-quote quoteBox">
            采购订单列表
        </blockquote>
        <script type="text/html" id="ordersDemo">

        </script>
        <c:forEach var="menu" items="${menuList}" varStatus="s">
            ${menu.resUrl}
        </c:forEach>

        <table id="ordersList" lay-filter="ordersList"></table>
    </div>
</div>

<!-- 权限更改 -->
<div style="height: 400px;overflow: auto;display: none" id="dtree1">
    <ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>

<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/shoppingManagejs/order/orderList.js" charset="utf-8"></script>
</body>
</html>