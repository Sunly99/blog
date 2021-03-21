package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.AnswerMapper;
import blog.pojo.mapper.view.MessageViewMapper;
import blog.pojo.po.Answer;
import blog.pojo.po.example.AnswerExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.AnswerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * AnswerServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerMapper answerMapper;

    @Override
    public ResponseVO<?> insertAnswer(Answer answer) {
        int count;
        try{
            Date date = new Date();
            answer.setCreateTime(date);
            answer.setUpdateTime(date);
            answer.setStatus(true);
            count = answerMapper.insertSelective(answer);
        }catch (Exception e){
            log.error("AnswerServiceImpl:insertAnswer \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteAnswer(Integer id) {
        int count;
        try{
            count = answerMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("AnswerServiceImpl:deleteAnswer \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateAnswer(Answer answer) {
        int count;
        try{
            count = answerMapper.updateByPrimaryKeySelective(answer);
        }catch (Exception e){
            log.error("AnswerServiceImpl:updateAnswer \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public PageInfo<Answer> selectAnswer(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Answer> list = answerMapper.selectByExample(new AnswerExample());
        return new PageInfo<>(list);
    }
}
