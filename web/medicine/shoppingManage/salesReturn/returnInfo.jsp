<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>处理货单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath%>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath%>iframe/assets/module/admin.css?v=314" />
    <link rel="stylesheet" href="<%=basePath%>admin/css/public.css" media="all" />
    <style>
        .layui-form-label {
            padding-left: 0;
            padding-right: 0;
            width: 110px;
        }

        .layui-form-item {
            margin-bottom: 30px;
        }
    </style>
</head>
<body class="childrenBody">
<%
    String id = request.getParameter("id");
%>
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
    <div class="layui-form-item">
        <label class="layui-form-label">货单编号</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="id" id="id" value="<%=id%>" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮寄地址</label>
        <div class="layui-input-inline">
            <input id="demoCascader11" placeholder="请选择省市区" class="layui-hide"/>
            <input type="text" name="address" id="address" placeholder="请输入具体位置" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">邮寄方式</label>
        <div class="layui-input-inline">
            <input type="text" name="shippingWay" id="shippingWay" placeholder="请输入邮寄方式" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">寄件人</label>
        <div class="layui-input-inline">
            <input type="text" name="consigner" id="consigner" placeholder="请输入寄件人" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">到货联系方式</label>
        <div class="layui-input-inline">
            <input type="text" name="phone" id="phone" placeholder="请输入联系方式" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="addRole">完成</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>iframe/assets/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>iframe/assets/module/cascader/citys-data.js"></script>
<script type="text/javascript" src="<%=basePath%>medicinejs/shoppingManagejs/salesReturn/returnInfo.js"></script>
</body>
</html>