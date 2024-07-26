layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree','element'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree;
    //表格渲染
    var tableIns = table.render({
        elem: '#purchaseList',
        url : '/orders?action=selectOrders',
        cellMinWidth : 95,
        page : true,
        toolbar: '#purchaseDemo',
        height : "full-25",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'oId', title: '采购单号',  align:'center',width:100,sort:true},
            {field: 'oName', title: '订单状态',  align:'center',width:100},
            // {field: 'specification', title: '规格', width:100, align:"center"},
            {field: 'manufactor', title:'生产企业' , width:250, align:"center"},
            // {field: 'unit', title:'单位' , width:100, align:"center"},
            // {field: 'oNum', title:'订单数量' , width:100, align:"center"},
            // {field: 'salePrice', title:'采购单价' , width:100, align:"center"},
            {field: 'shippingAddress', title:'发货地址' , width:300, align:"center"},
            {field: 'deliveryAddress', title:'收货地址' , width:300, align:"center"},
            {field: 'shippingTime', title:'发货时间' , width:150, align:"center"},
            {field: 'allPrice', title:'订单总价格' , width:100, align:"center"},
            {field: 'shippingWay', title:'发货方式' , width:150, align:"center"},
            {field: 'tempControlWay', title:'温控方式' , width:100, align:"center"},
            {field: 'deliveryTime', title:'到货时间' , width:100, align:"center"},
            {field: 'deliveryTemp', title:'到货温度' , width:100, align:"center"},
            {field: 'attachment', title:'关联附件' , width:100, align:"center"},
            {field: 'salesman', title:'供货单位业务员' , width:100, align:"center"},
            {field: 'buyer', title:'采购人' , width:100, align:"center"},
            {field: 'recipient', title:'收货人' , width:100, align:"center"},
            // {field: 'orderCondition', title:'收货状态' , width:100, align:"center"},
            // {field: 'statement', title:'收货状态' , width:100, align:"center"},

            {field: 'advance', title:'订单预付款' , width:150, align:"center"},
            {field: 'advanceStatus', title:'订单预付款状态' , width:200, align:"center"},
            {field: 'finals', title:'订单尾款' , width:150, align:"center"},
            {field: 'finalsStatus', title:'订单尾款状态' , width:200, align:"center"},
        ]],
        done:function (data){
        }
    });
    table.on('row(purchaseList)',function (obj){
        var data = obj.data; // 获得当前行数据
        var tr = obj.tr; // 获得当前行的 tr 元素
        var checkbox = tr.find('input[type="checkbox"]'); // 获取当前行的复选框

        // 检查是否是点击了复选框
        if (checkbox.is(':checked') || checkbox.is(':focus')) {
            // 如果复选框被勾选或获得焦点，不执行行点击的逻辑
            return;
        }
        openDetail(data);
        // 这里可以执行你的业务逻辑，比如打开一个模态框显示详情等
    });

    //打开详情页
    function openDetail(data){
        let oId = data.oId;
        layui.layer.open({
            title : "详情",
            type : 2,
            content : "medicine/approveManage/purchaseApproval/detailData.jsp",
            area:['700px','450px'],
            success:function (layero, index){
                var $iframes = layero.find('iframe')[0];
                $.ajax({
                    url:"/purchase?action=getId",//根据id查询的方法
                    type:"post",
                    data:{oId},
                    success:function(data){
                        $iframes.contentWindow.postMessage(data, '*');
                    }
                })
            }
        })
    }
    layui.use(function() {
        var laydate = layui.laydate;
        laydate.render({
            elem: '#ID-laydate-demo',
        });
    });

    table.on('toolbar(purchaseList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var purchId = '';
        for(i=0;i<data.length;i++){
            purchId = data[i].oId;//这里得和上面的field里的id名对应
        }
        var array = [];
        var state = [];
        for (let i = 0;i<data.length;i++){
            array[i]=data[i].oId;
            state[i]=data[i].oName;
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
                del(array);
                break;
            case 'audit':
                //审核
                audit(array,state);
                break;
            case 'noaudit':
                //反审核
                noaudit(array,state);
                break;
            case 'download':
                //导出
                download(array);
                break;
            case 'delOK':
                delOK();
                break;

        }

    });
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
            url:"/approval?action=noaudit",//根据id查询的方法
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
    function delOK(){
        layer.confirm('是否展示所有未审核的记录？', {icon: 3}, function(){
            tableIns.reload({
                url : '/approval?action=delOK',
                where: {
                },
                type:'static',
                page: false,
            });
            layer.msg('已经展示');
        }, function(){
            layer.msg('未展示');
        });
    }
    function audit(array,state){
        if (array.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        for (let i = 0; i < state.length; i++) {
            if (state[i] !== '未审阅'){
                layer.alert("单据"+array[i]+"已审阅,请取消！");
                return ;
            }
        }
        layer.confirm('是否通过？', {
            btn: ['确定', '取消'] //按钮
        }, function(){
            shengyue(array);
        }, function(){
            layer.msg('未审阅！请重新选择！', {
                time: 20000, // 20s 后自动关闭
                btn: [ '知道了']
            });
        });
        // //获取复选框选中的数据
        // var checkRows = table.checkStatus('purchaseList');
        // var oId = 10;
        // layui.layer.open({
        //     title : "审批",
        //     type : 2,
        //     content : "medicine/approveManage/purchaseApproval/audit.jsp",
        //     area:['900px','500px'],
        //     success:function (layero, index){
        //         var $iframes = layero.find('iframe')[0];
        //         $.ajax({
        //             url:"/purchase?action=getId",//根据id查询的方法
        //             type:"post",
        //             data:{oId},
        //             success:function(){
        //                 $iframes.contentWindow.postMessage(checkRows.data, '*');
        //             }
        //         })
        //     }
        // })

    }
    function shengyue(array){
        layer.alert('');
        var dataString = $.param({"purchId": array});
        console.log(dataString)
        $.ajax({
                        url:"/purchase?action=isOk",//根据id查询的方法
                        type:"post",
                        data:{dataString},
                        success:function(data){
                            let parse = JSON.parse(data);
                            if (parse.status===200){
                                layer.msg('审阅完成', {icon: 1});
                                location.reload()
                            }
                        }
                    })
    }

    function query(){
        var idValue = document.querySelector('input[name="id"]').value
        var nameValue = document.querySelector('input[name="zname"]').value
        var timeValue = document.querySelector('input[name="time"]').value

        var applyuser = document.getElementById('applyuser').value;
        var state = document.getElementById('state').value;
        var macuser = document.getElementById('macuser').value;
        var cw = document.getElementById('cw').value;
        var array = {"idValue":idValue,
            "nameValue":nameValue,
            "timeValue":timeValue,
            "applyuser":applyuser,
            "state":state,
            "macuser":macuser,
            "cw":cw
        };
        tableIns.reload({
            url : '/approval?action=search',
            where: array,
            type:'static',
            page: false,
            done:function (date){

            }
        });

    }
    function reset(){
        // document.querySelector('input[name="id"]').value='';
        window.location.reload()

    }
    function del(purchId){
        if (purchId.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        var dataString = $.param({"purchId": purchId});
        $.ajax({
            url:"/approval?action=del",//根据id查询的方法
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



});