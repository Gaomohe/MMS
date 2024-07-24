
layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var mId = $("#mId").val();
        var mName = $("#mName").val();
        var specification = $("#specification").val();
        var manufactor = $("#manufactor").val();
        var unit = $("#unit").val();
        var department = $("#department").val();
        var position = $("#position").val();
        var number = $("#number").val();
        var batchNumber = $("#batchNumber").val();
        var usefulLife = $("#usefulLife").val();
        var purchasePrice = $("#purchasePrice").val();
        var salePrice = $("#salePrice").val();
        var productDate = $("#productDate").val();
        var profits = $("#profits").val();
        var code = $("#code").val();
        var goodsType = $("#goodsType").val();
        var mType = $("#mType").val();
        var defined = $("#defined").val();
        var supplier = $("#supplier").val();
        var warehousingDate = $("#warehousingDate").val();
        var locationDescription = $("#locationDescription").val();
        var sign = $("#sign").val();
        var warehousingRemarks = $("#warehousingRemarks").val();
        var drugFrom = $("#drugFrom").val();
        // var handlingInformation = $("#handlingInformation").val();
        var approvalNumber = $("#approvalNumber").val();
        var LastCuringDate = $("#LastCuringDate").val();
        var timesStorage = $("#timesStorage").val();
        var documentNumber = $("#documentNumber").val();
        var placeOrigin = $("#placeOrigin").val();
        var batchsNumber = $("#batchsNumber").val();
        var recordNumber = $("#recordNumber").val();
        var tableCoding = $("#tableCoding").val();
        console.log(department)
        if(mName.length == "" ){
            layer.msg("药品名称不能为空")
            return false;
        }
        $.ajax({
            url:"/StockAllForm?action=updateStockAllForm",
            data:{
                "mId": mId,
                "mName": mName,
                "specification": specification,
                "manufactor": manufactor,
                "unit": unit,
                "number": number,
                "purchasePrice": purchasePrice,
                "salePrice": salePrice,
                "batchNumber": batchNumber,
                "productDate": productDate,
                "usefulLife": usefulLife,
                "warehousingDate": warehousingDate,
                "department": department,
                "warehousingRemarks": warehousingRemarks,
                "profits": profits,
                "code": code,
                "goodsType": goodsType,
                "mType": mType,
                "defined": defined,
                "supplier": supplier,
                "position": position,
                "locationDescription": locationDescription,
                "sign": sign,
                "drugFrom": drugFrom,
                // "handingInformation": handingInformation,
                "approvalNumber": approvalNumber,
                "LastCuringDate": LastCuringDate,
                "timesStorage": timesStorage,
                "documentNumber": documentNumber,
                "placeOrigin": placeOrigin,
                "batchsNumber": batchsNumber,
                "recordNumber": recordNumber,
                "tableCoding":tableCoding
            },
            type:"post",
            success:function(data){
                var info  = JSON.parse(data)
                console.log(info)
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
