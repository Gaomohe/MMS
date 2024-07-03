layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    /*  var userid = $("#uid").val();
      alert(userid);*/
    /*  $.ajax({
          url:"/Backend/RoleServlet?action=allRole",
          type:"post",
          success:function(data){
              var info = eval("("+data+")");
              var row = info.data;
              var role = $("#role1");
              $.ajax({
                  url:"/Backend/UserServlet?action=",	//查询用户是否有角色有返回1,没有返回0
              })
              var html = '<option value="0">无角色</option>';
              $.each(row,function(index,item){
                  html += '<option value="'+item.id+'">'+item.rname+'</option>';
              })
              role.html(html);
              form.render("select");
          }
      })*/
    // $.ajax({
    //     url:"/allRole",
    //     type:"post",
    //     success:function(data){
    //         var info = eval("("+data+")");
    //         var row = info.data;
    //         var role = $("#role1");
    //         var html = '';
    //         $.each(row,function(index,item){
    //             html += '<option value="'+item.rid+'">'+item.rname+'</option>';
    //         })
    //         role.html(html);
    //         form.render("select");
    //         $.ajax({
    //             url:"/allRole",
    //             type:"post",
    //             success:function(data){
    //                 var info = eval("("+data+")");
    //                 var row = info.data;
    //                 var role = $("#role1");
    //                 var html = '';
    //                 $.each(row,function(index,item){
    //                     html += '<option value="'+item.rid+'">'+item.rname+'</option>';
    //                 })
    //                 role.html(html);
    //                 form.render("select");
    //
    //             }
    //         })
    //     }
    // })

    /*  //自定义验证规则
      var isyan = form.verify({
        uname: function(value){
          if(value.length < 3){
            return '登录名不能小于3位数';
          }
          if(!/[^\u4e00-\u9fa5]/.test(value)){
              return "登录名不能为中文";
          }
        },
        password: [
          /^[\S]{6,12}$/
          ,'密码必须6到12位，且不能出现空格'
        ],
        content: function(value){
          layedit.sync(editIndex);
        }
      });*/

    //重名验证
    /*function checkUname(uname){
        var is = false;
        $.ajax({
            url:"/isUname",
            data:{"uname":uname},
            async:false,
            type:"post",
            success:function(data){
                if(data == 0){
                    is = true;
                }else{
                    is = false;
                }
            }
        })
        return is;
    }*/

    //重名验证
    /*$("#uname").blur(function(){
        var name = $("#uname").val();
        var name2 = $("#uname2").val();
        if(name !=null && name!=name2 ){
            var check = checkUname(name);
            if(check == false){
                layer.alert("登录账号已存在! 请重新输入");
            }
        }
    })*/


    //修改
    $("#xiugai").click(function(){
        var uid = $("#uid").val();
        var name = $("#uname").val();
        var pass = $("#password").val();
        var realName = $("#realName").val();
        var sex = $("input[name='st_Sex']:checked").val();

       /* if(name.length<3){
            layer.alert("登录名不能小于3位数")
            return false;
        }else if(pass.length < 5 || pass.length > 19){
            layer.alert('密码必须6到12位，且不能出现空格');
            return false;
        }else if(realName.length == "" || realName.length == null){
            layer.alert('用户名不能为空');
            return false;
        }else if(!email.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
            layer.alert("邮箱格式不正确！请重新输入");
            return false;
        }else if(phone.length != 11){
            layer.alert("手机格式不正确! 请重新输入");
            return false;
        }else if(name !=null && name!=name2 ){
            var check = checkUname(name);
            if(check == false){
                layer.alert("登录账号已存在! 请重新输入")
                return false;
            }
        }*/
        var data = {
            action:"doUpdateUser",
            "uid":uid,
            "name":name,
            "pass":pass,
            "realName":realName,
            "sex":sex
        }
        $.ajax({
            url:"/user",
            data:data,
            type:"post",
            dataType:"json",
            success:function(data){
                var info9 = JSON.parse(data);
                if(data.status == 200){
                    layer.msg(data.msg,{icon:6});
                    console.log(info9.msg)
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }else{
                    layer.msg("系统异常");
                }
            }
        })
        return false;
    })

});
/*jQuery(function($){
	  $.ajax({
		  url:"/Backend/RoleServlet?action=allRole",
		  type:"post",
		  success:function(data){
			  var info = eval("("+data+")");
			  var role = $("#role");
			  var html = '';
			  $.each(info.data,function(index,datas){
				  html += '<option value="'+datas.id+'">'+datas.rname+'</option>';
			  })
			  role.html(html);
		  }

	})
}); */