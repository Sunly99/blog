package blog.service;

import blog.pojo.po.Article;
import blog.pojo.po.view.ArticleView;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @param orderBy 分页排序
     * @return ResponseVO<PageInfo<Article>> 自定义标准返回类
     */
    PageInfo<ArticleView> selectArticle(Integer pageNum, Integer pageSize, String orderBy);

    /**
     * 查询文章内容
     *
     * @param id 文章编号
     * @return ResponseVO<PageInfo<Article>> 自定义标准返回类
     */
    ArticleView selectArticleById(Integer id);

    /**
     * 查询热门文章列表
     *
     * @param limit 展示条数
     * @return List<Article> 文章列表
     */
    List<Article> selectHotArticle(Integer limit);

    /**
     * 查询置顶文章列表
     *
     * @param limit 展示条数
     * @return List<Article> 文章列表
     */
    List<Article> selectTopArticle(Integer limit);

    /**
     * 查询文章列表
     *
     * @return List<Article> 文章列表
     */
    List<ArticleView> selectArticle();

    /**
     * 根据文章类别查询文章列表
     *
     * @param id 文章类别id
     * @return List<Article> 文章列表
     */
    List<ArticleView> selectArticle(Integer id);
}
