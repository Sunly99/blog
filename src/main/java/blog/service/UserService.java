package blog.service;

import blog.pojo.po.Link;
import blog.pojo.po.User;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.link.LinkQueryVO;
import blog.pojo.vo.user.UserQueryVO;

/**
 * UserService
 *
 * @author sly
 */
public interface UserService {

    /**
     * 添加用户
     *
     * @param user User实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteUser(Integer id);

    /**
     * 修改用户
     *
     * @param user User实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateUser(User user);

    /**
     * 查询用户
     *
     * @return ResponseVO<UserQueryVO> 自定义用户查询返回类
     */
    ResponseVO<UserQueryVO> selectUser();
}
