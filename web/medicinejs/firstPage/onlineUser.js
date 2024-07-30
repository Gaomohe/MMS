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

function renderMenu(i) {
    var html = '<tr>';
    html +='<td>'+'<a href="javascript:void(0)">'+i.name+'</a></td>'
    html +='<td>'+'<span class="text-muted"><i class="fa fa-clock-o"></i>'+i.time+'</span></td> '
    html +='<td>'+'<span style="border-radius: 0rem;font-weight: 500;line-height: 2;font-size: 85%;color: #ffffff;background-color: rgb(108,187,250);">'+i.role+'</span></td>'
    html +='<td>'+i.telNumber+'</td>'
    html +='</tr>'
    return html;
}

