package blog.controller;

import blog.pojo.po.Article;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章
 *
 * @author sly
 */
@Slf4j
@Api(tags = "文章")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("/add")
    public ResponseVO<?> insertArticle(@RequestBody Article article){
        return articleService.insertArticle(article);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteArticle(@RequestParam("id") Integer id){
        return articleService.deleteArticle(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateArticle(@RequestBody Article article){
        return articleService.updateArticle(article);
    }

    @GetMapping("/query")
    public ResponseVO<?> selectArticle(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                       @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return articleService.selectArticle();
    }

    @GetMapping("/query/{id}")
    public ResponseVO<?> selectArticle(@PathVariable Integer id){
        return articleService.selectArticleById(id);
    }
}
