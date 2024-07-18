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
<style>
    .layui-col-md2 {
        display: flex;
        align-items: center;
    }

</style>
<body class="childrenBody">

<div class="layuimini-container">
    <div class="layuimini-main">

        <blockquote class="layui-elem-quote quoteBox">
            药品库存列表
        </blockquote>

        <script type="text/html" id="stockAllFormDemo" src="//unpkg.com/layui@2.9.13/dist/layui.js">

            <div class="layui-form layui-row layui-col-space16">
                <label style="width: auto" class="layui-form-label">查询库存</label>
                <div class="layui-col-md2">
                    <select class="layui-input" id="select1" lay-event="select1" lay-filter="select1">
                        <option value="">商品分类</option>
                        <c:forEach var="type" items="${type1}" varStatus="s">
                            <option value="${type.typename}">${type.typename}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="layui-col-md2">
                    <select class="layui-input" id="select2" lay-event="select2" lay-filter="select2">
                        <option value="">药品分类</option>
                        <<c:forEach var="type" items="${type2}" varStatus="s">
                        <option value="${type.typename}">${type.typename}</option>
                    </c:forEach>
                    </select>
                </div>

                <div class="layui-col-md2">
                    <select class="layui-input" id="select3" lay-event="select3" lay-filter="select3">
                        <option value="">自定义类</option>
                        <<c:forEach var="type" items="${type3}" varStatus="s">
                        <option value="${type.typename}">${type.typename}</option>
                    </c:forEach>
                    </select>
                </div>

                <div class="layui-col-md2">
                    <select class="layui-input" id="select4" lay-event="select4" lay-filter="select4">
                        <option value="">剂型</option>
                        <<c:forEach var="type" items="${type4}" varStatus="s">
                        <option value="${type.typename}">${type.typename}</option>
                    </c:forEach>
                    </select>
                </div>

                <div class="layui-col-md2">
                    <button type="button" class="layui-btn layui-bg-red" id="findButton"><i class="layui-icon layui-icon-search"></i>查询</button>
                </div>
            </div>

            <hr class="layui-border-green">

            <div class="layui-form-item">
                <div class="layui-input-group">
                    <div class="layui-input-prefix">
                        搜索
                    </div>
                    <input type="text" placeholder="输入药品名进行搜索" class="layui-input" id="mName">
                    <div class="layui-input-split layui-input-suffix" style="cursor: pointer;background-color: white">
                        <i class="layui-icon layui-icon-search" id="searchIcon"></i>
                    </div>
                    <div style="position: relative;left: 5%">
                        <c:forEach var="menu" items="${menuList}" varStatus="s">
                            ${menu.resUrl}
                        </c:forEach>
                    </div>
                </div>
            </div>

        </script>

        <table id="stockAllFormList" lay-filter="stockAllFormList"></table>
    </div>
</div>




<!-- 权限更改 -->
<div style="height: 400px;overflow: auto;display: none" id="dtree1">
    <ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>
<script src="//unpkg.com/layui@2.9.13/dist/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockAllForm/stockAllFormList.js" charset="utf-8"></script>
</body>
</html>