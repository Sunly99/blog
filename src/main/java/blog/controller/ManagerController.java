package blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sly
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {

    @RequestMapping("/link")
    public String linkPage(Model model){
        return "manager/link";
    }
}
