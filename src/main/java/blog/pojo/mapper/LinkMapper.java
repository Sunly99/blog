package blog.pojo.mapper;

import blog.pojo.po.Link;
import blog.pojo.po.Example.LinkExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LinkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    long countByExample(LinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    int deleteByExample(LinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    int insert(Link record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    int insertSelective(Link record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    List<Link> selectByExample(LinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    Link selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Link record, @Param("example") LinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Link record, @Param("example") LinkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Link record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_link
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Link record);
}