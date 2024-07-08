layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var rName = $("#rName").val();
        var standard = $("#standard").val();
        var manufactor = $("#manufactor").val();
        var unit = $("#unit").val();
        var rNum = $("#rNum").val();
        var cost = $("#cost").val();
        var salePrice = $("#salePrice").val();
        var batchNumber = $("#batchNumber").val();
        var productDate = $("#productDate").val();
        var expiration = $("#expiration").val();
        var department = $("#department").val();
        if(rName.length == "" ){
            layer.msg("入库药品名称不能为空")
            return false;
        }
        $.ajax({
            url:"/StockInForm?action=addStockInForm",
            data:{
                "rName": rName,
                "standard":standard,
                "manufactor": manufactor,
                "unit": unit,
                "rNum": rNum,
                "cost":cost,
                "salePrice": salePrice,
                "batchNumber": batchNumber,
                "productDate": productDate,
                "expiration": expiration,
                "department": department,
            },
            type:"post",
            success:function(data){
                console.log(data)
                var info = JSON.parse(data);
                if(info.status == 200){
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

});

