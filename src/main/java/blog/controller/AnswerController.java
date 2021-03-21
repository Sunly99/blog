package blog.controller;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.po.Answer;
import blog.pojo.po.Message;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.home.answer.MessageAnswerVO;
import blog.service.AnswerService;
import blog.service.MessageAnswerService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    public ResponseVO<?> insertAnswer(@RequestBody Answer answer, HttpSession session){
        Object userId = session.getAttribute("userId");
        if (null == userId){
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.LOGIN_USER_NOT_LOGIN, null);
        }else {
            answer.setUserId(Integer.parseInt(userId.toString()));
        }
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

}

