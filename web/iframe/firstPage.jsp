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
    <!-- Vendors Style-->
    <link rel="stylesheet" href="<%= basePath %>/Deposito/main/css/vendors_css.css">
    <!-- Style-->
    <link rel="stylesheet" href="<%= basePath %>/Deposito/main/css/style.css">
    <link rel="stylesheet" href="<%= basePath %>/Deposito/main/css/skin_color.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/remixicon/fonts/remixicon.css">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!-- 主体部分 -->
<div class="layui-body">
    <div class="content-wrapper" style="width: 100%;margin-left: 0" >
        <div class="container-full">
            <%--仓库容量显示--%>
            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-xl-2 col-lg-4 order-3 order-xl-first">
                        <div class="box">
                            <div class="box-body text-center">
                                <h2 class="my-0">${need}</h2>
                                <p class="mb-0 text-fade">需采购药品</p>
                            </div>
                        </div>
                    </div>
                    <div id="table1" class="col-xl-3 col-lg-6">
                        <div class="box">
                            <div class="box-body text-center">
                                <div class="d-flex justify-content-around">
                                    <div>
                                        <h2 class="my-0">${mTotl}</h2>
                                        <p class="mb-0 text-fade">药品种数</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="table2" class="col-xl-3 col-lg-6">
                        <div class="box">
                            <div class="box-body text-center">
                                <div class="d-flex justify-content-around">
                                    <div>
                                        <h2 class="my-0">${fNumber}</h2>
                                        <p class="mb-0 text-fade">未审不合格药品</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="table3" class="col-xl-2 col-lg-4">
                        <div class="box">
                            <div class="box-body text-center">
                                <h2 class="my-0">${rNumber}</h2>
                                <p class="mb-0 text-fade">未处理退货单</p>
                            </div>
                        </div>
                    </div>
                    <div id="table4" class="col-xl-2 col-lg-4">
                        <div class="box">
                            <div class="box-body text-center">
                                <h2 class="my-0">${uNumber}</h2>
                                <p class="mb-0 text-fade">未付款药品数</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xl-9 col-12">
                        <div class="box">
                            <div class="box-header with-border">
                                <h4 class="box-title">采购订单状态</h4>
                            </div>
                            <div class="box-body p-0">
                                <div class="table-responsive">
                                    <table class="table mb-0 dash-table">
                                        <div id="orderList"></div>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="box position-static">
                            <div class="col-12">
                                <div class="box">
                                    <div class="box-header with-border">
                                        <h4 class="box-title">查看在线人</h4>
                                    </div>
                                    <!-- /.box-header -->
                                    <div class="table-responsive">
                                        <table class="table table-hover">
                                            <tr>
                                                <th>用户</th>
                                                <th>登录时间</th>
                                                <th>角色</th>
                                                <th>联系方式</th>
                                            </tr>
                                            <tbody id="onlineUsers">
                                            <!-- 动态插入的行将出现在这里 -->
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.box-body -->
                                </div>
                                <!-- /.box -->
                            </div>
                        </div>
                    </div>
                    <div class="col-xl-3 col-12">
                        <div class="box bg-success">
                            <div id="ww_4697bb2a07fc1" v='1.3' loc='auto' a='{"t":"horizontal","lang":"zh","sl_lpl":1,"ids":[],"font":"Arial","sl_ics":"one_a","sl_sot":"celsius","cl_bkg":"#FFFFFF","cl_font":"#000000","cl_cloud":"#d4d4d4","cl_persp":"#2196F3","cl_sun":"#FFC107","cl_moon":"#FFC107","cl_thund":"#FF5722"}'><a href="https://weatherwidget.org/zh/" id="ww_4697bb2a07fc1_u" target="_blank">天气插件</a></div><script async src="https://app2.weatherwidget.org/js/?id=ww_4697bb2a07fc1"></script>
                        </div>
                        <div class="box" id="bt-sellers">
                            <div class="box-header">
                                <h4 class="box-title">药品预警</h4>
                            </div>
                            <div class="box-body" style="height: 400px; overflow-y: auto;" >
                                <div class="inner-user-div3" >
                                    <div id="warnTable"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <%--<div class="col-xl-9 col-12">
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
                    </div>--%>
                </div>
                <div class="row"></div>
            </section>
            <!-- /.content -->
        </div>
    </div>
</div>
<!-- js部分 -->
<!-- Vendor JS -->
<script type="application/javascript" src="<%= basePath%>/Deposito/main/js/vendors.min.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/main/js/pages/chat-popup.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/assets/icons/feather-icons/feather.min.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/assets/vendor_components/apexcharts-bundle/dist/apexcharts.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/assets/vendor_components/progressbar.js-master/dist/progressbar.js"></script>
<script>
    document.getElementById('e').value = new Date().toISOString().substring(0, 10);
</script>
<!-- Deposito Admin App -->
<script type="application/javascript" src="<%= basePath%>/Deposito/main/js/template.js"></script>
<script type="application/javascript" src="<%= path%>/Deposito/main/js/pages/dashboard.js"></script>
<script type="application/javascript" src="<%= basePath%>medicinejs/firstPage/onlineUser.js"></script>
</body>
</html>
