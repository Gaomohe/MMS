layui.use(['layer', 'element', 'util', 'table', 'tableX','mousewheel','form'], function() {
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var util = layui.util;
    var table = layui.table;
    var tableX = layui.tableX;
    var layer = layui.layer;
    var form = layui.from;

    var tableCoding =$('#tab1').val();
    var mId =$('#tab2').val();
    var salePrice =$('#tab3').val();
    tableX.render({
        elem: '#xTable3',
        url: '/price?action=getPriceByTabCod',
        where:{
            tableCoding: tableCoding,
        },
        page: true,
        height: 400,
        limit: 15,
        limits: [5,10,15,20,25],
        cols: [
            [
                {
                    field: 'tableCoding',
                    title: '药品数据编号',
                    minWidth: 200,
                    align: 'center',
                    sort: true
                },
                {
                    field: 'historyPrice',
                    title: '历史价格',
                    minWidth: 400,
                    align: "center",
                },
                {
                    field: 'time',
                    title: '调价时间',
                    minWidth: 200,
                    align: 'center',
                },
                {
                    title:'操作',
                    width:150,
                    templet: '#barDemo'
                }
            ]
        ],
    });

    function upPrice(tableCoding,mId,salePrice,historyPrice){
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
                    update(tableCoding,historyPrice);
                }else {
                    layer.msg("添加失败");
                }
            }
        })
    };

    table.on('tool(xTable3)', function(obj){
        var data = obj.data;
        switch(obj.event){
            case 'back':
                var historyPrice = data.historyPrice; // 获取历史价格值
                layer.confirm('是否回溯为'+historyPrice+'元？', {icon: 3}, function(){
                    upPrice(tableCoding,mId,salePrice,historyPrice)
                }, function(){
                });
                break;
        }
    });

    function update(tableCoding,historyPrice){
        $.ajax({
            url:"/medicine?action=updateMedicinePrice",
            data:{
                price:historyPrice,
                tableCoding
            },
            tyep:"post",
            success:function(data){
                var info = JSON.parse(data);
                console.log(info);
                if(info.status == 200){
                    layer.msg("回溯成功")
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
    /*table.on('tool(xTable3)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        switch(obj.event){
            case 'back':
                alert("回溯");
                //修改药价
                /!*if(data.length != 1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }else{
                    upPrice(tableCoding,mId,salePrice);
                }*!/
                break;

            case 'backPrice':	//删除药品
                /!*backPrice(tableCoding);*!/
                break;

        };
    });*/
});
