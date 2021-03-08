package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.UserMapper;
import blog.pojo.po.Example.UserExample;
import blog.pojo.po.User;
import blog.pojo.vo.common.ResponseVO;
import blog.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * UserServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResponseVO<?> insertUser(User user) {
        int count;
        try{
            Date date = new Date();
            user.setCreateTime(date);
            user.setUpdateTime(date);
            count = userMapper.insertSelective(user);
        }catch (Exception e){
            log.error("UserServiceImpl:insertUser \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteUser(Integer id) {
        int count;
        try{
            count = userMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("UserServiceImpl:deleteUser \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateUser(User user) {
        int count;
        try{
            count = userMapper.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            log.error("UserServiceImpl:updateUser \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<PageInfo<User>> selectUser(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectByExample(new UserExample());
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return ParameterWrapperUtils.successAndRenderData(pageInfo);
    }
}
