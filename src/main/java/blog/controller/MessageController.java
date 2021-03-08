package blog.controller;

import blog.pojo.po.Message;
import blog.pojo.vo.common.ResponseVO;
import blog.service.MessageService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 留言
 *
 * @author sly
 */
@Slf4j
@Api(tags = "留言")
@RestController
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @PostMapping("/add")
    public ResponseVO<?> inserMessage(@RequestBody Message user){
        return messageService.insertMessage(user);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteMessage(@RequestParam("id") Integer id){
        return messageService.deleteMessage(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateMessage(@RequestBody Message user){
        return messageService.updateMessage(user);
    }

    @GetMapping("/query")
    public ResponseVO<?> selectMessage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        return messageService.selectMessage(pageNum, pageSize);
    }
}
