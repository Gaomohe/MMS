<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>不合格品处理</title>
    <link rel="stylesheet" href="<%=path%>iframe/assets/libs/layui/css/layui.css" />
    <link rel="stylesheet" href="<%=path%>iframe/assets/module/admin.css?v=314" />
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        /** 必须先给固定高度，否则无法计算分割的高度 */
        .split-group {
            height: 900px;
        }
        .layui-card-body {
            padding: 0;
        }

        .split-item {
            padding: 15px;
        }
        .layui-card-header {
            border-color: #dcdee2;
        }

        .split-group {
            height: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            padding: 20px;
        }
    </style>
</head>
<body>

<!-- 加载动画 -->
<div class="page-loading">
    <div class="ball-loader">
        <span></span><span></span><span></span><span></span>
    </div>
</div>

<!-- 正文开始 -->
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md7" style="width: 100.333%;">
            <div class="layui-card">
                <div class="layui-card-header">不合格品处理</div>
                <div class="layui-card-body">
                    <div class="split-group" style="height: 634px;flex-direction: row-reverse;">
                        <div class="split-item" id="demoSplit1" style="width: calc(25% - -0.5px);"></div>
                        <div class="split-item" id="demoSplit2">
                            <div class="layui-tab-item layui-show">
                                <div class="layui-form toolbar">
                                    <div class="layui-form-item text-right">
                                        <script type="text/html" id="toolbarDemo">

                                            <div class="layui-form layui-row layui-col-space16">
                                                <div class="layui-col-md6" style="width: 500px; margin-right: 5px;">
                                                    <div class="layui-inline" style="width: 100%;">
                                                        <div class="layui-input-inline" style="width: calc(100% - 60px);display: flex;">
                                                            <select id="select1" lay-search="" lay-creatable="">
                                                                <option value="">药品分类</option>
                                                                <c:forEach var="type" items="${mType}" varStatus="s">
                                                                    <option value="${type}">${type}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <button class="layui-btn icon-btn" id="searchByQuerys1" lay-event="searchByQuerys" lay-filter="formSubSearchTbBas" lay-submit>
                                                                <i class="layui-icon">&#xe615;</i>搜索
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="layui-col-md6" style="width: 500px; margin-right: 5px;">
                                                    <div class="layui-inline" style="width: 100%;">
                                                        <div class="layui-input-inline" style="width: calc(100% - 60px);display: flex">
                                                            <select id="select2" lay-search="" lay-creatable="">
                                                                <option value="">生产企业</option>
                                                                <c:forEach var="manufactor" items="${manufactor}" varStatus="s">
                                                                    <option value="${manufactor}">${manufactor}</option>
                                                                </c:forEach>
                                                            </select>
                                                            <button class="layui-btn icon-btn" id="searchByQuerys2" lay-event="searchByQuerys" lay-filter="formSubSearchTbBas" lay-submit>
                                                                <i class="layui-icon">&#xe615;</i>搜索
                                                            </button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                            <hr class="layui-border-green">
                                            <div class="layui-inline">
                                                <input id="search" lay-event="enterSearch" class="layui-input icon-search" type="text" placeholder="输入药品名称按回车搜索"/>
                                            </div>
                                            <c:forEach var="menu" items="${menuList}" varStatus="s">
                                                ${menu.resUrl}
                                            </c:forEach>
                                        </script>
                                    </div>
                                </div>
                                <table id="xTable1" lay-filter="xTable1"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- js部分 -->
<script type="text/javascript" src="<%=path%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>iframe//assets/js/common.js?v=314"></script>
<script type="text/javascript" src="<%=path%>medicinejs/qualityManage/defectiveDisposal/failedList.js" charset="UTF-8"></script>
</body>
</html>