/*
layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate;

    $("#update").click(function(){
        console.log("aaaaaaaaaaa");
        var oId = $("#oId").val();
        var manufactor = $("#manufactor").val();
        var shippingAddress = $("#shippingAddress").val();
        var deliveryAddress = $("#deliveryAddress").val();
        var shippingTime = $("#shippingTime").val();
        var shippingWay = $("#shippingWay").val();
        var tempControlWay = $("#tempControlWay").val();
        var deliveryTime = $("#deliveryTime").val();
        var deliveryTemp = $("#deliveryTemp").val();
        var attachment = $("#attachment").val();
        var salesman = $("#salesman").val();
        var buyer = $("#buyer").val();
        var recipient = $("#recipient").val();
        var orderCondition = $("#orderCondition").val();
        var statement = $("#statement").val();
        var allPrice = $("#allPrice").val();
        var advance = $("#advance").val();
        var advanceStatus = $("#advanceStatus").val();
        var finals = $("#finals").val();
        var finalsStatus = $("#finalsStatus").val();

        $.ajax({
            url: "/orders?action=updateOrders",
            data: {
                "oId": oId,
                "manufactor": manufactor,
                "shippingAddress": shippingAddress,
                "deliveryAddress": deliveryAddress,
                "shippingTime": shippingTime,
                "shippingWay": shippingWay,
                "tempControlWay": tempControlWay,
                "deliveryTime": deliveryTime,
                "deliveryTemp": deliveryTemp,
                "attachment": attachment,
                "salesman": salesman,
                "buyer": buyer,
                "recipient": recipient,
                "orderCondition": orderCondition,
                "statement": statement,
                "allPrice": allPrice,
                "advance": advance,
                "advanceStatus": advanceStatus,
                "finals": finals,
                "finalsStatus": finalsStatus,
            },
            type: "post",
            success: function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("修改成功");
                    setTimeout(function(){
                        layer.closeAll("iframe");
                        // 刷新父页面
                        parent.location.reload();
                    }, 1000);
                } else {
                    layer.msg("系统异常");
                }
            }
        });
        return false;
    });
});
*/





layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form,
        layer = layui.layer,
        layedit = layui.layedit,
        laydate = layui.laydate;

    $(document).ready(function(){
        $("#update").click(function(){
            console.log("Button clicked");
            var oId = $("#oId").val();
            var manufactor = $("#manufactor").val();
            var shippingAddress = $("#shippingAddress").val();
            var deliveryAddress = $("#deliveryAddress").val();
            var shippingTime = $("#shippingTime").val();
            var shippingWay = $("#shippingWay").val();
            var tempControlWay = $("#tempControlWay").val();
            var deliveryTime = $("#deliveryTime").val();
            var deliveryTemp = $("#deliveryTemp").val();
            var attachment = $("#attachment").val();
            var salesman = $("#salesman").val();
            var buyer = $("#buyer").val();
            var recipient = $("#recipient").val();
            var orderCondition = $("#orderCondition").val();
            var statement = $("#statement").val();
            var allPrice = $("#allPrice").val();
            var advance = $("#advance").val();
            var advanceStatus = $("#advanceStatus").val();
            var finals = $("#finals").val();
            var finalsStatus = $("#finalsStatus").val();

            $.ajax({
                url: "/orders?action=updateOrders",
                data: {
                    "oId": oId,
                    "manufactor": manufactor,
                    "shippingAddress": shippingAddress,
                    "deliveryAddress": deliveryAddress,
                    "shippingTime": shippingTime,
                    "shippingWay": shippingWay,
                    "tempControlWay": tempControlWay,
                    "deliveryTime": deliveryTime,
                    "deliveryTemp": deliveryTemp,
                    "attachment": attachment,
                    "salesman": salesman,
                    "buyer": buyer,
                    "recipient": recipient,
                    "orderCondition": orderCondition,
                    "statement": statement,
                    "allPrice": allPrice,
                    "advance": advance,
                    "advanceStatus": advanceStatus,
                    "finals": finals,
                    "finalsStatus": finalsStatus,
                },
                type: "post",
                success: function(data){
                    var info = JSON.parse(data);
                    console.log(info);
                    if(info.status == 200){
                        layer.msg("修改成功");
                        setTimeout(function(){
                            layer.closeAll("iframe");
                            // 刷新父页面
                            parent.location.reload();
                        }, 1000);
                    } else {
                        layer.msg("系统异常");
                    }
                }
            });
            return false;
        });
    });
});
