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
    <title>左右树表</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        #treeTbTree {
            height: 535px;
            overflow: auto;
        }

        @media screen and (max-width: 768px) {
            #treeTbTree {
                height: auto;
            }
        }

        /** dtree选中颜色重写 */
        .dtree-theme-item-this {
            background-color: #eeeeee !important;
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
        <!-- 左树 -->
        <div class="layui-col-sm12 layui-col-md4 layui-col-lg3">
            <div class="layui-card">
                <div class="layui-card-body mini-bar" id="treeTbTree">
                </div>
            </div>
        </div>
        <!-- 右表 -->
        <div class="layui-col-sm12 layui-col-md8 layui-col-lg9">
            <div class="layui-card">
                <div class="layui-card-body" style="min-height: 535px;">

                    <div class="layui-form toolbar">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <label class="layui-form-label w-auto">搜索：</label>
                                <div class="layui-input-inline mr0">
                                    <input name="keyword" class="layui-input" type="text" placeholder="输入关键字"/>
                                </div>
                            </div>
                            <div class="layui-inline">
                                <button class="layui-btn icon-btn" lay-filter="formSubSearchTbLtrt" lay-submit>
                                    <i class="layui-icon">&#xe615;</i>搜索
                                </button>
                                <button class="layui-btn icon-btn">
                                    <i class="layui-icon">&#xe654;</i>新增
                                </button>
                                <button class="layui-btn layui-btn-danger icon-btn">
                                    <i class="layui-icon">&#xe640;</i>删除
                                </button>
                            </div>
                        </div>
                    </div>

                    <table class="layui-table" id="tableTbTree" lay-filter="tableTbTree"></table>

                </div>
            </div>
        </div>

    </div>
</div>

<!-- 表格操作列 -->
<script type="text/html" id="tableBarTbTree">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form', 'table', 'util', 'dtree'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var util = layui.util;
        var dtree = layui.dtree;

        // 渲染表格
        var insTb = table.render({
            elem: '#tableTbTree',
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
                    sort: true, align: 'center', templet: function (d) {
                        return util.toDateString(d.createTime);
                    }, title: '创建时间'
                },
                {align: 'center', toolbar: '#tableBarTbTree', title: '操作', minWidth: 120}
            ]]
        });

        // 树形渲染
        dtree.render({
            elem: '#treeTbTree',
            url: '../../../json/tree.json',
            type: 'all',
            initLevel: '2',
            dot: false,
            method: 'GET'
        });

        // 树形点击事件
        dtree.on('node("treeTbTree")', function (obj) {
            var data = obj.param;
            layer.msg('你选择了：' + data.nodeId + '-' + data.context);
            insTb.reload({where: {nodeId: data.nodeId}}, 'data');
        });

        // 搜索按钮点击事件
        form.on('submit(formSubSearchTbLtrt)', function (data) {
            insTb.reload({where: data.field}, 'data');
        });

    });
</script>
</body>

</html>