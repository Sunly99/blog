package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.FileUtils;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.ArticleMapper;
import blog.pojo.mapper.view.ArticleViewMapper;
import blog.pojo.po.Article;
import blog.pojo.po.example.ArticleExample;
import blog.pojo.po.view.ArticleView;
import blog.pojo.po.view.example.ArticleViewExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private FileUtils fileUtils;

    @Override
    public ResponseVO<?> insertArticle(Article article) {
        int count;
        try{
            Date date = new Date();
            article.setCreateTime(date);
            article.setUpdateTime(date);
            article.setCounts(0);
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
            String avatar = articleMapper.selectByPrimaryKey(id).getAvatar();
            fileUtils.dropFile(avatar);
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
    public PageInfo<ArticleView> selectArticle(Integer pageNum, Integer pageSize, String orderBy) {
        PageHelper.startPage(pageNum, pageSize, orderBy);
        List<ArticleView> list = articleViewMapper.selectByExample(new ArticleViewExample());
        return new PageInfo<>(list);
    }

    @Override
    public ArticleView selectArticleById(Integer id) {
        ArticleViewExample articleViewExample = new ArticleViewExample();
        articleViewExample.createCriteria().andIdEqualTo(id);
        List<ArticleView> list = articleViewMapper.selectByExampleWithBLOBs(articleViewExample);
        return list.size()>0?list.get(0):new ArticleView();
    }

    @Override
    public List<Article> selectHotArticle(Integer limit) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andStatusShowEqualTo(true);
        articleExample.setOrderByClause("counts desc");
        return articleMapper.selectByExample(articleExample).stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<Article> selectTopArticle(Integer limit) {
        ArticleExample articleExample = new ArticleExample();
        articleExample.createCriteria().andStatusTopEqualTo(true).andStatusShowEqualTo(true);
        articleExample.setOrderByClause("update_time desc");
        return articleMapper.selectByExample(articleExample).stream().limit(limit).collect(Collectors.toList());
    }

    @Override
    public List<ArticleView> selectArticle() {
        ArticleViewExample articleViewExample = new ArticleViewExample();
        articleViewExample.createCriteria().andStatusShowEqualTo(true);
        articleViewExample.setOrderByClause("status_top desc,update_time desc");
        return articleViewMapper.selectByExample(articleViewExample);
    }

    @Override
    public List<ArticleView> selectArticle(Integer id) {
        ArticleViewExample articleViewExample = new ArticleViewExample();
        articleViewExample.createCriteria().andCategoryIdEqualTo(id).andStatusShowEqualTo(true);
        articleViewExample.setOrderByClause("status_top desc,update_time desc");
        return articleViewMapper.selectByExample(articleViewExample);
    }

}
