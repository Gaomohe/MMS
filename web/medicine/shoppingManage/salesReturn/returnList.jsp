<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">
    <title>退货退款</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .red-bg {
            background-color: #ffcccc !important; /* 红色背景，注意可能需要!important来覆盖其他样式 */
            color: red; /* 文本颜色，根据需要设置 */
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
            <div class="layui-form toolbar">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">货&nbsp;&nbsp;单&nbsp;&nbsp;状&nbsp;&nbsp;态： </label>
                        <div class="layui-col-md6" style="width: 100px;margin-right: 5px">
                            <select id="select1" lay-search="" lay-creatable="">
                                <option value="">订单状态</option>
                                <option value="未到货">未到货</option>
                                <option value="到货未退款">到货未退款</option>
                                <option value="已退款">已退款</option>
                            </select>
                        </div>
                        <button class="layui-btn icon-btn" id="searchByQuerys2" lay-event="searchByQuerys" lay-filter="formSubSearchTbBas" lay-submit>
                            <i class="layui-icon">&#xe615;</i>搜索
                        </button>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">发&nbsp;&nbsp;货&nbsp;&nbsp;人：</label>
                        <div class="layui-input-inline">
                            <input id="consigner" name="consigner" class="layui-input" type="text" placeholder="输入发货人"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">收&nbsp;&nbsp;货&nbsp;&nbsp;人：</label>
                        <div class="layui-input-inline">
                            <input id="consignee" name="consignee" class="layui-input" type="text" placeholder="输入收货人"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">退&nbsp;&nbsp;货&nbsp;&nbsp;单&nbsp;&nbsp;号：</label>
                        <div class="layui-input-inline">
                            <input id="returnId" name="returnId" class="layui-input" type="text" placeholder="输入退货单号"/>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">电&emsp;话：</label>
                        <div class="layui-input-inline">
                            <input id="phone" name="phone" class="layui-input" type="text" placeholder="输入联系方式"/>
                        </div>
                    </div>
                </div>
                <script type="text/html" id="toolbarDemo">
                    <c:forEach var="menu" items="${menuList}" varStatus="s">
                        ${menu.resUrl}
                    </c:forEach>
                </script>
            </div>
            <table class="layui-table" id="tableTbAdv" lay-filter="tableTbAdv"></table>
        </div>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script type="text/javascript" src="<%= path %>medicinejs/shoppingManagejs/salesReturn/returnList.js"></script>
</body>

</html>