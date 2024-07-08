layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree, layer = layui.layer, $ = layui.jquery;
    //表格渲染
    var tableIns = table.render({
        elem: '#purchaseList',
        url : '/purchase?action=getAllAppoint',
        cellMinWidth : 95,
        page : true,
        toolbar: '#purchaseDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'mId', title: '字典编号',  align:'center'},
            {field: 'mName', title: '药品名称', minWidth:100, align:"center"},
            {field: 'specification', title: '规格', align:'center'},
            {field: 'manufactor', title: '生产企业', align:'center'},
            {field: 'unit', title: '单位', minWidth:100, align:"center"},
            {field: 'department', title: '部门',  align:'center'},
            // {field: 'number', title: '采购数量',  align:'center'},
            {field: 'applyNumber', title: '采购数量',  align:'center'},
            {field: 'purchasePrice', title: '采购价',  align:'center'},
            {field: 'code', title: '批号',  align:'center'},
            {field: 'mType', title: '药品分类',  align:'center'},
            {field: 'supplier', title: '供货单位',  align:'center'},
            {field: 'approvalNumber', title: '准批文号',  align:'center'},
            {field: 'placeOrigin', title: '产地',  align:'center'},
            {field: 'applyUser' ,title:'申请人', align:'center'},
            {field: 'applyTime' ,title:'申请时间', align:'center'},
            {field: 'pharmacist' ,title:'药师审批人', align:'center'},
            {field: 'pharmacistApprove' ,title:'药师审批', align:'center'},
            {field: 'pharmacistTime' ,title:'药师审批时间', align:'center'},
            {field: 'finance' ,title:'财务审批人', align:'center'},
            {field: 'financeApprove' ,title:'财务审批', align:'center'},
            {field: 'financeTime' ,title:'财务审批时间', align:'center'}
        ]],
        done:function (){

        }
    });

    table.on('toolbar(purchaseList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var purchId = '';
        for(i=0;i<data.length;i++){
            purchId = data[i].sid;//这里得和上面的field里的id名对应
        }
        switch(obj.event){
            case 'time':
                laydate.render({
                    elem: '#ID-laydate-demo',
                });
                break;
            case 'query':
                //查询
                query();
                break;
            case 'reset':
                //重置
                reset();
                break;
            case 'del':
                //删除
                break;
            case 'audit':
                //审核
                break;
            case 'noaudit':
                //反审核
                break;
            case 'export':
                //导出
                break;

        }

    });
    function query(){
        var idValue = document.querySelector('input[name="id"]').value
        var nameValue = document.querySelector('input[name="zname"]').value
        var timeValue = document.querySelector('input[name="time"]').value

        var applyuser = document.getElementById('applyuser').value;
        var state = document.getElementById('state').value;
        var macuser = document.getElementById('macuser').value;
        var cw = document.getElementById('cw').value;
        tableIns.reload({
            url : '/approval?action=search',
            where: { // 新的查询参数
                idValue,nameValue,timeValue,applyuser,state,macuser,cw
            },
            type:'static',
            page: false
        });

    }
    function reset(){
        // document.querySelector('input[name="id"]').value='';
        window.location.reload()

    }



});