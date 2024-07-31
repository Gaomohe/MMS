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
    var medicine;
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

        // 获取 priceList、medicines 和 patientInfo 数据
        let priceListJson = params.priceList;
        let medicinesJson = params.medicines;
        let patientInfoJson = params.patientInfo;

        if (priceListJson && medicinesJson && patientInfoJson) {
            let priceList = JSON.parse(decodeURIComponent(priceListJson));
            let medicines = JSON.parse(decodeURIComponent(medicinesJson));
            medicine = medicines;
            let patientInfo = JSON.parse(decodeURIComponent(patientInfoJson));

            console.log("价格列表数据:", priceList);
            console.log("药品详细信息:", medicines);
            console.log("患者信息:", patientInfo);
            console.log("患者id:", patientInfo.pId);
            pId = patientInfo.pId;
            pName = patientInfo.pName;
            pSex = patientInfo.pSex;
            pWeight = patientInfo.pWeight;
            pAllergy = patientInfo.pAllergy;
            pAddress = patientInfo.pAddress;
            doctorAdvice = patientInfo.doctorAdvice;
            disease = patientInfo.disease;

            // 示例：将数据渲染到表格中
            layui.use(['table'], function() {
                let table = layui.table;

                table.render({
                    elem: '#tableOne',
                    data: medicines,
                    cols: [[
                        { field: 'mId', title: '药品编号', minWidth: 60},
                        { field: 'mName', title: '药品名称', minWidth: 60},
                        { field: 'price', title: '价格', minWidth: 60},
                        { field: 'quantity', title: '数量', minWidth: 60}
                    ]]
                });

                table.render({
                    elem: '#tableTwo',
                    data: medicines,
                    cols: [[
                        { field: 'mId', title: '药品编号', minWidth: 60},
                        { field: 'mName', title: '药品名称', minWidth: 60},
                        { field: 'price', title: '价格', minWidth: 60},
                        { field: 'quantity', title: '数量', minWidth: 60}
                    ]]
                });
            });

            // 示例：显示患者信息
            $('#pid').val(patientInfo.pId || '');
            $('#pName').val(patientInfo.pName || '');
            $('#sex').val(patientInfo.pSex || '');
            $('#weight').val(patientInfo.pWeight || '');
            $('#age').val(patientInfo.pAge || '');
            $('#address').val(patientInfo.pAddress || '');
            $('#phone').val(patientInfo.pPhone || '');
            $('#allergy').val(patientInfo.pAllergy || '');
            $('#disease').val(patientInfo.disease || '');
            $('#doctorAdvice').val(patientInfo.doctorAdvice || '');
        } else {
            console.error("URL 参数缺失或无法解析");
        }
    });

    $("#oksubmit").click(function() {
        console.log("执行了最终提交！")
        $.ajax({
            url:'/patient?action=addMedicine',
            type:'post',
            data:{
                "pId":pId,
                "pName":pName,
                "pSex":pSex,
                "pWeight":pWeight,
                "pAllergy":pAllergy,
                "disease":disease,
                "pAddress":pAddress,
                "doctorAdvice":doctorAdvice,
                "medicine": JSON.stringify(medicine)
            },
            success:function(data){
                console.log(data);
                parent.location.reload();
            }

        })
    })
});
