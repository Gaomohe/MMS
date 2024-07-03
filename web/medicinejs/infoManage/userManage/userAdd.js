layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    $.ajax({
        url:"/user?action=allRole",
        type:"post",
        success:function(data){
            var info = JSON.parse(data)
            console.log(info);
            // var row = info.data;
            var row = info;
            console.log(row);
            var role = $("#role1");
            var html = '';
            $.each(row,function(index,item){
                html += '<option value="'+item.id+'">'+item.name+'</option>';
            })
            role.html(html);
            form.render("select");
        }
    })

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

    /*  //监听提交
      form.on('submit("addUser")', function(data){
          var name = $("#uname").val();
          var pass = $("#password").val();
          var realName = $("#realName").val();
          var sex = $("input[type='radio']:checked").val();
          var email = $("#email").val();
          var phone = $("#phone").val();
          var role = $("select[name='role1']").val();
          alert(role);
          return false;
      });*/

    function checkUname(uname){
        var is = false;
        $.ajax({
            url:"/user?action=isUname",
            data:{"uname":uname},
            async:false,
            type:"post",
            success:function(data){
                var info = JSON.parse(data)
                if(info.status == 200){
                    is = true;
                }else{
                    is = false;
                }
            }
        })
        return is;
    }

    $("#uname").blur(function(){
        var name = $("#uname").val();
        if(!name.length == "" || !name.length == null){
            var check = checkUname(name);
            if(check == false){
                layer.alert("登录账号已存在! 请重新输入")
            }
        }
    })


    $("#tijiao").click(function(){
        var id = $("#id").val();
        var name = $("#userName").val();
        var pass = $("#password").val();
        var telNumber = $("#telNumber").val();
        var address = $("#address").val();
        var sex = $("input[name='st_Sex']:checked").val();
        var age = $("#age").val();
        var birthday = $("#birthday").val();
        var createDate = $("#createDate").val();
        var wechat = $("#wechat").val();
        var data = {
            action:"doUpdateUser",
            "id":id,
            "name":name,
            "pass":pass,
            "telNumber":telNumber,
            "address":address,
            "sex":sex,
            "age":age,
            "birthday":birthday,
            "createDate":createDate,
            "wechat":wechat,
        }
        if(name.length<3){
            layer.alert("登录名不能小于3位数")
            return false;
        }else if(pass.length < 5 || pass.length > 19){
            layer.alert('密码必须6到12位，且不能出现空格');
            return false;
        }else if(name.length == "" || name.length == null){
            layer.alert('用户名不能为空');
            return false;
        }else if(telNumber.length != 11){
            layer.alert("手机格式不正确! 请重新输入");
            return false;
        }

        $.ajax({
            url:"/user?action=addUser",
            data:data,
            tyep:"post",
            success:function(data){
                var info = JSON.parse(data)
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