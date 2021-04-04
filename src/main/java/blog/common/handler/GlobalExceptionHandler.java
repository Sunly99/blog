package blog.common.handler;

import blog.common.enumeration.StatusCodeEnum;
import blog.common.except.BusinessException;
import blog.common.util.ParameterWrapperUtils;
import blog.pojo.vo.common.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.naming.SizeLimitExceededException;

/**
 * 全局异常处理
 *
 * @author hys
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    //region # 业务逻辑异常

    /**
     * 自定义业务异常处理
     *
     * @param e 业务异常
     * @return ResponseEntity
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ResponseVO<?>> businessExceptionHandler(BusinessException e) {
        // 输出异常消息
        return ResponseEntity.status(HttpStatus.OK).body(ParameterWrapperUtils.putCode2ResponseVO(e));

    }

    //endregion

    // region # 参数异常
    /**
     * 参数异常处理
     *
     * @see HttpMessageNotReadableException HTTP参数不可读异常
     * @see MethodArgumentNotValidException 方法参数无效异常
     * @see MethodArgumentTypeMismatchException 参数类型错误处理
     * @see BadSqlGrammarException 错误的参数导致SQL语法异常处理
     * @param e 异常
     * @return ResponseEntity
     */
    @ExceptionHandler(value = {
            HttpMessageNotReadableException.class,
            MethodArgumentNotValidException.class,
            MethodArgumentTypeMismatchException.class,
            BadSqlGrammarException.class
    })
    public ResponseEntity<ResponseVO<?>> paramExceptionHandler(Exception e){
        // 打印日志
        log.error(e.getMessage(), e);
        // 输出异常消息
        return ResponseEntity.status(HttpStatus.OK).body(ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.PARAM_EXCEPTION));
    }
    //endregion

    // region # 文件异常

    /**
     * 文件异常处理
     *
     * @see MaxUploadSizeExceededException 超出总上传大小异常
     * @see SizeLimitExceededException 超出大小限制异常
     * @param e 异常
     * @return ResponseEntity
     */
    @ExceptionHandler(value = {
            MaxUploadSizeExceededException.class,
            SizeLimitExceededException.class
    })
    public ResponseEntity<ResponseVO<?>> fileExceptionHandler(Exception e){
        // 打印日志
        log.error(e.getMessage(), e);
        // 输出异常消息
        return ResponseEntity.status(HttpStatus.OK).body(ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.FILE_SIZE_ERROR));
    }

    // endregion

    //region # 其他异常

    /**
     * 其他异常处理
     *
     * @param e 异常
     * @return ResponseEntity
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseVO<?>> otherExceptionHandler(Exception e) {
        // 打印日志
        log.error(e.getMessage(), e);
        // 输出异常消息
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ParameterWrapperUtils.putCode2ResponseVO(StatusCodeEnum.UNKNOWN_ERROR));
    }

    //endregion
}

