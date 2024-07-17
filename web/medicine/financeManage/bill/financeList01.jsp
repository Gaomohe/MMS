<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-12
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>
<head>
    <title>总账管理</title>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
    <!-- 引入 layui.css -->
    <link href="//unpkg.com/layui@2.9.14/dist/css/layui.css" rel="stylesheet">
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">


</head>
<body>

<div class="layui-tab layui-tab-brief">
    <ul class="layui-tab-title">
<%--        <li class="layui-this">全部</li>--%>
        <li class="layui-this">收入单</li>
        <li>支出单</li>
        <li>预付款单</li>
        <li>固定资产</li>
    </ul>
    <div class="layui-tab-content">
<%--        <div class="layui-tab-item layui-show">--%>
<%--&lt;%&ndash;            内容-1 全部&ndash;%&gt;--%>
<%--            <script type="text/html" id="financeDemo">--%>
<%--                <form class="layui-form" action="">--%>
<%--                    <div class="layui-row">--%>
<%--                        <div class="layui-col-xs3">--%>
<%--                            <input id="show1-name" type="text" name="" placeholder="请输入商品名称" class="layui-input">--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs3">--%>
<%--                            <input id="show1-id" type="text" name="" placeholder="请输入单据编号" class="layui-input">--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs2">--%>
<%--                            <select id="show1-supply">--%>
<%--                                <option value="">选择供应商</option>--%>

<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs2">--%>
<%--                            <select id="show1-opera">--%>
<%--                                <option value="">选择操作员</option>--%>

<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs2">--%>
<%--                            <select id="show1-finance">--%>
<%--                                <option value="">选择财务人员</option>--%>

<%--                            </select>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    &lt;%&ndash;        <hr>&ndash;%&gt;--%>
<%--                    <div class="layui-row">--%>
<%--                        <div class="layui-col-xs8">--%>
<%--                            <div class="layui-form-item">--%>
<%--                                <div class="layui-inline">--%>
<%--                                    <label style="width: auto" class="layui-form-label">日期范围:</label>--%>
<%--                                    <div class="layui-inline" id="show1_dateRange">--%>
<%--                                        <div class="layui-input-inline">--%>
<%--                                            <input type="text" autocomplete="off" id="show1_laydate-start" class="layui-input" placeholder="开始日期">--%>
<%--                                        </div>--%>
<%--                                        <div class="layui-form-mid">-</div>--%>
<%--                                        <div class="layui-input-inline">--%>
<%--                                            <input type="text" autocomplete="off" id="show1_laydate-end" class="layui-input" placeholder="结束日期">--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs2">--%>
<%--                            <select id="show1-account">--%>
<%--                                <option value="">选择账户</option>--%>

<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs2">--%>
<%--                            <select id="show1-state">--%>
<%--                                <option value="">单据状态</option>--%>

<%--                            </select>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    &lt;%&ndash;        <hr>&ndash;%&gt;--%>
<%--                    <div class="layui-row">--%>
<%--                    <div class="layui-col-xs2">--%>
<%--                        <label for="show1-kind"></label>--%>
<%--                        <select id="show1-kind">--%>
<%--                            <option value="">选择单据</option>--%>
<%--                            <option value="收入单">收入单</option>--%>
<%--                            <option value="支出单">支出单</option>--%>
<%--                            <option value="预付款单">预付款单</option>--%>
<%--                        </select>--%>
<%--                    </div>--%>
<%--                    </div>--%>
<%--&lt;%&ndash;                    <hr>&ndash;%&gt;--%>
<%--                    <div class="layui-row">--%>
<%--                        <div class="layui-col-xs10">--%>
<%--                            <button lay-event="search" type="button" class="layui-btn layui-bg-blue"><i class="bi bi-search"></i> 查询</button>--%>
<%--                            <button lay-event="refresh" type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-bricks"></i> 重置</button>--%>
<%--                            <button lay-event="del"    type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-trash"></i> 删除</button>--%>
<%--                            <button lay-event="audit" type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-check-lg"></i> 审核</button>--%>
<%--                            <button lay-event="noaudit" type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-x-circle"></i> 反审核</button>--%>
<%--                            <button lay-event="export" type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-arrow-down-circle"></i> 导出</button>--%>
<%--                        </div>--%>
<%--                        <div class="layui-col-xs2">--%>
<%--&lt;%&ndash;                            <button lay-event="add" type="button" class="layui-btn"><i class="bi bi-plus"></i> 新增单据</button>&ndash;%&gt;--%>

<%--                        </div>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </script>--%>
<%--            <table id="financeList" lay-filter="financeList"></table>--%>

<%--        </div>--%>
        <div class="layui-tab-item layui-show">
