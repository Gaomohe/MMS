<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>修改预警</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath%>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath%>iframe/assets/module/admin.css?v=314" />
    <link rel="stylesheet" href="<%=basePath%>admin/css/public.css" media="all" />
</head>
<body class="childrenBody">
<%
    String id = request.getParameter("id");
    String warnNumber = request.getParameter("warnNumber");
%>
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
    <div class="layui-form-item" style="display: none">
        <label class="layui-form-label">临期编号</label>
        <div class="layui-input-inline">
            <input readonly type="text" name="id" id="id" value="<%=id%>" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">预警数量</label>
        <div class="layui-input-block">
            <input id="number" type="number" lay-affix="number" value="<%=warnNumber%>" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="warning" lay-filter="addRole">修改</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>iframe/assets/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>medicinejs/qualityManage/warn/warnInfo.js"></script>
</body>
</html>