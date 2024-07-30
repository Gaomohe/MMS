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
                            <div class="box-header"><h4 class="box-title text-white">表头1</h4></div>
                            <div class="box-body">
                                <div id="progressbar4" class="text-center position-relative"><span class="text-white"><span class="fs-48">100%</span><br>Location used</span></div>
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
                                <h4 class="box-title">Best Sellers This Quarter</h4>
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
