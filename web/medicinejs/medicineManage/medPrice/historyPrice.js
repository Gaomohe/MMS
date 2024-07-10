layui.use(['layer', 'form', 'table', 'util', 'laydate'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    var laydate = layui.laydate;

    // 渲染表格PriceTable1
    table.render({
        elem: '#priceTable1',
        url: '/medicine?action=getAllMedicine',
        page: true,
        height: 200,
        limit: 5,
        limits: [5,10,15,20,25],
        cols: [
            [{
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
                    field: 'specification',
                    title: '规格',
                    minWidth: 200,
                    align: 'center',
                },
                {
                    field: 'position',
                    title: '货位',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'number',
                    title: '数量',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'usefulLife',
                    title: '有效期',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'purchasePrice',
                    title: '采购价',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'salePrice',
                    title: '销售价',
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
                    field: 'profits',
                    title: '利润金额',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
            ]
        ],
    });

    table.on('row(priceTable1)', function(obj){
        var data = obj.data;
        console.log(obj.tr)
        reloadTable(data.tableCoding);
        reloadTableByMId(data.mId)
    });

    function reloadTable(tableCoding){
        table.render({
            elem: '#priceTable2',
            url: '/price?action=getPriceByTabCod',
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
                        field: 'historyPrice',
                        title: '历史价格',
                        minWidth: 400,
                        align: "center",
                    },
                    {
                        field: 'time',
                        title: '调价时间',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        title:'操作',
                        width:150,
                        templet: '#barDemo1'
                    }
                ]
            ],
        });
    }

    function reloadTableByMId(mId){
        table.render({
            elem: '#priceTable3',
            url: '/price?action=getPriceByMId',
            where:{
                mId: mId,
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
                        field: 'mId',
                        title: '药品编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'historyPrice',
                        title: '历史价格',
                        minWidth: 400,
                        align: "center",
                    },
                    {
                        field: 'time',
                        title: '调价时间',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        title:'操作',
                        width:150,
                        templet: '#barDemo2'
                    }
                ]
            ],
        });
    }
    table.on('tool(priceTable2)', function(obj){
        var data = obj.data;
        var id = data.id;
        switch(obj.event){
            case 'del':
                del(id);
                break;
        }
    });
    table.on('tool(priceTable3)', function(obj){
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
            url:"/price?action=delPrice",
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