
layui.use(['laydate', 'form', 'jquery'], function() {
    var laydate = layui.laydate;
    var form = layui.form;
    var $ = layui.jquery;
    var table  = layui.table;

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
                var cs = JSON.parse(res)
                var dom = $("#manuFactor").empty().html('<option value="0">请选择</option>');
                console.log(cs)
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.rId + '">' + item.manufactor + '</option>');
                });
                // 确保下拉框被正确渲染
                form.render("select");
                form.on('select(manuFactor)', function(data) {
                    allManufactor = cs.find(item => item.rId == data.value)?.manufactor || '';
                    console.log("选中动作动作：" + allManufactor);
                    console.log(data.value)
                    // 重新加载表格数据
                    reloadTable(allManufactor);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }
    function reloadTable(manufactorName) {
        tableIns.reload({
            url: "/StockInForm?action=getDrugNameByManufactorName",
            where: {
                manufactorName: manufactorName
            },
            page: {
                curr: 1 // 重新从第 1 页开始
            }
        });
    }
        // 表格渲染
        var tableIns = table.render({
            elem: '#addStockInFormList',
            url : '/StockInForm?action=getDrugNameByManufactor',
            type: "post",
            where: {
                manufactorName: '' // 初始时默认不传递任何供应商名称
            },
            page : true,
            limit : 6,
            limits : [6],
            cols : [[
                {checkbox: true, rowspan: 2}, // 复选框列
                {field:'tableCoding', width:200, align:'center', title:'药品编号', rowspan: 2}, // 药品编号列
                {field:'mName', width:235, align:'center', title:'药品名', rowspan: 2}, // 药品名列
                {field:'totlNumber', width:200, align:'center', title:'待入库药品数量', rowspan: 2}, // 药品名列
                {field:'statue', width:100, align:'center', title:'质检状态', rowspan: 2}, // 药品名列
                {field:'storageStatus', width:100, align:'center', title:'入库状态', rowspan: 2}, // 药品名列
            ]],
            done:function (data){
                console.log(data)
            }
        });
});

