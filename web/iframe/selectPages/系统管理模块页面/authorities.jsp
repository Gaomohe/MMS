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
    <title>菜单管理</title>
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
                            <input id="edtSearchAuth" class="layui-input" type="text" placeholder="输入关键字"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <button id="btnSearchAuth" class="layui-btn icon-btn"><i class="layui-icon">&#xe615;</i>搜索
                        </button>
                        <button id="btnAddAuth" class="layui-btn icon-btn"><i class="layui-icon">&#xe654;</i>添加</button>
                        <button id="btnExpandAuth" class="layui-btn icon-btn">全部展开</button>
                    </div>
                    <div class="layui-inline">
                        <button id="btnFoldAuth" class="layui-btn icon-btn">全部折叠</button>
                    </div>
                </div>
            </div>

            <table class="layui-table" id="tableAuth" lay-filter="tableAuth"></table>
        </div>
    </div>
</div>

<!-- 表格操作列 -->
<script type="text/html" id="tableBarAuth">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<!-- 表单弹窗 -->
<script type="text/html" id="modelAuth">
    <form id="modelAuthForm" lay-filter="modelAuthForm" class="layui-form model-form">
        <input name="authorityId" type="hidden"/>
        <div class="layui-form-item">
            <label class="layui-form-label">上级菜单</label>
            <div class="layui-input-block">
                <select name="parentId" lay-search>
                    <option value="">请选择上级菜单</option>
                    <option value="1">系统管理</option>
                    <option value="2">用户管理</option>
                    <option value="5">角色管理</option>
                    <option value="8">权限管理</option>
                    <option value="11">登录日志</option>
                    <option value="12">系统监控</option>
                    <option value="13">Druid监控</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限名称</label>
            <div class="layui-input-block">
                <input name="authorityName" placeholder="请输入权限名称" type="text" class="layui-input" maxlength="50"
                       lay-verType="tips" lay-verify="required" required/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限类型</label>
            <div class="layui-input-block">
                <input name="isMenu" type="radio" value="0" title="菜单" checked/>
                <input name="isMenu" type="radio" value="1" title="按钮"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜单url</label>
            <div class="layui-input-block">
                <input name="menuUrl" placeholder="请输入菜单url" type="text" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限标识</label>
            <div class="layui-input-block">
                <input name="authority" placeholder="请输入权限标识" type="text" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜单图标</label>
            <div class="layui-input-block">
                <input name="menuIcon" placeholder="请输入菜单图标" type="text" class="layui-input"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">排序号</label>
            <div class="layui-input-block">
                <input name="orderNumber" placeholder="请输入排序号" type="number" class="layui-input" min="0" max="1000"
                       lay-verType="tips" lay-verify="required|number" required/>
            </div>
        </div>
        <div class="layui-form-item text-right">
            <button class="layui-btn layui-btn-primary" type="button" ew-event="closePageDialog">取消</button>
            <button class="layui-btn" lay-filter="modelSubmitAuth" lay-submit>保存</button>
        </div>
    </form>
