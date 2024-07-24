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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Demo</title>
    <link href="//cdn.staticfile.net/layui/2.9.13/css/layui.css" rel="stylesheet">
</head>

<body>

<div style="position: absolute;left: 1%">
    <table class="layui-table" id="qualityFailedList"></table>`
</div>
<button type="button" class="layui-btn layui-btn-lg layui-btn-normal" id="confirm" style="position:absolute;bottom: 10%;right: 10%">返回</button>



<script src="//cdn.staticfile.net/layui/2.9.13/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockOutForm/stockOutFormInfo.js"></script>
</body>
</html>