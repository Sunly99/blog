package blog.service;

import blog.pojo.po.User;
import blog.pojo.vo.common.ResponseVO;

public interface LoginService {

    ResponseVO<User> loginCheck(String username, String password);
}
