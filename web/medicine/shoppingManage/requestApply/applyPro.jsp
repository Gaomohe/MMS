<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">
    <title>测试</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314"/>
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .layui-form-item {
            margin-bottom: 25px;
        }

        @media screen and (max-width: 1060px) {
            .lay-step {
                padding-left: 50px !important;
            }
        }
        .layui-btn {
            position: relative; /* 确保按钮是相对于正常文档流定位 */
            z-index: 1000; /* 给按钮一个较高的 z-index 值 */
        }

        /* 如果有其他元素遮盖了按钮，可以检查并调整这些元素的 z-index */
        .other-elements {
            position: relative;
            z-index: 1; /* 根据需要调整 z-index 值 */
        }

        /* 如果需要，给按钮的父元素设置 overflow 属性 */
        .layui-form-item {
            overflow: visible; /* 确保父元素不会限制子元素的显示 */
        }
        .table-container {
            width: 100%; /* 根据需要设置宽度 */
            height: 300px; /* 设置一个固定的高度，根据需要调整 */
            overflow: auto; /* 当内容超出时显示滚动条 */
        }
        .table-container-two {
            width: 100%; /* 根据需要设置宽度 */
            height: 140px; /* 设置一个固定的高度，根据需要调整 */
            overflow: auto; /* 当内容超出时显示滚动条 */
        }

        .layui-table {
            width: 100%; /* 表格宽度设置为100% */
            border-collapse: collapse; /* 确保表格边框合并 */
        }

        /* 如果需要，可以为表格的单元格添加一些基本样式 */
        .layui-table th, .layui-table td {
            padding: 8px;
            border: 1px solid #ddd; /* 单元格边框 */
            text-align: left; /* 文本对齐 */
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
    <div class="layui-card">
        <div class="layui-card-body" style="padding-top: 40px;">

            <div class="layui-carousel" id="stepForm" lay-filter="stepForm" style="margin: 0 auto;">
                <div carousel-item>
                    <div id="step01">

                        <form class="layui-form layui-form-pane" action="Javascript:void(0)">
                            <div class="table-container">
                            <table class="layui-table" id="tableTbBas" lay-filter="tableTbBas"></table>
                            </div>
<%--                            <div style="display: flex; justify-content: center;">--%>
<%--                                <button class="layui-btn" style="width: 200px;" id="tijiao" lay-filter="add">申请</button>--%>
<%--                            </div>--%>

                            <div style="display: flex;margin-top: 50px; justify-content: center;" class="layui-form-item">
                                <div class="layui-input-block">
                                    <button id="return" class="layui-btn layui-btn-primary layui-border">&emsp;取消&emsp;</button>
                                    <button class="layui-btn" lay-submit lay-filter="formDemo">&emsp;下一步&emsp;</button>
                                </div>
                            </div>
                        </form>




                    </div>
                    <div id="step02">



                        <div class="layui-form-item">
                            <label class="layui-form-label">申请人:</label>
                            <div class="layui-input-block">
                                <div class="layui-form-mid layui-word-aux">${name9}</div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label class="layui-form-label">申请类型:</label>
                            <div class="layui-input-block">
                                <div class="layui-form-mid layui-word-aux">药品</div>
                            </div>
                        </div>
                        <form class="layui-form" style="margin: 0 auto;max-width: 550px;padding-top: 60px;height: auto">
                            <div class="table-container-two">
                            <table style="height: auto"  class="layui-table" id="tableTrue" lay-filter="tableTrue"></table>
                            </div>
                                <br>
                            <div class="layui-form-item">
                                <label class="layui-form-label">总金额:</label>
                                <div class="layui-input-block">
                                    <div class="layui-form-mid layui-word-aux">
                                        <span id="total" style="font-size: 18px;color: #333;"></span>（￥人民币）
                                    </div>
                                </div>
                            </div>

                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button type="button" class="layui-btn layui-btn-primary pre">上一步</button>
                                    <button class="layui-btn" id="tijiao" lay-submit lay-filter="formDemo2">&emsp;提交&emsp;</button>
                                </div>
                            </div>
                        </form>



                    </div>
                    <div>

                        <div style="text-align: center;margin-top: 90px;">
                            <i class="layui-icon layui-circle"
                               style="color: white;font-size:30px;font-weight:bold;background: #52C41A;padding: 20px;line-height: 80px;">&#xe605;</i>
                            <div style="font-size: 24px;color: #333;font-weight: 500;margin-top: 30px;">操作成功
                            </div>
                            <div style="font-size: 14px;color: #666;margin-top: 20px;">正在等待审批</div>
                        </div>

                        <div style="text-align: center;margin-top: 50px;">
                            <button class="layui-btn next">继续申请</button>
                            <button id="checkCP" class="layui-btn layui-btn-primary">查看审批</button>
                        </div>

                    </div>
                </div>
            </div>

            <hr>

            <div id="textT" style="color: #666;margin-bottom: 40px;padding-left: 30px;">
                <h3>说明</h3><br>
                <h4>药品申请数量</h4>
                <p>关于药品的申请数量，用户选择最小值是0,即不能输入负数作为申请数量,负数在实际应用中没有意义。且输入的药品申请数量不能超过100,由于库存限制、订单处理能力和其他业务规则。用户在系统中输入的申请数量必须是一个不超过100的数字。</p>
                <br><h4>申请准则</h4>
                <p>所有药品申请活动遵循相关法律法规，包括但不限于药品管理法、医疗保健法规和公司政策。</p>
                <p>药品申请应基于患者的实际医疗需要，由具有相应资质的医疗专业人员根据患者的病情进行评估和处方。</p>
                <p>避免不必要的药品申请，确保药品的合理使用，避免药物滥用和依赖。</p>
            </div>
        </div>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script type="text/javascript" src="../../../admin/lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="../../../medicinejs/shoppingManagejs/requestApply/applyList.js"></script>

<script>
    layui.use(['layer', 'form', 'step','table'], function () {
        var $ = layui.jquery;
        var layer = parent.layer === undefined ? layui.layer : top.layer;
        var form = layui.form;
        var step = layui.step;
        var table = layui.table;

        step.render({
            elem: '#stepForm',
            filter: 'stepForm',
            width: '100%', //设置容器宽度
            stepWidth: '750px',
            height: '500px',
            stepItems: [{
                title: '填写申请数量'
            }, {
                title: '确认申请信息'
            }, {
                title: '完成'
            }]
        });

        form.on('submit(formDemo)', function (data) {
            var myData = datas.data;
            var tatol=0;
            var count = 0.0;
            $('tbody').first().find('tr').each(function() {
                var tr = this;
                var inputElement = $(tr).find('td').eq(4).find('input');
                var inputValue = $(tr).find('td').eq(5).find('input');
                let number01 = parseFloat(myData[count].purchasePrice);
                let number02 = parseInt(inputElement.val(),10);
                tatol+=number01*number02;
                myData[count].recordNumber=inputElement.val();
                myData[count].specification=inputValue.val();
                count++;
            });
            var totalElement = document.getElementById('total');
            // 设置元素的文本内容
            totalElement.textContent = tatol.toFixed(2);


            step.next('#stepForm');

            tableMy(myData);
            return false;
        });
        function tableMy(myData){
           var myTables = table.render({
                elem: '#tableTrue',
                data: myData,
                page: false,
                cellMinWidth: 100,
                cols: [[
                    {type: 'checkbox',hide:true},
                    {field: 'tableCoding', align: 'center', sort: true, title: '编号'},
                    {field: 'mName', align: 'center', title: '药品名称'},
                    {field: 'number', align: 'center', sort: true, title: '药品库存'},
                    {field: 'recordNumber',
                        align: 'center',
                        title: '申请数量'
                    },
                    {field: 'specification',
                        align: 'center',
                        title: '备注'
                    },

                ]],
                done:function (){
                }
            });
        }
        form.on('submit(formDemo2)', function (data) {
            step.next('#stepForm');
            tijiao();
            return false;
        });

        $('.pre').click(function () {

            step.pre('#stepForm');
        });

        $('.next').click(function () {
            step.next('#stepForm');
        });
        $('#return').click(function (){
            console.log("取消")
            setTimeout(function(){
                layer.closeAll("iframe");
                layer.msg("未申请！")
                //刷新父页面
                parent.location.reload();

            },1);

        })
        $('#checkCP').click(function (){
            parent.layer.close(parent.layer.getFrameIndex(window.name));

        })
        function history(){
            layui.layer.open({
                title : "历史记录",
                type : 2,
                content : "medicine/shoppingManage/requestApply/history.jsp",
                area:['600px','500px'],
                success:function(layero, index){
                    $.ajax({
                        url:"/approval?action=getHistory",//湖区历史记录
                        type:"post",
                        data:{},
                        success:function(data){
                            var parse = JSON.parse(data).data;
                            var iframe = layer.getChildFrame('body', index);
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
                            $(iframe).find('.layui-timeline').html(html);

                        }
                    })
                }
            });
        }
    });
</script>
</body>

</html>