layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','laytpl','dtree'],function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    var tableIns = table.render({
        elem: '#List',
        url : '/order?action=SelectOrderAll',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '订单编号', minWidth:100, align:"center"},
            {field: 'loginName', title: '用户名', minWidth:100, align:"center"},
            {field: 'userAddress', title: '订单地址', align:'center'},
            {field: 'createTime',  title: '创建时间',  align:'center'},
            {field: 'cost', title: '订单价格', minWidth:150, align:'center'}
        ]]
    });

    //工具栏事件
    table.on('toolbar(List)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var orid = '';
        for(i=0;i<data.length;i++){
            orid = data[i].id;
        }
        switch(obj.event){
            case 'upor':	//修改订单信息
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    uporder(orid);
                }
                break;

            case 'delor':	//下架商品
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    layer.confirm('确定下架此商品吗', {icon: 3, title:'提示'}, function(index){
                        delOrder(orid);
                        layer.close(index);
                    });
                }
                break;
        };
    });

    //修改
     function uporder(orid) {
         layui.layer.open({
             title: "修改订单信息",
             type: 2,
             content: "admin/page/system/order/orderinfo.jsp",
             area: ['370px', '430px'],
             success: function (layero, index) {
                 $.ajax({
                     url: "/selOrderid",
                     type: "post",
                     data: {"orid": orid},
                     success: function (data) {
                         var info = eval('(' + data + ')');
                         var body = layui.layer.getChildFrame('body', index);
                         body.find("#orderid").val(info.id);
                         body.find("#loginName").val(info.loginName);
                         body.find("#address").val(info.userAddress);
                         body.find("#ctime").val(info.createTime);
                         body.find("#price").val(info.cost);
                     }
                 })
             }
         })
     }




    //删除订单
    function delOrder(id) {
        $.ajax({
            url: "/delOrder",
            data: {"orid": id},
            type: "post",
            success: function (data) {
                if (data == 1) {
                    layer.msg("删除成功")
                    tableIns.reload("#newsList");
                }
            }
        })
    }
})