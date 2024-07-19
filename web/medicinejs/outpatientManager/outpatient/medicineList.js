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

    var mPower, mType, Unit, pAge, pId, pWeight, pAddress, pPhone, pAllergy, doctorAdvice, lastTime, tableMain, patientId, mName;
    let mIdList = new Set();
    let priceList = new Map();

    $(document).ready(function() {
        laydate.render({
            elem: '#time'
        });
        var tableIns = table.render({
            elem: '#MedicineList',
            cellMinWidth: 95,
            page: true,
            url: '/patient?action=getPatientMedicine',
            toolbar: '#MedicineDemo',
            height: "800px",
            limit: 20,
            limits: [10, 15, 20, 25],
            cols: [
                [{
                    fixed: "left",
                    type: "checkbox",
                    width: 50
                },
                    {
                        field: 'mId',
                        title: '药品编号',
                        minWidth: 50,
                        align: 'center',
                        sort: true,
                        hide: true
                    },
                    {
                        field: 'mName',
                        title: '药品名称',
                        minWidth: 100,
                        align: "center"
                    },
                    {
                        field: 'salePrice',
                        title: '销售价/元',
                        minWidth: 100,
                        align: 'center',
                        sort: true
                    },
                    {
                        field: 'update',
                        title: '数量',
                        minWidth: 50,
                        align: 'center',
                        sort: true
                    }]
            ]
        });
        tableMain = tableIns;

        table.on('toolbar(MedicineList)', function(obj) {
            var checkdata = table.checkStatus(obj.config.id)
            var files = checkdata.data;

            switch (obj.event) {
                case 'search':
                    console.log("---------------");
                    console.log(mPower);
                    console.log(mType);
                    console.log(Unit);
                    console.log("---------------");
                    Search(mPower, mType, Unit, mName);
                    break;
                case 'reload':
                    winReload();
                    break;
                case 'submit':
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            var inputElement = document.getElementsByName('price_min' + file.mId)[0];
                            priceList.set(file.mId, inputElement.value);
                            mIdList.add(file.mId);
                        });
                        console.log(priceList);
                        submit();
                    } else {
                        layer.msg("你没有选择", { icon: 2 });
                    }
                    break;

            }
        });
    });


    function submit() {
        let priceListObj = {};
        priceList.forEach((value, key) => {
            priceListObj[key] = value;
        });
        let priceListJson = JSON.stringify(priceListObj);
        console.log("======================");
        console.log(priceListJson);
        console.log("======================");

        $.ajax({
            url: "/patient?action=submit",
            type: "POST",
            contentType: "application/json",
            data: priceListJson,
            success: function(res) {
                console.log(res);
                var info = JSON.parse(res);
                console.log(info);
                if (info.status===200){
                    layer.msg("开药方成功", { icon: 1 });
                    parent.layer.close(window.currentLayerIndex);
                    parent.location.close();
                }else {
                    layer.msg("失败", { icon: 2 });
                }
            }
        });
    }

});
