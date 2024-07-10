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
    <link href="//cdn.staticfile.net/layui/2.9.13/css/layui.css" rel="stylesheet">    <!-- 请勿在项目正式环境中引用该 layui.css 地址 -->
<%--    <link href="admin\lib\layui-v2.9.13\layui\css\layui.css" rel="stylesheet">--%>
</head>

<body>

<div class="layui-btn-container">
<%--class="layui-input-inline"允许多个表单控件占一行，横着，一行可以放置多个表单元素--%>
<%--layui-form-item单独使用这个类会默认该元素独占一行--%>
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


    <form class="layui-form layui-form-pane" action="">
        <div class="layui-row" style="padding-top: 20px;">
            <div class="layui-col-xs6">
                <div class="grid-demo grid-demo-bg1">
                    <!-- 客户  -->
                    <div class="layui-form-item">
                        <div class="layui-input-group">
                            <div class="layui-input-prefix">
                                客户 *
                            </div>
                            <input type="text" placeholder="客户名称" class="layui-input">
                            <div class="layui-input-split layui-input-suffix" style="cursor: pointer;">
                                <i class="layui-icon layui-icon-search"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="layui-col-xs6">
                <div class="grid-demo"><!-- 日期           -->
                    <div class="layui-inline">
                        <label class="layui-form-label">日期</label>
                        <div class="layui-input-inline layui-input-wrap">
                            <div class="layui-input-prefix">
                                <i class="layui-icon layui-icon-date"></i>
                            </div>
                            <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-card-body layui-text">
            <div id="tableRes" class="table-overlay">
                <table id="paramTable" lay-filter="paramTable" class="layui-hide"></table>
            </div>
        </div>
    </form>

</div>


