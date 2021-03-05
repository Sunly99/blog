package blog.pojo.vo.user;

import blog.pojo.po.User;
import lombok.Data;

import java.util.List;

/**
 * UserQueryVO
 *
 * @author sly
 */
@Data
public class UserQueryVO {
    /** 记录总条数 */
    Long total;
    /** 用户列表 */
    List<User> userList;
    /** 当前页数 */
    Integer pageNum;
    /** 页面最大容量 */
    Integer pageSize;
    /** 最大页数 */
    Integer maxPage;
    /** 上一页页码 */
    Integer lastPage;
    /** 下一页页码 */
    Integer nextPage;
}
