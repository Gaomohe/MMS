layui.use(['layer', 'form', 'laydate'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var laydate = layui.laydate;
    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
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
        var handlingInformation = $("#handlingInformation").val();
        var approvalNumber = $("#approvalNumber").val();
        var LastCuringDate = $("#lastCuringDate").val();
        var timesStorage = $("#timesStorage").val();
        var documentNumber = $("#documentNumber").val();
        var placeOrigin = $("#placeOrigin").val();
        var batchsNumber = $("#batchsNumber").val();
        var recordNumber = $("#recordNumber").val();
        $.ajax({
            url:"/StockAllForm?action=addStockAllForm",
            data:{
                mName,
                specification,
                manufactor,
                unit,
                department,
                position,
                number,
                batchNumber,
                usefulLife,
                purchasePrice,
                salePrice,
                productDate,
                profits,
                code,
                goodsType,
                mType,
                defined,
                supplier,
                warehousingDate,
                locationDescription,
                sign,
                warehousingRemarks,
                drugFrom,
                handlingInformation,
                approvalNumber,
                LastCuringDate,
                timesStorage,
                documentNumber,
                placeOrigin,
                batchsNumber,
                recordNumber,
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

