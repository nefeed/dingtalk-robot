package com.nefeed.dingtalkrobot.enums;

/**
 * 机器人类型枚举
 *
 * @author nefeed@163.com
 * @version $Id: RobotTypeEnum.java, v 0.1 2019年10月13日 10:40 下午 章华隽 Exp $
 */
public enum RobotTypeEnum {

    /**
     * 直接以GET形式请求
     */
    GET("GET", "direct http get request."),
    /**
     * 直接以POST形式请求
     */
    POST("POST", "direct http post request."),
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
    RobotTypeEnum(String code, String description) {
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
     * @return RobotTypeEnum
     */
    public static RobotTypeEnum getByCode(String code) {
        for (RobotTypeEnum it : values()) {
            if (it.getCode().equals(code)) {
                return it;
            }
        }
        return null;
    }
}