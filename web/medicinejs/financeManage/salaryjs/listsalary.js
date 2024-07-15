layui.extend({
    dtree: '{/}admin/js/lay-module/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
}).use(['form','layer','laydate','table','upload','dtree','element','jquery'],function() {
    var table = layui.table;
    var layer = parent.layer === undefined ? layui.layer : top.layer;
    var $ = layui.jquery;

    var tableIns = table.render({
        // 全部
        elem: '#salaryList',
        url : '/bill?action=getAll',
        cellMinWidth : 95,
        page : true,
        toolbar: '#salaryDemo',
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
    table.on('toolbar(salaryList)', function(obj){
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
            case 'basicInformation':
                //基本资料
                basicInformation(array);
                break;
            case 'salaryInformation':
                //工资信息
                salaryInformation();
                break;
            case 'attendanceInformation':
                //考勤信息
                attendanceInformation();
                break;
            case 'RewardPunishmentInformation':
                //奖惩信息
                RewardPunishmentInformation();
                break;
            case 'taxInformation':
                //税务信息
                taxInformation();
                break;
            case 'settingsManagement':
                //设置与管理
                settingsManagement();
                break;
            case 'complaintsAndHelp':
                //投诉与帮助
                complaintsAndHelp();
                break;
            default:
                break;
        }
    });
    function complaintsAndHelp(){

    }
    function settingsManagement(){

    }
    function taxInformation(){

    }
    function basicInformation(array){

    }
    function salaryInformation(){

    }
    function attendanceInformation(){

    }
    function RewardPunishmentInformation(){

    }

})