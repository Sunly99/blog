package blog.common.except;

import blog.common.enumeration.StatusCodeEnum;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 指定错误抛出
 *
 * @author 水张哲
 * @date 2021年3月22日
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private double code;
    private String msg;
    private JSONObject response;

    public BusinessException(StatusCodeEnum sce) {
        code = sce.getCode();
        msg = sce.getMsg();
        log.warn(code + ": " + msg);
    }

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
        log.warn(code + ": " + this.msg);
    }

    public BusinessException(int code, String msg, JSONObject response) {
        this.code = code;
        this.msg = msg;
        this.response = response;
        log.warn(code + ": " + msg);
    }

    public BusinessException(StatusCodeEnum sce, JSONObject response) {
        code = sce.getCode();
        msg = sce.getMsg();
        this.response = response;
        log.warn(code + ": " + msg);
    }

    public BusinessException(StatusCodeEnum sce, String supplement) {
        code = sce.getCode();
        msg = sce.getMsg() + "(" + supplement + ")";
        log.warn(code + ": " + msg);
    }

    public BusinessException(StatusCodeEnum sce, Throwable throwable) {
        code = sce.getCode();
        msg = sce.getMsg();
        log.error(throwable.getMessage(), throwable);
    }

    public BusinessException(StatusCodeEnum sce, Throwable throwable, String supplement) {
        code = sce.getCode();
        msg = sce.getMsg() + "(" + supplement + ")";
        log.error(throwable.getMessage(), throwable);
    }
}
