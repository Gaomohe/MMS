layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;

    /*验证分类名是否存在*/
    $("#name").blur(function (){
        var name=$("#name").val();//分类
        var s=JSON.stringify(name);
        $.ajax({
            url:"/isCateName",
            type:"post",
            data:{
                name:name
            },
            success:function (data){
                if (data>=1){
                    layer.msg('分类名已经存在');
                }
            }
        })
    })

    /*添加分类*/
    form.on('submit(addCate)',function (data){
        var name=$("#name").val();
        var parentId=$("#parentId").val();
        var type=$("#type").val();

        if (name==""||name==null){
            layer.msg("分类名不可以为空");
            return false;
        }

        if (parentId==""||parentId==null){
            layer.msg("请输入父级ID");
            return false;
        }

        if (type==""||type==null){
            layer.msg("请选择级别");
            return false;
        }

        $.post("/addCategory",
            {
                name:name,
                parentId:parentId,
                type:type
            },
            function (data){
                var info = eval("("+data+")");
                if(info.status == 1){
                    top.layer.msg("分类添加成功");
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }else{
                    top.layer.msg("分类添加失败");
                }
            })
        return false;
    })

});