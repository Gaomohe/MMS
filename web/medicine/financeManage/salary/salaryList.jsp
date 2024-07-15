<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-12
  Time: 9:43
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
    <title>薪资管理</title>
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

<script type="text/html" id="salaryDemo">
    <form class="layui-form" action="">
        <div class="layui-row">
            <div class="layui-col-xs3">
                <input type="text" name="" placeholder="输入人员编号/名称" class="layui-input">
            </div>
            <div class="layui-col-xs3">
                <select>
                    <option id="state" value="">选择部门</option>
                    <option value="北京">A</option>
                    <option value="上海">B</option>
                    <option value="广州">C</option>
                    <option value="深圳">D</option>
                </select>
            </div>
            <div class="layui-col-xs2">
                <select>
                    <option id="" value="">选择性别</option>
                    <option value="北京">A</option>
                    <option value="上海">B</option>
                    <option value="广州">C</option>
                    <option value="深圳">D</option>
                </select>
            </div>
            <div class="layui-col-xs4">
                <button lay-event="search" type="button" class="layui-btn layui-bg-blue"><i class="bi bi-search"></i> 查询</button>
                <button lay-event="refresh" type="button" class="layui-btn layui-btn-primary layui-border"><i class="bi bi-bricks"></i> 重置</button>
            </div>
        </div>
        <br>
        <div class="layui-row">
            <div class="layui-col-xs12">
                <button type="button" class="layui-btn layui-bg-blue">基本资料</button>
                <button type="button" class="layui-btn">工资信息</button>
                <button type="button" class="layui-btn layui-bg-purple">考勤信息</button>
                <button type="button" class="layui-btn layui-bg-red">奖惩信息</button>
                <button type="button" class="layui-btn layui-bg-orange">税务信息</button>
                <button type="button" class="layui-btn layui-btn-primary layui-border">设置管理</button>
                <button type="button" class="layui-btn layui-btn-primary layui-border">投诉与帮助</button>
            </div>
        </div>
    </form>
</script>
<table  id="salaryList" lay-filter="salaryList"></table>



<script src="//unpkg.com/layui@2.9.14/dist/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/financeManage/salaryjs/listsalary.js" charset="utf-8"></script>

</body>
</html>
