package blog.pojo.vo.link;

import blog.pojo.po.Link;
import lombok.Data;

import java.util.List;

/**
 * LinkQueryVO
 *
 * @author sly
 */
@Data
public class LinkQueryVO {
    /** 记录总条数 */
    Long total;
    /** 友链列表 */
    List<Link> linkList;
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
