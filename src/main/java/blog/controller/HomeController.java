package blog.controller;

import blog.pojo.vo.home.answer.MessageAnswerVO;
import blog.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author sly
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @Resource
    private ArticleService articleService;
    @Resource
    private LinkService linkService;
    @Resource
    private DiaryService diaryService;
    @Resource
    private ArticleCategoryService articleCategoryService;
    @Resource
    private MessageAnswerService messageAnswerService;

    @RequestMapping("/index")
    public String indexPage(Model model){
        model.addAttribute("hotArticles",articleService.selectHotArticle(3));
        return "home/index";
    }

    @RequestMapping("/link")
    public String linkPage(Model model){
        model.addAttribute("links",linkService.selectLink());
        return "home/link";
    }

    @RequestMapping("/diary")
    public String diaryPage(Model model){
        model.addAttribute("diaries",diaryService.selectDiary());
        return "home/diary";
    }

    @RequestMapping("/message")
    public String messagePage(Model model){
        model.addAttribute("messages",messageAnswerService.selectMessageAnswerList());
        return "home/message";
    }

    @RequestMapping("/article")
    public String articlePage(Model model){
        model.addAttribute("articles",articleService.selectArticle());
        model.addAttribute("categories",articleCategoryService.selectArticleCategory());
        model.addAttribute("hotArticles",articleService.selectHotArticle(10));
        model.addAttribute("topArticles",articleService.selectTopArticle(10));
        return "home/article";
    }

    @RequestMapping("/article/{id}")
    public String articlePage(Model model, @PathVariable Integer id){
        model.addAttribute("articles",articleService.selectArticle(id));
        model.addAttribute("categories",articleCategoryService.selectArticleCategory());
        model.addAttribute("hotArticles",articleService.selectHotArticle(10));
        model.addAttribute("topArticles",articleService.selectTopArticle(10));
        return "home/article";
    }

    @RequestMapping("/read/{id}")
    public String readPage(@PathVariable Integer id,Model model){
        model.addAttribute("article",articleService.selectArticleById(id));
        model.addAttribute("messages",messageAnswerService.selectMessageAnswerList(id));
        return "home/read";
    }

    @RequestMapping("/about")
    public String aboutPage(Model model){
        return "home/about";
    }

    @RequestMapping("/login")
    public String loginPage(HttpSession session){
        session.invalidate();
        return "login";
    }
}
