package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.ArticleCategoryMapper;
import blog.pojo.po.ArticleCategory;
import blog.pojo.po.example.ArticleCategoryExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleCategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ArticleCategoryServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {
    @Resource
    private ArticleCategoryMapper articleCategoryMapper;

    @Override
    public ResponseVO<?> insertArticleCategory(ArticleCategory articleCategory) {
        int count;
        try{
            articleCategory.setStatus(true);
            count = articleCategoryMapper.insertSelective(articleCategory);
        }catch (Exception e){
            log.error("ArticleCategoryServiceImpl:insertArticleCategory \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteArticleCategory(Integer id) {
        int count;
        try{
            count = articleCategoryMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("ArticleCategoryServiceImpl:deleteArticleCategory \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateArticleCategory(ArticleCategory articleCategory) {
        int count;
        try{
            count = articleCategoryMapper.updateByPrimaryKeySelective(articleCategory);
        }catch (Exception e){
            log.error("ArticleCategoryServiceImpl:updateArticleCategory \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public PageInfo<ArticleCategory> selectArticleCategory(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleCategory> list = articleCategoryMapper.selectByExample(new ArticleCategoryExample());
        return new PageInfo<>(list);
    }

    @Override
    public List<ArticleCategory> selectArticleCategory() {
        ArticleCategoryExample articleCategoryExample = new ArticleCategoryExample();
        articleCategoryExample.createCriteria().andStatusEqualTo(true);
        return articleCategoryMapper.selectByExample(articleCategoryExample);
    }
}
