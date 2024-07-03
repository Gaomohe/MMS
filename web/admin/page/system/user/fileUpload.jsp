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
    <title>用户中心</title>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" charset="utf-8" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" charset="utf-8" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css" charset="utf-8">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css" charset="utf-8">
</head>
<body>
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
    <div class="demo-login-container">
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-username"></i>
                </div>
                <input type="text" name="username" value="" lay-verify="required" placeholder="用户名" lay-reqtext="请填写用户名" autocomplete="off" class="layui-input" lay-affix="clear">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-wrap">
                <div class="layui-input-prefix">
                    <i class="layui-icon layui-icon-password"></i>
                </div>
                <input type="password" name="password" value="" lay-verify="required" placeholder="密   码" lay-reqtext="请填写密码" autocomplete="off" class="layui-input" lay-affix="eye">
            </div>
        </div>
        <div class="layui-upload">
            <input type="text" id="filepath" hidden name="filepath" value="" >
            <button type="button" class="layui-btn" id="ID-upload-demo-btn-2">
                <i class="layui-icon layui-icon-upload"></i> 多图片上传
            </button>
            <blockquote class="layui-elem-quote layui-quote-nm" style="margin-top: 11px;">
                预览图：
                <div class="layui-upload-list" id="upload-demo-preview"></div>
            </blockquote>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>

<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript" language="JavaScript" src="<%=basePath %>admin/pagejs/system/user/file.js" charset="UTF-8"></script>
</body>
</html>
