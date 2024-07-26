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
    <title>详情</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <%--    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.9.13/layui/css/layui.css" media="all" />--%>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body class="childrenBody">
<div class="layuimini-container">
    <div class="layuimini-main">
        <script type="text/html" id="purchaseDemo">
            <button lay-event="del" class="layui-btn layui-btn-primary layui-border"><i class="layui-icon layui-icon-delete"></i> 删除</button>
            <button lay-event="delOK" type="button" class="layui-btn layui-bg-red">未审阅</button>
            <button lay-event="audit" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-ok"></i>审核</button>
            <button lay-event="noaudit" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-disabled"></i>反审核</button>
            <button lay-event="download" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-download-circle"></i>导出</button>
        </script>

        <table id="detailList" lay-filter="detailList "></table>
    </div>
</div>



<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/approveManage/purchaseApproval/detailData.js" charset="utf-8"></script>


</body>
</html>