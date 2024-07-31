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
    <link href="//unpkg.com/layui@2.9.14/dist/css/layui.css" rel="stylesheet">
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
                        <th>通知</th>
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
<%--            已读--%>
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-xs12">
                <table class="layui-table message-table">
                    <thead>
                    <tr>
                        <th>已读</th>
                    </tr>
                    </thead>
                    <tbody id="messagesContainerRead">
                    <!-- 消息列表项将通过JavaScript动态添加 -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
        </div>
        <div class="layui-tab-item">
<%--            代办--%>
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-xs12">
                <table class="layui-table message-table">
                    <thead>
                    <tr>
                        <th>待办</th>
                    </tr>
                    </thead>
                    <tbody id="messagesContainerToDo">
                    <!-- 消息列表项将通过JavaScript动态添加 -->
                    </tbody>
                </table>
            </div>
        </div>
    </div>
        </div>
    </div>
</div>




<script src="//unpkg.com/layui@2.9.14/dist/layui.js"></script>
<script>
    layui.extend({
        dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
    }).use(['form','layer','laydate','table','upload','element', 'jquery'],function(){
        const $ = layui.$;
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        $.ajax({
            url:"/purchase?action=getMsg",
            type:"post",
            success:function (data){
                let parse = JSON.parse(data);
                if(parse.status === 200){
                    var messages = parse.data;
                    console.log(messages)
                    var msg = [];
                    var msgRead=[]
                    var count = 0;
                    var countRead = 0;
                    for (let i = 0; i < messages.length; i++) {
                        if (messages[i].state===0){
                            msg[count++]=messages[i]
                        }else {
                            msgRead[countRead++]=messages[i]
                        }
                    }

                    //通知
                    mymsg(msg);
                    if (msg.length!==0){
                        console.log("声明")
                        msgClick(msg);
                    }


                    //已读
                    mymsgRead(msgRead);
                    if (msgRead.length!==0){
                        msgClickRead(msgRead)
                    }

                    //待办
                    mymsgToDo(null);



                }

            }
        })


        //每行绑定点击事件
        function msgClick(messages){
            // 为每一行绑定点击事件
            messages.forEach(function(message, index) {
                var row = messagesContainer.children[index];
                row.addEventListener('click', function() {
                    // var url = 'http://localhost:8080/medicine/shoppingManage/requestApply/detailedMsg.jsp';
                    openMsg01(message)
                });

            });
        }
        function msgClickRead(messages){
            // 为每一行绑定点击事件
            messages.forEach(function(message, index) {
                var row = messagesContainerRead.children[index];
                row.addEventListener('click', function() {
                    // var url = 'http://localhost:8080/medicine/shoppingManage/requestApply/detailedMsg.jsp';
                    openMsg02(message)
                });

            });
        }
        function openMsg01(message){
            layer.confirm('时间:'+message.time+'<br>'+'申请人:'+message.receivePeople
                +'<br>'+'申请凭证号:'+message.batch_num+'<br>'+message.message, {
                btn: ['确定'] //按钮
            }, function(){
               var msg = message.batch_num;
                layer.msg('已确认!', {icon: 1});
                //修改状态
                $.ajax({
                    url:"/purchase?action=setMsgState",//根据id查询的方法
                    type:"post",
                    data:{msg},
                    success:function(data){
                        var parse = JSON.parse(data);
                        if (parse.status === 200){
                            location.reload();
                        }
                    }
                })

            });
        }
        function openMsg02(message){
            layer.confirm('时间:'+message.time+'<br>'+'申请人:'+message.receivePeople
                +'<br>'+'申请凭证号:'+message.batch_num+'<br>'+message.message, {
                btn: ['确定'] //按钮
            }, function(){
                var msg = message.batch_num;
                layer.msg('已确认!', {icon: 1});
            });
        }

        //添加行
        function mymsg(messages){
            //通知
            var messagesContainer = document.getElementById('messagesContainer');

            var rowsHTML
            if (messages.length===0){
                rowsHTML = '<tr>' +
                    '<td>暂无更多的消息！</td>' +
                    '</tr>';
            }else {
                rowsHTML = messages.map(function(message, index) {
                    return '<tr>' +
                        '<td><i class="layui-icon layui-icon-email"></i>您有一条 ' + message.title + '<br><p class="message-time">' + message.time + '</p></td>' +
                        '</tr>';
                }).join('');
            }
            messagesContainer.innerHTML = rowsHTML;
        }
        function mymsgRead(messages){
            //通知
            var messagesContainerRead = document.getElementById('messagesContainerRead');
            var rowsHTML
            if (messages.length===0){
                rowsHTML = '<tr>' +
                    '<td>暂无更多的消息！</td>' +
                    '</tr>';
            }else {
                rowsHTML = messages.map(function(message, index) {
                    return '<tr>' +
                        '<td><i class="layui-icon layui-icon-email"></i>' + message.title + '  &nbsp; &nbsp;已读<br><p class="message-time">' + message.time + '</p></td>' +
                        '</tr>';
                }).join('');
            }
            messagesContainerRead.innerHTML = rowsHTML;
        }
        function mymsgToDo(messages){
            var messagesContainerToDo = document.getElementById('messagesContainerToDo');
            messagesContainerToDo.innerHTML = '<tr>' +
                '<td>暂无更多的消息！</td>' +
                '</tr>';
        }

    });
</script>

</body>
</html>
