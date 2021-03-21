package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.UserMapper;
import blog.pojo.po.User;
import blog.pojo.po.example.UserExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.LoginService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseVO<User> loginCheck(String username, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> list = userMapper.selectByExample(userExample);
        ResponseVO<User> userResponseVO = new ResponseVO<>();
        if (list.size()>0){
            if(password.equals(list.get(0).getPassword())){
                User user = new User();
                user.setId(list.get(0).getId());
                user.setUsername(list.get(0).getUsername());
                user.setNickName(list.get(0).getNickName());
                user.setAvatar(list.get(0).getAvatar());
                user.setLevel(list.get(0).getLevel());
                return ParameterWrapperUtils.successAndRenderData(user);
            }else {
                return ParameterWrapperUtils.putCode2ResponseVO(userResponseVO, StatusCodeEnum.LOGIN_PASSWORD_ERROR,null);
            }
        }else {
            return ParameterWrapperUtils.putCode2ResponseVO(userResponseVO, StatusCodeEnum.LOGIN_USER_NOT_EXIST,null);
        }
    }
}
