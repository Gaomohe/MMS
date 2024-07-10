<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-10
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
<link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
<link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
<link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="layui-timeline">



</div>


<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<%--<script type="text/javascript" src="<%=basePath %>medicinejs/shoppingManagejs/requestApply/shopList.js" charset="utf-8"></script>--%>

</body>
</html>
