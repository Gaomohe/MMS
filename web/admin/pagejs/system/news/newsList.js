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
        url : '/news?action=allNews',
        toolbar: '#toolbarDemo',
        page : true,
        height: 'full-145',
        limit : 10,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'id', title: '编号',  align:'center'},
            {field: 'title', title: '标题', minWidth:100, align:"center"},
            {field: 'content', title: '内容',  align:'center'},
            {field: 'date', title: '录入时间', align:'center'}
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
        var newsid = '';
        for(i=0;i<data.length;i++){
            newsid = data[i].id;
        }
        switch(obj.event){
            case 'addNews':	//添加咨询
                layui.layer.open({
                    title : "添加咨询",
                    type : 2,
                    content : "admin/page/system/news/newsAdd.jsp",
                    area:['400px','490px'],
                })
                break;

            case 'delNews':	//删除分类
                if(data.length == 0 || data.length > 1){
                    layer.msg("请选择一行数据进行操作")
                    return ;
                }else{
                    layer.confirm('确定删除此分类吗', {icon: 3, title:'提示'}, function(index){
                        delNews(newsid);
                        layer.close(index);
                    });
                }
                break;
        };
    });

    //删除分类
    function delNews(newsid){
        $.ajax({
            url:"/delNews",
            data:{"newsid":newsid},
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