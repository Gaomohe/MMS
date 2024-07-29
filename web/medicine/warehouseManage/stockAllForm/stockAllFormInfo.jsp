<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
        <label class="layui-form-label">药品名称</label>
        <div class="layui-input-inline">
            <input type="text" name="mName" id="mName" lay-verify="required"  placeholder="请输入入库单号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">规格</label>
        <div class="layui-input-inline">
            <input type="text" name="specification" id="specification" lay-verify="required" placeholder="请输入入库药品" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">生产企业</label>
        <div class="layui-input-inline">
            <input type="text" name="manufactor" id="manufactor" lay-verify="required" placeholder="请输入规格" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">单位</label>
        <div class="layui-input-inline">
            <input type="text" name="unit" id="unit" lay-verify="required" placeholder="请输入生产厂家" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">部门</label>
        <div class="layui-input-inline">
            <input type="text" name="department" id="department" lay-verify="required" placeholder="请输入单位" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">货位</label>
        <div class="layui-input-inline">
            <input type="text" name="position" id="position" lay-verify="required" placeholder="请输入入库药品数量" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">数量</label>
        <div class="layui-input-inline">
            <input type="text" name="number" id="number" lay-verify="required" placeholder="请输入药品成本" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">批号</label>
        <div class="layui-input-inline">
            <input type="text" name="batchNumber" id="batchNumber" lay-verify="required" placeholder="请输入销售价" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">有效期</label>
        <div class="layui-input-inline">
            <input type="text" name="usefulLife" id="usefulLife" lay-verify="required" placeholder="请输入批号" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">采购价</label>
        <div class="layui-input-inline">
            <input type="text" name="purchasePrice" id="purchasePrice" lay-verify="required" placeholder="请输入生产日期" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">销售价</label>
        <div class="layui-input-inline">
            <input type="text" name="salePrice" id="salePrice" lay-verify="required" placeholder="请输入有效期至" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">生产日期</label>
        <div class="layui-input-inline">
            <input type="text" name="productDate" id="productDate" lay-verify="required" placeholder="请输入入库时间" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">利润金额</label>
        <div class="layui-input-inline">
            <input type="text" name="profits" id="profits" lay-verify="required" placeholder="请输入部门" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">自编码</label>
        <div class="layui-input-inline">
            <input type="text" name="code" id="code" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">商品分类</label>
        <div class="layui-input-inline">
            <input type="text" name="goodsType" id="goodsType" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">药品分类</label>
        <div class="layui-input-inline">
            <input type="text" name="mType" id="mType" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">自定义类</label>
        <div class="layui-input-inline">
            <input type="text" name="defined" id="defined" lay-verify="required" placeholder="请输入自定义类" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供货商</label>
        <div class="layui-input-inline">
            <input type="text" name="supplier" id="supplier" lay-verify="required" placeholder="请输入供货商" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入库日期</label>
        <div class="layui-input-inline">
            <input type="text" name="warehousingDate" id="warehousingDate" lay-verify="required" placeholder="请输入入库日期" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">货位说明</label>
        <div class="layui-input-inline">
            <input type="text" name="locationDescription" id="locationDescription" lay-verify="required" placeholder="请输入货位说明" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标志</label>
        <div class="layui-input-inline">
            <input type="text" name="sign" id="sign" lay-verify="required" placeholder="请输入标志" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入库备注</label>
        <div class="layui-input-inline">
            <input type="text" name="warehousingRemarks" id="warehousingRemarks" lay-verify="required" placeholder="请输入入库备注" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">剂型</label>
        <div class="layui-input-inline">
            <input type="text" name="drugFrom" id="drugFrom" lay-verify="required" placeholder="请输入剂型" autocomplete="off" class="layui-input">
        </div>
    </div>
<%--    <div class="layui-form-item">--%>
<%--        <label class="layui-form-label">处理情况</label>--%>
<%--        <div class="layui-input-inline">--%>
<%--            <input type="text" name="handingInformation" id="handingInformation" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">--%>
<%--        </div>--%>
<%--    </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">批准文号</label>
        <div class="layui-input-inline">
            <input type="text" name="approvalNumber" id="approvalNumber" lay-verify="required" placeholder="请输入批准文号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上次养护日期</label>
        <div class="layui-input-inline">
            <input type="text" name="LastCuringDate" id="LastCuringDate" lay-verify="required" placeholder="请输入上次养护日期" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入库次数</label>
        <div class="layui-input-inline">
            <input type="text" name="timesStorage" id="timesStorage" lay-verify="required" placeholder="请输入入库次数" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单据号码</label>
        <div class="layui-input-inline">
            <input type="text" name="documentNumber" id="documentNumber" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产地</label>
        <div class="layui-input-inline">
            <input type="text" name="placeOrigin" id="placeOrigin" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">批次号</label>
        <div class="layui-input-inline">
            <input type="text" name="batchsNumber" id="batchsNumber" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">记录号</label>
        <div class="layui-input-inline">
            <input type="text" name="recordNumber" id="recordNumber" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">tableCoding</label>
        <div class="layui-input-inline">
            <input type="text" name="tableCoding" id="tableCoding" lay-verify="required" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>



    <br/><br/>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="upStockAllForm">修改库存盘点单</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockAllForm/stockAllFormInfo.js"></script>
</body>
</html>