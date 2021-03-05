package blog.pojo.vo.article;

import blog.pojo.po.ArticleCategory;
import blog.pojo.po.Diary;
import lombok.Data;

import java.util.List;

/**
 * ArticleCategoryQueryVO
 *
 * @author sly
 */
@Data
public class ArticleCategoryQueryVO {
    /** 记录总条数 */
    Long total;
    /** 文章类型列表 */
    List<ArticleCategory> articleCategoryList;
    /** 当前页数 */
    Integer pageNum;
    /** 页面最大容量 */
    Integer pageSize;
    /** 最大页数 */
    Integer maxPage;
    /** 上一页页码 */
    Integer lastPage;
    /** 下一页页码 */
    Integer nextPage;
}
