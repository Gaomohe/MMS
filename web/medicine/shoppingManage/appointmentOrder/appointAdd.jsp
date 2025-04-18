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
    <title>预购订单生成</title>
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

<form action="javascript:void(0)">
    <div class="layuimini-container">
        <div class="layuimini-main">
            <table id="medicineList" lay-filter="medicineList"></table>
            <script type="text/html" id="medicineDemo">

                <%--<c:forEach var="menu" items="${menuList}" varStatus="s">
                    ${menu.resUrl}
                </c:forEach>--%>

            </script>
            <button id="submit" lay-event="submit" lay-filter="submit" class="layui-btn" lay-submit>确认</button>
            <button id="cancel" lay-event="cancel" lay-filter="cancel" class="layui-btn" lay-submit>取消</button>



        </div>
    </div>
</form>

<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/shoppingManagejs/appointmentOrder/appointAdd.js" charset="UTF-8"></script>

</body>
</html>