layui.extend({
    dtree: '/admin/js/lay-module/layui_ext/dtree/dtree'  // 使用正确的相对路径或绝对路径
}).use(['form', 'layer', 'laydate', 'table', 'upload', 'dtree'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table,
        dtree = layui.dtree;  // 只在这里加载 dtree
    var applyCode;//申请编号
    var mName;//药品名称
    var applyTime;//申请时间
    var status;//状态
    var applyName;//申请人
    var phaName;//药师
    var finName;//财务
    var tableMain;
    var counts = 0;
    var total = 0;

    $(document).ready(function(){
        laydate.render({
            elem: '#time'
        });

        var tableIns = table.render({
            elem: '#outpatientList',
            cellMinWidth: 95,
            page: true,
            url : '/medicine?action=getAllMedicine',
            toolbar: '#outpatientDemo',
            height: "600px",
            limit: 20,
            limits: [10, 15, 20, 25],
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
                        field: 'manufactor',
                        title: '生产企业',
                        minWidth: 400,
                        align: 'center',
                    },
                    {
                        field: 'unit',
                        title: '单位',
                        minWidth: 100,
                        align: "center",
                    },
                    {
                        field: 'department',
                        title: '部门',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        field: 'position',
                        title: '货位',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'number',
                        title: '数量',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'batchNumber',
                        title: '批号',
                        minWidth: 200,
                        align: 'center',
                        sort: true
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
                        sort: true
                    },
                    {
                        field: 'salePrice',
                        title: '销售价',
                        minWidth: 200,
                        align: 'center',
                        sort: true
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
                        sort: true
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
                        field: 'supplier',
                        title: '供货单位',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        field: 'warehousingDate',
                        title: '入库日期',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'locationDescription',
                        title: '货位说明',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'sign',
                        title: '标志',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        field: 'warehousingRemarks',
                        title: '入库备注',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        field: 'drugFrom',
                        title: '剂型',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'handlingInformation',
                        title: '处理情况',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        field: 'approvalNumber',
                        title: '批准文号',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'LastCuringDate',
                        title: '上次养护日期',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'timesStorage',
                        title: '入库次数',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'documentNumber',
                        title: '单据号码',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'placeOrigin',
                        title: '产地',
                        minWidth: 200,
                        align: 'center',
                    },
                    {
                        field: 'batchsNumber',
                        title: '批次号',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'recordNumber',
                        title: '记录号',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        title: '操作',
                        width: 200,
                        templet: '#barDemo',
                    }
                ]
            ],
            /*cols: [[
                {fixed:"left",type: "checkbox", width:50},
                {field: 'pId', title: '患者卡号',  align:'center'},
                {field: 'dId', title: '医生编号',  align:'center'},
                {field: 'mId', title: '处方编号', minWidth:100, align:"center"},
                {field: 'name', title: '患者姓名', align:'center'},
                {field: 'sex', title: '性别', align:'center'},
                {field: 'age', title: '年龄', minWidth:100, align:"center"},
                {field: 'weight', title: '体重',  align:'center'},
                {field: 'address', title: '住址',  align:'center'},
                {field: 'phone', title: '联系方式',  align:'center'},
                {field: 'diagnosticTime', title: '就诊时间',  align:'center'},
                {field: 'allergy', title: '过敏史',  align:'center'},
                {field: 'doctorAdvice', title: '医嘱',  align:'center'},
                {field: 'dName', title: '医生姓名',  align:'center'},
            ]],*/
        });
        tableMain = tableIns;
        // 初始化下拉框
        renderApplyUser();
        renderPharmacist();
        renderFinancial();
        getCode();
        getmName();
        getTime();
        getStatus();

        table.on('toolbar(outpatientList)', function(obj) {
            /*var checkStatus = table.checkStatus(obj.config.id);
            var data = checkStatus.data;
            var applyIds = []; // 用来存储所有选中行的 applyId
            for (let i = 0; i < data.length; i++) {
                applyIds.push(data[i].applyId); // 将每个选中行的 applyId 添加到数组中
            }*/
            var checkdata= table.checkStatus(obj.config.id)
            var files= checkdata.data;
            console.log(files);
            var array = [];
            var state = [];
            for (let i = 0; i < files.length;i++){
                array[i]=files[i].applyId;
                state[i]=files[i].financeApprove;
            }
            // 根据点击的按钮事件执行相应的操作
            switch (obj.event) {
                case 'search':
                    search(applyCode,mName,applyTime,status,applyName,phaName,finName); // 将 applyIds 数组作为参数传递给 search 函数
                    break;
                // 可以添加更多 case 来处理其他按钮点击事件
                case 'reload':
                    winReload();
                    break;
                case 'del':
                    console.log("aaa");
                    console.log(files);
                    console.log(files.length);
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            // 假设每个file对象都有一个id属性，用于标识用户
                            total++;
                            delApply(file.applyId);
                        });
                    } else {
                        layer.msg("you are not select", {icon: 2});
                    }
                    break;
                case 'approve':
                    /*console.log("aaaaaa");
                    console.log(array);
                    console.log(state);
                    approve(array,state);*/

                    console.log("aaa");
                    console.log(files);
                    console.log(files.length);
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            // 假设每个file对象都有一个id属性，用于标识用户
                            console.log(file.applyId);
                            total++;
                            setApprove(file.applyId);
                        });
                    } else {
                        layer.msg("未选择", {icon: 2});
                    }
                    break;
                case 'unapprove':
                    console.log("aaa");
                    console.log(files);
                    console.log(files.length);
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            // 假设每个file对象都有一个id属性，用于标识用户
                            console.log(file.applyId);
                            total++;
                            setUnApprove(file.applyId);
                        });
                    } else {
                        layer.msg("未选择", {icon: 2});
                    }
                    break;
            }
        });
    });

    function getCode(){
        // 申请编号
        $('input[name="code"]').on('input', function(e) {
            applyCode = e.target.value;
            console.log("实时输入申请编号：" + applyCode);
        });
    }

    function getmName(){
        // 药品名称
        $('input[name="mName"]').on('input', function(e) {
            mName = e.target.value;
            console.log("药品名称：" + mName);
        });
    }

    function getTime(){
        // 申请时间
        laydate.render({
            elem: '#time',
            type: 'date',
            done: function(value) {
                applyTime = value;
                console.log('用户选择的时间：', value);
            }
        });
    }

    function getStatus(){
        // 状态选择下拉框
        form.on('select(status)', function(data) {
            status = data.value == 0 ? '' : data.elem.options[data.elem.selectedIndex].text;
            console.log("被选中的状态是：" + status);
        });
    }

    function renderApplyUser() {
        $.post("/user?action=getAppUser", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#applyUser").empty().html('<option value="0">申请人</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.id + '">' + item.userName + '</option>');
                });
                form.render("select");

                form.on('select(applyUser)', function(data) {
                    applyName = cs.find(item => item.id == data.value)?.userName || '';
                    console.log("申请人：" + applyName);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function renderPharmacist() {
        $.post("/user?action=getPhaName", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#pharmacist").empty().html('<option value="0">药师</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.id + '">' + item.userName + '</option>');
                });
                form.render("select");

                form.on('select(pharmacist)', function(data) {
                    phaName = cs.find(item => item.id == data.value)?.userName || '';
                    console.log("被选中的药师名字是：" + phaName);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function renderFinancial() {
        $.post("/user?action=getFinName", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#financial").empty().html('<option value="0">财务</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.id + '">' + item.userName + '</option>');
                });
                form.render("select");

                form.on('select(financial)', function(data) {
                    finName = cs.find(item => item.id == data.value)?.userName || '';
                    console.log("被选中的财务名字是：" + finName);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function search(applyCode, mName, applyTime, status, applyName, phaName, finName) {
        tableMain.reload({
            url: "/financial?action=Search",
            where: {
                "applyCode": applyCode,
                "mName": mName,
                "applyTime": applyTime,
                "status": status,
                "applyName": applyName,
                "phaName": phaName,
                "finName": finName
            },
            page: { curr: 1 }
        });
        renderApplyUser();
        renderPharmacist();
        renderFinancial();
        getCode();
        getmName();
        getTime();
        getStatus();
    }

    function winReload(){
        location.reload();
    }

    function delApply(ids){
        $.ajax({
            url: "/financial?action=delApply",
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
                        location.reload();
                    } else {
                        layer.msg("删除失败", { icon: 2 });
                    }
                }
            }
        });
    }
    function setUnApprove(id){
        $.ajax({
            url: "/financial?action=setUnApprove",
            data: { "id": id },
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
                        layer.msg("审核成功", { icon: 1 });
                        location.reload();
                    } else {
                        layer.msg("审核失败", { icon: 2 });
                    }
                }
            }
        });
    }

    function setApprove(id){
        $.ajax({
            url: "/financial?action=setApply",
            data: { "id": id },
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
                        layer.msg("审核成功", { icon: 1 });
                        location.reload();
                    } else {
                        layer.msg("审核失败", { icon: 2 });
                    }
                }
            }
        });
    }

    function approve(array,state){
        for (let i = 0; i < state.length; i++) {
            if (state[i]==="已审阅通过" || state[i]==="已审阅未通过"){
                layer.alert("单据"+array[i]+"已审阅,请取消！");
                return ;
            }
        }
        if (array.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        var dataString = $.param({"array": array});
        console.log("-------------------------------");
        console.log(array);
        console.log(state);
        console.log(dataString);
        layui.layer.open({
            title : "审批",
            type : 2,
            content : "medicine/approveManage/financialApproval/financialApprovalInfo.jsp",
            area:['900px','500px'],
            success:function (layero, index){
                $.ajax({
                    url:"/financial?action=getApproveById",//根据id将状态改成“已审批”
                    type:"post",
                    data:{dataString},
                    success:function(data){
                        var info = JSON.parse(data).data;
                        console.log("**************")
                        console.log(info);
                        var iframe = layer.getChildFrame('body', index);
                        var rowsHtml = '';
                        $(document).ready(function(){
                            form.render('checkbox');
                        });
                        $.each(info, function(i, item) {
                            rowsHtml += '<tr>';
                            rowsHtml += '<td><input type="checkbox" id="'+i+'" name="'+item.mName+'" value="'+item.applyId+'"></td>';
                            rowsHtml += '<td>' + item.applyId + '</td>';
                            rowsHtml += '<td>' + item.mName + '</td>';
                            rowsHtml += '<td>' + item.number + '</td>';
                            rowsHtml += '<td>'+item.mType+'</td>';
                            rowsHtml += '<td>'+item.specification+"/"+item.unit+'</td>';
                            rowsHtml += '<td>'+item.financeApprove+'</td>';
                            rowsHtml += '<td>' + item.applyNumber + '</td>';
                            rowsHtml += '<td>' + item.purchasePrice + '</td>>'
                            rowsHtml += '</tr>';
                        });
                        // 更新iframe窗口中的表格body
                        $(iframe).find('#table-body').html(rowsHtml);

                    }
                })
            }
        })
    }
});











