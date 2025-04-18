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
    <title>复杂表单</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .layui-form-item {
            margin-bottom: 0;
            margin-top: 20px;
        }

        .layui-form-item .layui-inline {
            margin-bottom: 25px;
            margin-right: 0;
        }

        .form-group-bottom {
            position: fixed;
            bottom: 0;
            left: 0;
            right: 0;
            background-color: #fff;
            padding: 10px 20px;
            box-shadow: 0 -1px 2px 0 rgba(0, 0, 0, .05);
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
<form class="layui-form">
    <div class="layui-fluid" style="padding-bottom: 75px;">
        <div class="layui-card">
            <div class="layui-card-header">仓库信息</div>
            <div class="layui-card-body">

                <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">仓库名:</label>
                        <div class="layui-input-block">
                            <input name="ckName" type="text" placeholder="请输入仓库名称" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">仓库域名:</label>
                        <div class="layui-input-block">
                            <input name="ckYm" type="text" placeholder="请输入" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">仓库管理员</label>
                        <div class="layui-input-block">
                            <select name="ckGly" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择管理员</option>
                                <option value="0">付晓晓</option>
                                <option value="1">周毛毛</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">审批人</label>
                        <div class="layui-input-block">
                            <select name="spPerson" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择审批人</option>
                                <option value="0">付晓晓</option>
                                <option value="1">周毛毛</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">生效日期:</label>
                        <div class="layui-input-block">
                            <input id="edtDateFormAdv1" name="sxTime" type="text" placeholder="请选择开始和结束日期"
                                   class="layui-input date-icon" autocomplete="off" lay-verType="tips"
                                   lay-verify="required"
                                   required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">仓库类型</label>
                        <div class="layui-input-block">
                            <select name="ckType" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择仓库类型</option>
                                <option value="0">私密</option>
                                <option value="1">公开</option>
                            </select>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="layui-card">
            <div class="layui-card-header">任务信息</div>
            <div class="layui-card-body">

                <div class="layui-form-item layui-row">
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">任务名:</label>
                        <div class="layui-input-block">
                            <input name="rwName" type="text" placeholder="请输入" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">任务描述:</label>
                        <div class="layui-input-block">
                            <input name="rwDesc" type="text" placeholder="请输入" class="layui-input"
                                   lay-verType="tips" lay-verify="required" required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">执行人</label>
                        <div class="layui-input-block">
                            <select name="zxPerson" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择执行人</option>
                                <option value="0">付晓晓</option>
                                <option value="1">周毛毛</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">责任人</label>
                        <div class="layui-input-block">
                            <select name="zrPerson" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择责任人</option>
                                <option value="0">付晓晓</option>
                                <option value="1">周毛毛</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">提醒时间:</label>
                        <div class="layui-input-block">
                            <input id="edtDateFormAdv2" name="txTime" type="text" placeholder="请选择提醒时间"
                                   class="layui-input date-icon" autocomplete="off" lay-verType="tips"
                                   lay-verify="required"
                                   required/>
                        </div>
                    </div>
                    <div class="layui-inline layui-col-md4">
                        <label class="layui-form-label">任务类型</label>
                        <div class="layui-input-block">
                            <select name="rwType" lay-verType="tips" lay-verify="required" required>
                                <option value="">请选择任务类型</option>
                                <option value="0">私密</option>
                                <option value="1">公开</option>
                            </select>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div class="layui-card">
            <div class="layui-card-header">选择成员</div>
            <div class="layui-card-body">

                <table class="layui-table" id="tableFormAdv" lay-filter="tableFormAdv"></table>

            </div>
        </div>
    </div>

    <div class="form-group-bottom text-right">
        <button type="reset" class="layui-btn layui-btn-primary">&emsp;重置&emsp;</button>
        <button class="layui-btn" lay-filter="formSubmitAdv" lay-submit>&emsp;提交&emsp;</button>
    </div>

</form>

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
        table.render({
            elem: '#tableFormAdv',
            url: '../../../json/user.json',
            page: true,
            cellMinWidth: 100,
            cols: [[
                {type: 'checkbox'},
                {field: 'username', sort: true, title: '账号'},
                {field: 'nickName', sort: true, title: '用户名'},
                {field: 'phone', sort: true, title: '手机号'},
                {field: 'sex', sort: true, title: '性别'},
                {
                    field: 'createTime', sort: true, templet: function (d) {
                        return util.toDateString(d.createTime);
                    }, title: '创建时间'
                }
            ]]
        });

        // 渲染laydate
        laydate.render({
            elem: '#edtDateFormAdv1',
            range: true
        });
        laydate.render({
            elem: '#edtDateFormAdv2'
        });

        // 监听表单提交
        form.on('submit(formSubmitAdv)', function (data) {
            // 验证表格选择
            var checkRows = table.checkStatus('tableFormAdv');
            if (checkRows.data.length == 0) {
                layer.tips('请至少选择一位成员', '#tableFormAdv+.layui-table-view .layui-table-header th:eq(0) div', {tips: [1, '#ff4c4c']});
                return false;
            }
            // 表格选择的数据放到data.field中
            data.field.checkUsers = checkRows;
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</body>

</html>