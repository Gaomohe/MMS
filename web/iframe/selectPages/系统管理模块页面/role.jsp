﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">
    <title>用户管理</title>
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
                        <label class="layui-form-label w-auto">搜索：</label>
                        <div class="layui-input-inline mr0">
                            <input name="keyword" class="layui-input" type="text" placeholder="输入关键字"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button class="layui-btn icon-btn" lay-filter="formSubSearchRole" lay-submit>
                            <i class="layui-icon">&#xe615;</i>搜索
                        </button>
                        <button id="btnAddRole" class="layui-btn icon-btn"><i class="layui-icon">&#xe654;</i>添加</button>
                    </div>
                </div>
            </div>

            <table class="layui-table" id="tableRole" lay-filter="tableRole"></table>
        </div>
    </div>
</div>

<!-- 表格操作列 -->
<script type="text/html" id="tableBarRole">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <a class="layui-btn layui-btn-xs" lay-event="auth">权限分配</a>
</script>
<!-- 表单弹窗 -->
<script type="text/html" id="modelRole">
    <form id="modelRoleForm" lay-filter="modelRoleForm" class="layui-form model-form">
        <input name="roleId" type="hidden"/>
        <div class="layui-form-item">
            <label class="layui-form-label">角色名</label>
            <div class="layui-input-block">
                <input name="roleName" placeholder="请输入角色名" type="text" class="layui-input" maxlength="20"
                       lay-verType="tips" lay-verify="required" required/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <textarea name="comments" placeholder="请输入内容" class="layui-textarea" maxlength="200"></textarea>
            </div>
        </div>
        <div class="layui-form-item text-right">
            <button class="layui-btn layui-btn-primary" type="button" ew-event="closePageDialog">取消</button>
            <button class="layui-btn" lay-filter="modelSubmitRole" lay-submit>保存</button>
        </div>
    </form>
</script>
<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form', 'table', 'util', 'admin', 'zTree'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var util = layui.util;
        var admin = layui.admin;

        // 渲染表格
        var insTb = table.render({
            elem: '#tableRole',
            url: '../../json/role.json',
            page: true,
            cellMinWidth: 100,
            cols: [[
                {type: 'numbers', title: '#'},
                {field: 'roleName', sort: true, title: '角色名'},
                {field: 'comments', sort: true, title: '备注'},
                {
                    sort: true, templet: function (d) {
                        return util.toDateString(d.createTime);
                    }, title: '创建时间'
                },
                {align: 'center', toolbar: '#tableBarRole', title: '操作', minWidth: 200}
            ]]
        });

        // 添加
        $('#btnAddRole').click(function () {
            showEditModel();
        });

        // 搜索
        form.on('submit(formSubSearchRole)', function (data) {
            insTb.reload({where: data.field}, 'data');
        });

        // 工具条点击事件
        table.on('tool(tableRole)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            if (layEvent === 'edit') { // 修改
                showEditModel(data);
            } else if (layEvent === 'del') { // 删除
                doDel(obj);
            } else if (layEvent === 'auth') {  // 权限管理
                showPermModel(data.roleId);
            }
        });

        // 删除
        function doDel(obj) {
            layer.confirm('确定要删除“' + obj.data.roleName + '”角色吗？', {
                skin: 'layui-layer-admin',
                shade: .1
            }, function (i) {
                layer.close(i);
                layer.load(2);
                $.get('../../json/ok.json', {
                    roleId: obj.data.roleId
                }, function (res) {
                    layer.closeAll('loading');
                    if (res.code == 200) {
                        layer.msg(res.msg, {icon: 1});
                        obj.del();
                    } else {
                        layer.msg(res.msg, {icon: 2});
                    }
                }, 'json');
            });
        }

        // 显示编辑弹窗
        function showEditModel(mRole) {
            admin.open({
                type: 1,
                title: (mRole ? '修改' : '添加') + '角色',
                content: $('#modelRole').html(),
                success: function (layero, dIndex) {
                    var url = mRole ? '../../json/ok.json' : '../../json/ok.json';
                    form.val('modelRoleForm', mRole);  // 回显数据
                    // 表单提交事件
                    form.on('submit(modelSubmitRole)', function (data) {
                        layer.load(2);
                        $.get(url, data.field, function (res) {
                            layer.closeAll('loading');
                            if (res.code == 200) {
                                layer.close(dIndex);
                                layer.msg(res.msg, {icon: 1});
                                insTb.reload({}, 'data');
                            } else {
                                layer.msg(res.msg, {icon: 2});
                            }
                        }, 'json');
                        return false;
                    });
                }
            });
        }

        // 权限管理
        function showPermModel(roleId) {
            admin.open({
                title: '角色权限分配',
                btn: ['保存', '取消'],
                content: '<ul id="treeAuth" class="ztree"></ul>',
                success: function (layero, index) {
                    $(layero).children('.layui-layer-content').css({'max-height': '300px', 'overflow': 'auto'});
                    layer.load(2);
                    var setting = {check: {enable: true}, data: {simpleData: {enable: true}}};
                    $.get('../../json/authTree.json', {
                        roleId: roleId
                    }, function (res) {
                        $.fn.zTree.init($('#treeAuth'), setting, res);
                        layer.closeAll('loading');
                    }, 'json');
                },
                yes: function (index) {
                    layer.load(2);
                    var treeObj = $.fn.zTree.getZTreeObj('treeAuth');
                    var nodes = treeObj.getCheckedNodes(true);
                    var ids = new Array();
                    for (var i = 0; i < nodes.length; i++) {
                        ids[i] = nodes[i].id;
                    }
                    $.get('../../json/ok.json', {
                        roleId: roleId,
                        authIds: JSON.stringify(ids)
                    }, function (res) {
                        layer.closeAll('loading');
                        if (200 == res.code) {
                            layer.msg(res.msg, {icon: 1});
                            layer.close(index);
                        } else {
                            layer.msg(res.msg, {icon: 2});
                        }
                    }, 'json');
                }
            });
        }

    });
</script>

</body>
</html>