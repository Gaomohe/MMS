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
    <style>
        #main{
            width: 570px;
            height: 600px;
            left: 660px;
            top:-600px;
            background-color: #ffffff;
            position: relative;
            margin-right: 0;
            margin-top: 0;
            z-index: 999;
        }
        #body1{
            width: 654px;
            height: 600px;
            margin-top: 0;
            margin-left: 0;
        }
    </style>
</head>
<body class="childrenBody">

<div class="layuimini-container" style="height: 620px">
    <div class="layuimini-main multinav-scroll" id="body1" >
        <script type="text/html" id="appointDemo">
            <c:forEach var="menu" items="${menuList}" varStatus="s">
                ${menu.resUrl}
            </c:forEach>
            <button lay-event="msg" type="button" class="layui-btn">&nbsp;<i class="layui-icon layui-icon-notice"></i>&nbsp;消息</button>
        </script>
        <table id="appointList" lay-filter="appointList" class="table table-hover"></table>
    </div>
    <div id="main" class="right-div" ><%--style="width: 50%;height: 500px;background-color: #0bb2d4"--%>

    </div>
</div>

<script type="text/javascript" src="<%=basePath%>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.0.2/dist/echarts.min.js" charset="utf-8"></script>
<script type="text/javascript" language="JavaScript" src="<%=basePath %>medicinejs/shoppingManagejs/appointmentOrder/appointList.js" charset="UTF-8"></script>
</body>
</html>