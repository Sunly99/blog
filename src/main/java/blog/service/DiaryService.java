package blog.service;

import blog.pojo.po.Diary;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

/**
 * DiaryService
 *
 * @author sly
 */
public interface DiaryService {

    /**
     * 添加日记
     *
     * @param diary Diary实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertDiary(Diary diary);

    /**
     * 删除日记
     *
     * @param id 日记Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteDiary(Integer id);

    /**
     * 修改日记
     *
     * @param diary Diary实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateDiary(Diary diary);

    /**
     * 查询日记
     *
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @return ResponseVO<PageInfo<Diary>> 自定义标准返回类
     */
    ResponseVO<PageInfo<Diary>> selectDiary(Integer pageNum, Integer pageSize);
}
