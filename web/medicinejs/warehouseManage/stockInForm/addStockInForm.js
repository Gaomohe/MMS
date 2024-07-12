
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

    layui.use('table', function(){
        var table = layui.table;
        // 表格渲染
        var tableIns = table.render({
            elem: '#addStockInFormList',
            url : '/StockInForm?action=getDrugNameByManufactor',
            page : true,
            limit : 6,
            limits : [6],
            cols : [[
                {checkbox: true, rowspan: 2}, // 复选框列
                {field:'rId', width:150, align:'center', title:'药品编号', rowspan: 2}, // 药品编号列
                {field:'rName', width:235, align:'center', title:'药品名', rowspan: 2}, // 药品名列
                {fixed: 'right', width:160, align:'center', toolbar: '#templet-demo-theads-tool', title:'操作', rowspan: 2} // 操作列
            ]]
        });
    });
});

