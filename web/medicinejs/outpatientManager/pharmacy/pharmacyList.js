layui.extend({
    dtree: '/admin/js/lay-module/layui_ext/dtree/dtree'
}).use(['form', 'layer', 'laydate', 'table', 'upload', 'dtree'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table,
        dtree = layui.dtree;
    var pName, pSex, pAge, pId, pWeight, pAddress, pPhone, pAllergy,doctorAdvice,lastTime,disease,tableMain;

    $(document).ready(function() {
        laydate.render({
            elem: '#time'
        });

        var tableIns = table.render({
            elem: '#pharmacyList',
            cellMinWidth: 95,
            page: true,
            url: '/pharmacy?action=getPharmacyList',
            toolbar: '#pharmacyDemo',
            height: "800px",
            limit: 20,
            limits: [10, 15, 20, 25],
            cols: [[
                {fixed:"left",type: "checkbox", width:50, sort: true},
                {field: 'phId', title: '处方编号',  align:'center', width:200, sort: true,hide:true},
                {field: 'pId', title: '患者编号', minWidth:100, align:"center", sort: true},
                {field: 'pName', title: '患者姓名', align:'center', width:200, sort: true},
                {field: 'doctor', title: '开方医生', align:'center', width:200, sort: true},
                {field: 'isPharmacy', title: '是否含有处方药', minWidth:100, align:"center", sort: true},
                {field: 'time', title: '开方时间',  align:'center', width:200, sort: true},
                {field: 'pharmacist', title: '药师',  align:'center', width:200, sort: true},
                {field: 'pharmacistApprove', title: '药师审核',  align:'center', width:200, sort: true},
                {field: 'pharmacistTime', title: '药师审核时间',  align:'center', width:200, sort: true},
            ]],
        });
        tableMain = tableIns;
        // 初始化下拉框


        table.on('row(pharmacyList)', function (obj) {
            var data = obj.data;
            var tr = obj.tr;
            var checkbox = tr.find('input[type="checkbox"]');
            var event = window.event || arguments.callee.caller.arguments[0];
            var target = event.target || event.srcElement;

            if (target === checkbox[0] || $(target).closest('td').find('input[type="checkbox"]').length > 0) {
                return;
            }

            console.log("点击了表格行");
            console.log(data.pId);
            medicineDetails(data.pId);
            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });

        table.on('toolbar(pharmacyList)', function(obj) {
            var checkdata = table.checkStatus(obj.config.id)
            var files = checkdata.data;
            var array = [];
            var state = [];
            for (let i = 0; i < files.length; i++) {
                array[i] = files[i].applyId;
                state[i] = files[i].financeApprove;
            }

            switch (obj.event) {
                case 'search':
                    Search();
                    break;
                case 'reload':

                    break;
                case 'del':
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            total++;
                            delApply(file.applyId);
                        });
                    } else {
                        layer.msg("you are not select", {icon: 2});
                    }
                    break;
                case 'addPatient':
                    addPatient();
                    break;
                case 'addMedicine':
                    if (files.length > 0) {
                        console.log(files[0].pId);
                        addMedicine(files[0].pId);
                    } else {
                        layer.msg("未选择", {icon: 2});
                    }
                    break;
                case 'check':
                    console.log("0000000000000000000000");
                    console.log(files[0].pId);
                    if (files.length > 0) {
                        console.log(files[0].pId);
                        Check(files[0].pId);
                    } else {
                        layer.msg("未选择", {icon: 2});
                    }
                    break;
            }
        });
    });


    /*function Check(phId){
        layui.layer.open({
            title : "审核处方",
            type : 2,
            content : "/pharmacy?action=getMenuBtn1&phId=" + phId,
            area:['1200px','675px']
        });

    }*/

    /*//打开开处方的界面
    function addMedicine(id){
        layui.layer.open({
            title : "开设处方",
            type : 2,
            content : "/patient?action=getAddMenuBtn&pId=" + id,
            area:['1200px','675px']
        });
    }*/




    function addPatient(){
        $.ajax({
            url: "/patient?action=addPatient",
            data: {
                "pName": pName,
                "pSex": pSex,
                "pAge": pAge,
                "pId": pId,
                "pWeight": pWeight,
                "pAddress": pAddress,
                "pPhone": pPhone,
                "pAllergy": pAllergy,
                "doctorAdvice": doctorAdvice,
                "lastTime": lastTime
            },
            type: "post",
            dataType: "json",
            traditional: true,
            success: function(res) {
                console.log("--------------------");
                console.log(res);
                console.log("********************");
                console.log(res.status);
                console.log("++++++++++++++++++++");
                if (res.status==200){
                    layer.msg("添加成功", { icon: 1 });
                    tableMain.reload();
                }else {
                    layer.msg("删除失败", { icon: 2 });
                }
            }
        });
    }

    function medicineDetails(pId){
        layui.layer.open({
            title : "详情",
            type : 2,
            content : "medicine/outpatientManager/pharmacy/checkPharmacy.jsp?pId=" + pId,
            area:['900px','550px'],
        })
    }

    function Search(){
        // 确保事件处理程序只绑定一次
        $("#submit").on("click", function (e) {
            e.preventDefault(); // 阻止表单的默认提交行为

            var formData = $("#searchForm").serializeArray();
            searchData = {}; // Reset searchData
            $.each(formData, function (i, field) {
                searchData[field.name] = field.value;
            });

            table.reload('pharmacyList', {
                url: '/pharmacy?action=Search',
                where: searchData,
                page: { curr: 1 },
                cache: false,
                response: {
                    statusCode: 200,
                    countName: 'count',
                    dataName: 'data',
                    msgName: 'msg'
                },
                done: function(res, curr, count) {
                    console.log("数据加载完成:", res);
                    if (res.code !== 200) {
                        layer.msg(res.msg || '加载失败');
                    }
                }
            });
        });
    }
});