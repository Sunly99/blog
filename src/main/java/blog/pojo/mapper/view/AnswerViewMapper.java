package blog.pojo.mapper.view;

import blog.pojo.po.view.AnswerView;
import blog.pojo.po.view.example.AnswerViewExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerViewMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_answer
     *
     * @mbg.generated
     */
    long countByExample(AnswerViewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_answer
     *
     * @mbg.generated
     */
    List<AnswerView> selectByExample(AnswerViewExample example);
}