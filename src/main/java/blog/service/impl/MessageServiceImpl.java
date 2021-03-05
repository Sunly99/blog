package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.MessageMapper;
import blog.pojo.mapper.view.MessageViewMapper;
import blog.pojo.po.Example.MessageViewExample;
import blog.pojo.po.Message;
import blog.pojo.po.MessageView;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.message.MessageQueryVO;
import blog.service.MessageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * MessageServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;
    @Resource
    private MessageViewMapper messageViewMapper;

    @Override
    public ResponseVO<?> insertMessage(Message message) {
        int count;
        try{
            Date date = new Date();
            message.setCreateTime(date);
            message.setUpdateTime(date);
            count = messageMapper.insertSelective(message);
        }catch (Exception e){
            log.error("MessageServiceImpl:insertMessage \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteMessage(Integer id) {
        int count;
        try{
            count = messageMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("MessageServiceImpl:deleteMessage \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateMessage(Message message) {
        int count;
        try{
            count = messageMapper.updateByPrimaryKeySelective(message);
        }catch (Exception e){
            log.error("MessageServiceImpl:updateMessage \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<MessageQueryVO> selectMessage() {
        List<MessageView> list = messageViewMapper.selectByExample(new MessageViewExample());
        // 自定义返回类赋值
        MessageQueryVO messageQueryVO = new MessageQueryVO();
        messageQueryVO.setMessageList(list);
        return ParameterWrapperUtils.successAndRenderData(messageQueryVO);
    }
}
