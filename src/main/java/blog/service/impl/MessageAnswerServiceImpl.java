package blog.service.impl;

import blog.pojo.mapper.view.AnswerViewMapper;
import blog.pojo.mapper.view.MessageViewMapper;
import blog.pojo.po.view.AnswerView;
import blog.pojo.po.view.MessageView;
import blog.pojo.po.view.example.AnswerViewExample;
import blog.pojo.po.view.example.MessageViewExample;
import blog.pojo.vo.home.answer.MessageAnswerVO;
import blog.service.MessageAnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * MessageAnswerServiceImpl
 *
 * @author sly
 */
@Service
public class MessageAnswerServiceImpl implements MessageAnswerService {
    @Resource
    private MessageViewMapper messageViewMapper;

    @Resource
    private AnswerViewMapper answerViewMapper;

    @Override
    public List<MessageAnswerVO> selectMessageAnswerList() {
        List<MessageAnswerVO> messageAnswerVOList = new ArrayList<>();

        MessageViewExample messageViewExample = new MessageViewExample();
        messageViewExample.createCriteria()
                .andTypeEqualTo(false)
                .andStatusEqualTo(true);
        messageViewExample.setOrderByClause("create_time");
        List<MessageView> messageViews = messageViewMapper.selectByExample(messageViewExample);
        for(MessageView messageView:messageViews){
            MessageAnswerVO messageAnswerVO = new MessageAnswerVO();

            AnswerViewExample answerViewExample = new AnswerViewExample();
            answerViewExample.createCriteria()
                    .andMessageIdEqualTo(messageView.getId())
                    .andStatusEqualTo(true);
            answerViewExample.setOrderByClause("create_time");
            List<AnswerView> answerViews = answerViewMapper.selectByExample(answerViewExample);

            messageAnswerVO.setMessage(messageView);
            messageAnswerVO.setAnswers(answerViews);
            messageAnswerVOList.add(messageAnswerVO);
        }

        return messageAnswerVOList;
    }

    @Override
    public List<MessageAnswerVO> selectMessageAnswerList(Integer id) {
        List<MessageAnswerVO> messageAnswerVOList = new ArrayList<>();

        MessageViewExample messageViewExample = new MessageViewExample();
        messageViewExample.createCriteria()
                .andArticleIdEqualTo(id)
                .andTypeEqualTo(true)
                .andStatusEqualTo(true);
        messageViewExample.setOrderByClause("create_time");
        List<MessageView> messageViews = messageViewMapper.selectByExample(messageViewExample);
        for(MessageView messageView:messageViews){
            MessageAnswerVO messageAnswerVO = new MessageAnswerVO();

            AnswerViewExample answerViewExample = new AnswerViewExample();
            answerViewExample.createCriteria()
                    .andMessageIdEqualTo(messageView.getId())
                    .andStatusEqualTo(true);
            answerViewExample.setOrderByClause("create_time");
            List<AnswerView> answerViews = answerViewMapper.selectByExample(answerViewExample);

            messageAnswerVO.setMessage(messageView);
            messageAnswerVO.setAnswers(answerViews);
            messageAnswerVOList.add(messageAnswerVO);
        }

        return messageAnswerVOList;
    }
}
