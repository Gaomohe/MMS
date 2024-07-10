
layui.use(['layer', 'element', 'util', 'table', 'tableX','mousewheel','form'], function() {
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var util = layui.util;
    var table = layui.table;
    var tableX = layui.tableX;
    var layer = layui.layer;
    var form = layui.from;

    tableX.render({
        elem: '#xTable1',
        url: '/price?action=getPriceByTabCod',
        page: true,
        height: 600,
        limit: 15,
        limits: [5,10,15,20,25],
        cols: [
            [{fixed: "left",
                type: "checkbox",
                width: 50
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
                    templet: '#barDemo'
                }
            ]
        ],
    });

    table.on('tool(barDemo)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var tableCoding="";
        var salePrice="";
        for(i=0;i<data.length;i++){
            tableCoding = data[i].tableCoding;
            salePrice = data[i].salePrice;

        }
        switch(obj.event){
            case 'upPrice':	//修改药价
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upPrice(tableCoding,mId,salePrice);
                }
                break;

            case 'backPrice':	//删除药品
                backPrice(tableCoding);

                break;

        };
    });
});
