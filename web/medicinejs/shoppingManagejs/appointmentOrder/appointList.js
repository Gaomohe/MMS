layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    /*------------- 加载时间 --------------------------------*/
    laydate.render({
        elem: '#ID-laydate-demo'
    });
    /*------------- 加载销售数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#userList',
        url : '/user?action=getAllUser',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [5,10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {title:'操作', width:150, templet: '#barDemo'}

        ]]
    });



})