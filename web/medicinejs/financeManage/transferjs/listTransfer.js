layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree','element','jquery'],function() {
    var table = layui.table;
    var layer = parent.layer === undefined ? layui.layer : top.layer;
    var $ = layui.jquery;


    var tableIns = table.render({
        // 全部
        elem: '#transferList',
        url : '/bill?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#transferDemo',
        height : "800px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},

        ]],
        done:function (data){
        }
    });


})