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
        elem: '#shoppList',
        url : '/shopping?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#shoppDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'mId', title: '药品编号',  align:'center'},
            {field: 'mName', title: '药品名称',  align:'center'},
            {field: 'specification', title: '规格',  align:'center'},
            {field: 'number', title: '库存',  align:'center'},
            {field: 'purchasePrice', title: '价格',  align:'center'},
            {field: 'manufactor', title: '供应商',  align:'center'},
            {field: 'drugFrom', title: '类别',  align:'center'},
            {field: 'opera', title: '操作',  align:'center',templet:function (d){
                    return '<a href="/shopping?action=select&mId=' + d.mId + '" class="layui-btn layui-btn-xs">查询</a>';
                }},

        ]],
    });

    //工具栏事件
    table.on('toolbar(shoppList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var id = '';
        for(i=0;i<data.length;i++){
            id = data[i].id;
        }

        switch(obj.event){
            case 'time':	//修改经手人
                laydate.render({
                    elem: '#ID-laydate-demo',
                    done:function (value){
                        $.ajax({
                            url:"/shopping?action=time",//根据id查询的方法
                            type:"post",
                            data:{value},
                            dataType:'JSON',
                            success:function (data){
                                if (data.code===0){
                                    tableIns.reload({
                                        data:data.data
                                    })
                                }
                            }

                        })
                    }
                });
                break;

            case 'add':	//新增经手人
                add(id);
                break;
            case 'submit':
                var searchInput = document.getElementById('searchInput');
                $.ajax({
                    url:"/shopping?action=search",//根据id查询的方法
                    type:"post",
                    data:{searchInput},
                    dataType:'JSON',
                    success:function (data){
                        if (data.code===0){
                            // tableIns.reload({
                            //     data:data.data
                            // })
                        }
                    }

                })
                break;
        }
    });
    function add(id){
        layui.layer.open({
            title : "申请",
            type : 2,
            content : "medicine/shoppingManage/requestApply/applyList.jsp",
            area:['800px','500px'],
            success:function(layero, index){
                $.ajax({
                    url:"/shopping?action=selectById",//根据id查询的方法
                    type:"post",
                    data:{id},
                    success:function(data){
                        var info = JSON.parse(data);
                        console.log(info);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#id").val(info.data.id);
                        body.find("#number").val(info.data.number);
                        body.find("#name").val(info.data.name);
                        body.find("#purchasePrice").val(info.data.purchasePrice);
                    }
                })
            }
        });
    }




})