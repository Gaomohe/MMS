// layui.extend({
//     dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
// }).use(['form','layer','laydate','table','upload','dtree','element'],function(){
//     var form = layui.form,
//         layer = parent.layer === undefined ? layui.layer : top.layer,
//         $ = layui.jquery,
//         laydate = layui.laydate,
//         upload = layui.upload,
//         table = layui.table;
//     var dtree = layui.dtree;
//
//         // 日期范围 - 左右面板独立选择模式
//       var times1 = laydate.render({
//             elem: '#ID-laydate-demo',
//             done:function (value, date, endDate){
//
//             }
//
//         });
//
//     var tableIns = table.render({
//         elem: '#financeList',
//         url : '/bill?action=getAll',
//         cellMinWidth : 95,
//         page : true,
//         toolbar: '#financeDemo',
//         height : "full-25",
//         limit : 20,
//         limits : [10,15,20,25],
//         cols : [[
//             {type: "checkbox", fixed:"left", width:50},
//             {field: 'sid', title: '供货商编号',  align:'center',width:100},
//             {field: 'sid', title: '供货商编号',  align:'center',width:100},
//
//         ]],
//         done:function (data){
//             times1;
//         }
//     });
//     $(document).ready(function (){
//         laydate.render({
//             elem: '#ID-laydate-demo',
//         });
//     })
// })