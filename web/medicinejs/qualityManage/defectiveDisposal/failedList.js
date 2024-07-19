layui.use(['layer', 'element', 'util', 'table', 'tableX','mousewheel','form','laydate','Split','flow'], function() {
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var util = layui.util;
    var table = layui.table;
    var tableX = layui.tableX;
    var layer = layui.layer;
    var form = layui.from;
    var laydate = layui.laydate;
    var Split = layui.Split;

    // 水平分割
    Split(['#demoSplit1', '#demoSplit2'], {sizes: [25, 75], minSize: 100});

    // 前端分页
    var tableIns=tableX.render({
        elem: '#xTable1',
        url: '/applyFailed?action=getAllApplyFailed',
        toolbar: '#toolbarDemo',
        page: true,
        height: 600,
        limit: 15,
        limits: [5,10,15,20,25],
        cols: [
            [{fixed:"left",type: "checkbox", width:50},
                {field: 'applyId', title: '申请编号',  align:'center',width:200},
                {field: 'mId', title: '字典编号',  align:'center',width:200},
                {field: 'mName', title: '药品名称', minWidth:100, align:"center",width:200},
                {field: 'specification', title: '规格', align:'center',width:200},
                {field: 'manufactor', title: '生产企业', align:'center',width:200},
                {field: 'number', title: '数量', align:'center',width:200},
                {field: 'applyNumber', title: '采购数量',  align:'center',width:200},
                {field: 'purchasePrice', title: '采购价',  align:'center',width:200},
                {field: 'code', title: '批号',  align:'center',width:200},
                {field: 'mType', title: '药品分类',  align:'center',width:200},
                {field: 'supplier', title: '供货单位',  align:'center',width:200},
                {field: 'approvalNumber', title: '准批文号',  align:'center',width:200},
                {field: 'placeOrigin', title: '产地',  align:'center',width:200},
                {field: 'applyUser' ,title:'申请人', align:'center',width:200},
                {field: 'applyTime' ,title:'申请时间', align:'center',width:200},
                {field: 'pharmacist' ,title:'药师', align:'center',width:200},
                {field: 'pharmacistApprove' ,title:'药师审批', align:'center',width:200},
                {field: 'pharmacistTime' ,title:'药师审批时间', align:'center',width:200},
                {field: 'tableCoding' ,title:'药品编号', align:'center',width:200},
                {field: 'cause' ,title:'处理记录', align:'center',width:200},
            ]
        ],
    });

    table.on('row(xTable1)', function(obj){
        var data = obj.data;
        loadContent(data.applyId);
    });

    table.on('toolbar(xTable1)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var tableCoding = '';
        var applyId='';
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
                    applyId = data[i].applyId;
                    console.log(delFunc(id));
                }
                if (i=data.length){
                    layer.msg("删除成功")
                    setTimeout(function (){location.reload()},2000);
                }
                break;
            case 'upFunc':
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
        };
    });

    loadContent(3190);
    function loadContent(applyId) {
        $.ajax({
            url: '/applyFailed?action=getCause', // 替换为你的服务器端点
            data:{
                applyId
            },
            type: 'GET',
            dataType: 'json',
            success: function(response) {

                // 假设响应是一个包含 causes 数据的对象
                var causes = response.data;
                var html = '';
                // 生成 HTML 内容
                $.each(causes, function(index, cause) {
                    html += '<div class="layui-timeline">';
                    html += '<div class="layui-timeline-item" style="padding-bottom: 0px;">';
                    html += '<i class="layui-icon layui-timeline-axis"></i>';
                    html += '<div class="layui-timeline-content layui-text">';
                    html += '<h3 class="layui-timeline-title">' + cause.applyTime + '</h3>';
                    html += '<p>' + cause.cause + ' <i class="layui-icon"></i></p>';
                    html += '</div>';
                    html += '</div>';
                    html += '</div>';
                });
                // 更新页面中的内容
                $('#demoSplit1').html(html);
            },
            error: function(xhr, status, error) {
                console.error('加载内容失败:', error);
            }
        });
    }

    function delFuanc(applyId){
        $.ajax({
            url: '/applyFailed?action=delApplyFailed', // 后端处理数据的URL
            type: "POST", // 或 'GET'，取决于后端接口的要求
            data: {
                applyId
            },
            dataType:"JSON",
            success: function(response) {
                layer.msg("已删除")
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    }
    //搜索
    /*$("#searchByQuerys").click(function () {
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
                        for(i;i<data.length;i++){
                            tableCoding = data[i].tableCoding;
                            id = data[i].id;
                            oId = data[i].orderId;
                            layer.confirm('是否要单退此药品？', {icon: 3}, function(){
                                addFunc(oId,id,2);
                                issue(tableCoding);
                                /!*delFunc(id);*!/
                            }, function(){
                                issue(tableCoding);
                                /!*delFunc(id);*!/
                            });

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
                /!*if (info.status == 200){
                    layer.msg("删除成功")
                    setTimeout(function (){location.reload()}, 2000);
                }else {
                    layer.msg("删除失败")
                }*!/
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
                /!*if (info.status == 200){
                    layer.msg("删除成功")
                    setTimeout(function (){location.reload()}, 2000);
                }else {
                    layer.msg("删除失败")
                }*!/
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
                    return 1;
                }
            },
            error: function(error) {
                console.error('Error:', error);
            }
        })
    }
    //不合格品处理
    function issue(tableCoding){
        layer.open({
            type: 2,
            title: '处理货单',
            shadeClose: true,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '600px'],
            content:"medicine/qualityManage/defectiveDisposal/failedInfo.jsp?tableCoding="+tableCoding,
        });
    }*/
});