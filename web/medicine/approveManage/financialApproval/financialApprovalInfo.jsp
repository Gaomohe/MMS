<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<head>
    <title>审批</title>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #f2f2f2;
        font-weight: bold;
    }
    #dialogBox {
        position: fixed; /* 固定定位，相对于浏览器窗口 */
        left: 25%;
        top: 25%;
        width: 50%;
        background: white;
        border: 1px solid black;
        padding: 20px;
        z-index: 1000; /* 确保对话框在页面最上层 */
    }
</style>
<body>
<form class="" action="Javascript:void(0)">
    <table id="tableID">
        <thead>
        <tr>
            <th>选择</th>
            <th>单据编号</th>
            <th>药品名称</th>
            <th>药品库存</th>
            <th>种类</th>
            <th>规格</th>
            <th>状态</th>
            <th>申请数量</th>
            <th>采购价格</th>
        </tr>
        </thead>
        <tbody id="table-body">
        <!-- 动态填充数据的地方 -->
        </tbody>
    </table>
    <%--    <div class="layuimini-container">--%>
    <%--        <div class="layuimini-main">--%>
    <%--            <script type="text/html" id=""></script>>--%>
    <%--        </div>--%>
    <%--    </div>--%>

    <br/><br/>
    <div class="layui-form-item" style="width: 50%;margin: auto">

        <button id="isok" type="button" class="layui-btn layui-bg-blue">通过</button>
        <button id="nook" type="button" class="layui-btn layui-bg-red">不通过</button>
        <button id="allok" type="button" class="layui-btn">全部通过</button>
        <button id="out" class="layui-btn layui-btn-primary layui-border">取消</button>
    </div>
</form>
<!-- 对话框容器，初始时隐藏 -->
<div id="dialogBox" style="display:none;">
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">备注:</label>
        <div class="layui-input-block">
            <textarea placeholder="需要填写不通过的原因" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button type="submit" id="tijao" class="layui-btn" lay-submit lay-filter="demo1">立即提交</button>
            <button type="reset" id="cz" class="layui-btn layui-btn-primary">重置</button>
            <button type="reset" id="out_1" class="layui-btn layui-btn-primary">取消</button>
        </div>
    </div>

</div>
<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>--%>
<script type="text/javascript" src="<%=basePath %>medicinejs/approveManage/financialApproval/financialApprovalInfo.js" charset="utf-8"></script>
</body>
</html>