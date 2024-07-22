layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree','element','jquery'],function() {
    var table = layui.table;
    var $ = layui.jquery;
    layui.use(function() {
        var laydate = layui.laydate;
        // 日期范围 - 左右面板独立选择模式
        laydate.render({
            elem: '#ID-laydate-demo'
        });
    });


    var tableIns = table.render({
        // 全部
        elem: '#transferList',
        url : '/transfer?action=getAllTransfer',
        cellMinWidth : 95,
        page : true,
        toolbar: '#transferDemo',
        height : "500px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'id', title: '转账编号',  align:'center',width:100},
            {field: 'zName', title: '转账方',  align:'center',width:100},
            {field: 'name', title: '转账人',  align:'center',width:100},
            {field: 'cName', title: '财务人',  align:'center',width:100},
            {field: 'money', title: '应转金额',  align:'center',width:100},
            {field: 'realMoney', title: '实转金额',  align:'center',width:100},
            {field: 'supName', title: '转账账户',  align:'center',width:100},
            {field: 'time', title: '转账时间',  align:'center',width:100},
            {field: 'note', title: '备注',  align:'center',width:100}

        ]],
        done:function (data){
        }
    });
    //预付款
    table.on('toolbar(transferList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var id = '';
        for(i=0;i<data.length;i++){
            id = data[i].id;
        }
        // var array = [];
        // for (let i = 0;i<data.length;i++){
        //     array[i]=data[i].applyId;
        //     state[i]=data[i].pharmacistApprove
        // }
        switch(obj.event){
            case 'search':
                //搜索
                search();
                break;
            case 'del':
                // del(array);
                break;
            case 'refresh':
                refresh();
                break;
            default:
                break;
        }
    });
    function search(){
        var timeElement = document.getElementById('ID-laydate-demo').value;
        var idElement = document.getElementById('id').value;

        var nameElement = document.getElementById('name').value;
        var financeElement = document.getElementById('finance').value;
        var supplyElement = document.getElementById('supply').value;

        var data={timeElement,idElement,nameElement,financeElement,supplyElement};
        tableIns.reload({
            url:"/transfer?action=search_transfer",
            where: data,
            type:'static',
            page: false,
            done:function (data){

            }
        });
    }

})