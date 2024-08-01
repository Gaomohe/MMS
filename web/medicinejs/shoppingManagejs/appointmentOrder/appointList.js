layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form', 'layer', 'laydate', 'table', 'laytpl', 'dtree'], function () {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    var counts = 0;
    var total = 0;
    // let idList = new Set();
    var tableMain;
    var supplierName;
    var mTypeName;
    var mNameName;

    $(document).ready(function () {
        supplier();
        mType();
        mName();
        loadTable();
        loadChart();
    });

    function loadTable() {
        tableMain = table.render({
            elem: '#appointList',
            url: '/appoint?action=getAllAppoint',
            toolbar: '#appointDemo',
            page: true,
            height: '600px',
            limit: 10,
            limits: [5, 10, 15, 20, 25],
            cols: [[
                { fixed: "left", type: "checkbox", width: 50 },
                { field: 'applyId', title: '申请编号', align: 'center', width: 200, hide: true, sort: true },
                { field: 'mId', title: '字典编号', align: 'center', width: 200, hide: true, sort: true },
                { field: 'mName', title: '药品名称', minWidth: 100, align: "center", width: 160, sort: true },
                { field: 'pharmacistApprove', title: '药师审批', align: 'center', width: 110, sort: true },
                { field: 'financeApprove', title: '财务审批', align: 'center', width: 110, sort: true },
                { field: 'purchasePrice', title: '采购价/￥', align: 'center', width: 110, sort: true },
                { field: 'applyNumber', title: '采购数量', align: 'center', width: 110, sort: true },
                { field: 'specification', title: '规格', align: 'center', width: 200, sort: true },
                { field: 'manufactor', title: '生产企业', align: 'center', width: 200, sort: true },
                { field: 'unit', title: '单位', minWidth: 100, align: "center", width: 200, sort: true },
                { field: 'department', title: '部门', align: 'center', width: 200, sort: true },
                { field: 'code', title: '批号', align: 'center', width: 200, sort: true },
                { field: 'mType', title: '药品分类', align: 'center', width: 200, sort: true },
                { field: 'supplier', title: '供货单位', align: 'center', width: 200, sort: true },
                { field: 'approvalNumber', title: '准批文号', align: 'center', width: 200, sort: true },
                { field: 'placeOrigin', title: '产地', align: 'center', width: 200, sort: true },
                { field: 'applyUser', title: '申请人', align: 'center', width: 200, sort: true },
                { field: 'applyTime', title: '申请时间', align: 'center', width: 200, sort: true },
                { field: 'pharmacist', title: '药师审批人', align: 'center', width: 200, sort: true },
                { field: 'pharmacistTime', title: '药师审批时间', align: 'center', width: 200, sort: true },
                { field: 'finance', title: '财务审批人', align: 'center', width: 200, sort: true },
                { field: 'financeTime', title: '财务审批时间', align: 'center', width: 200, sort: true },
                { field: 'tableCoding', title: '自编码', align: 'center', width: 200, hide: true, sort: true }
            ]]
        });
    }

    function loadChart() {
        function getLastSevenDays() {
            var dates = [];
            for (var i = 6; i >= 0; i--) {
                var date = new Date();
                date.setDate(date.getDate() - i);
                dates.push(date.toISOString().split('T')[0]);
            }
            return dates;
        }

        var lastSevenDays = getLastSevenDays();

        var chartDom = document.getElementById('main');
        if (chartDom) {
            var myChart = echarts.init(chartDom);

            $.ajax({
                url: '/appoint?action=getStatistics',
                method: 'GET',
                success: function(data) {
                    console.log("+++++++++++++++++++++++++++++++++++");
                    console.log(data);
                    console.log("+++++++++++++++++++++++++++++++++++");

                    // 解析 JSON 数据
                    data = JSON.parse(data);

                    // 确保 data 是一个数组
                    if (!Array.isArray(data)) {
                        console.error("数据格式错误，期望一个数组。", data);
                        return;
                    }

                    // 获取最近7天的日期
                    var datasetSource = [['近七天时间'].concat(lastSevenDays)];
                    var series = [];
                    var supplierData = {};

                    // 处理数据
                    data.forEach(function(res) {
                        var dateIndex = lastSevenDays.indexOf(res.applyTime);
                        if (dateIndex !== -1) {
                            if (!supplierData[res.manufactor]) {
                                supplierData[res.manufactor] = new Array(7).fill(0);
                            }
                            supplierData[res.manufactor][dateIndex] += res.applyNumber;
                        }
                    });

                    // 生成数据源
                    var pieData = []; // 保存饼状图数据
                    for (var supplier in supplierData) {
                        datasetSource.push([supplier].concat(supplierData[supplier]));
                        series.push({
                            type: 'line',
                            smooth: true,
                            seriesLayoutBy: 'row',
                            emphasis: { focus: 'series' },
                            name: supplier
                        });

                        // 计算饼状图数据
                        var total = supplierData[supplier].reduce((a, b) => a + b, 0);
                        pieData.push({
                            name: supplier,
                            value: total
                        });
                    }

                    // 添加饼状图系列
                    series.push({
                        type: 'pie',
                        id: 'pie',
                        radius: '30%',
                        center: ['50%', '25%'],
                        emphasis: {
                            focus: 'self'
                        },
                        label: {
                            formatter: '{b}: {c} ({d}%)'
                        },
                        data: pieData
                    });

                    // 配置 ECharts 选项
                    var option = {
                        legend: {
                            data: Object.keys(supplierData)
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        dataset: {
                            source: datasetSource
                        },
                        xAxis: { type: 'category' },
                        yAxis: { gridIndex: 0 },
                        grid: { top: '55%' },
                        series: series
                    };

                    myChart.setOption(option);

                    // 监听折线图的鼠标悬停事件，动态更新饼状图
                    myChart.on('updateAxisPointer', function (event) {
                        const xAxisInfo = event.axesInfo[0];
                        if (xAxisInfo) {
                            const dimension = xAxisInfo.value + 1;
                            var selectedDate = lastSevenDays[dimension - 1];

                            // 更新饼状图数据
                            var updatedPieData = pieData.map(function (item) {
                                var value = supplierData[item.name][dimension - 1];
                                return {
                                    name: item.name,
                                    value: value
                                };
                            });

                            myChart.setOption({
                                series: [{
                                    id: 'pie',
                                    data: updatedPieData
                                }]
                            });
                        }
                    });
                },
                error: function(err) {
                    console.error("Chart data load error:", err);
                }
            });
        }
    }

    function loadChart() {
        function getLastSevenDays() {
            var dates = [];
            for (var i = 6; i >= 0; i--) {
                var date = new Date();
                date.setDate(date.getDate() - i);
                dates.push(date.toISOString().split('T')[0]);
            }
            return dates;
        }

        var lastSevenDays = getLastSevenDays();

        var chartDom = document.getElementById('main');
        if (chartDom) {
            var myChart = echarts.init(chartDom);

            $.ajax({
                url: '/appoint?action=getStatistics',
                method: 'GET',
                success: function(data) {
                    console.log("+++++++++++++++++++++++++++++++++++");
                    console.log(data);
                    console.log("+++++++++++++++++++++++++++++++++++");

                    // 解析 JSON 数据
                    data = JSON.parse(data);

                    // 获取最近7天的日期
                    var datasetSource = [['近七天时间'].concat(lastSevenDays)];
                    var series = [];
                    var supplierData = {};
                    var colorMapping = {}; // 颜色映射

                    // 处理数据
                    data.forEach(function(res) {
                        var dateIndex = lastSevenDays.indexOf(res.applyTime);
                        if (dateIndex !== -1) {
                            if (!supplierData[res.manufactor]) {
                                supplierData[res.manufactor] = new Array(7).fill(0);
                            }
                            supplierData[res.manufactor][dateIndex] += res.applyNumber;
                        }
                    });

                    // 生成数据源和颜色映射
                    var pieData = []; // 保存饼状图数据
                    var colorList = ['#5470C6', '#91CC75', '#FAC858', '#EE6666', '#73C0DE', '#3BA272', '#FC8452', '#9A60B4', '#EA7CCC'];
                    var colorIndex = 0;

                    for (var supplier in supplierData) {
                        datasetSource.push([supplier].concat(supplierData[supplier]));
                        colorMapping[supplier] = colorList[colorIndex++ % colorList.length]; // 颜色映射

                        series.push({
                            type: 'line',
                            smooth: true,
                            seriesLayoutBy: 'row',
                            emphasis: { focus: 'series' },
                            name: supplier,
                            lineStyle: {
                                color: colorMapping[supplier]
                            },
                            itemStyle: {
                                color: colorMapping[supplier]
                            },
                            show:false
                        });

                        // 计算饼状图数据
                        var total = supplierData[supplier].reduce((a, b) => a + b, 0);
                        pieData.push({
                            name: supplier,
                            value: total,
                            itemStyle: {
                                color: colorMapping[supplier]
                            }
                        });
                    }

                    // 添加饼状图系列
                    series.push({
                        type: 'pie',
                        id: 'pie',
                        radius: '30%',
                        center: ['50%', '25%'],
                        emphasis: {
                            focus: 'self'
                        },
                        label: {
                            formatter: '{b}: {c} ({d}%)'
                        },
                        data: pieData
                    });

                    // 配置 ECharts 选项
                    var option = {
                        color: colorList, // 全局颜色设置
                        legend: {
                            data: Object.keys(supplierData),
                            show:false
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        dataset: {
                            source: datasetSource
                        },
                        xAxis: { type: 'category' },
                        yAxis: { gridIndex: 0 },
                        grid: { top: '55%' },
                        series: series
                    };

                    myChart.setOption(option);

                    // 监听折线图的鼠标悬停事件，动态更新饼状图
                    myChart.on('updateAxisPointer', function(event) {
                        const xAxisInfo = event.axesInfo[0];
                        if (xAxisInfo) {
                            const dimension = xAxisInfo.value + 1;
                            var selectedDate = lastSevenDays[dimension - 1];

                            // 更新饼状图数据
                            var updatedPieData = pieData.map(function(item) {
                                var value = supplierData[item.name][dimension - 1];
                                return value > 0 ? {
                                    name: item.name,
                                    value: value,
                                    itemStyle: {
                                        color: colorMapping[item.name]
                                    }
                                } : null;
                            }).filter(item => item !== null);

                            myChart.setOption({
                                series: [{
                                    id: 'pie',
                                    data: updatedPieData
                                }]
                            });
                        }
                    });
                },
                error: function(err) {
                    console.error("Chart data load error:", err);
                }
            });
        }
    }


    // 操作选择
    table.on('toolbar(appointList)', function (obj) {
        var checkdata = table.checkStatus(obj.config.id);
        var files = checkdata.data;
        console.log(obj);
        switch (obj.event) {
            case 'delAppoint':
                if (files.length > 0) {
                    files.forEach(function (file) {
                        total++;
                        del(file.mId);
                    });
                } else {
                    layer.msg("请选中要删除的数据", { icon: 2 });
                }
                break;
            case 'addAppoint':
                var firstManufacturer = "";
                var idList = new Set(); // 确保 idList 是一个 Set
                if (files.length > 0) {
                    firstManufacturer = files[0].manufactor;
                    var allSameManufacturer = true; // 标志变量
                    for (let i = 0; i < files.length; i++) {
                        const file = files[i];
                        total++;
                        if (file.financeApprove == '已审阅通过') {
                            layer.msg("已审核...请选择未审核申请药品");
                            break; // 这里会真正停止循环
                        }
                        idList.add(file.applyId);
                    }
                    if (allSameManufacturer) {
                        // 执行一些操作，比如提交选择的数据
                        console.log("要处理的数据:", Array.from(idList));
                        // 这里可以调用你的后台接口来处理这些数据
                    }
                    addAppoint(idList)
                } else {
                    layer.msg("请选中要操作的数据", { icon: 2 });
                }
                break;
            case 'search':
                search();
                break;
            case 'reload':
                winReload();
                break;
            case 'download':
                downloads();
                break;
            case 'msg':
                //右侧消息
                msg();
                break;
        }
    });

    /*-------- 搜索用户 ----------------------------*/
    $("#doSubmit").click(function(){
        var like = $("#likename").val()
        tableIns.reload({
            url:"http://localhost:8723/EEDemo/Interfaces?action=allUser&uname="+like,
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    })

    function msg(){
        layer.open({
            type: 2,
            offset: 'r',
            anim: 'slideLeft', // 从右往左
            area: ['320px', '100%'],
            shade: 0.1,

            shadeClose: true,
            id: 'ID-demo-layer-direction-r',
            content : "http://localhost:8080/medicine/shoppingManage/requestApply/msgList.jsp"
        });
    }



    //删除
    function del(ids) {
        $.ajax({
            url: "/appoint?action=delAppoint",
            data: { "ids": ids },
            type: "post",
            dataType: "json",
            traditional: true,
            success: function(res) {
                console.log("res");
                console.log(res);
                console.log(res.status);
                counts++;
                console.log(counts);
                console.log(total);
                if (counts == total) {
                    if (res.status) {
                        layer.msg("删除成功", { icon: 1 });
                        tableIns.reload();
                    } else {
                        layer.msg("删除失败", { icon: 2 });
                    }
                }
            }
        });
    }

    function upLoad(){
        layer.open({
            type: 2, // page 层类型
            area: ['600px', '450px'],
            title: '图片上传',
            shade: 0.6, // 遮罩透明度
            shadeClose: true, // 点击遮罩区域，关闭弹层
            maxmin: true, // 允许全屏最小化
            anim: 0, // 0-6 的动画形式，-1 不开启
            content: "admin/page/system/user/fileUpload.jsp"
        })
    }

    //新增订单
    /*function addAppoint(idsList){
        const serializedIds = encodeURIComponent(JSON.stringify(idsList));
        console.log("ssssssssssssssss");
        console.log(idsList);
        console.log("ssssssssssssssss");
        layer.open({
            type: 2, // page 层类型
            area: ['900px', '600px'],
            title: '预购订单信息',
            shade: 0.6, // 遮罩透明度
            shadeClose: true, // 点击遮罩区域，关闭弹层
            maxmin: true, // 允许全屏最小化
            anim: 0, // 0-6 的动画形式，-1 不开启
            content: "medicine/shoppingManage/appointmentOrder/appointAdd.jsp?idsList=" + serializedIds,
        });
    }*/
    function addAppoint(idsList) {
        // 如果 idsList 是 Set，转换为数组
        const idsArray = Array.from(idsList);

        console.log("idsList before encoding:", idsArray);
        const serializedIds = encodeURIComponent(JSON.stringify(idsArray));
        console.log("Serialized idsList:", serializedIds);

        layer.open({
            type: 2, // page 层类型
            area: ['900px', '600px'],
            title: '预购订单信息',
            shade: 0.6, // 遮罩透明度
            shadeClose: true, // 点击遮罩区域，关闭弹层
            maxmin: true, // 允许全屏最小化
            anim: 0, // 0-6 的动画形式，-1 不开启
            content: "medicine/shoppingManage/appointmentOrder/appointAdd.jsp?idsList=" + serializedIds,
        });
    }



    //修改回显
    function  selectByIdUser(id,uname) {
        layer.open({
            type: 2, // page 层类型
            area: ['600px', '450px'],
            title: '修['+uname+']改',
            shade: 0.6, // 遮罩透明度
            shadeClose: true, // 点击遮罩区域，关闭弹层
            maxmin: true, // 允许全屏最小化
            anim: 0, // 0-6 的动画形式，-1 不开启
            content: '/user?action=selectOneUser&&id='+id,
        })
    }

    //修改用户
    function upAppoint(userid){
        layui.layer.open({
            title : "修改用户信息",
            type : 2,
            content : "medicine/infoManage/userManage/userInfo.jsp",
            area:['500px','540px'],
            success:function(layero, index){
                $.ajax({
                    url:"/user?action=allUserByUserid",
                    type:"post",
                    data:{"userid":userid},
                    success:function(data){
                        var info = JSON.parse(data);
                        var body = layui.layer.getChildFrame('body', index);
                        body.find("#id").val(info.data.id);
                        body.find("#userName2").val(info.data.name);
                        body.find("#sex").val(info.data.sex);
                        body.find("#age").val(info.data.age);
                        body.find("#pass").val(info.data.password);
                        body.find("#telNumber").val(info.data.telNumber);
                        body.find("#address").val(info.data.address);
                        body.find("#birthday").val(info.data.birthday);
                        body.find("#createDate").val(info.data.createDate);
                        body.find("#wechat").val(info.data.wechat);

                        //性别(单选)
                        var sex2 = info.data.sex;
                        if(sex2 == "男"){
                            body.find("#sex1").prop("checked",true);
                        }else{
                            body.find("#sex2").prop("checked",true);
                        }
                        //状态(单选)
                        var isStatus = info.data.status;
                        if(isStatus == 200){
                            body.find("#isStatus0").prop("checked",true);
                        }else{
                            body.find("#isStatus1").prop("checked",true);
                        }
                        /*------下拉框赋值--------*/
                        $.ajax({
                            url:"/user?action=allRole",
                            type:"post",
                            success:function(data){
                                var info = JSON.parse(data);
                                // var row = info.data;
                                var row = info;
                                console.log(row);
                                var role = body.find("#role1");
                                $.ajax({
                                    url:"/user?action=queryUserIsRole",	//查询用户是否有角色有返回1,没有返回0
                                    data:{"userid":userid},
                                    type:"post",
                                    success:function(data){
                                        // console.log(data)
                                        var info1 = JSON.parse(data);
                                        console.log(info1.status);
                                        if(info1.status == 200){
                                            var html = '<option value="0">无角色</option>';
                                        }else{
                                            var html = '';
                                        }
                                        $.each(row,function(index,item){
                                            html += '<option value="'+item.id+'">'+item.name+'</option>';
                                        })
                                        role.html(html);
                                        //获取新窗口对象
                                        var iframeWindow = layero.find('iframe')[0].contentWindow;
                                        //重新渲染
                                        iframeWindow.layui.form.render();
                                    }
                                })

                            }
                        })
                        /*------下拉框赋值--------*/
                        //赋值后选中
                        $.ajax({
                            url:"/user?action=allRoleUserid",
                            type:"post",
                            data:{"userid":userid},
                            success:function(data){
                                var info2 = JSON.parse(data);
                                if(info2.status == 200){
                                    var select = 'dd[lay-value="0"]';
                                    body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
                                }else{
                                    var select = 'dd[lay-value='+info2.data.roleid+']';
                                    body.find("#role1").siblings("div.layui-form-select").find('dl').find(select).click();	//菜单样式
                                }
                            }
                        })
                        //获取新窗口对象
                        var iframeWindow = layero.find('iframe')[0].contentWindow;
                        //重新渲染
                        iframeWindow.layui.form.render();
                    }
                })
            }
        })
    }

    //删除用户
    function delUser(userid){
        $.ajax({
            url:"/user?action=delUser",
            data:{"userid":userid},
            type:"post",
            success:function(data){
                if(data == 1){
                    layer.msg("删除成功")
                    tableIns.reload("#newsList");
                }
            }
        })
    }

    //分配生产企业
    function supplier() {
        $.post("/appoint?action=getSupplier", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#supplier").empty().html('<option value="0">供货商</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.applyId + '">' + item.supplier + '</option>');
                });
                form.render("select");

                form.on('select(supplier)', function(data) {
                    supplierName = cs.find(item => item.applyId == data.value)?.supplier || '';
                    console.log("被选中的供货商是：" + supplierName);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    //药品类型
    function mType() {
        $.post("/appoint?action=getmType", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#mType").empty().html('<option value="0">药品类型</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.applyId + '">' + item.mType + '</option>');
                });
                form.render("select");

                form.on('select(mType)', function(data) {
                    mTypeName = cs.find(item => item.applyId == data.value)?.mType || '';
                    console.log("被选中的药品类型是：" + mTypeName);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    //药品名称
    //分配生产企业
    function mName() {
        $.post("/appoint?action=getmName", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#mName").empty().html('<option value="0">药品名称</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.applyId + '">' + item.mName + '</option>');
                });
                form.render("select");

                form.on('select(mName)', function(data) {
                    mNameName = cs.find(item => item.applyId == data.value)?.mName || '';
                    console.log("被选中的药品类型是：" + mNameName);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }


    // 导出excel
    function downloads() {
        var checkRows = table.checkStatus('financialList');
        console.log(checkRows);
        if (checkRows.data.length === 0) {
            layer.msg('请选择要导出的数据', {icon: 2});
        } else {
            table.exportFile(tableMain.config.id,checkRows.data, 'selected_data.xls');
        }
    }

    function winReload(){
        location.reload();
    }


    function search() {
        tableMain.reload({
            url: "/appoint?action=Search",
            where: {
                "supplierName": supplierName,
                "mTypeName": mTypeName,
                "mNameName": mNameName
            },
            page: { curr: 1 }
        });
        supplier();
        mType();
        mName();
    }
});

