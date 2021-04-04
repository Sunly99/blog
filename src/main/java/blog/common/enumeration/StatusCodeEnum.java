package blog.common.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 标准状态代码枚举
 *
 * @author 水张哲
 */

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusCodeEnum {
    // 操作失败
    Error(-1,"操作失败"),
    // 操作成功
    SUCCESS(0,"操作成功"),

    NOT_FOUND(404,"404 NOT FOUND"),

    PARAM_EXCEPTION(400.1, "参数异常"),

    // 数据库保存失败
    DATABASE_INSERT_FAIL(500.1,"数据库保存失败"),
    // 数据库删除失败
    DATABASE_DELETE_FAIL(500.2,"数据库删除失败"),
    // 数据库修改失败
    DATABASE_UPDATE_FAIL(500.3,"数据库修改失败"),
    // 数据库读取失败
    DATABASE_SELECT_FAIL(500.4,"数据库查询失败"),

    EMPTY_FILE_ERROR(600.1, "空文件异常"),
    FILE_UPLOAD_ERROR(600.2, "文件上传异常"),
    FILE_DELETE_ERROR(600.3, "文件删除异常"),
    FILE_MKDIR_ERROR(600.4, "文件夹创建失败"),
    FILE_URI_ERROR(600.5, "文件存放路径有误"),
    FILE_SIZE_ERROR(600.6, "文件超出指定大小"),
    FILE_DOWNLOAD_ERROR(600.7, "文件下载异常"),
    FILE_TYPE_ERROR(600.8, "文件类型异常"),
    FILE_NO_EXISTS_ERROR(600.9, "文件不存在"),


    // 登录-用户未登录
    LOGIN_USER_NOT_LOGIN(200.1,"用户未登录"),
    // 登录-用户不存在
    LOGIN_USER_NOT_EXIST(200.2,"用户不存在"),
    // 登录-用户名或密码错误
    LOGIN_PASSWORD_ERROR(200.3,"用户名或密码错误"),
    // 登录-用户被冻结
    LOGIN_CANNOT_LOGIN(200.4,"用户被冻结"),

    UNKNOWN_ERROR(999, "未知错误");;

    private final double code;
    private final String msg;
}
