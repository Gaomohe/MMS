layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form', 'layer', 'laydate', 'table', 'laytpl', 'dtree'], function() {
    console.log("Layui modules loaded");
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;

    // 获取 URL 参数的方法
    function getQueryParam(param) {
        console.log("=======================");
        let urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(param);
    }

    // 获取并解析 idsList 参数
    let idsListParam = getQueryParam('idsList');
    let idsList = idsListParam ? JSON.parse(decodeURIComponent(idsListParam)) : [];

    console.log("Received idsList:", idsList); // 输出接收到的 idsList 数组

    /*------------- 加载用户数据 --------------------------------*/
    var tableIns = table.render({
        elem: '#medicineList',
        url: '/appoint?action=selectAppoint&idsList=' + idsList.join(','),
        toolbar: '#medicineDemo',
        page: true,
        height: '500px',
        limit: 10,
        limits: [5, 10, 15, 20, 25],
        cols: [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'mId', title: '字典编号', align:'center'},
            {field: 'mName', title: '药品名称', minWidth:100, align:"center"},
            {field: 'specification', title: '规格', align:'center'},
            {field: 'manufactor', title: '生产企业', align:'center'},
            {field: 'unit', title: '单位', minWidth:100, align:"center"},
            {field: 'department', title: '部门', align:'center'},
            {field: 'applyNumber', title: '采购数量', align:'center'},
            {field: 'purchasePrice', title: '采购价', align:'center'},
            {field: 'code', title: '批号', align:'center'},
            {field: 'mType', title: '药品分类', align:'center'},
            {field: 'supplier', title: '供货单位', align:'center'},
            {field: 'approvalNumber', title: '准批文号', align:'center'},
            {field: 'placeOrigin', title: '产地', align:'center'},
            {field: 'applyUser', title:'申请人', align:'center'},
            {field: 'applyTime', title:'申请时间', align:'center'},
            {field: 'pharmacist', title:'药师审批人', align:'center'},
            {field: 'pharmacistApprove', title:'药师审批', align:'center'},
            {field: 'pharmacistTime', title:'药师审批时间', align:'center'},
            {field: 'finance', title:'财务审批人', align:'center'},
            {field: 'financeApprove', title:'财务审批', align:'center'},
            {field: 'financeTime', title:'财务审批时间', align:'center'}
        ]]
    });
    /*------------- 加载用户数据 --end------------------------------*/

    /*-------- 搜索用户 ----------------------------*/
    $("#doSubmit").click(function() {
        var like = $("#likename").val();
        tableIns.reload({
            url: "http://localhost:8723/EEDemo/Interfaces?action=allUser&uname=" + like,
            page: {
                curr: 1 //重新从第 1 页开始
            }
        });
    });

    table.on('toolbar(appointList)',function (obj) {
        var checkdata= table.checkStatus(obj.config.id)
        var files= checkdata.data;
        console.log(obj);
        switch (obj.event) {
            case 'delAppoint':
                if (files.length > 0) {
                    files.forEach(function(file) {
                        // 假设每个file对象都有一个id属性，用于标识用户
                        total++;
                        del(file.mId);
                    });
                } else {
                    layer.msg("you are not select", {icon: 2});
                }
                break;
            case 'submit':
                submit();
                break;
            case 'cancel':

                break;
        }
    });

    function submit(){
        $.ajax({
            url:'/appoint?action=Submit',
            type:'post',
            success:function (res){
                if (res.status==200){

                }
            }
        })
    }
});
