layui.use(['layer', 'element', 'util', 'table', 'tableX','mousewheel','form','laydate'], function() {
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var util = layui.util;
    var table = layui.table;
    var tableX = layui.tableX;
    var layer = layui.layer;
    var form = layui.from;
    var laydate = layui.laydate;


    // 前端分页
    var tableIns=tableX.render({
        elem: '#xTable2',
        height: 600,
        page:true,
        url: '/warning?action=getWarnDatailByWid&wId=1',
        cols: [
            [{fixed: "left",
                type: "checkbox",
                width: 50
            },
                {
                    field: 'id',
                    title: '数据编号',
                    minWidth: 200,
                    align: 'center',
                },
                {
                    field: 'number',
                    title: '此批次总数',
                    minWidth: 200,
                    align: 'center',
                },
                {
                    field: 'usefulLife',
                    title: '有效期',
                    minWidth: 200,
                    align: 'center',
                },
                {
                    field: 'uName',
                    title: '入库操作人',
                    minWidth: 200,
                    align: 'center',
                },
                {
                    field: 'time',
                    title: '操作时间',
                    minWidth: 200,
                    align: 'center',
                },
                {
                    field: 'uId',
                    title: '操作人id',
                    minWidth: 200,
                    align: 'center',
                    hide: true,
                },
                {
                    field: 'wid',
                    title: '总表Id',
                    minWidth: 200,
                    align: 'center',
                    hide: true,
                },
            ]
        ],
    });

});