package blog.service;

import blog.pojo.vo.common.ResponseVO;

public interface LoginService {

    ResponseVO<?> loginCheck(String username, String password);
}
