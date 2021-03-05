package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.SettingMapper;
import blog.pojo.po.Example.SettingExample;
import blog.pojo.po.Setting;
import blog.pojo.vo.common.ResponseVO;
import blog.service.SettingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * SettingServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class SettingServiceImpl implements SettingService {
    @Resource
    private SettingMapper settingMapper;

    @Override
    public ResponseVO<?> insertSetting(Setting setting) {
        int count;
        try{
            Date date = new Date();
            setting.setUpdateTime(date);
            count = settingMapper.insertSelective(setting);
        }catch (Exception e){
            log.error("SettingServiceImpl:insertSetting \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteSetting(Integer id) {
        int count;
        try{
            count = settingMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("SettingServiceImpl:deleteSetting \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateSetting(Setting setting) {
        if (setting.getId()==null){
            return insertSetting(setting);
        }else {
            int count;
            try{
                count = settingMapper.updateByPrimaryKeySelective(setting);
            }catch (Exception e){
                log.error("SettingServiceImpl:updateSetting \n" + e.getMessage());
                return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
            }
            return ParameterWrapperUtils.successAndRenderData(count);
        }
    }

    @Override
    public ResponseVO<Setting> selectSetting() {
        Setting setting = new Setting();
        List<Setting> list = settingMapper.selectByExample(new SettingExample());
        return ParameterWrapperUtils.successAndRenderData(list.size()>0?list.get(list.size()-1):setting);
    }
}
