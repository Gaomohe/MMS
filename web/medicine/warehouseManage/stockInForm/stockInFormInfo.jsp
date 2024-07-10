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
    <title>新增供应商</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
    <div class="layui-form-item">
        <label class="layui-form-label">入库单编号</label>
        <div class="layui-input-inline">
            <input type="text" name="rId" id="rId" lay-verify="required" disabled="" placeholder="请输入入库单编号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">入库药品</label>
        <div class="layui-input-inline">
            <input type="text" name="rName" id="rName" lay-verify="required" placeholder="请输入入库药品" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">规格</label>
        <div class="layui-input-inline">
            <input type="text" name="standard" id="standard" lay-verify="required" placeholder="请输入规格" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">生产厂家</label>
        <div class="layui-input-inline">
            <input type="text" name="manufactor" id="manufactor" lay-verify="required" placeholder="请输入生产厂家" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单位</label>
        <div class="layui-input-inline">
            <input type="text" name="unit" id="unit" lay-verify="required" placeholder="请输入单位" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">入库药品数量</label>
        <div class="layui-input-inline">
            <input type="text" name="rNum" id="rNum" lay-verify="required" placeholder="请输入入库药品数量" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">药品成本</label>
        <div class="layui-input-inline">
            <input type="text" name="cost" id="cost" lay-verify="required" placeholder="请输入药品成本" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">销售价</label>
        <div class="layui-input-inline">
            <input type="text" name="salePrice" id="salePrice" lay-verify="required" placeholder="请输入销售价" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">批号</label>
        <div class="layui-input-inline">
            <input type="text" name="batchNumber" id="batchNumber" lay-verify="required" placeholder="请输入批号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">生产日期</label>
        <div class="layui-input-inline">
            <input type="text" name="productDate" id="productDate" lay-verify="required" placeholder="请输入生产日期" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">有效期至</label>
        <div class="layui-input-inline">
            <input type="text" name="expiration" id="expiration" lay-verify="required" placeholder="请输入有效期至" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">入库时间</label>
        <div class="layui-input-inline">
            <input type="text" name="stockInTime" id="stockInTime" lay-verify="required" placeholder="请输入入库时间" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">部门</label>
        <div class="layui-input-inline">
            <input type="text" name="department" id="department" lay-verify="required" placeholder="请输入部门" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-inline">
            <input type="text" name="notes" id="notes" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>


    <br/><br/>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="updateStockInForm">修改入库单</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockInForm/stockInFormInfo.js"></script>
</body>
</html>