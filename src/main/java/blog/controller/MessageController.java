package blog.controller;

import blog.pojo.po.Message;
import blog.pojo.po.view.MessageView;
import blog.pojo.vo.common.ResponseVO;
import blog.service.MessageService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 留言/评论
 *
 * @author sly
 */
@Slf4j
@Api(tags = "留言/评论")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @PostMapping("/add")
    public ResponseVO<?> insertMessage(@RequestBody Message message){
        return messageService.insertMessage(message);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteMessage(@RequestParam("id") Integer id){
        return messageService.deleteMessage(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateMessage(@RequestBody Message message){
        return messageService.updateMessage(message);
    }

    @GetMapping("/query")
    public PageInfo<MessageView> selectMessage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        return messageService.selectMessage(pageNum, pageSize);
    }
}
