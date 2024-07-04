layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;


    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#userList',
        url : '/user?action=getAllUser',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [5,10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'userName', title: '登录名', minWidth:100, align:"center"},
            {field: 'sex', title: '用户性别', align:'center'},
            {field: 'age', title: '年龄', align:'center'},
            {field: 'password', title: '密码', minWidth:100, align:"center"},
            // {field: 'cardBalance', title: '医疗卡余额',  align:'center'},
            // {field: 'code', title: '编码',  align:'center'},
            {field: 'telNumber', title: '联系方式',  align:'center'},
            {field: 'address', title: '家庭住址',  align:'center'},
            {field: 'birthday', title: '出生日期',  align:'center'},
            {field: 'createDate', title: '创建时间',  align:'center'},
            {field: 'wechat', title: '微信',  align:'center'},
            {title:'操作', width:150, templet: '#barDemo'}
        ]]
    });
    /*------------- 加载用户数据 --end------------------------------*/

    /*-------- 搜索用户 ----------------------------*/
    $("#doSubmit").click(function(){
        var like = $("#likename").val()
        tableIns.reload({
            url:"http://rm-bp1ln5cud01u6z7893o.mysql.rds.aliyuncs.com:8723/EEDemo/Interfaces?action=allUser&uname="+like,
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })

    table.on('toolbar(userList)',function (obj) {
        var checkdata= table.checkStatus(obj.config.id)
        var files= checkdata.data;
        console.log(obj);
        switch (obj.event) {
            case 'delUser':
                if(files.length > 1 | files.length<1){
                    layer.msg("请选择一行进行删除",{icon:2})
                    return;
                }else {
                    del(files[0].id);
                }
                break;
            case 'addUser':
                addUser();
                break;
            case 'upUser':
                // selectByIdUser(files[0].id,files[0].name);
                upUser(files[0].id);
                break;
            case 'selectDesc':

                break;
            case 'uploadUser':
                upLoad();
                break;
        }
    })

    function upLoad(){
        layer.open({
            type: 2, // page 层类型
            area: ['600px', '450px'],
            title: '图片上传',
            shade: 0.6, // 遮罩透明度
            shadeClose: true, // 点击遮罩区域，关闭弹层
            maxmin: true, // 允许全屏最小化
            anim: 0, // 0-6 的动画形式，-1 不开启
            content: "admin/page/system/user/fileUpload.jsp"
        })
    }

    /*table.on('tool(userList)',function (obj) {
        console.log(obj)
        switch (obj.event) {
            case 'delUser':
                if(files.length>1 | files.length<1){
                    layer.msg("请选择一行进行删除",{icon:2})
                    return;
                }else {
                    del(files[0].id);
                }
                break;
            case 'addUser':
                addUser();
                break;
            case 'upUser':
                selectByIdUser(files[0].id,files[0].userName)
                break;
            case 'selectDesc':
                break;
        }

    })*/
    //删除
    function del(id){
        alert(id)
        $.ajax({
            url:"/user",
            data:{
                action:"delUser",
                id:id
            },
            type:"get",
            dataType:"json",
            success:function (res) {
                layer.msg(res.msg,{icon: 6})
                tableIns.reload("#userList");
            }
        })
    }

    //修改回显
    function  selectByIdUser(id,uname) {
        layer.open({
            type: 2, // page 层类型
            area: ['600px', '450px'],
            title: '修['+uname+']改',
            shade: 0.6, // 遮罩透明度
            shadeClose: true, // 点击遮罩区域，关闭弹层
            maxmin: true, // 允许全屏最小化
            anim: 0, // 0-6 的动画形式，-1 不开启
            content: '/user?action=selectOneUser&&id='+id,
        })
    }

    /*table.on('toolbar(newsList)',function (obj) {

      /!*获取当前数据表格的 id*!/
      var  checkStatus=  table.checkStatus(obj.config.id)
      var trData=  checkStatus.data;
      var user=null;
      for (let i = 0; i <trData.length ; i++) {
            user=trData[i]
        }
      switch (obj.event) {
          case 'delUser':
            if(trData.length==1){
               let id= trData[0].id;
                $.ajax({
                    url:"/LoginServlet?type=delUser",
                    data:{
                         userid:id
                      },
                    type:"POST",
                    dataType:"json",
                    success:function(data){
                        alert(data.cord)
                        if(data.cord == 200){
                            layer.msg("删除成功")
                            tableIns.reload("#newsList");
                        }
                    }
                })

            }else{
                layer.msg("请选怎一条进行删除")
          }
              break;

          case 'upUser':
              if(trData.length==1) {
                  let id = trData[0].id;
                  layui.layer.open({
                      title : "修改用户",
                      type : 2,
                      content : "/LoginServlet?type=getUser&id="+id,
                      area:['600px','690px'],
                  })
              }else{
                  layer.msg("请选怎一条进行修改")
              }
              break;

          case 'addUser':
              layui.layer.open({
                    title:"添加用户",
                    type:2,
                    content:"/admin/page/system/user/userAdd.jsp",
                    area:['600px','690px']
              })
              break;


          case 'hairMenu':
              alert(4)
              break;
      }

    })*/

    //工具栏事件
    /*table.on('toolbar(newsList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var userid = '';
        for(i=0;i<data.length;i++){
            userid = data[i].id;
        }
        switch(obj.event){
            case 'hairMenu':	//分配权限
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    hairMenu(userid);
                }
                break;

            case 'addUser':	//新增用户
                addUser();
                break;

            case 'hairRole':	//分配角色
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    //HairRole(userid);
                }
                break;

            case 'upUser':	//修改用户信息
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    upUser(userid);
                }
                break;

            case 'delUser':	//删除用户
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    layer.confirm('确定删除用户吗', {icon: 3, title:'提示'}, function(index){
                        var loginName = $("#loginName").val();
                        if(userid == loginName){
                            layer.msg("你正在登录当前账号,无法删除")
                        }else{
                            delUser(userid);
                            layer.close(index);
                        }
                    });
                }
                break;
        };
    });*/

    //修改用户
    function upUser(userid){
        layui.layer.open({
            title : "修改用户信息",
            type : 2,
            content : "medicine/infoManage/userManage/userInfo.jsp",
            area:['500px','540px'],
            success:function(layero, index){
                $.ajax({
                    url:"/user?action=allUserByUserid",
                    type:"post",
                    data:{"userid":userid},
                    success:function(data){
                        var info = JSON.parse(data);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#id").val(info.data.id);
                        body.find("#userName2").val(info.data.name);
                        body.find("#sex").val(info.data.sex);
                        body.find("#age").val(info.data.age);
                        body.find("#pass").val(info.data.password);
                        body.find("#telNumber").val(info.data.telNumber);
                        body.find("#address").val(info.data.address);
                        body.find("#birthday").val(info.data.birthday);
                        body.find("#createDate").val(info.data.createDate);
                        body.find("#wechat").val(info.data.wechat);

                        //性别(单选)
                        var sex2 = info.data.sex;
                        if(sex2 == "男"){
                            body.find("#sex1").prop("checked",true);
                        }else{
                            body.find("#sex2").prop("checked",true);
                        }
                        //状态(单选)
                        var isStatus = info.data.status;
                        if(isStatus == 200){
                            body.find("#isStatus0").prop("checked",true);
                        }else{
                            body.find("#isStatus1").prop("checked",true);
                        }
                        /*------下拉框赋值--------*/
                        $.ajax({
                            url:"/user?action=allRole",
                            type:"post",
                            success:function(data){
                                var info = JSON.parse(data);
                                // var row = info.data;
                                var row = info;
                                console.log(row);
                                var role = body.find("#role1");
                                $.ajax({
                                    url:"/user?action=queryUserIsRole",	//查询用户是否有角色有返回1,没有返回0
                                    data:{"userid":userid},
                                    type:"post",
                                    success:function(data){
                                        // console.log(data)
                                        var info1 = JSON.parse(data);
                                        console.log(info1.status);
                                        if(info1.status == 200){
                                            var html = '<option value="0">无角色</option>';
                                        }else{
                                            var html = '';
                                        }
                                        $.each(row,function(index,item){
                                            html += '<option value="'+item.id+'">'+item.name+'</option>';
                                        })
                                        role.html(html);
                                        //获取新窗口对象
                                        var iframeWindow = layero.find('iframe')[0].contentWindow;
                                        //重新渲染
                                        iframeWindow.layui.form.render();
                                    }
                                })

                            }
                        })
                        /*------下拉框赋值--------*/
                        //赋值后选中
                        $.ajax({
                            url:"/user?action=allRoleUserid",
                            type:"post",
                            data:{"userid":userid},
                            success:function(data){
                                var info2 = JSON.parse(data);
                                if(info2.status == 200){
                                    var select = 'dd[lay-value="0"]';
                                    body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
                                }else{
                                    var select = 'dd[lay-value='+info2.data.roleid+']';
                                    body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
                                }
                            }
                        })
                        //获取新窗口对象
                        var iframeWindow = layero.find('iframe')[0].contentWindow;
                        //重新渲染
                        iframeWindow.layui.form.render();
                    }
                })
            }
        })
    }

    //删除用户
    function delUser(userid){
        $.ajax({
            url:"/user?action=delUser",
            data:{"userid":userid},
            type:"post",
            success:function(data){
                if(data == 1){
                    layer.msg("删除成功")
                    tableIns.reload("#newsList");
                }
            }
        })
    }


    //分配权限
    function hairMenu(userid){
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
                            url:"/menuByUseridType1",
                            type:"post",
                            data:{"userid":userid},
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
            btn:['分配权限'],
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
                    url:"/menuByUserid",
                    data:{"array":menuidList,"userid":userid},
                    type:"post",
                    traditional:true,
                    success:function(data){
                        var demo = eval('(' + data + ')');
                        if(demo.status == 1){
                            layer.msg(demo.message);
                            layer.close(index)	//关闭
                        }else{
                            layer.msg("分配失败");
                        }
                    }
                })
            }
        })
    }

    //分配角色
    function HairRole(userid){
        layer.open({
            type:1,
            title:"分配角色",
            area:['200px','100px'],
            content:$('#hairRole'),
            success:function(){
                //查询全部角色
                $.ajax({
                    url:"/hairRole",
                    type:"post",
                    dataType:"json",
                    success:function(data){

                    }
                })
            }
        })
    }

    //新增用户
    function addUser(){
        layui.layer.open({
            title : "添加用户",
            type : 2,
            content : "medicine/infoManage/userManage/userAdd.jsp",
            area:['400px','500px'],
        })
    }

})
layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    /*------------- 加载时间 --------------------------------*/
    laydate.render({
        elem: '#ID-laydate-demo'
    });
    /*------------- 加载销售数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#userList',
        url : '/user?action=getAllUser',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [5,10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {title:'操作', width:150, templet: '#barDemo'}

        ]]
    });



})