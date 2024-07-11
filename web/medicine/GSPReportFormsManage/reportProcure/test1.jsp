<%--
  Created by IntelliJ IDEA.
  User: Jack Zhu
  Date: 2024-07-11
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>我是ddd</div>
<div id="main" style="width: 600px;height:400px;"></div>
<%--<script type="text/javascript" src="../../../iframe/echarts/echarts.js" charset="utf-8"></script>--%>
<script src="../../../iframe/echarts/echarts.js"></script>
<script  type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    // var myChart = echarts.init(document.getElementById('main'));
    // console.log("vv1")
    // console.log(myChart)
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data: ['销量']
        },
        xAxis: {
            data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
        },
        yAxis: {},
        series: [
            {
                name: '销量',
                type: 'bar',
                data: [5, 20, 36, 10, 10, 20]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>
