layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table,
        dtree = layui.dtree;

    var supplier,buyUser,status,mainTable;

    $(document).ready(function() {
        laydate.render({
            elem: '#time'
        });

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
                {field: 'oId', title: '采购单号',  align:'center',width:100,hide:true},
                // {field: 'oName', title: '药品名',  align:'center',width:100},
                // {field: 'specification', title: '规格', width:100, align:"center"},
                {field: 'manufactor', title:'生产企业' , width:250, align:"center"},
                // {field: 'unit', title:'单位' , width:100, align:"center"},
                // {field: 'oNum', title:'订单数量' , width:100, align:"center"},
                // {field: 'salePrice', title:'采购单价' , width:100, align:"center"},
                {field: 'shippingAddress', title:'发货地址' , width:250, align:"center"},
                {field: 'deliveryAddress', title:'收货地址' , width:250, align:"center"},
                {field: 'shippingTime', title:'发货时间' , width:150, align:"center"},
                {field: 'allPrice', title:'订单总价格' , width:100, align:"center"},
                {field: 'shippingWay', title:'发货方式' , width:150, align:"center"},
                {field: 'tempControlWay', title:'温控方式' , width:100, align:"center"},
                {field: 'deliveryTime', title:'到货时间' , width:100, align:"center"},
                {field: 'deliveryTemp', title:'到货温度' , width:100, align:"center"},
                {field: 'attachment', title:'关联附件' , width:100, align:"center"},
                {field: 'salesman', title:'供货单位业务员' , width:100, align:"center"},
                {field: 'buyer', title:'采购人' , width:100, align:"center"},
                {field: 'recipient', title:'收货人' , width:100, align:"center"},
                // {field: 'orderCondition', title:'收货状态' , width:100, align:"center"},
                {field: 'statement', title:'收货状态' , width:100, align:"center"},

                {field: 'advance', title:'订单预付款' , width:150, align:"center"},
                {field: 'advanceStatus', title:'订单预付款状态' , width:200, align:"center"},
                {field: 'finals', title:'订单尾款' , width:150, align:"center"},
                {field: 'finalsStatus', title:'订单尾款状态' , width:200, align:"center"},
            ]],
            done:function (data){
                console.log(data)
            }
        });
        mainTable = tableIns;
        getSupplier();
        getBuyUser();
        getStatus();

        //工具栏事件
        table.on('toolbar(ordersList)', function(obj){
            console.log(obj)
            var checkStatus = table.checkStatus(obj.config.id);
            var data = checkStatus.data;
            var oId = '';
            for(var i=0; i<data.length; i++){
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
                case 'details':
                    console.log("aaaaaaaaaaaaaaaaaaaaa");
                    console.log(data[0].oId);
                    getOrderDetails(data[0].oId);
                    break;
                case 'search':
                    Search();
                    break;

            };
        });
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
                        // body.find("#orderCondition").val(info.data.orderCondition); // 收货状态
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

    function getOrderDetails(oId){
        console.log("99999999999999999");
        console.log(oId);
        layui.layer.open({
            title : "订单详情",
            type : 2,
            content: "/orders?action=getMenuBtn1&oId=" + oId,
            area:['1000px','600px']
        });
    }



    function getSupplier() {
        $.post("/orders?action=getOrderList", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#supplier").empty().html('<option value="0">供应商</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.oId + '">' + item.manufactor + '</option>');
                });
                form.render("select");

                form.on('select(supplier)', function(data) {
                    supplier = cs.find(item => item.oId == data.value)?.manufactor || '';
                    console.log("供货商：" + supplier);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function getBuyUser() {
        $.post("/orders?action=getOrderList1", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#buyUser").empty().html('<option value="0">采购人</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.oId + '">' + item.buyer + '</option>');
                });
                form.render("select");

                form.on('select(buyUser)', function(data) {
                    buyUser = cs.find(item => item.oId == data.value)?.buyer || '';
                    console.log("采购人：" + buyUser);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function getStatus() {
        $.post("/orders?action=getOrderList2", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#status").empty().html('<option value="0">订单状态</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.oId + '">' + item.statement + '</option>');
                });
                form.render("select");

                form.on('select(status)', function(data) {
                    status = cs.find(item => item.oId == data.value)?.statement || '';
                    console.log("订单状态：" + status);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function Search(){
        tableMain.reload({
            url: "/orders?action=Search",
            where: {
                "supplier": supplier,
                "buyUser": buyUser,
                "status": status,
            },
            page: { curr: 1 }
        });
    }

});
