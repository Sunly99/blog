package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.AnswerMapper;
import blog.pojo.mapper.MessageMapper;
import blog.pojo.mapper.view.MessageAnswerViewMapper;
import blog.pojo.mapper.view.MessageViewMapper;
import blog.pojo.po.Answer;
import blog.pojo.po.Message;
import blog.pojo.po.example.AnswerExample;
import blog.pojo.po.example.MessageExample;
import blog.pojo.po.view.MessageAnswerView;
import blog.pojo.po.view.MessageView;
import blog.pojo.po.view.example.MessageAnswerViewExample;
import blog.pojo.po.view.example.MessageViewExample;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.home.answer.AnswerVO;
import blog.pojo.vo.home.answer.MessageAnswerVO;
import blog.service.AnswerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

    @Resource
    private MessageViewMapper messageViewMapper;

    @Resource
    private MessageAnswerViewMapper messageAnswerViewMapper;

    @Override
    public ResponseVO<?> insertAnswer(Answer answer) {
        int count;
        try{
            Date date = new Date();
            answer.setCreateTime(date);
            answer.setUpdateTime(date);
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

    @Override
    public List<MessageAnswerVO> selectAnswer(Boolean isArticleMessageType, Integer articleId) {
        List<MessageAnswerVO> messageAnswerVOList = new ArrayList<>();
        // 获取留言/评论列表
        MessageViewExample messageViewExample = new MessageViewExample();
        // 获取回复列表
        MessageAnswerViewExample messageAnswerViewExample = new MessageAnswerViewExample();
        // 判断是留言还是评论
        if(!isArticleMessageType){
            messageViewExample.createCriteria().andTypeEqualTo(false);
            messageAnswerViewExample.createCriteria().andMessageTypeEqualTo(false);
        }else if(articleId != null) {
            messageViewExample.createCriteria().andTypeEqualTo(true).andArticleIdEqualTo(articleId);
            messageAnswerViewExample.createCriteria().andMessageTypeEqualTo(true).andArticleIdEqualTo(articleId);
        }
        // 获取留言/评论列表
        List<MessageView> messageViewList =  messageViewMapper.selectByExample(messageViewExample);
        // 获取回复列表
        List<MessageAnswerView> messageAnswerViewList =messageAnswerViewMapper.selectByExample(messageAnswerViewExample);
        // 每一个留言/评论获取回复
        messageViewList.forEach(messageView->{
            MessageAnswerVO messageAnswerVO = new MessageAnswerVO();
            List<AnswerVO> answerVOList = new ArrayList<>();
            // 循环留言添加回复
            Iterator<MessageAnswerView> it = messageAnswerViewList.iterator();
            while(it.hasNext()){
                MessageAnswerView o = it.next();
                AnswerVO answerVO = new AnswerVO();
                answerVO.setUserId(o.getUserId());
                answerVO.setUserName(o.getNickName());
                answerVO.setUserAvatar(o.getUserAvatar());
                answerVO.setSendUserId(o.getSendUserId());
                answerVO.setSendUserName(o.getSendUserName());
                answerVO.setSendUserAvatar(o.getSendUserAvatar());
                answerVO.setContent(o.getContent());
                answerVO.setCreateTime(o.getCreateTime());
                answerVO.setUpdateTime(o.getUpdateTime());
                answerVOList.add(answerVO);
                it.remove();
            }
            messageAnswerVO.setMessage(messageView);
            messageAnswerVO.setAnswers(answerVOList);
            messageAnswerVOList.add(messageAnswerVO);
        });
        return messageAnswerVOList;
    }
}
