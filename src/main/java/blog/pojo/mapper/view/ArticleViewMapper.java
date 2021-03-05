package blog.pojo.mapper.view;

import blog.pojo.po.ArticleView;
import blog.pojo.po.Example.ArticleViewExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleViewMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_article
     *
     * @mbg.generated
     */
    long countByExample(ArticleViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_article
     *
     * @mbg.generated
     */
    List<ArticleView> selectByExampleWithBLOBs(ArticleViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_article
     *
     * @mbg.generated
     */
    List<ArticleView> selectByExample(ArticleViewExample example);
}