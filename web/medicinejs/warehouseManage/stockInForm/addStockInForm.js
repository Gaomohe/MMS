layui.use(function() {
    var laydate = layui.laydate;

// 日期时间选择器 - 日期和时间选择器同时显示（全面板）
    laydate.render({
        elem: '#ID-laydate-type-datetime',
        type: 'datetime',
        fullPanel: true // 2.8+
    })
})