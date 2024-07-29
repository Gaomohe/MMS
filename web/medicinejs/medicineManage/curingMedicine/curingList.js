layui.use(['layer', 'form', 'table', 'util', 'laydate','element'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    var laydate = layui.laydate;
    var element = layui.element;

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
                minWidth: 120,
                sort: true,
                templet: '#tplStateTbAdv',
                title: '养护状态'
            },
            {
                field: 'tableCoding',
                title: '数据编号',
                minWidth: 200,
                align: 'center',
                sort: true,
                hide:true,
            },
            {
                field: 'mId',
                title: '药品编号',
                minWidth: 200,
                align: 'center',
                sort: true,
                hide:true,
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

    //工具栏
    table.on('toolbar(tableTbAdv)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var tableCoding = '';
        var mId='';
        var arr='';
        for(i=0;i<data.length;i++){
            tableCoding = data[i].tableCoding;
            mId = data[i].mId;
            arr+=data[i].tableCoding+",";
        }
        switch(obj.event){
            case 'time':	//按照养护时间查找
                getTime();
                break;
            case 'addFunc':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    addCuring(tableCoding,mId);
                }
                break;
            case 'upState':
                if(data.length < 1){
                    layer.msg("请选择至少一行数据进行操作")
                    return false;
                }else{
                    upState(arr);
                }
                break;

        };
    });

    function upState(tableCoding){
        $.ajax({
            url: '/curing?action=updateMedicineLastCuringDate',
            type: "POST",
            data: {
                tableCoding
            },
            dataType: "JSON",
            success: function(response) {
                var tableData = response.data;
                location.reload();
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    }

    //时间
    function getTime(){
        // 申请时间
        laydate.render({
            elem: '#time',
            type: 'date',
            done: function(value) {
                applyTime = value;
                if (applyTime.length !== 0 ){
                    getByTime(applyTime);
                }
            }
        });
    }

    //时间搜索
    function getByTime(time){
        $.ajax({
            url:"/curing?action=getCuringByTime",
            data:{
                time
            },
            type:"POST",
            dataType:"JSON",
            success: function(response) {
                // 在成功回调中处理后端返回的数据
                // 假设后端返回的数据是一个数组，可以根据数据格式进行处理
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                renderTable(tableData); // 渲染表格数据
            },
            error: function(error) {
                console.error('Error:', error);
            }
        })
    }

    //名字搜索
    $('#search').off('keypress').on('keypress', function(event) {
        if (event.which === 13) {
            var search = $('#search').val();
            $.ajax({
                url: '/curing?action=getCuringByName',
                type: "POST",
                data: {
                    name: search,
                },
                dataType: "JSON",
                success: function(response) {
                    var tableData = response.data;
                    renderTable(tableData);
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    });

    //点击养护单触发事件
    function addCuring(tableCoding,mId){
        layer.msg('正在跳转...', {
            icon: 16,
            time: 1000,
            shade: 0.01
        }, function() {
            location.href = 'medicine/medicineManage/curingMedicine/curingAdd.jsp?tableCoding='+tableCoding+'&mId='+mId; // 目标页面URL
        });
    }

    //更新页面
    function renderTable(data) {
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#tableTbAdv',
                data: data, // 使用从后端获取的数据渲染表格
                toolbar: '#toolbarDemo',
                page: true,
                height: 600,
                limit: 15,
                limits: [5,10,15,20,25],
                cols: [[
                    {type: 'checkbox'},
                    {
                        field: 'state',
                        align: 'center',
                        minWidth: 120,
                        sort: true,
                        templet: '#tplStateTbAdv',
                        title: '养护状态'
                    },
                    {
                        field: 'tableCoding',
                        title: '数据编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                        hide:true,
                    },
                    {
                        field: 'mId',
                        title: '药品编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                        hide:true,
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
            table.on('toolbar(tableTbAdv)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                var tableCoding = '';
                for(i=0;i<data.length;i++){
                    tableCoding = data[i].tableCoding;
                }
                switch(obj.event){
                    case 'time':	//按照养护时间查找
                        getTime();
                        break;

                };
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
            $('#search').off('keypress').on('keypress', function(event) {
                if (event.which === 13) {
                    var search = $('#search').val();
                    $.ajax({
                        url: '/curing?action=getCuringByName',
                        type: "POST",
                        data: {
                            name: search,
                        },
                        dataType: "JSON",
                        success: function(response) {
                            var tableData = response.data;
                            renderTable(tableData);
                        },
                        error: function(error) {
                            console.error('Error:', error);
                        }
                    });
                }
            });
        });
    }
    // 导出excel
    $('#btnExportTbAdv').click(function () {
        var checkRows = table.checkStatus('tableTbAdv');
        if (checkRows.data.length == 0) {
            layer.msg('请选择要导出的数据', {icon: 2});
        } else {
            table.exportFile(insTb.config.id, checkRows.data, 'xls');
        }
    });

    // 切换Tab重置表格尺寸
    element.on('tab(tableXTab)', function (data) {
        var tableIds = ['tableTbAdv', 'xTable2'];
        table.resize(tableIds[data.index]);
    });
});