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
    <title>登录</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<!-- 页面加载loading -->
<div class="page-loading">
    <div class="ball-loader">
        <span></span><span></span><span></span><span></span>
    </div>
</div>

<!-- 正文开始 -->
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-body">
            <div class="layui-form toolbar">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label w-auto">账号：</label>
                        <div class="layui-input-inline mr0">
                            <input name="account" class="layui-input" type="text" placeholder="请输入账号"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label w-auto">日期：</label>
                        <div class="layui-input-inline mr0">
                            <input name="dateRange" class="layui-input date-icon" type="text" placeholder="请选择日期范围"
                                   autocomplete="off"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn icon-btn" lay-filter="formSubSearchLog" lay-submit>
                            <i class="layui-icon">&#xe615;</i>搜索
                        </button>
                        <button id="btnExpLog" class="layui-btn icon-btn"><i class="layui-icon">&#xe67d;</i>导出</button>
                    </div>
                </div>
            </div>

            <table class="layui-table" id="tableLog" lay-filter="tableLog"></table>
        </div>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form', 'table', 'util', 'laydate'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var util = layui.util;
        var laydate = layui.laydate;

        // 渲染表格
        var insTb = table.render({
            elem: '#tableLog',
            url: '../../json/loginRecord.json',
            page: true,
            cellMinWidth: 100,
            title: '登录日志',
            cols: [[
                {type: 'checkbox'},
                {field: 'username', sort: true, title: '账号'},
                {field: 'nickName', sort: true, title: '用户名'},
                {field: 'ipAddress', sort: true, title: 'IP'},
                {field: 'device', sort: true, title: '设备'},
                {field: 'osName', sort: true, title: '设备类型'},
                {field: 'browserType', sort: true, title: '浏览器'},
                {
                    field: 'createTime', templet: function (d) {
                        return util.toDateString(d.createTime);
                    }, title: '登录时间'
                }
            ]]
        });

        // 时间范围
        laydate.render({
            elem: 'input[name="dateRange"]',
            type: 'date',
            range: true,
            trigger: 'click'
        });

        // 搜索
        form.on('submit(formSubSearchLog)', function (data) {
            if (data.field.dateRange) {
                var searchDate = data.field.dateRange.split(' - ');
                data.field.startDate = searchDate[0];
                data.field.endDate = searchDate[1];
            } else {
                data.field.startDate = '';
                data.field.endDate = '';
            }
            data.field.dateRange = undefined;
            insTb.reload({where: data.field}, 'data');
        });

        // 导出excel
        $('#btnExpLog').click(function () {
            var checkRows = table.checkStatus('tableLog');
            if (checkRows.data.length == 0) {
                layer.msg('请选择要导出的数据', {icon: 2});
            } else {
                table.exportFile(insTb.config.id, checkRows.data, 'xls');
            }
        });

    });
</script>

</body>
</html>