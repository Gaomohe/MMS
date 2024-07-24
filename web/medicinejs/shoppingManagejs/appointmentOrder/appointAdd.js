layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form', 'layer', 'laydate', 'table', 'laytpl', 'dtree'], function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        laydate = layui.laydate,
        laytpl = layui.laytpl,
        table = layui.table;
    var dtree = layui.dtree;

    // 获取 URL 参数的方法
    function getQueryParam(param) {
        let urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(param);
    }

    // 获取并解析 idsList 参数
    let idsListParam = getQueryParam('idsList');
    let idsList = idsListParam ? JSON.parse(decodeURIComponent(idsListParam)) : [];
    console.log("Received idsList:", idsList); // 输出接收到的 idsList 数组

    var tableIns; // 定义为全局变量以便其他函数使用

    $(document).ready(function() {

        /*------------- 加载用户数据 --------------------------------*/
        tableIns = table.render({
            elem: '#medicineList',
            url: '/appoint?action=selectAppoint&idsList=' + idsList.join(','),
            toolbar: '#medicineDemo',
            page: true,
            height: '500px',
            limit: 10,
            limits: [5, 10, 15, 20, 25],
            cols: [[
                { fixed: "left", type: "checkbox", width: 50, hide: true, sort: true },
                { field: 'mId', title: '字典编号', align: 'center', hide: true, sort: true },
                { field: 'mName', title: '药品名称', minWidth: 100, align: "center", sort: true },
                { field: 'specification', title: '规格', align: 'center', sort: true },
                { field: 'manufactor', title: '生产企业', align: 'center', sort: true },
                { field: 'unit', title: '单位', minWidth: 100, align: "center", sort: true },
                { field: 'department', title: '部门', align: 'center', sort: true },
                { field: 'applyNumber', title: '采购数量', align: 'center', sort: true },
                { field: 'purchasePrice', title: '采购价', align: 'center', sort: true },
                { field: 'code', title: '批号', align: 'center', sort: true },
                { field: 'mType', title: '药品分类', align: 'center', sort: true },
                { field: 'supplier', title: '供货单位', align: 'center', sort: true },
                { field: 'approvalNumber', title: '准批文号', align: 'center', sort: true },
                { field: 'placeOrigin', title: '产地', align: 'center', sort: true },
                { field: 'applyUser', title: '申请人', align: 'center', sort: true },
                { field: 'applyTime', title: '申请时间', align: 'center', sort: true },
                { field: 'pharmacist', title: '药师审批人', align: 'center', sort: true },
                { field: 'pharmacistApprove', title: '药师审批', align: 'center', sort: true },
                { field: 'pharmacistTime', title: '药师审批时间', align: 'center', sort: true },
                { field: 'finance', title: '财务审批人', align: 'center' },
                { field: 'financeApprove', title: '财务审批', align: 'center' },
                { field: 'financeTime', title: '财务审批时间', align: 'center' }
            ]]
        });

        /*------------- 加载用户数据 --end------------------------------*/

        // 工具栏事件处理
        table.on('toolbar(medicineList)', function(obj) {
            console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            var checkdata = table.checkStatus(obj.config.id);
            var files = checkdata.data;

            switch (obj.event) {
                case 'delAppoint':
                    if (files.length > 0) {
                        files.forEach(function(file) {
                            del(file.mId);
                        });
                    } else {
                        layer.msg("你未选择任何数据", { icon: 2 });
                    }
                    break;
                case 'submit':
                    console.log("pppppppppppppppppppppppppppppppppppppp");
                    submit();
                    break;
                case 'cancel':
                    // 取消逻辑
                    break;
                default:
                    console.log("未处理的事件: " + obj.event);
                    break;
            }
        });
    });

    // 搜索功能
    $("#doSubmit").click(function() {
        var like = $("#likename").val();
        tableIns.reload({
            url: "/appoint?action=selectAppoint&search=" + encodeURIComponent(like),
            page: {
                curr: 1 // 重新从第 1 页开始
            }
        });
    });

    // 提交函数
    function submit() {
        var ids=1;
        $.ajax({
            url: '/appoint?action=Submit',
            data: { "ids": ids },
            type: "post",
            dataType: "json",
            traditional: true,
            success: function(res) {
                if (res.status == 200) {
                    layer.msg("提交成功", { icon: 1 });
                    // 关闭父页面
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.close(index);
                } else {
                    layer.msg("提交失败", { icon: 2 });
                }
            },
            error: function() {
                layer.msg("提交出错", { icon: 2 });
            }
        });
    }

    // 删除函数
    function del(mId) {
        $.ajax({
            url: '/appoint?action=delAppoint',
            type: 'post',
            data: { "mId": mId },
            success: function(res) {
                if (res.status == 200) {
                    layer.msg("删除成功", { icon: 1 });
                    tableIns.reload();
                } else {
                    layer.msg("删除失败", { icon: 2 });
                }
            },
            error: function() {
                layer.msg("删除出错", { icon: 2 });
            }
        });
    }
});
