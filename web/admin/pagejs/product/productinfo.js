layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    $("#xiugai").click(function(){
        var shopid = $("#shopid").val();
        var name = $("#name").val();
        var fileName = $("#fileName").val();
        var num = $("#num").val();
        var price = $("#price").val();
        var data = {
            "shopid":shopid,
            "num":num,
            "price":price
        }
        $.ajax({
            url:"/upproduct",
            data:data,
            tyep:"post",
            success:function(data){
                if(data == 1){
                    layer.msg("商品信息修改成功");
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