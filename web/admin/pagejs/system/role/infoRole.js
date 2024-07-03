﻿layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    //***********验证角色名是否存在***************
    function checkUname(rname){
        var is = false;
        $.ajax({
            url:"/role?action=checkUname",
            data:{"rname":rname},
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
        var rname = $("#rname").val();
        var rname2 = $("#rname2").val();
        var roleid = $("#roleid").val();
        if(rname.length == "" ){
            layer.msg("角色名不能为空")
            return false;
        }else if(rname.length != null && rname!=rname2 ){
            var check = checkUname(rname);
            if(check == false){
                layer.msg("角色名已存在! 请重新输入")
                return false;
            }
        }

        $.ajax({
            url:"/role?action=updateRole",
            data:{"rname":rname,"roleid":roleid},
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
