package blog.pojo.vo.message;

import blog.pojo.po.Message;
import blog.pojo.po.MessageView;
import lombok.Data;

import java.util.List;

/**
 * MessageQueryVO
 *
 * @author sly
 */
@Data
public class MessageQueryVO {
    /** 记录总条数 */
    Long total;
    /** 留言列表 */
    List<MessageView> messageList;
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
