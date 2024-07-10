layui.use(['layer', 'element', 'util', 'table', 'tableX','mousewheel','form'], function() {
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var util = layui.util;
    var table = layui.table;
    var tableX = layui.tableX;
    var layer = layui.layer;
    var form = layui.from;

    // 前端分页
    var tableIns=tableX.render({
        elem: '#xTable1',
        url: '/medicine?action=getAllMedicine',
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
                    sort: true,
                },
                {
                    field: 'salePrice',
                    title: '销售价',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
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
                    sort: true,
                },
                {
                    field: 'code',
                    title: '自编码',
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
            ]
        ],
    });


    table.on('toolbar(xTable1)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var tableCoding="";
        var mId="";
        var salePrice="";
        for(i=0;i<data.length;i++){
            tableCoding = data[i].tableCoding;
            mId = data[i].mId;
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

            case 'backPrice':	//药价回溯
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    backPrice(tableCoding,mId,salePrice);
                }
                break;

        };
    });
    function upPrice(tableCoding,mId,salePrice){
        $.ajax({
            url:"/price?action=addPrice",
            data:{
                tableCoding,
                mId,
                salePrice
            },
            type:"POST",
            dataType:"JSON",
            success:function (data) {
                if (data.status == 200){
                    openUpdate(tableCoding);
                }else {
                    layer.msg("添加失败");
                }
            }
        })
    };
    function openUpdate(tableCoding){
        layui.layer.open({
            title : "修改价格",
            type : 2,
            content : "medicine/medicineManage/medPrice/priceInfo.jsp",
            area:['450px','450px'],
        });
    }
    function backPrice(tableCoding,mId,salePrice){
        layui.layer.open({
            title : "药价回溯",
            type : 2,
            content : "medicine/medicineManage/medPrice/backPrice.jsp?tableCoding="+tableCoding+"&mId="+mId+"&salePrice="+salePrice,
            area:['1000px','450px'],
        });
    }


    //搜索
    $("#searchByQuerys").click(function () {
        select1 = $("#select1").val();
        select2 = $("#select2").val();
        select3 = $("#select3").val();
        select4 = $("#select4").val();
        $.ajax({
            url: '/medicine?action=getMedicineByQuery', // 后端处理数据的URL
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
                        sort: true,
                    },
                    {
                        field: 'salePrice',
                        title: '销售价',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
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
                        sort: true,
                    },
                    {
                        field: 'code',
                        title: '自编码',
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
                ]
                ],
            });
            table.on('toolbar(xTable1)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                var tableCoding="";
                var mId="";
                var salePrice="";
                for(i=0;i<data.length;i++){
                    tableCoding = data[i].tableCoding;
                    mId = data[i].mId;
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

                    case 'backPrice':	//药价回溯
                        if(data.length != 1){
                            layer.msg("请选择一行数据进行操作")
                            return false;
                        }else{
                            backPrice(tableCoding,mId,salePrice);
                        }
                        break;

                };
            });
            $("#searchByQuerys").click(function () {
                select1 = $("#select1").val();
                select2 = $("#select2").val();
                select3 = $("#select3").val();
                select4 = $("#select4").val();
                $.ajax({
                    url: '/medicine?action=getMedicineByQuery', // 后端处理数据的URL
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
                        url: '/medicine?action=getMedicineByName',
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
                url: '/medicine?action=getMedicineByName',
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
