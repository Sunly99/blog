package blog.controller;

import blog.pojo.po.Link;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.link.LinkQueryVO;
import blog.service.LinkService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
    public ResponseVO<?> selectLink(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        ResponseVO<LinkQueryVO> responseVO = linkService.selectLink();
        Long pageTotal = page.getTotal();
        Integer pages = page.getPages();
        LinkQueryVO linkQueryVO = responseVO.getData();
        linkQueryVO.setTotal(pageTotal);
        linkQueryVO.setMaxPage(pages);
        linkQueryVO.setLastPage(pageNum>1?pageNum-1:null);
        linkQueryVO.setNextPage(pageNum>=pages?null:pageNum+1);
        linkQueryVO.setPageNum(pageNum);
        linkQueryVO.setPageSize(pageSize);
        responseVO.setData(linkQueryVO);
        return responseVO;
    }
}
