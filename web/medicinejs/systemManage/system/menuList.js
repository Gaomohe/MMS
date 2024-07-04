layui.use(['layer','table', 'treeTable'], function () {
    var $ = layui.jquery;
    var table = layui.table;
    var treeTable = layui.treeTable;
    var layer = layui.layer;

    // 渲染表格
    var insTb = treeTable.render({
        elem: '#demoTreeTb',
        url: '/menu?action=getResource',/*   getResource*/
        toolbar: '#menutoolbarDemo',
        height: 'full-115',
        tree: {
            iconIndex: 2,           // 折叠图标显示在第几列
            isPidData: true,        // 是否是id、pid形式数据
            idName: 'authorityId',  // id字段名称
            pidName: 'parentId'     // pid字段名称
        },
        cols: [[
            {field: 'authorityId', title: '权限编号',width:10},
            {type: 'radio'},
            {field: 'authorityName', title: '权限名称'},
            {field: 'authority', title: '权限标识'},
            {field: 'isMenu', width: 80, align: 'center', title: '类型', templet: function (d) {
                    if (d.isMenu == 2) {
                        return '<span class="layui-badge layui-bg-orange">按钮</span>';
                    }
                    if (d.parentId == -1) {
                        return '<span class="layui-badge layui-bg-blue">目录</span>';
                    } else {
                        return '<span class="layui-badge layui-bg-green">菜单</span>';
                    }
                }}
        ]]
    });

    //监听工具栏
    treeTable.on('toolbar(demoTreeTb)', function(obj){
        switch(obj.event){
            case 'btn-expand':	//全部展开
                insTb.expandAll('#demoTreeTb');
                break;

            case 'btn-fold':	//全部折叠
                insTb.foldAll('#demoTreeTb');
                break;

            case 'addMenu':	//新增权限
                layui.layer.open({
                    title : "添加权限",
                    type : 2,
                    content : "medicine/systemManage/system/menuAdd.jsp",
                    area:['600px','500px'],
                })
                break;

            case 'upMenu':	//修改权限
                updataMenu();
                break;

            case 'delMenu':	//删除权限
                layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
                    delMenu();
                    layer.close(index);
                });
                break;
        };
    });

    /*case 'addMenu':	//新增权限
                 layui.layer.open({
                     title : "添加权限",
                     type : 2,
                     content : "admin/page/system/menu/menuAdd.jsp",
                     area:['600px','500px'],
                 })
                 break;*/

    function add(){
        layer.open({
            type:2,

        })
    }

    //---------删除权限-------
    function delMenu(){
        var menuid = '';
        JSON.stringify(insTb.checkStatus().map(function (d) {
            menuid = d.authorityId;
        }));
        if(menuid == null || menuid == ""){
            layer.msg("请选中一个节点进行删除");
        }else{
            $.ajax({
                url:"/menu",
                data:{
                    action:"delMenu",
                    "menuid":menuid
                },
                type:"post",
                dataType:"json",
                success:function(data){
                    //var info = eval("("+data+")");
                    if(data.status == 200){
                        layer.msg("删除成功");
                        insTb.reload();
                    }else{
                        layer.msg("删除失败");
                    }
                }
            })
        }
    }

    /*---------修改权限------*/
    function updataMenu(){
        var authorityId = '';
        JSON.stringify(insTb.checkStatus().map(function (d) {
            authorityId = d.authorityId;
        }));
        if(authorityId == null || authorityId==""){
            layer.msg('请选择一个进行修改');
        }else{
            layer.open({
                type:2,
                title:"修改权限",
                area:['700px','600px'],
                content:"medicine/systemManage/system/menuInfo.jsp",
                success:function(layero, index){
                    $.post("/menu?action=allMenuById",
                        {"menuid":authorityId},
                        function(data){
                            var info = JSON.parse(data);
                            console.log(info)

                            var body = layui.layer.getChildFrame('body', index);
                            body.find("#mid").val(info.data.resId);
                            body.find("#mname").val(info.data.name);  //权限名
                            body.find("#mfunction").val(info.data.resKey);	//请求路径
                            var select = 'dd[lay-value='+info.data.type+']';
                            body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
                            body.find("#mbtn").val(info.data.resUrl);		//按钮代码
                            body.find("#icon").val(info.data.icon);		//icon图标
                            var menuid3 = info.data.resId;
                            //上级的下拉框
                            $.post("/menu?action=allMenuById",{"menuid":menuid3},function(res){
                                var cs = JSON.parse(res);
                                console.log(cs);
                                body.find("#fatherType2").val(cs.data.fatherName);
                                console.log(cs);
                            })

                        })
                }
            })
        }
    };
});