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
        url: '/quality?action=getQualityBySS&storageStatus=未入库',
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
                    title: '质检人',
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
                {
                    field: 'orderId',
                    title: '订单编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                    hide: true,
                },
                {
                    field: 'usefulLife',
                    title: '有效期',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
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
                            issue(tableCoding,id);
                            addFunc(oId,id,2);
                        }, function(){
                            issue(tableCoding,id);
                        });

                    }
                }
                break;
            case 'addFunc2':
                var i = 0;
                if (data.length != 1){
                    layer.msg("请选择一条数据")
                }else {
                    for(i;i<data.length;i++){
                        id = data[i].id;
                        addFunc2(id);
                    }
                }
                break;
        };
    });
    //搜索
    $("#searchByQuerys").click(function () {
        select1 = $("#select1").val();
        select2 = $("#select2").val();
        select3 = $("#select3").val();
        select4 = $("#select4").val();
        sql = 1;
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
                renderTable(tableData); // 渲染表格数据
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
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
                                    issue(tableCoding,id);
                                    addFunc(oId,id,2);
                                }, function(){
                                    issue(tableCoding,id);
                                });

                            }
                        }
                        break;
                    case 'addFunc2':
                        var i = 0;
                        if (data.length != 1){
                            layer.msg("请选择一条数据")
                        }else {
                            for(i;i<data.length;i++){
                                id = data[i].id;
                                addFunc2(id);
                            }
                        }
                        break;
                };
            });
            $("#searchByQuerys").click(function () {
                select1 = $("#select1").val();
                select2 = $("#select2").val();
                select3 = $("#select3").val();
                select4 = $("#select4").val();
                sql = 1;
                $.ajax({
                    url: '/quality?action=getQualityByQuery', // 后端处理数据的URL
                    type: "POST", // 或 'GET'，取决于后端接口的要求
                    data: {
                        select1,
                        select2,
                        select3,
                        select4,
                        sql
                    },
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
                });
            });
            $('#search').off('keypress').on('keypress', function(event) {
                if (event.which === 13) {
                    var search = $('#search').val();
                    $.ajax({
                        url: '/quality?action=getQualityBymName',
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
    //名称搜索
    $('#search').off('keypress').on('keypress', function(event) {
        if (event.which === 13) {
            var search = $('#search').val();
            $.ajax({
                url: '/quality?action=getQualityBymName',
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
            url:"/quality?action=getQualityByTime",
            data:{
                time,
                sql:1
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
    //根据OId删除一整单
    function delFuncByOid(oid){
        $.ajax({
            url:"/quality?action=delQualityByOid",
            data:{
                oid
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
    //退货
    function addFunc(oId,id,num){
        $.ajax({
            url:"/quality?action=returnMedicine",
            data:{
                oId,
                id,
                num,
            },
            type:"POST",
            dataType:"JSON",
            success: function(date) {
                var info = JSON.parse(date);
                if (info.status == 200){
                    delFunc(id);
                }
            },
            error: function(error) {
                console.error('Error:', error);
            }
        })
        return 0
    }
    //不合格品处理
    function issue(tableCoding,id){
        layer.open({
            type: 2,
            title: '处理货单',
            shadeClose: true,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '600px'],
            content:"medicine/qualityManage/defectiveDisposal/failedInfo.jsp?tableCoding="+tableCoding+"&id="+id,
        });
    }
    //添加有效期
    function addFunc2(id){
        layer.open({
            type: 2,
            title: '添加有效日期',
            shadeClose: true,
            maxmin: true, //开启最大化最小化按钮
            area: ['350px','430px'],
            content:"medicine/qualityManage/qualityTest/qualityInfo.jsp?id="+id,
        });
    }
});

layui.use(['form'], function(){
    var form = layui.form;
    var $ = layui.jquery;
    var userfulLife = null;

    // 监听指定复选框
    form.on('switch(ckStateTbAdv)', function(data){
        var id = data.value; // 获取复选框的值
        var isChecked = data.elem.checked; // 获取复选框的选中状态
        $.ajax({
            url: '/quality?action=getQualityById',
            type: 'POST',
            data: {id: id},
            success: function(data){
                var info = JSON.parse(data);
                userfulLife = info.data.usefulLife;
                console.log(info.data);
                if (userfulLife != null){
                    change(id);
                }else {
                    layer.msg("请添加有效日期");
                }

            },
            error: function(xhr, status, error){
                // 处理错误
                console.error('Error:', error);
            }
        });
    });

    function change(id){
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
    }
});
