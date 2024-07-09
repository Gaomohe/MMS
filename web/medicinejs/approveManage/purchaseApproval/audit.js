layui.use(['form', 'layedit', 'laydate','table'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    $("#isok").click(function(){
        $.ajax({
            url:"/approval?action=isok",
            data:{
            },
            type:"post",
            success:function(data){

            }
        })
    })
    $("#nook").click(function(){
        $.ajax({
            url:"/approval?action=nook",
            data:{
            },
            type:"post",
            success:function(data){

            }
        })
    })
    $("#allok").click(function(){
        $.ajax({
            url:"/approval?action=allok",
            data:{
            },
            type:"post",
            success:function(data){

            }
        })
    })
    $("#out").click(function(){
        console.log("取消")
        var index = parent.layer.getFrameIndex(window.name); // 获取弹出层索引
        parent.layer.close(index); // 关闭弹出层
    })


})

