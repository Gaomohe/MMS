layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    var LogName;
    var action1;
    var startTime;
    var endTime;
    var logUser;
    var operate;
    var tableMain;
    var counts = 0;
    var total = 0

    $(document).ready(function(){
        laydate.render({
            elem: '#time'
        });

        //表格渲染
        var tableIns = table.render({
            elem: '#logList',
            url : '/log?action=getLogList',
            cellMinWidth : 95,
            page : true,
            toolbar: '#logDemo',
            height : "600px",
            limit : 20,
            limits : [10,15,20,25],
            cols : [[
                {type: "checkbox", fixed:"left", width:50},
                {field: 'logId', title: '编号',  align:'center',width:150},
                {field: 'time', title: '时间',  align:'center',width:250},
                {field: 'name', title: '操作用户', width:200, align:"center"},
                {field: 'action', title:'动作' , width:200, align:"center"},
                {field: 'item', title:'事务' , width:200, align:"center"},
                {field: 'operate', title:'操作' , width:200, align:"center"}
            ]]
        });
        tableMain = tableIns;
        // 初始化下拉框
        getLogAction();
        getLogItem();
        getLogUser()
        getStartTime();
        getEndTime();
        logOperate();

        table.on('toolbar(logList)', function(obj) {
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
                    search(LogName,action1,startTime,endTime,logUser,operate); // 将 applyIds 数组作为参数传递给 search 函数
                    break;
                // 可以添加更多 case 来处理其他按钮点击事件
                case 'reload':
                    winReload();
                case 'del':
                    console.log("aaa");
                    console.log(files);
                    console.log(files.length);
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            // 假设每个file对象都有一个id属性，用于标识用户
                            console.log(file.logId);
                            total++;
                            delLog(file.logId);
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
        var checkRows = table.checkStatus('logList');
        console.log(checkRows);
        if (checkRows.data.length === 0) {
            layer.msg('请选择要导出的数据', {icon: 2});
        } else {
            table.exportFile(tableMain.config.id,checkRows.data, 'log_data.xls');
        }
    }

    //操作人
    function getLogUser(){
        // 申请编号
        $('input[name="logUser"]').on('input', function(e) {
            logUser = e.target.value;
            console.log("申请人：" + logUser);
        });
    }

    //开始时间
    function getStartTime(){
        // 开始时间
        laydate.render({
            elem: '#startTime',
            type: 'date',
            done: function(value) {
                startTime = value;
                console.log('用户选择的开始时间：', value);
            }
        });
    }

    //结束时间
    function getEndTime(){
        // 结束时间
        laydate.render({
            elem: '#endTime',
            type: 'date',
            done: function(value) {
                endTime = value;
                console.log('用户选择的结束时间：', value);
            }
        });
    }

    //日志动作
    function getLogAction() {
        $.post("/log?action=getLogAction", function(res) {
            try {
                var cs = JSON.parse(res);
                console.log(cs);
                var dom = $("#action").empty().html('<option value="0">动作类型</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.logId + '">' + item.action + '</option>');
                });
                form.render("select");

                form.on('select(action)', function(data) {
                    action1 = cs.find(item => item.logId == data.value)?.action || '';
                    console.log("选中动作动作：" + action1);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    //日志操作类型
    function getLogItem() {
        $.post("/log?action=getLogItem", function(res) {
            try {
                var cs = JSON.parse(res);
                console.log(cs)
                var dom = $("#logType").empty().html('<option value="0">事务类型</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.logId + '">' + item.item + '</option>');
                });
                form.render("select");

                form.on('select(logType)', function(data) {
                    LogName = cs.find(item => item.logId == data.value)?.item || '';
                    console.log("被选中的日志是：" + LogName);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function logOperate(){
        $.post("/log?action=getLogOperate", function(res) {
            try {
                var cs = JSON.parse(res);
                console.log(cs)
                var dom = $("#operate").empty().html('<option value="0">操作</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.logId + '">' + item.operate + '</option>');
                });
                form.render("select");

                form.on('select(operate)', function(data) {
                    operate = cs.find(item => item.logId == data.value)?.operate || '';
                    console.log("被选中的操作是：" + operate);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function delLog(id) {
        $.ajax({
            url: "/log?action=delLog",
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
                        layer.msg("删除成功", { icon: 1 });
                        tableMain.reload();
                    } else {
                        layer.msg("删除失败", { icon: 2 });
                    }
                }
            }
        });
    }

    function search(LogName,action1,startTime,endTime,logUser,operate) {
        console.log("-------------------");
        console.log(action);
        console.log("-------------------");
        tableMain.reload({
            url: "/log?action=Search",
            where: {
                "LogName": LogName,
                "action1": action1,
                "startTime": startTime,
                "endTime": endTime,
                "logUser":logUser,
                "operate":operate
            },
            page: { curr: 1 }
        });
        getLogAction();
        getLogItem();
        getLogUser()
        getStartTime();
        getEndTime();
        logOperate();
    }

    //重置
    function winReload(){
        getLogAction();
        getLogItem();
        getLogUser()
        getStartTime();
        getEndTime();
        logOperate();
        // location.reload();
    }

    //删除日志
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

})