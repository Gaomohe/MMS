layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'],function() {
    alert("ddddddd")
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    var total = 0;
    var count = 0;
    var chartDom = document.getElementById('main');
    var myChart = echarts.init(chartDom);
    var option;

    // $.ajax({
    //     url: '/StockAllForm?action=getStockAllFormByEcharts',
    //     type: 'GET',
    //     dataType: 'json',
    //     success: function (data) {
    //         console.log(data);
    //         // 处理从服务器获取的数据
    //         var chartData = [];
    //         var chartLabels = [];
    //
    //         data.forEach(function (item) {
    //             chartData.push({value: item.percentage, name: item.mName});
    //             chartLabels.push(item.mName);
    //         });
    //
    //         // 在这里设置option并更新图表
    //         option = {
    //             title: {
    //                 text: '药品库存统计',
    //                 subtext: '库存占比',
    //                 left: 'center'
    //             },
    //             tooltip: {
    //                 trigger: 'item',
    //                 formatter: '{a} <br/>{b} : {c} ({d}%)'
    //             },
    //             legend: {
    //                 bottom: 10,
    //                 left: 'center',
    //                 data: chartLabels
    //             },
    //             series: [
    //                 {
    //                     name: '药品统计',
    //                     type: 'pie',
    //                     radius: '65%',
    //                     center: ['50%', '50%'],
    //                     selectedMode: 'single',
    //                     data: chartData,
    //                     emphasis: {
    //                         itemStyle: {
    //                             shadowBlur: 10,
    //                             shadowOffsetX: 0,
    //                             shadowColor: 'rgba(0, 0, 0, 0.5)'
    //                         }
    //                     }
    //                 }
    //             ]
    //         };
    //         option && myChart.setOption(option);
    //     },
    //     error: function (err) {
    //         console.error('获取数据失败: ', err);
    //     }
    // });
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
                    var myChart = echarts.init(document.getElementById('main'));
                    var option;
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
});