layui.use(['form', 'layedit', 'laydate','jquery','cascader'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate
        ,$=layui.jquery
        ,cascader = layui.cascader;

    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var wId = $("#wId").val();
        var message = $("#contentTextarea").val();
        $.ajax({
            url:"/message?action=addMessageByWId",
            data:{
                wId,
                message
            },
            tyep:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("发布成功")
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

});
