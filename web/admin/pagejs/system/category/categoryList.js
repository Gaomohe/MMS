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


    /*------------- 加载分类数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#newsList',
        url : '/allCategory',
        toolbar: '#toolbarDemo',
        page : false,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'name', title: '分类名', minWidth:100, align:"center"},
            {field: 'parentId', title: '父级Id',  align:'center'},
            {field: 'type', title: '类级', align:'center'}
        ]]
    });
    /*------------- 加载分类数据 --end------------------------------*/

    /*-------- 搜索用户 ----------------------------*/
    /*$("#doSubmit").click(function(){
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
        var cateid = '';
        for(i=0;i<data.length;i++){
            cateid = data[i].id;
        }
        switch(obj.event){
            case 'addClass':	//添加分类
                layui.layer.open({
                    title : "添加分类",
                    type : 2,
                    content : "admin/page/system/category/categoryAdd.jsp",
                    area:['400px','490px'],
                })
                break;

            case 'delClass':	//删除分类
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    layer.confirm('确定删除此分类吗', {icon: 3, title:'提示'}, function(index){
                        delClass(cateid);
                        layer.close(index);
                    });
                }
                break;
        };
    });

    //删除分类
    function delClass(cateid){
        $.ajax({
            url:"/delClass",
            data:{"cateid":cateid},
            type:"post",
            dataType:"json",
            success:function(data){
                if(data.status == 1){
                    layer.msg("删除成功")
                    tableIns.reload();
                }
            }
        })
    }


})