<%--            内容-2-收入单--%>
            <script type="text/html" id="incomeDemo">
                <form class="layui-form" action="">
                    <div class="layui-row">
                        <div class="layui-col-xs3">
                            <input id="show2-name" type="text" name="" placeholder="请输入商品名称" class="layui-input">
                        </div>
                        <div class="layui-col-xs3">
                            <input id="show2-id" type="text" name="" placeholder="请输入批次" class="layui-input">
                        </div>
                        <div class="layui-col-xs2">
                            <select id="show2-supply">
                                <option value="">选择供应商</option>
                                <c:forEach var="supply1" items="${supply1}" varStatus="s">
                                    <option value="${supply1.supplier}">${supply1.supplier}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="layui-col-xs2">
                            <select>
                                <option id="show2-opera" value="">选择操作员</option>
                                <option value="无">无</option>
                            </select>
                        </div>
                        <div class="layui-col-xs2">
                            <select id="show2-finance">
                                <option value="">选择财务人员</option>
                                <option value="无">无</option>
                            </select>
                        </div>
                    </div>
                    <%--        <hr>--%>
                    <div class="layui-row">
                        <div class="layui-col-xs8">
                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <label style="width: auto" class="layui-form-label">日期范围:</label>
                                    <div class="layui-inline" id="show2_dateRange">
                                        <div class="layui-input-inline">
                                            <input type="text" autocomplete="off" id="show2_laydate-start" class="layui-input" placeholder="开始日期">
                                        </div>
                                        <div class="layui-form-mid">-</div>
                                        <div class="layui-input-inline">
                                            <input type="text" autocomplete="off" id="show2_laydate-end" class="layui-input" placeholder="结束日期">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="layui-col-xs2">
                            <select id="show2-account">
                                <option value="">收入账户</option>
                                <option value="无">无</option>
                            </select>
                        </div>
<%--                        <div class="layui-col-xs2">--%>
<%--                            <select id="show2-state">--%>
<%--                                <option value="">单据状态</option>--%>
<%--                                <option value="已审核">已审核</option>--%>
<%--                                <option value="未审核">未审核</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
                    </div>
                    <%--        <hr>--%>
                    <div class="layui-row">
                        <div class="layui-col-xs10">
                            <button lay-event="search" type="button" class="layui-btn layui-bg-blue"><i class="bi bi-search"></i> 查询</button>
                            <button lay-event="refresh" type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-bricks"></i> 重置</button>
                            <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-trash"></i> 删除</button>
<%--                            <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-check-lg"></i> 审核</button>--%>
<%--                            <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-x-circle"></i> 反审核</button>--%>
                            <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-arrow-down-circle"></i> 导出</button>
                        </div>
                        <div class="layui-col-xs2">
<%--                            <button type="button" class="layui-btn"><i class="bi bi-plus"></i> 新增收入单</button>--%>

                        </div>
                    </div>
                </form>
            </script>
            <table id="incomeList" lay-filter="incomeList"></table>
        </div>
        <div class="layui-tab-item">
<%--            内容-3-支出--%>
    <script type="text/html" id="spendDemo">
        <form class="layui-form" action="">
            <div class="layui-row">
                <div class="layui-col-xs3">
                    <input id="show3-name" type="text" name="" placeholder="请输入商品名称" class="layui-input">
                </div>
                <div class="layui-col-xs3">
                    <input id="show3-id" type="text" name="" placeholder="请输入批次号" class="layui-input">
                </div>
                <div class="layui-col-xs2">
                    <select id="show3-supply">

                        <option value="">选择供应商</option>
                        <c:forEach var="supply2" items="${supply2}" varStatus="s">
                            <option value="${supply2.supplier}">${supply2.supplier}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">选择操作员</option>
                        <option value="无">无</option>

                    </select>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">选择财务人员</option>
                        <option value="无">无</option>
                    </select>
                </div>
            </div>
            <%--        <hr>--%>
            <div class="layui-row">
                <div class="layui-col-xs8">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label style="width: auto" class="layui-form-label">日期范围:</label>
                            <div class="layui-inline" id="show3_dateRange">
                                <div class="layui-input-inline">
                                    <input type="text" autocomplete="off" id="show3_laydate-start" class="layui-input" placeholder="开始日期">
                                </div>
                                <div class="layui-form-mid">-</div>
                                <div class="layui-input-inline">
                                    <input type="text" autocomplete="off" id="show3_laydate-end" class="layui-input" placeholder="结束日期">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">支出账户</option>
                        <option value="北京">A</option>
                        <option value="上海">B</option>
                        <option value="广州">C</option>
                        <option value="深圳">D</option>
                    </select>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">单据状态</option>
                        <option value="已审批">已审批</option>
                        <option value="未审批">未审批</option>
                    </select>
                </div>
            </div>
            <%--        <hr>--%>
            <div class="layui-row">
                <div class="layui-col-xs10">
                    <button lay-event="search" type="button" class="layui-btn layui-bg-blue"><i class="bi bi-search"></i> 查询</button>
                    <button type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-bricks"></i> 重置</button>
                    <button type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-trash"></i> 删除</button>
                    <button type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-check-lg"></i> 审核</button>
                    <button type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-x-circle"></i> 反审核</button>
                    <button type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-arrow-down-circle"></i> 导出</button>
                </div>
                <div class="layui-col-xs2">
