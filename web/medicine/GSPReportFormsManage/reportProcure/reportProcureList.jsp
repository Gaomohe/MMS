<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-10
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body>
<div class="layui-tab">
    <ul class="layui-tab-title">
        <li class="layui-this">标签1</li>
        <li>标签2</li>
        <li>标签3</li>
        <li>标签4</li>
        <li>标签5</li>
    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">内容-1</div>
        <div class="layui-tab-item">内容-2</div>
        <div class="layui-tab-item">内容-3</div>
        <div class="layui-tab-item">内容-4</div>
        <div class="layui-tab-item">内容-5</div>
    </div>
</div>
<%--<div class="layuimini-container">--%>
<%--    <div class="layuimini-main">--%>
<%--        <blockquote class="layui-elem-quote layui-quote-nm">--%>

<%--        </blockquote>--%>
<%--        --%>
<%--        --%>
<%--&lt;%&ndash;        <script type="text/html" id="purchaseDemo">&ndash;%&gt;--%>
<%--&lt;%&ndash;        &ndash;%&gt;--%>
<%--&lt;%&ndash;        </script>&ndash;%&gt;--%>
<%--    </div>--%>
<%--</div>--%>


<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>--%>
<script type="text/javascript" src="<%=basePath %>medicinejs/GSPReportFormsManage/reportProcure/reportProcureList.js" charset="utf-8"></script>


</body>

</html>
