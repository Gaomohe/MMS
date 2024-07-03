layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    //***********验证供应商名是否存在***************
    function checkUname(mname){
        var is = false;
        $.ajax({
            url:"/middleMan?action=checkMiddleManName",
            data:{"mname":mname},
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
        var mname = $("#mname").val();
        var mname2 = $("#mname2").val();
        var workId = $("#workId").val();
        var tel = $("#tel").val();
        var email = $("#email").val();
        var department = $("#department").val();
        var medName = $("#medName").val();
        var standard = $("#standard").val();
        var medNum = $("#medNum").val();
        var date = $("#date").val();
        var place = $("#place").val();
        if(sname.length == "" ){
            layer.msg("经手人名称不能为空")
            return false;
        }else if(mname.length != null && mname!=mname2 ){
            var check = checkUname(mname);
            if(check == false){
                layer.msg("经手人名称已存在! 请重新输入")
                return false;
            }
        }

        $.ajax({
            url:"/middleMan?action=updateMiddleMan",
            data:{
                "mname":mname,
                "workId":workId,
                "tel":tel,
                "email":email,
                "department":department,
                "medName":medName,
                "standard":standard,
                "medNum":medNum,
                "date":date,
                "place":place
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

});
