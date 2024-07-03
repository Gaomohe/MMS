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
        elem: '#newsList',
        url : '/SelectProductAll',
        toolbar: '#toolbarDemo',
        page : false,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '商品编号', minWidth:100, align:"center"},
            {field: 'name', title: '商品名称', minWidth:100, align:"center"},
            {field: 'fileName', title: '商品图片', align:'center',templet:"#Img"},
            {field: 'stock',  title: '商品库存',  align:'center'},
            {field: 'price', title: '商品价格', minWidth:150, align:'center'}
        ]]
    });
   /* /!*-------- 搜索用户 ----------------------------*!/
    $("#doSubmit").click(function(){
        var like = $("#likename").val()
        tableIns.reload({
            url:"http://localhost:8723/EEDemo/Interfaces?action=allUser&uname="+like,
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })*/

    //工具栏事件
    table.on('toolbar(newsList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var proid = '';
        for(i=0;i<data.length;i++){
            proid = data[i].id;
        }
        switch(obj.event){
            case 'btn-expand':	//全部展开
                insTb.expandAll('#demoTreeTb');
                break;

            case 'btn-fold':	//全部折叠
                insTb.foldAll('#demoTreeTb');
                break;

            case 'addpro':	//新增商品
                addpro();
                break;

            case 'uppro':	//修改商品信息
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    upproduct(proid);
                }
                break;

            case 'delpro':	//下架商品
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    layer.confirm('确定下架此商品吗', {icon: 3, title:'提示'}, function(index){
                        delpro(proid);
                        layer.close(index);

                    });
                }
                break;
        };
    });

    //修改
    function upproduct(proid) {
        layui.layer.open({
            title: "修改商品信息",
            type: 2,
            content: "admin/page/product/productinfo.jsp",
            area: ['370px', '430px'],
            success: function (layero, index) {
                $.ajax({
                    url: "/selidproall",
                    type: "post",
                    data: {"proid": proid},
                    success: function (data) {
                        var info = eval('(' + data + ')');
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#shopid").val(info.id);
                        body.find("#name").val(info.name);
                        body.find("#fileName").val(info.fileName);
                        body.find("#fileName1").val(info.fileName);
                        body.find("#num").val(info.stock);
                        body.find("#price").val(info.price);
                    }
                })
            }
        })
    }




    //下架商品
    function delpro(id) {
        $.ajax({
            url: "/delproduct",
            data: {"proid": id},
            type: "post",
            success: function (data) {
                if (data == 1) {
                    layer.msg("删除成功")
                    tableIns.reload("#newsList");
                }
            }
        })
    }

    //新增用户
    function addpro(){
        layui.layer.open({
            title : "添加商品",
            type : 2,
            content : "admin/page/product/productAdd.jsp",
            area:['400px','490px'],
        })
    }
})