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
            {field: 'mId', title: '药品编号',  align:'center',width:100},
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
            {field: 'code', title:'自编码' , width:100, align:"center"},
            {field: 'goodsType', title:'商品分类' , width:100, align:"center"},
            {field: 'mType', title:'药品分类' , width:100, align:"center"},
            {field: 'defined', title:'自定义类' , width:100, align:"center"},
            {field: 'supplier', title:'供货商' , width:100, align:"center"},
            {field: 'warehousingDate', title:'入库日期' , width:100, align:"center"},
            {field: 'locationDescription', title:'货位说明' , width:100, align:"center"},
            {field: 'sign', title:'标志' , width:100, align:"center"},
            {field: 'warehousingRemarks', title:'入库备注' , width:100, align:"center"},
            {field: 'drugFrom', title:'剂型' , width:100, align:"center"},
            {field: 'handlingInformation', title:'处理情况' , width:100, align:"center"},
            {field: 'approvalNumber', title:'批准文号' , width:100, align:"center"},
            {field: 'LastCuringDate', title:'上次养护日期' , width:100, align:"center"},
            {field: 'timesStorage', title:'入库次数' , width:100, align:"center"},
            {field: 'documentNumber', title:'单据号码' , width:100, align:"center"},
            {field: 'placeOrigin', title:'产地' , width:100, align:"center"},
            {field: 'batchsNumber', title:'批次号' , width:100, align:"center"},
            {field: 'recordNumber', title:'记录号' , width:100, align:"center"},

        ]],
        done:function (data){
            console.log(data)
        }
    });

    //工具栏事件
    table.on('toolbar(stockAllFormList)', function(obj){
        console.log(obj)
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var mId = '';
        for(i=0;i<data.length;i++){
            mId = data[i].mId;
        }
        console.log(mId)
        switch(obj.event){
            case 'delStockAllForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('确定删除此入库单吗?', {icon: 3, title:'提示'}, function(index){
                    delStockAllForm(mId);
                    layer.close(index);
                });
                break;

            case 'updateStockInForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    updateStockAllForm(rId);
                }
                break;

            case 'addStockAllForm':
                addStockAllForm();
                break;

        };
    });

    function delStockAllForm(mId){
        $.ajax({
            url:"/StockAllForm?action=delStockAllForm",
            type:"post",
            data:{"mId":mId},
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

    function updateStockAllForm(rId){
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
                        body.find("#department").val(info.data.department);
                    }
                })
            }
        });
    }
    function addStockAllForm(){
        layui.layer.open({
            title : "新增入库单",
            type : 2,
            content : "medicine/warehouseManage/stockInForm/stockInFormAdd.jsp",
            area:['400px','500px'],
        });
    }

})