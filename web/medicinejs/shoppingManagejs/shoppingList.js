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
            {field: 'userName', title: '登录名', minWidth:100, align:"center"},
            {field: 'sex', title: '用户性别', align:'center'},
            {field: 'age', title: '年龄', align:'center'},
            {field: 'password', title: '密码', minWidth:100, align:"center"},
            // {field: 'cardBalance', title: '医疗卡余额',  align:'center'},
            // {field: 'code', title: '编码',  align:'center'},
            {field: 'telNumber', title: '联系方式',  align:'center'},
            {field: 'address', title: '家庭住址',  align:'center'},
            {field: 'birthday', title: '出生日期',  align:'center'},
            {field: 'createDate', title: '创建时间',  align:'center'},
            {field: 'wechat', title: '微信',  align:'center'},
            {title:'操作', width:150, templet: '#barDemo'}
        ]]
    });


})