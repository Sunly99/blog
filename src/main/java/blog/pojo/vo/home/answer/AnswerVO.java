package blog.pojo.vo.home.answer;

import lombok.Data;

import java.util.Date;

/**
 * Answer
 * @author sly
 */
@Data
public class AnswerVO {

    private Integer userId;
    private String userName;
    private String userAvatar;

    private Integer sendUserId;
    private String sendUserName;
    private String sendUserAvatar;

    private String content;

    private Date createTime;
    private Date updateTime;
}
