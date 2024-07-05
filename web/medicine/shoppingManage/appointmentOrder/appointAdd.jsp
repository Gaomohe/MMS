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
    <title>用户中心</title>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" charset="utf-8" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" charset="utf-8" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css" charset="utf-8">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css" charset="utf-8">
</head>
<body class="childrenBody">

<div class="layuimini-container">
    <div class="layuimini-main">
        <script type="text/html" id="appointAddDemo">
            <c:forEach var="menu" items="${menuList}" varStatus="s">
                ${menu.resUrl}
            </c:forEach>
        </script>
        <table id="appointAddList" lay-filter="appointAddList"></table>
        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>
</div>

<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<%--<script type="text/javascript" src="../../pagejs/system/user/userList.js"></script>--%>
<script type="text/javascript" language="JavaScript" src="<%=basePath %>medicinejs/shoppingManagejs/appointmentOrder/appointList.js" charset="UTF-8"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/pagejs/system/user/userList.js" charset="utf-8"></script>--%>
</body>
</html>