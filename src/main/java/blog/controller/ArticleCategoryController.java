package blog.controller;

import blog.pojo.po.ArticleCategory;
import blog.pojo.vo.article.ArticleCategoryQueryVO;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleCategoryService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        ResponseVO<ArticleCategoryQueryVO> responseVO = articleCategoryService.selectArticleCategory();
        Long pageTotal = page.getTotal();
        Integer pages = page.getPages();
        ArticleCategoryQueryVO articleCategoryQueryVO = responseVO.getData();
        articleCategoryQueryVO.setTotal(pageTotal);
        articleCategoryQueryVO.setMaxPage(pages);
        articleCategoryQueryVO.setLastPage(pageNum>1?pageNum-1:null);
        articleCategoryQueryVO.setNextPage(pageNum>=pages?null:pageNum+1);
        articleCategoryQueryVO.setPageNum(pageNum);
        articleCategoryQueryVO.setPageSize(pageSize);
        responseVO.setData(articleCategoryQueryVO);
        return responseVO;
    }
}
