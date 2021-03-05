package blog.service;

import blog.pojo.po.Setting;
import blog.pojo.vo.common.ResponseVO;

/**
 * SettingService
 *
 * @author sly
 */
public interface SettingService {

    /**
     * 添加设置（暂不开放）
     *
     * @param setting Setting实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertSetting(Setting setting);

    /**
     * 删除设置（暂不开放）
     *
     * @param id 设置Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteSetting(Integer id);

    /**
     * 修改设置
     *
     * @param setting Setting实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateSetting(Setting setting);

    /**
     * 查询设置
     *
     * @return ResponseVO<Setting> 设置实体返回类
     */
    ResponseVO<Setting> selectSetting();
}
