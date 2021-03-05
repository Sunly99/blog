package blog.service;

import blog.pojo.po.Message;
import blog.pojo.po.MessageView;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

/**
 * MessageService
 *
 * @author sly
 */
public interface MessageService {

    /**
     * 添加留言
     *
     * @param message Message实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertMessage(Message message);

    /**
     * 删除留言
     *
     * @param id 留言Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteMessage(Integer id);

    /**
     * 修改留言
     *
     * @param message Message实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateMessage(Message message);

    /**
     * 查询留言
     *
     * @return ResponseVO<PageInfo<MessageView>> 自定义标准返回类
     */
    ResponseVO<PageInfo<MessageView>> selectMessage();
}
