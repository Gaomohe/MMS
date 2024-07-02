<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= path %>/iframe/assets/images/favicon.ico" rel="icon">
    <title>登录</title>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= path %>/iframe/assets/css/login.css?v=314">
    <link rel="stylesheet" href="<%= path %>/iframe/assets/module/admin.css?v=314">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="login-wrapper">
    <div class="login-header">
        <img src="<%= path %>/iframe/assets/images/logo.png"> 欢迎登录医药管理系统
    </div>
    <div class="login-body">
        <div class="layui-card">
            <div class="layui-card-header">
                <i class="layui-icon layui-icon-engine"></i>&nbsp;&nbsp;用户登录
            </div>
            <form class="layui-card-body layui-form layui-form-pane">
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-username"></i></label>
                    <div class="layui-input-block">
                        <input name="id" type="text" placeholder="账号" class="layui-input"
                               lay-verType="tips" lay-verify="required" required/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
                    <div class="layui-input-block">
                        <input name="password" type="password" placeholder="密码" class="layui-input"
                               lay-verType="tips" lay-verify="required" required/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-vercode"></i></label>
                    <div class="layui-input-block">
                        <div class="layui-row inline-block">
                            <div class="layui-col-xs7">
                                <input name="code" type="text" placeholder="验证码" class="layui-input"
                                       autocomplete="off" lay-verType="tips" lay-verify="required" required/>
                            </div>
                            <div class="layui-col-xs5" style="padding-left: 6px;">
                                <img class="login-captcha" src="https://www.oschina.net/action/user/captcha">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <a href="javascript:;" class="layui-link">帐号注册</a>
                    <a href="javascript:;" class="layui-link pull-right">忘记密码？</a>
                </div>
                <div class="layui-form-item">
                    <button lay-filter="login-submit" class="layui-btn layui-btn-fluid" lay-submit>登 录</button>
                </div>
            </form>
        </div>
    </div>

    <div class="login-footer">
        <p>© 2019 easyweb.vip 版权所有</p>
        <p>
            <span><a href="https://easyweb.vip" target="_blank">获取授权</a></span>
            <span><a href="https://easyweb.vip/doc/" target="_blank">开发文档</a></span>
            <span><a href="https://demo.easyweb.vip/spa/" target="_blank">单页面版</a></span>
        </p>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= path %>/iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= path %>/iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;
        // 表单提交
        form.on('submit(login-submit)', function (obj) {
                obj = obj.field;
                console.log(obj.field);
                $.ajax({
                    url: "/user?action=Login",
                    type: "post",
                    data: {
                        id: obj.id,
                        password: obj.password,
                        code:obj.code
                    },
                    dataType: "json",
                    success: function (data) {
                        var info = JSON.parse(data);
                        console.log(info.status);
                        console.log("aaaaaaa");
                        console.log(data.status);
                        if (data.status == 200) {
                            layer.msg('登录成功', {icon: 1, time: 1500}, function () {
                                // location.replace('/iframe/index.jsp');
                                window.location = '/iframe/index.jsp';
                            });
                        } else {
                            layer.msg('登录失败', {icon: 2, time: 1500}, data.msg);
                            $('.login-captcha').click();
                        }
                    }
                })
            });
        // 图形验证码
        /*$('.login-captcha').click(function () {
            this.src = this.src + '?t=' + (new Date).getTime();
        });*/
        $('.login-captcha').click(function () {
            this.src = this.src.split('?')[0] + '?t=' + (new Date).getTime();
        });

    });
</script>
</body>
</html>--%>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<%= basePath %>iframe/assets/images/favicon.ico" rel="icon">
    <title>登录</title>
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/libs/layui/css/layui.css"/>
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/css/login.css?v=314">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/module/admin.css?v=314">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        /* 这里可以添加一些优化后的CSS样式 */
        .login-wrapper { /* ... */ }
        .login-header { /* ... */ }
        .login-body { /* ... */ }
        .login-footer { /* ... */ }
        .login-captcha { cursor: pointer; }
    </style>
