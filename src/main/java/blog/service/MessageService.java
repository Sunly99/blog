package blog.service;

import blog.pojo.po.Message;
import blog.pojo.po.view.MessageView;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

/**
 * MessageService
 *
 * @author sly
 */
public interface MessageService {

    /**
     * 添加留言/评论
     *
     * @param message Message实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertMessage(Message message);

    /**
     * 删除留言/评论
     *
     * @param id 留言/评论Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteMessage(Integer id);

    /**
     * 修改留言/评论
     *
     * @param message Message实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateMessage(Message message);

    /**
     * 查询留言/评论
     *
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @return PageInfo<MessageView> 自定义标准返回类
     */
    PageInfo<MessageView> selectMessage(Integer pageNum, Integer pageSize);

}
