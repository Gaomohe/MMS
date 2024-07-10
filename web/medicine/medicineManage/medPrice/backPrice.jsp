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
  <link rel="stylesheet" href="<%=path%>iframe/assets/libs/layui/css/layui.css" />
  <link rel="stylesheet" href="<%=path%>iframe/assets/module/admin.css?v=314" />
  <link rel="stylesheet" href="<%=path%>iframe/assets/module/formSelects/formSelects-v4.css"/>
  <link rel="stylesheet" href="<%=path%>iframe/assets/module/city-picker/city-picker.css"/>
  <script src="<%=path%>iframe/assets/module/city-picker/city-picker.data.js"></script>
</head>
<body>
<div class="layui-fluid">
  <div class="layui-card">
    <div class="layui-card-body" style="padding-top: 5px;">
      <div class="layui-tab layui-tab-brief" lay-filter="tableXTab">
        <div class="layui-tab-content" style="padding-left: 0;padding-right: 0;">
          <%--第三页--%>
          <div class="layui-tab-item ">
            <table id="xTable3" lay-filter="xTable3"></table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
<script type="text/javascript" src="<%=path%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>iframe/assets/js/common.js"></script>
<script type="text/javascript" src="<%=path%>medicinejs/medicineManage/medDictionary/backPrice.jsp" charset="UTF-8"></script>
</html>