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
        elem: '#supplierList',
        url : '/supplier?action=selectSupplier',
        cellMinWidth : 95,
        page : true,
        toolbar: '#supplierDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},
            {field: 'sName', title: '供货商名称',  align:'center',width:100},
            {field: 'operationWay', title: '供货方式', width:150, align:"center"},
            {field: 'tel', title:'电话' , width:150, align:"center"},
            {field: 'contact', title:'联系人' , width:150, align:"center"},
            {field: 'status', title:'状态' , width:150, align:"center"},
            {field: 'license', title:'许可证到期日期' , width:150, align:"center"},
            {field: 'createTime', title:'创建时间' , width:150, align:"center"}
        ]],
        // done:function (data){
        //     console.log(data)
        // }
    });

    //工具栏事件
    table.on('toolbar(supplierList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var supplierId = '';
        for(i=0;i<data.length;i++){
            supplierId = data[i].sid;//这里得和上面的field里的id名对应
        }
        switch(obj.event){
            case 'delSupplier':	//删除供应商
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('删除供应商后用户对应的权限也会删除,确定删除吗?', {icon: 3, title:'提示'}, function(index){
                    delSupplier(supplierId);
                    layer.close(index);
                });
                break;

            case 'upSupplier':	//修改供应商
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upSupplier(supplierId);
                }
                break;

            case 'addSupplier':	//新增供应商
                addSupplier();
                break;

            // case 'hairMenu':	//修改角色权限
            //     if(data.length == 0 || data.length > 1){
            //         layer.msg("请选择一行数据进行操作")
            //         return ;
            //     }else{
            //         hairMenu(roleid);
            //     }
            //     break;
        };
    });

    //删除供应商
    function delSupplier(supplierId){
        $.ajax({
            url:"/supplier?action=delSupplier",
            type:"post",
            data:{"supplierId":supplierId},
            success:function(data){
                var info = JSON.parse(data);
                if(info.status == 200){
                    layer.msg("删除成功");
                    tableIns.reload("#supplierList");
                }
            }
        })
    }

    //修改供应商
    function upSupplier(supplierId){
        layui.layer.open({
            title : "修改供货商信息",
            type : 2,
            content : "medicine/infoManage/supplierManage/supplierInfo.jsp",
            area:['350px','230px'],
            success:function(layero, index){
                $.ajax({
                    url:"/supplier?action=selectSupplierById",//根据id查询的方法
                    type:"post",
                    data:{"supplierId":supplierId},
                    success:function(data){
                        var info = JSON.parse(data);
                        console.log(info);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#supplierId").val(info.data.sid);
                        body.find("#sname2").val(info.data.sName);
                        body.find("#sname").val(info.data.sName);
                        body.find("#operationWay").val(info.data.operationWay);
                        body.find("#tel").val(info.data.tel);
                        body.find("#contact").val(info.data.contact);
                        body.find("#status").val(info.data.status);
                        body.find("#license").val(info.data.license);
                        body.find("#createTime").val(info.data.createTime);
                    }
                })
                /*        			//获取新窗口对象
                                    var iframeWindow = layero.find('iframe')[0].contentWindow;
                                    //重新渲染
                                    iframeWindow.layui.form.render();*/
            }
        });
    }

    //新增角色
    function addSupplier(){
        console.log("ddd")
        layui.layer.open({
            title : "新增供应商",
            type : 2,
            content : "medicine/infoManage/supplierManage/supplierAdd.jsp",
            area:['400px','500px'],
        });
    }

    //分配权限
    function hairMenu(roleid) {
        var index1=layer.open({
            title : "分配权限",
            type : 1,
            content : $('#dtree1'),
            area:['300px','500px'],
            success:function () {
                dtree.render({
                    elem: '#dataTree3',
                    url: "/role?action=MenuDtree",
                    dataStyle: "layuiStyle",  //使用layui风格的数据格式
                    dataFormat: "list",  //配置data的风格为list
                    response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
                    checkbar:true,
                    line: true,  // 显示树线
                    done:function () {
                        $.ajax({
                            url:"/role?action=menuByRoleid",
                            type:"post",
                            data:{"roleid":roleid},
                            success:function(res) {
                                var cs = JSON.parse(res);
                                console.log(cs);
                                $.each(cs,function(index,row){
                                    console.log(row.id);
                                    dtree.chooseDataInit("dataTree3",[row.id]); // 初始化选中
                                })
                            }
                        })
                    }
                })
            },
            btn:["修改权限"],
            yes:function () {
                var node= dtree.getCheckbarNodesParam("dataTree3");
                var infos = JSON.stringify(node);
                var cs = JSON.parse(infos);
                var menuidList=new Array();
                $.each(cs,function(index,row){
                    menuidList[index] = row.nodeId;
                })
                $.ajax({
                    url:"/role?action=UpdateRoleMenu",
                    data:{
                        "array":menuidList,
                        "roleid":roleid
                    },
                    type:"post",
                    dataType:"json",
                    traditional:true,
                    success:function(data){
                        console.log(data.status);
                        if(data.status == 200){
                            layer.msg(data.msg);
                            table.reload('newsList');
                            location.reload();
                            layer.close(index1)
                        }else{
                            layer.msg("分配失败");
                        }
                    }
                })
            },

        })
    }

    //分配权限
    function hairMenu1(roleid) {
        layui.layer.open({
                title : "分配权限",
                type : 1,
                content : $('#dtree1'),
                area:['300px','500px'],
                success:function () {
                    dtree.render({
                        elem: "#dataTree3",
                        url: "/role?action=allMenuDtree",
                        dataStyle: "layuiStyle",  //使用layui风格的数据格式
                        dataFormat: "list",  //配置data的风格为list
                        response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
                        checkbar:true,
                        line: true,  // 显示树线
                        done:function (res) {
                            $.ajax({
                                url:"/role?action=menuByUseridType",
                                type:"post",
                                data:{"roleid":roleid},
                                success:function(res){
                                    var cs = JSON.parse(res);
                                    $.each(cs,function(index,row){
                                        dtree.chooseDataInit("dataTree3",[row.id]); // 初始化选中
                                    })
                                }
                            })
                        }

                    })
                }
            }
        )
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

})