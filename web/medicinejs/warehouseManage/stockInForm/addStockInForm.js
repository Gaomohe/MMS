layui.use(function(){
    var laydate = layui.laydate;
    // 渲染
    laydate.render({
        elem: '#ID-laydate-demo'
    });
});
$(document).ready(function (){
    getLogAction();
})
var allManufactor;
function getLogAction() {
    $.post("/StockInForm?action=getManufactorAll", function(res) {
        try {
            var cs = JSON.parse(res);
            console.log(cs);
            console.log(cs[0].rId)
            console.log(cs[1].manufactor)
            var dom = $("#manufactor").empty().html('<option value="0">请选择</option>');
            $.each(cs, function(index, item) {
                dom.append('<option value="' + item.rId + '">' + item.manufactor + '</option>');
            });
            form.render("select");

            form.on('select(manufactor)', function(data) {
                allManufactor = cs.find(item => item.rId == data.value)?.manufactor || '';
                console.log("选中动作动作：" + allManufactor);
            });
        } catch (e) {
            console.error("Error parsing JSON:", e);
        }
    });
}


layui.use(['table', 'form', 'jquery','laydate'], function () {
    var table = layui.table;
    var form = layui.form;
    var laydate = layui.laydate;
    var $ = layui.jquery;
    var tableData = new Array();
    var param = {
        tempId: new Date().valueOf(),
        keyParam: '',
        valueParam: '',
    };
    tableData.push(param);

    // 提交事件


    //初始化表单
    table.render({
        elem: "#paramTable",
        id: 'paramTable',
        data: tableData,
        totalRow: true,
        title: '销售单',
        toolbar: '#toolbarDemo',
        defaultToolbar: ['filter', 'exports', 'print'],
        page: false,
        loading: false,
        even: false,
    // {type: "checkbox", fixed:"left", width:50},
    // {field: 'rId', title: '#',  align:'center',width:100},
    // {field: 'stockInNum', title: "入库单号",  align:'center',width:100},
    // {field: 'rName', title: '入库药品',  align:'center',width:100},
    // {field: 'standard', title: '规格', width:100, align:"center"},
    // {field: 'manufactor', title:'生产厂家' , width:100, align:"center"},
    // {field: 'unit', title:'单位' , width:100, align:"center"},
    // {field: 'rNum', title:'入库药品数量' , width:100, align:"center"},
    // {field: 'cost', title:'成本' , width:100, align:"center"},
    // {field: 'salePrice', title:'销售价' , width:100, align:"center"},
    // {field: 'batchNumber', title:'批号' , width:100, align:"center"},
    // {field: 'productDate', title:'生产日期' , width:100, align:"center"},
    // {field: 'expiration', title:'有效期至' , width:100, align:"center"},
    // {field: 'stockInTime', title:'入库时间' , width:100, align:"center"},
    // {field: 'department', title:'部门' , width:100, align:"center"},
    // {field: 'notes', title:'备注' , width:100, align:"center"},
        cols: [[
            { field: 'rId', title: '#', type: 'numbers',minWidth: 100},
            { field: 'rName', title: '药品名称', edit: 'text', minWidth: 100, totalRowText: '合计：' },
            // {field: 'standard', title: '规格', width:100, align:"center"},
            { field: 'unit', title: '单位', edit: 'text', maxWidth: 80 },
            { field: 'rNum', title: '数量', edit: true, maxWidth: 100, totalRow: true },
            // {field: 'cost', title:'成本' , width:100, align:"center"},
            { field: 'salePrice', title: '销售价', edit: 'text' , maxWidth: 100},
            // {field: 'batchNumber', title:'批号' , width:100, align:"center"},
            // {field: 'productDate', title:'生产日期' , width:100, align:"center"},
            // {field: 'expiration', title:'有效期至' , width:100, align:"center"},
            // {field: 'stockInTime', title:'入库时间' , width:100, align:"center"},
            // {field: 'department', title:'部门' , width:100, align:"center"},
            { field: 'je', title: '金额', totalRow: '{{= parseInt(d.TOTAL_NUMS) }} 元', edit: true, maxWidth: 100},
            { field: 'notes', title: '备注', edit: 'text',  maxWidth: 100 },
            { fixed: 'right', title: '操作', width: 134, minWidth: 125, align: 'center', toolbar: '#barDemo' },
        ]]
    })


    //添加事件
    table.on('toolbar(paramTable)', function (obj) {
        var options = obj.config; // 获取当前表格属性配置项
        var checkStatus = table.checkStatus(options.id); // 获取选中行相关数据
        console.log(obj); // 查看对象所有成员

        // 根据不同的事件名进行相应的操作
        switch (obj.event) { // 对应模板元素中的 lay-event 属性值
            case 'add':
                var oldData = table.cache["paramTable"];
                var newRow = {
                    tempId: new Date().valueOf(),
                    keyParam: '',
                    valueParam: '',
                }
                oldData.push(newRow);
                table.reload('paramTable', {
                    data: oldData
                });
                layer.msg('增加一行');
                break;
            case 'delete':
                layer.msg('删除');
                break;
            case 'update':
                table.reload('paramTable', { data: oldData });
                layer.msg('合计刷新');
                break;
        };
    });


    //删除行
    table.on('tool(paramTable)', function (obj) {
        var data = obj.data, event = obj.event, tr = obj.tr;
        switch (event) {
            case "del":
                layer.confirm('真的删除吗？', function (index) {
                    obj.del();
                    layer.close(index);
                    var oldData = table.cache["paramTable"];
                    for (var i = 0; i < oldData.length; i++) {
                        row = oldData[i];
                        if (!row || !row.tempId) {
                            oldData.splice(i, 1);    //删除一项
                        }
                        continue;
                    }
                    table.reload('paramTable', {
                        data: oldData
                    });
                });
        }
    });


    $("#execute").click(function () {
        var paramList = JSON.stringify(table.cache["paramTable"]);
        console.log(paramList);
    });
    // 日期
    laydate.render({
        elem: '#date'
    });
});


layui.use(function () {
    var table = layui.table;
    // 渲染
    table.render({
        elem: '#test',
        toolbar: '#toolbarDemo',
        // … // 其他属性
    });

    // 头部工具栏事件
    table.on('toolbar(test)', function (obj) {
        var options = obj.config; // 获取当前表格属性配置项
        var checkStatus = table.checkStatus(options.id); // 获取选中行相关数据
        console.log(obj); // 查看对象所有成员

        // 根据不同的事件名进行相应的操作
        switch (obj.event) { // 对应模板元素中的 lay-event 属性值
            case 'add':
                layer.msg('添加');
                break;
            case 'delete':
                layer.msg('删除');
                break;
            case 'update':
                layer.msg('编辑');
                break;
        };
    });
});

