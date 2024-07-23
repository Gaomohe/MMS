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
    <!-- Vendors Style-->
    <%--<link rel="stylesheet" href="<%= path %>/Deposito/main/css/vendors_css.css">
    <!-- Style-->
    <link rel="stylesheet" href="<%= path %>/Deposito/main/css/style.css">
    <link rel="stylesheet" href="<%= path %>/Deposito/main/css/skin_color.css">
--%>
<%--<link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/remixicon/fonts/remixicon.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/css/vendors_css.css">--%>
    <%--<link rel="stylesheet" href="<%= path %>iframe/assets/css/style.css">--%>
<%--    <link rel="stylesheet" href="<%= basePath %>iframe/assets/css/skin_color.css">--%>
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
        <div class="content-wrapper" style="width: 100%;margin-left: 0" >
            <div class="container-full">
                <!-- Main content -->
                <section class="content">
                    <div class="row">
                        <div class="col-xl-2 col-lg-4 order-3 order-xl-first">
                            <div class="box">
                                <div class="box-body text-center">
                                    <h2 class="my-0">3432</h2>
                                    <p class="mb-0 text-fade">New Order</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-6">
                            <div class="box">
                                <div class="box-body text-center">
                                    <div class="d-flex justify-content-around">
                                        <div>
                                            <h2 class="my-0">$ 532k</h2>
                                            <p class="mb-0 text-fade">Sales</p>
                                        </div>
                                        <div class="b-1"></div>
                                        <div>
                                            <h2 class="my-0">4125</h2>
                                            <p class="mb-0 text-fade">Total Orders</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-6">
                            <div class="box">
                                <div class="box-body text-center">
                                    <div class="d-flex justify-content-around">
                                        <div>
                                            <h2 class="my-0">2453</h2>
                                            <p class="mb-0 text-fade">Units Sold</p>
                                        </div>
                                        <div class="b-1"></div>
                                        <div>
                                            <h2 class="my-0">1942</h2>
                                            <p class="mb-0 text-fade">Low Stock</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-2 col-lg-4">
                            <div class="box">
                                <div class="box-body text-center">
                                    <h2 class="my-0">33(23%)</h2>
                                    <p class="mb-0 text-fade">Return Customers</p>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-2 col-lg-4">
                            <div class="box">
                                <div class="box-body text-center">
                                    <p class="mb-5 text-fade text-end" style="padding-bottom: 1px;">Time Period</p>
                                    <div class="btn-group w-p100">
                                        <button class="btn btn-sm btn-primary-light dropdown-toggle" type="button" data-bs-toggle="dropdown">Last One Month</button>
                                        <div class="dropdown-menu">
                                            <a class="dropdown-item" href="#">Three Month</a>
                                            <a class="dropdown-item" href="#">Six Month</a>
                                            <a class="dropdown-item" href="#">Last One Year</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-9 col-12">
                            <div class="box position-static">
                                <div class="box-header">
                                    <h4 class="box-title">Section Overview</h4>
                                    <div class="box-controls pull-right">
                                        <input class="form-control no-border bg-lightest" id="e" type="date">
                                    </div>
                                </div>
                                <div class="box-body">
                                    <div class="row mb-20">
                                        <div class="col-lg-3 col-md-6 col-12">
                                            <div class="row g-0 row-cols-auto">
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-6 col-12">
                                            <div class="row g-0 row-cols-auto">
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <div class="w-40 h-40 m-5">	</div>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-12">
                                            <div class="row g-0 row-cols-auto">
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <div class="w-40 h-40 m-5">	</div>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-lg-3 col-md-6 col-12">
                                            <div class="row g-0 row-cols-auto">
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-3 col-md-6 col-12">
                                            <div class="row g-0 row-cols-auto">
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <div class="w-40 h-40 m-5">	</div>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-lg-6 col-12">
                                            <div class="row g-0 row-cols-auto">
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <div class="w-40 h-40 m-5">	</div>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning-light d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Empty</h4>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                                <div class="col">
                                                    <div class="section-bx">
                                                        <a href="#" class="w-40 h-40 m-5 bg-warning d-block rounded10">
                                                            <div class="bx-dec">
                                                                <div class="section-dec d-flex align-items-center">
                                                                    <div class="box-img">
                                                                        <img src="../images/box.png" class="img-fluid" alt="" />
                                                                    </div>
                                                                    <div class="dec">
                                                                        <h4 class="text-white my-0">Row 3 #124578</h4>
                                                                        <p class="text-white">H60 x W60 x 20 KG</p>
                                                                        <p class="mb-0 text-white-50">Delivered 06:15PM</p>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="d-flex mt-20">
                                        <div class="d-flex">
                                            <div class="w-20 h-20 bg-warning-light rounded"></div>
                                            <h5 class="mx-15 my-0">Free Place</h5>
                                        </div>
                                        <div class="d-flex">
                                            <div class="w-20 h-20 bg-warning rounded"></div>
                                            <h5 class="mx-15 my-0">Loaded Place</h5>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-xl-6 col-12">
                                    <div class="box">
                                        <div class="box-header">
                                            <h4 class="box-title">Top Cities</h4>
                                        </div>
                                        <div class="box-body py-0">
                                            <div id="topcities"></div>
                                        </div>
                                        <div class="box-footer">
                                            <div class="d-flex justify-content-between">
                                                <div class="d-flex">
                                                    <p class="mb-0 me-10">Show</p>
                                                    <div class="btn-group">
                                                        <button class="btn btn-xs btn-primary-light dropdown-toggle" type="button" data-bs-toggle="dropdown">5 Result</button>
                                                        <div class="dropdown-menu">
                                                            <a class="dropdown-item" href="#">10 Result</a>
                                                            <a class="dropdown-item" href="#">15 Result</a>
                                                            <a class="dropdown-item" href="#">20 Result</a>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="d-flex">
                                                    <p class="mb-0 me-10">Short By</p>
                                                    <div class="btn-group">
                                                        <button class="btn btn-xs btn-primary-light dropdown-toggle" type="button" data-bs-toggle="dropdown">Order</button>
                                                        <div class="dropdown-menu">
                                                            <a class="dropdown-item" href="#">Delivery Date</a>
                                                            <a class="dropdown-item" href="#">Payment</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-12">
                                    <div class="box">
                                        <div class="box-header">
                                            <h4 class="box-title">Inventory Stock</h4>
                                        </div>
                                        <div class="box-body">
                                            <div id="recent_trend"></div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-12">
                                    <div class="box">
                                        <div class="box-header with-border">
                                            <h4 class="box-title">Orders Shipping Today</h4>
                                            <div class="box-controls pull-right">
                                                <div class="lookup lookup-circle lookup-right">
                                                    <input type="text" name="s">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-body p-0">
                                            <div class="table-responsive">
                                                <table class="table mb-0 dash-table">
                                                    <tr>
                                                        <td><a href="javascript:void(0)">1234</a></td>
                                                        <td><span class="text-muted text-nowrap">05-12-2021</span> </td>
                                                        <td>Donec</td>
                                                        <td><span class="badge badge-pill badge-danger">Shipping</span></td>
                                                        <td>$954</td>
                                                        <td><i class="fa fa-truck"></i></td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="javascript:void(0)">3215</a></td>
                                                        <td><span class="text-muted text-nowrap">05-13-2021</span> </td>
                                                        <td>Consectetur</td>
                                                        <td><span class="badge badge-pill badge-danger">Shipping</span></td>
                                                        <td>$512</td>
                                                        <td><i class="fa fa-truck"></i></td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="javascript:void(0)">4521</a></td>
                                                        <td><span class="text-muted text-nowrap">05-14-2021</span> </td>
                                                        <td>Vestibulum</td>
                                                        <td><span class="badge badge-pill badge-danger">Shipping</span></td>
                                                        <td>$745</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="javascript:void(0)">1452</a></td>
                                                        <td><span class="text-muted text-nowrap">05-15-2021</span> </td>
                                                        <td>Donec</td>
                                                        <td><span class="badge badge-pill badge-danger">Shipping</span></td>
                                                        <td>$875</td>
                                                        <td><i class="fa fa-truck"></i></td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="javascript:void(0)">7458</a></td>
                                                        <td><span class="text-muted text-nowrap">05-16-2021</span> </td>
                                                        <td>Nam ut</td>
                                                        <td><span class="badge badge-pill badge-danger">Shipping</span></td>
                                                        <td>$658</td>
                                                        <td></td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="javascript:void(0)">7451</a></td>
                                                        <td><span class="text-muted text-nowrap">05-17-2021</span> </td>
                                                        <td>Praesent</td>
                                                        <td><span class="badge badge-pill badge-danger">Shipping</span></td>
                                                        <td>$418</td>
                                                        <td><i class="fa fa-truck"></i></td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="javascript:void(0)">4125</a></td>
                                                        <td><span class="text-muted text-nowrap">05-18-2021</span> </td>
                                                        <td>Sed tempor</td>
                                                        <td><span class="badge badge-pill badge-danger">Shipping</span></td>
                                                        <td>$421</td>
                                                        <td></td>
                                                    </tr>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xl-6 col-12">
                                    <div class="box" style="background-color: #2e72ff;">
                                        <div class="box-header">
                                            <h4 class="box-title text-white">Statistics</h4>
                                        </div>
                                        <div class="box-body">
                                            <div class="d-flex justify-content-evenly">
                                                <div id="progressbar1" class="w-100 text-center position-relative"><span class="text-white">Total Orders<br>$415k</span></div>
                                                <div id="progressbar2" class="w-100 text-center position-relative"><span class="text-white">Orders Sent<br>25 out of 65</span></div>
                                                <div id="progressbar3" class="w-100 text-center position-relative"><span class="text-white">Orders picked<br>12 out of 65</span></div>
                                            </div>
                                            <div class="mt-50 d-flex justify-content-between align-items-end">
                                                <div>
                                                    <div id="apexChart2"></div>
                                                </div>
                                                <div>
                                                    <button type="button" class="waves-effect waves-light btn btn-rounded btn-warning-light text-dark"><i class="fa fa-ellipsis-h me-15"></i> View More</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-12">
                            <div class="box bg-success">
                                <div class="box-header">
                                    <h4 class="box-title text-white">Section 5 usage</h4>
                                </div>
                                <div class="box-body">
                                    <div id="progressbar4" class="text-center position-relative"><span class="text-white"><span class="fs-36">58%</span><br>Location used</span></div>
                                    <div class="mt-50 d-flex justify-content-evenly">
                                        <div class="text-center">
                                            <p class="mb-0 text-white-50">Loaded</p>
                                            <h4 class="mb-0 text-white">19 Shelves</h4>
                                        </div>
                                        <div class="text-center">
                                            <p class="mb-0 text-white-50">Empty</p>
                                            <h4 class="mb-0 text-white">64 Shelves</h4>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="box" id="bt-sellers">
                                <div class="box-header">
                                    <h4 class="box-title">
                                        Best Sellers This Quarter
                                    </h4>
                                </div>
                                <div class="box-body">
                                    <div class="inner-user-div3">
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Kelly Bookshelf</h5>
                                                    <p class="mb-0">BR 8129</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">124 Units</h3>
                                                    <p class="mb-0"><span>$588 per unit</span> | <strong>$72,931</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Darcy Side Table</h5>
                                                    <p class="mb-0">BR 3039</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">107 Units</h3>
                                                    <p class="mb-0"><span>$188 per unit</span> | <strong>$20,116</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Clarissa Chaise</h5>
                                                    <p class="mb-0">BR 8129</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">102 Units</h3>
                                                    <p class="mb-0"><span>$980 per unit</span> | <strong>$99,960</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Sheffield Bedframe</h5>
                                                    <p class="mb-0">BR 8129</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">98 Units</h3>
                                                    <p class="mb-0"><span>$1400 per unit</span> | <strong>$137,200</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Amelia Floorlamp</h5>
                                                    <p class="mb-0">BR 8129</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">93 Units</h3>
                                                    <p class="mb-0"><span>$110 per unit</span> | <strong>$10,230</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Kelly Bookshelf</h5>
                                                    <p class="mb-0">BR 8129</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">124 Units</h3>
                                                    <p class="mb-0"><span>$588 per unit</span> | <strong>$72,931</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Darcy Side Table</h5>
                                                    <p class="mb-0">BR 3039</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">107 Units</h3>
                                                    <p class="mb-0"><span>$188 per unit</span> | <strong>$20,116</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Clarissa Chaise</h5>
                                                    <p class="mb-0">BR 8129</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">102 Units</h3>
                                                    <p class="mb-0"><span>$980 per unit</span> | <strong>$99,960</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Sheffield Bedframe</h5>
                                                    <p class="mb-0">BR 8129</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">98 Units</h3>
                                                    <p class="mb-0"><span>$1400 per unit</span> | <strong>$137,200</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="box-shadowed p-10 mb-10 rounded10">
                                            <div class="d-flex justify-content-between align-items-center">
                                                <div>
                                                    <h5 class="my-5">Amelia Floorlamp</h5>
                                                    <p class="mb-0">BR 8129</p>
                                                </div>
                                                <div>
                                                    <h3 class="my-5">93 Units</h3>
                                                    <p class="mb-0"><span>$110 per unit</span> | <strong>$10,230</strong></p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6 col-12">
                            <div class="box">
                                <div class="box-header with-border">
                                    <h4 class="box-title">list of sections</h4>
                                </div>
                                <div class="box-body pt-0">
                                    <div class="table-responsive">
                                        <table class="table mb-0">
                                            <tr>
                                                <td><a href="javascript:void(0)">Section 001</a></td>
                                                <td><span class="text-muted text-nowrap"><i class="fa fa-calendar-o text-success-light mx-5"></i> 05-12-2021</span> </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <span class="mx-5">Used</span>
                                                        <div class="progress progress-xs w-p100 mt-0">
                                                            <div class="progress-bar bg-primary" role="progressbar" style="width: 20%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-end">20%</td>
                                            </tr>
                                            <tr>
                                                <td><a href="javascript:void(0)">Section 002</a></td>
                                                <td><span class="text-muted text-nowrap"><i class="fa fa-calendar-o text-success-light mx-5"></i> 05-12-2021</span> </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <span class="mx-5">Used</span>
                                                        <div class="progress progress-xs w-p100 mt-0">
                                                            <div class="progress-bar bg-primary" role="progressbar" style="width: 28%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-end">28%</td>
                                            </tr>
                                            <tr>
                                                <td><a href="javascript:void(0)">Section 003</a></td>
                                                <td><span class="text-muted text-nowrap"><i class="fa fa-calendar-o text-success-light mx-5"></i> 05-12-2021</span> </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <span class="mx-5">Used</span>
                                                        <div class="progress progress-xs w-p100 mt-0">
                                                            <div class="progress-bar bg-danger" role="progressbar" style="width: 80%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-end">80%</td>
                                            </tr>
                                            <tr>
                                                <td><a href="javascript:void(0)">Section 004</a></td>
                                                <td><span class="text-muted text-nowrap"><i class="fa fa-calendar-o text-success-light mx-5"></i> 05-12-2021</span> </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <span class="mx-5">Used</span>
                                                        <div class="progress progress-xs w-p100 mt-0">
                                                            <div class="progress-bar bg-warning" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-end">50%</td>
                                            </tr>
                                            <tr>
                                                <td><a href="javascript:void(0)">Section 005</a></td>
                                                <td><span class="text-muted text-nowrap"><i class="fa fa-calendar-o text-success-light mx-5"></i> 05-12-2021</span> </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <span class="mx-5">Used</span>
                                                        <div class="progress progress-xs w-p100 mt-0">
                                                            <div class="progress-bar bg-warning" role="progressbar" style="width: 58%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-end">58%</td>
                                            </tr>
                                            <tr>
                                                <td><a href="javascript:void(0)">Section 006</a></td>
                                                <td><span class="text-muted text-nowrap"><i class="fa fa-calendar-o text-success-light mx-5"></i> 05-12-2021</span> </td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <span class="mx-5">Used</span>
                                                        <div class="progress progress-xs w-p100 mt-0">
                                                            <div class="progress-bar bg-success" role="progressbar" style="width: 36%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td class="text-end">36%</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-12">
                            <div class="box">
                                <div class="box-header with-border">
                                    <h4 class="box-title">Average Inventory Turnaround</h4>
                                </div>
                                <div class="box-body py-0">
                                    <div id="overview_trend"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <!-- /.content -->
            </div>
        </div>
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
<!-- Vendor JS -->
<%--<script type="application/javascript" src="<%= path%>/Deposito/main/js/vendors.min.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/main/js/pages/chat-popup.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/assets/icons/feather-icons/feather.min.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/assets/vendor_components/apexcharts-bundle/dist/apexcharts.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/assets/vendor_components/progressbar.js-master/dist/progressbar.js"></script>
<script>
    document.getElementById('e').value = new Date().toISOString().substring(0, 10);
</script>
<!-- Deposito Admin App -->
<script type="application/javascript" src="<%= path%>/Deposito/main/js/template.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/main/js/pages/dashboard.js"></script>--%>
<script>
    layui.use(['index'], function () {
        var $ = layui.jquery;
        var index = layui.index;

        // 默认加载主页
        index.loadHome({
            menuPath: '../iframe/selectPages/所有首页可选择页面/introduction.jsp',
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