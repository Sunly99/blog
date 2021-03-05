package blog.service;

import blog.pojo.po.Link;
import blog.pojo.vo.common.ResponseVO;
import blog.pojo.vo.link.LinkQueryVO;


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
     * @return ResponseVO<LinkQueryVO> 自定义友链查询返回类
     */
    ResponseVO<LinkQueryVO> selectLink();
}
