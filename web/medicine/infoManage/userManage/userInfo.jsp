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
    <title>修改用户</title>
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
        <label class="layui-form-label">账号</label>
        <div class="layui-input-inline">
            <input type="text" name="uid" id="uid" value="${user1.id}" lay-verify="required" disabled="" placeholder="用户编号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="userName" value="${user1.userName}" id="userName" lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="text" name="password" value="${user1.password}" id="password" placeholder="默认密码123456"  value="123456" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">联系方式</label>
        <div class="layui-input-inline">
            <input type="text" name="telNumber" value="${user1.telNumber}" id="realName" lay-verify="required" placeholder="请输入联系方式" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item" pane="">
        <label class="layui-form-label">性别</label>
        <div class="layui-input-block">
            <input type="radio" name="st_Sex" id="sex1"  value="1" title="男">
            <input type="radio" name="st_Sex" id="sex2" value="2" title="女">
        </div>
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="xiugai" lay-filter="addUser">修改用户</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/pagejs/system/user/infoUser.js" charset="utf-8"></script>
</body>
</html>