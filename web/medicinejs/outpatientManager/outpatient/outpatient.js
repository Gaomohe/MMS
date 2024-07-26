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
            elem: '#outpatientList',
            cellMinWidth: 95,
            page: true,
            url: '/patient?action=getPatientList',
            toolbar: '#outpatientDemo',
            height: "800px",
            limit: 20,
            limits: [10, 15, 20, 25],
            cols: [[
                {fixed:"left",type: "checkbox", width:50},
                {field: 'pId', title: '患者卡号',  align:'center', width:200},
                // {field: 'dId', title: '医生编号',  align:'center', width:200},
                {field: 'mId', title: '处方编号', minWidth:100, align:"center",hide:true},
                {field: 'name', title: '患者姓名', align:'center', width:200},
                {field: 'sex', title: '性别', align:'center', width:200},
                {field: 'age', title: '年龄', minWidth:100, align:"center"},
                {field: 'weight', title: '体重/kg',  align:'center', width:200},
                {field: 'address', title: '住址',  align:'center', width:200},
                {field: 'phone', title: '联系方式',  align:'center', width:200},
                {field: 'diagnosticTime', title: '就诊时间',  align:'center', width:200},
                {field: 'allergy', title: '过敏史',  align:'center', width:200},
                {field: 'doctorAdvice', title: '医嘱',  align:'center', width:200},
                {field: 'dName', title: '医生姓名',  align:'center', width:200},
                {field: 'lastDiaTime', title: '上次就诊时间',  align:'center', width:200}
            ]],
        });
        tableMain = tableIns;
        // 初始化下拉框
        getName();
        getSex();
        getAge();
        getPid();
        getWeight();
        getAddress();
        getPhone();
        getAllergy();
        getAdvice();
        getDisease();
        getTime();
        getStatus();

        table.on('row(outpatientList)', function(obj){
            var data = obj.data; // 获得当前行数据
            var tr = obj.tr; // 获得当前行的 tr 元素
            var checkbox = tr.find('input[type="checkbox"]'); // 获取复选框元素

            // 使用事件参数来判断实际点击的位置
            var event = window.event || arguments.callee.caller.arguments[0];
            var target = event.target || event.srcElement;

            // 判断点击的是否是复选框
            if (target === checkbox[0] || $(target).closest('td').find('input[type="checkbox"]').length > 0) {
                // 如果点击的是复选框列，不执行行点击的逻辑
                return;
            }

            console.log("点击了表格行");
            console.log(data.pId);
            addMedicine(data.pId);
            // 高亮选中行样式
            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });

        table.on('toolbar(outpatientList)', function(obj) {

            var data = obj.data; // 获得当前行数据
            var tr = obj.tr; // 获得当前行的 tr 元素
            var checkbox = tr.find('input[type="checkbox"]'); // 获取当前行的复选框
            console.log("+++++++++++++++++++++-------------------------");
            console.log(data);
            console.log("+++++++++++++++++++++-------------------------");
            // 检查是否是点击了复选框
            if (checkbox.is(':checked') || checkbox.is(':focus')) {
                // 如果复选框被勾选或获得焦点，不执行行点击的逻辑
                return;
            }
            console.log("+++++++++++++++++++++-------------------------");
            console.log(data);
            console.log("+++++++++++++++++++++-------------------------");
            openDetail(data);
            // 这里可以执行你的业务逻辑，比如打开一个模态框显示详情等

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
                    search(pName, pSex, pAge, pId, pWeight, pAddress, pPhone, pAllergy,doctorAdvice,lastTime);
                    break;
                case 'reload':
                    winReload();
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
                /*case 'addMedicine':
                    if (files.length > 0) {
                        console.log(files[0].pId);
                        addMedicine(files[0].pId);
                    } else {
                        layer.msg("未选择", {icon: 2});
                    }
                    break;*/
            }
        });
    });

    //打开开处方的界面
    function addMedicine(id){
        layui.layer.open({
            title : "开设处方",
            type : 2,
            content : "/patient?action=getAddMenuBtn&pId=" + id,
            area:['1200px','675px']
        });
    }

    function openDetail(data){
        console.log("+++++++++++++++++++++-------------------------");
        console.log(data);
        console.log("+++++++++++++++++++++-------------------------");
        let id = data.pId;
        layui.layer.open({
            title : "开设处方",
            type : 2,
            content : "/patient?action=getAddMenuBtn&pId=" + id,
            area:['1200px','675px']
        });
    }

    //刷新页面
    function winReload(){
        // location.reload();
        getName();
        getSex();
        getAge();
        getPid();
        getWeight();
        getAddress();
        getPhone();
        getAllergy();
        getAdvice();
        getTime();
        getStatus();
    }

    //获取患者姓名
    function getName() {
        console.log("Initializing patient name input");
        $('input[name="pName"]').on('input', function(e) {
            pName = e.target.value;
            console.log("实时输入患者姓名：" + pName);
        });
    }

    function getSex() {
        form.on('select(sex)', function(data) {
            pSex = data.value == 0 ? '' : data.elem.options[data.elem.selectedIndex].text;
            console.log("患者性别：" + pSex);
        });
    }


    function getAge() {
        $('input[name="age"]').on('input', function(e) {
            pAge = e.target.value;
            console.log("患者年龄：" + pAge);
        });
    }

    function getPid() {
        $('input[name="pid"]').on('input', function(e) {
            pId = e.target.value;
            console.log("患者卡号：" + pId);
        });
    }

    function getWeight() {
        $('input[name="weight"]').on('input', function(e) {
            pWeight = e.target.value;
            console.log("患者体重：" + pWeight);
        });
    }

    //患者地址
    function getAddress() {
        $('input[name="address"]').on('input', function(e) {
            pAddress = e.target.value;
            console.log("患者地址：" + pAddress);
        });
    }

    //患者联系方式
    function getPhone() {
        $('input[name="phone"]').on('input', function(e) {
            pPhone = e.target.value;
            console.log("联系方式：" + pPhone);
        });
    }

    //过敏史
    function getAllergy() {
        form.on('select(allergy)', function(data) {
            pAllergy = data.value == 0 ? '' : data.elem.options[data.elem.selectedIndex].text;
            console.log("过敏史：" + pAllergy);
        });
    }

    //医嘱
    function getAdvice() {
        $('textarea[name="doctorAdvice"]').on('input', function(e) {
            doctorAdvice = e.target.value;
            console.log("医嘱：" + doctorAdvice);
        });

    }

    //就诊结果
    function getDisease() {
        $('textarea[name="disease"]').on('input', function(e) {
            disease = e.target.value;
            console.log("医嘱：" + disease);
        });

    }

    function getTime() {
        laydate.render({
            elem: '#lastTime',
            type: 'date',
            done: function(value) {
                lastTime = value;
                console.log('用户选择的时间：', value);
            }
        });
    }

    function getStatus() {
        form.on('select(status)', function(data) {
            status = data.value == 0 ? '' : data.elem.options[data.elem.selectedIndex].text;
            console.log("被选中的状态是：" + status);
        });
    }


    function search(pName, pSex, pAge, pId, pWeight, pAddress, pPhone, pAllergy,doctorAdvice,lastTime) {
        tableMain.reload({
            url: "/patient?action=Search",
            where: {
                "pName": pName,
                "pSex": pSex,
                "pAge": pAge,
                "pId": pId,
                "pWeight": pWeight,
                "pAddress": pAddress,
                "pPhone": pPhone,
                "disease":disease,
                "pAllergy": pAllergy,
                "doctorAdvice": doctorAdvice,
                "lastTime": lastTime
            },
            page: {curr: 1}
        });
        getName();
        getSex();
        getAge();
        getPid();
        getWeight();
        getAddress();
        getPhone();
        getAllergy();
        getAdvice();
        getTime();
        getStatus();
    }

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
                "disease":disease,
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
});

