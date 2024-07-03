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
        elem: '#newsList',
        url : '/role?action=allRole',
        cellMinWidth : 95,
        page : true,
        toolbar: '#roleDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: '编号',  align:'center',width:100},
            {field: 'state', title: '状态',  align:'center',width:100},
            {field: 'name', title: '角色名', width:150, align:"center"},
            {field: 'roleKey', title:'角色标识' , width:150, align:"center"},
            {field: 'description', title:'角色描述' , width:150, align:"center"}
        ]]
    });

    //工具栏事件
    table.on('toolbar(newsList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var roleid = '';
        for(i=0;i<data.length;i++){
            roleid = data[i].id;
        }
        switch(obj.event){
            case 'delRole':	//删除角色
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('删除角色后用户对应的权限也会删除,确定删除吗?', {icon: 3, title:'提示'}, function(index){
                    delRole(roleid);
                    layer.close(index);
                });
                break;

            case 'upRole':	//修改角色
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upRole(roleid);
                }
                break;

            case 'addRole':	//新增角色
                addRole();
                break;

            case 'hairMenu':	//修改角色权限
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    hairMenu(roleid);
                }
                break;
        };
    });

    //删除角色
    function delRole(roleid){
        $.ajax({
            url:"/role?action=delRole",
            type:"post",
            data:{"roleid":roleid},
            success:function(data){
                var info = JSON.parse(data);
                if(info.status == 200){
                    layer.msg("删除成功");
                    tableIns.reload("#newsList");
                }
            }
        })
    }

    //修改角色
    function upRole(roleid){
        layui.layer.open({
            title : "修改角色",
            type : 2,
            content : "admin/page/system/role/roleInfo.jsp",
            area:['350px','230px'],
            success:function(layero, index){
                $.ajax({
                    url:"/role?action=allRoleByRoleid",
                    type:"post",
                    data:{"roleid":roleid},
                    success:function(data){
                        var info = JSON.parse(data);
                        console.log(info);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#roleid").val(info.data.id);
                        body.find("#rname2").val(info.data.name);
                        body.find("#rname").val(info.data.name);
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
    function addRole(){
        layui.layer.open({
            title : "新增角色",
            type : 2,
            content : "admin/page/system/role/roleAdd.jsp",
            area:['350px','200px'],
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