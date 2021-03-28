package blog.controller;

import blog.pojo.po.User;
import blog.pojo.vo.common.ResponseVO;
import blog.service.LoginService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 登录
 *
 * @author sly
 */
@Slf4j
@Api(tags = "登录")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping("/check")
    public ResponseVO<?> loginCheck(@RequestParam String username, @RequestParam String password,@ApiIgnore HttpSession session){
        ResponseVO<User> responseVO = loginService.loginCheck(username, password);
        if(responseVO.getCode()==0){
            session.setAttribute("userId",responseVO.getData().getId());
            session.setAttribute("userName",responseVO.getData().getNickName());
            session.setAttribute("userAvatar",responseVO.getData().getAvatar());
            session.setAttribute("userLevel",responseVO.getData().getLevel());
        }
        return responseVO;
    }
}
