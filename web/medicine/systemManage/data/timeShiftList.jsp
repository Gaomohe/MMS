<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>数据备份与恢复</title>
    <link rel="stylesheet" href="https://www.layuicdn.com/layui-v2.6.8/css/layui.css">
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-md6 layui-col-md-offset3">
            <button id="backup" class="layui-btn layui-btn-normal">数据备份</button>
            <button id="restore" class="layui-btn layui-btn-warm">数据恢复</button>
        </div>
    </div>
</div>
<script src="https://www.layuicdn.com/layui-v2.6.8/layui.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function(){
        $('#backup').click(function(){
            $.ajax({
                url: '/backup',
                type: 'POST',
                success: function(response){
                    alert('备份成功');
                },
                error: function(){
                    alert('备份失败');
                }
            });
        });

        $('#restore').click(function(){
            $.ajax({
                url: '/restore',
                type: 'POST',
                success: function(response){
                    alert('恢复成功');
                },
                error: function(){
                    alert('恢复失败');
                }
            });
        });
    });
</script>
</body>
</html>
