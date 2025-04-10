<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String path = request.getContextPath();
%>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">
    <title>分布表单</title>
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
                    <div>

                        <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 60px;">
                            <div class="layui-form-item">
                                <label class="layui-form-label">付款账户:</label>
                                <div class="layui-input-block">
                                    <select lay-verify="required">
                                        <option value="easyweb@foxmail.com">easyweb@foxmail.com</option>
                                    </select>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">收款账户:</label>
                                <div class="layui-input-block">
                                    <input type="email" value="test@example.com" placeholder="请输入收款账户"
                                           class="layui-input"
                                           lay-verify="required" required>
                                </div>
                            </div>
                            <div class="layui-form-item layui-form-text">
                                <label class="layui-form-label">收款人姓名:</label>
                                <div class="layui-input-block">
                                    <input type="text" placeholder="请输入收款人姓名" value="Alex" class="layui-input"
                                           lay-verify="required" required/>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">转账金额:</label>
                                <div class="layui-input-block">
                                    <input type="number" placeholder="请输入金额" value="11" class="layui-input"
                                           lay-verify="required"
                                           required>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button class="layui-btn" lay-submit lay-filter="formDemo">&emsp;下一步&emsp;
                                    </button>
                                </div>
                            </div>
                        </form>

                    </div>
                    <div>

                        <form class="layui-form" style="margin: 0 auto;max-width: 460px;padding-top: 60px;">
                            <div class="layui-form-item">
                                <label class="layui-form-label">付款账户:</label>
                                <div class="layui-input-block">
                                    <div class="layui-form-mid layui-word-aux">ant-design@alipay.com</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">收款账户:</label>
                                <div class="layui-input-block">
                                    <div class="layui-form-mid layui-word-aux">test@example.com</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">收款人姓名:</label>
                                <div class="layui-input-block">
                                    <div class="layui-form-mid layui-word-aux">Alex</div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">转账金额:</label>
                                <div class="layui-input-block">
                                    <div class="layui-form-mid layui-word-aux">
                                        <span style="font-size: 18px;color: #333;">500</span>（人民币伍佰元整）
                                    </div>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label class="layui-form-label">支付密码:</label>
                                <div class="layui-input-block">
                                    <input type="password" placeholder="请输入支付密码" value="123456"
                                           class="layui-input"
                                           lay-verify="required"
                                           required>
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <div class="layui-input-block">
                                    <button type="button" class="layui-btn layui-btn-primary pre">上一步</button>
                                    <button class="layui-btn" lay-submit lay-filter="formDemo2">&emsp;提交&emsp;
                                    </button>
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
                            <div style="font-size: 14px;color: #666;margin-top: 20px;">预计两小时到账</div>
                        </div>

                        <div style="text-align: center;margin-top: 50px;">
                            <button class="layui-btn next">再转一笔</button>
                            <button class="layui-btn layui-btn-primary">查看账单</button>
                        </div>

                    </div>
                </div>
            </div>

            <hr>

            <div style="color: #666;margin-top: 30px;margin-bottom: 40px;padding-left: 30px;">
                <h3>说明</h3><br>
                <h4>转账到支付宝账户</h4>
                <p>如果需要，这里可以放一些关于产品的常见问题说明。如果需要，这里可以放一些关于产品的常见问题说明。如果需要，这里可以放一些关于产品的常见问题说明。</p>
                <br><h4>转账到银行卡</h4>
                <p>如果需要，这里可以放一些关于产品的常见问题说明。如果需要，这里可以放一些关于产品的常见问题说明。如果需要，这里可以放一些关于产品的常见问题说明。</p>
            </div>
        </div>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>

<script>
    layui.use(['layer', 'form', 'step'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        var step = layui.step;

        step.render({
            elem: '#stepForm',
            filter: 'stepForm',
            width: '100%', //设置容器宽度
            stepWidth: '750px',
            height: '500px',
            stepItems: [{
                title: '填写转账信息'
            }, {
                title: '确认转账信息'
            }, {
                title: '完成'
            }]
        });

        form.on('submit(formDemo)', function (data) {
            step.next('#stepForm');
            return false;
        });

        form.on('submit(formDemo2)', function (data) {
            step.next('#stepForm');
            return false;
        });

        $('.pre').click(function () {
            step.pre('#stepForm');
        });

        $('.next').click(function () {
            step.next('#stepForm');
        });
    });
</script>
</body>

</html>