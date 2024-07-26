<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">
    <title>EasyWeb后台开发框架</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        /** 卡片轮播图样式 */
        .admin-carousel .layui-carousel-ind {
            position: absolute;
            top: -41px;
            text-align: right;
        }

        .admin-carousel .layui-carousel-ind ul {
            background: 0 0;
        }

        .admin-carousel .layui-carousel-ind li {
            background-color: #e2e2e2;
        }

        .admin-carousel .layui-carousel-ind li.layui-this {
            background-color: #999;
        }

        /** 广告位轮播图 */
        .admin-news .layui-carousel-ind {
            height: 45px;
        }

        .admin-news a {
            display: block;
            line-height: 60px;
            text-align: center;
        }

    </style>
</head>

<body>

<!-- 加载动画 -->
<div class="page-loading">
    <div class="ball-loader">
        <span></span><span></span><span></span><span></span>
    </div>
</div>

<!-- 正文开始 -->
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    药品总数<span class="layui-badge-rim">个</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">${mTotl}</p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    昨日入库药品<span class="layui-badge-rim">个</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">${yesterday}</p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    已过期药品<span class="layui-badge-rim">种</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">${out}</p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    需采购药品<span class="layui-badge-rim">种</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">${need}</p>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-row layui-col-space15">
        <div class="layui-col-lg8 layui-col-md7" style="width: 50%;">
            <div class="layui-tab-item layui-show">
                <div class="layui-form toolbar">
                    <div class="layui-form-item text-right">
                        <script type="text/html" id="toolbarDemo">
                            <div class="layui-inline">
                                <label style="width: auto" class="layui-form-label">选择时间:</label>
                                <div class="layui-input-inline">
                                    <input type="text" lay-event="time" lay-filter="time" class="layui-input" id="time" placeholder="请选择时间">
                                </div>
                                <input id="search" lay-event="enterSearch" class="layui-input icon-search" type="text" placeholder="输入药品名称按回车搜索"/>
                            </div>
                            <c:forEach var="menu" items="${menuList}" varStatus="s">
                                ${menu.resUrl}
                            </c:forEach>
                        </script>
                    </div>
                </div>
                <table id="xTable1" lay-filter="xTable1" style="background-color: white"></table>
            </div>
        </div>
        <div class="layui-col-lg8 layui-col-md7" style="width: 50%;">
            <div class="layui-tab-item layui-show">
                <table id="xTable2" lay-filter="xTable2" style="background-color: white"></table>
            </div>
        </div>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script type="text/javascript" src="<%=path%>medicinejs/qualityManage/warn/warnList.js" charset="UTF-8"></script>
<script type="text/javascript" src="<%=path%>medicinejs/qualityManage/warn/warndetailList.js" charset="UTF-8"></script>
<script>
    layui.use(['layer', 'carousel'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var carousel = layui.carousel;
        var device = layui.device;

        // 渲染轮播
        carousel.render({
            elem: '.layui-carousel',
            width: '100%',
            height: '60px',
            arrow: 'none',
            autoplay: true,
            trigger: device.ios || device.android ? 'click' : 'hover',
            anim: 'fade'
        });
    });
</script>
</body>

</html>