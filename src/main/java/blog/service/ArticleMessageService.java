package blog.service;

import blog.pojo.po.ArticleMessage;
import blog.pojo.po.ArticleMessageView;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

/**
 * ArticleMessageService
 *
 * @author sly
 */
public interface ArticleMessageService {

    /**
     * 添加评论
     *
     * @param articleMessage ArticleMessage实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertArticleMessage(ArticleMessage articleMessage);

    /**
     * 删除评论
     *
     * @param id 评论Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteArticleMessage(Integer id);

    /**
     * 修改评论
     *
     * @param articleMessage ArticleMessage实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateArticleMessage(ArticleMessage articleMessage);

    /**
     * 查询评论
     *
     * @return ResponseVO<PageInfo<ArticleMessage>> 自定义标准返回类
     */
    ResponseVO<PageInfo<ArticleMessageView>> selectArticleMessage();
}
