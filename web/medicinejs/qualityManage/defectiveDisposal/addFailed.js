layui.use(['form', 'layedit', 'laydate','jquery','cascader'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate
        ,$=layui.jquery
        ,cascader = layui.cascader;

    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var tableCoding = $("#id").val();
        var id = $("#id1").val();
        var cause = $('#contentTextarea').val();
        $.ajax({
            url:"/applyFailed?action=addFailed",
            data:{
                tableCoding,
                id,
                cause
            },
            tyep:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("操作成功")
                    setTimeout(function(){
                        delFunc(id);
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

    function delFunc(id){
        $.ajax({
            url:"/quality?action=delQuality",
            data:{
                id
            },
            type:"POST",
            dataType:"JSON",
            success: function(date) {
                var info = JSON.parse(date);
                if (info.status == 200){
                    return 1;
                }
            },
            error: function(error) {
                console.error('Error:', error);
            }
        })
    }

});
