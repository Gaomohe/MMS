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
    <title>添加分类</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
</head>
<body>


<form class="layui-form">
    <%--分类名--%>
    <div class="layui-form-item">
        <label class="layui-form-label">分类名</label>
        <div class="layui-input-inline">
            <input type="text" name="catename" id="name" lay-verify="required" placeholder="请输入分类名" autocomplete="off" class="layui-input">
        </div>
    </div>




        <%--级别--%>
        <div class="layui-form-item layui-row layui-col-xs12">
            <label class="layui-form-label">请选择级别</label>
            <div class="layui-input-block">
                <select name="type" id="type" lay-filter="type">
                    <option value="0">-- 请选择 --</option>
                    <option value="1">-- 一级 --</option>
                    <option value="2">-- 二级 --</option>
                    <option value="3">-- 三级 --</option>
                </select>
            </div>
        </div>

        <%--父级ID--%>
        <div class="layui-form-item layui-row layui-col-xs12">
            <label class="layui-form-label">输入父级ID</label>
            <div class="layui-input-inline">
                <input type="text" name="parentId" id="parentId" lay-verify="required" placeholder="请输入父级ID" autocomplete="off" class="layui-input">
            </div>
        </div>

    <%--提交--%>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" id="cateAjax" lay-submit lay-filter="addCate">添加分类</button>
        </div>
    </div>

</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/pagejs/system/category/categoryAdd.js"></script>


</body>
</html>
