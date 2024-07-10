<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Demo</title>
    <!-- 引入 layui.css -->
    <link href="//unpkg.com/layui@2.9.14/dist/css/layui.css" rel="stylesheet">
<%--    <link href="//cdn.staticfile.net/layui/2.9.13/css/layui.css" rel="stylesheet">--%>
    <%--    <link href="admin\lib\layui-v2.9.13\layui\css\layui.css" rel="stylesheet">--%>
</head>

<body>

<div class="layui-btn-container">
    <%--class="layui-input-inline"允许多个表单控件占一行，横着，一行可以放置多个表单元素--%>
    <%--layui-form-item单独使用这个类会默认该元素独占一行--%>
        <div class="layui-form layui-row layui-col-space16">

            <div class="layui-input-inline">
                <label class="layui-form-label">单据日期</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" id="ID-laydate-type-datetime" placeholder="yyyy-MM-dd HH:mm:ss">
                </div>
            </div>

            <div class="layui-input-inline">
                <label class="layui-form-label">单据编号</label>
                <div class="layui-input-inline">
                    <input type="text" placeholder="请输入单据编号" class="layui-input">
                </div>
            </div>

            <div class="layui-input-inline">
<%--                <label class="layui-form-label">单据编号</label>--%>
                <select id="state">
                    <option value="">请选择</option>
                    <option value="未审批">未审阅</option>
                    <option value="已审批">已审阅通过</option>
                    <option value="已审批">已审阅未通过</option>
                </select>
            </div>

        </div>
</div>

<form class="layui-form layui-form-pane" action="">
    <div class="layui-card-body layui-text">
        <div id="tableRes" class="table-overlay">
            <table id="paramTable" lay-filter="paramTable" class="layui-hide"></table>
        </div>
<%--        <div class="layui-form-item" style="padding-left: 20px;">--%>
<%--            <button class="layui-btn" lay-submit lay-filter="demo2">确认</button>--%>
<%--            <button type="reset" class="layui-btn layui-btn-primary">重置</button>--%>
<%--        </div>--%>
    </div>
</form>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="add">增加一行</button>
        <button class="layui-btn layui-btn-sm" lay-event="update">合计刷新</button>
    </div>
</script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>
</script>






<!-- 引入 layui.js -->
<script src="//unpkg.com/layui@2.9.14/dist/layui.js"></script>
<%--<script src="//cdn.staticfile.net/layui/2.9.13/layui.js"></script>--%>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockInForm/addStockInForm.js"></script>
</body>
</html>