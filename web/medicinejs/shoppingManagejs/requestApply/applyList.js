layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;

    $("#tijiao").click(function(){
        var sname = $("#sname").val();

        if(sname.length == "" ){
            layer.msg("供应商名称不能为空")
            return false;
        }else if(sname.length != null){
            var check = checkUname(sname);
            console.log(check);
            if(check == false){
                layer.msg("该供货商已存在! 请重新输入")
                return false;
            }
        }
        $.ajax({
            url:"/shopping?action=add",
            data:{
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

})