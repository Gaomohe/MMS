<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">
    <title>表格缩略图</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        #tableTbImg + .layui-table-view .layui-table-body tbody > tr > td {
            padding: 0;
        }

        #tableTbImg + .layui-table-view .layui-table-body tbody > tr > td > .layui-table-cell {
            height: 60px;
            line-height: 60px;
        }

        .tdImg {
            width: 50px;
            height: 50px;
            max-width: none;
            cursor: zoom-in;
        }

        .layui-table-view {
            margin: 0;
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
    <div class="layui-card">
        <div class="layui-card-body" id="layPhotosTbImg">
            <table id="tableTbImg" lay-filter="tableTbImg"></table>
        </div>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>

<script>
    layui.use(['layer', 'table', 'util'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var table = layui.table;
        var util = layui.util;

        // 渲染表格
        table.render({
            elem: '#tableTbImg',
            url: '../../../json/user.json',
            page: true,
            cellMinWidth: 100,
            cols: [[
                {type: 'numbers', title: '#'},
                {
                    align: 'center', templet: function (d) {
                        // var url = d.imgUrl;
                        var url = 'https://pic.qqtn.com/up/2018-9/15367146917869444.jpg';
                        return '<img src="' + url + '" class="tdImg" />';
                    }, title: '头像', width: 90, unresize: true
                },
                {field: 'username', align: 'center', sort: true, title: '账号'},
                {field: 'nickName', align: 'center', sort: true, title: '用户名'},
                {field: 'phone', align: 'center', sort: true, title: '手机号'},
                {field: 'sex', align: 'center', sort: true, title: '性别'},
                {
                    sort: true, align: 'center', templet: function (d) {
                        return util.toDateString(d.createTime);
                    }, title: '创建时间'
                }
            ]],
            done: function () {
                layer.photos({
                    photos: '#layPhotosTbImg',
                    shade: .1,
                    closeBtn: true
                });
            }
        });

    });
</script>
</body>

</html>