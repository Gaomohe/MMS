layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var mid = $("#mId").val();
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
        var goodsType = $("#select1").val();
        var mType = $("#select2").val();
        var defined = $("#select3").val();
        var supplier = $("#supplier").val();
        var warehousingDate = $("#warehousingDate").val();
        var locationDescription = $("#locationDescription").val();
        var sign = $("#sign").val();
        var warehousingRemarks = $("#warehousingRemarks").val();
        var drugFrom = $("#select4").val();
        var handlingInformation = $("#handlingInformation").val();
        var approvalNumber = $("#approvalNumber").val();
        var LastCuringDate = $(".ManageTime").val();
        var timesStorage = $("#timesStorage").val();
        var documentNumber = $("#documentNumber").val();
        var placeOrigin = $("#placeOrigin").val();
        var batchsNumber = $("#batchsNumber").val();
        var recordNumber = $("#recordNumber").val();
        $.ajax({
            url:"/medicine?action=addMedicine",
            data:{
                mid,
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

