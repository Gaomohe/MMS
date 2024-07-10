layui.use(['layer', 'element', 'util', 'table', 'tableX','mousewheel','form'], function() {
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var util = layui.util;
    var table = layui.table;
    var tableX = layui.tableX;
    var layer = layui.layer;
    var form = layui.from;

    // 前端分页
    var tableIns=tableX.render({
        elem: '#xTable1',
        url: '/medicine?action=getAllMedicine',
        toolbar: '#toolbarDemo',
        page: true,
        height: 600,
        limit: 15,
        limits: [5,10,15,20,25],
        cols: [
            [{fixed: "left",
                type: "checkbox",
                width: 50
            },
                {
                    field: 'tableCoding',
                    title: '数据编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'mId',
                    title: '药品编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'mName',
                    title: '药品名称',
                    minWidth: 400,
                    align: "center",
                },
                {
                    field: 'specification',
                    title: '规格',
                    minWidth: 200,
                    align: 'center',
                },
                {
                    field: 'usefulLife',
                    title: '有效期',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'purchasePrice',
                    title: '采购价',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'salePrice',
                    title: '销售价',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'productDate',
                    title: '生产日期',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'profits',
                    title: '利润金额',
                    minWidth: 200,
                    align: 'center',
                    sort: true,
                },
                {
                    field: 'code',
                    title: '自编码',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'goodsType',
                    title: '商品分类',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'mType',
                    title: '药品分类',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'defined',
                    title: '自定义类',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'drugFrom',
                    title: '剂型',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
            ]
        ],
    });


    table.on('toolbar(xTable1)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var tableCoding="";
        var mId="";
        var salePrice="";
        for(i=0;i<data.length;i++){
            tableCoding = data[i].tableCoding;
            mId = data[i].mId;
            salePrice = data[i].salePrice;

        }
        switch(obj.event){
            case 'upPrice':	//修改药价
                if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upPrice(tableCoding,mId,salePrice);
                }
                break;

            case 'backPrice':	//删除药品
                backPrice(tableCoding);
                break;

        };
    });
    function upPrice(tableCoding,mId,salePrice){
        $.ajax({
            url:"/price?action=addPrice",
            data:{
                tableCoding,
                mId,
                salePrice
            },
            type:"POST",
            dataType:"JSON",
            success:function (data) {
                if (data.status == 200){
                    openUpdate(tableCoding);
                }else {
                    layer.msg("添加失败");
                }
            }
        })
    };
    function openUpdate(tableCoding){
        layui.layer.open({
            title : "修改价格",
            type : 2,
            content : "medicine/medicineManage/medPrice/priceInfo.jsp",
            area:['450px','450px'],
        });
    }
    function backPrice(tableCoding){
        layui.layer.open({
            title : "修改价格",
            type : 2,
            content : "medicine/medicineManage/medPrice/backPrice.jsp",
            area:['600px','600px'],
        });
    }

});
