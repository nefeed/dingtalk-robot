package com.nefeed.dingtalkrobot.enums;

/**
 * 操作事件码枚举
 *
 * @author nefeed@163.com
 * @version $Id: ActionLogEventEnum.java, v 0.1 2019年10月06日 12:21 下午 章华隽 Exp $
 */
public enum ActionLogEventEnum {

    /**
     * 用户登录
     */
    LOGIN("LOGIN", "用户登录"),
    /**
     * 注册
     */
    REGISTER("REGISTER", "用户注册"),
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
    ActionLogEventEnum(String code, String description) {
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
     * @return ActionLogEventEnum
     */
    public static ActionLogEventEnum getByCode(String code) {
        for (ActionLogEventEnum it : values()) {
            if (it.getCode().equals(code)) {
                return it;
            }
        }
        return null;
    }
}