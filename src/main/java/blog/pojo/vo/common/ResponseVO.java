package blog.pojo.vo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response 标准VO
 *
 * @author sly
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO<T>{
    /** 返回代码 */
    private Double code;
    /** 返回信息 */
    private String msg;
    /** 返回数据 */
    private T data;
    /** 返回堆栈 */
    private String stack;
}
