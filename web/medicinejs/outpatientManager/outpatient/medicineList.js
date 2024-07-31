/*
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

    let params = {};
    let queryString = window.location.search.slice(1);
    let pairs = queryString.split("&");

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
                        sort: true,
                        templet: function(d) {
                            return `<input type="number" name="quantity_${d.mId}" value="1" class="layui-input" style="width: 80px;" min="1" placeholder="输入数量"/>`;
                        }
                    }]
            ]
        });

        pairs.forEach(function(pair) {
            let [key, value] = pair.split("=");
            params[decodeURIComponent(key)] = decodeURIComponent(value || '');
        });

        table.on('toolbar(MedicineList)', function(obj) {
            var checkdata = table.checkStatus(obj.config.id);
            var files = checkdata.data;

            switch (obj.event) {
                case 'submit':
                    if (files.length > 0) {
                        let priceListObj = {};
                        let medicines = [];

                        files.forEach(function(file) {
                            let mId = file.mId;
                            let mName = file.mName;
                            let salePrice = file.salePrice;
                            let quantity = $(`input[name='quantity_${mId}']`).val(); // 获取数量值

                            // 确保获取到的数量值是正确的
                            console.log(`mId: ${mId}, quantity: ${quantity}`);

                            medicines.push({
                                mId: mId,
                                mName: mName,
                                price: salePrice,
                                quantity: quantity
                            });

                            priceListObj[mId] = quantity;
                        });

                        let priceListJson = JSON.stringify(priceListObj);
                        let medicinesJson = JSON.stringify(medicines);

                        // 编码 params 对象
                        let paramsString = Object.keys(params).map(key => `${key}=${encodeURIComponent(params[key])}`).join('&');

                        // 打开新页面并传递数据
                        layui.layer.open({
                            title: "下一页面",
                            type: 2,
                            content: `/medicine/outpatientManager/outpatient/signature.jsp?priceList=${encodeURIComponent(priceListJson)}&medicines=${encodeURIComponent(medicinesJson)}&patientInfo=${encodeURIComponent(patientInfoJson)}&${paramsString}`,
                            area: ['850px', '600px']
                        });

                    } else {
                        layer.msg("你没有选择", { icon: 2 });
                    }
                    break;
            }
        });
    });
});
*/


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

    let params = {};
    let queryString = window.location.search.slice(1);
    let pairs = queryString.split("&");

    $(document).ready(function() {
        // 解析 URL 参数
        pairs.forEach(function(pair) {
            let [key, value] = pair.split("=");
            params[decodeURIComponent(key)] = decodeURIComponent(value || '');
        });

        // 渲染日期选择器
        laydate.render({
            elem: '#time'
        });

        // 渲染药品列表表格
        table.render({
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
                        sort: true,
                        templet: function(d) {
                            return `<input type="number" name="quantity_${d.mId}" value="1" class="layui-input" style="width: 80px;" min="1" placeholder="输入数量"/>`;
                        }
                    }]
            ]
        });

        // 处理表格工具栏的操作
        table.on('toolbar(MedicineList)', function(obj) {
            var checkdata = table.checkStatus(obj.config.id);
            var files = checkdata.data;

            switch (obj.event) {
                case 'submit':
                    if (files.length > 0) {
                        let priceListObj = {};
                        let medicines = [];

                        files.forEach(function(file) {
                            let mId = file.mId;
                            let mName = file.mName;
                            let salePrice = file.salePrice;
                            let quantity = $(`input[name='quantity_${mId}']`).val(); // 获取数量值

                            // 确保获取到的数量值是正确的
                            console.log(`mId: ${mId}, quantity: ${quantity}`);

                            medicines.push({
                                mId: mId,
                                mName: mName,
                                price: salePrice,
                                quantity: quantity
                            });

                            priceListObj[mId] = quantity;
                        });

                        let priceListJson = JSON.stringify(priceListObj);
                        let medicinesJson = JSON.stringify(medicines);

                        // 编码 params 对象
                        let paramsString = Object.keys(params).map(key => `${key}=${encodeURIComponent(params[key])}`).join('&');

                        // 生成患者信息 JSON
                        let patientInfoJson = JSON.stringify({

                            pId: params.pId,
                            pName: params.pName,
                            pSex: params.pSex,
                            pAge: params.pAge,
                            pWeight: params.pWeight,
                            pAddress: params.pAddress,
                            pPhone: params.pPhone,
                            pAllergy: params.pAllergy,
                            disease : params.disease,
                            doctorAdvice: params.doctorAdvice
                        });



                        // 打开第三个页面并传递数据
                        layui.layer.open({
                            title: "下一页面",
                            type: 2,
                            content: `/medicine/outpatientManager/outpatient/signature.jsp?priceList=${encodeURIComponent(priceListJson)}&medicines=${encodeURIComponent(medicinesJson)}&patientInfo=${encodeURIComponent(patientInfoJson)}&${paramsString}`,
                            area: ['850px', '600px']
                        });

                    } else {
                        layer.msg("你没有选择", { icon: 2 });
                    }
                    break;
            }
        });
    });
});
