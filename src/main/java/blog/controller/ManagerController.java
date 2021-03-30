package blog.controller;

import blog.service.*;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * @author sly
 */
@Api(tags = "后台页面")
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private UserService userService;

    @Resource
    private LinkService linkService;

    @Resource
    private ArticleCategoryService articleCategoryService;

    @Resource
    private DiaryService diaryService;

    @Resource
    private MessageService messageService;

    @Resource
    private ArticleService articleService;

    @GetMapping("/index")
    public String indexPage(){
        return "manager/index";
    }

    @GetMapping("/link")
    public String linkPage(Model model,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize
    ){
        model.addAttribute("links",linkService.selectLink(pageNum, pageSize));
        return "manager/link";
    }

    @GetMapping("/user")
    public String userPage(Model model,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize
    ){
        model.addAttribute("users",userService.selectUser(pageNum, pageSize));
        return "manager/user";
    }

    @GetMapping("/article-category")
    public String articleCategoryPage(Model model,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize
    ){
        model.addAttribute("articleCategories",articleCategoryService.selectArticleCategory(pageNum, pageSize));
        return "manager/blog-type";
    }

    @GetMapping("/diary")
    public String diaryPage(Model model,
                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize
    ){
        model.addAttribute("diaries",diaryService.selectDiary(pageNum, pageSize));
        return "manager/diary";
    }

    @GetMapping("/message")
    public String messagePage(Model model,
                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                            @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize
    ){
        model.addAttribute("messages",messageService.selectMessage(pageNum, pageSize));
        return "manager/message";
    }

    @GetMapping("/article")
    public String articlePage(Model model,
                              @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize
    ){
        model.addAttribute("articles",articleService.selectArticle(pageNum, pageSize, "id"));
        return "manager/blog";
    }
}
