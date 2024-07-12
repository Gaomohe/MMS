<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-11
  Time: 10:47
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
    <!-- 引入 layui.css -->
    <link href="//unpkg.com/layui@2.9.14/dist/css/layui.css" rel="stylesheet">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body>
<div class="layui-form">
    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">中文版</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="ID-laydate-demo" placeholder="yyyy-MM-dd">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">国际版</label>
            <div class="layui-input-inline">
                <input type="text" class="layui-input" id="ID-laydate-demo-en" placeholder="yyyy-MM-dd">
            </div>
        </div>
    </div>
</div>


<!-- 引入 layui.js -->
<script src="//unpkg.com/layui@2.9.14/dist/layui.js"></script>
<%--<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>--%>
<script>
    layui.use(function(){
        var laydate = layui.laydate;
        // 渲染
        laydate.render({
            elem: '#ID-laydate-demo'
        });
        // 英文版
        laydate.render({
            elem: '#ID-laydate-demo-en',
            lang: 'en'
        });
    });
</script>
<%--<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.0.2/dist/echarts.min.js" charset="utf-8"></script>--%>

</body>
</html>
