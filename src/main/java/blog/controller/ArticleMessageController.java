package blog.controller;

import blog.pojo.po.ArticleMessage;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleMessageService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章-评论
 *
 * @author sly
 */
@Slf4j
@Api(tags = "文章-评论")
@RestController
@RequestMapping("/article/message")
public class ArticleMessageController {
    @Resource
    private ArticleMessageService articleMessageService;

    @PostMapping("/add")
    public ResponseVO<?> insertArticleMessage(@RequestBody ArticleMessage articleMessage){
        return articleMessageService.insertArticleMessage(articleMessage);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteArticleMessage(@RequestParam("id") Integer id){
        return articleMessageService.deleteArticleMessage(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateArticleMessage(@RequestBody ArticleMessage articleMessage){
        return articleMessageService.updateArticleMessage(articleMessage);
    }

    @GetMapping("/query")
    public ResponseVO<?> selectArticleMessage(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        return articleMessageService.selectArticleMessage(pageNum, pageSize);
    }
}
