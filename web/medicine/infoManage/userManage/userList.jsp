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
<body class="childrenBody">

<div class="layuimini-container">
    <div class="layuimini-main">
        <blockquote class="layui-elem-quote quoteBox">
            用户管理
        </blockquote>
        <script type="text/html" id="toolbarDemo">
            <c:forEach var="menu" items="${menuList}" varStatus="s">
                ${menu.resUrl}
            </c:forEach>
        </script>
        <table id="userList" lay-filter="userList"></table>
        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>
</div>
<!-- 分配权限 -->
<div style="height: 400px;overflow: auto;display: none;" id="dtree1" >
    <ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>

<!-- 分配角色 -->
<div style="height: 400px;overflow: auto;display: none;" id="hairRole">
    <select name="Roleid" id="RoleName" lay-filter="RoleName">

    </select>
</div>


<%--<script type="text/javascript" src="../admin/lib/layui-v2.5.5/layui.js"></script>--%>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<%--<script type="text/javascript" src="../../pagejs/system/user/userList.js"></script>--%>
<script type="text/javascript" language="JavaScript" src="<%=basePath %>medicinejs/infoManage/userManage/userList.js" charset="UTF-8"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/pagejs/system/user/userList.js" charset="utf-8"></script>--%>
</body>
</html>