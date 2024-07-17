
layui.use(['laydate', 'form', 'jquery','table'], function() {
    var laydate = layui.laydate;
    var form = layui.form;
    var $ = layui.jquery;
    var table  = layui.table;

    laydate.render({
        elem: '#time',
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
                {field:'rId', width:200, align:'center', hide:true, title:'药品编号', rowspan: 2}, // 药品编号列
                {field:'rName', width:100, align:'center', title:'药品名', rowspan: 2}, // 药品名列
                {field:'standard', width:150, align:'center', title:'药品规格', rowspan: 2}, // 药品名列
                {field:'unit', width:100, align:'center', title:'单位', rowspan: 2}, // 药品名列
                {field:'cost', width:50, align:'center', title:'成本', hide:true,rowspan: 2}, // 药品名列
                {field:'salePrice', width:50, align:'center', title:'销售价',hide:true, rowspan: 2}, // 药品名列
                {field:'batchNumber', width:150, align:'center', title:'批号',hide:true, rowspan: 2}, // 药品名列
                {field:'productDate', width:150, align:'center', title:'生产日期',hide:true, rowspan: 2}, // 药品名列
                {field:'expiration', width:150, align:'center', title:'保质期', hide:true,rowspan: 2}, // 药品名列
                {field:'department', width:150, align:'center', title:'部门', rowspan: 2}, // 药品名列
                {field:'totlNumber', width:100, align:'center', title:'待入库药品数量', rowspan: 2}, // 药品名列
                {field:'statue', width:100, align:'center',hide:true, title:'质检状态', rowspan: 2}, // 药品名列
                {field:'storageStatus', width:100, align:'center', title:'入库状态', rowspan: 2}, // 药品名列
            ]],
            done:function (data){
                console.log(data)
            }
        });

    $('#saveButton').click(function() {
        // 获取表格勾选的行数据
        var checkStatus = table.checkStatus('addStockInFormList'); // 确保这里的ID正确
        var data = checkStatus.data;
        var rId = '';

        for (var i = 0; i < data.length; i++) {
            $.ajax({
                url:"/StockInForm?action=addStockInForm",
                data:{
                    "rId":data[i].rId,
                    "time":$("#time").val(),
                    "stockInNum":$("#stockInNum").val(),
                    "manufactor":$("#manuFactor").val(),
                    "standard":data[i].standard,
                    "unit":data[i].unit,
                    "cost":data[i].cost,
                    "salePrice":data[i].salePrice,
                    "batchNumber":data[i].batchNumber,
                    "productDate":data[i].productDate,
                    "expiration":data[i].expiration,
                    "department":data[i].department,
                    "rName":data[i].rName,
                    "totlNumber":data[i].totlNumber,
                    "statue":data[i].statue,
                    "storageStatus":data[i].storageStatus
                },
                type:"post",
                success:function(data){
                    console.log(data)
                    var info = JSON.parse(data);
                    if(info.status == 200){
                        layer.msg("入库成功")
                        setTimeout(function(){
                            layer.closeAll("iframe");
                            //刷新父页面
                            parent.location.reload();
                        },1000);
                    }else{
                        layer.msg("系统异常");
                    }
                }
            })
        }
            return false;
    })

    $('#cancelButton').click(function() {
        var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
        parent.layer.close(index); // 关闭模态框
    });
});

