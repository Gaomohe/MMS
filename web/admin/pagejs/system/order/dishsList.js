/*
layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    //表格渲染
    var tableIns = table.render({
        elem: '#dishList',
        url : '/dish?action=allDish',
        cellMinWidth : 95,
        page : true,
        toolbar: '#dishDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: '编号',  align:'center',width:200},
            {field: 'name', title: '菜名',  align:'center',width:200},
            {field: 'price', title: '价格', width:150, align:"center"},
            {field: 'picture', title: '图片', width:200, align:"center"},
        ]]
    });

    //工具栏事件
    table.on('toolbar(dishList)', function(obj){
        console.log(100);
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var dishid = '';
        console.log(dishid)
        for(i=0;i<data.length;i++){
            dishid = data[i].id;
            console.log(dishid)
        }
        switch(obj.event){
            case 'delDish':	//删除菜品
                console.log(dishid);
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('删除菜品后对应的全部数据都将被删除,确定删除吗?', {icon: 3, title:'提示'}, function(index){
                    delDish(dishid);
                    layer.close(index);
                });
                break;

            case 'upDish':	//修改
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upDish(dishid);
                }
                break;

            case 'addDish':	//新增
                addDish();
                break;

            case 'hairMenu':	//修改角色权限
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    hairMenu(roleid);
                }
                break;
            case 'addOrder':
                addOrderDish(dishid);
                break;
        };
    });

    //加入购物车
    function addOrderDish(dishid){
        $.ajax({
            url:"/trolley?action=addTrolly",
            type:"post",
            data:{"dishid":dishid},
            success:function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("添加成功");
                    tableIns.reload("#dishList");
                }
            }
        })
    }

    //删除菜品
    function delDish(dishid){
        $.ajax({
            url:"/dish?action=delDish",
            type:"post",
            data:{"dishid":dishid},
            success:function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("删除成功");
                    tableIns.reload("#dishList");
                }
            }
        })
    }

    function addDish(){
        layui.layer.open({
            title:"添加菜品",
            type:2,
            content : "admin/page/system/dish/addDish.jsp",
            area:['500px','650px']
        })
    }

    //修改角色
    function upDish(dishid){
        layui.layer.open({
            title : "修改角色",
            type : 2,
            content : "admin/page/system/dish/dishInfo.jsp",
            area:['500px','650px'],
            success:function(layero, index){
                $.ajax({
                    url:"/dish?action=allDishById",
                    type:"post",
                    data:{"dishid":dishid},
                    success:function(data){
                        var info = JSON.parse(data);
                        console.log(info);
                        console.log(info.data.id);
                        console.log(info.data.name);
                        console.log(info.data.price);
                        console.log(info.data.picture);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#id").val(info.data.id);
                        body.find("#name").val(info.data.name);
                        body.find("#price").val(info.data.price);
                        body.find("#upload-demo-preview").val(info.data.picture);
                    }
                })
                /!*        			//获取新窗口对象
                                    var iframeWindow = layero.find('iframe')[0].contentWindow;
                                    //重新渲染
                                    iframeWindow.layui.form.render();*!/
            }
        });
    }





    //新增角色
    function addRole(){
        layui.layer.open({
            title : "新增角色",
            type : 2,
            content : "admin/page/system/role/roleAdd.jsp",
            area:['350px','200px'],
        });
    }

    //修改角色权限
    function upRoleMenu(roleid){
        layui.layer.open({
            title : "分配权限",
            type : 1,
            content : $('#dtree1'),
            area:['300px','500px'],
            success:function(){
                //给dtree树加载数据
                dtree.render({
                    elem: "#dataTree3",
                    url: "/allMenuDtree",
                    dataStyle: "layuiStyle",  //使用layui风格的数据格式
                    dataFormat: "list",  //配置data的风格为list
                    response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
                    checkbar:true,
                    line: true,  // 显示树线
                    done: function(res, $ul, first){
                        $.ajax({
                            url:"/allRoleMenu",
                            type:"post",
                            data:{"roleid":roleid},
                            success:function(res){
                                var cs = eval('(' + res + ')');
                                $.each(cs,function(index,row){
                                    dtree.chooseDataInit("dataTree3",[row.id]); // 初始化选中
                                })
                            }
                        })
                    }
                });
            },
            btn:['修改权限'],	//确认按钮
            yes: function(index, layero){
                var params = dtree.getCheckbarNodesParam("dataTree3");
                var infos = JSON.stringify(params);
                var cs = eval('(' + infos + ')');
                var menuidList = new Array();	//所有选中值的权限id
                //alert(menuidList.length);
                $.each(cs,function(index,row){
                    menuidList[index] = row.nodeId;
                })
                $.ajax({
                    url:"/menuByRoleid",
                    data:{
                        "array":menuidList,
                        "roleid":roleid
                    },
                    type:"post",
                    traditional:true,
                    success:function(data){
                        var demo = eval('(' + data + ')');
                        if(demo.status == 1){
                            layer.msg(demo.message);
                            table.reload('newsList');
                            layer.close(index)	//关闭/
                        }else{
                            layer.msg("分配失败");
                        }
                    }
                })
            }
        })
    }


})*/




layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    //表格渲染
    var tableIns = table.render({
        elem: '#dishList',
        url: '/dish?action=allDish',
        cellMinWidth: 95,
        page: true,
        toolbar: '#dishDemo',
        height: "full-125",
        limit: 20,
        limits: [10, 15, 20, 25],
        cols: [[
            {type: "checkbox", fixed: "left", width: 50},
            {field: 'id', title: '编号', align: 'center', width: 200},
            {field: 'name', title: '菜名', align: 'center', width: 200},
            {field: 'price', title: '价格', width: 150, align: "center"},
            {field: 'picture', title: '图片', width: 200, align: "center"}
        ]]
    });

    //工具栏事件
    table.on('toolbar(dishList)', function(obj) {
        console.log(100);
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var dishid = '';
        console.log(dishid);
        for (i = 0; i < data.length; i++) {
            dishid = data[i].id;
            console.log(dishid);
        }
        switch (obj.event) {
            case 'delDish': // 删除菜品
                console.log(dishid);
                if (data.length != 1) {
                    layer.msg("请选择一行数据进行操作");
                    return false;
                }
                layer.confirm('删除菜品后对应的全部数据都将被删除,确定删除吗?', {icon: 3, title: '提示'}, function(index) {
                    delDish(dishid);
                    layer.close(index);
                });
                break;

            case 'upDish': // 修改
                if (data.length != 1) {
                    layer.msg("请选择一行数据进行操作");
                    return false;
                } else {
                    upDish(dishid);
                }
                break;

            case 'addDish': // 新增
                addDish();
                break;

            case 'hairMenu': // 修改角色权限
                if (data.length == 0 || data.length > 1) {
                    layer.msg("请选择一行数据进行操作");
                    return;
                } else {
                    hairMenu(roleid);
                }
                break;

            case 'addOrder': // 加入购物车
                if (data.length != 1) {
                    layer.msg("请选择一行数据进行操作");
                    return false;
                } else {
                    // 先弹出对话框让用户输入数量
                    layer.prompt({
                        formType: 0,
                        value: 1,
                        title: '请输入数量'
                    }, function(value, index) {
                        addOrderDish(dishid, value); // 传递 dishid 和数量
                        layer.close(index);
                    });
                }
                break;
        };
    });

    // 加入购物车
    function addOrderDish(dishid, quantity) {
        $.ajax({
            url: "/trolley?action=addTrolly",
            type: "post",
            data: {"dishid": dishid, "quantity": quantity},
            success: function(data) {
                var info = JSON.parse(data);
                console.log(info);
                if (info.status == 200) {
                    layer.msg("添加成功");
                    tableIns.reload("#dishList");
                    location.reload();
                }
            }
        });
    }
});
