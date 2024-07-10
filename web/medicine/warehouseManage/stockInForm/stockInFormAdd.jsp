<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Demo</title>
    <link href="//cdn.staticfile.net/layui/2.9.13/css/layui.css" rel="stylesheet">    <!-- 请勿在项目正式环境中引用该 layui.css 地址 -->
    <%--    <link href="admin\lib\layui-v2.9.13\layui\css\layui.css" rel="stylesheet">--%>
</head>

<body>

<div class="layui-btn-container">
    <%--class="layui-input-inline"允许多个表单控件占一行，横着，一行可以放置多个表单元素--%>
    <%--layui-form-item单独使用这个类会默认该元素独占一行--%>
        <div class="layui-input-inline">
        <div class="layui-form layui-row layui-col-space10">
            <div class="layui-col-md4">
                <label class="layui-form-label">供货商</label>
                <select>
                    <option value="">请选择</option>
                    <option value="AAA">选项 A</option>
                    <option value="BBB">选项 B</option>
                    <option value="CCC">选项 C</option>
                </select>
            </div>
        </div>
        </div>

    <div class="layui-input-inline">
        <label class="layui-form-label">单据日期</label>
        <div class="layui-input-inline">
            <input type="text" class="layui-input" id="ID-laydate-type-datetime" placeholder="yyyy-MM-dd HH:mm:ss">
        </div>
    </div>

    <div class="layui-input-inline">
        <label class="layui-form-label">单据编号</label>
        <div class="layui-input-inline">
            <input type="text" placeholder="请输入单据编号" class="layui-input">
        </div>
    </div>

</div>


<%--    <form class="layui-form layui-form-pane" action="">--%>
<%--        <div class="layui-row" style="padding-top: 20px;">--%>
<%--            <div class="layui-col-xs6">--%>
<%--                <div class="grid-demo grid-demo-bg1">--%>
<%--                    <!-- 客户  -->--%>
<%--                    <div class="layui-form-item">--%>
<%--                        <div class="layui-input-group">--%>
<%--                            <div class="layui-input-prefix">--%>
<%--                                客户 *--%>
<%--                            </div>--%>
<%--                            <input type="text" placeholder="客户名称" class="layui-input">--%>
<%--                            <div class="layui-input-split layui-input-suffix" style="cursor: pointer;">--%>
<%--                                <i class="layui-icon layui-icon-search"></i>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="layui-col-xs6">--%>
<%--                <div class="grid-demo"><!-- 日期           -->--%>
<%--                    <div class="layui-inline">--%>
<%--                        <label class="layui-form-label">日期</label>--%>
<%--                        <div class="layui-input-inline layui-input-wrap">--%>
<%--                            <div class="layui-input-prefix">--%>
<%--                                <i class="layui-icon layui-icon-date"></i>--%>
<%--                            </div>--%>
<%--                            <input type="text" name="date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"--%>
<%--                                   class="layui-input">--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--        <div class="layui-card-body layui-text">--%>
<%--            <div id="tableRes" class="table-overlay">--%>
<%--                <table id="paramTable" lay-filter="paramTable" class="layui-hide"></table>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </form>--%>

<script src="//cdn.staticfile.net/layui/2.9.13/layui.js"></script>
<script type="text/javascript" src="<%=basePath %>admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/warehouseManage/stockInForm/addStockInForm.js"></script>
</body>
</html>