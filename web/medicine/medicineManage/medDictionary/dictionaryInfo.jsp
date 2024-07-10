<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <form class="layui-form layui-form-pane" action="Javascript:void(0)">
                <div class="layui-form-item">
                    <label class="layui-form-label">数据编号:</label>
                    <div class="layui-input-block">
                        <input readonly type="text" id="ID" value="${medicine.tableCoding}" class="layui-input"
                               lay-verType="tips" lay-verify="required" required/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">药品编号:</label>
                    <div class="layui-input-block">
                        <input type="text" id="mId" value="${medicine.mId}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">药品名称:</label>
                    <div class="layui-input-block">
                        <input type="text" id="mName" value="${medicine.mName}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">规格:</label>
                    <div class="layui-input-block">
                        <input type="text" id="specification" value="${medicine.specification}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">生产企业:</label>
                    <div class="layui-input-block">
                        <input type="text" id="manufactor" value="${medicine.manufactor}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">单位:</label>
                    <div class="layui-input-block">
                        <input type="text" id="unit" value="${medicine.unit}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">部门:</label>
                    <div class="layui-input-block">
                        <input type="text" id="department" value="${medicine.department}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">货位:</label>
                    <div class="layui-input-block">
                        <input type="text" id="position" value="${medicine.position}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">数量:</label>
                    <div class="layui-input-block">
                        <input  type="text" id="number" value="${medicine.number}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">批号:</label>
                    <div class="layui-input-block">
                        <input  type="text" id="batchNumber" value="${medicine.batchNumber}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">有效期:</label>
                    <div class="layui-input-block">
                        <input  type="date" id="usefulLife" value="${medicine.usefulLife}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">采购价:</label>
                    <div class="layui-input-block">
                        <input  type="text" id="purchasePrice" value="${medicine.purchasePrice}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">销售价:</label>
                    <div class="layui-input-block">
                        <input  type="text" id="salePrice" value="${medicine.salePrice}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">生产日期:</label>
                    <div class="layui-input-block">
                        <input  type="date" id="productDate" value="${medicine.productDate}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">利润金额:</label>
                    <div class="layui-input-block">
                        <input type="text" id="profits" value="${medicine.profits}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">自编码:</label>
                    <div class="layui-input-block">
                        <input type="text" id="code" value="${medicine.code}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">商品分类:</label>
                    <div class="layui-input-block">
                        <select id="select1" lay-search="" lay-creatable="">
                            <option value="${medicine.goodsType}" hidden=""></option>
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
                            <option value="${medicine.mType}" hidden=""></option>
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
                            <option value="${medicine.defined}" hidden=""></option>
                            <<c:forEach var="type" items="${type3}" varStatus="s">
                            <option value="${type.typename}">${type.typename}</option>
                        </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">供货单位:</label>
                    <div class="layui-input-block">
                        <input  type="text" id="supplier" value="${medicine.supplier}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">入库日期:</label>
                    <div class="layui-input-block">
                        <input  type="date" id="warehousingDate" value="${medicine.warehousingDate}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">货位说明:</label>
                    <div class="layui-input-block">
                        <input type="text" id="locationDescription" value="${medicine.locationDescription}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">标志:</label>
                    <div class="layui-input-block">
                        <input type="text" id="sign" value="${medicine.sign}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">入库备注:</label>
                    <div class="layui-input-block">
                        <input type="text" id="warehousingRemarks" value="${medicine.warehousingRemarks}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">剂型:</label>
                    <div class="layui-input-block">
                        <select id="select4" lay-search="" lay-creatable="">
                            <option value="${medicine.drugFrom}" hidden=""></option>
                            <<c:forEach var="type" items="${type4}" varStatus="s">
                            <option value="${type.typename}">${type.typename}</option>
                        </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">处理情况:</label>
                    <div class="layui-input-block">
                        <input type="text" id="handlingInformation" value="${medicine.handlingInformation}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">批准文号:</label>
                    <div class="layui-input-block">
                        <input type="text" id="approvalNumber" value="${medicine.approvalNumber}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">上次养护日期:</label>
                    <div class="layui-input-block">
                        <input type="date" id="ManageTime" value="${medicine.lastCuringDate}" class="layui-input"/>
                    </div>
                </div>
                <%-- <div class="layui-form-item">
                     <label class="layui-form-label">上次养护日期:</label>
                     <div class="layui-input-block">
                         <input type="text" id="person" value="${medicine.LastManageTime}" class="layui-input"/>
                     </div>
                 </div>--%>
                <div class="layui-form-item">
                    <label class="layui-form-label">入库次数:</label>
                    <div class="layui-input-block">
                        <input type="text" id="timesStorage" value="${medicine.timesStorage}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">单据号码:</label>
                    <div class="layui-input-block">
                        <input type="text" id="documentNumber" value="${medicine.documentNumber}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">产地:</label>
                    <div class="layui-input-block">
                        <input type="text" id="placeOrigin" value="${medicine.placeOrigin}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">批次号:</label>
                    <div class="layui-input-block">
                        <input type="text" id="batchsNumber" value="${medicine.batchsNumber}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">记录号:</label>
                    <div class="layui-input-block">
                        <input type="text" id="recordNumber" value="${medicine.recordNumber}" class="layui-input"/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" id="medicineUpdate" lay-filter="addRole">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=path%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>iframe/assets/js/common.js"></script>
<script type="text/javascript" src="<%=path%>medicinejs/medicineManage/medDictionary/dictionaryList.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path%>medicinejs/medicineManage/medDictionary/typesList.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path%>medicinejs/medicineManage/medDictionary/dictionaryInfo.js" charset="UTF-8"></script>
</body>
</html>