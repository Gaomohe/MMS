layui.use(['layer', 'form', 'table', 'util', 'laydate'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    var laydate = layui.laydate;

    form.render('select');

    // 渲染表格
    var insTb = table.render({
        elem: '#tableTbAdv',
        url: '../../../json/user.json',
        page: true,
        cellMinWidth: 100,
        cols: [[
            {type: 'checkbox'},
            {field: 'username', align: 'center', sort: true, title: '账号'},
            {field: 'nickName', align: 'center', sort: true, title: '用户名'},
            {field: 'phone', align: 'center', sort: true, title: '手机号'},
            {field: 'sex', align: 'center', sort: true, title: '性别'},
            {
                field: 'createTime', sort: true, align: 'center', templet: function (d) {
                    return util.toDateString(d.createTime);
                }, title: '创建时间'
            },
            {field: 'state', align: 'center', sort: true, templet: '#tplStateTbAdv', title: '状态'},
            {align: 'center', toolbar: '#tableBarTbAdv', title: '操作', minWidth: 150}
        ]]
    });

    // 搜索
    form.on('submit(formSubSearchTbAdv)', function (data) {
        insTb.reload({where: data.field}, 'data');
    });

    // 渲染laydate
    laydate.render({
        elem: '#edtDateTbAdv'
    });

    // 导出excel
    $('#btnExportTbAdv').click(function () {
        var checkRows = table.checkStatus('tableTbAdv');
        if (checkRows.data.length == 0) {
            layer.msg('请选择要导出的数据', {icon: 2});
        } else {
            table.exportFile(insTb.config.id, checkRows.data, 'xls');
        }
    });

});