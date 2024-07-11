layui.use(['layer', 'form', 'table', 'util', 'laydate'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    var laydate = layui.laydate;

    form.render('select');

    // 渲染表格
    var insTb = table.render({
        elem: '#tableTbAdv',
        url: '/curing?action=getState',
        page: true,
        toolbar:"#toolbarDemo",
        height: 600,
        limit: 15,
        limits: [5,10,15,20,25],
        cols: [[
            {type: 'checkbox'},
            {
                field: 'state',
                align: 'center',
                minWidth: 100,
                sort: true,
                templet: '#tplStateTbAdv',
                title: '养护状态'
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
                field: 'lastCuringDate',
                title: '上次养护日期',
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
                field: 'productDate',
                title: '生产日期',
                minWidth: 200,
                align: 'center',
                sort: true
            },
            {
                field: 'goodsType',
                title: '商品分类',
                minWidth: 200,
                align: 'center',
                sort: true
            },
            {
                field: 'mType',
                title: '药品分类',
                minWidth: 200,
                align: 'center',
                sort: true
            },
            {
                field: 'defined',
                title: '自定义类',
                minWidth: 200,
                align: 'center',
                sort: true
            },
            {
                field: 'drugFrom',
                title: '剂型',
                minWidth: 200,
                align: 'center',
                sort: true
            },
            {
                field: 'placeOrigin',
                title: '产地',
                minWidth: 200,
                align: 'center',
            },
        ]]
    });

    // 搜索
    form.on('submit(formSubSearchTbAdv)', function (data) {
        insTb.reload({where: data.field}, 'data');
    });

    table.on('toolbar(tableTbAdv)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        console.log(data)
        var tableCoding = '';
        for(i=0;i<data.length;i++){
            tableCoding = data[i].tableCoding;
        }
        switch(obj.event){
            case 'time':	//按照养护时间查找
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                delFunc(tableCoding);
                break;

            case 'upFunc':	//修改药品
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upFunc(tableCoding);
                }
                break;

            case 'addFunc':	//删除药品
                addfunc();
                break;
        };
    });

    function getTime(){
        // 申请时间
        laydate.render({
            elem: '#time',
            type: 'date',
            done: function(value) {
                applyTime = value;
                console.log('用户选择的时间：', value);
            }
        });
    }

    // 渲染laydate
    laydate.render({
        elem: '#edtDateTbAdv'
    });

    // 导出excel
    $('#btnExportTbAdv').click(function () {
        var checkRows = table.checkStatus('tableTbAdv');
        if (checkRows.data.length == 0) {
            layer.msg('请选择要导出的数据', {icon: 2});
        } else {
            table.exportFile(insTb.config.id, checkRows.data, 'xls');
        }
    });

});