<%--<script type="text/html" id="toolbarDemo">--%>
<%--    <div class="layui-btn-container">--%>
<%--        <button class="layui-btn layui-btn-sm" lay-event="add">增加一行</button>--%>
<%--        <!-- <button class="layui-btn layui-btn-sm" lay-event="delete">删除</button> -->--%>
<%--        <button class="layui-btn layui-btn-sm" lay-event="update">合计刷新</button>--%>
<%--    </div>--%>
<%--</script>--%>
<%--<script type="text/html" id="barDemo">--%>
<%--    <!-- <a class="layui-btn layui-btn-xs" lay-event="add">添加</a> -->--%>
<%--    <a class="layui-btn layui-btn-xs" lay-event="del">删除</a>--%>
<%--    </div>--%>
<%--</script>--%>
<%--<script src="./layui/layui.js"></script>--%>
<%--<script>--%>
<%--    layui.use(['table', 'form', 'jquery','laydate'], function () {--%>
<%--        var table = layui.table;--%>
<%--        var form = layui.form;--%>
<%--        var laydate = layui.laydate;--%>
<%--        var $ = layui.jquery;--%>
<%--        var tableData = new Array();--%>
<%--        var param = {--%>
<%--            tempId: new Date().valueOf(),--%>
<%--            keyParam: '',--%>
<%--            valueParam: '',--%>
<%--        };--%>
<%--        tableData.push(param);--%>

<%--        // 提交事件--%>


<%--        //初始化表单--%>
<%--        table.render({--%>
<%--            elem: "#paramTable",--%>
<%--            id: 'paramTable',--%>
<%--            data: tableData,--%>
<%--            totalRow: true,--%>
<%--            title: '销售单',--%>
<%--            toolbar: '#toolbarDemo',--%>
<%--            defaultToolbar: ['filter', 'exports', 'print'],--%>
<%--            page: false,--%>
<%--            loading: false,--%>
<%--            even: false,--%>
<%--            cols: [[--%>
<%--                { title: '序号', type: 'numbers' },--%>
<%--                { field: 'mq', title: '商品规格', edit: 'text', minWidth: 300, totalRowText: '合计：' },--%>
<%--                { field: 'dw', title: '单位', edit: 'text', maxWidth: 80 },--%>
<%--                { field: 'sl', title: '数量', edit: true, maxWidth: 100, totalRow: true },--%>
<%--                { field: 'dj', title: '单价', edit: 'text' , maxWidth: 100},--%>
<%--                { field: 'je', title: '金额', totalRow: '{{= parseInt(d.TOTAL_NUMS) }} 元', edit: true, maxWidth: 100},--%>
<%--                { field: 'bz', title: '备注', edit: 'text',  maxWidth: 100 },--%>
<%--                { fixed: 'right', title: '操作', width: 134, minWidth: 125, align: 'center', toolbar: '#barDemo' },--%>
<%--            ]]--%>
<%--        })--%>


<%--        //添加事件--%>
<%--        table.on('toolbar(paramTable)', function (obj) {--%>
<%--            var options = obj.config; // 获取当前表格属性配置项--%>
<%--            var checkStatus = table.checkStatus(options.id); // 获取选中行相关数据--%>
<%--            console.log(obj); // 查看对象所有成员--%>

<%--            // 根据不同的事件名进行相应的操作--%>
<%--            switch (obj.event) { // 对应模板元素中的 lay-event 属性值--%>
<%--                case 'add':--%>
<%--                    var oldData = table.cache["paramTable"];--%>
<%--                    var newRow = {--%>
<%--                        tempId: new Date().valueOf(),--%>
<%--                        keyParam: '',--%>
<%--                        valueParam: '',--%>
<%--                    }--%>
<%--                    oldData.push(newRow);--%>
<%--                    table.reload('paramTable', {--%>
<%--                        data: oldData--%>
<%--                    });--%>
<%--                    layer.msg('增加一行');--%>
<%--                    break;--%>
<%--                case 'delete':--%>
<%--                    layer.msg('删除');--%>
<%--                    break;--%>
<%--                case 'update':--%>
<%--                    table.reload('paramTable', { data: oldData });--%>
<%--                    layer.msg('合计刷新');--%>
<%--                    break;--%>
<%--            };--%>
<%--        });--%>


<%--        //删除行--%>
<%--        table.on('tool(paramTable)', function (obj) {--%>
<%--            var data = obj.data, event = obj.event, tr = obj.tr;--%>
<%--            switch (event) {--%>
<%--                case "del":--%>
<%--                    layer.confirm('真的删除吗？', function (index) {--%>
<%--                        obj.del();--%>
<%--                        layer.close(index);--%>
<%--                        var oldData = table.cache["paramTable"];--%>
<%--                        for (var i = 0; i < oldData.length; i++) {--%>
<%--                            row = oldData[i];--%>
<%--                            if (!row || !row.tempId) {--%>
<%--                                oldData.splice(i, 1);    //删除一项--%>
<%--                            }--%>
<%--                            continue;--%>
<%--                        }--%>
<%--                        table.reload('paramTable', {--%>
<%--                            data: oldData--%>
<%--                        });--%>
<%--                    });--%>
<%--            }--%>
<%--        });--%>


<%--        $("#execute").click(function () {--%>
<%--            var paramList = JSON.stringify(table.cache["paramTable"]);--%>
<%--            console.log(paramList);--%>
<%--        });--%>
<%--        // 日期--%>
<%--        laydate.render({--%>
<%--            elem: '#date'--%>
<%--        });--%>
<%--    });--%>

<%--</script>--%>
<%--<script>--%>
<%--    layui.use(function () {--%>
<%--        var table = layui.table;--%>
<%--        // 渲染--%>
<%--        table.render({--%>
<%--            elem: '#test',--%>
<%--            toolbar: '#toolbarDemo',--%>
<%--            // … // 其他属性--%>
<%--        });--%>

<%--        // 头部工具栏事件--%>
<%--        table.on('toolbar(test)', function (obj) {--%>
<%--            var options = obj.config; // 获取当前表格属性配置项--%>
<%--            var checkStatus = table.checkStatus(options.id); // 获取选中行相关数据--%>
<%--            console.log(obj); // 查看对象所有成员--%>

<%--            // 根据不同的事件名进行相应的操作--%>
<%--            switch (obj.event) { // 对应模板元素中的 lay-event 属性值--%>
<%--                case 'add':--%>
<%--                    layer.msg('添加');--%>
<%--                    break;--%>
<%--                case 'delete':--%>
<%--                    layer.msg('删除');--%>
<%--                    break;--%>
<%--                case 'update':--%>
<%--                    layer.msg('编辑');--%>
<%--                    break;--%>
<%--            };--%>
<%--        });--%>
<%--    });--%>
<%--</script>--%>



<script src="//cdn.staticfile.net/layui/2.9.13/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockOutForm/addStockOutForm.js"></script>
</body>
</html>