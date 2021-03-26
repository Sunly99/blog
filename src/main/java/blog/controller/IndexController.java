package blog.controller;

import blog.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author sly
 */
@Controller
public class IndexController {
    @Resource
    private ArticleService articleService;

    @RequestMapping("/")
    public String indexPage(Model model){
        model.addAttribute("hotArticles",articleService.selectHotArticle(3));
        return "/home/index";
    }
}
