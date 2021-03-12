package blog.controller;

import blog.service.LinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private LinkService linkService;

    @RequestMapping("/link")
    public String linkPage(Model model){
        model.addAttribute("linkInfo",linkService.selectLink(0,0));
        return "manager/link";
    }
}
