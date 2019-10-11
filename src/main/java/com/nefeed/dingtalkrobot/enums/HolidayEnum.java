package com.nefeed.dingtalkrobot.enums;

/**
 * 节假日枚举
 *
 * 0: 正常工作日
 * 1: 法定节假日
 * 2: 节假日调休补班
 * 3: 休息日
 * @author nefeed@163.com
 * @version $Id: HolidayEnum.java, v 0.1 2019年10月11日 7:51 下午 章华隽 Exp $
 */
public enum HolidayEnum {

    /**
     * 0: 正常工作日
     */
    NORMAL_WORKDAY(0,"NORMAL_WORKDAY", "normal workday"),
    /**
     * 1: 法定节假日
     */
    LEGAL_HOLIDAY(1,"LEGAL_HOLIDAY", "legal holiday"),
    /**
     * 2: 节假日调休补班
     */
    LEGAL_WORKDAY(2,"LEGAL_WORKDAY", "legal workday"),
    /**
     * 3: 休息日
     */
    NORMAL_HOLIDAY(3,"NORMAL_HOLIDAY", "normal holiday"),
    ;

    /**
     * value
     */
    private final Integer value;
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
    HolidayEnum(Integer value, String code, String description) {
        this.value = value;
        this.code = code;
        this.description = description;
    }

    /**
     * Getter method for property value.
     *
     * @return property value of value
     */
    public Integer getValue() {
        return value;
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
     * 通过枚举<code>value</code>获得枚举
     *
     * @param value 枚举值
     * @return HolidayEnum
     */
    public static HolidayEnum getByValue(Integer value) {
        for (HolidayEnum it : values()) {
            if (it.getValue().equals(value)) {
                return it;
            }
        }
        return null;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     *
     * @param code 枚举码
     * @return HolidayEnum
     */
    public static HolidayEnum getByCode(String code) {
        for (HolidayEnum it : values()) {
            if (it.getCode().equals(code)) {
                return it;
            }
        }
        return null;
    }
}