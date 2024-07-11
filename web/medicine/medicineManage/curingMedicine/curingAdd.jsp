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

<%
    String tableCoding = request.getParameter("tableCoding");
    String mId = request.getParameter("mId");
%>
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
                    <label class="layui-form-label">药品数据编号:</label>
                    <div class="layui-input-block">
                        <input readonly type="text" name="tableCoding" class="layui-input" value="<%=tableCoding%>"
                               lay-verType="tips" lay-verify="required" required/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">药品编号:</label>
                    <div class="layui-input-block">
                        <input readonly type="text" name="mId" class="layui-input" value="<%=mId%>"
                               lay-verType="tips" lay-verify="required" required/>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">养护描述:</label>
                    <div class="layui-input-block">
                        <textarea name="content" placeholder="请输入你的养护内容" class="layui-textarea"
                                  lay-verType="tips" lay-verify="required" required></textarea>
                    </div>
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
            var obj = data.field
            $.ajax({
                url:"/curing?action=addCuring",
                data:{
                    tableCoding:obj.tableCoding,
                    mId:obj.mId,
                    content:obj.content,
                },
                type:"POST",
                dataType:"JSON",
                success:function (){
                    changeCuring(obj.tableCoding);
                    layer.msg("提交成功")
                }
            })
            return false;
        });

        function changeCuring(tableCoding){
            $.ajax({
                url: '/medicine?action=updateMedicineLastCuringDate',
                type: "POST",
                data: {
                    tableCoding: tableCoding,
                },
                dataType: "JSON",
                success: function(response) {
                    var tableData = response.data;
                    /*var xhr = new XMLHttpRequest();
                    xhr.open('GET', '/curing?action=getMenuBtn', true);
                    xhr.send();*/
                    setTimeout(window.history.back(),2000)
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    });
</script>
</body>
</html>