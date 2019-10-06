package com.nefeed.dingtalkrobot.enums;

/**
 * 返回码枚举
 *
 * @author nefeed@163.com
 * @version $Id: ResultCodeEnum.java, v 0.1 2019年10月06日 12:00 下午 章华隽 Exp $
 */
public enum ResultCodeEnum {

    /**
     * 成功
     */
    SUCCESS("SUCCESS", "success."),
    /**
     * 系统异常
     */
    SYSTEM_ERROR("SYSTEM_ERROR", "system error."),
    /**
     * 未知异常
     */
    UNKNOWN_EXCEPTION("UNKNOWN_EXCEPTION", "unknown exception."),
    /**
     * 账号不存在
     */
    ACCOUNT_NOT_EXISTS("ACCOUNT_NOT_EXISTS", "account not exists."),
    /**
     * 密码错误
     */
    WRONG_PASSWORD("WRONG_PASSWORD", "wrong password."),
    ;

    /**
     * 枚举码
     */
    private final String code;
    /**
     * 说明
     */
    private final String description;

    /**
     * 私有构造函数
     *
     * @param code        枚举码
     * @param description 说明
     */
    ResultCodeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * Getter method for property <tt>code</tt>.
     *
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>description</tt>.
     *
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code 枚举码
     * @return ResultCodeEnum
     */
    public static ResultCodeEnum getByCode(String code) {
        for (ResultCodeEnum it : values()) {
            if (it.getCode().equals(code)) {
                return it;
            }
        }
        return null;
    }
}