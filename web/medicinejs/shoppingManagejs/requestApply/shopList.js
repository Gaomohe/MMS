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
        elem: '#shoppList',
        url : '/shopping?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#shoppDemo',
        height : "full-125",
        limit : 20,
        limits : [10,15,20,25],
        cols : [[
            {fixed:"left",type: "checkbox", width:50},
            {field: 'tableCoding', title: '药品编号',  align:'center'},
            {field: 'mName', title: '药品名称',  align:'center'},
            {field: 'specification', title: '规格',  align:'center'},
            {field: 'number', title: '库存',  align:'center'},
            {field: 'purchasePrice', title: '价格',  align:'center'},
            {field: 'manufactor', title: '供应商',  align:'center'},
            {field: 'drugFrom', title: '类别',  align:'center'},
            {field: 'productDate', title: '生产日期',  align:'center'},
            {field: 'opera', title: '操作',  align:'center',templet:function (d){
                    return '<a href="/shopping?action=select&mId=' + d.mId + '" class="layui-btn layui-btn-xs">详情</a>';
                }},

        ]],
    });

    form.on('select(onChangeSelect)',function (data){
        var drugFrom = data.value;
        tableIns.reload({
            url : '/shopping?action=getSelectedValue', // 保持URL不变，除非你需要改变数据源
            where: { // 新的查询参数
                drugFrom: drugFrom // 假设服务器端接受drugFrom参数来过滤数据
            },
            type:'static',
            page: false
        },'data',function (){
            document.querySelector('select[lay-filter="onChangeSelect"]').value = drugFrom;
            form.render('select');
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
            case 'time':	//修改经手人
                laydate.render({
                    elem: '#ID-laydate-demo',
                    done:function (value){
                        tableIns.reload({
                            url : '/shopping?action=time',
                            where: {
                                value: value
                            },
                            type:'static',
                            page: false
                        });
                    }
                });
                break;

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
                var searchValue = document.getElementById('searchInput').value;
                tableIns.reload({
                    url : '/shopping?action=search',
                    where: { // 新的查询参数
                        searchValue: searchValue
                    },
                    type:'static',
                    page: false
                });
                break;
        }
    });
    function add(array){
        var dataString = $.param({"array": array});
        layui.layer.open({
            title : "申请",
            type : 2,
            content : "medicine/shoppingManage/requestApply/applyList.jsp",
            area:['800px','500px'],
            success:function(layero, index){
                $.ajax({
                    url:"/shopping?action=selectById",//根据id查询的方法
                    type:"post",
                    data:{dataString},
                    success:function(data){
                        var info = JSON.parse(data).data;
                        var iframe = layer.getChildFrame('body', index);
                        var rowsHtml = '';
                        $.each(info, function(i, item) {
                            rowsHtml += '<tr>';
                            rowsHtml += '<td>' + item.tableCoding + '</td>';
                            rowsHtml += '<td>' + item.mName + '</td>';
                            rowsHtml += '<td>' + item.number + '</td>';
                            rowsHtml += '<td><input type="text" class="form-control" value="' + 0 + '"></td>';
                            rowsHtml += '</tr>';
                        });
                        // 更新iframe窗口中的表格body
                        $(iframe).find('#table-body').html(rowsHtml);
                    }
                })
            }
        });
    }




})