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
        url: '/returnSal?action=getReturnSale',
        page: true,
        toolbar: '#toolbarDemo',
        limit: 15,
        limits: [5,10,15,20,25],
        height:600,
        cols: [[
            {type: 'checkbox'},
            {field: 'id', align: 'center', sort: true, title: '编号'},
            {field: 'returnId', align: 'center', sort: true, title: '退货单号'},
            {field: 'address', align: 'center', sort: true, title: '地址',
                templet: function(d) {
                    if (!d.address) {
                        return '<div class="red-bg">' + (d.address || '请处理') + '</div>';
                    }
                    return d.address;
                }
            },
            {field: 'shippingWay', align: 'center', sort: true, title: '邮寄方式'},
            {field: 'shippingTime', align: 'center', sort: true, title: '邮寄时间'},
            {field: 'consigner', align: 'center', sort: true, title: '发货人'},
            {field: 'consignee', align: 'center', sort: true, title: '收货人'},
            {field: 'oId', align: 'center', sort: true, title: '采购单号'},
            {field: 'callNumber', align: 'center', sort: true, title: '联系方式'},
            {field: 'state', align: 'center', sort: true, title: '货单状态'}
        ]],
        done:function (res) {
            var trs = $('#tableTbAdv').next('.layui-table-view').find('tbody tr');
            trs.each(function(index, tr) {
                var td = $(tr).find('td:eq(3)'); // 假设 address 在第四列
                var address = $(tr).data('index'); // 假设你使用某种方式（如 ids 字段）来映射行索引到数据索引
                if (!res.data[index].address) { // 注意这里使用了 index 作为数据索引，这可能需要调整
                    $(tr).addClass('red-bg');
                }
            });
        }
    });

    table.on('toolbar(tableTbAdv)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var id='';
        var state='';
        for(i=0;i<data.length;i++){
            id = data[i].id;
        }
        switch(obj.event){
            case 'delFunc':	//按照养护时间查找
                var i = 0;
                for(i=0;i<data.length;i++){
                    id = data[i].id;
                    delReturn(id);
                }
                if (i=data.length){
                    layer.msg("删除成功")
                    setTimeout(function (){location.reload()},2000);
                }
                break;
            case 'upFunc1':
                var i;
                for(i;i<data.length;i++){
                    id = data[i].id;
                    state = data[i].state;
                    upReturn1(id);
                }
                if (i=data.length){
                    layer.msg("操作成功")
                    setTimeout(function (){location.reload()},2000);
                }
                break;
            case 'upFunc2':
                var i;
                for(i;i<data.length;i++){
                    id = data[i].id;
                    upReturn2(id);
                }
                if (i=data.length){
                    layer.msg("操作成功")
                    setTimeout(function (){location.reload()},2000);
                }
                break;
            case 'upFunc3':
                if(data.length!=1){
                    layer.msg("请选择一条数据处理")
                }else{
                    upReturn3(id)
                }
                break;
            case 'upFunc4':
                if(data.length!=1){
                    layer.msg("请选择一条数据处理")
                }else{
                    upReturn4(id)
                }
                break;
        };
    });

    $("#searchByQuerys2").click(function (){
        var state =$("#select1").val();
        if (state!=""){
            $.ajax({
                url: '/returnSal?action=getSalReturnByStatue', // 后端处理数据的URL
                type: "POST", // 或 'GET'，取决于后端接口的要求
                data: {
                    state
                },
                dataType:"JSON",
                success: function(response) {
                    var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                    renderTable(tableData); // 渲染表格数据
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    })
    /*$("#select1").on('change',function (){
        var state =$("#select1").val();
        alert(state)
        if (state!=""){
            $.ajax({
                url: '/returnSal?action=getSalReturnByStatue', // 后端处理数据的URL
                type: "POST", // 或 'GET'，取决于后端接口的要求
                data: {
                    state
                },
                dataType:"JSON",
                success: function(response) {
                    var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                    renderTable(tableData); // 渲染表格数据
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    })*/

    $("#consigner").on('change',function (){
        var consigner =$("#consigner").val();
        if (consigner!=""){
            $.ajax({
                url: '/returnSal?action=getSalReturnByEr', // 后端处理数据的URL
                type: "POST", // 或 'GET'，取决于后端接口的要求
                data: {
                    consigner
                },
                dataType:"JSON",
                success: function(response) {
                    var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                    renderTable(tableData); // 渲染表格数据
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    })

    $("#consignee").on('change',function (){
        var consignee =$("#consignee").val();
        if (consignee!=""){
            $.ajax({
                url: '/returnSal?action=getSalReturnByEE', // 后端处理数据的URL
                type: "POST", // 或 'GET'，取决于后端接口的要求
                data: {
                    consignee
                },
                dataType:"JSON",
                success: function(response) {
                    var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                    renderTable(tableData); // 渲染表格数据
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    })

    $("#returnId").on('change',function (){
        var returnId =$("#returnId").val();
        if (returnId!=""){
            $.ajax({
                url: '/returnSal?action=getSalReturnByRId', // 后端处理数据的URL
                type: "POST", // 或 'GET'，取决于后端接口的要求
                data: {
                    returnId
                },
                dataType:"JSON",
                success: function(response) {
                    var tableData = response.data;
                    renderTable(tableData); // 渲染表格数据
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    })

    $("#phone").on('change',function (){
        var phone =$("#phone").val();
        if (phone!=""){
            $.ajax({
                url: '/returnSal?action=getSalReturnByCall', // 后端处理数据的URL
                type: "POST", // 或 'GET'，取决于后端接口的要求
                data: {
                    callNumber:phone
                },
                dataType:"JSON",
                success: function(response) {
                    var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                    renderTable(tableData); // 渲染表格数据
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        }
    })
    function renderTable(data) {
        layui.use('table', function(){
            var table = layui.table;
            table.render({
                elem: '#tableTbAdv',
                data: data, // 使用从后端获取的数据渲染表格
                page: true,
                toolbar: '#toolbarDemo',
                limit: 15,
                limits: [5,10,15,20,25],
                height:600,
                cols: [[
                    {type: 'checkbox'},
                    {field: 'id', align: 'center', sort: true, title: '编号'},
                    {field: 'returnId', align: 'center', sort: true, title: '退货单号'},
                    {field: 'address', align: 'center', sort: true, title: '地址',
                        templet: function(d) {
                            if (!d.address) {
                                return '<div class="red-bg">' + (d.address || '请处理') + '</div>';
                            }
                            return d.address;
                        }
                    },
                    {field: 'shippingWay', align: 'center', sort: true, title: '邮寄方式'},
                    {field: 'shippingTime', align: 'center', sort: true, title: '邮寄时间'},
                    {field: 'consigner', align: 'center', sort: true, title: '发货人'},
                    {field: 'consignee', align: 'center', sort: true, title: '收货人'},
                    {field: 'oId', align: 'center', sort: true, title: '采购单号'},
                    {field: 'callNumber', align: 'center', sort: true, title: '联系方式'},
                    {field: 'state', align: 'center', sort: true, title: '货单状态'}
                ]],
                done:function (res) {
                    var trs = $('#tableTbAdv').next('.layui-table-view').find('tbody tr');
                    trs.each(function(index, tr) {
                        var td = $(tr).find('td:eq(3)'); // 假设 address 在第四列
                        var address = $(tr).data('index'); // 假设你使用某种方式（如 ids 字段）来映射行索引到数据索引
                        if (!res.data[index].address) { // 注意这里使用了 index 作为数据索引，这可能需要调整
                            $(tr).addClass('red-bg');
                        }
                    });
                }
            });
            table.on('toolbar(tableTbAdv)', function(obj){
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                var id='';
                var state='';
                for(i=0;i<data.length;i++){
                    id = data[i].id;
                }
                switch(obj.event){
                    case 'delFunc':	//按照养护时间查找
                        var i = 0;
                        for(i=0;i<data.length;i++){
                            id = data[i].id;
                            delReturn(id);
                        }
                        if (i=data.length){
                            layer.msg("删除成功")
                            setTimeout(function (){location.reload()},2000);
                        }
                        break;
                    case 'upFunc1':
                        var i;
                        for(i;i<data.length;i++){
                            id = data[i].id;
                            state = data[i].state;
                            upReturn1(id);
                        }
                        if (i=data.length){
                            layer.msg("操作成功")
                            setTimeout(function (){location.reload()},2000);
                        }
                        break;
                    case 'upFunc2':
                        var i;
                        for(i;i<data.length;i++){
                            id = data[i].id;
                            upReturn2(id);
                        }
                        if (i=data.length){
                            layer.msg("操作成功")
                            setTimeout(function (){location.reload()},2000);
                        }
                        break;
                    case 'upFunc3':
                        if(data.length!=1){
                            layer.msg("请选择一条数据处理")
                        }else{
                            upReturn3(id)
                        }
                        break;
                    case 'upFunc4':
                        if(data.length!=1){
                            layer.msg("请选择一条数据处理")
                        }else{
                            upReturn4(id)
                        }
                        break;
                };
            });
        });
    }

    function delReturn(id){
        $.ajax({
            url: '/returnSal?action=delSalReturn', // 后端处理数据的URL
            type: "POST", // 或 'GET'，取决于后端接口的要求
            data: {
                id
            },
            dataType:"JSON",
            success: function(response) {
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                renderTable(tableData); // 渲染表格数据
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    }

    function upReturn1(id){
        $.ajax({
            url: '/returnSal?action=updateStatue', // 后端处理数据的URL
            type: "POST", // 或 'GET'，取决于后端接口的要求
            data: {
                id,
                state:"到货未付款"
            },
            dataType:"JSON",
            success: function(response) {
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                renderTable(tableData); // 渲染表格数据
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    }

    function upReturn2(id){
        $.ajax({
            url: '/returnSal?action=updateStatue', // 后端处理数据的URL
            type: "POST", // 或 'GET'，取决于后端接口的要求
            data: {
                id,
                state:"已退款"
            },
            dataType:"JSON",
            success: function(response) {
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                renderTable(tableData); // 渲染表格数据
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    }

    function upReturn3(id){
        layer.open({
            type: 2,
            title: '处理货单',
            shadeClose: true,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '600px'],
            content:"medicine/shoppingManage/salesReturn/returnInfo.jsp?id="+id,
        });
    }

    function upReturn4(id){
        layer.open({
            type: 2,
            title: '添加收件人',
            shadeClose: true,
            maxmin: true, //开启最大化最小化按钮
            area: ['900px', '600px'],
            content:"medicine/shoppingManage/salesReturn/returnAddEE.jsp?id="+id,
        });
    }
    // 导出excel
    $('#btnExportTbAdv').click(function () {
        var checkRows = table.checkStatus('tableTbAdv');
        if (checkRows.data.length == 0) {
            layer.msg('请选择要导出的数据', {icon: 2});
        } else {
            table.exportFile(insTb.config.id, checkRows.data, 'docx');
        }
    });

});