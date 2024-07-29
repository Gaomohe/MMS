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

        /*var tableIns = table.render({
            elem: '#financialList',
            cellMinWidth: 95,
            page: true,
            url : '/appoint?action=getAllAppoint',
            toolbar: '#financialDemo',
            height: "600px",
            limit: 20,
            limits: [10, 15, 20, 25],
            cols: [[
                {fixed:"left",type: "checkbox", width:50},
                {field: 'applyId', title: '申请编号',  align:'center',width:200},
                {field: 'mId', title: '字典编号',  align:'center',width:200},
                {field: 'mName', title: '药品名称', minWidth:100, align:"center",width:200},
                {field: 'specification', title: '规格', align:'center',width:200},
                {field: 'manufactor', title: '生产企业', align:'center',width:200},
                {field: 'unit', title: '单位', minWidth:100, align:"center",width:200},
                {field: 'department', title: '部门',  align:'center',width:200},
                {field: 'applyNumber', title: '采购数量',  align:'center',width:200},
                {field: 'purchasePrice', title: '采购价',  align:'center',width:200},
                {field: 'code', title: '批号',  align:'center',width:200},
                {field: 'mType', title: '药品分类',  align:'center',width:200},
                {field: 'supplier', title: '供货单位',  align:'center',width:200},
                {field: 'approvalNumber', title: '准批文号',  align:'center',width:200},
                {field: 'placeOrigin', title: '产地',  align:'center',width:200},
                {field: 'applyUser' ,title:'申请人', align:'center',width:200},
                {field: 'applyTime' ,title:'申请时间', align:'center',width:200},
                {field: 'pharmacist' ,title:'药师', align:'center',width:200},
                {field: 'pharmacistApprove' ,title:'药师审批', align:'center',width:200},
                {field: 'pharmacistTime' ,title:'药师审批时间', align:'center',width:200},
                {field: 'finance' ,title:'财务', align:'center',width:200},
                {field: 'financeApprove' ,title:'财务审批', align:'center',width:200},
                {field: 'financeTime' ,title:'财务审批时间', align:'center',width:200}
            ]],
        });*/
        var tableIns = table.render({
            elem: '#financialList',
            url : '/orders?action=selectOrders',
            cellMinWidth : 95,
            page : true,
            toolbar: '#financialDemo',
            height : "full-25",
            limit : 20,
            limits : [10,15,20,25],
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'oId', title: '采购单号',  align:'center',width:100,sort:true},
                {field: 'oName', title: '订单状态',  align:'center',width:100},
                {field: 'specification', title: '审阅人', width:100, align:"center"},
                {field: 'manufactor', title:'生产企业' , width:250, align:"center"},
                // {field: 'unit', title:'单位' , width:100, align:"center"},
                // {field: 'oNum', title:'订单数量' , width:100, align:"center"},
                // {field: 'salePrice', title:'采购单价' , width:100, align:"center"},
                {field: 'shippingAddress', title:'发货地址' , width:300, align:"center"},
                {field: 'deliveryAddress', title:'收货地址' , width:300, align:"center"},
                {field: 'shippingTime', title:'发货时间' , width:150, align:"center"},
                {field: 'allPrice', title:'订单总价格' , width:100, align:"center"},
                {field: 'shippingWay', title:'发货方式' , width:150, align:"center"},
                {field: 'tempControlWay', title:'温控方式' , width:100, align:"center"},
                {field: 'deliveryTime', title:'到货时间' , width:100, align:"center"},
                {field: 'deliveryTemp', title:'到货温度' , width:100, align:"center"},
                {field: 'attachment', title:'关联附件' , width:100, align:"center"},
                {field: 'salesman', title:'供货单位业务员' , width:100, align:"center"},
                {field: 'buyer', title:'采购人' , width:100, align:"center"},
                {field: 'recipient', title:'收货人' , width:100, align:"center"},
                // {field: 'orderCondition', title:'收货状态' , width:100, align:"center"},
                // {field: 'statement', title:'收货状态' , width:100, align:"center"},

                {field: 'advance', title:'订单预付款' , width:150, align:"center"},
                {field: 'advanceStatus', title:'订单预付款状态' , width:200, align:"center"},
                {field: 'finals', title:'订单尾款' , width:150, align:"center"},
                {field: 'finalsStatus', title:'订单尾款状态' , width:200, align:"center"},
            ]],
            done:function (data){
            }
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

        table.on('toolbar(financialList)', function(obj) {
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
                    console.log("aaa");
                    console.log(files);
                    console.log(files.length);
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            // 假设每个file对象都有一个id属性，用于标识用户
                            console.log("=====================");
                            console.log(file.applyId);
                            console.log("=====================");
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
                case 'download':
                    console.log("--------------------");
                    downloads();
                    break;
            }
        });
    });

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











