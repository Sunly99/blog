package blog.service;

import blog.pojo.po.Link;
import blog.pojo.vo.common.ResponseVO;
import com.github.pagehelper.PageInfo;

import java.util.List;


/**
 * LinkService
 *
 * @author sly
 */
public interface LinkService {

    /**
     * 添加友链
     *
     * @param link Link实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> insertLink(Link link);

    /**
     * 删除友链
     *
     * @param id 友链Id
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> deleteLink(Integer id);

    /**
     * 修改友链
     *
     * @param link Link实体类
     * @return ResponseVO<?> 自定义标准返回类
     */
    ResponseVO<?> updateLink(Link link);

    /**
     * 查询友链
     *
     * @param pageNum 当前页码
     * @param pageSize 分页大小
     * @return ResponseVO<PageInfo<Link>> 自定义标准返回类
     */
    ResponseVO<PageInfo<Link>> selectLink(Integer pageNum, Integer pageSize);

    /**
     * 查询友链列表-不分页
     *
     * @return List<Link> 友链列表
     */
    List<Link> selectLink();

}
