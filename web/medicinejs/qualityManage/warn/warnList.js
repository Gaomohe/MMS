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
        elem: '#xTable1',
        url: '/warning?action=getWarnAll',
        toolbar: '#toolbarDemo',
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
                    field: 'id',
                    title: '数据编号',
                    minWidth: 50,
                    align: 'center',
                    hide: true,
                },
                {
                    field: 'mName',
                    title: '药品名称',
                    minWidth: 100,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'tableCoding',
                    title: '药品数据编号',
                    minWidth: 10,
                    align: 'center',
                    sort: true,
                    hide: true,
                },
                {
                    field: 'tolNumber',
                    title: '总数',
                    minWidth: 50,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'warnNumber',
                    title: '预警值',
                    minWidth: 50,
                    align: "center",
                    sort: true,
                },
                {
                    field: 'name',
                    title: '操作人',
                    minWidth: 50,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'time',
                    title: '操作时间',
                    minWidth: 100,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'uId',
                    title: '操作人id',
                    minWidth: 10,
                    align: 'center',
                    sort: true,
                    hide: true,
                },
            ]
        ],
    });

    table.on('toolbar(xTable1)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var id='';
        var warnNumber='';
        for(i=0;i<data.length;i++){
           id = data[i].id;
           warnNumber = data[i].warnNumber;
        }
        switch(obj.event){
            case 'time':	//按照时间查找
                getTime();
                break;
            case 'delFunc':
                var i = 0;
                for(i=0;i<data.length;i++){
                    id = data[i].id;
                    delFunc(id);
                }
                if (i=data.length){
                    layer.msg("删除成功")
                    setTimeout(function (){location.reload()},2000);
                }
                break;
            case 'upFunc':
                var i = 0;
                if (data.length != 1){
                    layer.msg("请选择一条数据")
                }else {
                    upFunc(id,warnNumber)
                }
                break;
            case 'addFunc':
                var i = 0;
                if (data.length != 1){
                    layer.msg("请选择一条数据")
                }else {
                    addFunc(id);
                }
                break;
        };
    });
    table.on('row(xTable1)', function(obj){
        var data = obj.data;
        $.ajax({
            url: '/warning?action=getWarnDatailByWid',
            type: "POST",
            data: {
                wId:data.id,
            },
            dataType: "JSON",
            success: function(response) {
                var tableData = response.data;
                renderTable2(tableData);
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
        renderTable2(data.applyId);
    });
    //查询方法
    function renderTable(data) {
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#xTable1',
                data: data, // 使用从后端获取的数据渲染表格
                toolbar: '#toolbarDemo',
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
                            field: 'id',
                            title: '数据编号',
                            minWidth: 50,
                            align: 'center',
                            hide: true,
                        },
                        {
                            field: 'mName',
                            title: '药品名称',
                            minWidth: 100,
                            align: 'center',
                            sort: true,
                        },
                        {
                            field: 'tableCoding',
                            title: '药品数据编号',
                            minWidth: 10,
                            align: 'center',
                            sort: true,
                            hide: true,
                        },
                        {
                            field: 'tolNumber',
                            title: '总数',
                            minWidth: 50,
                            align: 'center',
                            sort: true,
                        },
                        {
                            field: 'warnNumber',
                            title: '预警值',
                            minWidth: 50,
                            align: "center",
                            sort: true,
                        },
                        {
                            field: 'name',
                            title: '操作人',
                            minWidth: 50,
                            align: 'center',
                            sort: true
                        },
                        {
                            field: 'time',
                            title: '操作时间',
                            minWidth: 100,
                            align: 'center',
                            sort: true,
                        },
                        {
                            field: 'uId',
                            title: '操作人id',
                            minWidth: 10,
                            align: 'center',
                            sort: true,
                            hide: true,
                        },
                    ]
                ],
            });
            table.on('toolbar(xTable1)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                var tableCoding = '';
                var totlNumber="";
                var id='';
                var arr='';
                var oId='';
                for(i=0;i<data.length;i++){
                    arr+=data[i].tableCoding+",";
                }
                switch(obj.event){
                    case 'time':	//按照养护时间查找
                        getTime();
                        break;
                    case 'delFunc':
                        var i = 0;
                        for(i=0;i<data.length;i++){
                            id = data[i].id;
                            delFunc(id);
                        }
                        if (i=data.length){
                            layer.msg("删除成功")
                            setTimeout(function (){location.reload()},2000);
                        }
                        break;
                    case 'addFunc':
                        var i = 0;
                        for(i;i<data.length;i++){
                            id = data[i].id;
                            oId = data[i].orderId;
                            addFunc(oId,id,1);
                            delFuncByOid(oId)
                        }
                        if (i=data.length){
                            layer.msg("删除成功")
                            setTimeout(function (){location.reload()},2000);
                        }
                        break;
                    case 'issue':
                        var i = 0;
                        if (data.length != 1){
                            layer.msg("请选择一条数据")
                        }else {
                            for(i;i<data.length;i++){
                                tableCoding = data[i].tableCoding;
                                id = data[i].id;
                                oId = data[i].orderId;
                                layer.confirm('是否要单退此药品？', {icon: 3}, function(){
                                    var a = addFunc(oId,id,2);
                                    issue(tableCoding);
                                    if (a = 1){
                                        delFunc(id);
                                    }
                                }, function(){
                                    issue(tableCoding,id);
                                });

                            }
                        }
                        break;
                };
            });
            $('#search').off('keypress').on('keypress', function(event) {
                if (event.which === 13) {
                    var search = $('#search').val();
                    $.ajax({
                        url: '/warning?action=getWarnsByMname',
                        type: "POST",
                        data: {
                            mName: search,
                            sql:1,
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
    //表2
    function renderTable2(data) {
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#xTable2',
                height: 600,
                page:true,
                data: data, // 使用从后端获取的数据渲染表格
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
                            hide: true,
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
    }
    //名称搜索
    $('#search').off('keypress').on('keypress', function(event) {
        if (event.which === 13) {
            var search = $('#search').val();
            $.ajax({
                url: '/warning?action=getWarnsByMname',
                type: "POST",
                data: {
                    mName: search,
                    sql:1,
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
    //时间搜索
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
    function getByTime(time){
        $.ajax({
            url:"/warning?action=getWarnsByTime",
            data:{
                time,
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
    //删
    function upFunc(id,warnNumber){
        layer.open({
            type: 2,
            area: ['420px', '240px'], // 宽高
            title: false,
            content:"medicine/qualityManage/imminentWarning/warnInfo.jsp?id="+id+"&warnNumber="+warnNumber,
            move: '#test-page-move'
        });
    }
    //发出信息
    function addFunc(wId){
        layer.open({
            type: 2,
            area: ['420px', '240px'], // 宽高
            title: false,
            content:"medicine/qualityManage/imminentWarning/massageAdd.jsp?wId="+wId,
            move: '#test-page-move'
        });
    }

});