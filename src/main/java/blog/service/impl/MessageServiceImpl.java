package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.MessageMapper;
import blog.pojo.mapper.view.MessageViewMapper;
import blog.pojo.po.Link;
import blog.pojo.po.Message;
import blog.pojo.po.example.LinkExample;
import blog.pojo.po.example.MessageExample;
import blog.pojo.po.view.MessageView;
import blog.pojo.po.view.example.MessageViewExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.MessageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public PageInfo<MessageView> selectMessage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<MessageView> list = messageViewMapper.selectByExample(new MessageViewExample());
        return new PageInfo<>(list);
    }
}
