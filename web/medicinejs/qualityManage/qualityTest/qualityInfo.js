layui.use(['form', 'layedit', 'laydate','jquery','cascader'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate
        ,$=layui.jquery
        ,cascader = layui.cascader;

    /*****************提交按钮事件***********************/

    $("#tijiao").click(function(){
        var id = $("#id").val();
        var usefulLife = $("#usefulLife").val();
        if(!isValidDateTime(usefulLife)){
            usefulLife +="00:00:00";
        }
        $.ajax({
            url:"/quality?action=upUsefulLife",
            data:{
                id,
                usefulLife
            },
            tyep:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("修改成功")
                    setTimeout(function(){
                        layer.closeAll("iframe");
                        parent.location.reload();
                    },1000);
                }else{
                    layer.msg("系统异常");
                }
            }
        })
        return false;
    })

    laydate.render({

        elem: '#usefulLife',

        type: 'datetime',

    });

    //正则表达式判断有效期格式
    function isValidDateTime(dateTime) {
        // 定义正则表达式
        // 这里的正则表达式假设年份为4位数字，月份和日期为1或2位数字，小时、分钟和秒为2位数字
        // 并且考虑到了月份和日期可能只有一位数字时前面会有0的情况
        var regex = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;

        // 使用正则表达式测试字符串
        return regex.test(dateTime);
    }

});

