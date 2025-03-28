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
    <title>门诊</title>
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
<div class="layui-form">
    <div class="layuimini-container">
        <div class="layuimini-main">
            <script type="text/html" id="pharmacyDemo">
                <form id="searchForm">
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input type="text" id="search" name="search" lay-verify="search" lay-event="search" lay-filter="search" placeholder="请输入搜索字段" autocomplete="off" class="layui-input">
                        </div>
                        <button type="button" id="submit" lay-event="submit" lay-filter="submit" class="layui-btn layui-bg-blue"><i class="layui-icon">&#xe615;</i>查询</button>
                    </div>
                    <button type="button" id="back" lay-event="back" lay-filter="back" class="layui-btn layui-bg-blue"><i class="layui-icon">&#xe65c;</i>药品回滚</button>
                </form>
                <%--<c:forEach var="menu" items="${menuList}" varStatus="s">
                    ${menu.resUrl}
                </c:forEach>--%>

            </script>
            <table id="pharmacyList" lay-filter="pharmacyList"></table>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/outpatientManager/pharmacy/pharmacyList.js" charset="utf-8"></script>
</body>
</html>