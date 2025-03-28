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
    <title>基础表单</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .layui-form-item {
            margin-bottom: 25px;
        }

        label .layui-icon {
            font-size: 14px;
            color: #666;
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
        <div class="layui-card-body">

            <form class="layui-form" style="max-width: 700px;margin: 40px auto;">
                <div class="layui-form-item">
                    <label class="layui-form-label">标题:</label>
                    <div class="layui-input-block">
                        <input type="text" name="title" placeholder="给目标起个名字" class="layui-input"
                               lay-verType="tips" lay-verify="required" required/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">起止日期:</label>
                    <div class="layui-input-block">
                        <input id="edtDateFormBas" type="text" name="date" placeholder="请选择开始和结束日期"
                               class="layui-input date-icon" autocomplete="off" lay-verType="tips" lay-verify="required"
                               required/>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">目标描述:</label>
                    <div class="layui-input-block">
                        <textarea name="desc" placeholder="请输入你的阶段性工作目标" class="layui-textarea"
                                  lay-verType="tips" lay-verify="required" required></textarea>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">衡量标准:</label>
                    <div class="layui-input-block">
                        <textarea name="hlbz" placeholder="请输入衡量标准" class="layui-textarea"
                                  lay-verType="tips" lay-verify="required" required></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">
                        客户&nbsp;<i lay-tips="目标的服务对象" lay-direction="1" class="layui-icon layui-icon-tips"></i>&nbsp;:
                    </label>
                    <div class="layui-input-block">
                        <input type="text" name="customer" placeholder="请描述你服务的客户" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">邀评人:</label>
                    <div class="layui-input-block">
                        <input type="text" name="person" placeholder="最多可邀请5人" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">权重:</label>
                    <div class="layui-input-block">
                        <input type="number" name="qz" placeholder="请输入" class="layui-input inline-block"
                               style="width: 160px;"/>
                        <span>&nbsp;%</span>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">目标公开:</label>
                    <div class="layui-input-inline" style="display: block;width: auto;float: none;">
                        <input type="radio" name="gk" value="0" title="公开" checked>
                        <input type="radio" name="gk" value="1" title="部分公开">
                        <input type="radio" name="gk" value="2" title="不公开">
                    </div>
                    <div class="layui-form-mid layui-word-aux">客户、邀评人默认被分享</div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formSubmitBas" lay-submit>&emsp;提交&emsp;</button>
                        <button type="reset" class="layui-btn layui-btn-primary">&emsp;重置&emsp;</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form', 'laydate'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var laydate = layui.laydate;

        // 渲染laydate
        laydate.render({
            elem: '#edtDateFormBas',
            range: true
        });

        // 监听表单提交
        form.on('submit(formSubmitBas)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
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