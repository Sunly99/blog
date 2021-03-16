package blog.controller;

import blog.pojo.po.Link;
import blog.pojo.vo.common.ResponseVO;
import blog.service.LinkService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 友链
 *
 * @author sly
 */
@Slf4j
@Api(tags = "友链")
@RestController
@RequestMapping("/link")
public class LinkController {
    @Resource
    private LinkService linkService;

    @PostMapping("/add")
    public ResponseVO<?> insertLink(@RequestBody Link link){
        return linkService.insertLink(link);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteLink(@RequestParam("id") Integer id){
        return linkService.deleteLink(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateLink(@RequestBody Link link){
        return linkService.updateLink(link);
    }

    @GetMapping("/query")
    public PageInfo<Link> selectLink(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        return linkService.selectLink(pageNum, pageSize);
    }
}
