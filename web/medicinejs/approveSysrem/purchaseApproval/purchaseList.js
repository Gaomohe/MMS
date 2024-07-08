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
    laydate.render({
        elem: '#ID-laydate-demo'
    });

    //表格渲染
    var tableIns = table.render({
        elem: '#purchaseList',
        url : '/approval?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#purchaseDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: '药品编号',  align:'center',width:100},
            {field: 'Name', title: '药品名称',  align:'center',width:100},
            {field: 'Name', title: '药品名称',  align:'center',width:100},
            {field: 'Name', title: '药品名称',  align:'center',width:100},
            {field: 'Name', title: '药品名称',  align:'center',width:100},
            {field: 'time', title:'申请时间' , width:150, align:"center"},
            {field: 'status', title:'状态' , width:150, align:"center"},
        ]],
    });
    table.on('toolbar(supplierList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var supplierId = '';
        for(i=0;i<data.length;i++){
            supplierId = data[i].sid;//这里得和上面的field里的id名对应
        }
        switch(obj.event){

        }

    });



});