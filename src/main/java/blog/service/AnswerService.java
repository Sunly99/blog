package blog.service;

import blog.pojo.po.Answer;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * AnswerService
 *
 * @author sly
 */
public interface AnswerService {

    /**
     * 添加回复
     *
     * @param answer Answer实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertAnswer(Answer answer);

    /**
     * 删除回复
     *
     * @param id 回复Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteAnswer(Integer id);

    /**
     * 修改回复
     *
     * @param answer Answer实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateAnswer(Answer answer);

    /**
     * 查询回复
     *
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @return PageInfo<Answer> 自定义标准返回类
     */
    PageInfo<Answer> selectAnswer(Integer pageNum, Integer pageSize);


}