</script>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form', 'table', 'admin', 'treetable'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var table = layui.table;
        var admin = layui.admin;
        var treetable = layui.treetable;

        // 渲染表格
        function renderTable() {
            treetable.render({
                treeColIndex: 1,
                treeSpid: -1,
                treeIdName: 'authorityId',
                treePidName: 'parentId',
                elem: '#tableAuth',
                url: '../../json/authorities.json',
                cellMinWidth: 100,
                cols: [[
                    {type: 'numbers', title: '#'},
                    {field: 'authorityName', title: '权限名称', minWidth: 200},
                    {field: 'menuUrl', title: '菜单url'},
                    {field: 'authority', title: '权限标识'},
                    {field: 'orderNumber', title: '排序号', align: 'center'},
                    {
                        title: '类型', templet: function (d) {
                            var strs = ['<span class="layui-badge-rim">菜单</span>', '<span class="layui-badge layui-bg-gray">按钮</span>'];
                            return strs[d.isMenu];
                        }, align: 'center'
                    },
                    {templet: '#tableBarAuth', title: '操作', align: 'center', minWidth: 120}
                ]]
            });
        }

        renderTable();

        // 添加按钮点击事件
        $('#btnAddAuth').click(function () {
            showEditModel();
        });

        // 工具条点击事件
        table.on('tool(tableAuth)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            if (layEvent === 'edit') { // 修改
                showEditModel(data);
            } else if (layEvent === 'del') { // 删除
                doDel(data.authorityId, data.authorityName);
            }
        });

        // 删除
        function doDel(authorityId, authorityName) {
            layer.confirm('确定要删除“' + authorityName + '”吗？', {
                skin: 'layui-layer-admin',
                shade: .1
            }, function (index) {
                layer.close(index);
                layer.load(2);
                $.get('../../json/ok.json', {
                    authorityId: authorityId
                }, function (res) {
                    layer.closeAll('loading');
                    if (res.code == 200) {
                        layer.msg(res.msg, {icon: 1});
                        renderTable();
                    } else {
                        layer.msg(res.msg, {icon: 2});
                    }
                }, 'json');
            });
        }

        // 显示表单弹窗
        function showEditModel(mAuth) {
            admin.open({
                type: 1,
                title: (mAuth ? '修改' : '添加') + '权限',
                content: $('#modelAuth').html(),
                success: function (layero, dIndex) {
                    $(layero).children('.layui-layer-content').css('overflow', 'visible');
                    var url = mAuth ? '../../json/ok.json' : '../../json/ok.json';
                    if (mAuth && mAuth.isMenu == '1') {
                        $('#modelAuthForm input[name="isMenu"][value="1"]').prop("checked", true);
                    }
                    form.val('modelAuthForm', mAuth);  // 回显数据
                    // 表单提交事件
                    form.on('submit(modelSubmitAuth)', function (data) {
                        if (data.field.parentId == '') {
                            data.field.parentId = '-1';
                        }
                        layer.load(2);
                        $.get(url, data.field, function (res) {
                            layer.closeAll('loading');
                            if (res.code == 200) {
                                layer.close(dIndex);
                                layer.msg(res.msg, {icon: 1});
                                renderTable();
                            } else {
                                layer.msg(res.msg, {icon: 2});
                            }
                        }, 'json');
                        return false;
                    });
                }
            });
        }

        // 搜索按钮点击事件
        $('#btnSearchAuth').click(function () {
            $('#edtSearchAuth').removeClass('layui-form-danger');
            var keyword = $('#edtSearchAuth').val();
            var $tds = $('#tableAuth').next('.treeTable').find('.layui-table-body tbody tr td');
            $tds.css('background-color', 'transparent');
            if (!keyword) {
                layer.tips('请输入关键字', '#edtSearchAuth', {tips: [1, '#ff4c4c']});
                $('#edtSearchAuth').addClass('layui-form-danger');
                $('#edtSearchAuth').focus();
                return;
            }
            var searchCount = 0;
            $tds.each(function () {
                if ($(this).text().indexOf(keyword) >= 0) {
                    $(this).css('background-color', '#FAE6A0');
                    if (searchCount == 0) {
                        $('body,html').stop(true);
                        $('body,html').animate({scrollTop: $(this).offset().top - 150}, 500);
                    }
                    searchCount++;
                }
            });
            if (searchCount == 0) {
                layer.msg("没有匹配结果", {icon: 5, anim: 6});
            } else {
                treetable.expandAll('#tableAuth');
            }
        });

        $('#btnExpandAuth').click(function () {
            treetable.expandAll('#tableAuth');
        });

        $('#btnFoldAuth').click(function () {
            treetable.foldAll('#tableAuth');
        });

    });
</script>
</body>
</html>