<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-08
  Time: 16:28
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
    <title>审批</title>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
        font-weight: bold;
    }
</style>
<body>
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
    <table id="tableID">
        <thead>
        <tr>
            <th></th>
            <th>单据编号</th>
            <th>药品名称</th>
            <th>药品库存</th>
            <th>申请数量</th>
        </tr>
        </thead>
        <tbody id="table-body">
        <!-- 动态填充数据的地方 -->
        </tbody>
    </table>
<%--    <div class="layuimini-container">--%>
<%--        <div class="layuimini-main">--%>
<%--            <script type="text/html" id=""></script>>--%>
<%--        </div>--%>
<%--    </div>--%>

    <br/><br/>
    <div class="layui-form-item" style="width: 50%;margin: auto">

        <button id="isok" type="button" class="layui-btn layui-bg-blue">通过</button>
        <button id="nook" type="button" class="layui-btn layui-bg-red">不通过</button>
        <button id="allok" type="button" class="layui-btn">全部通过</button>
        <button id="out" class="layui-btn layui-btn-primary layui-border">取消</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>--%>
<script type="text/javascript" src="<%=basePath %>medicinejs/approveManage/purchaseApproval/audit.js" charset="utf-8"></script>
</body>
</html>
