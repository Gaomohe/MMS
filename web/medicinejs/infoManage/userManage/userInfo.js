layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    //修改
    $("#xiugai").click(function(){
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
