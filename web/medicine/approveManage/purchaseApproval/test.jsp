<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-09
  Time: 8:43
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

<table id="tableID">
    <thead>
    <tr>
        <th>选择</th>
        <th>单据编号</th>

    </tr>
    </thead>
    <tbody id="table-body">
        <tr>
            <td><input type="checkbox" name="AAA" title="默认"></td>
            <td>ssssffff</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="AAA" title="默认"></td>
            <td>ssss</td>
        </tr>
    <!-- 动态填充数据的地方 -->
    </tbody>
</table>
<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>--%>
<script type="text/javascript" src="<%=basePath %>medicinejs/approveManage/purchaseApproval/audit.js" charset="utf-8"></script>

</body>
</html>
