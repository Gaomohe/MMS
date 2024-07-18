layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    //***********验证供应商名是否存在***************
    function checkUname(oName){
        var is = false;
        $.ajax({
            url:"/orders?action=checkOrdersName",
            data:{"oName":oName},
            async:false,
            type:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log(info.status);
                console.log(info);
                if(info.status==200){
                    is = true;
                }else{
                    is = false;
                }

            }
        })
        return is;
    }

    /***********鼠标失去焦点事件************(就一个input可以不用)***************/
    /*  $("#rname").blur(function(){
          var name = $("#rname").val();
          if(rname.length != null && rname!=rname2 ){
              var check = checkUname(name);
              if(check == false){
                  layer.msg("登录账号已存在! 请重新输入")
              }
          }
      })*/

    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var oId = $("#oId").val();
        /*var oName = $("#oName").val();
        var oName2 = $("#oName2").val();
        var specification = $("#specification").val();*/
        var manufactor = $("#manufactor").val();
        /*var unit = $("#unit").val();
        var oNum = $("#oNum").val();
        var salePrice = $("#salePrice").val();*/
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
        /*if(oName.length == "" ){
            layer.msg("药品名称不能为空")
            return false;
        }else if(oName.length != null && oName!=oName2 ){
            var check = checkUname(oName);
            if(check == false){
                layer.msg("药品名称已存在! 请重新输入")
                return false;
            }
        }*/

        $.ajax({
            url:"/orders?action=updateOrders",
            data:{
                "oId":oId,
                "oName": oName,
                "specification": specification,
                "manufactor": manufactor,
                "unit": unit,
                "oNum": oNum,
                "salePrice": salePrice,
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
                "statement": statement
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
