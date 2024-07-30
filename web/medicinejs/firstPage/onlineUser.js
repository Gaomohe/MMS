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


var bar = new ProgressBar.Circle(progressbar4, {
    color: '#ffb550',
    // This has to be the same size as the maximum width to
    // prevent clipping
    strokeWidth: 10,
    trailWidth: 2,
    trailColor: '#73bda4',
    easing: 'easeInOut',
    duration: 1400,
    text: {
        autoStyleContainer: false
    },
    from: { color: '#ffb550', width: 5 },
    to: { color: '#ffb550', width: 5 },
    // Set default step function for all animate calls
    step: function(state, circle) {
        circle.path.setAttribute('stroke', state.color);
        circle.path.setAttribute('stroke-width', state.width);

        var value = Math.round(circle.value() * 150);
        if (value === 0) {
            circle.setText('');
        } else {
            circle.setText(value);
        }

    }
});
bar.text.style.fontFamily = '"Raleway", Helvetica, sans-serif';
bar.text.style.fontSize = '2rem';

bar.animate(0.8);
