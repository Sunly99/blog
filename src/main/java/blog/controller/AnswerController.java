package blog.controller;

import blog.pojo.po.Answer;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.home.answer.MessageAnswerVO;
import blog.service.AnswerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 回复
 *
 * @author sly
 */
@Slf4j
@Api(tags = "回复")
@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Resource
    private AnswerService answerService;

    @PostMapping("/add")
    public ResponseVO<?> insertAnswer(@RequestParam Integer messageId,
                                      @RequestParam String content){
        Answer answer = new Answer();
        answer.setMessageId(messageId);
        answer.setContent(content);
        answer.setUserId(1);
        answer.setStatus(true);
        System.out.println(answer.toString());
        return answerService.insertAnswer(answer);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteAnswer(@RequestParam("id") Integer id){
        return answerService.deleteAnswer(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateAnswer(@RequestBody Answer answer){
        return answerService.updateAnswer(answer);
    }

    @GetMapping("/query")
    public PageInfo<Answer> selectAnswer(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        return answerService.selectAnswer(pageNum, pageSize);
    }

    @GetMapping("/query/test")
    public List<MessageAnswerVO> selectAnswerTest(){
        return answerService.selectAnswer(false,null);
    }
}

