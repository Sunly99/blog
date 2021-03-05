package blog.service;

import blog.pojo.po.Diary;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.diary.DiaryQueryVO;

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
     * @return ResponseVO<DiaryQueryVO> 自定义日记查询返回类
     */
    ResponseVO<DiaryQueryVO> selectDiary();
}
