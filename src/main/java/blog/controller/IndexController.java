package blog.controller;

import blog.service.ArticleService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @author sly
 */
@Api("首页")
@Controller
public class IndexController {
    @Resource
    private ArticleService articleService;

    @GetMapping("/")
    public String indexPage(Model model){
        model.addAttribute("hotArticles",articleService.selectHotArticle(3));
        return "home/index";
    }
}
