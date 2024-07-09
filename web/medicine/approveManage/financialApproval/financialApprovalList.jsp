<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>采购审批</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
</head>
<body class="childrenBody">
<div class="layui-form">
    <div class="layuimini-container">
        <div class="layuimini-main">
            <script type="text/html" id="financialDemo">



                <c:forEach var="menu" items="${menuList}" varStatus="s">
                    ${menu.resUrl}
                </c:forEach>
            </script>
            <table id="financialList" lay-filter="financialList"></table>
        </div>
        <div class="layuimini-main">
            <script type="text/html" id="purchaseDemo">

                <hr class="layui-border-green">
                <div class="layui-form layui-row layui-col-space16">
                    <div class="layui-form-item layui-row layui-col-xs12">
                        <label class="layui-form-label">选择类型</label>
                        <div class="layui-input-block">
                            <div class="layui-input-block">
                                <select name="type" id="applyUser" lay-filter="applyUser"></select>
                            </div>
                        </div>
                    </div>
                    <div class="layui-col-md2">
                        <select lay-search="" lay-event="status">
                            <option value="0" selected>状态</option>
                            <option value="1">未审批</option>
                            <option value="2">已审批</option>
                        </select>
                    </div>
                    <div class="layui-col-md2">
                        <select lay-search="" lay-event="pharmacist">
                            <option value="">药师</option>
                            <option value="1">AAA</option>
                        </select>
                    </div>
                    <div class="layui-col-md2">
                        <select lay-search="" lay-event="financial">
                            <option value="">财务</option>
                            <option value="1">AAA</option>
                        </select>
                    </div>
                    <div class="layui-col-md4">
                        <button type="button"  lay-event="search" class="layui-btn layui-bg-blue">查询</button>
                        <button  lay-event="reload" class="layui-btn layui-btn-primary layui-border-green"><i class="layui-icon layui-icon-refresh-1"></i>重置</button>
                    </div>
                </div>
                <hr class="layui-border-green">
                <button  lay-event="del" class="layui-btn layui-btn-primary layui-border"><i class="layui-icon layui-icon-delete"></i> 删除</button>
                <button  lay-event="approve" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-ok"></i>审核</button>
                <button  lay-event="unapprove" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-disabled"></i>反审核</button>
                <button  lay-event="download" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-download-circle"></i>导出</button>

            </script>

            <table id="purchaseList" lay-filter="purchaseList"></table>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/approveManage/financialApproval/financialApprovalList.js" charset="utf-8"></script>
</body>
</html>