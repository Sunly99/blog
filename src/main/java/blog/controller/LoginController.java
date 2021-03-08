package blog.controller;

import blog.pojo.vo.common.ResponseVO;
import blog.service.LoginService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public ResponseVO<?> loginCheck(@RequestParam String username,@RequestParam String password){
        return loginService.loginCheck(username, password);
    }
}
