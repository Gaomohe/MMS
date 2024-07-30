// 获取菜单数据并渲染
$.ajax({
    url: '/user?action=getOnlineUser',
    method: 'GET',
    dataType: 'json',
    success: function (data) {
        var info = data.data;
        var menuHtml = '';
        info.forEach(function (i){
            menuHtml += renderMenu(i)+'\n';
        })
        $('#onlineUsers').html(menuHtml);
    }
});

$.ajax({
    url: '/menu?action=getWarnForFirst',
    method: 'GET',
    dataType: 'json',
    success: function (data) {
        var info = data.data;
        var menuHtml = '';
        info.forEach(function (i){
            menuHtml += renderMenu1(i)+'\n';
        })
        $('#warnTable').html(menuHtml);
    }
});

$.ajax({
    url: '/menu?action=getOrderMsg',
    method: 'GET',
    dataType: 'json',
    success: function (data) {
        var info = data.data;
        var menuHtml = '';
        info.forEach(function (i){
            menuHtml += renderMenu2(i)+'\n';
        })
        $('#orderList').html(menuHtml);
    }
});

function renderMenu(i) {
    var html = '<tr>';
    html +='<td>'+'<a href="javascript:void(0)">'+i.name+'</a></td>'
    html +='<td>'+'<span class="text-muted"><i class="fa fa-clock-o"></i>'+i.time+'</span></td> '
    html +='<td>'+'<span style="border-radius: 0rem;font-weight: 500;line-height: 2;font-size: 85%;color: #ffffff;background-color: rgb(108,187,250);">'+i.role+'</span></td>'
    html +='<td>'+i.telNumber+'</td>'
    html +='</tr>'
    return html;
}

function renderMenu1(i) {
    var html = '<div class="box-shadowed p-10 mb-10 rounded10">\n' +
        '                                        <div class="d-flex justify-content-between align-items-center">';
    html +='<div>'+'<h5 class="my-5">预警数量|锁定</h5>'
    html +='<p class="mb-0">'+i.warnNumber+'|'+i.dicNumber+'</p>'
    html +='</div>'
    html +='<div>'+'<h5 class="my-5">'+i.mName+'</h5>'
    html +='<p class="mb-0">'+i.tolNumber+'</p>'
    html +='</div>'
    html +='</div>'
    html +='</div>'
    return html;
}

function renderMenu2(i) {
    var html = '<tr style="line-height: 2.5;font-weight: 400;text-align: center">';
    html +='<td style="width: 14%"><a href="javascript:void(0)">'+i.oId+'</a></td>'
    html +='<td style="width: 14%"><span class="text-muted text-nowrap">'+i.buyer+'</span> </td>'
    html +='<td style="width: 20%">'+i.shippingAddress+'</td>'
    html +='<td style="width: 14%"><span style="border-radius: 0rem;font-weight: 500;line-height: 2;font-size: 85%;color: #ffffff;background-color: rgb(253,84,249);">'+i.specification+'</span></td>'
    html +='<td style="width: 14%">￥'+i.allPrice+'</td>'
    if (i.deliveryTime==null){
        html +='<td style="margin-right: 50px;margin-left: 50px"><i class="fa fa-truck"></i></td>'
    }
    html +='<tr>'
    return html;
}


/*function getReturn(number){
    if (number==0){
        return 0;
    }
}*/


