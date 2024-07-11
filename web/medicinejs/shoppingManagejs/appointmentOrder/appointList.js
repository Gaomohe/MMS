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

    var counts = 0;
    var total = 0;
    let idList = new Set();

    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#appointList',
        url : '/appoint?action=getAllAppoint',
        toolbar: '#appointDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [5,10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'applyId', title: '申请编号',  align:'center',width:200},
            {field: 'mId', title: '字典编号',  align:'center',width:200},
            {field: 'mName', title: '药品名称', minWidth:100, align:"center",width:200},
            {field: 'specification', title: '规格', align:'center',width:200},
            {field: 'manufactor', title: '生产企业', align:'center',width:200},
            {field: 'unit', title: '单位', minWidth:100, align:"center",width:200},
            {field: 'department', title: '部门',  align:'center',width:200},
            // {field: 'number', title: '采购数量',  align:'center'},
            {field: 'applyNumber', title: '采购数量',  align:'center',width:200},
            {field: 'purchasePrice', title: '采购价',  align:'center',width:200},
            {field: 'code', title: '批号',  align:'center',width:200},
            {field: 'mType', title: '药品分类',  align:'center',width:200},
            {field: 'supplier', title: '供货单位',  align:'center'},
            {field: 'approvalNumber', title: '准批文号',  align:'center'},
            {field: 'placeOrigin', title: '产地',  align:'center'},
            {field: 'applyUser' ,title:'申请人', align:'center'},
            {field: 'applyTime' ,title:'申请时间', align:'center'},
            {field: 'pharmacist' ,title:'药师审批人', align:'center'},
            {field: 'pharmacistApprove' ,title:'药师审批', align:'center'},
            {field: 'pharmacistTime' ,title:'药师审批时间', align:'center'},
            {field: 'finance' ,title:'财务审批人', align:'center'},
            {field: 'financeApprove' ,title:'财务审批', align:'center'},
            {field: 'financeTime' ,title:'财务审批时间', align:'center'},
            {field: 'tableCoding' ,title:'自编码', align:'center'}
        ]]
    });
    /*------------- 加载用户数据 --end------------------------------*/

    /*-------- 搜索用户 ----------------------------*/
    $("#doSubmit").click(function(){
        var like = $("#likename").val()
        tableIns.reload({
            url:"http://localhost:8723/EEDemo/Interfaces?action=allUser&uname="+like,
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })

    table.on('toolbar(appointList)',function (obj) {
        var checkdata= table.checkStatus(obj.config.id)
        var files= checkdata.data;
        console.log(obj);
        switch (obj.event) {
            case 'delAppoint':
                if (files.length > 0) {
                    files.forEach(function(file) {
                        // 假设每个file对象都有一个id属性，用于标识用户
                        total++;
                        del(file.mId);
                    });
                } else {
                    layer.msg("you are not select", {icon: 2});
                }
                break;
            case 'addAppoint':
                if (files.length > 0) {
                    files.forEach(function(file) {
                        // 假设每个file对象都有一个id属性，用于标识用户
                        total++;
                        idList.add(file.mId)
                    });
                    console.log("aaaaaaa");
                    console.log(idList);
                    console.log("aaaaaaa");
                    let idListArray = Array.from(idList);
                    console.log(idListArray); // 输出：[1, 2]
                    addAppoint(idListArray);

                } else {
                    layer.msg("请选择要添加的预约", {icon: 2});
                }
                break;
            case 'upAppoint':
                // selectByIdUser(files[0].id,files[0].name);
                upAppoint(files[0].id);
                break;
            case 'selectDesc':

                break;
            case 'uploadUser':
                upLoad();
                break;
        }
    });

    //删除
    function del(ids) {
        $.ajax({
            url: "/appoint?action=delAppoint",
            data: { "ids": ids },
            type: "post",
            dataType: "json",
            traditional: true,
            success: function(res) {
                console.log("res");
                console.log(res);
                console.log(res.status);
                counts++;
                console.log(counts);
                console.log(total);
                if (counts == total) {
                    if (res.status) {
                        layer.msg("删除成功", { icon: 1 });
                        tableIns.reload();
                    } else {
                        layer.msg("删除失败", { icon: 2 });
                    }
                }
            }
        });
    }

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

    //新增订单
    function addAppoint(idsList){
        console.log("ssssssssssssssss");
        console.log(idsList);
        console.log("ssssssssssssssss");
        $.ajax({
            url: "/appoint?action=addAppoint",
            data: { "idsList": idsList },
            type: "post",
            dataType: "json",
            traditional: true,
            success: function(res) {
                console.log("res");
                console.log(res);
                console.log(res.status);
                counts++;
                console.log(counts);
                console.log(total);
                if (counts == total) {

                }
                if (res.status==200) {
                    layer.msg("添加成功", { icon: 1 });
                    tableIns.reload();
                } else {
                    layer.msg("添加失败", { icon: 2 });
                }
            }
        });
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

    //修改用户
    function upAppoint(userid){
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