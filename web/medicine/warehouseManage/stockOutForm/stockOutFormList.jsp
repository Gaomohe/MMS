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
  <title>采购订单管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta name="apple-mobile-web-app-status-bar-style" content="black">
  <meta name="apple-mobile-web-app-capable" content="yes">
  <meta name="format-detection" content="telephone=no">
  <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
  <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.9.13/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
  <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
  <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body class="childrenBody">

<div class="layuimini-container">
  <div class="layuimini-main">
    <blockquote class="layui-elem-quote quoteBox">
      药品出库单列表
    </blockquote>

    <div class="layui-inline">
      <label style="width: auto" class="layui-form-label">出库单号:</label>
      <div class="layui-input-inline">
        <input type="text" id="outNum" name="outNum" lay-verify="outNum" placeholder="请输入出库单号" autocomplete="off" class="layui-input">
      </div>
    </div>

    <div class="layui-inline">
      <label style="width: auto" class="layui-form-label">药品信息:</label>
      <div class="layui-input-inline">
        <input type="text" id="oName" name="oName" lay-verify="oName" placeholder="请输入药品名称" autocomplete="off" class="layui-input">
      </div>
    </div>


    <div class="layui-inline">
      <label class="layui-form-label">出库日期</label>
      <div class="layui-input-inline">
        <input type="text" class="layui-input" id="stockOutTime" name="stockOutTime" placeholder="yyyy-MM-dd HH:mm:ss">
      </div>

      <button type="button" class="layui-btn layui-bg-blue" id="search">查询</button>
      <button class="layui-btn layui-btn-primary layui-border" id="reset">重置</button>

    </div>



    <script type="text/html" id="stockOutFormDemo">
      <c:forEach var="menu" items="${menuList}" varStatus="s">
        ${menu.resUrl}
      </c:forEach>
    </script>

    <table id="stockOutFormList" lay-filter="stockOutFormList"></table>
  </div>
</div>


<!-- 权限更改 -->
<div style="height: 400px;overflow: auto;display: none" id="dtree1">
  <ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>

<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script src="//unpkg.com/layui@2.9.13/dist/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockOutForm/stockOutFormList.js" charset="utf-8"></script>
</body>
</html>