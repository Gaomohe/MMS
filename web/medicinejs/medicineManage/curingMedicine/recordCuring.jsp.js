layui.use(['layer', 'form', 'table', 'util', 'laydate'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    var laydate = layui.laydate;

    // 渲染表格PriceTable1
    table.render({
        elem: '#curingTable1',
        url: '/medicine?action=getAllMedicine',
        page: true,
        height: 200,
        limit: 5,
        limits: [5,10,15,20,25],
        cols: [
            [{
                fixed: "left",
                type: "checkbox",
                width: 50
            },
                {
                    field: 'tableCoding',
                    title: '数据编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'mId',
                    title: '药品编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'mName',
                    title: '药品名称',
                    minWidth: 400,
                    align: "center",
                },
                {
                    field: 'usefulLife',
                    title: '有效期',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'productDate',
                    title: '生产日期',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'locationDescription',
                    title: '货位说明',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'lastCuringDate',
                    title: '上次养护日期',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
            ]
        ],
    });

    table.on('row(curingTable1)', function(obj){
        var data = obj.data;
        console.log(obj.tr)
        reloadTable(data.tableCoding);
    });

    function reloadTable(tableCoding){
        table.render({
            elem: '#curingTable2',
            url: '/curing?action=getCuringByTab',
            where:{
                tableCoding: tableCoding,
            },
            page: true,
            height: 400,
            limit: 5,
            limits: [5,10,15,20,25],
            cols: [
                [
                    {
                        field: 'id',
                        title: '数据编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'tableCoding',
                        title: '药品数据编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'mId',
                        title: '药品编号',
                        minWidth: 400,
                        align: "center",
                    },
                    {
                        field: 'content',
                        title: '养护信息',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        field: 'time',
                        title: '养护时间',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        title:'操作',
                        width:150,
                        templet: '#barDemo'
                    }
                ]
            ],
        });
    }

    table.on('tool(curingTable2)', function(obj){
        var data = obj.data;
        var id = data.id;
        switch(obj.event){
            case 'del':
                del(id);
                break;
        }
    });

    function del(id){
        $.ajax({
            url:"/curing?action=delCuring",
            type:"post",
            data:{"id":id},
            success:function(data){
                var info = JSON.parse(data);
                if(info.status == 200){
                    console.log(info.status)
                    layer.msg("删除成功");
                    location.reload();
                }
            }
        })
    }





});