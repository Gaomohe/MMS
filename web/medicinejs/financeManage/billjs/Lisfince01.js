layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree','element','jquery'],function() {
    var table = layui.table;
    var form = layui.form;
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
        url : '/bill?action=getAllIncome',
        cellMinWidth : 95,
        page : true,
        toolbar: '#incomeDemo',
        height : "500px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'orderId', title: '批次',  align:'center',width:100},
            {field: 'mname', title: '商品名称',  align:'center',width:100},
            {field: 'specification', title: '规格',  align:'center',width:100},
            {field: 'kind', title: '种类',  align:'center',width:100},
            {field: 'drugFrom', title: '分类',  align:'center',width:100},
            {field: 'supplier', title: '供货商',  align:'center',width:100},
            {field: 'unit', title: '类型',  align:'center',width:100},
            {field: 'productDate', title: '生产时间',  align:'center',width:100},
            {field: 'salePrice', title: '出售价格',  align:'center',width:100},
            {field: 'number', title: '出售数量',  align:'center',width:100},
            {field: 'opera', title: '操作人员',  align:'center',width:100},
            {field: 'finence', title: '财务人员',  align:'center',width:100},
            {field: 'state', title: '状态',  align:'center',width:100},
            {field: 'times', title: '单据时间',  align:'center',width:100},
            {field: 'account', title: '账户',  align:'center',width:100}

        ]],
        done:function (data){
        }
    });
    var advancetableIns = table.render({
        // 预付款
        elem: '#advanceList',
        url : '/bill?action=getAllAdvance',
        cellMinWidth : 95,
        page : true,
        toolbar: '#advanceDemo',
        height : "500px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'orderId', title: '批次',  align:'center',width:100},
            {field: 'mname', title: '商品名称',  align:'center',width:100},
            {field: 'specification', title: '规格',  align:'center',width:100},
            {field: 'kind', title: '种类',  align:'center',width:100},
            {field: 'drugFrom', title: '分类',  align:'center',width:100},
            {field: 'supplier', title: '供货商',  align:'center',width:100},
            {field: 'unit', title: '类型',  align:'center',width:100},
            {field: 'productDate', title: '生产时间',  align:'center',width:100},
            {field: 'buyPrice', title: '购买价格',  align:'center',width:100},
            {field: 'number', title: '购买数量',  align:'center',width:100},
            {field: 'percent', title: '预付款比例',  align:'center',width:100},
            {field: 'money', title: '预付款金额',  align:'center',width:100},
            {field: 'opera', title: '操作人员',  align:'center',width:100},
            {field: 'finence', title: '财务人员',  align:'center',width:100},
            {field: 'state', title: '状态',  align:'center',width:100},
            {field: 'times', title: '单据时间',  align:'center',width:100},
            {field: 'account', title: '账户',  align:'center',width:100}
        ]],
        done:function (data){
        }
    });
    var spendtableIns = table.render({
        // 支付
        elem: '#spendList',
        url : '/bill?action=getAllSpend',
        cellMinWidth : 95,
        page : true,
        toolbar: '#spendDemo',
        height : "500px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'orderId', title: '批次',  align:'center',width:100},
            {field: 'mname', title: '商品名称',  align:'center',width:100},
            {field: 'specification', title: '规格',  align:'center',width:100},
            {field: 'kind', title: '种类',  align:'center',width:100},
            {field: 'drugFrom', title: '分类',  align:'center',width:100},
            {field: 'supplier', title: '供货商',  align:'center',width:100},
            {field: 'unit', title: '类型',  align:'center',width:100},
            {field: 'productDate', title: '生产时间',  align:'center',width:100},
            {field: 'buyPrice', title: '购买价格',  align:'center',width:100},
            {field: 'number', title: '购买数量',  align:'center',width:100},
            {field: 'opera', title: '操作人员',  align:'center',width:100},
            {field: 'finence', title: '财务人员',  align:'center',width:100},
            {field: 'state', title: '状态',  align:'center',width:100},
            {field: 'times', title: '单据时间',  align:'center',width:100},
            {field: 'account', title: '账户',  align:'center',width:100}
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
    //-----------初始化----------------
    $.ajax({
        url:"/bill?action=Init",
        type:"post",
        data:{},
        success:function(data){

        }
    })


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
        var state = [];
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
            case 'audit':
                //审核
                audit(array,state);
                break;
            case 'noaudit':
                noaudit(array,state);
                break;
            case 'export':
                //导出
                download(array);
                break;
            case 'add':
                //新增单据
                // add();
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



    //支出
    table.on('toolbar(spendList)', function(obj){
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
                console.log("搜索")
                search2();
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

    //预付款
    table.on('toolbar(advanceList)', function(obj){
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
                search3();
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


    function add(){
        layui.layer.open({
            title : "收入单",
            type : 2,
            content : "medicine/financeManage/bill/addFinance02.jsp",
            area:['540px','450px'],
            offset:'50px',
            success:function (layero, index){

            }
        })
    }
    function download(purchId){
        if (purchId.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        layer.confirm('是否需要导出', {icon: 3}, function(){
            layer.msg('ok', {icon: 1});
        }, function(){
            layer.msg('未导出');
        });
        var checkRows = table.checkStatus('purchaseList');
        console.log(checkRows);
        if (checkRows.data.length === 0) {
            layer.msg('请选择要导出的数据', {icon: 2});
        } else {
            table.exportFile(tableIns.config.id,checkRows.data, 'selected_data.xls');
        }

    }
    function noaudit(array,state){
        if (array.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        for (let i = 0; i < state.length; i++) {
            if (state[i]==="未审阅"){
                layer.alert("单据"+array[i]+"未审阅！不允许撤销！");
                return ;
            }
        }
        var dataString = $.param({"purchId": array});
        $.ajax({
            url:"/bill?action=noaudit",//根据id查询的方法
            type:"post",
            data:{dataString},
            success:function(data){
                var parse = JSON.parse(data);
                if (parse.status===200){
                    layer.msg("已撤销", { icon: 1 });
                    tableIns.reload()
                }else {
                    layer.msg("出错了", { icon: 2 });
                }
            }
        })
    }
    function audit(array,state){
        if (array.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        for (let i = 0; i < state.length; i++) {
            if (state[i]==="已审阅通过" || state[i]==="已审阅未通过"){
                layer.alert("单据"+array[i]+"已审阅,请取消！");
                return ;
            }
        }

        $.ajax({
            url:"/bill?action=getAuditId",//根据id将状态改成“以审批”
            type:"post",
            data:{dataString},
            success:function (data){
            }

        })

    }

    function refresh(){
        location.reload();
    }
    function search3(){
        var nameElement = document.getElementById('show4-name').value;
        var idElement = document.getElementById('show4-id').value;

        var supplyElement = document.getElementById('show4-supply').value;
        // var operaElement = document.getElementById('show2-opera').value;
        // var financeElement = document.getElementById('show2-finance').value;
        var startElement = document.getElementById('show3_laydate-start').value;
        // var endElement = document.getElementById('show3_laydate-end').value;
        // var accountElement = document.getElementById('show2-account').value;
        // var stateElement = document.getElementById('show2-state').value;

        var data={nameElement,idElement,supplyElement,
            startElement};
        advancetableIns.reload({
            url:"/bill?action=search03",
            where: data,
            type:'static',
            page: false,
            done:function (data){

            }
        });






    }
    function search2(){
        var nameElement = document.getElementById('show3-name').value;
        var idElement = document.getElementById('show3-id').value;

        var supplyElement = document.getElementById('show3-supply').value;
        // var operaElement = document.getElementById('show2-opera').value;
        // var financeElement = document.getElementById('show2-finance').value;
        var startElement = document.getElementById('show3_laydate-start').value;
        var endElement = document.getElementById('show3_laydate-end').value;
        // var accountElement = document.getElementById('show2-account').value;
        // var stateElement = document.getElementById('show2-state').value;

        var data={nameElement,idElement,supplyElement,
            startElement,endElement};
        spendtableIns.reload({
            url:"/bill?action=search02",
            where: data,
            type:'static',
            page: false,
            done:function (data){

            }
        });






    }
    function search1(){
        var nameElement = document.getElementById('show2-name').value;
        var idElement = document.getElementById('show2-id').value;

        var supplyElement = document.getElementById('show2-supply').value;
        // var operaElement = document.getElementById('show2-opera').value;
        // var financeElement = document.getElementById('show2-finance').value;
        var startElement = document.getElementById('show2_laydate-start').value;
        var endElement = document.getElementById('show2_laydate-end').value;
        // var accountElement = document.getElementById('show2-account').value;
        // var stateElement = document.getElementById('show2-state').value;

        var data={nameElement,idElement,supplyElement,
            startElement,endElement};
        incometableIns.reload({
            url:"/bill?action=search01",
            where: data,
            type:'static',
            page: false,
            done:function (data){

            }
        });






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