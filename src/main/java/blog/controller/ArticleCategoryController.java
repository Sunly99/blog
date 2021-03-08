package blog.controller;

import blog.pojo.po.ArticleCategory;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleCategoryService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章-类型
 *
 * @author sly
 */
@Slf4j
@Api(tags = "文章-类型")
@RestController
@RequestMapping("/article/category")
public class ArticleCategoryController {
    @Resource
    private ArticleCategoryService articleCategoryService;

    @PostMapping("/add")
    public ResponseVO<?> insertArticleCategory(@RequestBody ArticleCategory articleCategory){
        return articleCategoryService.insertArticleCategory(articleCategory);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteArticleCategory(@RequestParam("id") Integer id){
        return articleCategoryService.deleteArticleCategory(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateArticleCategory(@RequestBody ArticleCategory articleCategory){
        return articleCategoryService.updateArticleCategory(articleCategory);
    }

    @GetMapping("/query")
    public ResponseVO<?> selectArticleCategory(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        return articleCategoryService.selectArticleCategory(pageNum, pageSize);
    }
}
