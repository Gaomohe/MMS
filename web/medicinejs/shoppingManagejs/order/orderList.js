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
        elem: '#ordersList',
        url : '/orders?action=selectOrders',
        cellMinWidth : 95,
        page : true,
        toolbar: '#ordersDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'oId', title: '采购单号',  align:'center',width:100},
            {field: 'oName', title: '药品名',  align:'center',width:100,hide:true},
            {field: 'specification', title: '规格', width:100, align:"center"},
            {field: 'manufactor', title:'生产企业' , width:100, align:"center"},
            {field: 'unit', title:'单位' , width:100, align:"center",hide:true},
            {field: 'oNum', title:'订单数量' , width:100, align:"center",hide:true},
            {field: 'salePrice', title:'采购单价' , width:100, align:"center",hide:true},
            {field: 'shippingAddress', title:'发货地址' , width:100, align:"center"},
            {field: 'deliveryAddress', title:'收货地址' , width:100, align:"center"},
            {field: 'shippingTime', title:'发货时间' , width:100, align:"center"},
            {field: 'shippingWay', title:'发货方式' , width:100, align:"center"},
            {field: 'tempControlWay', title:'温控方式' , width:100, align:"center"},
            {field: 'deliveryTime', title:'到货时间' , width:100, align:"center"},
            {field: 'deliveryTemp', title:'到货温度' , width:100, align:"center"},
            {field: 'attachment', title:'关联附件' , width:100, align:"center"},
            {field: 'salesman', title:'供货单位业务员' , width:100, align:"center"},
            {field: 'buyer', title:'采购人' , width:100, align:"center"},
            {field: 'recipient', title:'收货人' , width:100, align:"center"},
            {field: 'orderCondition', title:'收货状态' , width:100, align:"center"},
            {field: 'statement', title:'收货说明' , width:100, align:"center"}
        ]],
        done:function (data){
            console.log(data)
        }
    });

    //工具栏事件
    table.on('toolbar(ordersList)', function(obj){
        console.log(obj)
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var oId = '';
        for(i=0;i<data.length;i++){
            oId = data[i].oId;
        }
        console.log(checkStatus)
        console.log(data)
        console.log(oId)
        switch(obj.event){
            case 'delOrders':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('确定删除此订单吗?', {icon: 3, title:'提示'}, function(index){
                    delOrders(oId);
                    layer.close(index);
                });
                break;

            case 'upOrders':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upOrders(oId);
                }
                break;

            case 'addOrders':
                addOrders();
                break;

        };
    });

    function delOrders(oId){
        $.ajax({
            url:"/orders?action=delOrders",
            type:"post",
            data:{"oId":oId},
            success:function(data){
                var info = JSON.parse(data);
                if(info.status == 200){
                    layer.msg("删除成功");
                    tableIns.reload("#ordersList");
                }
            }
        })
    }

    function upOrders(oId){
        layui.layer.open({
            title : "修改采购订单信息",
            type : 2,
            content : "medicine/shoppingManage/order/orderInfo.jsp",
            area:['550px','500px'],
            success:function(layero, index){
                $.ajax({
                    url:"/orders?action=selectOrdersById",//根据id查询的方法
                    type:"post",
                    data:{"oId":oId},
                    success:function(data){
                        var info = JSON.parse(data);
                        console.log(info);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#oId").val(info.data.oId); // 采购单号
                        body.find("#oName").val(info.data.oName); // 药品名
                        body.find("#specification").val(info.data.specification); // 规格
                        body.find("#manufactor").val(info.data.manufactor); // 生产企业
                        body.find("#unit").val(info.data.unit); // 单位
                        body.find("#oNum").val(info.data.oNum); // 订单数量
                        body.find("#salePrice").val(info.data.salePrice); // 采购单价
                        body.find("#shippingAddress").val(info.data.shippingAddress); // 发货地址
                        body.find("#deliveryAddress").val(info.data.deliveryAddress); // 收货地址
                        body.find("#shippingTime").val(info.data.shippingTime); // 发货时间
                        body.find("#shippingWay").val(info.data.shippingWay); // 发货方式
                        body.find("#tempControlWay").val(info.data.tempControlWay); // 温控方式
                        body.find("#deliveryTime").val(info.data.deliveryTime); // 到货时间
                        body.find("#deliveryTemp").val(info.data.deliveryTemp); // 到货温度
                        body.find("#attachment").val(info.data.attachment); // 关联附件
                        body.find("#salesman").val(info.data.salesman); // 供货单位业务员
                        body.find("#buyer").val(info.data.buyer); // 采购人
                        body.find("#recipient").val(info.data.recipient); // 收货人
                        body.find("#orderCondition").val(info.data.orderCondition); // 收货状态
                        body.find("#statement").val(info.data.statement); // 收货说明
                    }
                })
            }
        });
    }

    //新增经手人
    function addOrders(){
        layui.layer.open({
            title : "新增采购订单",
            type : 2,
            content : "medicine/shoppingManage/order/orderAdd.jsp",
            area:['400px','500px'],
        });
    }

})