layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        $ = layui.jquery;

        var  laydate=layui.laydate;
        laydate.render({
             elem:'#createTime'
        });



    /*添加分类*/
    form.on('submit(addNews)',function (data){
        var title=$("#title").val();
        var content=$("#content").val();
        var createTime=$("#createTime").val();

        if (title==""||title==null){
            layer.msg("标题不可以为空");
            return false;
        }

        if (content==""||content==null){
            layer.msg("内容不能为空");
            return false;
        }

        var nl = {
            title:title,
            content:content,
            createTime:createTime
        }

        console.log(nl)

        var news = JSON.stringify(nl);

        $.post("/addNews", {news:news},
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