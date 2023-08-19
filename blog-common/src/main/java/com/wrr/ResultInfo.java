package com.wrr;

public enum ResultInfo {
    ACCESS_DENIED("403","权限不足"),
    LOGIN_SUCCESS("666","登陆成功"),
    LOGIN_FAIL("777","登陆失败"),
    LOGOUT_SUCCESS("111","退出成功"),
    NOT_FOUND("404","没有找到"),
    SUCCESS("200","操作成功"),
    GLOBAL_ERROR("101","系统繁忙")
    ;

    private String code;
    private String message;

    ResultInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
