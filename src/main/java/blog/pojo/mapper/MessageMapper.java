package blog.pojo.mapper;

import blog.pojo.po.Message;
import blog.pojo.po.example.MessageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    long countByExample(MessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    int deleteByExample(MessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    int insert(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    int insertSelective(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    List<Message> selectByExample(MessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    Message selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_message
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Message record);
}