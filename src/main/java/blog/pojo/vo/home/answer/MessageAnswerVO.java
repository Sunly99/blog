package blog.pojo.vo.home.answer;

import blog.pojo.po.view.MessageView;
import lombok.Data;

import java.util.List;

/**
 * MessageAnswer
 * @author sly
 */
@Data
public class MessageAnswerVO {

    private MessageView message;

    private List<AnswerVO> answers;
}
