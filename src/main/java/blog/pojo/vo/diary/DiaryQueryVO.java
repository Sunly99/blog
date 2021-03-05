package blog.pojo.vo.diary;

import blog.pojo.po.Diary;
import lombok.Data;

import java.util.List;

/**
 * DiaryQueryVO
 *
 * @author sly
 */
@Data
public class DiaryQueryVO {
    /** 记录总条数 */
    Long total;
    /** 日记列表 */
    List<Diary> diaryList;
    /** 当前页数 */
    Integer pageNum;
    /** 页面最大容量 */
    Integer pageSize;
    /** 最大页数 */
    Integer maxPage;
    /** 上一页页码 */
    Integer lastPage;
    /** 下一页页码 */
    Integer nextPage;
}
