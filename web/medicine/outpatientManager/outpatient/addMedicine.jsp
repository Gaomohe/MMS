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
    <title>门诊</title>
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
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">患者卡号:</label>
                <div class="layui-input-inline">
                    <input type="text" name="pid" lay-verify="pid" lay-event="pid" lay-filter="pid" placeholder="请输入卡号" autocomplete="off" class="layui-input">
                </div>
            </div>
            <hr class="layui-border-green">
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">患者姓名:</label>
                <div class="layui-input-inline">
                    <input type="text" name="pName" lay-verify="pName" lay-event="pName" lay-filter="pName" placeholder="请输入患者姓名" autocomplete="off" class="layui-input">
                </div>
            </div>
            <hr class="layui-border-green">
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">患者性别:</label>
                <div class="layui-input-inline">
                    <input type="text" name="sex" lay-verify="sex" lay-event="sex" lay-filter="sex" placeholder="性别" autocomplete="off" class="layui-input">
                </div>
            </div>
            <hr class="layui-border-green">
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">患者体重:</label>
                <div class="layui-input-inline">
                    <input type="text" onkeyup="value=value.match(/\d+\.?\d{0,2}/,'')" name="weight" lay-verify="weight" lay-event="weight" lay-filter="weight" placeholder="请输入患者体重" autocomplete="off" class="layui-input" οnkeyup='this.value=this.value.replace(/\D/gi,"")'>
                    <span style=" position: absolute; top: 1%; right: 6%;color: #000000; display: table-cell;white-space: nowrap; padding: 7px 10px;">Kg</span>
                </div>
            </div>
            <hr class="layui-border-green">
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">患者年龄:</label>
                <div class="layui-input-inline">
                    <input type="number" name="age" lay-verify="age" lay-event="age" lay-filter="sex" placeholder="请输入患者年龄" autocomplete="off" class="layui-input">
                </div>
            </div>
            <hr class="layui-border-green">
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">患者地址:</label>
                <div class="layui-input-inline">
                    <input type="text" name="address" lay-verify="address" lay-event="address" lay-filter="address" placeholder="请输入患者地址" autocomplete="off" class="layui-input">
                </div>
            </div>
            <hr class="layui-border-green">
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">过敏史:</label>
                <div class="layui-input-inline">
                    <input type="text" name="allergy" lay-verify="allergy" lay-event="allergy" lay-filter="allergy" placeholder="过敏史" autocomplete="off" class="layui-input">
                </div>
            </div>
            <hr class="layui-border-green">
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">诊断描述:</label>
                <div class="layui-input-inline">
                    <textarea cols="50" rows="10" type="text" name="disease" lay-verify="disease" lay-event="disease" lay-filter="disease" placeholder="请输入诊断描述" autocomplete="off" class="layui-input" style="width: 800px; height: 70px;"></textarea>
                </div>
            </div>
            <hr class="layui-border-green">
            <div class="layui-inline">
                <label style="width: auto" class="layui-form-label">就诊医嘱:</label>
                <div class="layui-input-inline">
                    <textarea cols="50" rows="10" type="text" name="doctorAdvice" lay-verify="doctorAdvice" lay-event="doctorAdvice" lay-filter="doctorAdvice" placeholder="请输入医嘱" autocomplete="off" class="layui-input" style="width: 800px; height: 70px;"></textarea>
                </div>
            </div>
            <hr class="layui-border-green">

            <script type="text/html" id="addMedicineDemo">
                <form id="searchForm">
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <input type="text" id="search" name="search" lay-verify="search" lay-event="search" lay-filter="search" placeholder="请输入搜索字段" autocomplete="off" class="layui-input">
                        </div>
                        <button type="button" id="submit" lay-event="submit" lay-filter="submit" class="layui-btn layui-bg-blue"><i class="layui-icon">&#xe615;</i>查询</button>
                    </div>
                    <button type="button" lay-event="addMedicine" class="layui-btn layui-btn-danger"><i class="layui-icon">&#xe654;</i>开处方</button>

                </form>
                <%--<c:forEach var="menu" items="${menuList}" varStatus="s">
&lt;%&ndash;                    ${menu.resUrl}&ndash;%&gt;
                </c:forEach>--%>
            </script>
            <table id="addMedicineList" lay-filter="addMedicineList"></table>
        </div>
        <%--<table id="addMedicineList2" lay-filter="addMedicineList2"></table>--%>
    </div>
</div>



<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/outpatientManager/outpatient/addMedicine.js" charset="utf-8"></script>
</body>
</html>