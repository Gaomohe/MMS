layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    //表格渲染
    var tableIns = table.render({
        elem: '#stockOutFormList',
        url : '/StockOutForm?action=selectStockOutForm',
        cellMinWidth : 95,
        page : true,
        toolbar: '#stockOutFormDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'outId', title: '出库单号',  align:'center',width:100},
            {field: 'outStatus', title: '出库单状态',  align:'center',width:100},
            {field: 'oDate', title: '出库日期', width:100, align:"center"},
            {field: 'oManufactor', title:'往来单位' , width:100, align:"center"},
            {field: 'oType', title:'出库类型' , width:100, align:"center"},
            {field: 'oNum', title:'出库明细数' , width:100, align:"center"},
            {field: 'oSalePrice', title:'销售金额' , width:100, align:"center"},
            {field: 'oAmount', title:'出库总金额' , width:100, align:"center"},
            {field: 'oCost', title:'成本金额' , width:100, align:"center"},
            {field: 'operator', title:'操作员' , width:100, align:"center"},
            {field: 'auditor', title:'审核人' , width:100, align:"center"},
            {field: 'auditTime', title:'审核时间' , width:100, align:"center"},
            {field: 'department', title:'部门' , width:100, align:"center"},

        ]],
        done:function (data){
            console.log(data)
        }
    });

    //工具栏事件
    table.on('toolbar(stockOutFormList)', function(obj){
        console.log(obj)
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var outId = '';
        for(i=0;i<data.length;i++){
            outId = data[i].outId;
        }
        console.log(outId)
        switch(obj.event){
            case 'delStockOutForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                layer.confirm('确定删除此出库单吗?', {icon: 3, title:'提示'}, function(index){
                    delStockOutForm(outId);
                    layer.close(index);
                });
                break;

            case 'updateStockOutForm':
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    updateStockOutForm(outId);
                }
                break;

            case 'addStockOutForm':
                addStockOutForm();
                break;

        };
    });

    function delStockOutForm(outId){
        $.ajax({
            url:"/StockOutForm?action=delStockOutForm",
            type:"post",
            data:{"outId":outId},
            success:function(data){
                console.log(data)
                var info = JSON.parse(data);
                if(info.status == 200){
                    layer.msg("删除成功");
                    tableIns.reload("#stockOutFormList");
                }
            }
        })
    }

    function updateStockOutForm(outId){
        layui.layer.open({
            title : "修改入库单信息",
            type : 2,
            content : "medicine/warehouseManage/stockInForm/stockInFormInfo.jsp",
            area:['550px','500px'],
            success:function(layero, index){
                $.ajax({
                    url:"/StockOutForm?action=selectStockInFormById",//根据id查询的方法
                    type:"post",
                    data:{"outId":outId},
                    success:function(data){
                        var info = JSON.parse(data);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#rId").val(info.data.rId);
                        body.find("#rName").val(info.data.rName);
                        body.find("#standard").val(info.data.standard);
                        body.find("#manufactor").val(info.data.manufactor);
                        body.find("#unit").val(info.data.unit);
                        body.find("#rNum").val(info.data.rNum);
                        body.find("#cost").val(info.data.cost);
                        body.find("#salePrice").val(info.data.salePrice);
                        body.find("#batchNumber").val(info.data.batchNumber);
                        body.find("#productDate").val(info.data.productDate);
                        body.find("#expiration").val(info.data.expiration);
                        body.find("#department").val(info.data.department);
                    }
                })
            }
        });
    }
    function addStockOutForm(){
        layer.open({
            type: 2,
            content : "medicine/warehouseManage/stockOutForm/stockOutFormAdd.jsp",
            area: ['720px', '520px'],
            fixed: false, // 不固定
            maxmin: true,
            shadeClose: true,
            btn: ['保存并审核', '取消'],
            btnAlign: 'c',
            yes: function (index, layero) {
                // 获取 iframe 的窗口对象
                var iframeWin = window[layero.find('iframe')[0]['name']];
                var elemMark = iframeWin.$('#mark'); // 获得 iframe 中某个输入框元素
                var value = elemMark.val();

                if ($.trim(value) === '') return elemMark.focus();
                // 显示获得的值
                layer.msg('获得 iframe 中的输入框标记值：' + value);
            }
        })
    }

})