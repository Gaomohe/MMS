layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    //***********验证角色名是否存在***************
    function checkUname(oName){
        var is = false;
        $.ajax({
            url:"/orders?action=isUname",
            data:{"oName":oName},
            async:false,
            type:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log(info.status);
                if(info.status == 200){
                    is = true;
                }else{
                    is = false;
                }
                console.log(is);
            }
        })
        return is;
    }

    /***********鼠标失去焦点事件************(就一个input可以不用)***************/
    /*  $("#rname").blur(function(){
          var name = $("#rname").val();
          if(!name.length == "" || !name.length == null){
              var check = checkUname(name);
              if(check == false){
                  layer.msg("登录账号已存在! 请重新输入")
              }
          }
      })*/

    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var oId = $("#oId").val();
        var oName = $("#oName").val();
        var Specification = $("#Specification").val();
        var Manufactor = $("#Manufactor").val();
        var Unit = $("#Unit").val();
        var oNum = $("#oNum").val();
        var salePrice = $("#salePrice").val();
        var ShippingAddress = $("#ShippingAddress").val();
        var DeliveryAddress = $("#DeliveryAddress").val();
        var ShippingTime = $("#ShippingTime").val();
        var ShippingWay = $("#ShippingWay").val();
        var TempControlWay = $("#TempControlWay").val();
        var DeliveryTime = $("#DeliveryTime").val();
        var DeliveryTemp = $("#DeliveryTemp").val();
        var Attachment = $("#Attachment").val();
        var Salesman = $("#Salesman").val();
        var Buyer = $("#Buyer").val();
        var Recipient = $("#Recipient").val();
        var orderCondition = $("#orderCondition").val();
        var Statement = $("#Statement").val();
        if(oName.length == "" ){
            layer.msg("药品名称不能为空")
            return false;
        }else if(oName.length != null){
            var check = checkUname(oName);
            console.log(check);
            if(check == false){
                layer.msg("药品名称已存在! 请重新输入")
                return false;
            }
        }
        $.ajax({
            url:"/orders?action=addOrders",
            data:{
                "oId":oId,
                "oName": oName,
                "Specification": Specification,
                "Manufactor": Manufactor,
                "Unit": Unit,
                "oNum": oNum,
                "salePrice": salePrice,
                "ShippingAddress": ShippingAddress,
                "DeliveryAddress": DeliveryAddress,
                "ShippingTime": ShippingTime,
                "ShippingWay": ShippingWay,
                "TempControlWay": TempControlWay,
                "DeliveryTime": DeliveryTime,
                "DeliveryTemp": DeliveryTemp,
                "Attachment": Attachment,
                "Salesman": Salesman,
                "Buyer": Buyer,
                "Recipient": Recipient,
                "orderCondition": orderCondition,
                "Statement": Statement
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

