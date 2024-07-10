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
    <title>采购申请</title>
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
<style>
    .layui-carousel a {
        display: block;
        line-height: 150px;
        text-align: center;
        color: #000;
        font-size: 20px;
    }
    .layui-carousel a:hover {
        color: #e3d01f;
        text-decoration: none;
    }
</style>
<body class="childrenBody">

<div class="layuimini-container">
    <div class="layuimini-main">
        <blockquote class="layui-elem-quote layui-quote-nm">
            <div class="layui-carousel" id="test1" lay-filter="test1">
                <div carousel-item>
                    <!-- 轮播内容 -->
                    <div><a href="javascript:void(0)">安徽省人民政府办公厅关于印发
                        加强矿山全生命周期管理若干措施的通知</a></div>
                    <div><a href="javascript:void(0)">安徽省人民政府办公厅关于印发2024年
                        省政府负责同志联系推进重点项目的通知</a></div>
                    <div><a href="javascript:void(0)">安徽省人民政府办公厅关于
                        2024年第二季度全省政府网站与
                        政务新媒体检查情况的通报</a></div>
                    <!-- 可以根据需要添加更多轮播项 -->
                </div>
            </div>
        </blockquote>
        <script type="text/html" id="shoppDemo">
            <div class="layui-inline">
                <%--            按钮--%>
<%--                <label class="layui-form-label">选择时间:</label>--%>
                <div class="layui-input-inline">
                    <input type="text" lay-event="time" class="layui-input" id="ID-laydate-demo" placeholder="选择时间">
                </div>
            </div>

<div class="layui-inline">
    <div class="layui-input-inline">
        <input type="text" id="searchInput" placeholder="请输入药品名称" class="layui-input">
    </div>
</div>
<button lay-filter="doSearch" lay-submit lay-event="submit" class="layui-btn layui-btn-primary layui-border-green">点击搜索</button>
<button lay-event="add" type="button" class="layui-btn layui-bg-blue">采购申请</button>
<button lay-event="history" type="button" class="layui-btn">历史记录</button>
<button lay-event="prescriptionDrug" type="button" class="layui-btn layui-bg-red">处方药</button>
            <hr>
<%--            下拉--%>
<div class="layui-form layui-row layui-col-space16">
            <div class="layui-col-md2">
                <select lay-filter="onChangeSelect" id="onChangeSelect">
                    <option id="onChangeSelectValue" value="">请选择类型</option>
                    <c:forEach var="kindList" items="${kindList}" varStatus="s">
                        <option value="${kindList.drugFrom}">${kindList.drugFrom}</option>
                    </c:forEach>

                </select>
            </div>
    <div class="layui-col-md8">
        <button lay-event="explain" type="button" class="layui-btn layui-btn-primary layui-btn-radius">说明</button>
    </div>
</div>


        </script>

        <table id="shoppList" lay-filter="shoppList"></table>
    </div>
</div>


<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/shoppingManagejs/requestApply/shopList.js" charset="utf-8"></script>
<script>
    layui.use(['carousel','laydate'], function(){
        var carousel = layui.carousel;
        carousel.render({
            elem: '#test1'
            ,width: '100%' // 设置容器宽度
            ,arrow: 'always' // 始终显示箭头
            ,height: '120px'
        });
    });
</script>
</body>
</html>