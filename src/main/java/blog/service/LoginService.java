package blog.service;

import blog.pojo.po.User;
import blog.pojo.vo.common.ResponseVO;

/**
 * 登录校验
 *
 * @author sly
 */
public interface LoginService {
    ResponseVO<User> loginCheck(String username, String password);
}
