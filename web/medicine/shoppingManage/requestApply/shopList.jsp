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
    <title>采购申请</title>
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
            采购申请
        </blockquote>
        <script type="text/html" id="shoppDemo">
<%--            按钮--%>
            <button type="button" style="margin-left: 2%" lay-event="add" class="layui-btn layui-btn-warm"><i class="layui-icon">&#xe654;</i>采购申请</button>
<%--            时间--%>
            <div class="layui-inline">
                <label class="layui-form-label">日期:</label>
                <div class="layui-input-inline">
                    <input type="text" lay-event="time" class="layui-input" id="ID-laydate-demo" placeholder="选择时间">
                </div>
            </div>

<%--            下拉--%>
            <div class="layui-col-md2">
                <select lay-filter="onChangeSelect">
                    <option value="">请选择类型</option>
                    <%--        <option value="1">AAA</option>--%>
                    <c:forEach var="kindList" items="${kindList}" varStatus="s">
                        <option value="${kindList.drugFrom}">${kindList.drugFrom}</option>
                    </c:forEach>

                </select>
            </div>
<%--                搜索--%>
<div class="layui-inline">
    <div class="layui-input-inline">
        <input type="text" id="searchInput" placeholder="请输入药品名称" class="layui-input">
    </div>
    <button type="button" class="layui-btn" lay-filter="doSearch" lay-submit lay-event="submit">搜索</button>
</div>

<%--申请历史记录--%>
<button style="margin-top: 2%" type="button" class="layui-btn layui-bg-blue">历史记录</button>

        </script>

        <table id="shoppList" lay-filter="shoppList"></table>
    </div>
</div>


<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/shoppingManagejs/requestApply/shopList.js" charset="utf-8"></script>
</body>
</html>