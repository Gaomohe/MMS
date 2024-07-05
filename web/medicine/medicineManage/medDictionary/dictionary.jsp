<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>
    </title>
    <link rel="stylesheet" href="<%=path%>iframe/assets/libs/layui/css/layui.css" />
    <link rel="stylesheet" href="<%=path%>iframe/assets/module/admin.css?v=314" />
</head>
<body>
<blockquote class="layui-elem-quote quoteBox" style="background-color: white;margin-top: 20px">
    药品字典
</blockquote>
<div class="layui-tab-item layui-show">
    <div class="layui-form toolbar">
        <div class="layui-form-item text-right">
            <script type="text/html" id="toolbarDemo">
                <c:forEach var="menu" items="${menuList}" varStatus="s">
                    ${menu.resUrl}
                </c:forEach>
                <div class="layui-inline">
                    <input tb-search="xTable1" class="layui-input icon-search" type="text" />
                </div>
            </script>
        </div>
    </div>
    <table id="xTable1" lay-filter="xTable1"></table>
</div>
</body>
<script type="text/javascript" src="<%=path%>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%=path%>iframe/assets/js/common.js"></script>
<script type="text/javascript" src="<%=path%>medicinejs/medicineManage/medDictionary/my.js" charset="UTF-8">
</script>
</html>