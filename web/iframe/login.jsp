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
    <link rel="shortcut icon" href="<%= basePath %>iframe/assets/images/favicon.ico" />
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/css/backend-plugin.min.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/css/backend.css?v=1.0.0">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
    <link rel="stylesheet" href="<%= basePath %>iframe/assets/vendor/remixicon/fonts/remixicon.css">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <![endif]-->
    <!-- Backend Bundle JavaScript -->

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
    <div id="loading">
        <div id="loading-center">
        </div>
    </div>
    <div class="wrapper">
        <section class="login-content">
            <div class="container">
                <div class="row align-items-center justify-content-center height-self-center">
                    <div class="col-lg-8">
                        <div class="card auth-card">
                            <div class="card-body p-0">
                                <div class="d-flex align-items-center auth-content">
                                    <form class="layui-card-body layui-form layui-form-pane">
                                    <div class="col-lg-7 align-self-center">
                                        <div class="p-3">
                                            <h2 class="mb-2">欢迎登录</h2>
                                            <p>Login to stay connected.</p>
                                            <form>
                                                <div class="row">
                                                    <div class="col-lg-12">
                                                        <div class="floating-label form-group" style="width: 160%">
                                                            <input class="floating-input form-control" type="text" name="id" placeholder=" ">
                                                            <label style="padding: 0px 5px">账号</label>
                                                        </div>
                                                    </div>
                                                    <div class="col-lg-12">
                                                        <div class="floating-label form-group" style="width: 160%">
                                                            <input class="floating-input form-control" type="password" name="password" placeholder=" ">
                                                            <label style="padding: 0px 5px">密码</label>
                                                        </div>
                                                    </div>

                                                    <div class="col-lg-12">
                                                        <div class="layui-row inline-block">
                                                            <div class="layui-col-xs7" style="width: 70%;border-top-left-radius:50px;border-bottom-left-radius:50px;" >
                                                                <input type = "text" id = "input" style="width:150px;height:37px;border: 1px solid #cccccc;" placeholder="请输入验证码" lay-verify="required" required/>
                                                            </div>
                                                            <div class="layui-col-xs5" style="padding-left: 6px;width: 30%">
                                                                <input type = "button" id="code" name="code" style="position:absolute;right:-120px;cursor:pointer;height:38px;width: 125px; border:1px solid #E9F0FE;" onclick="createCode()" required="required" value="点击获取验证码">
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <button type="submit" class="btn btn-primary" lay-filter="login-submit" lay-submit>登录</button>
                                            </form>
                                        </div>
                                    </div>
                                    </form>
                                    <div class="col-lg-5 content-right">
                                        <img src="<%= basePath %>iframe/assets/images/login/01.png" class="img-fluid image-right" alt="">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>

<script src="<%= basePath %>iframe/assets/js/backend-bundle.min.js"></script>
<script src="<%= basePath %>iframe/assets/js/table-treeview.js"></script>
<script src="<%= basePath %>iframe/assets/js/customizer.js"></script>
<script async src="<%= basePath %>iframe/assets/js/chart-custom.js"></script>
<script src="<%= basePath %>iframe/assets/js/app.js"></script>
<script type="text/javascript" src="<%= basePath %>iframe/assets/libs/layui/layui.js"></script>
<script type="text/javascript" src="<%= basePath %>iframe/assets/js/common.js?v=314"></script>
<script>
    layui.use(['layer', 'form'], function () {
        var $ = layui.jquery;
        var layer = layui.layer;
        var form = layui.form;

        // 表单提交
        form.on('submit(login-submit)', function (obj) {
            console.log("aaaaaaaaaaaaaaaa");
            obj = obj.field;
            console.log(obj.id);
            console.log(obj.password);
            console.log(obj.code);
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
