package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.DiaryMapper;
import blog.pojo.po.Diary;
import blog.pojo.po.example.DiaryExample;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.home.diary.HomeDiaryVO;
import blog.service.DiaryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
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
    public ResponseVO<PageInfo<Diary>> selectDiary(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Diary> list = diaryMapper.selectByExampleWithBLOBs(new DiaryExample());
        PageInfo<Diary> pageInfo = new PageInfo<>(list);
        return ParameterWrapperUtils.successAndRenderData(pageInfo);
    }

    @Override
    public List<HomeDiaryVO> selectDiary() {
        DiaryExample diaryExample = new DiaryExample();
        diaryExample.createCriteria().andStatusEqualTo(true);
        diaryExample.setOrderByClause("create_time desc");
        List<Diary> list = diaryMapper.selectByExampleWithBLOBs(diaryExample);

        List<String> yearList = new ArrayList<>();
        List<HomeDiaryVO> homeDiaryVOList = new ArrayList<>();

        list.forEach(o->{
            Calendar cal = Calendar.getInstance();
            cal.setTime(o.getCreateTime());
            String year = String.valueOf(cal.get(Calendar.YEAR));
            if(!yearList.contains(year)){
                yearList.add(year);
            }
        });

        yearList.forEach(o->{
            HomeDiaryVO homeDiaryVO = new HomeDiaryVO();
            homeDiaryVO.setYear(o);
            List<Diary> diaryList = new ArrayList<>();
            list.forEach(i->{
                Calendar cal = Calendar.getInstance();
                cal.setTime(i.getCreateTime());
                String year = String.valueOf(cal.get(Calendar.YEAR));
                if(year.equals(o)){
                    diaryList.add(i);
                }
            });
            homeDiaryVO.setDiaryList(diaryList);
            homeDiaryVOList.add(homeDiaryVO);
        });

        return homeDiaryVOList;
    }
}
