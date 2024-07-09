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
        url : '/appoint?action=getAllAppoint',
        cellMinWidth : 95,
        page : true,
        toolbar: '#purchaseDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'applyId', title: '申请编号',  align:'center'},
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
            {field: 'financeTime' ,title:'财务审批时间', align:'center'},
            {field: 'tableCoding' ,title:'自编码', align:'center'}
        ]],
        done:function (data){
        }
    });

    table.on('toolbar(purchaseList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var purchId = '';
        for(i=0;i<data.length;i++){
            purchId = data[i].applyId;//这里得和上面的field里的id名对应
        }
        var array = new Array();
        for (let i = 0;i<data.length;i++){
            array[i]=data[i].applyId
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
                audit(array);
                break;
            case 'noaudit':
                //反审核
                noaudit(array);
                break;
            case 'export':
                //导出
                break;
            case 'delOK':
                delOK();
                break;

        }

    });
    function noaudit(array){
        if (purchId.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        var dataString = $.param({"purchId": purchId});
        $.ajax({
            url:"/approval?action=noaudit",//根据id查询的方法
            type:"post",
            data:{dataString},
            success:function(data){
                if (data.status===200){
                    layer.msg("已撤销", { icon: 1 });
                    tableIns.reload()
                }else {
                    layer.msg("出错了", { icon: 2 });
                }
            }
        })
    }
    function delOK(){
        layer.confirm('是否清除所有已审核的记录？', {icon: 3}, function(){
            $.ajax({
                url:"/approval?action=delOK",//根据id查询的方法
                type:"post",
                data:{},
                success:function(data){
                    if (data.status===200){
                        layer.msg('已清除', {icon: 1});
                        tableIns.reload()
                    }else {
                        layer.msg("出错了", { icon: 2 });
                    }
                }
            })

            tableIns.reload()
        }, function(){
            layer.msg('未清除');
        });
    }
    function audit(array){
        if (array.length===0){
            layer.msg("请选择一条记录");
            return ;
        }
        var dataString = $.param({"array": array});
        layui.layer.open({
            title : "审批",
            type : 2,
            content : "medicine/approveManage/purchaseApproval/audit.jsp",
            area:['800px','500px'],
            success:function (layero, index){
                $.ajax({
                    url:"/approval?action=getAuditId",//根据id将状态改成“以审批”
                    type:"post",
                    data:{dataString},
                    success:function(data){
                        var info = JSON.parse(data).data;
                        console.log("审批")

                        var iframe = layer.getChildFrame('body', index);
                        var rowsHtml = '';
                        console.log(info)
                        $.each(info, function(i, item) {
                            console.log(item)
                            rowsHtml += '<tr>';
                            rowsHtml += '<td>' +  '</td>';
                            rowsHtml += '<td>' + item.applyId + '</td>';
                            rowsHtml += '<td>' + item.mName + '</td>';
                            rowsHtml += '<td>' + item.number + '</td>';
                            rowsHtml += '<td>' + item.applyNumber + '</td>';
                            rowsHtml += '</tr>';
                        });
                        // 更新iframe窗口中的表格body
                        $(iframe).find('#table-body').html(rowsHtml);

                    }
                })
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
                if (data.status===200){
                    layer.msg("删除成功", { icon: 1 });
                    tableIns.reload()
                }else {
                    layer.msg("删除失败", { icon: 2 });
                }
            }
        })
    }



});