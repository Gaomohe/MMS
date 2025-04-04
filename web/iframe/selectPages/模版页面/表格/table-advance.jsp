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
    <title>复杂表格</title>
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
                        <label class="layui-form-label">账&emsp;&emsp;号：</label>
                        <div class="layui-input-inline">
                            <input name="username" class="layui-input" type="text" placeholder="输入账号"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">用&nbsp;&nbsp;户&nbsp;&nbsp;名：</label>
                        <div class="layui-input-inline">
                            <input name="nickName" class="layui-input" type="text" placeholder="输入用户名"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">手&nbsp;&nbsp;机&nbsp;&nbsp;号：</label>
                        <div class="layui-input-inline">
                            <input name="phone" class="layui-input" type="text" placeholder="输入用户名"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">性&emsp;&emsp;别：</label>
                        <div class="layui-input-inline">
                            <select name="sex">
                                <option value="">所有</option>
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">状&emsp;&emsp;态：</label>
                        <div class="layui-input-inline">
                            <select name="state">
                                <option value="">所有</option>
                                <option value="0">正常</option>
                                <option value="1">冻结</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">注册时间：</label>
                        <div class="layui-input-inline">
                            <input id="edtDateTbAdv" name="createTime" class="layui-input date-icon" type="text"
                                   placeholder="选择注册时间" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="layui-inline" style="padding-left: 20px;">
                        <button class="layui-btn icon-btn" lay-filter="formSubSearchTbAdv" lay-submit>
                            <i class="layui-icon">&#xe615;</i>搜索
                        </button>
                        <button class="layui-btn icon-btn">
                            <i class="layui-icon">&#xe654;</i>添加
                        </button>
                        <button id="btnExportTbAdv" class="layui-btn icon-btn">
                            <i class="layui-icon">&#xe67d;</i>导出
                        </button>
                    </div>
                </div>
            </div>
            <table class="layui-table" id="tableTbAdv" lay-filter="tableTbAdv"></table>
        </div>
    </div>

</div>

<!-- 表格操作列 -->
<script type="text/html" id="tableBarTbAdv">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<!-- 表格状态列 -->
<script type="text/html" id="tplStateTbAdv">
    <input type="checkbox" lay-filter="ckStateTbAdv" value="{{d.userId}}" lay-skin="switch"
           lay-text="正常|锁定" {{d.state==0?'checked':''}}/>
</script>
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

        form.render('select');

        // 渲染表格
        var insTb = table.render({
            elem: '#tableTbAdv',
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
                {field: 'state', align: 'center', sort: true, templet: '#tplStateTbAdv', title: '状态'},
                {align: 'center', toolbar: '#tableBarTbAdv', title: '操作', minWidth: 150}
            ]]
        });

        // 搜索
        form.on('submit(formSubSearchTbAdv)', function (data) {
            insTb.reload({where: data.field}, 'data');
        });


        //监听工具条
        table.on('tool(tableTbAdv)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值

            if (layEvent === 'edit') { //查看
                layer.msg('点击了修改');
            } else if (layEvent === 'del') { //删除
                layer.msg('点击了删除');
            }
        });

        // 渲染laydate
        laydate.render({
            elem: '#edtDateTbAdv'
        });

        // 导出excel
        $('#btnExportTbAdv').click(function () {
            var checkRows = table.checkStatus('tableTbAdv');
            if (checkRows.data.length == 0) {
                layer.msg('请选择要导出的数据', {icon: 2});
            } else {
                table.exportFile(insTb.config.id, checkRows.data, 'docx');
            }
        });

    });
</script>
</body>

</html>