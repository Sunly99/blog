package blog.controller;

import blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author sly
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private UserService userService;

    @RequestMapping("/link")
    public String linkPage(Model model){
        return "manager/link";
    }

    @RequestMapping("/user")
    public String userPage(Model model,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "1")  Integer pageSize
    ){
        model.addAttribute("users",userService.selectUser(pageNum, pageSize));
        return "manager/user";
    }
}
