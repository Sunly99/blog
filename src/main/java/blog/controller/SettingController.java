package blog.controller;

import blog.pojo.po.Setting;
import blog.pojo.vo.common.ResponseVO;
import blog.service.SettingService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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

    @ApiIgnore
    @PostMapping("/add")
    public ResponseVO<?> insertSetting(@RequestBody Setting setting){
        return settingService.insertSetting(setting);
    }

    @ApiIgnore
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
