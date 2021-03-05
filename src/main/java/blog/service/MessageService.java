package blog.service;

import blog.pojo.po.Message;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.message.MessageQueryVO;

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
     * @return ResponseVO<MessageQueryVO> 自定义留言查询返回类
     */
    ResponseVO<MessageQueryVO> selectMessage();
}
