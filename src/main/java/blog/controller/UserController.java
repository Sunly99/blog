package blog.controller;

import blog.pojo.po.Link;
import blog.pojo.po.User;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.link.LinkQueryVO;
import blog.pojo.vo.user.UserQueryVO;
import blog.service.LinkService;
import blog.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户
 *
 * @author sly
 */
@Slf4j
@Api(tags = "用户")
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/add")
    public ResponseVO<?> insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteUser(@RequestParam("id") Integer id){
        return userService.deleteUser(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/query")
    public ResponseVO<?> selectUser(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        ResponseVO<UserQueryVO> responseVO = userService.selectUser();
        Long pageTotal = page.getTotal();
        Integer pages = page.getPages();
        UserQueryVO userQueryVO = responseVO.getData();
        userQueryVO.setTotal(pageTotal);
        userQueryVO.setMaxPage(pages);
        userQueryVO.setLastPage(pageNum>1?pageNum-1:null);
        userQueryVO.setNextPage(pageNum>=pages?null:pageNum+1);
        userQueryVO.setPageNum(pageNum);
        userQueryVO.setPageSize(pageSize);
        responseVO.setData(userQueryVO);
        return responseVO;
    }
}
