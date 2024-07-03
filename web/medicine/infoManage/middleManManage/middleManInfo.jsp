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
        <label class="layui-form-label">经手人姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="mname" id="mname" lay-verify="required" placeholder="请输入经手人姓名 autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="tel" id="tel" lay-verify="required" placeholder="请输入经手人电话号码" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email" id="email" lay-verify="required" placeholder="请输入经手人邮箱" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">部门</label>
        <div class="layui-input-inline">
            <input type="text" name="department" id="department" lay-verify="required" placeholder="请输入经手人部门" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">经手药品名</label>
        <div class="layui-input-inline">
            <input type="text" name="medName" id="medName" lay-verify="required" placeholder="请输入经手药品名" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">药品规格</label>
        <div class="layui-input-inline">
            <input type="text" name="standard" id="standard" lay-verify="required" placeholder="请输入药品规格" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">经手数量</label>
        <div class="layui-input-inline">
            <input type="text" name="medNum" id="medNum" lay-verify="required" placeholder="请输入经手数量" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">经手时间</label>
        <div class="layui-input-inline">
            <input type="text" name="date" id="date" lay-verify="required" placeholder="请输入经手时间" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">经手地点</label>
        <div class="layui-input-inline">
            <input type="text" name="place" id="place" lay-verify="required" placeholder="请输入经手地点" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">供货商名称</label>
        <div class="layui-input-inline">
            <input type="text" name="supplierName" id="supplierName" lay-verify="required" placeholder="请输入供货商名称" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="upSupplier">修改供应商</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/infoManage/middleManManage/infoMiddleMan.js"></script>
</body>
</html>