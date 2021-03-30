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
    // 数据库保存失败
    DATABASE_INSERT_FAIL(500.1,"数据库保存失败"),
    // 数据库删除失败
    DATABASE_DELETE_FAIL(500.2,"数据库删除失败"),
    // 数据库修改失败
    DATABASE_UPDATE_FAIL(500.3,"数据库修改失败"),
    // 数据库读取失败
    DATABASE_SELECT_FAIL(500.4,"数据库查询失败"),

    // 登录-用户未登录
    LOGIN_USER_NOT_LOGIN(200.1,"用户未登录"),
    // 登录-用户不存在
    LOGIN_USER_NOT_EXIST(200.2,"用户不存在"),
    // 登录-用户名或密码错误
    LOGIN_PASSWORD_ERROR(200.3,"用户名或密码错误"),
    // 登录-用户被冻结
    LOGIN_CANNOT_LOGIN(200.4,"用户被冻结");

    private final double code;
    private final String msg;
}
