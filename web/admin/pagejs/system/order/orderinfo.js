layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    $("#xiugai").click(function(){
        var orderid = $("#orderid").val();
        var address = $("#address").val();
        var data = {
            "orderid":orderid,
            "address":address,
        }
        $.ajax({
            url:"/uporder",
            data:data,
            tyep:"post",
            success:function(data){
                if(data == 1){
                    layer.msg("订单信息修改成功");
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

});