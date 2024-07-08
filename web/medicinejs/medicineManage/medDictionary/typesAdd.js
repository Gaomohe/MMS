layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    var a = $("input").attr('id');
    var b = $("input").attr('name');
    //***********验证角色名是否存在***************
    function checkUname(name){
        var is = false;
        $.ajax({
            url:"/type?action="+b,
            data:{"typename":name},
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
    $("#add").click(function(){
        var name = $("input").val();
        if(name.length == "" ){
            layer.msg("角色名不能为空")
            return false;
        }else if(name.length != null){
            var check = checkUname(name);
            console.log(check);
            if(check == false){
                layer.msg("角色名已存在! 请重新输入")
                return false;
            }
        }
        $.ajax({
            url:"/type?action="+a,
            data:{
                "type":name,
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

