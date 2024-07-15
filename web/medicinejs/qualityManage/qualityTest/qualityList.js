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
        url: '/quality?action=getQualityBySS&storageStatus=0',
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
                    sort: true
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
                    field: 'totlNumber',
                    title: '本批入库数量',
                    minWidth: 200,
                    align: 'center',
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

    table.on('toolbar(xTable1)', function(obj){
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
        };
    });
    //搜索
    $("#searchByQuerys").click(function () {
        select1 = $("#select1").val();
        select2 = $("#select2").val();
        select3 = $("#select3").val();
        select4 = $("#select4").val();
        $.ajax({
            url: '/quality?action=getQualityByQuery', // 后端处理数据的URL
            type: "POST", // 或 'GET'，取决于后端接口的要求
            data: {
                select1,
                select2,
                select3,
                select4
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
                        sort: true
                    },
                    {
                        field: 'statue',
                        title: '质检状态',
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
                        field: 'totlNumber',
                        title: '本批入库数量',
                        minWidth: 200,
                        align: 'center',
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
                    {
                        title: '操作',
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
                };
            });
            $("#searchByQuerys").click(function () {
                select1 = $("#select1").val();
                select2 = $("#select2").val();
                select3 = $("#select3").val();
                select4 = $("#select4").val();
                $.ajax({
                    url: '/quality?action=getQualityByQuery', // 后端处理数据的URL
                    type: "POST", // 或 'GET'，取决于后端接口的要求
                    data: {
                        select1,
                        select2,
                        select3,
                        select4
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


    $('#search').off('keypress').on('keypress', function(event) {
        if (event.which === 13) {
            var search = $('#search').val();
            $.ajax({
                url: '/quality?action=getQualityBymName',
                type: "POST",
                data: {
                    mName: search,
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