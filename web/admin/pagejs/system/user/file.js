layui.use(['upload', 'form'], function(){
    var upload = layui.upload;
    var layer = layui.layer
    var form = layui.form;
        var $ = layui.$;

        var path= new Array();
        var i=0;
        // 多图片上传
        upload.render({
            elem: '#ID-upload-demo-btn-2',
            url: '/file?action=upload', // 实际使用时改成您自己的上传接口即可。
            multiple: true,
            before: function (obj) {
                obj.preview(function (index, file, result) {
                    $('#upload-demo-preview').append('<img src="' + result + '" alt="' + file.name + '" style="width: 90px; height: 90px;">')
                });
            },
            done: function (res) {
                // 上传完毕
                if (res.status == 200) {
                    layer.msg("预览图上传加载成功")
                    $("#filepath").val(res.msg)
                    path[i++] = res.msg
                    console.log(path)

                }
            }
        });

    // 使用form模块的on事件监听提交事件
    form.on('submit(demo1)', function (data) {
        alert(1)
        console.log(data.field);
            //var path=JSON.stringify(path)
            // 此处可执行 Ajax 等操作
            $.ajax({
                url:"/file?action=insertFile",
                data:{
                    path:path,
                    uname:data.field.username,
                    password:data.field.password
                },
                type:"GET",
                dataType:"json",
                traditional:true,
                success:function (data) {
                    console.log(data);
                    layer.msg(data.msg)
                    // 添加成功后关闭弹出层并刷新父页面
                    if(data.status == 200){
                        setTimeout(function(){
                            var index = parent.layer.getFrameIndex(window.name); //获取当前iframe层的索引
                            parent.layer.close(index); // 关闭弹出层
                            parent.location.reload(); // 刷新父页面
                        }, 1000);
                    }
                }
            })
            return false; // 阻止表单的默认提交行为
        });

});