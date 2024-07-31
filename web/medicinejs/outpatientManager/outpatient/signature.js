$(document).ready(function() {
    let params = getQueryParams();
    console.log("接收到的参数:", params);

    // 获取 priceList、medicines 和 patientInfo 数据
    let priceListJson = params.priceList;
    let medicinesJson = params.medicines;
    let patientInfoJson = params.patientInfo;

    let priceList = JSON.parse(decodeURIComponent(priceListJson));
    let medicines = JSON.parse(decodeURIComponent(medicinesJson));
    let patientInfo = JSON.parse(decodeURIComponent(patientInfoJson));

    console.log("价格列表数据:", priceList);
    console.log("药品详细信息:", medicines);
    console.log("患者信息:", patientInfo);

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
    $('#doctorAdvice').val(patientInfo.doctorAdvice || '');
});
