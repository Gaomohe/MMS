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
    <style>
        #xTable2 + .layui-table-view .layui-table-click, #xTable2 + .layui-table-view .layui-table-hover, #xTable2 + .layui-table-view .layui-table tbody tr:hover {
            background: transparent;
        }
    </style>
</head>
<%--<script type="text/javascript" th:src="@{/lib/ui/xm-select/xm-select.js}" charset="utf-8"></script>--%>
<body>
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-body" style="padding-top: 5px;">
            <div class="layui-tab layui-tab-brief" lay-filter="tableXTab">
                <ul class="layui-tab-title">
                    <li>药品价格</li>
                    <li>历史价格</li>
                </ul>
                <div class="layui-tab-content" style="padding-left: 0;padding-right: 0;">
                    <div class="layui-tab-item layui-show">
                        <div class="layui-form toolbar">
                            <div class="layui-form-item text-right">
                                <script type="text/html" id="toolbarDemo">
                                    <div class="layui-form layui-row layui-col-space16">
                                        <div class="layui-col-md6" style="width: 100px;margin-right: 5px">
                                            <select id="select1" lay-search="" lay-creatable="">
                                                <option value="%" hidden=""></option>
                                                <<c:forEach var="type" items="${type1}" varStatus="s">
                                                <option value="${type.typename}">${type.typename}</option>
                                            </c:forEach>
                                            </select>
                                        </div>
                                        <div class="layui-col-md6" style="width: 100px;margin-right: 5px">
                                            <select id="select2" lay-search="" lay-creatable="">
                                                <option value="%" hidden=""></option>
                                                <<c:forEach var="type" items="${type2}" varStatus="s">
                                                <option value="${type.typename}">${type.typename}</option>
                                            </c:forEach>
                                            </select>
                                        </div>
                                        <div class="layui-col-md6" style="width: 100px;margin-right: 5px">
                                            <select id="select3" lay-search="" lay-creatable="">
                                                <option value="%" hidden=""></option>
                                                <<c:forEach var="type" items="${type3}" varStatus="s">
                                                <option value="${type.typename}">${type.typename}</option>
                                            </c:forEach>
                                            </select>
                                        </div>
                                        <div class="layui-col-md6" style="width: 100px;margin-right: 5px">
                                            <select id="select4" lay-search="" lay-creatable="">
                                                <option value="%" hidden=""></option>
                                                <<c:forEach var="type" items="${type4}" varStatus="s">
                                                <option value="${type.typename}">${type.typename}</option>
                                            </c:forEach>
                                            </select>
                                        </div>
                                        <div class="layui-inline">
                                            <button class="layui-btn icon-btn" id="searchByQuerys" lay-event="searchByQuerys" lay-filter="formSubSearchTbBas" lay-submit>
                                                <i class="layui-icon">&#xe615;</i>搜索
                                            </button>
                                        </div>
                                    </div>
                                    <hr class="layui-border-green">
                                    <div class="layui-inline">
                                        <input tb-search="xTable1" class="layui-input icon-search" type="text" placeholder="输入药品名称按回车搜索"/>
                                    </div>
                                    <c:forEach var="menu" items="${menuList}" varStatus="s">
                                        ${menu.resUrl}
                                    </c:forEach>
                                </script>
                            </div>
                        </div>
                        <table id="xTable1" lay-filter="xTable1"></table>
                    </div>


                    <%--第二页--%>
                    <div class="layui-tab-item">
                        <div id="xTable2">

                            <div class="layui-row layui-col-space1">
                                <div class="layui-col-md3">

                                    <div class="layui-tab-item layui-show">
                                        <div class="layui-form toolbar">
                                            <div class="layui-form-item text-right">
                                                <script type="text/html" id="btn1">
                                                    <button type='button' lay-event='addFunc' class='layui-btn layui-btn-warm xz'><i class='layui-icon'>&#xe654;</i>新增</button>
                                                </script>
                                            </div>
                                        </div>
                                        <table id="getType1" lay-filter="getType1"></table>
                                        <script type="text/html" id="type1bar">
                                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                                        </script>
                                    </div>

                                </div>

                                <div class="layui-col-md3">

                                    <div class="layui-tab-item layui-show">
                                        <div class="layui-form toolbar">
                                            <div class="layui-form-item text-right">
                                                <script type="text/html" id="btn2">
                                                    <button type='button' lay-event='addFunc' class='layui-btn layui-btn-warm xz'><i class='layui-icon'>&#xe654;</i>新增</button>
                                                </script>
                                            </div>
                                        </div>
                                        <table id="getType2" lay-filter="getType2"></table>
                                        <script type="text/html" id="type2bar">
                                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                                        </script>
                                    </div>

                                </div>

                                <div class="layui-col-md3">
                                    <div class="layui-tab-item layui-show">
                                        <div class="layui-form toolbar">
                                            <div class="layui-form-item text-right">
                                                <script type="text/html" id="btn3">
                                                    <button type='button' lay-event='addFunc' class='layui-btn layui-btn-warm xz'><i class='layui-icon'>&#xe654;</i>新增</button>
                                                </script>
                                            </div>
                                        </div>
                                        <table id="getType3" lay-filter="getType3"></table>
                                        <script type="text/html" id="type3bar">
                                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                                        </script>
                                    </div>

                                </div>

                                <div class="layui-col-md3">

                                    <div class="layui-tab-item layui-show">
                                        <div class="layui-form toolbar">
                                            <div class="layui-form-item text-right">
                                                <script type="text/html" id="btn4">
                                                    <button type='button' lay-event='addFunc' class='layui-btn layui-btn-warm xz'><i class='layui-icon'>&#xe654;</i>新增</button>
                                                </script>
                                            </div>
                                        </div>
                                        <table id="getType4" lay-filter="getType1"></table>
                                        <script type="text/html" id="type4bar">
                                            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                                        </script>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

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
<script type="text/javascript" src="<%=path%>medicinejs/medicineManage/medPrice/priceList.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path%>medicinejs/medicineManage/medDictionary/typesList.js" charset="UTF-8"></script>
</html>