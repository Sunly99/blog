package blog.service;

import blog.pojo.vo.home.answer.MessageAnswerVO;

import java.util.List;

/**
 * MessageAnswerService
 *
 * @author sly
 */
public interface MessageAnswerService {

    /**
     * 查询留言
     *
     * @return List<MessageAnswerVO> 自定义标准返回类
     */
    List<MessageAnswerVO> selectMessageAnswerList();

    /**
     * 查询评论
     *
     * @param id 文章Id
     * @return List<MessageAnswerVO> 自定义标准返回类
     */
    List<MessageAnswerVO> selectMessageAnswerList(Integer id);
}
