package blog.controller;

import blog.pojo.po.Setting;
import blog.pojo.po.User;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.user.UserQueryVO;
import blog.service.SettingService;
import blog.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 设置
 *
 * @author sly
 */
@Slf4j
@Api(tags = "设置")
@RestController
@RequestMapping("/setting")
public class SettingController {
    @Resource
    private SettingService settingService;

    @PostMapping("/add")
    public ResponseVO<?> insertSetting(@RequestBody Setting setting){
        return settingService.insertSetting(setting);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteSetting(@RequestParam("id") Integer id){
        return settingService.deleteSetting(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateSetting(@RequestBody Setting setting){
        return settingService.updateSetting(setting);
    }

    @GetMapping("/query")
    public ResponseVO<?> selectSetting(){
        return settingService.selectSetting();
    }
}
