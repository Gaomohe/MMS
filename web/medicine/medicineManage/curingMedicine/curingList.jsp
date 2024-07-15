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

<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-body" style="padding-top: 5px;">
            <div class="layui-tab layui-tab-brief" lay-filter="tableXTab">
                <ul class="layui-tab-title">
                    <li>养护一览</li>
                    <li>养护记录</li>
                </ul>
                <div class="layui-tab-content" style="padding-left: 0;padding-right: 0;">
                    <div class="layui-tab-item layui-show">
                        <div class="layui-form toolbar">
                            <div class="layui-form-item text-right">
                                <script type="text/html" id="toolbarDemo">
                                    <div class="layui-inline">
                                        <label style="width: auto" class="layui-form-label">养护时间:</label>
                                        <div class="layui-input-inline">
                                            <input type="text" lay-event="time" lay-filter="time" class="layui-input" id="time" placeholder="请选择时间">
                                        </div>
                                    </div>
                                    <hr class="layui-border-green">
                                    <div class="layui-inline">
                                        <input id="search" class="layui-input icon-search" type="text" placeholder="输入药品名称按回车搜索"/>
                                    </div>
                                    <c:forEach var="menu" items="${menuList}" varStatus="s">
                                        ${menu.resUrl}
                                    </c:forEach>
                                </script>
                            </div>
                        </div>
                        <table class="layui-table" id="tableTbAdv" lay-filter="tableTbAdv"></table>
                    </div>


                    <%--第二页--%>
                    <div class="layui-tab-item">
                        <div id="xTable2">
                            <form class="layui-form">
                                <div class="layui-fluid" style="padding-bottom: 75px;">

                                    <div class="layui-card">
                                        <div class="layui-card-header">点击选择养护数据</div>
                                        <div class="layui-card-body">
                                            <table class="layui-table" id="curingTable1" lay-filter="curingTable1"></table>
                                        </div>
                                    </div>

                                    <div class="layui-card">
                                        <div class="layui-card-header">养护记录</div>
                                        <div class="layui-card-body">
                                            <table class="layui-table" id="curingTable2" lay-filter="curingTable2"></table>
                                            <script type="text/html" id="barDemo">
                                                <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
                                            </script>
                                        </div>
                                    </div>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 表格状态列 -->
<script type="text/html" id="tplStateTbAdv">
    <input type="checkbox" lay-filter="ckStateTbAdv" value="{{d.userId}}" lay-skin="switch"
           lay-text="已养护|未养护" {{d.state==0?'checked':''}}/>
</script>
<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script type="text/javascript" src="<%= path %>medicinejs/medicineManage/curingMedicine/curingList.js"></script>
<script type="text/javascript" src="<%= path %>medicinejs/medicineManage/curingMedicine/recordCuring.jsp.js"></script>
<%--<script type="text/javascript" src="<%= path %>medicinejs/medicineManage/medDictionary/dictionaryList.js"></script>--%>
</body>

</html>