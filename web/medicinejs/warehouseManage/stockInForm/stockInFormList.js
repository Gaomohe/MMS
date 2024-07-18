layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'],function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    var total = 0;
    var count = 0;
    layui.use(function () {
        laydate.render({
            elem: '#MainTime',
            type: 'datetime'
        });
    });

    //表格渲染
    var tableIns = table.render({
        elem: '#stockInFormList',
        url : '/StockInForm?action=selectStockInForm',
        cellMinWidth : 95,
        page : true,
        toolbar: '#stockInFormDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'rId', title: '#',  align:'center',width:100},
            {field: 'stockInNum', title: '入库单号',  align:'center',width:200},
            {field: 'rName', title: '入库药品',  align:'center',width:100},
            {field: 'standard', title: '规格', width:100, align:"center"},
            {field: 'manufactor', title:'生产厂家' , width:100, align:"center"},
            {field: 'unit', title:'单位' , width:100, align:"center"},
            {field: 'rNum', title:'入库药品数量' , width:100, align:"center"},
            {field: 'cost', title:'成本' , width:100, align:"center"},
            {field: 'salePrice', title:'销售价' , width:100, align:"center"},
            {field: 'batchNumber', title:'批号' , width:100, align:"center"},
            {field: 'productDate', title:'生产日期' , width:150, align:"center"},
            {field: 'expiration', title:'有效期至' , width:150, align:"center"},
            {field: 'stockInTime', title:'入库时间' , width:150, align:"center"},
            {field: 'department', title:'部门' , width:100, align:"center"},
            {field: 'notes', title:'备注' , width:100, align:"center"},

        ]],
        done:function (data){
            console.log(data)
        }
    });
    //根据入库单号/药品信息/入库日期查询和重置的事件
        // 绑定“查询”点击事件
    $("#queryButton").click(function() {
        var stockInNum = $("#stockInNum").val();
        var rName = $("#rName").val();
        var stockInTime = $("#stockInTime").val();
        console.log(rName);
        $.ajax({
            url:"/StockInForm?action=getStockInFormByQuery",
            type:"POST",
            data:{
                "stockInNum":stockInNum,
                "rName":rName,
                "stockInTime":stockInTime
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
    //重置
    $("#resetButton").click(function() {
        tableIns.reload({
            url:"/StockInForm?action=selectStockInForm",
            page: {
                curr:1
            }
        })
    })


    function renderTable(data){
        console.log(data)
        layui.use('table',function (){
            var table = layui.table;
            table.render({
                elem: '#stockInFormList',
                data:data,
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'rId', title: '#',  align:'center',width:100},
                    {field: 'stockInNum', title: "入库单号",  align:'center',width:100},
                    {field: 'rName', title: '入库药品',  align:'center',width:100},
                    {field: 'standard', title: '规格', width:100, align:"center"},
                    {field: 'manufactor', title:'生产厂家' , width:100, align:"center"},
                    {field: 'unit', title:'单位' , width:100, align:"center"},
                    {field: 'rNum', title:'入库药品数量' , width:100, align:"center"},
                    {field: 'cost', title:'成本' , width:100, align:"center"},
                    {field: 'salePrice', title:'销售价' , width:100, align:"center"},
                    {field: 'batchNumber', title:'批号' , width:100, align:"center"},
                    {field: 'productDate', title:'生产日期' , width:100, align:"center"},
                    {field: 'expiration', title:'有效期至' , width:100, align:"center"},
                    {field: 'stockInTime', title:'入库时间' , width:100, align:"center"},
                    {field: 'department', title:'部门' , width:100, align:"center"},
                    {field: 'notes', title:'入库状态' , width:100, align:"center"},
                ]],
                done:function (data){
                    console.log(data)
                }
            })
        })
    }


    //工具栏事件
    table.on('toolbar(stockInFormList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var rId = '';
        for(i=0;i<data.length;i++){
            rId = data[i].rId;
        }
        console.log(rId)
        console.log(data)
        switch(obj.event){
            case 'delStockInForm':
                if (data.length > 0) {
                    data.forEach(function(data1) {
                        // 假设每个file对象都有一个id属性，用于标识用户
                        total++;
                        delStockInForm(data1.rId);
                    });
                } else {
                    layer.msg("you are not select", {icon: 2});
                }
                break;
                // if(data.length = 0){
                //     layer.msg("请选择一行数据进行操作")
                //     return false;
                // }else if (data.length>=1){
                //     layer.confirm('确定删除此入库单吗?', {icon: 3, title:'提示'}, function(index){
                //         for(i=0;i<id.length;i++){
                //             delStockInForm(id[i]);
                //         }
                //
                //         layer.close(index);
                //         setTimeout(function(){
                //             layer.closeAll("iframe");
                //             //刷新父页面
                //             parent.location.reload();
                //         },1000);
                //     });
                //     break;
                // }
            case 'updateStockInForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    updateStockInForm(rId);
                }
                break;

            case 'addStockInForm':
                addStockInForm();
                break;

        };
    });

    function delStockInForm(rId){
        $.ajax({
            url:"/StockInForm?action=delStockInForm",
            type:"post",
            data:{"rId":rId},
            success:function(data){
                count++
                if (count == total) {
                    if (res.status) {
                        layer.msg("删除成功", { icon: 1 });
                        location.reload();
                    } else {
                        layer.msg("删除失败", { icon: 2 });
                    }
                }
                var info = JSON.parse(data);
                if(info.status == 200){
                    tableIns.reload("#stockInFormList");
                }
            }
        })
    }

    function updateStockInForm(rId){
        layui.layer.open({
            title : "修改入库单信息",
            type : 2,
            content : "medicine/warehouseManage/stockInForm/stockInFormInfo.jsp",
            area:['550px','500px'],
            success:function(layero, index){
                $.ajax({
                    url:"/StockInForm?action=selectStockInFormById",//根据id查询的方法
                    type:"post",
                    data:{"rId":rId},
                    success:function(data){
                        var info = JSON.parse(data);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#rId").val(info.data.rId);
                        body.find("#stockInNum").val(info.data.stockInNum);
                        body.find("#rName").val(info.data.rName);
                        body.find("#standard").val(info.data.standard);
                        body.find("#manufactor").val(info.data.manufactor);
                        body.find("#unit").val(info.data.unit);
                        body.find("#rNum").val(info.data.rNum);
                        body.find("#cost").val(info.data.cost);
                        body.find("#salePrice").val(info.data.salePrice);
                        body.find("#batchNumber").val(info.data.batchNumber);
                        body.find("#productDate").val(info.data.productDate);
                        body.find("#expiration").val(info.data.expiration);
                        body.find("#stockInTime").val(info.data.stockInTime);
                        body.find("#notes").val(info.data.notes);
                    }
                })
            }
        });
    }
    function addStockInForm(){
        layer.open({
            type: 2,
            content : "medicine/warehouseManage/stockInForm/stockInFormAdd.jsp",
            area: ['1200px', '520px'],
            fixed: false, // 不固定
            maxmin: true,
            shadeClose: true,
            btnAlign: 'c',
            success:function (layero,index){
                $.ajax({
                    url:"/StockInForm?action=selectGeneratedStockInNumber",
                    type:"POST",
                    success:function (data){
                        var info = JSON.parse(data);
                        var cs = info.data
                        console.log(cs)
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#stockInNum").val(cs)
                    }
                })
            },
        })
    }

})