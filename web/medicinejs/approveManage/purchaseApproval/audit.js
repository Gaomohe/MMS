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
                    if (data.status===200){
                        layer.msg('已通过！', {icon: 1});
                        //刷新页面，重新加载页面
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
        var dataString = $.param({"selectedData": selectedData});
        $('#dialogBox').show();
        $.ajax({
            url:"/approval?action=nook",
            data:{
                dataString
            },
            type:"post",
            success:function(data){

            }
        })
    })

    //全部通过事件
    $("#allok").click(function(){
        layer.confirm('是否全部通过？', {icon: 3}, function(){
            $.ajax({
                url:"/approval?action=allok",
                data:{
                },
                type:"post",
                success:function(data){
                    if (data.status===200){
                        var index = parent.layer.getFrameIndex(window.name); // 获取弹出层索引
                        parent.layer.close(index); // 关闭弹出层
                        layer.msg('已全部通过');

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
    $('.agree-link').click(function(event) {
        // 阻止链接默认的导航行为
        event.preventDefault();
        // 获取当前点击的链接中存储的applyId
        var applyId = $(this).data('applyid');

        // 执行你想要进行的操作，比如发送一个请求到服务器
        console.log('同意操作的applyId:', applyId);

        // 这里可以添加更多的逻辑处理
    });


})

