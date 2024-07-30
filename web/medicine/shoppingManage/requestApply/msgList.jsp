<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-29
  Time: 9:46
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
    <title>消息</title>
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

    <style>
        .message-table {
            width: 100%;
            text-align: left;
        }
        .message-table tbody tr:hover {
            background-color: #f2f2f2; /* 鼠标悬浮时的背景颜色 */
        }
        .message-time {
            color: #999;
            font-size: 12px;
            white-space: nowrap; /* 防止时间文字换行 */
        }
    </style>
</head>
<body>

<div class="layui-tab layui-tab-brief">
    <ul class="layui-tab-title">
        <li class="layui-this">通知</li>
        <li>已读</li>
        <li>待办</li>

    </ul>
    <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
<%--            内容-1--%>
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-xs12">
                <table class="layui-table message-table">
                    <thead>
                    <tr>
                        <th>消息内容</th>
                        <th>时间</th>
                    </tr>
                    </thead>
                    <tbody id="messagesContainer">
                    <!-- 消息列表项将通过JavaScript动态添加 -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>

        </div>

        <div class="layui-tab-item">
            已读
        </div>
        <div class="layui-tab-item">
            代办
        </div>
    </div>
</div>




<script src="//unpkg.com/layui@2.9.14/dist/layui.js"></script>
<script>
    layui.use(['form', 'laydate','table'], function(){
        const $ = layui.$;

        var messages;
        $.ajax({
            url:"/purchase?action=getMsg",
            type:"post",
            success:function (data){
                let parse = JSON.parse(data);
                if(parse.status === 200){
                    messages = parse.data;
                }

            }
        })
        var messagesContainer = document.getElementById('messagesContainer');


        var rowsHTML = messages.map(function(message, index) {
            return '<tr>' +
                '<td><i class="layui-icon layui-icon-email"></i>您有一条 ' + message.title + '</td>' +
                '<td class="message-time">' + message.time + '</td>' +
                '</tr>';
        }).join('');

        messagesContainer.innerHTML = rowsHTML;
    });
</script>

</body>
</html>
