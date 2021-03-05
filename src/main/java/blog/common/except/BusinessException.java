package blog.common.except;

import blog.common.enumeration.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 指定错误抛出
 *
 * @author 水张哲
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessException extends Exception {

    private double code;
    private String msg;

    public BusinessException(StatusCodeEnum sce){
        code = sce.getCode();
        msg = sce.getMsg();
    }

}