</head>
<script>
    function createCode() {

        code = "";
        var codeLength = 4; // 验证码的长度
        var checkCode = document.getElementById("code");
        var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
            'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); // 随机数
        for (var i = 0; i < codeLength; i++) { // 循环操作
            var index = Math.floor(Math.random() * 36); // 取得随机数的索引（0~35）
            code += random[index]; // 根据索引取得随机数加到code上
        }
        checkCode.value = code; // 把code值赋给验证码
    }




    function validate() {
        var inputCode = document.getElementById("input").value.toUpperCase(); // 取得输入的验证码并转化为大写
        var inputCod = document.getElementById("input");
        if (inputCode.length <= 0) { // 若输入的验证码长度为0
            return false;
        } else if (inputCode != code) { // 若输入的验证码与产生的验证码不一致时
            mizhu.alert("输入提示", "验证码输入错误！"); // 则弹出验证码输入错误
            createCode(); // 刷新验证码
            alert("验证码输入错误，重新写入")
            return false;
        }
        return true;
    }
</script>
<body>
<div class="login-wrapper">
    <div class="login-header">
        <img src="<%= basePath %>iframe/assets/images/logo.png"> 欢迎登录医药管理系统
    </div>
    <div class="login-body">
        <div class="layui-card">
            <div class="layui-card-header">
                <i class="layui-icon layui-icon-engine"></i>&nbsp;&nbsp;用户登录
            </div>
            <form class="layui-card-body layui-form layui-form-pane">
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-username"></i></label>
                    <div class="layui-input-block">
                        <input name="id" type="text" placeholder="账号" class="layui-input"
                               lay-verType="tips" lay-verify="required" required/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-password"></i></label>
                    <div class="layui-input-block">
                        <input name="password" type="password" placeholder="密码" class="layui-input"
                               lay-verType="tips" lay-verify="required" required/>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label"><i class="layui-icon layui-icon-vercode"></i></label>
                    <div class="layui-input-block">
                        <div class="layui-row inline-block">
                            <div class="layui-col-xs7">
                                <input type = "text" id = "input" style="width:180px;height:37px;border: 1px solid #cccccc;" placeholder="请输入验证码" lay-verify="required" required/>
                            </div>
                            <div class="layui-col-xs5" style="padding-left: 6px;">
                                <input type = "button" id="code" style="position:absolute;right:-95px;cursor:pointer;height:38px;width: 100px; border:1px solid #e6e6e6;" onclick="createCode()" required="required" value="点击获取验证码">
                            </div>

                        </div>
                </div>

                <div class="layui-form-item">
                    <a href="javascript:;" class="layui-link">帐号注册</a>
                    <a href="javascript:;" class="layui-link pull-right">忘记密码？</a>
                </div>
                <div class="layui-form-item">
                    <button lay-filter="login-submit" class="layui-btn layui-btn-fluid" lay-submit>登 录</button>
                </div>
                </div>
            </form>
        </div>
    </div>

    <div class="login-footer">
        <p>© 2019 easyweb.vip 版权所有</p>
        <p>
            <span><a href="https://easyweb.vip" target="_blank">获取授权</a></span>
            <span><a href="https://easyweb.vip/doc/" target="_blank">开发文档</a></span>
            <span><a href="https://demo.easyweb.vip/spa/" target="_blank">单页面版</a></span>
        </p>
    </div>
</div>

<!-- js部分 -->
<script type="text/javascript" src="<%= basePath %>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= basePath %>iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;

        // 表单提交
        form.on('submit(login-submit)', function (obj) {
            obj = obj.field;
            if (validate()) {
                if (obj.code == '') {
                    layer.msg('验证码不能为空');
                    return false;
                }
            }else {
                layer.msg('验证码输入错误，请重新输入',{icon: 1});
            }
            $.ajax({
                url: "<%= basePath %>user?action=Login",
                type: "post",
                data: {
                    id: obj.id,
                    password: obj.password,
                    code: obj.code
                },
                dataType: "json",
                success: function (data) {
                    if (data.status == 200) {
                        layer.msg('登录成功', {icon: 1, time: 1500}, function () {
                            window.location = '<%= basePath %>iframe/index.jsp';
                        });
                    } else {
                        layer.msg('登录失败', {icon: 2, time: 1500}, function() {
                            $('.login-captcha').click();
                        });
                    }
                }
            });
            return false; // 阻止表单跳转。如果需要表单跳转，去掉这句即可。
        });
    });
</script>
</body>
</html>
