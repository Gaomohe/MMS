
layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree','element', 'jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        upload = layui.upload,
        table = layui.table;
    var dtree = layui.dtree;
    //表格渲染
    var tableIns = table.render({
        elem: '#shoppList',
        url : '/shopping?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#shoppDemo',
        height : "800px",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox",sort: true, width:50},
            {field: 'tableCoding', title: '药品编号',sort: true,  align:'center',hide:true},
            {field: 'mName', title: '药品名称',  align:'center',sort: true,width:100},
            {field: 'specification', title: '规格',  align:'center',sort: true},
            {field: 'number', title: '库存',  align:'center',sort: true},
            {field: 'purchasePrice', title: '价格',  align:'center',sort: true},
            {field: 'manufactor', title: '供应商',  align:'center',width:300},
            {field: 'drugFrom', title: '类别',  align:'center'},
            {field: 'goodsType', title: '种类',  align:'center'},
            {field: 'productDate', title: '生产日期',  align:'center',hide: true},
            {field: 'approvalNumber', title: '注册批号',  align:'center'},
            {field: 'documentNumber', title: '商品编号',  align:'center'},
            // {field: 'opera', title: '操作',  align:'center',templet:function (d){
            //         return '<a href="/shopping?action=select&mId=' + d.mId + '" class="layui-btn layui-btn-xs">详情</a>';
            //     }},

        ]],
        done:function (){

        }
    });
    // $(document).ready(function (){
    //     initDatepicker();
    // })

    var initDatepicker=function (){
        laydate.render({
            elem: '#ID-laydate-demo',
            trigger: 'click', // 鼠标点击触发
            done: function(value, date, endDate){
                tableIns.reload({
                    url : '/shopping?action=time',
                    where: {
                        value: value
                    },
                    type:'static',
                    page: false,
                    done:function (){
                        document.getElementById('ID-laydate-demo').value = value;
                        setTimeout(function(){
                            initDatepicker();
                        }, 300); // 延迟时间根据实际情况调整
                    }
                });
            }
        });
    }
    initDatepicker();
    form.on('select(onChangeSelect)',function (data){

        var drugFrom = data.value;
        tableIns.reload({
            url : '/shopping?action=getSelectedValue', // 保持URL不变，除非你需要改变数据源
            where: { // 新的查询参数
                drugFrom: drugFrom // 假设服务器端接受drugFrom参数来过滤数据
            },
            type:'static',
            page: false,
            done:function (){

            }
        });
    });
    form.on('select(onChangeSelect01)',function (data){
        var drugFrom = data.value;
        tableIns.reload({
            url : '/shopping?action=getSelectedSup', // 保持URL不变，除非你需要改变数据源
            where: { // 新的查询参数
                drugFrom: drugFrom // 假设服务器端接受drugFrom参数来过滤数据
            },
            type:'static',
            page: false,
            done:function (){

            }
        });
    });

    //工具栏事件
    table.on('toolbar(shoppList)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data = checkStatus.data;
        var id = '';
        for(i=0;i<data.length;i++){
            id = data[i].id;
        }
        switch(obj.event){
            case 'add':	//新增经手人
                if (data.length<1){
                    layer.msg("请选择一行数据进行操作")
                    return false;
                }
                var array = new Array();
                for (let i = 0;i<data.length;i++){
                    array[i]=data[i].tableCoding;
                }
                add(array);
                break;
            case 'submit':
                //搜索
                var searchValue = document.getElementById('searchInput').value;
                if (searchValue==null || searchValue===''){
                    // 空
                    return ;
                }
                tableIns.reload({
                    url : '/shopping?action=search',
                    where: { // 新的查询参数
                        searchValue: searchValue
                    },
                    type:'static',
                    page: false,
                    done:function (){
                        // 数据加载完成后，重新设置搜索框的值
                        document.getElementById('searchInput').value = searchValue;
                    }
                });

                break;
            case 'prescriptionDrug':
                //处方药
                tableIns.reload({
                    url : '/shopping?action=prescriptionDrug',
                    where: { // 新的查询参数
                    },
                    type:'static',
                    page: true,
                    height:800
                });
                break;
            case 'explain':
                layui.layer.open({
                    title : "申请说明",
                    type : 2,
                    content : "medicine/shoppingManage/requestApply/explain.jsp",
                    area:['600px','500px'],
                    success:function(layero, index){

                    }
                });
                break;
            case 'history':
                history();
                break;
            case 'msg':
                //右侧消息
                msg();
                break;
            default:
                break;
        }
    });
    function msg(){
        layer.open({
            type: 2,
            offset: 'r',
            anim: 'slideLeft', // 从右往左
            area: ['320px', '100%'],
            shade: 0.1,

            shadeClose: true,
            id: 'ID-demo-layer-direction-r',
            content : "http://localhost:8080/medicine/shoppingManage/requestApply/msgList.jsp"
        });
    }
    function add(array){
        var dataString = $.param({"array": array});
        layui.layer.open({
            title : "申请表",
            type : 2,
            content : "medicine/shoppingManage/requestApply/applyPro.jsp",
            area:['800px','500px'],
            success:function(layero, index){
                var $iframes = layero.find('iframe')[0];
                $.ajax({
                    url:"/shopping?action=selectById",//根据id查询的方法
                    type:"post",
                    data:{dataString},
                    success:function(data){
                        $iframes.contentWindow.postMessage(data, '*');

                    }
                })
            }
        });
    }
    function history(){
        layui.layer.open({
            title : "历史记录",
            type : 2,
            content : "medicine/shoppingManage/requestApply/history.jsp",
            area:['600px','500px'],
            success:function(layero, index){
                $.ajax({
                    url:"/approval?action=getHistory",//湖区历史记录
                    type:"post",
                    data:{},
                    success:function(data){
                        var parse = JSON.parse(data).data;
                        var iframe = layer.getChildFrame('body', index);
                        var html = '';
                        var insert = '';
                        var count = 0;
                            for (let j = 0; j < parse.length; j++) {
                                insert = '<p>药品编号:'+parse[j].mId+'药品名称:'+parse[j].mName+'申请数量:'+parse[j].applyNumber+'状态:'+parse[j].pharmacistApprove+'</p>';
                                for (let k = j+1; k < parse.length; k++) {
                                    if (parse[j].applyTime===parse[k].applyTime){
                                        insert += '<p>药品编号:'+parse[k].mId+'药品名称:'+parse[k].mName+'申请数量:'+parse[k].applyNumber+'状态:'+parse[k].pharmacistApprove+'</p>'
                                    }else {
                                        j = k - 1;
                                        html+= '<div class="layui-timeline-item">\n' +
                                            '    <i class="layui-icon layui-timeline-axis"></i>\n' +
                                            '    <div class="layui-timeline-content layui-text">\n' +
                                            '      <h3 class="layui-timeline-title">申请时间:'+parse[j].applyTime+'</h3>\n' +
                                            '      <p></p>\n' +insert+
                                            '    </div>\n' +
                                            '  </div>';
                                        count++;
                                        break;
                                    }
                                }
                                if (count===10){
                                    //控制条数
                                    break;
                                }
                            }
                        $(iframe).find('.layui-timeline').html(html);

                    }
                })
            }
        });
    }




})