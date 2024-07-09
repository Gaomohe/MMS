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
    <link href="//cdn.staticfile.net/layui/2.9.13/css/layui.css" rel="stylesheet">    <!-- 请勿在项目正式环境中引用该 layui.css 地址 -->
<%--    <link href="admin\lib\layui-v2.9.13\layui\css\layui.css" rel="stylesheet">--%>
</head>
<body>
<div class="layui-btn-container">

        <div class="layui-inline">
            <label class="layui-form-label">单据日期</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="ID-laydate-type-datetime" placeholder="yyyy-MM-dd HH:mm:ss">
            </div>


        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">单据编号</label>
            <div class="layui-input-inline">
                <input type="text" placeholder="请输入单据编号" class="layui-input">
            </div>
        </div>


</div>

<%--<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>--%>
<script src="//cdn.staticfile.net/layui/2.9.13/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockOutForm/addStockOutForm.js"></script>
</body>
</html>