<%--                    <button type="button" class="layui-btn"><i class="bi bi-plus"></i> 新增单据</button>--%>

                </div>
            </div>
        </form>
    </script>
    <table id="spendList" lay-filter="spendList"></table>
        </div>
        <div class="layui-tab-item">
<%--            内容-4-预付款--%>
    <script type="text/html" id="advanceDemo">
        <form class="layui-form" action="">
            <div class="layui-row">
                <div class="layui-col-xs3">
                    <input id="show4-name" type="text" name="" placeholder="请输入商品名称" class="layui-input">
                </div>
                <div class="layui-col-xs3">
                    <input id="show4-id" type="text" name="" placeholder="请输入单据编号" class="layui-input">
                </div>
                <div class="layui-col-xs2">
                    <select id="show4-supply">
                        <option value="">选择供应商</option>
                        <c:forEach var="supply3" items="${supply3}" varStatus="s">
                            <option value="${supply3.supplier}">${supply3.supplier}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">选择操作员</option>
                        <option value="无">无</option>

                    </select>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">选择财务人员</option>
                        <option value="无">无</option>

                    </select>
                </div>
            </div>
            <%--        <hr>--%>
            <div class="layui-row">
                <div class="layui-col-xs8">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label style="width: auto" class="layui-form-label">日期范围:</label>
                            <div class="layui-inline" id="show4_dateRange">
                                <div class="layui-input-inline">
                                    <input type="text" autocomplete="off" id="show4_laydate-start" class="layui-input" placeholder="开始日期">
                                </div>
                                <div class="layui-form-mid">-</div>
                                <div class="layui-input-inline">
                                    <input type="text" autocomplete="off" id="show4_laydate-end" class="layui-input" placeholder="结束日期">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">预付款账户</option>
                        <option value="无">无</option>

                    </select>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">单据状态</option>
                        <option value="已审核">已审核</option>
                        <option value="未审核">未审核</option>
                    </select>
                </div>
            </div>
            <%--        <hr>--%>
            <div class="layui-row">
                <div class="layui-col-xs8">
                    <button type="button" class="layui-btn layui-bg-blue"><i class="bi bi-search"></i> 查询</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-bricks"></i> 重置</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-trash"></i> 删除</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-check-lg"></i> 审核</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-x-circle"></i> 反审核</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-arrow-down-circle"></i> 导出</button>
                </div>
                <div class="layui-col-xs4">
<%--                    <button type="button" class="layui-btn"><i class="bi bi-plus"></i> 新增单据</button>--%>

                </div>
            </div>
        </form>
    </script>
    <table id="advanceList" lay-filter="advanceList"></table>
        </div>
        <div class="layui-tab-item">
<%--            内容-5-固定资产--%>
    <script type="text/html" id="assetDemo">
        <form class="layui-form" action="">
            <div class="layui-row">
                <div class="layui-col-xs3">
                    <input type="text" name="" placeholder="请输入资产名称" class="layui-input">
                </div>
                <div class="layui-col-xs3">
                    <input type="text" name="" placeholder="请输入资产编号" class="layui-input">
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">选择资产类别</option>
                        <option value="北京">北京</option>
                        <option value="上海">上海</option>
                        <option value="广州">广州</option>
                        <option value="深圳">深圳</option>
                    </select>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">选择资产供应商</option>
                        <option value="北京">A</option>
                        <option value="上海">B</option>
                        <option value="广州">C</option>
                        <option value="深圳">D</option>
                    </select>
                </div>
                <div class="layui-col-xs2">
                    <select>
                        <option value="">选择资产状态</option>
                        <option value="北京">A</option>
                        <option value="上海">B</option>
                        <option value="广州">C</option>
                        <option value="深圳">D</option>
                    </select>
                </div>
            </div>
            <%--        <hr>--%>
            <br>
            <%--        <hr>--%>
            <div class="layui-row">
                <div class="layui-col-xs12">
                    <button type="button" class="layui-btn layui-bg-blue"><i class="bi bi-search"></i> 查询</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-trash"></i> 删除</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-check-lg"></i> 闲置</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-x-circle"></i> 报废</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-arrow-down-circle"></i> 导出</button>
                    <button type="button" class="layui-btn"><i class="bi bi-plus"></i> 新增资产</button>
                    <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-bricks"></i> 重置</button>
                </div>
            </div>
        </form>
    </script>
    <table id="assetList" lay-filter="assetList"></table>
        </div>
    </div>
</div>












<!-- 引入 layui.js -->
<%--<script src="../../../admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/mhDoLbDldZc3qpsJHpLogda//BVZbgYuw6kof4u2FrCedxOtgRZDTHgHUhOCVim" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-7ymO4nGrkm372HoSbq1OY2DP4pEZnMiA+E0F3zPr+JQQtQ82gQ1HPY3QIVtztVua" crossorigin="anonymous"></script>--%>
<script src="//unpkg.com/layui@2.9.14/dist/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/financeManage/billjs/Lisfince01.js" charset="utf-8"></script>

</body>
</html>
