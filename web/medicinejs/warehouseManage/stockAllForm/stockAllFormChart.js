layui.use(['form', 'laydate'], function() {
    var $ = layui.jquery

        $.ajax({
            url: '/StockAllForm?action=getStockAllFormByEcharts', // 确保这是正确的后端 URL
            type: 'GET',
            dataType: 'json',
            success: function(resultData) {
                console.log(resultData)
                if (resultData.status === 200) {
                    // 格式化数据为 ECharts 所需格式
                    var data = resultData.data;
                    var formattedData = data.map(function(item) {
                        return {
                            name: item.department,
                            value: item.number
                        };
                    });
                    console.log('Formatted Data:', formattedData);

                    // 使用获取的数据更新 ECharts 图表
                    var myChart = echarts.init(document.getElementById('main'));
                    var option = {
                        title: {
                            text: '药品库存盘点',
                            subtext: '各部门库存汇总',
                            left: 'center'
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        legend: {
                            bottom: 10,
                            left: 'center',
                        },
                        series: [
                            {
                                name:'库存',
                                type: 'pie',
                                radius: '65%',
                                center: ['50%', '50%'],
                                selectedMode: 'single',
                                data: formattedData,
                                emphasis: {
                                    itemStyle: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                },
                            }
                        ]
                    };
                    myChart.setOption(option);
                } else {
                    console.error("获取数据失败: " + resultData.msg);
                }
            },
        });
});
