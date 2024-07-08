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
    <title>采购审批</title>
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
        <blockquote class="layui-elem-quote layui-quote-nm">
            采购审批
        </blockquote>
        <script type="text/html" id="purchaseDemo">
<%--           组件--%>

<%--输入单据编号--%>
<div class="layui-inline">
    <label style="width: auto" class="layui-form-label">申请编号:</label>
    <div class="layui-input-inline">
        <input type="text" name="email" lay-verify="email" placeholder="请输入申请编号" autocomplete="off" class="layui-input">
    </div>
</div>

<%--输入药品名称--%>
<div class="layui-inline">
    <label style="width: auto" class="layui-form-label">药品名称:</label>
    <div class="layui-input-inline">
        <input type="text" name="email" lay-verify="email" placeholder="请输入药品名称" autocomplete="off" class="layui-input">
    </div>
</div>
<%--申请时间--%>
<div class="layui-inline">
    <label style="width: auto" class="layui-form-label">申请时间:</label>
    <div class="layui-input-inline">
        <input type="text" class="layui-input" id="ID-laydate-demo" placeholder="请选择时间">
    </div>
</div>
<hr class="layui-border-green">

<hr class="layui-border-green">

<button type="button" class="layui-btn layui-bg-blue">查询</button>
<button class="layui-btn layui-btn-primary layui-border-green"><i class="layui-icon layui-icon-refresh-1"></i>重置</button>
<button class="layui-btn layui-btn-primary layui-border"><i class="layui-icon layui-icon-delete"></i> 删除</button>
<button class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-ok"></i>审核</button>
<button class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-download-circle"></i>导出</button>
<%--            申请人--%>

        </script>

        <table id="purchaseList" lay-filter="purchaseList"></table>
    </div>
</div>



<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>--%>
<script type="text/javascript" src="<%=basePath %>medicinejs/approveSysrem/purchaseApproval/purchaseList.js" charset="utf-8"></script>
<script>
    layui.use(function(){
        var laydate = layui.laydate;
        // 渲染
        laydate.render({
            elem: '#ID-laydate-demo'
        });
    });
</script>
</body>
</html>