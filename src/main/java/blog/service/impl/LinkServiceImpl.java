package blog.service.impl;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.mapper.LinkMapper;
import blog.pojo.po.Link;
import blog.pojo.po.example.LinkExample;
import blog.pojo.vo.common.ResponseVO;
import blog.service.LinkService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * LinkServiceImpl
 *
 * @author sly
 */
@Log4j2
@Service
public class LinkServiceImpl implements LinkService {
    @Resource
    private LinkMapper linkMapper;

    @Override
    public ResponseVO<?> insertLink(Link link) {
        int count;
        try{
            Date date = new Date();
            link.setCreateTime(date);
            link.setUpdateTime(date);
            link.setStatus(true);
            count = linkMapper.insertSelective(link);
        }catch (Exception e){
            log.error("LinkServiceImpl:insertLink \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_INSERT_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> deleteLink(Integer id) {
        int count;
        try{
            count = linkMapper.deleteByPrimaryKey(id);
        }catch (Exception e){
            log.error("LinkServiceImpl:deleteLink \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_DELETE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public ResponseVO<?> updateLink(Link link) {
        int count;
        try{
            count = linkMapper.updateByPrimaryKeySelective(link);
        }catch (Exception e){
            log.error("LinkServiceImpl:updateLink \n" + e.getMessage());
            return ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.DATABASE_UPDATE_FAIL,e);
        }
        return ParameterWrapperUtils.successAndRenderData(count);
    }

    @Override
    public PageInfo<Link> selectLink(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Link> list = linkMapper.selectByExample(new LinkExample());
        return  new PageInfo<>(list);
    }

    @Override
    public List<Link> selectLink() {
        LinkExample linkExample = new LinkExample();
        linkExample.createCriteria().andStatusEqualTo(true);
        return linkMapper.selectByExample(linkExample);
    }
}
