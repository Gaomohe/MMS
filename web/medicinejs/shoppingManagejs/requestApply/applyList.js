var datas;
function tijiao(){
    var arrID = new Array();
    var arrKu = new Array();
    var count = 0;
    var firstTbody = $('tbody:first');
    firstTbody.find('tr').each(function() {
        var tr = this;

        // 获取第2个td
        var secondTd = $(tr).find('td').eq(1);
        // 获取第5个td
        var inputElement = $(tr).find('td').eq(4).find('input');
        arrID[count]=secondTd.text();
        arrKu[count]=inputElement.val();
        count++;
    });

    var arrID = $.param({"arrID": arrID});
    var arrKu = $.param({"arrKu": arrKu});
    $.ajax({
        url:"/shopping?action=add",
        data:{
            arrKu,arrID
        },
        type:"post",
        success:function(data){
            var info = JSON.parse(data);
            if(info.status === 200){
                console.log("ceshi")
                console.log(info)
                layer.msg("申请成功")

                // setTimeout(function(){
                //     layer.closeAll("iframe");
                //     //刷新父页面
                //     parent.location.reload();
                // },1000);
                insertApply();
            }else{
                layer.msg("系统异常");
            }
        }
    })
    return false;
}
function insertApply(){
    $.ajax({
        url:"/shopping?action=insertApply",
        type:"post",
        success:function (data){
            if(data.status === 200){
                console.log("成功");
            }

        }
    })
}
$(document).ready(function (){
    layui.use(['form', 'layedit', 'laydate','table'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit
            ,laydate = layui.laydate
            ,$ = layui.jquery
            ,table = layui.table;
        var insTb;
        window.addEventListener('message', function(event) {
            var messageData = event.data;
            let info = JSON.parse(messageData);
            datas = info;
            insTb = table.render({
                elem: '#tableTbBas',
                data: info.data,
                page: false,
                cellMinWidth: 100,
                cols: [[
                    {type: 'checkbox',hide:true},
                    {field: 'tableCoding', align: 'center', sort: true, title: '编号'},
                    {field: 'mName', align: 'center', title: '药品名称'},
                    {field: 'number', align: 'center', sort: true, title: '药品库存'},
                    {field: 'apply',
                        align: 'center',
                        title: '申请数量',
                        templet:function(d){
                            return '<div class="layui-input-inline" style="width: 100px;">\n' +
                                '        <input type="number" name="price_min" value="10" placeholder="" autocomplete="off" class="layui-input" min="0" max="100" step="1" lay-affix="number">\n' +
                                '      </div>';
                        }
                    },




                    {field: 'beiZhu',
                        align: 'center',
                        title: '备注',
                        templet:function(d){
                            return '<input type="text" name="" placeholder="备注" class="layui-input">';
                        }
                    },

                ]],
                done:function (){
                }
            });

        }, false);

        // $("#tijiao").click(function(){
        //     tijiao();
        // })



    })


})