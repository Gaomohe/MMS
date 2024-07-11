layui.use(['layer', 'form', 'laydate'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var laydate = layui.laydate;

    // 渲染laydate
    laydate.render({
        elem: '#edtDateFormBas',
        range: true
    });

    // 监听表单提交
    form.on('submit(formSubmitBas)', function (data) {
        console.log(data.field);
        return false;
    });
});