layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    $("#tijiao").click(function(){

        var id = $("#id").val();
        var name = $("#name").val();
        var number = $("#number").val();
        var purchasePrice = $("#purchasePrice").val();
        if(name.length === "" ){
            layer.msg("名称不能为空")
            return false;
        }
        $.ajax({
            url:"/shopping?action=add",
            data:{
                id,number,name,purchasePrice
            },
            type:"post",
            success:function(data){
                var info = JSON.parse(data);
                if(info.status === 200){
                    layer.msg("添加成功")
                    setTimeout(function(){
                        layer.closeAll("iframe");
                        //刷新父页面
                        parent.location.reload();
                    },1000);
                }else{
                    layer.msg("系统异常");
                }
            }
        })
        return false;
    })

})

