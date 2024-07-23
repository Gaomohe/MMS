<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="author" content="">
    <%--<link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">--%>
    <title>医药管理系统</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <link rel="stylesheet" href="<%= path %>iframe/assets/css/style.css">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <!-- 头部 -->
    <div class="layui-header">
        <div class="layui-logo">
            <img src="<%= path %>/iframe/assets/images/logo.png"/>
            <cite>医药管理系统</cite>
        </div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item" lay-unselect>
                <a ew-event="flexible" title="侧边伸缩"><i class="layui-icon layui-icon-shrink-right"></i></a>
            </li>
            <li class="layui-nav-item" lay-unselect>
                <a ew-event="refresh" title="刷新"><i class="layui-icon layui-icon-refresh-3"></i></a>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item" lay-unselect>
                <a ew-event="message" title="消息">
                    <i class="layui-icon layui-icon-notice"></i>
                    <span class="layui-badge-dot"></span><!--小红点-->
                </a>
            </li>
            <li class="layui-nav-item" lay-unselect>
                <a ew-event="note" title="便签"><i class="layui-icon layui-icon-note"></i></a>
            </li>
            <li class="layui-nav-item layui-hide-xs" lay-unselect>
                <a ew-event="fullScreen" title="全屏"><i class="layui-icon layui-icon-screen-full"></i></a>
            </li>
            <li class="layui-nav-item" lay-unselect>
                <a>
                    <img src="<%= path %>/iframe/assets/images/head.png" class="layui-nav-img">
                    <cite>管理员</cite>
                </a>
                <dl class="layui-nav-child">
                    <dd lay-unselect>
                        <a ew-href="page/template/user-info.html">个人中心</a>
                    </dd>
                    <dd lay-unselect>
                        <a ew-event="psw">修改密码</a>
                    </dd>
                    <hr>
                    <dd lay-unselect>
                        <a ew-event="logout" data-url="../iframe/login.jsp">退出</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-unselect>
                <a ew-event="theme" title="主题"><i class="layui-icon layui-icon-more-vertical"></i></a>
            </li>
        </ul>
    </div>

    <!--无限极左侧菜单-->
    <div class="layui-side">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree arrow2" lay-filter="admin-side-nav" lay-accordion="true"
                style="margin-top: 15px" id="side-nav"></ul>
        </div>
    </div>
    <!-- 主体部分 -->
    <div class="layui-body">
    </div>
    <!-- 底部 -->
    <div class="layui-footer">
        copyright © 2019 <a href="http://easyweb.vip" target="_blank">医药系统</a> all rights reserved.
        <span class="pull-right">Version 3.1.4</span>
    </div>
</div>

<!-- 加载动画 -->
<div class="page-loading">
    <div class="ball-loader">
        <span></span><span></span><span></span><span></span>
    </div>
</div>

<!-- js部分 -->
<script type="application/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="application/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['index'], function () {
        var $ = layui.jquery;
        var index = layui.index;

        // 默认加载主页
        index.loadHome({
            menuPath: '../iframe/firstPage.jsp',
            menuName: '<i class="layui-icon layui-icon-home"></i>'
        });

    });
</script>
<script type="application/javascript" src="<%= path %>/iframe/assets/libs/jquery/jquery-3.2.1.min.js"></script>
<script>
    // 获取菜单数据并渲染
    $.ajax({
        url: '/menu?action=selectMenu',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            var menuHtml = '';
            data.menuInfo.forEach(function (item) {
                menuHtml += renderMenu(item);
            });
            $('#side-nav').html(menuHtml);
            layui.element.render('nav', 'admin-side-nav');
        }
    });

    function renderMenu(item) {
        var html = '<li class="layui-nav-item">';
        if (item.child && item.child.length > 0) {
            html += '<a lay-href="javascript:;">' + (item.icon ? '<i class="' + item.icon + '"></i>' : '') + '<cite>' + item.title + '</cite></a>';
            html += '<dl class="layui-nav-child">';
            item.child.forEach(function (child) {
                html += renderMenu(child);
            });
            html += '</dl>';
        } else {
            html += '<a lay-href="' + item.href + '" target="' + item.target + '">' + (item.icon ? '<i class="' + item.icon + '"></i>' : '') + '<cite>' + item.title + '</cite></a>';
        }
        html += '</li>';
        return html;
    }
</script>
</body>
</html>