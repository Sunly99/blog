package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.ArticleMessageMapper;
import blog.pojo.mapper.view.ArticleMessageViewMapper;
import blog.pojo.po.ArticleMessage;
import blog.pojo.po.ArticleMessageView;
import blog.pojo.po.Example.ArticleMessageViewExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleMessageService;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * ArticleMessageServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class ArticleMessageServiceImpl implements ArticleMessageService {
    @Resource
    private ArticleMessageMapper articleMessageMapper;
    @Resource
    private ArticleMessageViewMapper articleMessageViewMapper;

    @Override
    public ResponseVO<?> insertArticleMessage(ArticleMessage articleMessage) {
        int count;
        try{
            Date date = new Date();
            articleMessage.setCreateTime(date);
            articleMessage.setUpdateTime(date);
            count = articleMessageMapper.insertSelective(articleMessage);
        }catch (Exception e){
            log.error("ArticleMessageServiceImpl:insertArticleMessage \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteArticleMessage(Integer id) {
        int count;
        try{
            count = articleMessageMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("ArticleMessageServiceImpl:deleteArticleMessage \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateArticleMessage(ArticleMessage articleMessage) {
        int count;
        try{
            count = articleMessageMapper.updateByPrimaryKeySelective(articleMessage);
        }catch (Exception e){
            log.error("ArticleMessageServiceImpl:updateArticleMessage \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<PageInfo<ArticleMessageView>> selectArticleMessage() {
        List<ArticleMessageView> list = articleMessageViewMapper.selectByExample(new ArticleMessageViewExample());
        PageInfo<ArticleMessageView> pageInfo = new PageInfo<>();
        pageInfo.setList(list);
        return ParameterWrapperUtils.successAndRenderData(pageInfo);
    }
}
