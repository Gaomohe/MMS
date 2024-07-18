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
</head>

<body>

<div class="layui-btn-container">
    <%--class="layui-input-inline"允许多个表单控件占一行，横着，一行可以放置多个表单元素--%>
    <%--layui-form-item单独使用这个类会默认该元素独占一行--%>
        <div class="layui-form layui-row layui-col-space16">


            <%--单据编号是随机生成的--%>
            <div class="layui-input-inline">
                <label class="layui-form-label">单据编号</label>
                <div class="layui-input-inline">
                    <input type="text"  id="stockInNum" disabled="" placeholder="请输入单据编号" class="layui-input">
                </div>
            </div>


            <div class="layui-input-inline">
                <label class="layui-form-label">供应商</label>
                <div class="layui-input-inline">
                    <select lay-search="" id="manuFactor" lay-event="manuFactor" lay-filter="manuFactor">

                    </select>
                </div>
            </div>

                <div class="layui-input-inline">
                    <label class="layui-form-label">药品名称</label>
                    <div class="layui-input-inline">
                        <input type="text"  id="rName" placeholder="请输入药品名称" class="layui-input">
                    </div>
                    <button type="button" class="layui-btn layui-bg-blue" id="search">查询</button>
                    <button class="layui-btn layui-btn-primary layui-border" id="reset">重置</button>
                </div>
        </div>
</div>

<div id="transfer" style="width:1150px; margin: 0 auto; position: absolute;top: 15%;left: 1%">
    <table id="addStockInFormList" lay-filter="addStockInFormList"></table>
</div>

<div class="layui-btn-container" style="position: absolute;bottom: 0;left:38%">
    <button type="button" class="layui-btn layui-btn-lg layui-btn-normal" id="saveButton">确定入库</button>
    <button type="button" class="layui-btn layui-btn-primary layui-btn-lg" id="cancelButton">取消</button>
</div>


<script type="text/html" id="templet-demo-theads-tool">
    <div class="layui-clear-space">
        <button id="addDrugs" type="button" class="layui-btn layui-btn-xs layui-btn-normal">添加</button>
    </div>
</script>




<!-- 引入 layui.js -->
<script src="//unpkg.com/layui@2.9.14/dist/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockInForm/addStockInForm.js"></script>
</body>
</html>