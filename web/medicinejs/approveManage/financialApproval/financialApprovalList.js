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

    $(document).ready(function(){
        laydate.render({
            elem: '#time'
        });
    });
    var applyCode;//申请编号
    var mName;//药品名称
    var applyTime;//申请时间
    var status;//状态
    var applyName;//申请人
    var phaName;//药师
    var finName;//财务
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
    //申请编号
    document.querySelector('input[name="code"]').addEventListener('input', function(e){
        var codeValue = e.target.value; // 获取输入框的当前值
        console.log("实时输入申请编号：" + codeValue);
        applyCode = codeValue;
    });

    //药品名称
    document.querySelector('input[name="mName"]').addEventListener('input', function(e){
        var codeValue = e.target.value; // 获取输入框的当前值
        console.log("药品名称：" + codeValue);
        mName = codeValue;
    });

    //申请时间
    laydate.render({
        elem: '#time',
        type: 'date',
        done: function(value, date, endDate){
            // 这里的 value 就是用户选择的时间值
            console.log('用户选择的时间：', value);
            applyTime=value;
        }
    });
    /*document.getElementById('time').addEventListener('input', function(e){
        // 注意：如果用户是通过 laydate 选择的时间，这个事件不会触发。
        var timeValue = e.target.value;
        console.log('输入框中的时间值：', timeValue);
    });*/

    //申请人选择下拉框
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
            form.on('select(applyUser)', function(data){
                var selectedValue = data.value; // 获取被选中的药师ID
                var selectedName = "";

                $.each(cs, function(index, item) {
                    console.log(index);
                    console.log(item);
                    console.log(item.id);
                    if (item.id == selectedValue) {
                        selectedName = item.userName; // 找到对应的药师名字
                        return false; // 找到后退出循环
                    }
                });
                console.log("申请人：" + selectedName);
                applyName = selectedName;
            });
        }
    )

    //状态选择下拉框
    form.on('select(status)', function(data){
        var selectedValue = data.value; // 获取被选中的状态码
        var selectedText = data.elem.options[data.elem.selectedIndex].text; // 获取被选中的状态文本
        console.log("被选中的状态码是：" + selectedValue);
        console.log("被选中的状态是：" + selectedText);
        status = selectedText;
    });

    //药师选择下拉框
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
            form.on('select(pharmacist)', function(data){
                var selectedValue = data.value; // 获取被选中的药师ID
                var selectedName = "";

                $.each(cs, function(index, item) {
                    console.log(index);
                    console.log(item);
                    console.log(item.id);
                    if (item.id == selectedValue) {
                        selectedName = item.userName; // 找到对应的药师名字
                        return false; // 找到后退出循环
                    }
                });
                console.log("被选中的药师名字是：" + selectedName);
                phaName = selectedName;
            });
        }
    )

    //财务选择下拉框
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
            form.on('select(financial)', function(data){
                var selectedValue = data.value; // 获取被选中的药师ID
                var selectedName = "";

                $.each(cs, function(index, item) {
                    console.log(index);
                    console.log(item);
                    console.log(item.id);
                    if (item.id == selectedValue) {
                        selectedName = item.userName; // 找到对应的药师名字
                        return false; // 找到后退出循环
                    }
                });
                console.log("被选中的药师名字是：" + selectedName);
                finName = selectedName;
            })
        }
    )


});