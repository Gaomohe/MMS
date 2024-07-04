layui.use(['form','layer','layedit','laydate','upload'],function(){
    var form = layui.form
    layer = parent.layer === undefined ? layui.layer : top.layer,
        laypage = layui.laypage,
        upload = layui.upload,
        layedit = layui.layedit,
        laydate = layui.laydate,
        $ = layui.jquery;

    /* --- 验证权限名是否存在 ---------------------------------------------------------------*/
    $("#mname").blur(function(){
        var mname = $("#mname").val();  //权限
        // $.post("/isMenuName&mname="+mname,
        //     function(res){
        //     /*var cs = eval('(' + res + ')');*/
        //     if(res == 1){
        //         layer.msg('权限名已存在');
        //     }
        // })
        var s = JSON.stringify(mname);
        $.ajax({
            url:"/isMenuName",
            type:"post",
            data:{
                name:s
            },
            success:function(data){
                /*var cs = eval('(' + res + ')');*/
                if(data == 1){
                    layer.msg('权限名已存在');
                }
            }
        })
    })

    /* --- 验证请求路径是否存在 ----------------------------------------------------------------*/
    $("#mfunction").blur(function(){
        var mfunction = $("#mfunction").val();  //请求路径
        // $.post("/isMenuUrl&mfunction="+mfunction,function(res){
        //     /*var cs = eval('(' + res + ')');*/
        //     if(res == 1){
        //         layer.msg('请求路径已存在');
        //     }
        // })
        var s = JSON.stringify(mfunction);
        $.ajax({
            url:"/isMenuUrl",
            type:"post",
            data:{
                url:s
            },
            success:function(data){
                /*var cs = eval('(' + res + ')');*/
                if(data == 1){
                    layer.msg('请求路径已存在');
                }
            }
        })
    })


    /* -- 新增权限 --------------------------------------------------------------- */
    form.on('submit(menuUser)',function(data){
        var mname = $("#mname").val();  //权限名称
        var resUrl = $("#resUrl").val();  //权限名称
        var mfunction = $("#mfunction").val();  //权限标识
        var type2 = $("#type2").val();  //权限类型
        var icon = $("#icon").val();  //icon图标
        var mbtn = $("#mbtn").val();  //按钮代码
        var father = $("#father").val();  //父级
        //权限名
        if(mname == "" || mname == null){
            layer.msg("权限名不能为空");
            return false;
        }

        //请求路径
        if(mfunction == "" || mfunction == null){
            layer.msg("请求路径不能为空");
            return false;
        }

        //类型
        if(type2 == 0 || type2.size == 0){
            layer.msg("请选择类型");
            return false;
        }

        if(type2 != 1){
            if(father == 0){
                layer.msg("菜单或按钮不能没有上级");
                return false;
            }
        }
        if(type2 == 3){
            if(mbtn == null || mbtn.length < 30 || mbtn==""){
                layer.msg("按钮代码格式错误");
                return false;
            }
        }
        if(type2 != 3){
            mbtn = mname;
        }

        console.log({
            mname:mname,
            resUrl:resUrl,
            mfunction:mfunction,
            type2:type2,
            icon:icon,
            mbtn:mbtn,
            father:father
        })


        $.ajax({
            url:"/menu",
            data:{
                action:"addResources",
                mname:mname,
                resUrl:resUrl,
                mfunction:mfunction,
                type2:type2,
                icon:icon,
                mbtn:mbtn,
                father:father
            },
            type:"post",
            dataType:"json",
            success:function (data) {
                if(data.status == 200){
                    top.layer.msg(data.msg);
                    layer.closeAll("iframe");
                    //刷新父页面
                    parent.location.reload();
                }else{
                    top.layer.msg("权限添加失败");
                }
            }
        })

        /*$.post("/addMenu",{
                mname:mname,
                mfunction:mfunction,
                type2:type2,
                icon:icon,
                mbtn:mbtn,
                father:father
            },
            function(data){
            var info = eval("("+data+")");
            if(info.status == 1){
                top.layer.msg("权限添加成功");
                layer.closeAll("iframe");
                //刷新父页面
                parent.location.reload();
            }else{
                top.layer.msg("权限添加失败");
            }
        })*/
        return false;
    })


    /*-----------类型选择下拉框的点击事件----------*/
    form.on('select(type2)', function(data){
        var type = data.value;
        var dom = $("#goodsid");
        var mname = $("#mname").val();  //权限
        dom.html("");
        if(type == 3){
            $("#mbtn").val('');
            $("#iconclass").css("display","");
            $("#mbtn1").css("display","block");
            $("#urlpath").css("display","none");
            $("#iconclass").css("display","none");
            $("#btnclss").css("display","block");
            $.get("/menu?action=allButtonType",function (res) {
                var cs = JSON.parse(res);
                console.log(cs)
                var btntype = $('#btnType');
                var html = '<span value="0"></span>';
                $.each(cs,function (index, item) {
                    html += '<span class="btnType4" onclick="tongyiType(this)">'+item.btnType+'</span> ';
                });
                btntype.html(html);
            })
        }else if(type == 1){
            $("#mbtn1").css("display","none");
            $("#urlpath").css("display","none");
        }else{
            $("#iconclass").css("display","block");
            $("#urlpath").css("display","block");
            $("#btnclss").css("display","none");
            $("#mbtn1").css("display","none");
        }
        $.get("/menu?action=menuByType", {mtype:type},function (res) {
            var cs = JSON.parse(res);
            console.log(cs)
            var dom = $("#father");
            if(type == 1){
                var html = '<option value="0">目录没有上一级</option>';
            }else{
                var html = '<option value="0">请选择</option>';
                $.each(cs,function (index, item) {
                    html += '<option value="'+item.resId+'">'+item.name+'</option>';
                });
            }
            dom.html(html);
            //重新渲染下拉列表
            form.render("select");
        });

    });
    /*-----------监听下拉框----------*/

})
function tongyiType(obj){
    $("#mbtn").val('');
    var info =  $(obj).html();
    $("#mbtn").val(info);
}
