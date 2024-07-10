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
        <input type="text" name="rId" lay-verify="rId" placeholder="请输入出库单号" autocomplete="off" class="layui-input">
      </div>
    </div>
    <%--药品信息--%>
    <%--可通过药品名称查询有哪些药品是入库的--%>
    <div class="layui-inline">
      <label style="width: auto" class="layui-form-label">药品信息:</label>
      <div class="layui-input-inline">
        <input type="text" name="rName" lay-verify="rName" placeholder="请输入药品名称" autocomplete="off" class="layui-input">
      </div>
    </div>

<%--    <div class="layui-form-item">--%>
<%--    这个layui-form-item是独占一行的意思--%>
      <div class="layui-inline">
        <label class="layui-form-label">出库日期:</label>
        <div class="layui-inline" id="ID-laydate-rangeLinked">
          <div class="layui-input-inline" style="">
            <input type="text" autocomplete="off" id="ID-laydate-start-date-1" class="layui-input" placeholder="开始日期">
          </div>
          <div class="layui-form-mid">-</div>
          <div class="layui-input-inline">
            <input type="text" autocomplete="off" id="ID-laydate-end-date-1" class="layui-input" placeholder="结束日期">
          </div>
        </div>
        <button type="button" class="layui-btn layui-bg-blue">查询</button>
        <button class="layui-btn layui-btn-primary layui-border">重置</button>
      </div>
<%--    </div>--%>

    <%--可根据入库日期查询药品入库单信息--%>



    <script type="text/html" id="stockOutFormDemo">
      <c:forEach var="menu" items="${menuList}" varStatus="s">
        ${menu.resUrl}
      </c:forEach>
    </script>

    <table id="stockOutFormList" lay-filter="stockOutFormList"></table>
  </div>
</div>

<!-- 请勿在项目正式环境中引用该 layui.js 地址 -->
<script src="//unpkg.com/layui@2.9.13/dist/layui.js"></script>
<script>
  layui.use(function () {
    var laydate = layui.laydate;

    // 日期范围 - 左右面板联动选择模式
    laydate.render({
      elem: '#ID-laydate-rangeLinked',
      range: ['#ID-laydate-start-date-1', '#ID-laydate-end-date-1'],
      rangeLinked: true // 开启日期范围选择时的区间联动标注模式 ---  2.8+ 新增
    });

  });
</script>

<!-- 权限更改 -->
<div style="height: 400px;overflow: auto;display: none" id="dtree1">
  <ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>

<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockOutForm/stockOutFormList.js" charset="utf-8"></script>
</body>
</html>