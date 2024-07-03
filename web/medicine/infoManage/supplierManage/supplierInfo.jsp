<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>新增供应商</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
    <div class="layui-form-item">
        <label class="layui-form-label">供应商编号</label>
        <div class="layui-input-inline">
            <input type="text" name="supplierId" id="supplierId" disabled=""	 lay-verify="required" placeholder="供货商编号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供应商名称</label>
        <div class="layui-input-inline">
            <input type="text" name="sname2" id="sname2" readonly style="display:none" lay-verify="required" placeholder="请输入供应商名称" autocomplete="off" class="layui-input">
            <input type="text" name="sname" id="sname" lay-verify="required" placeholder="请输入供应商名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="upSupplier">修改供应商</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/infoManage/supplierManage/infoSupplier.js"></script>
</body>
</html>