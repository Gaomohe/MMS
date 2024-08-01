<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>新增角色</title>
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
        <label class="layui-form-label">药品编号:</label>
        <div class="layui-input-block">
            <input type="text" id="mId" value="00" class="layui-input"/>
        </div>
    </div>
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
            <input  type="text" id="number" value="0" class="layui-input"/>
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
            <input  type="text" id="purchasePrice" value="0" class="layui-input"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">销售价:</label>
        <div class="layui-input-block">
            <input  type="text" id="salePrice" value="0" class="layui-input"/>
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
            <input type="text" id="profits" value="0" class="layui-input"/>
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
            <select id="select1" lay-search="" lay-creatable="">
                <option value="" hidden=""></option>
                <<c:forEach var="type" items="${type1}" varStatus="s">
                <option value="${type.typename}">${type.typename}</option>
            </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">药品分类:</label>
        <div class="layui-input-block">
            <select id="select2" lay-search="" lay-creatable="">
                <option value="" hidden=""></option>
                <<c:forEach var="type" items="${type2}" varStatus="s">
                <option value="${type.typename}">${type.typename}</option>
            </c:forEach>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">自定义类:</label>
        <div class="layui-input-block">
            <select id="select3" lay-search="" lay-creatable="">
                <option value="" hidden=""></option>
                <<c:forEach var="type" items="${type3}" varStatus="s">
                <option value="${type.typename}">${type.typename}</option>
            </c:forEach>
            </select>
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
            <select id="select4" lay-search="" lay-creatable="">
                <option value="" hidden=""></option>
                <<c:forEach var="type" items="${type4}" varStatus="s">
                <option value="${type.typename}">${type.typename}</option>
            </c:forEach>
            </select>
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
    <%--<div class="layui-form-item">
        <label class="layui-form-label">上次养护日期:</label>
        <div class="layui-input-block">
            <input type="date" id="lastCuringDate" value="" class="layui-input"/>
        </div>
    </div>--%>
    <div class="layui-form-item">
        <label class="layui-form-label">入库次数:</label>
        <div class="layui-input-block">
            <input type="text" id="timesStorage" value="0" class="layui-input"/>
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
            <input type="text" id="recordNumber" value="0" class="layui-input"/>
        </div>
    </div>

    <br/><br/>
    <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" id="tijiao" lay-filter="addRole">添加药品</button>
    </div>
</form>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/medicineManage/medDictionary/typesList.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/medicineManage/medDictionary/dictionaryAdd.js"></script>
</body>
</html>