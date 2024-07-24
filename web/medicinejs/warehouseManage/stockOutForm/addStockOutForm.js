
layui.use(['laydate', 'form', 'jquery','table'], function() {
    var laydate = layui.laydate;
    var form = layui.form;
    var $ = layui.jquery;
    var table  = layui.table;

    // 表格渲染
    var tableIns = table.render({
        elem: '#NormalStockOutList',
        url : '/StockOutForm?action=getNormalStockOut',
        type: "post",
        page : true,
        limit : 6,
        limits : [6],
        cols : [[
            {field: 'pid', title: '#',hide:true, align:'center',width:170},
            {field: 'name', title: '患者姓名',  align:'center',width:170},
            {field: 'mName', title: '药品名称', width:200, align:"center"},
            {field: 'defined', title:'药品类型' , width:200, align:"center"},
            {field: 'number', title:'出库数量' , width:200, align:"center"},
            {field: 'status', title:'取药/出库状态' , width:200, align:"center"},
            {field: 'getmTime', title:'出库时间' , width:200, align:"center"},
        ]],
        done:function (data){
            console.log(data)
        }
    });

    $('#confirm').click(function() {
        var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
        parent.layer.close(index); // 关闭模态框
    });
});

