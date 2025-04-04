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

    var select1;
    var select2;
    var select3;
    var select4;

    //表格渲染
    var tableIns = table.render({
        elem: '#stockAllFormList',
        url : '/StockAllForm?action=selectStockAllForm',
        cellMinWidth : 95,
        page : true,
        toolbar: '#stockAllFormDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'mId', title: '药品编号', hide:true, align:'center',width:100},
            {field: 'mName', title: '药品名称',  align:'center',width:100},
            {field: 'specification', title: '规格', width:100, align:"center"},
            {field: 'manufactor', title:'生产厂家' , width:100, align:"center"},
            {field: 'unit', title:'单位' , width:100, align:"center"},
            {field: 'department', title:'部门' , width:100, align:"center"},
            {field: 'position', title:'货位' , width:100, align:"center"},
            {field: 'number', title:'数量' , width:100, align:"center"},
            {field: 'batchNumber', title:'批号' , width:100, align:"center"},
            {field: 'usefulLife', title:'有效期' , width:100, align:"center"},
            {field: 'purchasePrice', title:'采购价' , width:100, align:"center"},
            {field: 'salePrice', title:'销售价' , width:100, align:"center"},
            {field: 'productDate', title:'生产日期' , width:100, align:"center"},
            {field: 'profits', title:'利润金额' , width:100, align:"center"},
            {field: 'code', title:'自编码' ,hide:true, width:100, align:"center"},
            {field: 'goodsType', title:'商品分类' , width:100, align:"center"},
            {field: 'mType', title:'药品分类' , width:100, align:"center"},
            {field: 'defined', title:'自定义类' , width:100, align:"center"},
            {field: 'supplier', title:'供货商' , width:100, align:"center"},
            {field: 'warehousingDate', title:'入库日期' , width:100, align:"center"},
            {field: 'locationDescription', title:'货位说明' , hide:true,width:100, align:"center"},
            {field: 'sign', title:'标志', hide:true , width:100, align:"center"},
            {field: 'warehousingRemarks', title:'入库备注' , width:100, align:"center"},
            {field: 'drugFrom', title:'剂型' , width:100, align:"center"},
            {field: 'handingInformation', title:'处理情况' ,hide:true, width:100, align:"center"},
            {field: 'approvalNumber', title:'批准文号' , width:100, align:"center"},
            {field: 'LastCuringDate', title:'上次养护日期' ,width:100, align:"center"},
            {field: 'timesStorage', title:'入库次数' , width:100, align:"center"},
            {field: 'documentNumber', title:'单据号码' , hide:true,width:100, align:"center"},
            {field: 'placeOrigin', title:'产地' , width:100, align:"center"},
            {field: 'batchsNumber', title:'批次号' ,hide:true, width:100, align:"center"},
            {field: 'recordNumber', title:'记录号' , width:100, align:"center"},
            {field: 'tableCoding', title:'id',hide:true , width:100, align:"center"},

        ]],
        done:function (data){
            console.log(data)
        }
    });
    //工具栏事件
    table.on('toolbar(stockAllFormList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var tableCoding = '';
        for(i=0;i<data.length;i++){
            tableCoding = data[i].tableCoding;
        }
        console.log(tableCoding)
        switch(obj.event){
            case 'delStockAllForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('确定删除此库存单吗?', {icon: 3, title:'提示'}, function(index){
                    delStockAllForm(tableCoding);
                    layer.close(index);
                });
                break;

            case 'upStockAllForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upStockAllForm(tableCoding);
                }
                break;

            case 'addStockAllForm':
                addStockAllForm();
                break;

        };
    });
    function delStockAllForm(tableCoding){
        console.log(tableCoding)
        $.ajax({
            url:"/StockAllForm?action=delStockAllForm",
            type:"post",
            data:{"tableCoding":tableCoding},
            success:function(data){
                console.log(data)
                var info = JSON.parse(data);
                if(info.status == 200){
                    layer.msg("删除成功");
                    tableIns.reload("#stockAllFormList");
                }
            }
        })
    }

    function upStockAllForm(tableCoding){
        layui.layer.open({
            title : "修改药品库存单信息",
            type : 2,
            content : "medicine/warehouseManage/stockAllForm/stockAllFormInfo.jsp",
            area:['550px','500px'],
            success:function(layero, index){
                $.ajax({
                    url:"/StockAllForm?action=selectStockAllFormById",//根据id查询的方法
                    type:"post",
                    data:{"tableCoding":tableCoding},
                    success:function(data){
                        var info = JSON.parse(data);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#mId").val(info.data.rId);
                        body.find("#mName").val(info.data.mName);
                        body.find("#specification").val(info.data.specification);
                        body.find("#manufactor").val(info.data.manufactor);
                        body.find("#unit").val(info.data.unit);
                        body.find("#department").val(info.data.department);
                        body.find("#position").val(info.data.position);
                        body.find("#number").val(info.data.number);
                        body.find("#batchNumber").val(info.data.batchNumber);
                        body.find("#usefulLife").val(info.data.usefulLife);
                        body.find("#purchasePrice").val(info.data.purchasePrice);
                        body.find("#salePrice").val(info.data.salePrice);
                        body.find("#productDate").val(info.data.productDate);
                        body.find("#salePrice").val(info.data.salePrice);
                        body.find("#productDate").val(info.data.productDate);
                        body.find("#profits").val(info.data.profits);
                        body.find("#code").val(info.data.code);
                        body.find("#goodsType").val(info.data.goodsType);
                        body.find("#mType").val(info.data.mType);
                        body.find("#defined").val(info.data.defined);
                        body.find("#supplier").val(info.data.supplier);
                        body.find("#warehousingDate").val(info.data.warehousingDate);
                        body.find("#locationDescription").val(info.data.locationDescription);
                        body.find("#sign").val(info.data.sign);
                        body.find("#warehousingRemarks").val(info.data.warehousingRemarks);
                        body.find("#drugFrom").val(info.data.drugFrom);
                        body.find("#handingInformation").val(info.data.handingInformation);
                        body.find("#approvalNumber").val(info.data.approvalNumber);
                        body.find("#LastCuringDate").val(info.data.LastCuringDate);
                        body.find("#timesStorage").val(info.data.timesStorage);
                        body.find("#documentNumber").val(info.data.documentNumber);
                        body.find("#placeOrigin").val(info.data.placeOrigin);
                        body.find("#batchsNumber").val(info.data.batchsNumber);
                        body.find("#recordNumber").val(info.data.recordNumber);
                        body.find("#tableCoding").val(info.data.tableCoding);
                        console.log(tableCoding)
                    }
                })
            }
        });
    }
    function addStockAllForm(){
        layui.layer.open({
            title : "新增药品库存单",
            type : 2,
            content : "medicine/warehouseManage/stockAllForm/stockAllFormAdd.jsp",
            area:['600px','500px'],
        });
    }

    //绑定查询按钮事件
    $("#findButton").click(function () {
        select1 = $("#select1").val();
        select2 = $("#select2").val();
        select3 = $("#select3").val();
        select4 = $("#select4").val();
        $.ajax({
            url: '/StockAllForm?action=getStockAllFormByQuery', // 后端处理数据的URL
            type: "POST", // 或 'GET'，取决于后端接口的要求
            data: {
                select1,
                select2,
                select3,
                select4
            },
            dataType:"JSON",
            success: function(response) {
                console.log(response)
                // 在成功回调中处理后端返回的数据
                // 假设后端返回的数据是一个数组，可以根据数据格式进行处理
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                // 更新表格数据
                reloadTable(tableData);
            },
            error: function(error) {
                console.error('Error:', error);
            }
        });
    });

    $("#reset").click(function () {
        alert("ddd")
        select1 = $("#select1").val('');
        select2 = $("#select2").val('');
        select3 = $("#select3").val('');
        select4 = $("#select4").val('');

        tableIns.reload({
            url:"/StockAllForm?action=selectStockAllForm",
            page: {
                curr:1
            }
        })
    })



    //重新加载表格
    function reloadTable(data) {
        console.log(data)
        layui.use('table',function (){
            var table = layui.table;
            var tableIns = table.render({
                elem: "#stockAllFormList",
                data: data,//使用从后端获取的数据进行渲染
                toolbar: "#stockAllFormDemo",
                page: true,
                height: 600,
                limit: 15,
                limits: [5,10,15,20,25],
                cols: [[
                    {type: "checkbox", fixed: "left", width: 50},
                    {field: 'mId', title: '药品编号', hide: true, align: 'center', width: 100},
                    {field: 'mName', title: '药品名称', align: 'center', width: 100},
                    {field: 'specification', title: '规格', width: 100, align: "center"},
                    {field: 'manufactor', title: '生产厂家', width: 100, align: "center"},
                    {field: 'unit', title: '单位', width: 100, align: "center"},
                    {field: 'department', title: '部门', width: 100, align: "center"},
                    {field: 'position', title: '货位', width: 100, align: "center"},
                    {field: 'number', title: '数量', width: 100, align: "center"},
                    {field: 'batchNumber', title: '批号', width: 100, align: "center"},
                    {field: 'usefulLife', title: '有效期', width: 100, align: "center"},
                    {field: 'purchasePrice', title: '采购价', width: 100, align: "center"},
                    {field: 'salePrice', title: '销售价', width: 100, align: "center"},
                    {field: 'productDate', title: '生产日期', width: 100, align: "center"},
                    {field: 'profits', title: '利润金额', width: 100, align: "center"},
                    {field: 'code', title: '自编码', hide: true, width: 100, align: "center"},
                    {field: 'goodsType', title: '商品分类', width: 100, align: "center"},
                    {field: 'mType', title: '药品分类', width: 100, align: "center"},
                    {field: 'defined', title: '自定义类', width: 100, align: "center"},
                    {field: 'supplier', title: '供货商', width: 100, align: "center"},
                    {field: 'warehousingDate', title: '入库日期', width: 100, align: "center"},
                    {field: 'locationDescription', title: '货位说明', hide: true, width: 100, align: "center"},
                    {field: 'sign', title: '标志', width: 100, align: "center"},
                    {field: 'warehousingRemarks', title: '入库备注', width: 100, align: "center"},
                    {field: 'drugFrom', title: '剂型', width: 100, align: "center"},
                    {field: 'handingInformation', title: '处理情况', hide: true, width: 100, align: "center"},
                    {field: 'approvalNumber', title: '批准文号', width: 100, align: "center"},
                    {field: 'LastCuringDate', title: '上次养护日期', hide: true, width: 100, align: "center"},
                    {field: 'timesStorage', title: '入库次数', width: 100, align: "center"},
                    {field: 'documentNumber', title: '单据号码', hide: true, width: 100, align: "center"},
                    {field: 'placeOrigin', title: '产地', width: 100, align: "center"},
                    {field: 'batchsNumber', title: '批次号', hide: true, width: 100, align: "center"},
                    {field: 'recordNumber', title: '记录号', width: 100, align: "center"},
                ]],
            })
            //重新绑定工具栏,因为我们需要查很多次但上面只能查一次
            table.on('toolbar(stockAllFormList)',function (obj){
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                console.log(data)
                var tableCoding = '';
                for(i=0;i<data.length;i++){
                    tableCoding = data[i].tableCoding;
                }

            })
            //重新绑定搜索绑定并按条件查询
            $("#findButton").click(function () {
                select1 = $("#select1").val();
                select2 = $("#select2").val();
                select3 = $("#select3").val();
                select4 = $("#select4").val();
                $.ajax({
                    url: '/StockAllForm?action=getStockAllFormByQuery', // 后端处理数据的URL
                    type: "POST", // 或 'GET'，取决于后端接口的要求
                    data: {
                        select1,
                        select2,
                        select3,
                        select4
                    },
                    dataType:"JSON",
                    success: function(response) {
                        console.log(response)
                        // 在成功回调中处理后端返回的数据
                        // 假设后端返回的数据是一个数组，可以根据数据格式进行处理
                        var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                        // 更新表格数据
                        reloadTable(tableData);
                    },
                    error: function(error) {
                        console.error('Error:', error);
                    }
                });
            });
        })
    }

    //点击放大镜图标（搜索i标签）根据药品名查询
    $("#searchIcon").click(function (){
        var mName = $("#mName").val();
        console.log(mName);
        $.ajax({
            url:"/StockAllForm?action=getStockAllFormByDrugName",
            type:"POST",
            data:{
                "mName":mName,
            },
            dataType:"JSON",
            success:function (response){
                console.log(response);
                var tableData = response.data; // 假设数据在返回的响应中是一个名为 data 的属性
                console.log(tableData)
                renderTable(tableData); // 渲染表格数据
            },
        })
    })
    function renderTable(data){
        console.log(data)
        layui.use('table',function (){
            var table = layui.table;
            table.render({
                elem: '#stockAllFormList',
                data:data,
                cols : [[
                    {type: "checkbox", fixed: "left", width: 50},
                    {field: 'mId', title: '药品编号', hide: true, align: 'center', width: 100},
                    {field: 'mName', title: '药品名称', align: 'center', width: 100},
                    {field: 'specification', title: '规格', width: 100, align: "center"},
                    {field: 'manufactor', title: '生产厂家', width: 100, align: "center"},
                    {field: 'unit', title: '单位', width: 100, align: "center"},
                    {field: 'department', title: '部门', width: 100, align: "center"},
                    {field: 'position', title: '货位', width: 100, align: "center"},
                    {field: 'number', title: '数量', width: 100, align: "center"},
                    {field: 'batchNumber', title: '批号', width: 100, align: "center"},
                    {field: 'usefulLife', title: '有效期', width: 100, align: "center"},
                    {field: 'purchasePrice', title: '采购价', width: 100, align: "center"},
                    {field: 'salePrice', title: '销售价', width: 100, align: "center"},
                    {field: 'productDate', title: '生产日期', width: 100, align: "center"},
                    {field: 'profits', title: '利润金额', width: 100, align: "center"},
                    {field: 'code', title: '自编码', hide: true, width: 100, align: "center"},
                    {field: 'goodsType', title: '商品分类', width: 100, align: "center"},
                    {field: 'mType', title: '药品分类', width: 100, align: "center"},
                    {field: 'defined', title: '自定义类', width: 100, align: "center"},
                    {field: 'supplier', title: '供货商', width: 100, align: "center"},
                    {field: 'warehousingDate', title: '入库日期', width: 100, align: "center"},
                    {field: 'locationDescription', title: '货位说明', hide: true, width: 100, align: "center"},
                    {field: 'sign', title: '标志', width: 100, align: "center"},
                    {field: 'warehousingRemarks', title: '入库备注', width: 100, align: "center"},
                    {field: 'drugFrom', title: '剂型', width: 100, align: "center"},
                    {field: 'handingInformation', title: '处理情况', hide: true, width: 100, align: "center"},
                    {field: 'approvalNumber', title: '批准文号', width: 100, align: "center"},
                    {field: 'LastCuringDate', title: '上次养护日期', hide: true, width: 100, align: "center"},
                    {field: 'timesStorage', title: '入库次数', width: 100, align: "center"},
                    {field: 'documentNumber', title: '单据号码', hide: true, width: 100, align: "center"},
                    {field: 'placeOrigin', title: '产地', width: 100, align: "center"},
                    {field: 'batchsNumber', title: '批次号', hide: true, width: 100, align: "center"},
                    {field: 'recordNumber', title: '记录号', width: 100, align: "center"},
                ]],
            })
        })
    }
    $("#chartButton").click(function () {
        layer.open({
            type: 2,
            area: ['1200px', '520px'], // 宽高
            content: 'medicine/warehouseManage/stockAllForm/stockAllFormChart.jsp'
        });

    })
})