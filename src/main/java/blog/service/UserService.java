package blog.service;

import blog.pojo.po.User;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

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
     * @return ResponseVO<PageInfo<User>> 自定义标准返回类
     */
    ResponseVO<PageInfo<User>> selectUser();
}
