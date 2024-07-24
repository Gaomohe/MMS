layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    layui.use(function(){
        var laydate = layui.laydate;
        // 日期时间选择器
        laydate.render({
            elem: '#stockOutTime',
            type: 'datetime'
        });
    });

    //表格渲染
    var tableIns = table.render({
        elem: '#stockOutFormList',
        url : '/StockOutForm?action=selectStockOutForm',
        cellMinWidth : 95,
        page : true,
        toolbar: '#stockOutFormDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'outId', title: '#', hide:true, align:'center',width:170},
            {field: 'outNum', title: '出库单号',  align:'center',width:200},
            {field: 'tableCoding', title: '出库单id', hide:true, width:100, align:"center"},
            {field: 'oName', title:'药品名称' , width:200, align:"center"},
            {field: 'standard', title:'规格' , width:200, align:"center"},
            {field: 'manufactor', title:'供货商' , width:200, align:"center"},
            {field: 'unit', title:'单位' , width:100, align:"center"},
            {field: 'oNum', title:'出库数量' , width:100, align:"center"},
            {field: 'cost', title:'成本' , width:100, align:"center"},
            {field: 'salePrice', title:'销售价' , width:100, align:"center"},
            {field: 'batchNumber', title:'批号' , width:200, align:"center"},
            {field: 'productDate', title:'生产日期' , width:200, align:"center"},
            {field: 'expiration', title:'有效期' , width:200, align:"center"},
            {field: 'stockOutTime', title:'出库时间' , width:200, align:"center"},
            {field: 'department', title:'部门' , width:100, align:"center"},
            {field: 'notes', title:'出库状态' , width:100, align:"center"},

        ]],
        done:function (data){
            console.log(data)
        }
    });

    //根据入库单号/药品信息/入库日期查询和重置的事件
    // 绑定“查询”点击事件
    $("#search").click(function() {
        var outNum = $("#outNum").val();
        var oName = $("#oName").val();
        var stockOutTime = $("#stockOutTime").val();
        console.log(outNum)
        console.log(oName)
        console.log(stockOutTime)
        $.ajax({
            url:"/StockOutForm?action=getStockOutFormByQuery",
            type:"POST",
            data:{
                "outNum":outNum,
                "oName":oName,
                "stockOutTime":stockOutTime
            },
            dataType:"JSON",
            success:function (response){
                console.log(response);
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                console.log(tableData)
                renderTable(tableData); // 渲染表格数据
            },
        })
    });
    function renderTable(data){
        console.log(data)
        layui.use('table',function (){
            var table = layui.table;
            table.render({
                elem: '#stockOutFormList',
                data:data,
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'outId', title: '#', hide:true, align:'center',width:170},
                    {field: 'outNum', title: '出库单号',  align:'center',width:200},
                    {field: 'tableCoding', title: '出库单id', hide:true, width:100, align:"center"},
                    {field: 'oName', title:'药品名称' , width:200, align:"center"},
                    {field: 'standard', title:'规格' , width:200, align:"center"},
                    {field: 'manufactor', title:'供货商' , width:200, align:"center"},
                    {field: 'unit', title:'单位' , width:100, align:"center"},
                    {field: 'oNum', title:'出库数量' , width:100, align:"center"},
                    {field: 'cost', title:'成本' , width:100, align:"center"},
                    {field: 'salePrice', title:'销售价' , width:100, align:"center"},
                    {field: 'batchNumber', title:'批号' , width:200, align:"center"},
                    {field: 'productDate', title:'生产日期' , width:200, align:"center"},
                    {field: 'expiration', title:'有效期' , width:200, align:"center"},
                    {field: 'stockOutTime', title:'出库时间' , width:200, align:"center"},
                    {field: 'department', title:'部门' , width:100, align:"center"},
                    {field: 'notes', title:'出库状态' , width:100, align:"center"},
                ]],
                done:function (data){
                    console.log(data)
                }
            })
        })
    }
    //重置
    $("#reset").click(function() {
        $("#outNum").val('');
        $("#oName").val('');
        $("#stockOutTime").val('');
        tableIns.reload({
            url:"/StockOutForm?action=selectStockOutForm",
            page: {
                curr:1
            }
        })
    })

    //工具栏事件
    table.on('toolbar(stockOutFormList)', function(obj){
        console.log(obj)
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var outId = '';
        for(i=0;i<data.length;i++){
            outId = data[i].outId;
        }
        console.log(outId)
        switch(obj.event){
            case 'delStockOutForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('确定删除此出库单吗?', {icon: 3, title:'提示'}, function(index){
                    delStockOutForm(outId);
                    layer.close(index);
                });
                break;

            case 'updateStockOutForm':
                    updateStockOutForm();
                break;

            case 'addStockOutForm':
                addStockOutForm();
                break;

        };
    });

    function delStockOutForm(outId){
        $.ajax({
            url:"/StockOutForm?action=delStockOutForm",
            type:"post",
            data:{"outId":outId},
            success:function(data){
                console.log(data)
                var info = JSON.parse(data);
                if(info.status == 200){
                    layer.msg("删除成功");
                    tableIns.reload("#stockOutFormList");
                }
            }
        })
    }

    function updateStockOutForm(){
        layer.open({
            type: 2,
            content : "medicine/warehouseManage/stockOutForm/stockOutFormInfo.jsp",
            area: ['1200px', '520px'],
            fixed: false, // 不固定
            maxmin: true,
            shadeClose: true,
            btnAlign: 'c',
        })
    }
    function addStockOutForm(){
        layer.open({
            type: 2,
            content : "medicine/warehouseManage/stockOutForm/stockOutFormAdd.jsp",
            area: ['1200px', '520px'],
            fixed: false, // 不固定
            maxmin: true,
            shadeClose: true,
            btnAlign: 'c',
        })
    }

})