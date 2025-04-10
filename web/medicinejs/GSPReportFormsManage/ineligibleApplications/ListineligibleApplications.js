layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree','element'],function(){
    var element = layui.element;
    var table = layui.table;
    var $ = layui.jquery;
    // hash 地址定位
    var hashName = 'tabid'; // hash 名称
    var layid = location.hash.replace(new RegExp('^#'+ hashName + '='), ''); // 获取 lay-id 值
    element.tabChange('test-hash', layid);
    element.on('tab(test-hash)', function(obj){
        // location.hash = hashName +'='+ this.getAttribute('lay-id');
        switch (obj.index){
            case 0:
                page();
                break;
            case 1:
                if (document.getElementById('main')){
                    // echartss():
                    pageOne();
                }
                break;
            case 2:
                if (document.getElementById('pie')){
                    pageTwo();
                }
                break;
            case 3:
                console.log("页面4")
                break;
            case 4:
                console.log("页面5")
                break;
        }

    });


    function pageTwo(){
        var datas = [];
        $.ajax({
            url:"/gspReport?action=getAllSup",//根据id查询的方法
            type:"post",
            data:{},
            success:function (data){
                var parse = JSON.parse(data).data;
                for (let i = 0; i < parse.length; i++) {
                    var maps = {}
                    maps.value = parse[i].num;
                    maps.name = parse[i].name;
                    datas[i] = maps;
                }
                pie(datas);
            }
        })
        //
        $(document).ready(function() {
            $("#supply").change(function() {
                var selectedValue = $(this).val();
                console.log(selectedValue)

            })
        })
    }
    function pageOne(){
        var days = 10;
        getAjax(days)
        console.log("看看")
        $(document).ready(function() {
            // $("#buyNum").change(function() {
            //     var selectedValue = $(this).val();
            //     // 根据day执行相应的操作
            //     getAjax(days)
            // });
            //
            $("#nav .layui-nav-item > a").click(function() {
                event.preventDefault(); // 阻止链接默认行为
                var index = $(this).parent().index() + 1;
                switch (index){
                    case 1:
                        //采购记录
                        getAjax(10)
                        break;
                    case 2:
                        //种类
                        getChoise01();
                        break;
                    case 3:
                        //采购商品
                        getChoise02();
                        break;
                    case 4:
                        //库存剩余
                        // getChoise03();
                        break;
                    default:
                        break

                }

            });

            //子菜单
            $('#nav .layui-nav-child a').on('click', function(event) {
                event.preventDefault(); // 阻止链接默认行为
                var jQuery = $(this).text();
                switch (jQuery){
                    case '全部':
                        getAjax(10);
                        break;
                    case '最近三天':
                        getAjax(3);
                        break;
                    case '最近七天':
                        getAjax(7);
                        break;
                    default:
                        break;
                }
            });
        });
    }
    function getChoise03(){
        var xAxis=[];
        var series=[];
        $.ajax({
            url:"/gspReport?action=getChoise03",//根据id查询的方法
            type:"post",
            data:{},
            success:function (data){
                var parse = JSON.parse(data).data;
                for (let i = 0; i < parse.length; i++) {
                    xAxis[i]=parse[i].name;
                    series[i]=parse[i].number;
                }
                category("库存剩余",xAxis,series);
            }
        })
    }
    function getChoise02(){
        var xAxis=[];
        var series=[];
        $.ajax({
            url:"/ineligibleApplications?action=getChoise02",//根据id查询的方法
            type:"post",
            data:{},
            success:function (data){
                var parse = JSON.parse(data).data;
                for (let i = 0; i < parse.length; i++) {
                    xAxis[i]=parse[i].name;
                    series[i]=parse[i].number;
                }
                category("采购商品",xAxis,series);
            }
        })
    }
    function getChoise01(){
        var xAxis=[];
        var series=[];
        $.ajax({
            url:"/ineligibleApplications?action=getChoise01",//根据id查询的方法
            type:"post",
            data:{},
            success:function (data){
                var parse = JSON.parse(data).data;
                for (let i = 0; i < parse.length; i++) {
                    xAxis[i]=parse[i].name;
                    series[i]=parse[i].number;
                }
                category("采购类型",xAxis,series);
            }
        })
    }
    function getAjax(day){
        var xAxis=[];
        var series=[];
        $.ajax({
            url:"/ineligibleApplications?action=getllDay",//根据id查询的方法
            type:"post",
            data:{day},
            success:function (data){
                var parse = JSON.parse(data).data;
                for (let i = 0; i < parse.length; i++) {
                    xAxis[i]=parse[i].times;
                    series[i]=parse[i].number;
                }
                category("采购记录",xAxis,series);
            }
        })
    }
    function category(title,xAxis,series){
        var myChart = echarts.init(document.getElementById('main'));
        option = {
            title: {
                text: title,  // 设置标题文本
                left: 'center',   // 标题居中显示
                top: 'top'        // 标题显示在顶部
            },
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'cross'
                }
            },
            xAxis: {
                type: 'category',
                data: xAxis
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    data: series,
                    type: 'line'
                }
            ]
        };
        myChart.setOption(option);
    }
    // 柱状
    function echartss(){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data: ['销量订单']
            },
            xAxis: {
                data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
            },
            yAxis: {},
            series: [
                {
                    name: '销量订单',
                    type: 'bar',
                    data: [5, 20, 36, 10, 10, 20]
                },
            ]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    }
    function pie(data){
        var myChart = echarts.init(document.getElementById('pie'));
        option = {
            title: {
                text: '供货商'
            },
            tooltip: {
                trigger: 'item'
            },
            legend: {
                top: '5%',
                left: 'center'
            },
            series: [
                {
                    name: 'Access From',
                    type: 'pie',
                    radius: ['40%', '70%'],
                    avoidLabelOverlap: false,
                    itemStyle: {
                        borderRadius: 10,
                        borderColor: '#fff',
                        borderWidth: 2
                    },
                    label: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        label: {
                            show: true,
                            fontSize: 40,
                            fontWeight: 'bold'
                        }
                    },
                    labelLine: {
                        show: false
                    },
                    data: data
                }
            ]
        };

        myChart.setOption(option);
    }

    function page(){
        tableIns;
    }
    var tableIns = table.render({
        elem: '#purchaseList',
        url : '/ineligibleApplications?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#purchaseDemo',
        height : "500px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            // {field: 'applyId', title: '申请编号',  align:'center'},
            // {field: 'mId', title: '字典编号',  align:'center'},
            {field: 'appid', title: '申请编号', minWidth:100, align:"center"},
            {field: 'mid', title: '商品编号', align:'center'},
            {field: 'mname', title: '商品名称', align:'center'},
            {field: 'peoName', title: '申请人', minWidth:100, align:"center"},
            // {field: 'department', title: '部门',  align:'center'},
            // {field: 'number', title: '采购数量',  align:'center'},
            {field: 'applyTime', title: '申请时间',  align:'center'},
            {field: 'cause', title: '原因',  align:'center'},
            {field: 'number', title: '数量',  align:'center'},
            {field: 'specification', title: '规格',  align:'center'},
            {field: 'supplier', title: '供货单位',  align:'center'},
            {field: 'mType', title: '类型',  align:'center'},
            {field: 'unit', title: '类别',  align:'center'},
            {field: 'productDate' ,title:'生产时间', align:'center'},
            {field: 'goodsType' ,title:'分类', align:'center'},
            {field: 'defined' ,title:'处方', align:'center'},
            {field: 'price' ,title:'价格', align:'center'},
        ]],
        done:function (data){
            $('#search').on('click', function() {
                search();
                // 这里可以添加搜索相关的代码
            });
        }
    });
    function search(){
        var inputValue = $('#input').val(); // 获取输入框的值
        tableIns.reload({
            url : '/gspReport?action=search',
            where: {
                inputValue
            },
            type:'static',
            page: false,
        });
    }
})