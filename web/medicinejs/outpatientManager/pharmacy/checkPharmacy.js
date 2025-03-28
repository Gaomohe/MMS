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
    var idList = new Set();
    var numberList = new Set();
    var count = 0;
    var total = 0;

    function getQueryParams() {
        let params = {};
        let queryString = window.location.search.slice(1);
        let pairs = queryString.split("&");
        pairs.forEach(function(pair) {
            let [key, value] = pair.split("=");
            params[decodeURIComponent(key)] = decodeURIComponent(value || '');
        });
        return params;
    }

    $(document).ready(function() {

        let params = getQueryParams();
        console.log("接收到的参数:", params);

        // 获取pId并在页面中显示
        let pIds = parseInt(params.pId, 10);
        patientId = pIds;

        backValues();
        laydate.render({
            elem: '#time'
        });
        var tableIns = table.render({
            elem: '#checkPharmacyList',
            cellMinWidth: 95,
            page: true,
            url: '/pharmacy?action=Check&pIds=' + pIds,
            toolbar: '#checkPharmacyDemo',
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
                    {
                        field: 'unit',
                        title: '单位',
                        minWidth: 100,
                        align: "center",
                    },

                    {
                        field: 'number',
                        title: '数量',
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
                        field: 'position',
                        title: '推荐取药库位',
                        minWidth: 200,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'defined',
                        title: '药品类型',
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


                ]
            ],
        });
        tableMain = tableIns;

        table.on('toolbar(checkPharmacyList)', function(obj) {
            var checkdata = table.checkStatus(obj.config.id)
            var files = checkdata.data;
            var array = [];
            var state = [];
            for (let i = 0; i < files.length; i++) {
                array[i] = files[i].applyId;
                state[i] = files[i].financeApprove;
            }

            switch (obj.event) {
                case 'submit':
                    pay(pIds);
                    break;
            }
        });
    });

    /*function getMedicine(mId){
        $.ajax({
            url:"/pharmacy?action=getMedicine",
            type:"post",
            data:{"mId":mId},
            success:function(data){
                if (res.status==200){
                    layer.msg("取药成功成功", { icon: 1 });
                    tableMain.reload();
                    parent.layer.close(window.currentLayerIndex);
                    if (window.currentLayerIndex !== undefined) {
                        parent.layer.close(window.currentLayerIndex);
                    }
                }else {
                    layer.msg("删除失败", { icon: 2 });
                }
            }
        })
    }*/

    // //刷新页面
    // function winReload(){
    //     // location.reload();
    //     getUnit();
    //     getmType();
    //     getmPower();
    //     getmName();
    // }

    function pay(pIds){
        $.ajax({
            url: "/pharmacy?action=Pay",
            data:{
                "pIds":pIds
            },
            type: "post",
            dataType: "json",
            traditional: true,
            success: function(res) {

                console.log("这是res的值"+res.data);
                layer.msg("需支付总金额!" + res.data + "元!");

            }
        })
    }

    //病患信息回显
    function backValues(){
        $.ajax({
            url:"/pharmacy?action=backValues",
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


    // function getmName(){
    //     $('input[name="mName"]').on('input', function(e) {
    //         mName = e.target.value;
    //         console.log("药品名称：" + mName);
    //     });
    // }
    //
    // /*//获取药品分类
    // function getmPower() {
    //     console.log("---------------");
    //     $.post("/patient?action=getmPower", function(res) {
    //         console.log(res);
    //         try {
    //             var cs = JSON.parse(res);
    //             var dom = $("#mPower").empty().html('<option value="0">药品功效</option>');
    //             $.each(cs, function(index, item) {
    //                 dom.append('<option value="' + item.id + '">' + item.typename + '</option>');
    //             });
    //             form.render("select");
    //
    //             form.on('select(mPower)', function(data) {
    //                 mPower = cs.find(item => item.id == data.value)?.typename || '';
    //                 console.log("被选药品功效：" + mPower);
    //             });
    //         } catch (e) {
    //             console.error("Error parsing JSON:", e);
    //         }
    //     });*/
    // // }
    //
    // //获取药品类型
    // function getmType() {
    //     $.post("/patient?action=getmType", function(res) {
    //         try {
    //             var cs = JSON.parse(res);
    //             var dom = $("#mType").empty().html('<option value="0">药品类型</option>');
    //             $.each(cs, function(index, item) {
    //                 dom.append('<option value="' + item.id + '">' + item.typename + '</option>');
    //             });
    //             form.render("select");
    //
    //             form.on('select(mType)', function(data) {
    //                 mType = cs.find(item => item.id == data.value)?.typename || '';
    //                 console.log("被选中的药品类型：" + mType);
    //             });
    //         } catch (e) {
    //             console.error("Error parsing JSON:", e);
    //         }
    //     });
    // }
    //
    // //获取药剂类型
    // function getUnit() {
    //     $.post("/patient?action=getUnit", function(res) {
    //         try {
    //             var cs = JSON.parse(res);
    //             var dom = $("#unit").empty().html('<option value="0">药剂类型</option>');
    //             $.each(cs, function(index, item) {
    //                 dom.append('<option value="' + item.id + '">' + item.typename + '</option>');
    //             });
    //             form.render("select");
    //
    //             form.on('select(unit)', function(data) {
    //                 Unit = cs.find(item => item.id == data.value)?.typename || '';
    //                 console.log("被药品药剂类型：" + Unit);
    //             });
    //         } catch (e) {
    //             console.error("Error parsing JSON:", e);
    //         }
    //     });
    // }

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

