<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-12
  Time: 9:44
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
    <title>转账</title>
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
<script type="text/html" id="transferDemo">
    <form class="layui-form" action="">
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
                <input id="id" type="text" name="" placeholder="请输入单据编号" class="layui-input">
            </div>
            <div class="layui-col-xs2">
                <input id="name" type="text" name="" placeholder="请输入单据名称" class="layui-input">
            </div>

        </div>
        <div class="layui-row">
            <div class="layui-col-xs2">
                <select>
                    <option id="show2-opera" value="">选择操作员</option>
                    <option value="北京">A</option>
                    <option value="上海">B</option>
                    <option value="广州">C</option>
                    <option value="深圳">D</option>
                </select>
            </div>
            <div class="layui-col-xs2">
                <select>
                    <option id="finance" value="">选择财务人员</option>
                    <option value="北京">A</option>
                    <option value="上海">B</option>
                    <option value="广州">C</option>
                    <option value="深圳">D</option>
                </select>
            </div>
            <div class="layui-col-xs2">
                <select>
                    <option id="supply" value="">选择付款账户</option>
                    <option value="北京">A</option>
                    <option value="上海">B</option>
                    <option value="广州">C</option>
                    <option value="深圳">D</option>
                </select>
            </div>
            <div class="layui-col-xs2">
                <select>
                    <option id="state" value="">选择订单状态</option>
                    <option value="北京">A</option>
                    <option value="上海">B</option>
                    <option value="广州">C</option>
                    <option value="深圳">D</option>
                </select>
            </div>
        </div>
        <br>
        <div class="layui-row">
            <div class="layui-col-xs8">
                <button lay-event="search" type="button" class="layui-btn layui-bg-blue"><i class="bi bi-search"></i> 查询</button>
                <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-trash"></i> 删除</button>
                <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-check-lg"></i> 审核</button>
                <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-x-circle"></i> 反审核</button>
                <button class="layui-btn layui-btn-primary layui-border"><i class="bi bi-arrow-down-circle"></i> 导出</button>
            </div>
            <div class="layui-col-xs4">
                <button type="button" class="layui-btn"><i class="bi bi-plus"></i> 新增单据</button>
                <button lay-event="refresh" type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-bricks"></i> 重置</button>
            </div>
        </div>
    </form>
</script>
<table id="transferList" lay-filter="transferList"></table>



<script src="//unpkg.com/layui@2.9.14/dist/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/financeManage/transferjs/listTransfer.js" charset="utf-8"></script>


</body>
</html>
