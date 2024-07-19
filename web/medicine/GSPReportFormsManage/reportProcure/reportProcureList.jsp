<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-10
  Time: 18:39
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
    <title>采购记录</title>
    <link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
    <style>
        .container {
            display: flex; /* 使用flex布局 */
            justify-content: space-between; /* 左右间距均匀分布 */
            align-items: flex-start; /* 垂直方向上顶部对齐 */
        }

        .left-div {
            width: 30%; /* 左边div宽度 */
            /*background-color: #ff0000; !* 背景颜色 *!*/
        }

        .right-div {
            width: 70%; /* 右边div宽度 */
            /*background-color: lightcoral; !* 背景颜色 *!*/
        }
        /* 基本样式 */
        select {
            width: 200px;
            height: 30px;
            padding: 5px;
            font-size: 16px;
            border: 1px solid #ccc;
            /*border-radius: 5px;*/
            background-color: #fff;
            color: #333;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
        }

        /* 鼠标悬停时的样式 */
        select:hover {
            border-color: #888;
        }

        /* 选中时的样式 */
        select:focus {
            border-color: #000;
            outline: none;
        }

        /* 选项样式 */
        select option {
            padding: 5px;
            font-size: 14px;
            color: #666;
        }

        /* 选项被选中时的样式 */
        select option:checked {
            background-color: #f0f0f0;
            color: #000;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
<%--        <blockquote class="layui-elem-quote layui-quote-nm">--%>

<%--        </blockquote>--%>

        <div class="layui-tab" lay-filter="test-hash">
            <ul class="layui-tab-title">
                <li class="layui-this" lay-id="11">数据</li>
                <li lay-id="22">图表1</li>
                <li lay-id="33">图表2</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <script type="text/html" id="purchaseDemo">
                        <div class="layui-row">
                            <div class="layui-col-xs3">
                                <input id="input" type="text" name="" placeholder="请输入" class="layui-input">
                            </div>
                            <div class="layui-col-xs3">
                                <button id="search" type="button" class="layui-btn"><i class="layui-icon layui-icon-search"></i> 搜索</button>
                            </div>
                            <div class="layui-col-xs3">
<%--                                <div class="grid-demo grid-demo-bg1">3/12</div>--%>
                            </div>
                            <div class="layui-col-xs3">
<%--                                <div class="grid-demo">3/12</div>--%>
                            </div>
                        </div>
                    </script>
                    <table id="purchaseList" lay-filter="purchaseList"></table>
                </div>
                <div class="layui-tab-item">
                    <div class="container">
                        <div class="left-div">
<%--                            <label>采购数量:</label>--%>
<%--                            <select id="buyNum" name="interest" lay-filter="aihao" >--%>
<%--                                <option value=""></option>--%>
<%--                                <option value="0" selected>全部</option>--%>
<%--                                <option value="1">最近三天</option>--%>
<%--                                <option value="2">最近七天</option>--%>
<%--                            </select>--%>
                            <br>
                            <br>
                            <br>
                            <br>
                            <ul id="nav" class="layui-nav layui-nav-tree" style="background-color: #000000;color: black">
                                <li class="layui-nav-item">
                                    <a href="javascript:;">采购记录</a>
                                    <dl class="layui-nav-child">
                                        <dd><a href="javascript:;">全部</a></dd>
                                        <dd><a href="javascript:;">最近三天</a></dd>
                                        <dd><a href="javascript:;">最近七天</a></dd>
                                    </dl>
                                </li>
                                <li class="layui-nav-item"><a href="javascript:;">采购类型</a></li>
                                <li class="layui-nav-item"><a href="javascript:;">采购商品</a></li>
                                <li class="layui-nav-item"><a href="javascript:;">今日销售</a></li>

                            </ul>
<%--                            <label>采购数量:</label>--%>
<%--                            <select name="interest" lay-filter="aihao">--%>
<%--                                <option value=""></option>--%>
<%--                                <option value="0" selected>全部</option>--%>
<%--                                <option value="1">阅读</option>--%>
<%--                                <option value="2">游戏</option>--%>
<%--                                <option value="3">音乐</option>--%>
<%--                                <option value="4">旅行</option>--%>
<%--                            </select>--%>

                        </div>
                        <div  id="main" class="right-div" style="width: 600px;height:400px;">

                        </div>
                    </div>
                </div>
                <div class="layui-tab-item">
                    <div class="container">
                        <div class="left-div">
<%--                            <label>供货商:</label>--%>
<%--                            <select id="supply" name="interest" lay-filter="aihao" >--%>
<%--                                <option value=""></option>--%>
<%--                                <option value="a" selected>a</option>--%>
<%--                                <option value="b">b</option>--%>
<%--                                <option value="c">c</option>--%>
                            </select>
                        </div>
                        <div id="pie" class="right-div" style="width: 600px;height:1000px;">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/echarts@5.0.2/dist/echarts.min.js" charset="utf-8"></script>
<%--<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.9.13/layui/layui.js" charset="utf-8"></script>--%>
<script type="text/javascript" src="<%=basePath %>medicinejs/GSPReportFormsManage/reportProcure/listreportpro.js" charset="utf-8"></script>
</body>

</html>
