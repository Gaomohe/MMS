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
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.9.13/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body class="childrenBody">

<div class="layuimini-container">
    <div class="layuimini-main">

        <blockquote class="layui-elem-quote quoteBox">
            药品入库单列表
        </blockquote>

        <div class="layui-inline">
            <label style="width: auto" class="layui-form-label">入库单号:</label>
            <div class="layui-input-inline">
                <input type="text" name="rId" lay-verify="stockInNum" id="stockInNum" placeholder="请输入入库单号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--药品信息--%>
        <%--可通过药品名称查询有哪些药品是入库的--%>
        <div class="layui-inline">
            <label style="width: auto" class="layui-form-label">药品信息:</label>
            <div class="layui-input-inline">
                <input type="text" name="rName" lay-verify="rName" id="rName" placeholder="请输入药品名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <%--可根据入库日期查询药品入库单信息--%>
                <div class="layui-inline">
                        <label class="layui-form-label">入库日期</label>
                        <div class="layui-input-inline">
                            <input type="text" class="layui-input" id="stockInTime" placeholder="yyyy-MM-dd HH:mm:ss">
                        </div>
                            <button type="button" class="layui-btn layui-bg-blue" id="queryButton">查询</button>
                            <button class="layui-btn layui-btn-primary layui-border" id="resetButton" type="reset">重置</button>
                </div>

        <script type="text/html" id="stockInFormDemo" >
            <c:forEach var="menu" items="${menuList}" varStatus="s">
                ${menu.resUrl}
            </c:forEach>
        </script>

            <table id="stockInFormList" lay-filter="stockInFormList"></table>

    </div>
</div>



        <!-- 权限更改 -->
<div style="height: 400px;overflow: auto;display: none" id="dtree1">
    <ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>

<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockInForm/stockInFormList.js" charset="utf-8"></script>
</body>
</html>