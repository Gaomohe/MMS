<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-10
  Time: 18:39
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
<div class="layuimini-container">
    <div class="layuimini-main">
<%--        <blockquote class="layui-elem-quote layui-quote-nm">--%>

<%--        </blockquote>--%>

        <div class="layui-tab" lay-filter="test-hash">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="11">数据</li>
                <li lay-id="22">标签2</li>
                <li lay-id="33">标签3</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <script type="text/html" id="purchaseDemo">
                        <button type="button" class="layui-btn layui-btn-normal layui-btn-radius">百搭按钮</button>
                    </script>
                    <table id="purchaseList" lay-filter="purchaseList"></table>
                </div>
                <div class="layui-tab-item">
                    <div id="main" style="width: 600px;height:400px;"></div>
                </div>
                <div class="layui-tab-item"><div id="pie" style="width: 600px;height:400px;"></div></div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.0.2/dist/echarts.min.js" charset="utf-8"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>--%>
<script type="text/javascript" src="<%=basePath %>medicinejs/GSPReportFormsManage/reportProcure/listreportProcure.js" charset="utf-8"></script>
</body>

</html>
