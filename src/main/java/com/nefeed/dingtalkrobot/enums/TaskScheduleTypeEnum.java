package com.nefeed.dingtalkrobot.enums;

/**
 * 定时任务schedule枚举
 *
 * @author nefeed@163.com
 * @version $Id: TaskScheduleTypeEnum.java, v 0.1 2019年10月11日 5:13 下午 章华隽 Exp $
 */
public enum TaskScheduleTypeEnum {

    /**
     * 每天执行
     */
    EVERYDAY("EVERYDAY", "everyday run task."),
    /**
     * 工作日执行
     */
    WORKDAY("WORKDAY", "only workday run task."),
    /**
     * 最后一个工作日(昨天和今天是工作日, 明天是休息日)
     */
    LAST_WORKDAY("LAST_WORKDAY", "yesterday and today is workday, and tomorrow is holiday."),
    /**
     * 假日执行
     */
    HOLIDAY("HOLIDAY", "only holiday run task."),
    /**
     * 周一到周五执行
     */
    WEEKDAY("WEEKDAY", "only weekday(1-5) run task."),
    /**
     * 周末执行
     */
    WEEKEND("WEEKEND", "only weekend(6-7) run task."),
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
    TaskScheduleTypeEnum(String code, String description) {
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
     * @return TaskScheduleTypeEnum
     */
    public static TaskScheduleTypeEnum getByCode(String code) {
        for (TaskScheduleTypeEnum it : values()) {
            if (it.getCode().equals(code)) {
                return it;
            }
        }
        return null;
    }
}