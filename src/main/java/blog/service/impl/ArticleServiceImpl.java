package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.ArticleMapper;
import blog.pojo.mapper.view.ArticleViewMapper;
import blog.pojo.po.Article;
import blog.pojo.po.ArticleView;
import blog.pojo.po.Example.ArticleViewExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleService;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * ArticleServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleViewMapper articleViewMapper;

    @Override
    public ResponseVO<?> insertArticle(Article article) {
        int count;
        try{
            Date date = new Date();
            article.setCreateTime(date);
            article.setUpdateTime(date);
            count = articleMapper.insertSelective(article);
        }catch (Exception e){
            log.error("ArticleServiceImpl:insertArticle \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteArticle(Integer id) {
        int count;
        try{
            count = articleMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("ArticleServiceImpl:deleteArticle \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateArticle(Article article) {
        int count;
        try{
            count = articleMapper.updateByPrimaryKeySelective(article);
        }catch (Exception e){
            log.error("ArticleServiceImpl:updateArticle \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<PageInfo<ArticleView>> selectArticle() {
        List<ArticleView> list = articleViewMapper.selectByExample(new ArticleViewExample());
        PageInfo<ArticleView> pageInfo = new PageInfo<>();
        pageInfo.setList(list);
        return ParameterWrapperUtils.successAndRenderData(pageInfo);
    }

    @Override
    public ResponseVO<ArticleView> selectArticleById(Integer id) {
        ArticleViewExample articleViewExample = new ArticleViewExample();
        articleViewExample.createCriteria().andIdEqualTo(id);
        List<ArticleView> list = articleViewMapper.selectByExampleWithBLOBs(new ArticleViewExample());
        return ParameterWrapperUtils.successAndRenderData(list.size()>0?list.get(0):new ArticleView());
    }

}
