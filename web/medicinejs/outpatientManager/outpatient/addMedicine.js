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
    var mPower,mType,Unit, pAge, pId, pWeight, pAddress, pPhone, pAllergy,doctorAdvice,lastTime,tableMain,patientId,mName;
    let mIdList = new Set();

    $(document).ready(function() {
        backValues();
        laydate.render({
            elem: '#time'
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

        table.on('toolbar(addMedicineList)', function(obj) {
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
                    console.log("---------------");
                    console.log(mPower);
                    console.log(mType);
                    console.log(Unit);
                    console.log("---------------");
                    Search(mPower,mType,Unit,mName);
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
            url:"/patient?action=backValues",
            data: {
                "patientId":patientId
            },
            type: "post",
            dataType: "json",
            traditional: true,
            success: function(res) {
                console.log("--------------------");
                console.log(res);
                console.log("++++++++++++++++++++");
                document.querySelector('input[name="pid"]').value = res.pId;
                pId = res.pId;
                document.querySelector('input[name="pName"]').value = res.name;
                document.querySelector('input[name="sex"]').value = res.sex;
                document.querySelector('input[name="age"]').value = res.age;
                document.querySelector('input[name="weight"]').value = res.weight;
                document.querySelector('input[name="address"]').value = res.address;
                document.querySelector('input[name="phone"]').value = res.phone;
                document.querySelector('input[name="allergy"]').value = res.allergy;
                document.querySelector('input[name="time"]').value = res.diagnosticTime;
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

    var define = "";
    function Search(mPower,mType,Unit,mName) {
        tableMain.reload({
            url: '/patient?action=getMedicineList',
            where: {
                "mPower": mPower,
                "mType": mType,
                "Unit": Unit,
                "mName":mName
            },
            page: {curr: 1}
        });
        // 重新获取下拉菜单的选项
        getUnit();
        getmType();
        getmPower();
        backValues();
        getmName();
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

    /*function addMedicine(){
        let mIdArray = Array.from(mIdList); // 将 Set 转化为数组
        $.ajax({
            url:"/patient?action=addMedicine",
            data: {
                "mIdList": mIdArray,
                "pId": pId,
            },
            type: "post",
            dataType: "json",
            traditional: true,
            success:function (res){
                if (res.status==200){
                    layer.msg("开出处方成功", { icon: 1 });
                    tableMain.reload();
                }else {
                    layer.msg("删除失败", { icon: 2 });
                }
            }
        });
    }*/

    //打开开处方的界面
    function addMedicine(){
        let mIdArray = Array.from(mIdList); // 将 Set 转化为数组
        console.log("1111111111111111111");
        console.log(mIdList);
        console.log("2222222222222222222");
        console.log(mIdArray);
        console.log("3333333333333333333");

        layui.layer.open({
            title : "开设处方",
            type : 2,
            content: "/patient?action=getMenuBtn1&mIdList=" + mIdArray.join(","),
            area:['1000px','600px']
        });
    }
});

