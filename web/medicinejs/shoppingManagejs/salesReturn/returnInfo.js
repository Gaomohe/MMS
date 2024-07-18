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
        var demoCascader11 = $("#demoCascader11").val();
        console.log(demoCascader11);
        var address = $("#address").val();
        var shippingWay = $("#shippingWay").val();
        var consigner = $("#consigner").val();

        demoCascader11 +="/"+address
        $.ajax({
            url:"/returnSal?action=updateAll",
            data:{
                id,
                address:demoCascader11,
                shippingWay,
                consigner
            },
            tyep:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("修改成功")
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

    cascader.render({
        elem: '#demoCascader11',
        data: citysData,
        itemHeight: '250px',
        filterable: false
    });

});
