package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.UserMapper;
import blog.pojo.po.User;
import blog.pojo.po.example.UserExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseVO<?> loginCheck(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> list = userMapper.selectByExample(userExample);
        if (list.size()>0){
            if(password.equals(list.get(0).getPassword())){
                return ParameterWrapperUtils.successAndRenderData(list.get(0).getLevel());
            }else {
                return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.LOGIN_PASSWORD_ERROR);
            }
        }else {
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.LOGIN_USER_NOT_EXIST);
        }
    }
}
