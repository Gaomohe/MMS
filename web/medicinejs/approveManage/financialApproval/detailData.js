layui.use(['form', 'layedit', 'laydate','table'], function(){

    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate
        ,$ = layui.jquery
        ,table = layui.table;
    var insTb;

    window.addEventListener('message', function(event) {
        var messageData = event.data;
        let info = JSON.parse(messageData);
        insTb = table.render({
            elem: '#detailList',
            data: info.data,
            page: false,
            cellMinWidth: 100,
            cols: [[
                // {type: "checkbox", fixed:"left", width:50,hide:true},
                {field: 'mId', title: '药品编号',  align:'center',width:100,sort:true},
                {field: 'applyBuyNumber', title: '申请数量',  align:'center',width:100},
                {field: 'mName', title: '药品名称',  align:'center',width:100},
                {field: 'specification', title: '规格',  align:'center',width:100},
                {field: 'manufactor', title: '生产商',  align:'center',width:100},
                {field: 'unit', title: '类型',  align:'center',width:100},
                {field: 'department', title: '所用部门',  align:'center',width:100},
                {field: 'purchasePrice', title: '价格',  align:'center',width:100},
                {field: 'salePrice', title: '售价',  align:'center',width:100},
                {field: 'productDate', title: '生产日期',  align:'center',width:100},
                {field: 'goodsType', title: '种类',  align:'center',width:100},
                {field: 'mType', title: '用途',  align:'center',width:100},
                {field: 'defined', title: '处方药',  align:'center',width:100},
            ]],
            done:function (){
            }
        });

    }, false);
})