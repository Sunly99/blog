package blog.pojo.mapper.view;

import blog.pojo.po.ArticleSimpleView;
import blog.pojo.po.Example.ArticleSimpleViewExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleSimpleViewMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_article_simple
     *
     * @mbg.generated
     */
    long countByExample(ArticleSimpleViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_article_simple
     *
     * @mbg.generated
     */
    List<ArticleSimpleView> selectByExampleWithBLOBs(ArticleSimpleViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_article_simple
     *
     * @mbg.generated
     */
    List<ArticleSimpleView> selectByExample(ArticleSimpleViewExample example);
}