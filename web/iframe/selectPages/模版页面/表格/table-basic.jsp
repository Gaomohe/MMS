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
    <title>数据表格</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
        <div class="layui-card-body">

            <div class="layui-form toolbar">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label w-auto">搜索：</label>
                        <div class="layui-input-inline mr0">
                            <input name="keyword" class="layui-input" type="text" placeholder="输入关键字"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn icon-btn" lay-filter="formSubSearchTbBas" lay-submit>
                            <i class="layui-icon">&#xe615;</i>搜索
                        </button>
                        <button id="btnExportTbBas" class="layui-btn icon-btn">
                            <i class="layui-icon">&#xe67d;</i>导出
                        </button>
                        <!-- 下拉按钮 -->
                        <div class="dropdown-menu dropdown-hover">
                            <button class="layui-btn icon-btn">
                                &nbsp;更多 <i class="layui-icon layui-icon-drop"></i></button>
                            <ul class="dropdown-menu-nav">
                                <li><a><i class="layui-icon layui-icon-edit"></i>修改用户</a></li>
                                <li><a><i class="layui-icon layui-icon-delete"></i>删除用户</a></li>
                                <li><a><i class="layui-icon layui-icon-print"></i>打印用户</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>

            <table class="layui-table" id="tableTbBas" lay-filter="tableTbBas"></table>
        </div>
    </div>
</div>

<!-- 表格操作列 -->
<script type="text/html" id="tableBarTbBas">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <a class="layui-btn layui-btn-xs" data-dropdown="#dropUser{{d.LAY_INDEX}}" no-shade="true">
        更多<i class="layui-icon layui-icon-drop" style="font-size: 12px;margin-right: 0;"></i></a>
    <!-- 下拉菜单 -->
    <ul class="dropdown-menu-nav dropdown-bottom-right layui-hide" id="dropUser{{d.LAY_INDEX}}">
        <div class="dropdown-anchor"></div>
        <li><a lay-event="edit2"><i class="layui-icon layui-icon-edit"></i>修改用户</a></li>
        <li><a lay-event="del2"><i class="layui-icon layui-icon-delete"></i>删除用户</a></li>
        <li><a lay-event="print2"><i class="layui-icon layui-icon-print"></i>打印用户</a></li>
    </ul>
</script>
<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form', 'table', 'util', 'dropdown'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var util = layui.util;
        var dropdown = layui.dropdown;

        // 渲染表格
        var insTb = table.render({
            elem: '#tableTbBas',
            url: '../../../json/user.json',
            page: true,
            cellMinWidth: 100,
            cols: [[
                {type: 'checkbox'},
                {field: 'username', align: 'center', sort: true, title: '账号'},
                {field: 'nickName', align: 'center', sort: true, title: '用户名'},
                {field: 'phone', align: 'center', sort: true, title: '手机号'},
                {field: 'sex', align: 'center', sort: true, title: '性别'},
                {
                    field: 'createTime', sort: true, align: 'center', templet: function (d) {
                        return util.toDateString(d.createTime);
                    }, title: '创建时间'
                },
                {
                    field: 'state', align: 'center', sort: true, templet: function (d) {
                        var strs = [
                            '<span class="text-success">正常</span>',
                            '<span class="text-danger">锁定</span>'
                        ];
                        return strs[d.state];
                    }, title: '状态'
                },
                {align: 'center', toolbar: '#tableBarTbBas', title: '操作', minWidth: 200}
            ]]
        });

        //监听工具条
        table.on('tool(tableTbBas)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值

            if (layEvent === 'edit') { // 查看
                layer.msg('点击了修改');
            } else if (layEvent === 'del') { // 删除
                layer.msg('点击了删除');
            } else if (layEvent === 'edit2') { // 修改2
                layer.msg('点击了下拉菜单修改');
            } else if (layEvent === 'del2') { // 删除2
                layer.msg('点击了下拉菜单删除');
            } else if (layEvent === 'print2') { // 打印2
                layer.msg('点击了下拉菜单打印');
            }
            dropdown.hideAll();
        });

        // 导出excel
        $('#btnExportTbBas').click(function () {
            var checkRows = table.checkStatus('tableTbBas');
            if (checkRows.data.length == 0) {
                layer.msg('请选择要导出的数据', {icon: 2});
            } else {
                table.exportFile(insTb.config.id, checkRows.data, 'xls');
            }
        });

        // 搜索按钮点击事件
        form.on('submit(formSubSearchTbBas)', function (data) {
            insTb.reload({where: data.field}, 'data');
        });

    });
</script>
</body>

</html>