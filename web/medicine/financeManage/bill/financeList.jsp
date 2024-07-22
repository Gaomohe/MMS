<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Jack Zhu--%>
<%--  Date: 2024-07-11--%>
<%--  Time: 13:37--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"%>--%>
<%--<%--%>
<%--    String path = request.getContextPath();--%>
<%--    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";--%>
<%--%>--%>
<%--<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>总账</title>--%>
<%--    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />--%>
<%--    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />--%>
<%--    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">--%>
<%--    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">--%>

<%--</head>--%>
<%--<body>--%>
<%--<div class="layuimini-container">--%>
<%--&lt;%&ndash;            <blockquote class="layui-elem-quote layui-quote-nm">&ndash;%&gt;--%>

<%--&lt;%&ndash;            </blockquote>&ndash;%&gt;--%>

<%--    <script type="text/html" id="financeDemo">--%>

<%--        <div class="layui-inline">--%>
<%--            <label style="width: auto" class="layui-form-label">单据编号:</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="text" name="id" lay-verify="id" placeholder="请输入单据编号" autocomplete="off" class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        &lt;%&ndash;输入药品名称&ndash;%&gt;--%>
<%--        <div class="layui-inline">--%>
<%--            <label style="width: auto" class="layui-form-label">商品名称:</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="text" name="zname" lay-verify="zname" placeholder="请输入商品名称" autocomplete="off" class="layui-input">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        &lt;%&ndash;申请时间&ndash;%&gt;--%>
<%--        <div class="layui-inline">--%>
<%--            <label style="width: auto" class="layui-form-label">单据时间:</label>--%>
<%--            <div class="layui-input-inline">--%>
<%--                <input type="text" name="time" lay-event="time" class="layui-input" id="ID-laydate-demo" placeholder="请选择单据日期">--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <hr class="layui-border-green">--%>
<%--        &lt;%&ndash;            申请人&ndash;%&gt;--%>
<%--        <div class="layui-form layui-row layui-col-space16">--%>
<%--            <div class="layui-col-md2">--%>
<%--                <select id="applyuser">--%>
<%--                    <option value="">操作人员</option>--%>
<%--                    <c:forEach var="applyUser" items="${applyUser}" varStatus="s">--%>
<%--                        <option value="${applyUser.userName}">${applyUser.userName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class="layui-col-md2">--%>
<%--                <select id="state">--%>
<%--                    <option value="">单据状态</option>--%>
<%--                    <option value="未审批">未审阅</option>--%>
<%--                    <option value="已审批">已审阅通过</option>--%>
<%--                    <option value="已审批">已审阅未通过</option>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class="layui-col-md2">--%>
<%--                <select id="macuser">--%>
<%--                    <option value="">财务人员</option>--%>
<%--                    <c:forEach var="phaName" items="${phaName}" varStatus="s">--%>
<%--                        <option value="${phaName.userName}">${phaName.userName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class="layui-col-md2">--%>
<%--                <select id="cw">--%>
<%--                    <option value="">收款账户</option>--%>
<%--                    <c:forEach var="finName" items="${finName}" varStatus="s">--%>
<%--                        <option value="${finName.userName}">${finName.userName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class="layui-col-md2">--%>
<%--                <select id="fukuan">--%>
<%--                    <option value="">付款账户</option>--%>
<%--                    <c:forEach var="finName" items="${finName}" varStatus="s">--%>
<%--                        <option value="${finName.userName}">${finName.userName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class="layui-col-md2">--%>
<%--                <select id="cwss">--%>
<%--                    <option value="">供货商</option>--%>
<%--                    <c:forEach var="finName" items="${finName}" varStatus="s">--%>
<%--                        <option value="${finName.userName}">${finName.userName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>
<%--            <div class="layui-col-md2">--%>
<%--                <select id="ddd">--%>
<%--                    <option value="">收支状态</option>--%>
<%--                    <c:forEach var="finName" items="${finName}" varStatus="s">--%>
<%--                        <option value="${finName.userName}">${finName.userName}</option>--%>
<%--                    </c:forEach>--%>
<%--                </select>--%>
<%--            </div>--%>

<%--            <div class="layui-col-md4">--%>
<%--                <label style="width: auto" class="layui-form-label">单据备注:</label>--%>
<%--                <div class="layui-input-inline">--%>
<%--                    <input type="text" name="id" lay-verify="id" placeholder="请输入单据备注" autocomplete="off" class="layui-input">--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="layui-col-md4">--%>
<%--                <button type="button" lay-event="query" class="layui-btn layui-bg-blue">查询</button>--%>
<%--                <button lay-event="reset" class="layui-btn layui-btn-primary layui-border-green"><i class="layui-icon layui-icon-refresh-1"></i>重置</button>--%>
<%--            </div>--%>



<%--        </div>--%>

<%--        <hr class="layui-border-green">--%>
<%--        <button type="button" class="layui-btn layui-bg-blue">新增单据</button>--%>
<%--        <button lay-event="del" class="layui-btn layui-btn-primary layui-border"><i class="layui-icon layui-icon-delete"></i> 删除</button>--%>
<%--        <button lay-event="delOK" type="button" class="layui-btn layui-bg-red">清除已审阅</button>--%>
<%--        <button lay-event="audit" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-ok"></i>审核</button>--%>
<%--        <button lay-event="noaudit" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-disabled"></i>反审核</button>--%>
<%--        <button lay-event="export" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-download-circle"></i>导出</button>--%>
<%--        <button lay-event="export" class="layui-btn layui-btn-primary layui-border-blue"><i class="layui-icon layui-icon-upload-circle"></i>导入</button>--%>
<%--        <button type="button" class="layui-btn">生成报表</button>--%>


<%--    </script>--%>
<%--    <table id="financeList" lay-filter="financeList"></table>--%>
<%--    <div class="layuimini-main">--%>
<%--    </div>--%>
<%--</div>--%>


<%--<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>--%>
<%--<script type="text/javascript" src="<%=basePath %>medicinejs/financeManage/billjs/Listfince.js" charset="utf-8"></script>--%>


<%--</body>--%>
<%--</html>--%>
