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
    <title>系统日志</title>
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
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="style.css">
    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            padding: 0;
            background: #494A5F;
            font-weight: 500;
            font-family: "Microsoft YaHei","宋体","Segoe UI", "Lucida Grande", Helvetica, Arial,sans-serif, FreeSans, Arimo;
        }

        #container {
            width: 500px;
            height: 820px;
            margin: 0 auto;
        }
        div.search {padding: 30px 0;}

        form {
            position: relative;
            width: 300px;
            margin: 0 auto;
        }

        input, button {
            border: none;
            outline: none;
        }

        input {
            width: 100%;
            height: 42px;
            padding-left: 13px;
        }

        button {
            height: 42px;
            width: 42px;
            cursor: pointer;
            position: absolute;
        }

        /*搜索框7*/
        .bar7 {background: #7BA7AB;}
        .bar7 form {
            height: 42px;
        }
        .bar7 input {
            width: 250px;
            border-radius: 42px;
            border: 2px solid #324B4E;
            background: #F9F0DA;
            transition: .3s linear;
            float: right;
        }
        .bar7 input:focus {
            width: 300px;
        }
        .bar7 button {
            background: none;
            top: -2px;
            right: 0;
        }
        .bar7 button:before{
            content: "\f002";
            font-family: FontAwesome;
            color: #324b4e;
        }
    </style>
</head>
<body class="childrenBody">

<div class="layuimini-container">
    <div class="layuimini-main">
        <blockquote class="layui-elem-quote quoteBox">
            日志列表
            <div class="search bar7">
                <form>
                    <input type="text" placeholder="请输入您要搜索的内容...">
                    <button type="submit"></button>
                </form>
            </div>
        </blockquote>
        <script type="text/html" id="roleDemo">
            <c:forEach var="menu" items="${menuList}" varStatus="s">
                ${menu.resUrl}
            </c:forEach>
        </script>
        <table id="newsList" lay-filter="newsList"></table>
    </div>
</div>

<!-- 权限更改 -->
<div style="height: 400px;overflow: auto;display: none" id="dtree1">
    <ul id="dataTree3" class="dtree" data-id="0"></ul>
</div>

<script type="text/javascript" src="<%=basePath %>admin/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basePath %>medicinejs/systemManage/log/logList.js" charset="utf-8"></script>
</body>
</html>