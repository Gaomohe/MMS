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
        url: '/quality?action=getQualityBySS&storageStatus=已入库',
        toolbar: '#toolbarDemo2',
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
                    title: '质检数据编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                    hide: true,
                },
                {
                    field: 'statue',
                    title: '质检状态',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                    templet: '#tplStateTbAdv',
                },
                {
                    field: 'tableCoding',
                    title: '药品数据编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                    hide: true,
                },
                {
                    field: 'mId',
                    title: '药品编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                    hide: true,
                },
                {
                    field: 'mName',
                    title: '药品名称',
                    minWidth: 400,
                    align: "center",
                },
                {
                    field: 'totlNumber',
                    title: '本批入库数量',
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
                    field: 'surveyNumber',
                    title: '抽样数量',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'goodsType',
                    title: '商品分类',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'mType',
                    title: '药品分类',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'defind',
                    title: '自定义分类',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'drugFrom',
                    title: '剂型',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'warehousingRemarks',
                    title: '仓库标注',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'storageStatus',
                    title: '入库状态',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'time',
                    title: '质检时间',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
            ]
        ],
    });

    table.on('toolbar(xTable2)', function(obj){
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
            case 'time2':	//按照养护时间查找
                getTime();
                break;
            case 'delFunc':
                var i = 0;
                for(i=0;i<data.length;i++){
                    id = data[i].id;
                    console.log(delFunc(id));
                }
                if (i=data.length){
                    layer.msg("删除成功")
                    setTimeout(function (){location.reload()},2000);
                }
                break;
            case 'issue':
                var i = 0;
                for(i;i<data.length;i++){
                    tableCoding = data[i].tableCoding;
                    id = data[i].id;
                    oId = data[i].orderId;
                    layer.confirm('是否要单退此药品？', {icon: 3}, function(){
                        addFunc(oId,id,2);
                        issue(tableCoding);
                        /*delFunc(id);*/
                    }, function(){
                        issue(tableCoding);
                        /*delFunc(id);*/
                    });

                }
                break;
        };
    });
    //搜索
    $("#searchByQuerys2").click(function () {
        select1 = $("#select21").val();
        select2 = $("#select22").val();
        select3 = $("#select23").val();
        select4 = $("#select24").val();
        sql = 2;
        $.ajax({
            url: '/quality?action=getQualityByQuery', // 后端处理数据的URL
            type: "POST", // 或 'GET'，取决于后端接口的要求
            data: {
                select1,
                select2,
                select3,
                select4,
                sql,
            },
            dataType:"JSON",
            success: function(response) {
                // 在成功回调中处理后端返回的数据
                // 假设后端返回的数据是一个数组，可以根据数据格式进行处理
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                renderTable1(tableData); // 渲染表格数据
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    });
    //查询方法
    function renderTable1(data) {
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#xTable2',
                data: data, // 使用从后端获取的数据渲染表格
                toolbar: '#toolbarDemo2',
                page: true,
                height: 600,
                limit: 15,
                limits: [5,10,15,20,25],
                cols: [ [
                    {fixed: "left",
                        type: "checkbox",
                        width: 50
                    },
                    {
                        field: 'id',
                        title: '质检数据编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                        hide: true,
                    },
                    {
                        field: 'statue',
                        title: '质检状态',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                        templet: '#tplStateTbAdv',
                    },
                    {
                        field: 'tableCoding',
                        title: '药品数据编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                        hide: true,
                    },
                    {
                        field: 'mId',
                        title: '药品编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                        hide: true,
                    },
                    {
                        field: 'mName',
                        title: '药品名称',
                        minWidth: 400,
                        align: "center",
                    },
                    {
                        field: 'totlNumber',
                        title: '本批入库数量',
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
                        field: 'surveyNumber',
                        title: '抽样数量',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                    },
                    {
                        field: 'goodsType',
                        title: '商品分类',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                    },
                    {
                        field: 'mType',
                        title: '药品分类',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'defind',
                        title: '自定义分类',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                    },
                    {
                        field: 'drugFrom',
                        title: '剂型',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'warehousingRemarks',
                        title: '仓库标注',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'storageStatus',
                        title: '入库状态',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'time',
                        title: '质检时间',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                ]
                ],
            });
            table.on('toolbar(xTable2)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                var tableCoding = '';
                var id='';
                var arr='';
                for(i=0;i<data.length;i++){
                    tableCoding = data[i].tableCoding;
                    arr+=data[i].tableCoding+",";
                }
                table.on('toolbar(xTable2)', function(obj){
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
                                console.log(delFunc(id));
                            }
                            if (i=data.length){
                                layer.msg("删除成功")
                                setTimeout(function (){location.reload()},2000);
                            }
                            break;
                        case 'issue':
                            var i = 0;
                            for(i;i<data.length;i++){
                                tableCoding = data[i].tableCoding;
                                id = data[i].id;
                                oId = data[i].orderId;
                                layer.confirm('是否要单退此药品？', {icon: 3}, function(){
                                    addFunc(oId,id,2);
                                    issue(tableCoding);
                                    /*delFunc(id);*/
                                }, function(){
                                    issue(tableCoding);
                                    /*delFunc(id);*/
                                });

                            }
                            break;
                    };
                });
            });
            $("#searchByQuerys2").click(function () {
                select1 = $("#select21").val();
                select2 = $("#select22").val();
                select3 = $("#select23").val();
                select4 = $("#select24").val();
                sql = 2;
                $.ajax({
                    url: '/quality?action=getQualityByQuery', // 后端处理数据的URL
                    type: "POST", // 或 'GET'，取决于后端接口的要求
                    data: {
                        select1,
                        select2,
                        select3,
                        select4,
                        sql,
                    },
                    dataType:"JSON",
                    success: function(response) {
                        // 在成功回调中处理后端返回的数据
                        // 假设后端返回的数据是一个数组，可以根据数据格式进行处理
                        var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                        renderTable1(tableData); // 渲染表格数据
                    },
                    error: function(error) {
                        console.error('Error:', error);
                    }
                });
            });
            $('#search2').off('keypress').on('keypress', function(event) {
                if (event.which === 13) {
                    var search = $('#search').val();
                    $.ajax({
                        url: '/quality?action=getQualityBymName',
                        type: "POST",
                        data: {
                            mName: search,
                            sql:2,
                        },
                        dataType: "JSON",
                        success: function(response) {
                            var tableData = response.data;
                            renderTable1(tableData);
                        },
                        error: function(error) {
                            console.error('Error:', error);
                        }
                    });
                }
            });
        });
    }

    $('#search2').off('keypress').on('keypress', function(event) {
        if (event.which === 13) {
            var search = $('#search2').val();
            $.ajax({
                url: '/quality?action=getQualityBymName',
                type: "POST",
                data: {
                    mName: search,
                    sql:2,
                },
                dataType: "JSON",
                success: function(response) {
                    var tableData = response.data;
                    console.log(tableData);
                    renderTable1(tableData);
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    });

    function getTime(){
        // 申请时间
        laydate.render({
            elem: '#time2',
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
            url:"/quality?action=getQualityByTime",
            data:{
                time,
                sql:2
            },
            type:"POST",
            dataType:"JSON",
            success: function(response) {
                // 在成功回调中处理后端返回的数据
                // 假设后端返回的数据是一个数组，可以根据数据格式进行处理
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                renderTable1(tableData); // 渲染表格数据
            },
            error: function(error) {
                console.error('Error:', error);
            }
        })
    }

    function delFunc(id){
        $.ajax({
            url:"/quality?action=delQuality",
            data:{
                id
            },
            type:"POST",
            dataType:"JSON",
            success: function(date) {
                var info = JSON.parse(date);
                if (info.status == 200){
                    return 1;
                }
                /*if (info.status == 200){
                    layer.msg("删除成功")
                    setTimeout(function (){location.reload()}, 2000);
                }else {
                    layer.msg("删除失败")
                }*/
            },
            error: function(error) {
                console.error('Error:', error);
            }
        })
    }

    function issue(tableCoding){
        layer.open({
            type: 2,
            title: '处理货单',
            shadeClose: true,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '600px'],
            content:"medicine/qualityManage/defectiveDisposal/failedInfo.jsp?tableCoding="+tableCoding,
        });
    }

});

layui.use(['form'], function(){
    var form = layui.form;
    var $ = layui.jquery;

    // 监听指定复选框
    form.on('switch(ckStateTbAdv)', function(data){
        var id = data.value; // 获取复选框的值
        var isChecked = data.elem.checked; // 获取复选框的选中状态
        // 发送AJAX请求到服务器
        $.ajax({
            url: '/quality?action=updateQualityStatue',
            type: 'POST',
            data: {id: id},
            success: function(data){
                var info = JSON.parse(data);
                if (info.status == 200){
                    layer.msg("变化成功")
                    setTimeout(function (){location.reload()}, 2000);
                }else {
                    layer.msg("变化失败")
                }

            },
            error: function(xhr, status, error){
                // 处理错误
                console.error('Error:', error);
            }
        });
    });
});