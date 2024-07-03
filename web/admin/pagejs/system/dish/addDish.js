layui.use(['upload', 'form'], function(){
    var upload = layui.upload;
    var layer = layui.layer;
    var form = layui.form;
    var $ = layui.$;

    var path = [];
    var i = 0;

    // 多图片上传
    upload.render({
        elem: '#ID-upload-demo-btn-2',
        url: '/file?action=upload', // 实际使用时改成您自己的上传接口即可。
        multiple: true,
        before: function (obj) {
        obj.preview(function (index, file, result) {
        $('#upload-demo-preview').append('<img src="' + result + '" alt="' + file.name + '" style="width: 90px; height: 90px;">');
            });
        },
        done: function (res) {
        console.log(50);
        console.log(res.status);
        // 上传完毕
        if (res.status == 200) {
        layer.msg("预览图上传加载成功");
        $("#filepath").val(res.msg);
        path.push(res.msg); // 将图片路径添加到数组中
        console.log(100);
        console.log(path);
        console.log(200);
            }
        }
    });

    // 使用form模块的on事件监听提交事件
    form.on('submit(required)', function (data) {
        var name = data.field.name;
        var price = data.field.price;

        if(name.length === "") {
            layer.msg("菜品名不能为空");
            return false;
        } else {
            var check = checkUname(name);
            if(check == false) {
            layer.msg("菜品名已存在! 请重新输入");
            return false;
        }
    }

        console.log("即将提交的数据：");
        console.log("name: " + name);
        console.log("price: " + price);
        console.log("path: " + JSON.stringify(path));

        $.ajax({
            url: "/dish?action=addDish",
            data: {
            "name": name,
            "price": price,
            "path": JSON.stringify(path) // 添加图片路径
        },
        type: "post",
        success: function(data){
            var info = JSON.parse(data);
            console.log(info.status);
            if(info.status == 200){
                layer.msg("添加成功");
                setTimeout(function(){
                    parent.layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }, 1000);
            } else {
                layer.msg("系统异常");
            }
        }
    });

    return false; // 阻止表单的默认提交行为
});

    //***********验证角色名是否存在***************
    function checkUname(name){
        var is = false;
        $.ajax({
            url: "/dish?action=isUname",
            data: {"name": name},
            async: false,
            type: "post",
            success: function(data){
                var info = JSON.parse(data);
                if(info.status == 200){
                    is = true;
                } else {
                    is = false;
                }
            }
        });
        return is;
    }
});

