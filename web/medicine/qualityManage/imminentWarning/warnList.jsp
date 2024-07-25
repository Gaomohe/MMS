<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
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
                    药品总数<span class="layui-badge layui-bg-blue pull-right">个</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">？</p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    昨日入库药品<span class="layui-badge layui-bg-black pull-right">个</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">？</p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    已过期药品<span class="layui-badge layui-bg-green pull-right">种</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">？</p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    需采购药品<span class="layui-badge layui-bg-orange pull-right">种</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">？</p>
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
                            <c:forEach var="menu" items="${menuList2}" varStatus="s">
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
        <%--<div class="layui-col-lg4 layui-col-md5" style="width: 23.333%;">
            <div class="layui-card">
                <div class="layui-card-header">前端框架</div>
                <div class="layui-card-body">
                    <table class="layui-table layui-text">
                        <colgroup>
                            <col width="100">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td>基础框架</td>
                            <td><a href="http://www.layui.com/" target="_blank">layui-v2.5.3</a></td>
                        </tr>
                        <tr>
                            <td>路由框架</td>
                            <td>
                                lay-Router（基于<a href="https://github.com/itorr/q.js" target="_blank">q.js</a>进行改进封装）
                            </td>
                        </tr>
                        <tr>
                            <td>主要特色</td>
                            <td>单页面 / 响应式 / 简约 / 易上手</td>
                        </tr>
                        <tr>
                            <td>获取源码</td>
                            <td>
                                <a href="https://easyweb.vip" target="_blank" class="layui-btn layui-btn-sm">前往官网</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="layui-card">
                <div class="layui-card-header">前端框架</div>
                <div class="layui-card-body">
                    <table class="layui-table layui-text">
                        <colgroup>
                            <col width="100">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td>基础框架</td>
                            <td><a href="http://www.layui.com/" target="_blank">layui-v2.5.3</a></td>
                        </tr>
                        <tr>
                            <td>路由框架</td>
                            <td>
                                lay-Router（基于<a href="https://github.com/itorr/q.js" target="_blank">q.js</a>进行改进封装）
                            </td>
                        </tr>
                        <tr>
                            <td>主要特色</td>
                            <td>单页面 / 响应式 / 简约 / 易上手</td>
                        </tr>
                        <tr>
                            <td>获取源码</td>
                            <td>
                                <a href="https://easyweb.vip" target="_blank" class="layui-btn layui-btn-sm">前往官网</a>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            &lt;%&ndash;<div class="layui-card">
                <div class="layui-card-header">后台框架</div>
                <div class="layui-card-body">
                    <table class="layui-table layui-text">
                        <colgroup>
                            <col width="100">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td>核心框架</td>
                            <td>Spring、Spring MVC、Spring Boot</td>
                        </tr>
                        <tr>
                            <td>持久层</td>
                            <td>MyBatis、Druid、<a href="http://mp.baomidou.com" target="_blank">MyBatis-Plus</a>
                            </td>
                        </tr>
                        <tr>
                            <td>权限框架</td>
                            <td>Shiro、<a href="https://easyweb.vip" target="_blank">JwtPermission</a>(API接口权限)
                            </td>
                        </tr>
                        <tr>
                            <td>其他</td>
                            <td>IDEA(开发工具)、MySQL(数据库)</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <div class="layui-card">
                <div class="layui-card-header">友情链接</div>
                <div class="layui-card-body">
                    <div class="layui-carousel admin-carousel admin-news">
                        <div carousel-item>
                            <div>
                                <a href="http://www.layui.com/" target="_blank" class="layui-bg-green">
                                    layui - 经典模块化前端框架
                                </a>
                            </div>
                            <div>
                                <a href="http://fly.layui.com/extend/" target="_blank" class="layui-bg-cyan">
                                    layui第三方组件平台
                                </a>
                            </div>
                            <div>
                                <a href="http://fly.layui.com/case/2018/" target="_blank" class="layui-bg-blue">
                                    发现layui年度最佳案例
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>&ndash;%&gt;
        </div>--%>
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