<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-10
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<link rel="stylesheet" href="<%=basePath %>admin/lib/layui-v2.5.5/css/layui.css" media="all" />
<link rel="stylesheet" href="<%=basePath %>admin/css/public.css" media="all" />
<link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/dtree.css">
<link rel="stylesheet" href="<%=basePath %>admin/js/lay-module/layui_ext/dtree/font/dtreefont.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="layui-timeline">



</div>


<script type="text/javascript" src="<%=basePath %>iframe/assets/libs/layui/layui.js" charset="utf-8"></script>
<%--<script type="text/javascript" src="<%=basePath %>medicinejs/shoppingManagejs/requestApply/shopList.js" charset="utf-8"></script>--%>
<script>
    layui.use(['form', 'layedit', 'laydate','table'], function(){
        var $ = layui.$;
        let parse;
        window.addEventListener('message', function(event) {
            var messageData = event.data;
            parse = JSON.parse(messageData).data;
            insert(parse);
        }, false);
        function insert(parse){
            var timeline = document.querySelector('.layui-timeline');
            var html = '';
            var insert = '';
            var count = 0;
            for (let j = 0; j < parse.length; j++) {
                insert = '<p>药品编号:'+parse[j].mId+'药品名称:'+parse[j].mName+'申请数量:'+parse[j].applyNumber+'状态:'+parse[j].pharmacistApprove+'</p>';
                for (let k = j+1; k < parse.length; k++) {
                    if (parse[j].applyTime===parse[k].applyTime){
                        insert += '<p>药品编号:'+parse[k].mId+'药品名称:'+parse[k].mName+'申请数量:'+parse[k].applyNumber+'状态:'+parse[k].pharmacistApprove+'</p>'
                    }else {
                        j = k - 1;
                        html+= '<div class="layui-timeline-item">\n' +
                            '    <i class="layui-icon layui-timeline-axis"></i>\n' +
                            '    <div class="layui-timeline-content layui-text">\n' +
                            '      <h3 class="layui-timeline-title">申请时间:'+parse[j].applyTime+'</h3>\n' +
                            '      <p></p>\n' +insert+
                            '    </div>\n' +
                            '  </div>';
                        count++;
                        break;
                    }
                }
                if (count===10){
                    //控制条数
                    break;
                }
            }
            timeline.innerHTML += html;
        }

    })

</script>
</body>
</html>
