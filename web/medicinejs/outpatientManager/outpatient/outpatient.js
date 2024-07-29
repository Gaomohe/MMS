layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'
}).use(['form', 'layer', 'laydate', 'table', 'upload', 'dtree', 'element', 'jquery'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;

    var tableMain;
    $(document).ready(function () {
        laydate.render({
            elem: '#time'
        });

        tableMain = table.render({
            elem: '#outpatientList',
            url: '/patient?action=getPatientList',
            cellMinWidth: 95,
            page: true,
            toolbar: '#outpatientDemo',
            height: "900px",
            limit: 20,
            limits: [10, 15, 20, 25],
            cols: [[
                {fixed: "left", type: "checkbox", width: 50},
                {field: 'pId', title: '患者卡号', align: 'center', width: 200, sort: true},
                {field: 'name', title: '患者姓名', align: 'center', width: 200, sort: true},
                {field: 'sex', title: '性别', align: 'center', width: 200, sort: true},
                {field: 'age', title: '年龄', minWidth: 100, align: "center", sort: true},
                {field: 'weight', title: '体重/kg', align: 'center', width: 200, sort: true},
                {field: 'address', title: '住址', align: 'center', width: 200, sort: true},
                {field: 'phone', title: '联系方式', align: 'center', width: 200, sort: true},
                {field: 'diagnosticTime', title: '就诊时间', align: 'center', width: 200, sort: true},
                {field: 'allergy', title: '过敏史', align: 'center', width: 200, sort: true},
                {field: 'doctorAdvice', title: '医嘱', align: 'center', width: 200, sort: true},
                {field: 'dName', title: '医生姓名', align: 'center', width: 200, sort: true},
                {field: 'lastDiaTime', title: '上次就诊时间', align: 'center', width: 200, sort: true}
            ]],
        });

        table.on('row(outpatientList)', function (obj) {
            var data = obj.data;
            var tr = obj.tr;
            var checkbox = tr.find('input[type="checkbox"]');
            var event = window.event || arguments.callee.caller.arguments[0];
            var target = event.target || event.srcElement;

            if (target === checkbox[0] || $(target).closest('td').find('input[type="checkbox"]').length > 0) {
                return;
            }

            console.log("点击了表格行");
            console.log(data.pId);
            addMedicine(data.pId);
            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });

        table.on('toolbar(outpatientList)', function (obj) {
            var checkdata = table.checkStatus(obj.config.id);
            var files = checkdata.data;

            switch (obj.event) {
                case 'addPatient':
                    addPatient();
                    break;
            }
        });
    });

    $("#submit").click(function (e) {
        e.preventDefault(); // 阻止表单的默认提交行为
        var formData = $("#searchForm").serializeArray();
        var searchData = {};

        $.each(formData, function (i, field) {
            searchData[field.name] = field.value;
        });

        // 调试输出
        console.log("搜索内容：", searchData);

        // 重新加载表格数据
        layui.table.reload('outpatientList', {
            url: '/patient?action=Search',  // 确保 URL 正确
            where: searchData,             // 传递的查询条件
            page: { curr: 1 },             // 重置分页到第一页
            response: {                    // 确保数据格式正确
                statusCode: 200,           // 状态码配置
                countName: 'count',        // 数据总数字段名
                dataName: 'data',          // 数据字段名
                msgName: 'msg'             // 消息字段名
            },
            done: function(res, curr, count) {
                console.log("数据加载完成:", res);  // 调试输出
                if (res.code !== 200) {
                    layer.msg(res.msg || '加载失败');
                }
            }
        });
    });



    $("#reload").click(function () {
        tableMain.reload();
    })


});
