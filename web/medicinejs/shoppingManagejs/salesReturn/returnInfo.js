layui.use(['form', 'layedit', 'laydate','jquery','cascader'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate
        ,$=layui.jquery
        ,cascader = layui.cascader;

    /*****************提交按钮事件***********************/
    $("#tijiao").click(function(){
        var id = $("#id").val();
        var demoCascader11Value = $("#demoCascader11").val(); // 获取级联选择器的值
        var valuesArray = demoCascader11Value.split(','); // 分割成数组
        var a = '';
        valuesArray.forEach(function(value) {
            var label = '';
            // 假设 citysData 是你的省市区数据
            function findLabel(data, value) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].value === value) {
                        label = data[i].label;
                        return true; // 但这里的 return true 不会影响 forEach 循环
                    }
                    if (data[i].children) {
                        // 递归查找子级
                        if (findLabel(data[i].children, value)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            // 从 citysData 开始查找
            findLabel(citysData, value);
            a +="/"+label;
        });
        var address = $("#address").val();
        var shippingWay = $("#shippingWay").val();
        var consigner = $("#consigner").val();

        a +="/"+address
        $.ajax({
            url:"/returnSal?action=updateAll",
            data:{
                id,
                address:a,
                shippingWay,
                consigner
            },
            tyep:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("修改成功")
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

    cascader.render({
        elem: '#demoCascader11',
        data: citysData,
        itemHeight: '250px',
        filterable: false,
        label:true,
    });

});
