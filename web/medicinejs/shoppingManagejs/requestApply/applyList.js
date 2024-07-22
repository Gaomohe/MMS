layui.use(['form', 'layedit', 'laydate','table'], function(){
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;


    $("#tijiao").click(function(){
        var arrID = new Array();
        var arrKu = new Array();
        var count = 0;
        $('#table-body tr').each(function() {
            var $row = $(this);
            var medicineCode = parseInt($row.find('td:eq(0)').text().trim(),10);  // 第一列：药品编号
            var addQuantity = parseInt($row.find('td:eq(3) input').val(), 10); // 第四列：添加数量，转化为整数

            // 检查是否为有效数值
            if (!isNaN(addQuantity)) {
                arrID[count]=medicineCode;
                arrKu[count]=addQuantity
                count++;
            }
        });
        var arrID = $.param({"arrID": arrID});
        var arrKu = $.param({"arrKu": arrKu});
        $.ajax({
            url:"/shopping?action=add",
            data:{
                arrKu,arrID
            },
            type:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log("什么")
                console.log(data)
                if(info.status === 200){
                    layer.msg("申请成功")
                    setTimeout(function(){
                        layer.closeAll("iframe");
                        //刷新父页面
                        parent.location.reload();
                    },1000);
                    insertApply();
                }else{
                    layer.msg("系统异常");
                }
            }
        })
        return false;
    })

    function insertApply(){
        $.ajax({
            url:"/shopping?action=insertApply",
            type:"post",
            success:function (data){
                if(data.status === 200){
                    console.log("成功");
                }

            }
        })
    }

})

