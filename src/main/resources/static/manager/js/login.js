function loginCheck() {
    let username = $("[name='username']").val();
    let password = $("[name='password']").val();
    $.ajax({
        method: 'post',
        url: '/login/check',
        data:{
            "username": username,
            "password": password
        },
        dataType:'JSON',
        success:function(res){
            lightyear.loading('show');
            if(res.code===0){
                setTimeout(function() {
                    lightyear.loading('hide');
                    lightyear.notify('登陆成功!即将返回!', 'success', 1500, 'mdi mdi-emoticon-happy', 'top', 'center');
                    history.go(-1);
                }, 1e3)
            }else {
                setTimeout(function() {
                    lightyear.loading('hide');
                    lightyear.notify(res.msg, 'danger', 1500, 'mdi mdi-emoticon-happy', 'top', 'center');
                }, 1e3)
            }
        }
    })
}