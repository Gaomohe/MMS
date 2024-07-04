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



    /*------------- 加载销售数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#shoppingList',
        url : '/shopping?action=getAll',
        toolbar: '#shoppingDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [5,10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'mId', title: '药品id',  align:'center'},
            {field: 'mName', title: '药品名称',  align:'center'},
            {field: 'specification', title: '规格',  align:'center'},
            {field: 'number', title: '库存',  align:'center'},
            {field: 'purchasePrice', title: '价格',  align:'center'},
            {field: 'opera', title: '操作',  align:'center',templet:function (d){
                    return '<a href="/shopping?action=select&mId=' + d.mId + '" class="layui-btn layui-btn-xs">查询</a>';
                }},

        ]]
    });
    // // 获取搜素框
    // form.on('select()', function(data){
    //     var selectedValue = data.value;
    //     alert(selectedValue)
    // });


    //工具栏事件
    table.on('toolbar(shoppingList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var shopId = '';
        for(let i=0;i<data.length;i++){
            shopId = data[i].sid;//这里得和上面的field里的id名对应
        }
        switch(obj.event){
            case 'add':	//新增
                add();
                break;
            case 'time':	//时间
                time();
                break;
        }
    });

    function time(){
        laydate.render({
            elem: '#ID-laydate-demo',
            done:function (value, date, endDate){

            }
        });
    }
    function add(){
        layui.layer.open({
            title : "申请",
            type : 2,
            content : "medicine/shoppingManage/requestApply/applyList.jsp",
            area:['400px','500px'],
        });
    }


})