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
    <title>新增商品信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" chacharset="utf-8" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
    <div class="layui-form-item">
        <label class="layui-form-label">商品名称</label>
        <div class="layui-input-inline">
            <input type="text" name="name" id="name" lay-verify="required" placeholder="商品名称" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品描述</label>
        <div class="layui-input-inline">
            <input type="text" name="miaoshu" id="miaoshu" lay-verify="required" placeholder="商品描述" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">一级商品</label>
        <div class="layui-input-inline">
            <select name="one" id="one" lay-filter="one">

            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">二级商品</label>
        <div class="layui-input-inline">
            <select name="two" id="two" lay-filter="one">

            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">三级商品</label>
        <div class="layui-input-inline">
            <select name="three" id="three" lay-filter="one">

            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品价格</label>
        <div class="layui-input-inline">
            <input type="text" name="price" id="price" lay-verify="required" placeholder="商品价格" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品库存</label>
        <div class="layui-input-inline">
            <input type="text" name="num" id="num" placeholder="商品库存"  value="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品图片</label>
        <div class="layui-input-inline">
            <input type="file" name="fileName" id="fileName" placeholder="上传图片" value=""  autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="addUser">新增商品</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/pagejs/product/productAdd.js" charset="utf-8"></script>
</body>
</html>

