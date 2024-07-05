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
    <title>申请表</title>
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
    <c:forEach var="menu" items="${ooo}" varStatus="s">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 400px;">药品编号:药品编号-药品名称:药品名称-药品剩余:药品剩余</label>
            <div class="layui-input-inline">
                <input style="width: 60%" type="text" name="id" id="id" lay-verify="required" placeholder="请输入申请数量" autocomplete="off" class="layui-input">
            </div>
        </div>
    </c:forEach>

    <br/><br/>
    <div class="layui-form-item" style="width: 50%;margin: auto">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="add">申请</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/shoppingManagejs/requestApply/applyList.js"></script>
</body>
</html>