layui.use(['element', 'jquery', 'layedit', 'flow'], function () {
    var element = layui.element;
    var form = layui.form;
    var $ = layui.jquery;
    var layedit = layui.layedit;
    var flow = layui.flow;
    //评论和留言的编辑器
    var editIndex = layedit.build('remarkEditor', {
        height: 150,
        tool: ['face', '|', 'link'],
    });
    //评论和留言的编辑器的验证
    form.verify({
        content: function (value) {
            value = $.trim(layedit.getContent(editIndex));
            if (value == "") return "请输入内容";
            layedit.sync(editIndex);
        },
        replyContent: function (value) {
            if (value == "") return "请输入内容";
        }
    });
    //回复按钮点击事件
    $('#message-list').on('click', '.btn-reply', function () {
         var targetId = $(this).data('targetid')
             , targetName = $(this).data('targetname')
             , $container = $(this).parent('p').parent().siblings('.replycontainer');
         if ($(this).text() == '回复') {
             $container.find('textarea').attr('placeholder', '回复【' + targetName + '】');
             $container.removeClass('layui-hide');
             $container.find('input[name="targetUserId"]').val(targetId);
             $(this).parents('.message-list li').find('.btn-reply').text('回复');
             $(this).text('收起');
         } else {
             $container.addClass('layui-hide');
             $container.find('input[name="targetUserId"]').val(0);
             $(this).text('回复');
         }
     });

    form.on('submit(formLeaveMessage)', function(data){
        let postData = {
            "articleId": data.field.articleid,
            "content" : data.field.editorContent,
            "type" : true
        }
        $.ajax({
            method: 'post',
            url: '/message/add',
            data: JSON.stringify(postData),
            contentType:'application/json',
            dataType:'JSON',
            success:function(res){
                if(res.code === 200.1){
                    layui.layer.msg("请先登录!", {icon: 5});
                    setTimeout(function () {
                        window.location.href = "/home/login";
                    },2000)
                }else {
                    if(res.code === 0){
                        layui.layer.msg(res.msg, {icon: 6});
                    } else {
                        layui.layer.msg(res.msg, {icon: 5});
                    }
                    setTimeout(function () {
                        window.location.reload();
                    },2000)
                }
            }
        })
        return false;
    });
    form.on('submit(formReply)', function(data){
        let postData = {
            "messageId" : data.field.remarkId,
            "targetUserId":data.field.targetUserId,
            "content" : data.field.replyContent,
        }
        $.ajax({
            method: 'post',
            url: '/answer/add',
            data: JSON.stringify(postData),
            contentType:'application/json',
            dataType:'JSON',
            success:function(res){
                if(res.code === 200.1){
                    layui.layer.msg("请先登录!", {icon: 5});
                    setTimeout(function () {
                        window.location.href = "/home/login";
                    },2000)
                }else {
                    if(res.code === 0){
                        layui.layer.msg(res.msg, {icon: 6});
                    } else {
                        layui.layer.msg(res.msg, {icon: 5});
                    }
                    setTimeout(function () {
                        window.location.reload();
                    },2000)
                }
            }
        })
        return false;
    });
});
