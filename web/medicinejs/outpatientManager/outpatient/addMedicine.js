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
    var mPower,mType,Unit, pAge, pId, pWeight, pAddress, pPhone, pAllergy,disease,doctorAdvice,lastTime,tableMain,patientId,mName,pName,pSex;

    var inputVal = "";
    let mIdList = new Set();

    $(document).ready(function() {
        backValues();
        laydate.render({
            elem: '#time'
        });
        function getQueryVariable(variable) {
            var query = window.location.search.substring(1);
            var vars = query.split("&");
            for (var i = 0; i < vars.length; i++) {
                var pair = vars[i].split("=");
                if (pair[0] == variable) {
                    return pair[1];
                }
            }
            return false;
        }

        // 获取 pId 参数并转换为整数
        pId = parseInt(getQueryVariable("pId"), 10);
        // 将 pId 参数用于你的页面逻辑
        $.ajax({
            url: '/patient?action=getPatientInfo',
            type: 'GET',
            data: { "pId": pId },
            success: function(res) {
                console.log("/////////////////////");
                console.log(res);
                console.log("/////////////////////");
                res = JSON.parse(res);
               /* var info = JSON.parse(data);
                console.log(info);
                var body = layui.layer.getChildFrame('body', index);*/
                // body.find("#pid").val(info.data.oId); // 采购单号
                document.querySelector('input[name="pid"]').value = res.pId;
                pId = res.pId;
                console.log("患者id：" + pId);
                document.querySelector('input[name="pName"]').value = res.name;
                pName = res.name;
                console.log("患者：" + pName);
                document.querySelector('input[name="sex"]').value = res.sex;
                pSex = res.sex;
                console.log("患者：" + pSex);
                document.querySelector('input[name="age"]').value = res.age;
                pAge = res.age;
                document.querySelector('input[name="weight"]').value = res.weight;
                pWeight = res.weight;
                document.querySelector('input[name="address"]').value = res.address;
                pAddress = res.address;
                // document.querySelector('input[name="phone"]').value = res.phone;
                // pPhone = res.phone;
                document.querySelector('input[name="allergy"]').value = res.allergy;
                pAllergy = res.allergy;
                // document.querySelector('input[name="time"]').value = res.diagnosticTime;
                document.querySelector('textarea[name="disease"]').value = res.disease;
                disease = res.disease;
                console.log("病：" + disease);
                document.querySelector('textarea[name="doctorAdvice"]').value = res.doctorAdvice;
                doctorAdvice = res.doctorAdvice;
                console.log("医嘱：" + doctorAdvice);
            }
        });
        var tableIns = table.render({
            elem: '#addMedicineList',
            cellMinWidth: 95,
            page: true,
            url: '/medicine?action=getAllMedicine',
            toolbar: '#addMedicineDemo',
            height: "800px",
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
                        sort: true,
                        hide:true
                    },
                    {
                        field: 'mId',
                        title: '药品编号',
                        minWidth: 200,
                        align: 'center',
                        sort: true,
                        hide:true
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
                    /*{
                        field: 'manufactor',
                        title: '生产企业',
                        minWidth: 400,
                        align: 'center',
                    },*/
                    {
                        field: 'unit',
                        title: '单位',
                        minWidth: 100,
                        align: "center",
                    },
                    /*{
                        field: 'department',
                        title: '部门',
                        minWidth: 200,
                        align: 'center',
                    },*/
                    /*{
                        field: 'position',
                        title: '货位',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },*/
                    {
                        field: 'number',
                        title: '数量',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    /*{
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
                    },*/
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
                    /*{
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
                    },*/
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
                    /*{
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
                    },*/
                    /*{
                        field: 'warehousingRemarks',
                        title: '入库备注',
                        minWidth: 200,
                        align: 'center',
                    },*/
                    {
                        field: 'drugFrom',
                        title: '剂型',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                   /* {
                        field: 'handlingInformation',
                        title: '处理情况',
                        minWidth: 200,
                        align: 'center',
                    },*/
                    {
                        field: 'approvalNumber',
                        title: '批准文号',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    /*{
                        field: 'lastCuringDate',
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
                    }*/
                ]
            ],
        });
        tableMain = tableIns;
        getUnit();
        getmType();
        getmPower();
        getmName();
        Search();


        table.on('toolbar(addMedicineList)', function(obj) {
            var checkdata = table.checkStatus(obj.config.id)
            var files = checkdata.data;
            var array = [];
            var state = [];
            for (let i = 0; i < files.length; i++) {
                array[i] = files[i].applyId;
                state[i] = files[i].financeApprove;
            }
            console.log("event的值:" + obj.event);
            switch (obj.event) {
                case 'submit':
                    console.log("这里执行了Search");
                    Search();
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
                case 'approve':
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            total++;
                            setApprove(file.applyId);
                        });
                    } else {
                        layer.msg("未选择", {icon: 2});
                    }
                    break;
                case 'addPatient':
                    addPatient();
                    break;
                case 'addMedicine':
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            mIdList.add(file.mId)
                        });
                    } else {
                        layer.msg("未选择", {icon: 2});
                    }
                    console.log(mIdList);
                    addMedicine();
                    break;
            }
        });

    });

    //刷新页面
    function winReload(){
        // location.reload();
        getUnit();
        getmType();
        getmPower();
        getmName();
    }

    //病患信息回显
    function backValues(){
        $.ajax({
            url:"/patient?action=getPatientInfo",
            data: {
                "pId":pId
            },
            type: "post",
            dataType: "json",
            traditional: true,
            success: function(res) {
                console.log("--------------------");
                console.log(res);
                console.log("++++++++++++++++++++");
                document.querySelector('input[name="pid"]').value = res.pId;

                document.querySelector('input[name="pName"]').value = res.name;

                document.querySelector('input[name="sex"]').value = res.sex;

                document.querySelector('input[name="age"]').value = res.age;

                document.querySelector('input[name="weight"]').value = res.weight;

                document.querySelector('input[name="address"]').value = res.address;

                document.querySelector('input[name="phone"]').value = res.phone;

                document.querySelector('input[name="allergy"]').value = res.allergy;

                // document.querySelector('input[name="time"]').value = res.diagnosticTime;
                document.querySelector('textarea[name="disease"]').value = res.disease;

                document.querySelector('textarea[name="doctorAdvice"]').value = res.doctorAdvice;

            }
        })
    }


    function getmName(){
        $('input[name="mName"]').on('input', function(e) {
            mName = e.target.value;
            console.log("药品名称：" + mName);
        });
    }

    //获取药品分类
    function getmPower() {
        console.log("---------------");
        $.post("/patient?action=getmPower", function(res) {
            console.log(res);
            try {
                var cs = JSON.parse(res);
                var dom = $("#mPower").empty().html('<option value="0">药品功效</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.id + '">' + item.typename + '</option>');
                });
                form.render("select");

                form.on('select(mPower)', function(data) {
                    mPower = cs.find(item => item.id == data.value)?.typename || '';
                    console.log("被选药品功效：" + mPower);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    //获取药品类型
    function getmType() {
        $.post("/patient?action=getmType", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#mType").empty().html('<option value="0">药品类型</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.id + '">' + item.typename + '</option>');
                });
                form.render("select");

                form.on('select(mType)', function(data) {
                    mType = cs.find(item => item.id == data.value)?.typename || '';
                    console.log("被选中的药品类型：" + mType);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    //获取药剂类型
    function getUnit() {
        $.post("/patient?action=getUnit", function(res) {
            try {
                var cs = JSON.parse(res);
                var dom = $("#unit").empty().html('<option value="0">药剂类型</option>');
                $.each(cs, function(index, item) {
                    dom.append('<option value="' + item.id + '">' + item.typename + '</option>');
                });
                form.render("select");

                form.on('select(unit)', function(data) {
                    Unit = cs.find(item => item.id == data.value)?.typename || '';
                    console.log("被药品药剂类型：" + Unit);
                });
            } catch (e) {
                console.error("Error parsing JSON:", e);
            }
        });
    }

    function getValue(){

    }

    //单框查询所有
    function Search() {
        // 实时监听输入框变化
        $("#search").on("input", function() {
            inputVal = $(this).val(); // 更新全局变量的值
            console.log("实时接收的值:", inputVal);
        });

        console.log("Search已经被执行了!");

        // 处理表单提交
        $("#submit").click(function(e) {
            e.preventDefault(); // 阻止表单的默认提交行为

            // 在点击提交按钮时重新获取输入框的值
            var inputVal = $("#search").val();
            console.log("输入值inputVal:" + inputVal);

            table.reload('addMedicineList', {
                url: '/patient?action=searchMedicine',
                where: { "inputVal": inputVal },
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


    function addPatient(){
        $.ajax({
            url: "/patient?action=addPatient",
            data: {
                "pId": pId,
                "pName": pName,
                "pSex": pSex,
                "pAge": pAge,
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




    //打开开处方的界面
    /*function addMedicine(){
        let mIdArray = Array.from(mIdList); // 将 Set 转化为数组
        let otherParams = {
            pId: pId,
            pName: pName,
            pSex: pSex,
            pAge: pAge,
            pWeight: pWeight,
            pAddress: pAddress,
            pPhone: pPhone,
            pAllergy: pAllergy,
            doctorAdvice: doctorAdvice
        };

        // 编码参数
        let paramsString = Object.keys(otherParams).map(key => `${key}=${encodeURIComponent(otherParams[key])}`).join('&');
        console.log("1111111111111111111");
        console.log(mIdList);
        console.log("2222222222222222222");
        console.log(mIdArray);
        console.log("3333333333333333333");

        layui.layer.open({
            title: "开设处方",
            type: 2,
            content: `/patient?action=getMenuBtn1&mIdList=${mIdArray.join(",")}&${paramsString}`,
            area: ['950px', '550px']
        });
    }*/
    function addMedicine() {
        console.log("disease的值是" + disease);
        let mIdArray = Array.from(mIdList); // 将 Set 转化为数组
        let otherParams = {
            pId: pId,
            pName: pName,
            pSex: pSex,
            pAge: pAge,
            pWeight: pWeight,
            pAddress: pAddress,
            pPhone: pPhone,
            pAllergy: pAllergy,
            disease:disease,
            doctorAdvice: doctorAdvice
        };

        // 编码参数
        let paramsString = Object.keys(otherParams).map(key => `${key}=${encodeURIComponent(otherParams[key])}`).join('&');
        console.log("1111111111111111111");
        console.log(mIdList);
        console.log("2222222222222222222");
        console.log(mIdArray);
        console.log("3333333333333333333");

        layui.layer.open({
            title: "开设处方",
            type: 2,
            content: `/patient?action=getMenuBtn1&mIdList=${mIdArray.join(",")}&${paramsString}`,
            area: ['950px', '550px']
        });
    }



});

