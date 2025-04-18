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
                    访问量<span class="layui-badge layui-bg-blue pull-right">周</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">99,666</p>
                    <p>总计访问量<span class="pull-right">88万 <i class="layui-icon layui-icon-flag"></i></span></p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    下载<span class="layui-badge layui-bg-black pull-right">月</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">33,555</p>
                    <p>新下载<span class="pull-right">10% <i class="layui-icon">&#xe601</i></span></p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    Start<span class="layui-badge layui-bg-green pull-right">周</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">99,666</p>
                    <p>总Start数<span class="pull-right">88万 <i class="layui-icon layui-icon-rate"></i></span></p>
                </div>
            </div>
        </div>
        <div class="layui-col-xs12 layui-col-sm6 layui-col-md3">
            <div class="layui-card">
                <div class="layui-card-header">
                    活跃用户<span class="layui-badge layui-bg-orange pull-right">月</span>
                </div>
                <div class="layui-card-body">
                    <p class="lay-big-font">66,666</p>
                    <p>最近一个月<span class="pull-right">15% <i class="layui-icon layui-icon-user"></i></span></p>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-row layui-col-space15">
        <div class="layui-col-lg8 layui-col-md7">
            <div class="layui-card">
                <div class="layui-card-header">更新日志</div>
                <div class="layui-card-body">
                    <ul class="layui-timeline">
                        <li class="layui-timeline-item">
                            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                            <div class="layui-timeline-content layui-text">
                                <h3 class="layui-timeline-title">
                                    V3.0
                                    <small>发布全新版本</small>&emsp;
                                    <span class="layui-badge-rim">2018-10-13</span>
                                </h3>
                                <ul>
                                    <li>侧导航栏折叠效果优化，PC端鼠标移入子菜单悬浮在右侧</li>
                                    <li>增加可自由切换主题功能，默认自带多套主题风格可选</li>
                                    <li>发布iframe版本、单标签版本，优化spa版本</li>
                                    <li>上线官网并采用付费授权模式，不再提供开源版本</li>
                                </ul>
                            </div>
                        </li>
                        <li class="layui-timeline-item">
                            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                            <div class="layui-timeline-content layui-text">
                                <h3 class="layui-timeline-title">
                                    V2.0
                                    <small>多标签、全新风格</small>&emsp;
                                    <span class="layui-badge-rim">2018-06-28</span>
                                </h3>
                                <ul>
                                    <li>增加侧导航栏折叠效果，PC端折叠为图标，移动端抽屉风格</li>
                                    <li>增加多标签选项卡的功能，且可自由配置是否开启多标签</li>
                                    <li>界面优化，主框架借鉴layadmin的设计风格，清新简洁</li>
                                    <li>使用SpringBoot、SpringSecurity、OAuth2.0重构后台部分</li>
                                </ul>
                            </div>
                        </li>
                        <li class="layui-timeline-item">
                            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                            <div class="layui-timeline-content layui-text">
                                <h3 class="layui-timeline-title">
                                    V1.0
                                    <small>第一个jQuery单页面框架</small>&emsp;
                                    <span class="layui-badge-rim">2018-01-02</span>
                                </h3>
                                <ul>
                                    <li>将公司基于Shiro、AdminLTE的框架改造成前后端分离模式</li>
                                    <li>引入q.js作为前端路由框架，实现SPA单页面效果</li>
                                    <li>去除Shiro，基于jjwt开发JwtPermission框架控制权限</li>
                                    <li>1.x版本开源后让很多对vue、react不熟悉的后端程序员也能够实现前后端分离</li>
                                </ul>
                            </div>
                        </li>
                        <li class="layui-timeline-item">
                            <i class="layui-icon layui-timeline-axis">&#xe63f;</i>
                            <div class="layui-timeline-content layui-text">
                                <div class="layui-timeline-title">
                                    EasyWeb默默开发中...&emsp;<span class="layui-badge-rim">更早</span>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <div class="layui-col-lg4 layui-col-md5">
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
            </div>
        </div>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
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