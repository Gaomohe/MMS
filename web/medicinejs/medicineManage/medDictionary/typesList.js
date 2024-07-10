layui.use(['layer', 'element', 'util', 'table', 'tableX'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var element = layui.element;
    var util = layui.util;
    var table = layui.table;
    var tableX = layui.tableX;


    //分类显示
    table.render({
        elem: '#getType1',
        url: '/type?action=getGoodsType',
        page: false,
        height:600,
        toolbar:"#btn1",
        cols: [[
            {fixed: "left",
                type: "checkbox",
                width: 50
            },
            {
                field: 'typename',
                title: '商品分类',
                minWidth: 150,
                align: 'center',
                sort: true
            },{
                title: '操作',
                width: 150,
                templet: '#type1bar',
            }
        ]]
    });
    table.render({
        elem: '#getType2',
        url: '/type?action=getMType',
        page: false,
        toolbar:"#btn2",
        height:600,
        cols: [[
            {fixed: "left",
                type: "checkbox",
                width: 50
            },
            {
                field: 'typename',
                title: '药品分类',
                minWidth: 150,
                align: 'left',
                sort: true
            },{
                title: '操作',
                width: 150,
                templet: '#type2bar',
            }
        ]]
    });
    table.render({
        elem: '#getType3',
        url: '/type?action=getfreeType',
        page: false,
        toolbar:"#btn3",
        height:600,
        cols: [[
            {fixed: "left",
                type: "checkbox",
                width: 50
            },
            {
                field: 'typename',
                title: '自定义分类',
                minWidth: 150,
                align: 'center',
                sort: true
            },{
                title: '操作',
                width: 150,
                templet: '#type3bar',
            }
        ]]
    });
    table.render({
        elem: '#getType4',
        url: '/type?action=getdosage',
        page: false,
        toolbar:"#btn4",
        height:600,
        cols: [[
            {fixed: "left",
                type: "checkbox",
                width: 50
            },
            {
                field: 'typename',
                title: '剂型',
                minWidth: 150,
                align: 'center',
                sort: true
            },
            {
                title: '操作',
                width: 150,
                templet: '#type4bar',
            }
        ]]
    });

    table.on('tool(getType1)', function(obj){
        var  data = obj.data;
        var layEvent = obj.event;
        var med = "delGoodsType";
        if(obj.event === 'del'){
            del(data.typename,med)
            location.reload();
        }
    });
    table.on('tool(getType2)', function(obj){
        var  data = obj.data;
        var layEvent = obj.event;
        var med = "delMType";
        if(obj.event === 'del'){
            del(data.typename,med)
            location.reload();
        }
    });
    table.on('tool(getType3)', function(obj){
        var  data = obj.data;
        var layEvent = obj.event;
        var med = "delfreeType";
        if(obj.event === 'del'){
            del(data.typename,med)
            location.reload();
        }
    });
    table.on('tool(getType4)', function(obj){
        var  data = obj.data;
        var layEvent = obj.event;
        var med = "deldosage";
        if(obj.event === 'del'){
            del(data.typename,med)
            location.reload();
        }
    });

    table.on('toolbar(getType1)', function(obj){
        if(obj.event === 'addFunc'){
            layui.layer.open({
                title : "添加权限",
                type : 2,
                content : "medicine/medicineManage/medDictionary/type1Add.jsp",
                area:['600px','500px'],
            })
        }
    });
    table.on('toolbar(getType2)', function(obj){
        if(obj.event === 'addFunc'){
            layui.layer.open({
                title : "添加权限",
                type : 2,
                content : "medicine/medicineManage/medDictionary/type2Add.jsp",
                area:['600px','500px'],
            })
        }
    });
    table.on('toolbar(getType3)', function(obj){
        if(obj.event === 'addFunc'){
            layui.layer.open({
                title : "添加权限",
                type : 2,
                content : "medicine/medicineManage/medDictionary/type3Add.jsp",
                area:['600px','500px'],
            })
        }
    });
    table.on('toolbar(getType4)', function(obj){
        if(obj.event === 'addFunc'){
            layui.layer.open({
                title : "添加权限",
                type : 2,
                content : "medicine/medicineManage/medDictionary/type4Add.jsp",
                area:['600px','500px'],
            })
        }
    });
    function del(data,med){
        $.ajax({
            url: '/type?action='+med, // 后端处理数据的URL
            type: "POST", // 或 'GET'，取决于后端接口的要求
            data: {
                type:data
            },
            dataType:"JSON",
            success: function(data) {
                layer.msg(data.msg);
            },
            error: function() {

            }
        })
    }



    /*// 排序自动传递sort和order
    var insTb3 = tableX.render({
        elem: '#xTable3',
        url: '../../../json/user.json',
        page: true,
        cellMinWidth: 100,
        cols: [[
            {type: 'numbers'},
            {field: 'nickName', title: '用户名', sort: true},
            {field: 'sex', title: '性别', sort: true},
            {field: 'phone', title: '手机号', sort: true},
            {field: 'roleId', templet: function (d) {
                    var str = '';
                    for (var i = 0; i < d.roles.length; i++) {
                        str += ('<span class="layui-badge-rim">' + d.roles[i].roleName + '</span>');
                        if (i != d.roles.length - 1) {
                            str += '<span class="layui-badge-rim layui-hide">,</span>';
                        }
                    }
                    return str;
                }, title: '角色', sort: true
            },
            {field: 'state', templet: '#tableState', title: '状态', sort: true},
            {field: 'createTime', templet: function (d) {
                    return util.toDateString(d.createTime);
                }, title: '创建时间', sort: true
            }
        ]],
        done: function () {
            // 绑定鼠标右键
            tableX.bindCtxMenu('xTable3', [{
                icon: 'layui-icon layui-icon-edit',
                name: '修改用户',
                click: function (d) {
                    layer.msg('点击了修改，userId：' + d.userId);
                }
            }, {
                icon: 'layui-icon layui-icon-unlink',
                name: '冻结用户',
                click: function (d) {
                    layer.msg('点击了冻结，userId：' + d.userId);
                }
            }, {
                icon: 'layui-icon layui-icon-close text-danger',
                name: '<span class="text-danger">删除用户</span>',
                click: function (d) {
                    layer.msg('点击了删除，userId：' + d.userId);
                }
            }]);
        }
    });*/

    // 导出数据包含templet
    $('#btnExport3').click(function () {
        tableX.exportData({
            cols: insTb3.config.cols,
            data: table.cache.xTable3,
            fileName: '用户表'
        });
    });

    // 切换Tab重置表格尺寸
    element.on('tab(tableXTab)', function (data) {
        var tableIds = ['xTable1', 'xTable2', 'xTable3'];
        table.resize(tableIds[data.index]);
    });

    setTimeout(function () {
        table.resize('xTable1');
    }, 200);

});