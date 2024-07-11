<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">
    <title>复杂表格</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                <div class="layui-form-item text-right">
                    <script type="text/html" id="toolbarDemo">
                        <div class="layui-inline">
                            <label style="width: auto" class="layui-form-label">养护时间:</label>
                            <div class="layui-input-inline">
                                <input type="text" lay-event="time" lay-event="time" lay-filter="time" class="layui-input" id="time" placeholder="请选择时间">
                            </div>
                        </div>
                        <c:forEach var="menu" items="${menuList}" varStatus="s">
                            ${menu.resUrl}
                        </c:forEach>
                    </script>
                </div>
            <table class="layui-table" id="tableTbAdv" lay-filter="tableTbAdv"></table>
        </div>
    </div>

</div>

<!-- 表格状态列 -->
<script type="text/html" id="tplStateTbAdv">
    <input type="checkbox" lay-filter="ckStateTbAdv" value="{{d.userId}}" lay-skin="switch"
           lay-text="正常|锁定" {{d.state==0?'checked':''}}/>
</script>
<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script type="text/javascript" src="<%= path %>medicinejs/medicineManage/curingMedicine/curingList.js"></script>
<%--<script type="text/javascript" src="<%= path %>medicinejs/medicineManage/medDictionary/dictionaryList.js"></script>--%>
</body>

</html>