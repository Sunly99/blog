package blog.service;

import blog.pojo.po.ArticleCategory;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

/**
 * ArticleCategoryService
 *
 * @author sly
 */
public interface ArticleCategoryService {

    /**
     * 添加文章类型
     *
     * @param articleCategory ArticleCategory实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertArticleCategory(ArticleCategory articleCategory);

    /**
     * 删除文章类型
     *
     * @param id 文章类型Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteArticleCategory(Integer id);

    /**
     * 修改文章类型
     *
     * @param articleCategory ArticleCategory实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateArticleCategory(ArticleCategory articleCategory);

    /**
     * 查询文章类型
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @return ResponseVO<PageInfo<ArticleCategory>> 自定义分类查询返回类
     */
    ResponseVO<PageInfo<ArticleCategory>> selectArticleCategory(Integer pageNum, Integer pageSize);
}
