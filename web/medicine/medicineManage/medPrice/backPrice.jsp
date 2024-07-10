<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>
  </title>
  <link rel="stylesheet" href="<%=basePath%>iframe/assets/libs/layui/css/layui.css" />
  <link rel="stylesheet" href="<%=basePath%>iframe/assets/module/admin.css?v=314" />
  <link rel="stylesheet" href="<%=basePath%>iframe/assets/module/formSelects/formSelects-v4.css"/>
  <link rel="stylesheet" href="<%=basePath%>iframe/assets/module/city-picker/city-picker.css"/>
</head>
<body>
<%
  String tableCoding = request.getParameter("tableCoding");
  String mId = request.getParameter("mId");
  String salePrice = request.getParameter("salePrice");
%>
<input hidden="" id="tab1" value="<%=tableCoding%>">
<input hidden="" id="tab2" value="<%=mId%>">
<input hidden="" id="tab3" value="<%=salePrice%>">
<div class="layui-fluid">
  <div class="layui-card">
    <div class="layui-card-body" style="padding-top: 5px;">
      <div class="layui-tab layui-tab-brief" lay-filter="tableXTab">
        <div class="layui-tab-content" style="padding-left: 0;padding-right: 0;">
            <table id="xTable3" lay-filter="xTable3"></table>
          <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="back">回溯</a>
          </script>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="<%=basePath%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=basePath%>iframe/assets/js/common.js"></script>
<script type="text/javascript" src="<%=basePath%>medicinejs/medicineManage/medPrice/backPrice.js" charset="UTF-8"></script>
</html>