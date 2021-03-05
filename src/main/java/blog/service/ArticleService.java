package blog.service;

import blog.pojo.po.Article;
import blog.pojo.po.ArticleView;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

/**
 * ArticleService
 *
 * @author sly
 */
public interface ArticleService {

    /**
     * 添加文章
     *
     * @param article Article实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertArticle(Article article);

    /**
     * 删除文章
     *
     * @param id 文章Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteArticle(Integer id);

    /**
     * 修改文章
     *
     * @param article Article实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateArticle(Article article);

    /**
     * 查询文章列表
     *
     * @return ResponseVO<PageInfo<Article>> 自定义标准返回类
     */
    ResponseVO<PageInfo<ArticleView>> selectArticle();

    /**
     * 查询文章内容
     *
     * @param id 文章编号
     * @return ResponseVO<PageInfo<Article>> 自定义标准返回类
     */
    ResponseVO<ArticleView> selectArticleById(Integer id);
}
