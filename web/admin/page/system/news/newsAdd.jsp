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
    <title>添加咨询</title>
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
    <%--标题--%>
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <div class="layui-input-inline">
            <input type="text" name="title" id="title" lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>


    <%--内容--%>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">内容</label>
        <div class="layui-input-inline">
            <input type="text" name="content" id="content" lay-verify="required" placeholder="请输入内容" autocomplete="off" class="layui-input">
        </div>
    </div>

    <%--时间--%>
    <div class="layui-form-item">
        <label class="layui-form-label">创建时间</label>
        <div class="layui-input-inline">
            <input type="date" name="createTime" id="createTime" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
    </div>

    <%--提交--%>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" id="newsAjax" lay-submit lay-filter="addNews">添加咨询</button>
        </div>
    </div>

</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/pagejs/system/news/newsAdd.js"></script>


</body>
</html>
