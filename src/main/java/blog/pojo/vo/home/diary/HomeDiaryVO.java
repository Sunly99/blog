package blog.pojo.vo.home.diary;

import blog.pojo.po.Diary;
import lombok.Data;

import java.util.List;

/**
 * @author sly
 */
@Data
public class HomeDiaryVO {
    private String year;
    private List<Diary> diaryList;
}
