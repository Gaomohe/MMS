layui.use(['form', 'layedit', 'laydate'], function() {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate;


    $("#tijiao").click(function(){
        var name = $("#name").val();
        var fileName = $("#fileName").val();
        var one = $("#one").val();
        var two = $("#two").val();
        var three = $("#three").val();
        var num = $("#num").val();
        var price = $("#price").val();
        var miaoshu = $("#miaoshu").val();
        var data = {
            "name":name,
            "miaoshu":miaoshu,
            "one":one,
            "two":two,
            "three":three,
            "price":price,
            "num":num,
            "fileName":fileName
        }

        $.ajax({
            url:"/addproduct",
            data:data,
            tyep:"post",
            success:function(data){
                if(data == 1){
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

   $(function () {
       $("#miaoshu").click(function () {
           $.get("/seltype", {type:1},function (res) {
               var cs = eval('(' + res + ')');
               var dom = $("#one");
                   var html = '<option value="0">请选择</option>';
                   $.each(cs,function (index, item) {
                       html += '<option value="'+item.id+'">'+item.name+'</option>';
                   });
               dom.html(html);
               //重新渲染下拉列表
               form.render("select");
           });
       })
   })
    $(function () {
        $("#miaoshu").click(function () {
            $.get("/seltype", {type:2},function (res) {
                var cs = eval('(' + res + ')');
                var dom = $("#two");
                var html = '<option value="0">请选择</option>';
                $.each(cs,function (index, item) {
                    html += '<option value="'+item.id+'">'+item.name+'</option>';
                });
                dom.html(html);
                //重新渲染下拉列表
                form.render("select");
            });
        })
    })
    $(function () {
        $("#miaoshu").click(function () {
            $.get("/seltype", {type:3},function (res) {
                var cs = eval('(' + res + ')');
                var dom = $("#three");
                var html = '<option value="0">请选择</option>';
                $.each(cs,function (index, item) {
                    html += '<option value="'+item.id+'">'+item.name+'</option>';
                });
                dom.html(html);
                //重新渲染下拉列表
                form.render("select");
            });
        })
    })

})