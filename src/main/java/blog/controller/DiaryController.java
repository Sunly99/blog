package blog.controller;

import blog.pojo.po.Diary;
import blog.pojo.vo.common.ResponseVO;
import blog.service.DiaryService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 日记
 *
 * @author sly
 */
@Slf4j
@Api(tags = "日记")
@RestController
@RequestMapping("/diary")
public class DiaryController {
    @Resource
    private DiaryService diaryService;

    @PostMapping("/add")
    public ResponseVO<?> insertDiary(@RequestBody Diary diary){
        return diaryService.insertDiary(diary);
    }

    @PostMapping("/del")
    public ResponseVO<?> deleteDiary(@RequestParam("id") Integer id){
        return diaryService.deleteDiary(id);
    }

    @PostMapping("/modify")
    public ResponseVO<?> updateDiary(@RequestBody Diary diary){
        return diaryService.updateDiary(diary);
    }

    @GetMapping("/query")
    public ResponseVO<?> selectDiary(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize){
        return diaryService.selectDiary(pageNum, pageSize);
    }
}
