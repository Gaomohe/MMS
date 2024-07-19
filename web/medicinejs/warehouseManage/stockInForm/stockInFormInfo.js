
layui.use(['form', 'layedit', 'laydate'], function(){
    console.log("dddd")
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var rId = $("#rId").val();
        var stockInNum = $("#stockInNum").val();
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
        var stockInTime = $("#stockInTime").val();
        var department = $("#department").val();
        var notes = $("#notes").val();
        console.log(department)
        if(rName.length == "" ){
            layer.msg("药品名称不能为空")
            return false;
        }
        console.log(rId)
        $.ajax({
            url:"/StockInForm?action=updateStockInForm",
            data:{
                "rId":rId,
                "stockInNum":stockInNum,
                "rName": rName,
                "standard": standard,
                "manufactor": manufactor,
                "unit": unit,
                "rNum": rNum,
                "cost": cost,
                "salePrice": salePrice,
                "batchNumber": batchNumber,
                "productDate": productDate,
                "expiration": expiration,
                "stockInTime":stockInTime,
                "department": department,
                "notes":notes
            },
            type:"post",
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

});
