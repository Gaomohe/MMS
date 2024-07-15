layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree','element','jquery'],function() {
    var table = layui.table;
    var layer = parent.layer === undefined ? layui.layer : top.layer;
    var $ = layui.jquery;
    // 参数



    layui.use(['laydate'], function(){
        var laydate = layui.laydate;
        laydate.render({
            elem: '#show1_dateRange',
            range: ['#show1_laydate-start', '#show1_laydate-end'],
        });
        laydate.render({
            elem: '#show2_dateRange',
            range: ['#show2_laydate-start', '#show2_laydate-end'],

        });
        laydate.render({
            elem: '#show3_dateRange',
            range: ['#show3_laydate-start', '#show3_laydate-end'],

        });
        laydate.render({
            elem: '#show4_dateRange',
            range: ['#show4_laydate-start', '#show4_laydate-end'],

        });
        laydate.render({
            elem: '#show5_dateRange',
            range: ['#show5_laydate-start', '#show5_laydate-end'],

        });
    })


    var tableIns = table.render({
        // 全部
        elem: '#financeList',
        url : '/bill?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#financeDemo',
        height : "800px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},

        ]],
        done:function (data){
        }
    });
    var incometableIns = table.render({
        // 收入
        elem: '#incomeList',
        url : '/bill?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#incomeDemo',
        height : "800px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},

        ]],
        done:function (data){
        }
    });
    var advancetableIns = table.render({
        // 预付款
        elem: '#advanceList',
        url : '/bill?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#advanceDemo',
        height : "800px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},

        ]],
        done:function (data){
        }
    });
    var spendtableIns = table.render({
        // 支付
        elem: '#spendList',
        url : '/bill?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#spendDemo',
        height : "800px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},

        ]],
        done:function (data){
        }
    });
    var assettableIns = table.render({
// 固定资产
        elem: '#assetList',
        url : '/bill?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#assetDemo',
        height : "800px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},
            {field: 'sid', title: '供货商编号',  align:'center',width:100},

        ]],
        done:function (data){
        }
    });


    //工具栏事件----------------
    // 全部
    table.on('toolbar(financeList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var id = '';
        for(i=0;i<data.length;i++){
            id = data[i].id;
        }
        var array = [];
        for (let i = 0;i<data.length;i++){
            array[i]=data[i].applyId;
            state[i]=data[i].pharmacistApprove
        }
        switch(obj.event){
            case 'search':
                //搜索
                search();
                break;
            case 'del':
                del(array);
                break;
            case 'refresh':
                refresh();
                break;
            default:
                break;
        }
    });
    // 收入
    table.on('toolbar(incomeList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var id = '';
        for(i=0;i<data.length;i++){
            id = data[i].id;
        }
        var array = [];
        for (let i = 0;i<data.length;i++){
            array[i]=data[i].applyId;
            state[i]=data[i].pharmacistApprove
        }
        switch(obj.event){
            case 'search':
                //搜索
                search1();
                break;
            case 'del':
                del(array);
                break;
            case 'refresh':
                refresh();
                break;
            default:
                break;
        }
    });

    function refresh(){
        location.reload();
    }
    function search1(){
        var nameElement = document.getElementById('show2-name-name').value;
        var idElement = document.getElementById('show2-id').value;

        var supplyElement = document.getElementById('show2-supply').value;
        var operaElement = document.getElementById('show2-opera').value;
        var financeElement = document.getElementById('show2-finance').value;
        var startElement = document.getElementById('show2_laydate-start').value;
        var endElement = document.getElementById('show2_laydate-end').value;
        var accountElement = document.getElementById('show2-account').value;
        var stateElement = document.getElementById('show2-state').value;

        var data={nameElement,idElement,supplyElement,operaElement,financeElement,
            startElement,endElement,accountElement,stateElement};
        $.ajax({
            url:"/bill?action=search",
            type:"post",
            data:data,
            success:function(data){

            }
        })






    }
    function search(){
        var nameElement = document.getElementById('show1-name').value;
        var idElement = document.getElementById('show1-id').value;

        var supplyElement = document.getElementById('show1-supply').value;
        var operaElement = document.getElementById('show1-opera').value;
        var financeElement = document.getElementById('show1-finance').value;
        var startElement = document.getElementById('show1_laydate-start').value;
        var endElement = document.getElementById('show1_laydate-end').value;
        var accountElement = document.getElementById('show1-account').value;
        var stateElement = document.getElementById('show1-state').value;
        var kindElement = document.getElementById('show1-kind').value;

        var data={nameElement,idElement,supplyElement,operaElement,financeElement,
            startElement,endElement,accountElement,stateElement,kindElement};
        $.ajax({
            url:"/bill?action=search",
            type:"post",
            data:data,
            success:function(data){

            }
        })






    }
    function del(array){
        if (array.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        var dataString = $.param({"array": array});
        $.ajax({
            url:"/bill?action=del",//根据id查询的方法
            type:"post",
            data:{dataString},
            success:function(data){
                var parse = JSON.parse(data);
                if (parse.status===200){
                    layer.msg("删除成功", { icon: 1 });
                    tableIns.reload()
                }else {
                    layer.msg("删除失败", { icon: 2 });
                }
            }
        })

    }


})