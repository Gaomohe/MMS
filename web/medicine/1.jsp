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
    <title>引导插件</title>
    <link rel="stylesheet" href="<%=path%>iframe/assets/libs/layui/css/layui.css" />
    <link rel="stylesheet" href="<%=path%>iframe/assets/module/admin.css?v=314" />
    <link rel="stylesheet" href="<%=path%>iframe/assets/module/formSelects/formSelects-v4.css"/>
    <link rel="stylesheet" href="<%=path%>iframe/assets/module/city-picker/city-picker.css"/>
    <script src="<%=path%>iframe/assets/module/city-picker/city-picker.data.js"></script>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .layui-form-label {
            padding-left: 0;
            padding-right: 0;
            width: 110px;
        }

        .layui-form-item {
            margin-bottom: 30px;
        }
    </style>
</head>
<body>

<!-- 正文开始 -->
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md4">
            <div class="layui-card">
                <div class="layui-card-header">常用示例</div>
                <div class="layui-card-body">
                    <div class="layui-form model-form">
                        <div class="layui-form-item">
                            <label class="layui-form-label">省市区选择：</label>
                            <div class="layui-input-block">
                                <input id="demoCascader11" placeholder="请选择" class="layui-hide"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 加载动画 -->
<div class="page-loading">
    <div class="ball-loader">
        <span></span><span></span><span></span><span></span>
    </div>
</div>

<script type="text/javascript" src="<%=path%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>iframe/assets/js/common.js"></script>
<script type="text/javascript" src="<%=path%>iframe/assets/module/cascader/citys-data.js"></script>
<script>
    layui.use(['layer', 'form', 'tableX', 'cascader'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var tableX = layui.tableX;
        var cascader = layui.cascader;

        // 省市区选择
        cascader.render({
            elem: '#demoCascader11',
            data: citysData,
            itemHeight: '250px',
            filterable: true
        });

        // 关闭清除按钮
        cascader.render({
            elem: '#demoCascader13',
            data: data,
            clearable: false
        });

        // 清除时重置
        cascader.render({
            elem: '#demoCascader14',
            data: data,
            clearAllActive: true
        });
    });
</script>
</body>
</html>
