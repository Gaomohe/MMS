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
    laydate.render({
        elem: '#ID-laydate-demo'
    });

    //表格渲染
    var tableIns = table.render({
        elem: '#financialList',
        url : '/purchase?action=getAllAppoint',
        cellMinWidth : 95,
        page : true,
        toolbar: '#financialDemo',
        height : "600px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'mId', title: '字典编号',  align:'center'},
            {field: 'mName', title: '药品名称', minWidth:100, align:"center"},
            {field: 'specification', title: '规格', align:'center'},
            {field: 'manufactor', title: '生产企业', align:'center'},
            {field: 'unit', title: '单位', minWidth:100, align:"center"},
            {field: 'department', title: '部门',  align:'center'},
            // {field: 'number', title: '采购数量',  align:'center'},
            {field: 'applyNumber', title: '采购数量',  align:'center'},
            {field: 'purchasePrice', title: '采购价',  align:'center'},
            {field: 'code', title: '批号',  align:'center'},
            {field: 'mType', title: '药品分类',  align:'center'},
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
            {field: 'financeTime' ,title:'财务审批时间', align:'center'}
        ]],
        done:function (){

        }
    });

    table.on('toolbar(supplierList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var supplierId = '';
        for(i=0;i<data.length;i++){
            supplierId = data[i].sid;//这里得和上面的field里的id名对应
        }
        switch(obj.event){

        }

    });


    //监听工具栏
    treeTable.on('toolbar(financialList)', function(obj){
        switch(obj.event){
            case 'applyUser':

                applyUser();
                break;

            case 'status':	//全部折叠
                insTb.foldAll('#demoTreeTb');
                break;

            case 'pharmacist':	//新增权限
                getPharmacist();
                break;

            case 'financial':	//修改权限
                updataMenu();
                break;

            case 'search':	//删除权限
                layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
                    delMenu();
                    layer.close(index);
                });
                break;
            case 'reload':	//删除权限
                layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
                    delMenu();
                    layer.close(index);
                });
                break;
            case 'del':	//删除权限
                layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
                    delMenu();
                    layer.close(index);
                });
                break;
            case 'approve':	//删除权限
                layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
                    delMenu();
                    layer.close(index);
                });
                break;
            case 'unapprove':	//删除权限
                layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
                    delMenu();
                    layer.close(index);
                });
                break;
            case 'download':	//删除权限
                layer.confirm('确定删除此权限吗?', {icon: 3, title:'提示'}, function(index){
                    delMenu();
                    layer.close(index);
                });
                break;
        };
    });

    function applyUser(){
        $.post("/user?action=getAppUser",function(res){
            var cs = JSON.parse(res);
            console.log(cs);
            body.find("#applyUser").val(cs.data.userName);
            console.log(cs);
        })
    }

    $.post("/user?action=getAppUser",
        {"menuid":authorityId},
        function(data) {
            var info = JSON.parse(data);
            console.log(info)
            var body = layui.layer.getChildFrame('body', index);
            body.find("#mid").val(info.data.resId);
            body.find("#mname").val(info.data.name);  //权限名
            body.find("#mfunction").val(info.data.resKey);	//请求路径
            var select = 'dd[lay-value=' + info.data.type + ']';
            body.find("#type2").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
            body.find("#mbtn").val(info.data.resUrl);		//按钮代码
            body.find("#icon").val(info.data.icon);		//icon图标
            var menuid3 = info.data.resId;
            //上级的下拉框
            $.post("/menu?action=allMenuById", {"menuid": menuid3}, function (res) {
                var cs = JSON.parse(res);
                console.log(cs);
                body.find("#fatherType2").val(cs.data.fatherName);
                console.log(cs);
            })
        }
    )


});