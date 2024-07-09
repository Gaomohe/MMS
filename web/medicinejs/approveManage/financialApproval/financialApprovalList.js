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

    laydate.render({
        elem: '#financialList'
    });

    //表格渲染
    var tableIns = table.render({
        elem: '#financialList',
        url : '/purchase?action=getAllAppoint',
        cellMinWidth : 95,
        page : true,
        toolbar: '#financialDemo',
        height : "600px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'applyId', title: '申请编号',  align:'center'},
            {field: 'mId', title: '字典编号',  align:'center'},
            {field: 'mName', title: '药品名称', minWidth:100, align:"center"},
            {field: 'specification', title: '规格', align:'center'},
            {field: 'manufactor', title: '生产企业', align:'center'},
            {field: 'unit', title: '单位', minWidth:100, align:"center"},
            {field: 'department', title: '部门',  align:'center'},
            // {field: 'number', title: '采购数量',  align:'center'},
            {field: 'applyNumber', title: '采购数量',  align:'center'},
            {field: 'purchasePrice', title: '采购价',  align:'center'},
            {field: 'code', title: '批号',  align:'center'},
            {field: 'mType', title: '药品分类',  align:'center'},
            {field: 'supplier', title: '供货单位',  align:'center'},
            {field: 'approvalNumber', title: '准批文号',  align:'center'},
            {field: 'placeOrigin', title: '产地',  align:'center'},
            {field: 'applyUser' ,title:'申请人', align:'center'},
            {field: 'applyTime' ,title:'申请时间', align:'center'},
            {field: 'pharmacist' ,title:'药师审批人', align:'center'},
            {field: 'pharmacistApprove' ,title:'药师审批', align:'center'},
            {field: 'pharmacistTime' ,title:'药师审批时间', align:'center'},
            {field: 'finance' ,title:'财务审批人', align:'center'},
            {field: 'financeApprove' ,title:'财务审批', align:'center'},
            {field: 'financeTime' ,title:'财务审批时间', align:'center'}
        ]],
        done:function (){

        }
    });

    $.post("/user?action=getAppUser",
        function(res) {
            console.log(res);
            try {
                var cs = JSON.parse(res);
                var dom = $("#applyUser");
                dom.empty(); // 清空现有的选项
                var html = '<option value="0">申请人</option>';
                $.each(cs, function(index, item) {
                    html += '<option value="' + item.id + '">' + item.userName + '</option>';
                });
                dom.html(html);
                layui.form.render("select") // 重新渲染下拉框
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        }
    )

    $.post("/user?action=getPhaName",
        function(res) {
            console.log(res);
            try {
                var cs = JSON.parse(res);
                var dom = $("#pharmacist");
                dom.empty(); // 清空现有的选项
                var html = '<option value="0">药师</option>';
                $.each(cs, function(index, item) {
                    html += '<option value="' + item.id + '">' + item.userName + '</option>';
                });
                dom.html(html);
                layui.form.render("select") // 重新渲染下拉框
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        }
    )

    $.post("/user?action=getFinName",
        function(res) {
            console.log(res);
            var cs = JSON.parse(res);
            var dom = $("#financial");
            dom.empty(); // 清空现有的选项
            var html = '<option value="0">财务</option>';
            $.each(cs, function(index, item) {
                html += '<option value="' + item.id + '">' + item.userName + '</option>';
            });
            dom.html(html);
            layui.form.render("select") // 重新渲染下拉框
        }
    )


});