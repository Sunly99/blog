package blog.controller;

import blog.pojo.po.Message;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.message.MessageQueryVO;
import blog.service.MessageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        ResponseVO<MessageQueryVO> responseVO = messageService.selectMessage();
        Long pageTotal = page.getTotal();
        Integer pages = page.getPages();
        MessageQueryVO messageQueryVO = responseVO.getData();
        messageQueryVO.setTotal(pageTotal);
        messageQueryVO.setMaxPage(pages);
        messageQueryVO.setLastPage(pageNum>1?pageNum-1:null);
        messageQueryVO.setNextPage(pageNum>=pages?null:pageNum+1);
        messageQueryVO.setPageNum(pageNum);
        messageQueryVO.setPageSize(pageSize);
        responseVO.setData(messageQueryVO);
        return responseVO;
    }
}
