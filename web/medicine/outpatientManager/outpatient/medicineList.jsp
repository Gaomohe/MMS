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
    <title>门诊</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body class="childrenBody">
<form>
    <div class="layui-form">
        <div class="layuimini-container">
            <div class="layuimini-main">
                <table id="MedicineList" lay-filter="MedicineList"></table>
                <script type="text/html" id="MedicineDemo">
                    <button type="button" id="submit" lay-event="submit" lay-filter="submit" class="layui-btn layui-bg-blue">确认</button>
                    <button type="button" id="cancel" lay-event="cancel" lay-filter="cancel" class="layui-btn layui-btn-danger">取消</button>
                    <%--<c:forEach var="menu" items="${menuList}" varStatus="s">
                        &lt;%&ndash;                    ${menu.resUrl}&ndash;%&gt;

                    </c:forEach>--%>
                </script>
            </div>
            <table id="addMedicineList2" lay-filter="addMedicineList2"></table>
        </div>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/outpatientManager/outpatient/medicineList.js" charset="utf-8"></script>
</body>
</html>