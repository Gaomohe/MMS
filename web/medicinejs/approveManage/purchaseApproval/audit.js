layui.use(['form', 'layedit', 'laydate','table'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    var $ = layui.$;
    // 初始设置半选

    //通过事件
    $("#isok").click(function(){
        // 获取所有选中的复选框
        var checkedCheckboxes = $('input[type="checkbox"]:checked');

        // 创建一个数组来存储选中的数据
        var selectedData = [];

        // 遍历选中的复选框
        checkedCheckboxes.each(function() {
            var applyId = $(this).val(); // 获取复选框的value值，即applyId
            // 将数据存储到数组中
            selectedData.push({
                applyId: applyId,
            });
        });
        if (selectedData.length===0){
            layer.msg('请选择一列');
            return ;
        }
        var dataString = $.param({"selectedData": selectedData});
        layer.confirm('是否确定？', {icon: 3}, function(){
            $.ajax({
                url:"/approval?action=isok",
                data:{
                    dataString
                },
                type:"post",
                success:function(data){
                    var parse = JSON.parse(data);
                    if (parse.status===200){
                        layer.alert('已通过！');
                        // 刷新父页面
                        parent.window.location.reload();

                        // 关闭弹出层
                        var index = parent.layer.getFrameIndex(window.name); // 获取弹出层索引
                        parent.layer.close(index); // 关闭弹出层

                        //刷新页面，重新加载页面
                        // reloadAuditWindow
                    }else {
                        layer.msg('出错啦', {icon: 2});

                    }
                }
            })

        }, function(){
            layer.msg('未通过');
        });
    })

    //不通过事件
    $("#nook").click(function(){
        // 获取所有选中的复选框
        var checkedCheckboxes = $('input[type="checkbox"]:checked');

        // 创建一个数组来存储选中的数据
        var selectedData = [];

        // 遍历选中的复选框
        checkedCheckboxes.each(function() {
            var applyId = $(this).val(); // 获取复选框的value值，即applyId
            // 将数据存储到数组中
            selectedData.push({
                applyId: applyId,
            });
        });
        if (selectedData.length===0){
            layer.msg('请选择一列');
            return ;
        }
        $('#dialogBox').show();
    })

    //全部通过事件
    $("#allok").click(function(){
        var allInputs = $('input');

// 创建一个数组来存储所有input元素的value
        var inputValues = [];

// 遍历所有input元素
        allInputs.each(function() {
            var inputValue = $(this).val(); // 获取当前input元素的value
            inputValues.push(inputValue); // 将value添加到数组中
        });

        var dataString = $.param({"inputValues": inputValues});
        layer.confirm('是否全部通过？', {icon: 3}, function(){
            $.ajax({
                url:"/approval?action=isok",
                data:{
                    dataString
                },
                type:"post",
                success:function(data){
                    var parse = JSON.parse(data);
                    if (parse.status===200){
                        layer.alert('已全部通过！');
                        // 刷新父页面
                        parent.window.location.reload();

                        // 关闭弹出层
                        var index = parent.layer.getFrameIndex(window.name); // 获取弹出层索引
                        parent.layer.close(index); // 关闭弹出层

                    }else {
                        layer.msg('出错啦');
                    }
                }
            })
        },function (){
            layer.msg('未通过');
        })

    })


    //取消事件
    $("#out").click(function(){
        var index = parent.layer.getFrameIndex(window.name); // 获取弹出层索引
        parent.layer.close(index); // 关闭弹出层
    });

    //取消事件
    $("#out_1").click(function (){
        $('#dialogBox').hide();
    })
    $("#tijao").click(function (){
        // 获取所有选中的复选框
        var checkedCheckboxes = $('input[type="checkbox"]:checked');

        // 创建一个数组来存储选中的数据
        var selectedData = [];

        // 遍历选中的复选框
        checkedCheckboxes.each(function() {
            var applyId = $(this).val(); // 获取复选框的value值，即applyId
            // 将数据存储到数组中
            selectedData.push({
                applyId: applyId,
            });
        });
        layui.stope(event);

        // 获取textarea的值
        var textareaValue = $('.layui-textarea').val();
        var dataString = $.param({"selectedData": selectedData});
        $.ajax({
            url:"/approval?action=submit",
            data:{
                textareaValue,
                dataString
            },
            type:"post",
            success:function(data){
                var parse = JSON.parse(data);
                if (parse.status===200){
                    layer.alert('已提交！');
                    // 刷新父页面
                    parent.window.location.reload();

                    // 关闭弹出层
                    var index = parent.layer.getFrameIndex(window.name); // 获取弹出层索引
                    parent.layer.close(index); // 关闭弹出层


                }else {
                    layer.msg('出错啦');
                }
            }
        })

    })
    $('.agree-link').click(function(event) {
        // 阻止链接默认的导航行为
        event.preventDefault();
        // 获取当前点击的链接中存储的applyId
        var applyId = $(this).data('applyid');


    });


})

