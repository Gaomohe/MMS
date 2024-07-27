layui.use(['laydate', 'form', 'jquery','table'], function() {
    var laydate = layui.laydate;
    var form = layui.form;
    var $ = layui.jquery;
    var table  = layui.table;

    // 表格渲染
    // var tableIns = table.render({
    //     elem: '#qualityFailedList',
    //     url : '/StockOutForm?action=getApplyFailedStockOut',
    //     type: "post",
    //     page : true,
    //     limit : 6,
    //     limits : [6],
    //     cols : [[
    //         {field: 'applyId', title: '申请编号',hide:true, align:'center',width:200},
    //         {field: 'mId', title: '字典编号', hide:true,  align:'center',width:200},
    //         {field: 'mName', title: '药品名称', minWidth:100, align:"center",width:200},
    //         {field: 'specification', title: '规格', align:'center',width:150},
    //         {field: 'manufactor', title: '生产企业',hide:true, align:'center',width:200},
    //         {field: 'number', title: '出库数量', align:'center',width:150},
    //         {field: 'applyNumber', title: '采购数量',hide:true,   align:'center',width:100},
    //         {field: 'purchasePrice', title: '采购价', hide:true,  align:'center',width:200},
    //         {field: 'code', title: '批号', hide:true,  align:'center',width:200},
    //         {field: 'mType', title: '药品分类',  align:'center',width:200},
    //         {field: 'supplier', title: '供货单位',  align:'center',width:200},
    //         {field: 'approvalNumber', title: '准批文号', hide:true,  align:'center',width:200},
    //         {field: 'placeOrigin', title: '产地', hide:true,  align:'center',width:200},
    //         {field: 'applyUser' ,title:'申请人', align:'center',hide:true, width:200},
    //         {field: 'applyTime' ,title:'出库时间', align:'center',width:200},
    //         {field: 'pharmacist' ,title:'药师', hide:true, align:'center',width:200},
    //         {field: 'pharmacistApprove' ,title:'药师审批', hide:true, align:'center',width:200},
    //         {field: 'pharmacistTime' ,title:'药师审批时间',hide:true,  align:'center',width:200},
    //         {field: 'tableCoding' ,title:'药品编号',hide:true,  align:'center',width:200},
    //         {field: 'cause' ,title:'处理记录', align:'center',width:150},
    //     ]],
    //     done:function (data){
    //         console.log(data)
    //     }
    // });

    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option;
    $(document).ready(function() {
        $.ajax({
            url: '/StockAllForm?action=getStockAllFormByEcharts', // 确保这是正确的后端 URL
            type: 'GET',
            dataType: 'json',
            success: function (resultData) {
                var salesData = resultData.data;
                var mName = salesData.map(function (item) {
                    return item.mName;
                });
                alert(mName)
                var number = salesData.map(function (item) {
                    return item.number;
                });

                // 使用获取的数据更新 ECharts 图表
               myChart = echarts.init(document.getElementById('main'));
                option = {
                    title: {
                        text: '药品库存统计',
                        subtext: '库存占比',
                        left: 'center'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },
                    legend: {
                        bottom: 10,
                        left: 'center',
                        data: mName
                    },
                    series: [
                        {
                            name: '药品统计',
                            type: 'pie',
                            radius: '65%',
                            center: ['50%', '50%'],
                            selectedMode: 'single',
                            data: number,
                            emphasis: {
                                itemStyle: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };
                option && myChart.setOption(option);
            },
            error: function (xhr, status, error) {
                console.error("Error: " + status + " " + error);
            }
        });
    });

    // $('#confirm').click(function() {
    //     var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
    //     parent.layer.close(index); // 关闭模态框
    // });
});