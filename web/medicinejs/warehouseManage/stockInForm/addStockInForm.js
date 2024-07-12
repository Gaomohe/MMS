
layui.use(['laydate', 'form', 'jquery'], function() {
    var laydate = layui.laydate;
    var form = layui.form;
    var $ = layui.jquery;

    laydate.render({
        elem: '#ID-laydate-type-datetime',
        type: 'datetime'
    });

    $(document).ready(function() {
        getLogAction();
    });

    var allManufactor;

    function getLogAction() {
        $.post("/StockInForm?action=getManufactorAll", function(res) {
            try {
                var cs = JSON.parse(res);

                var dom = $("#manuFactor").empty().html('<option value="0">请选择</option>');

                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.rId + '">' + item.manufactor + '</option>');
                });

                // 确保下拉框被正确渲染
                form.render("select");

                form.on('select(manuFactor)', function(data) {

                    allManufactor = cs.find(item => item.rId == data.value)?.manufactor || '';
                    console.log("选中动作动作：" + allManufactor);
                });

            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }
});



layui.use(['table', 'form', 'jquery', 'laydate'], function () {
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

    // 初始化表单
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
        cols: [[
            { field: 'rId', title: '#', type: 'numbers', minWidth: 100 },
            { field: 'rName', title: '药品名称',edit: 'text', minWidth: 100, totalRowText: '合计：'},
            { field: 'specification', title: '规格', edit: 'text', maxWidth: 80 },
            { field: 'unit', title: '单位', edit: 'text', maxWidth: 80 },
            { field: 'rNum', title: '数量', edit: true, maxWidth: 100, totalRow: true },
            { field: 'cost', title: '成本', edit: 'text', maxWidth: 80 },
            { field: 'salePrice', title: '销售价', edit: 'text', maxWidth: 100 },
            //批号自动生成
            //生产日期（根据选择的药品进行查询，并自动生成）
            //有效期至（根据选择的药品进行查询，并自动生成）
            //入库时间自动生成
            // 部门自动生成（都是急诊部，写死的）
            { field: 'notes', title: '备注', edit: 'text', maxWidth: 100 },
            { fixed: 'right', title: '操作', width: 134, minWidth: 125, align: 'center', toolbar: '#barDemo' },
        ]]
    });

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
