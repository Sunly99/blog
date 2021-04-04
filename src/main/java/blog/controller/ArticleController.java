package blog.controller;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.except.BusinessException;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.po.Article;
import blog.pojo.po.view.ArticleView;
import blog.pojo.vo.common.ResponseVO;
import blog.service.ArticleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * 文章
 *
 * @author sly
 */
@Slf4j
@Api(tags = "文章")
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @Value("${spring.servlet.multipart.max-file-size}")
    private String fileMaxSize;
    private final static String UPLOAD_PATH_PREFIX = "uploadFile";
    private final static Integer M_SIZE = 1024 * 1024;
    private final static Set<String> FILE_TYPE = new HashSet<>();
    static {
        FILE_TYPE.add("image/jpg");
        FILE_TYPE.add("image/png");
        FILE_TYPE.add("image/jpeg");
    }

    @PostMapping("/add")
    public ResponseVO<?> insertArticle(Article article, MultipartFile file, HttpSession session) throws IOException {
        // 判断文件是否存在
        if(!file.isEmpty()){
            if(file.getSize() / M_SIZE > Integer.parseInt(fileMaxSize.split("M")[0])){
                // 图片大小不能超过10M
                throw new BusinessException(StatusCodeEnum.FILE_SIZE_ERROR);
            }else {
                // 判断上传文件格式
                String fileType = file.getContentType();
                if (FILE_TYPE.contains(fileType)){
                    // TODO 上传文件

                    // 获取Jar包所在地址
                    ApplicationHome applicationHome = new ApplicationHome(getClass());
                    File jarFile = applicationHome.getSource();
                    log.info("jarFile_path:" + jarFile.getParentFile().toString());
                    // Jar包同目录下文件存储地址
                    File uploadFile = new File(jarFile.getParentFile().toString() + File.separator + UPLOAD_PATH_PREFIX);
                    if(!uploadFile.exists()){
                        boolean mkdir = uploadFile.mkdir();
                        log.info("mkdir result: " + mkdir);
                    }
                    String oldImgName = file.getOriginalFilename();
                    assert oldImgName != null;
                    String newImgName = UUID.randomUUID().toString() + oldImgName.substring(oldImgName.lastIndexOf("."));
                    try {
                        String filePath = uploadFile.getPath() + File.separator + newImgName;
                        log.info("filePath: " + filePath);
                        File newFile = new File(filePath);
                        file.transferTo(newFile);
                        article.setAuthorId((Integer) session.getAttribute("userId"));
                        article.setAvatar("http://sunly.personel-blog.top/images/" + newImgName);
                        return articleService.insertArticle(article);
                    }catch (Exception e){
                        return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.Error, e);
                    }
                }else {
                    // 不符合格式
                    throw new BusinessException(StatusCodeEnum.FILE_TYPE_ERROR);
                }
            }
        }else {
            throw new BusinessException(StatusCodeEnum.FILE_NO_EXISTS_ERROR);
        }
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteArticle(@RequestParam("id") Integer id){
        return articleService.deleteArticle(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateArticle(@RequestBody Article article){
        return articleService.updateArticle(article);
    }

    @GetMapping("/query")
    public PageInfo<ArticleView> selectArticle(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                               @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
                                               @RequestParam(value = "orderBy", defaultValue = "id") String orderBy){
        return articleService.selectArticle(pageNum, pageSize, orderBy);
    }

    @GetMapping("/query/{id}")
    public ArticleView selectArticle(@PathVariable Integer id){
        return articleService.selectArticleById(id);
    }
}
