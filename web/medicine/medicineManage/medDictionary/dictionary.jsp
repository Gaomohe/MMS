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
<div style="background-color: white;padding: 10px;margin: 10px">
    <blockquote class="layui-elem-quote quoteBox" style="margin-top: 20px;margin-bottom: 20px">
        药品字典
    </blockquote>
    <div class="layui-tab-item layui-show">
        <div class="layui-form toolbar">
            <div class="layui-inline">
                <div class="layui-form-item">
                    <label class="layui-form-label">商品分类</label>
                    <div class="layui-input-block xm-select-nri" style="width:245px;max-width: 60%;">
                        <select name="city" xm-select="selDemo">
                            <c:forEach var="type" items="${type1}" varStatus="s">
                                <option value="${type.typename}">${type.typename}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">药品分类</label>
                    <div class="layui-input-block xm-select-nri" style="width:245px;max-width: 60%;">
                        <select name="city" xm-select="selDemo1">
                            <c:forEach var="type" items="${type2}" varStatus="s">
                                <option value="${type.typename}">${type.typename}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-form-item">
                    <label class="layui-form-label">自定义分类</label>
                    <div class="layui-input-block xm-select-nri" style="width:245px;max-width: 60%;">
                        <select name="city" xm-select="selDemo2">
                            <c:forEach var="type" items="${type3}" varStatus="s">
                                <option value="${type.typename}">${type.typename}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">剂型</label>
                    <div class="layui-input-block xm-select-nri" style="width:245px;max-width: 60%;">
                        <select name="city" xm-select="selDemo3">
                            <c:forEach var="type" items="${type4}" varStatus="s">
                                <option value="${type.typename}">${type.typename}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-inline">
                <button class="layui-btn icon-btn" lay-event="searchByQuerys" lay-filter="formSubSearchTbBas" lay-submit>
                    <i class="layui-icon">&#xe615;</i>搜索
                </button>
            </div>
            <div class="layui-form-item text-right">
                <script type="text/html" id="toolbarDemo">
                    <div class="layui-inline">
                        <input tb-search="xTable1" class="layui-input icon-search" type="text" placeholder="按回车搜索"/>
                    </div>
                    <c:forEach var="menu" items="${menuList}" varStatus="s">
                        ${menu.resUrl}
                    </c:forEach>
                </script>
            </div>
        </div>
        <table id="xTable1" lay-filter="xTable1"></table>
        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
            <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=path%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>iframe/assets/js/common.js"></script>
<script type="text/javascript" src="<%=path%>medicinejs/medicineManage/medDictionary/my.js" charset="UTF-8"></script>
</html>