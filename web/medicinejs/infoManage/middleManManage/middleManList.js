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
        elem: '#middleManList',
        url : '/middleMan?action=selectMiddleMan',
        cellMinWidth : 95,
        page : true,
        toolbar: '#middleManDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'workId', title: '经手人工号',  align:'center',width:100},
            {field: 'mName', title: '经手人姓名',  align:'center',width:100},
            {field: 'tel', title: '电话', width:150, align:"center"},
            {field: 'email', title:'邮箱' , width:150, align:"center"},
            {field: 'department', title:'部门' , width:150, align:"center"},
            {field: 'medName', title:'经手药品名' , width:150, align:"center"},
            {field: 'standard', title:'药品规格' , width:150, align:"center"},
            {field: 'medNum', title:'经手数量' , width:150, align:"center"},
            {field: 'date', title:'经手时间' , width:150, align:"center"},
            {field: 'place', title:'经手地点' , width:150, align:"center"},
            {field: 'supplierName', title:'供货商名称' , width:150, align:"center"}
        ]]
    });

    //工具栏事件
    table.on('toolbar(middleManList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var workId = '';
        for(i=0;i<data.length;i++){
            workId = data[i].id;
        }
        switch(obj.event){
            case 'delMiddleMan':	//删除经手人
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('删除经手人后用户对应的权限也会删除,确定删除吗?', {icon: 3, title:'提示'}, function(index){
                    delMiddleMan(workId);
                    layer.close(index);
                });
                break;

            case 'upMiddleMan':	//修改经手人
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upMiddleMan(workId);
                }
                break;

            case 'addMiddleMan':	//新增经手人
                addMiddleMan();
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
    function delMiddleMan(workId){
        $.ajax({
            url:"/middleMan?action=delMiddleMan",
            type:"post",
            data:{"workId":workId},
            success:function(data){
                var info = JSON.parse(data);
                if(info.status == 200){
                    layer.msg("删除成功");
                    tableIns.reload("#middleManList");
                }
            }
        })
    }

    //修改供应商
    function upMiddleMan(workId){
        layui.layer.open({
            title : "修改经手人信息",
            type : 2,
            content : "medicine/infoManage/middleManManage/middleManInfo.jsp",
            area:['350px','230px'],
            success:function(layero, index){
                $.ajax({
                    url:"/middleMan?action=selectMiddleManById",//根据id查询的方法
                    type:"post",
                    data:{"workId":workId},
                    success:function(data){
                        var info = JSON.parse(data);
                        console.log(info);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#workId").val(info.data.id);
                        body.find("#mName2").val(info.data.name);
                        body.find("#mName").val(info.data.name);
                        body.find("#tel").val(info.data.tel);
                        body.find("#email").val(info.data.email);
                        body.find("#department").val(info.data.department);
                        body.find("#medName").val(info.data.medName);
                        body.find("#standard").val(info.data.standard);
                        body.find("#medNum").val(info.data.medNum);
                        body.find("#date").val(info.data.date);
                        body.find("#place").val(info.data.place);
                        body.find("#supplierName").val(info.data.supplierName);
                    }
                })
                /*        			//获取新窗口对象
                                    var iframeWindow = layero.find('iframe')[0].contentWindow;
                                    //重新渲染
                                    iframeWindow.layui.form.render();*/
            }
        });
    }

    //新增经手人
    function addMiddleMan(){
        layui.layer.open({
            title : "新增经手人",
            type : 2,
            content : "medicine/infoManage/middleManManage/middleManAdd.jsp",
            area:['400px','500px'],
        });
    }

})