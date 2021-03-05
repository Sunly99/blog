package blog.controller;

import blog.pojo.po.Diary;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.diary.DiaryQueryVO;
import blog.service.DiaryService;
import com.github.pagehelper.Page;
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
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        ResponseVO<DiaryQueryVO> responseVO = diaryService.selectDiary();
        Long pageTotal = page.getTotal();
        Integer pages = page.getPages();
        DiaryQueryVO diaryQueryVO = responseVO.getData();
        diaryQueryVO.setTotal(pageTotal);
        diaryQueryVO.setMaxPage(pages);
        diaryQueryVO.setLastPage(pageNum>1?pageNum-1:null);
        diaryQueryVO.setNextPage(pageNum>=pages?null:pageNum+1);
        diaryQueryVO.setPageNum(pageNum);
        diaryQueryVO.setPageSize(pageSize);
        responseVO.setData(diaryQueryVO);
        return responseVO;
    }
}
