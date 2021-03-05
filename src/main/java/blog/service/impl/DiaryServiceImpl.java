package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.DiaryMapper;
import blog.pojo.po.Diary;
import blog.pojo.po.Example.DiaryExample;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.diary.DiaryQueryVO;
import blog.service.DiaryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * DiaryServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class DiaryServiceImpl implements DiaryService {
    @Resource
    private DiaryMapper diaryMapper;

    @Override
    public ResponseVO<?> insertDiary(Diary diary) {
        int count;
        try{
            Date date = new Date();
            diary.setCreateTime(date);
            diary.setUpdateTime(date);
            count = diaryMapper.insertSelective(diary);
        }catch (Exception e){
            log.error("DiaryServiceImpl:insertDiary \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteDiary(Integer id) {
        int count;
        try{
            count = diaryMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("DiaryServiceImpl:deleteDiary \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateDiary(Diary diary) {
        int count;
        try{
            count = diaryMapper.updateByPrimaryKeySelective(diary);
        }catch (Exception e){
            log.error("DiaryServiceImpl:updateDiary \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<DiaryQueryVO> selectDiary() {
        List<Diary> list = diaryMapper.selectByExample(new DiaryExample());
        // 自定义返回类赋值
        DiaryQueryVO diaryQueryVO = new DiaryQueryVO();
        diaryQueryVO.setDiaryList(list);
        return ParameterWrapperUtils.successAndRenderData(diaryQueryVO);
    }
}
