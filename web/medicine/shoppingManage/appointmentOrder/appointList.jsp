<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-04
  Time: 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<head>
    <meta charset="utf-8">
    <title>采购申请</title>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" charset="utf-8" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" charset="utf-8" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css" charset="utf-8">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css" charset="utf-8">
</head>
<body class="childrenBody">
<div class="layuimini-main">
    <blockquote class="layui-elem-quote quoteBox">
        采购申请
    </blockquote>
    <script type="text/html" id="supplierDemo">

    </script>
    <c:forEach var="menu" items="${menuList}" varStatus="s">
        ${menu.resUrl}
    </c:forEach>

    <div class="layui-form">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">日期:</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="ID-laydate-demo" placeholder="选择时间">
                </div>
            </div>
        </div>
    </div>

    <table id="supplierList" lay-filter="supplierList"></table>
</div>

</body>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript" language="JavaScript" src="<%=basePath %>medicinejs/shoppingManagejs/appointmentOrder/appointList.js" charset="UTF-8"></script>
</html>
