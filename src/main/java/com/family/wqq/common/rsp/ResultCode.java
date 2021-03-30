package com.family.wqq.common.rsp;

/**
 * 公共的返回码
 * 返回码code：
 * 成功：10000
 * 失败：10001
 * 未登录：10002
 * 未授权：10003
 * 抛出异常：99999
 * <p>
 * ...
 */
@SuppressWarnings(value = "all")

public enum ResultCode {

    SUCCESS(true, 10000, "操作成功！"),
    FAIL(false,10001,"操作失败"),
    PARAM_IS_EMPTY(false,10002,"请求参数不正确"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！"),
    TOKEN_IS_ENPTY(false,10003,"token不能为空"),
    TOKEN_IS_EXPIRE(false,10004,"token已过期"),
    TOKEN_IS_EXCEPTION(false,10005,"解析token异常"),
    NO_AUTH(false,10006,"无权限访问"),

    ;
    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    ResultCode(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public boolean success() {
        return success;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }

}
