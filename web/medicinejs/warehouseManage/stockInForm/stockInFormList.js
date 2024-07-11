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

    layui.use(function () {
        var laydate = layui.laydate;
        // 渲染
        laydate.render({
            elem: '#ID-laydate-demo'
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
            {field: 'rId', title: '入库单号',  align:'center',width:100},
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
            {field: 'notes', title:'备注' , width:100, align:"center"},

        ]],
        done:function (data){
            console.log(data)
        }
    });
    //根据入库单号/药品信息/入库日期查询和重置的事件
        // 绑定“查询”点击事件
    $("#queryButton").click(function() {
        var rId = $("#rId").val();
        var rName = $("#rName").val();
        var stockInTime = $("#stockInTime").val();
        console.log(rName);
        $.ajax({
            url:"/StockInForm?action=getStockInFormByQuery",
            type:"POST",
            data:{
                "rId":rId,
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
    function renderTable(data){
        console.log(data)
        layui.use('table',function (){
            var table = layui.table;
            table.render({
                elem: '#stockInFormList',
                data:data,
                cols : [[
                    {type: "checkbox", fixed:"left", width:50},
                    {field: 'rId', title: '入库单号',  align:'center',width:100},
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
                    {field: 'notes', title:'备注' , width:100, align:"center"},
                ]],
                done:function (data){
                    console.log(data)
                }
            })
        })
    }
    //绑定“重置”点击时间



    //工具栏事件
    table.on('toolbar(stockInFormList)', function(obj){
        console.log(obj)
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var rId = '';
        for(i=0;i<data.length;i++){
            rId = data[i].rId;
        }
        console.log(rId)
        switch(obj.event){
            case 'delStockInForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('确定删除此入库单吗?', {icon: 3, title:'提示'}, function(index){
                    delStockInForm(rId);
                    layer.close(index);
                });
                break;

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
                console.log(data)
                var info = JSON.parse(data);
                if(info.status == 200){
                    layer.msg("删除成功");
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
            btn: ['保存并审核', '取消'],
            btnAlign: 'c',
            yes: function (index, layero) {
                // 获取 iframe 的窗口对象
                var iframeWin = window[layero.find('iframe')[0]['name']];
                var elemMark = iframeWin.$('#mark'); // 获得 iframe 中某个输入框元素
                var value = elemMark.val();

                if ($.trim(value) === '') return elemMark.focus();
                // 显示获得的值
                layer.msg('获得 iframe 中的输入框标记值：' + value);
            }
        })
        // layui.layer.open({
        //     title : "新增入库单",
        //     type : 2,
        //     content : "medicine/warehouseManage/stockInForm/stockInFormAdd.jsp",
        //     area:['400px','500px'],
        // });
    }

})