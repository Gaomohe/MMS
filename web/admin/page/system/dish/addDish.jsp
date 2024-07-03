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
    <title>新增角色</title>
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
        <label class="layui-form-label">菜品名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" id="name" lay-verify="required" placeholder="请输入菜品名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">菜品价格</label>
        <div class="layui-input-inline">
            <input type="text" name="price" id="price" lay-verify="required" placeholder="请输入菜品价格" autocomplete="off" class="layui-input">
        </div>
    </div>
    <%--<div class="layui-form-item">
        <label class="layui-form-label">菜品图片</label>
        <div class="layui-input-inline">
            <input type="text" name="picture" id="picture" lay-verify="addDish" placeholder="请上传菜品图片" autocomplete="off" class="layui-input">
        </div>
    </div>--%>
    <div class="layui-upload">
        <input type="text" id="filepath" hidden name="filepath" value="" >
        <button type="button" class="layui-btn" id="ID-upload-demo-btn-2">
            <i class="layui-icon layui-icon-upload"></i> 上传菜品图片
        </button>
        <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 11px;">
            预览图：
            <div class="layui-upload-list" id="upload-demo-preview"></div>
        </blockquote>
    </div>
    <br/><br/>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="submit" lay-submit lay-filter="required">添加菜品</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/pagejs/system/dish/addDish.js"></script>
</body>
</html>