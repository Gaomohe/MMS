
layui.use(['laydate', 'form', 'jquery','table'], function() {
    var laydate = layui.laydate;
    var form = layui.form;
    var $ = layui.jquery;
    var table  = layui.table;

    $(document).ready(function() {
        getLogAction();
    });

    var allManufactor;

    function getLogAction() {
        $.post("/StockInForm?action=getManufactorAll", function(res) {
            //获取订单表里的所有供应商
            try {
                var cs = JSON.parse(res);
                var dom = $("#manuFactor").empty().html('<option value="0">请选择</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.oId + '">' + item.manufactor + '</option>');
                });
                form.render("select");

                form.on('select(manuFactor)', function(data) {
                    allManufactor = cs.find(item => item.oId == data.value)?.manufactor || '';
                    console.log("供应商名称：" + allManufactor);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }
    ////////////根据供应商名称和药品名称来查询并显示表格，状态为已入库
    $("#search").click(function (){
        var rName = $("#rName").val();
        console.log(rName)
        tableIns.reload({
            url: "/StockInForm?action=getStockInFormByManufactorAndDrugName",
            where: {
                manufactorName: allManufactor,
                rName:rName
            },
            page: {
                curr: 1 // 重新从第 1 页开始
            }
        });
    })
    //重置按钮
    $('#reset').click(function(){
        alert("reset")
        $("#manuFactor").val('0');
        $("#rName").val('');
        // 重新加载表格数据
        table.reload('addStockInFormList', {
            url: '/StockInForm?action=getAllStockForm', // 请替换为实际的数据接口
            where: {
                manufactorName: ''
            },
            page: {
                curr: 1 // 重置到第一页
            }
        });
    })
        // 表格渲染
        var tableIns = table.render({
            elem: '#addStockInFormList',
            url : '/StockInForm?action=getAllStockForm',
            type: "post",
            where: {
                manufactorName: '',// 初始时默认不传递任何供应商名称


            },
            page : true,
            limit : 6,
            limits : [6],
            cols : [[
                {checkbox: true, rowspan: 2}, // 复选框列
                {field:'rId', width:200, align:'center', hide:true, title:'药品编号', rowspan: 2}, // 药品编号列
                {field:'rName', width:200, align:'center', title:'药品名', rowspan: 2}, // 药品名列
                {field:'standard', width:200, align:'center', title:'药品规格', rowspan: 2}, // 药品名列
                {field:'unit', width:170, align:'center', title:'单位', rowspan: 2}, // 药品名列
                {field:'cost', width:50, align:'center', title:'成本', hide:true,rowspan: 2}, // 药品名列
                {field:'salePrice', width:50, align:'center', title:'销售价',hide:true, rowspan: 2}, // 药品名列
                {field:'batchNumber', width:150, align:'center', title:'批号',hide:true, rowspan: 2}, // 药品名列
                {field:'productDate', width:150, align:'center', title:'生产日期',hide:true, rowspan: 2}, // 药品名列
                {field:'expiration', width:150, align:'center', title:'保质期', hide:true,rowspan: 2}, // 药品名列
                {field:'department', width:170, align:'center', title:'部门', rowspan: 2}, // 药品名列
                {field:'totlNumber', width:150, align:'center', title:'待入库药品数量', rowspan: 2}, // 药品名列
                {field:'statue', width:100, align:'center',hide:true, title:'质检状态', rowspan: 2}, // 药品名列
                {field:'storageStatus', width:200, align:'center', title:'入库状态', rowspan: 2}, // 药品名列
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

