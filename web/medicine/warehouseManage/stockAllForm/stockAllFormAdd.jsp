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
    <title>新增库存盘点单</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.9.13/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
</head>
<body class="childrenBody">
<form class="layui-form layui-form-pane" action="Javascript:void(0)">
    <div class="layui-form-item">
        <label class="layui-form-label">药品名称:</label>
        <div class="layui-input-block">
            <input type="text" id="mName" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">规格:</label>
        <div class="layui-input-block">
            <input type="text" id="specification" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">生产企业:</label>
        <div class="layui-input-block">
            <input type="text" id="manufactor" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单位:</label>
        <div class="layui-input-block">
            <input type="text" id="unit" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">部门:</label>
        <div class="layui-input-block">
            <input type="text" id="department" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">货位:</label>
        <div class="layui-input-block">
            <input type="text" id="position" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">数量:</label>
        <div class="layui-input-block">
            <input  type="text" id="number" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">批号:</label>
        <div class="layui-input-block">
            <input  type="text" id="batchNumber" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">有效期:</label>
        <div class="layui-input-block">
            <input  type="date" id="usefulLife" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">采购价:</label>
        <div class="layui-input-block">
            <input  type="text" id="purchasePrice" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">销售价:</label>
        <div class="layui-input-block">
            <input  type="text" id="salePrice" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">生产日期:</label>
        <div class="layui-input-block">
            <input  type="date" id="productDate" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">利润金额:</label>
        <div class="layui-input-block">
            <input type="text" id="profits" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">自编码:</label>
        <div class="layui-input-block">
            <input type="text" id="code" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">商品分类:</label>
        <div class="layui-input-block">
            <input type="text" id="goodsType" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">药品分类:</label>
        <div class="layui-input-block">
            <input type="text" id="mType" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">自定义类:</label>
        <div class="layui-input-block">
            <input type="text" id="defined" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">供货单位:</label>
        <div class="layui-input-block">
            <input  type="text" id="supplier" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入库日期:</label>
        <div class="layui-input-block">
            <input  type="date" id="warehousingDate" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">货位说明:</label>
        <div class="layui-input-block">
            <input type="text" id="locationDescription" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标志:</label>
        <div class="layui-input-block">
            <input type="text" id="sign" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入库备注:</label>
        <div class="layui-input-block">
            <input type="text" id="warehousingRemarks" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">剂型:</label>
        <div class="layui-input-block">
            <input type="text" id="drugFrom" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">处理情况:</label>
        <div class="layui-input-block">
            <input type="text" id="handlingInformation" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">批准文号:</label>
        <div class="layui-input-block">
            <input type="text" id="approvalNumber" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上次养护日期:</label>
        <div class="layui-input-block">
            <input type="date" id="lastCuringDate" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">入库次数:</label>
        <div class="layui-input-block">
            <input type="text" id="timesStorage" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">单据号码:</label>
        <div class="layui-input-block">
            <input type="text" id="documentNumber" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">产地:</label>
        <div class="layui-input-block">
            <input type="text" id="placeOrigin" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">批次号:</label>
        <div class="layui-input-block">
            <input type="text" id="batchsNumber" value="" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">记录号:</label>
        <div class="layui-input-block">
            <input type="text" id="recordNumber" value="" class="layui-input"/>
        </div>
    </div>

    <br/><br/>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="addStockAllForm">新增药品库存</button>
    </div>
</form>
<script src="//unpkg.com/layui@2.9.13/dist/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockAllForm/stockAllFormAdd.js"></script>

</body>
</html>