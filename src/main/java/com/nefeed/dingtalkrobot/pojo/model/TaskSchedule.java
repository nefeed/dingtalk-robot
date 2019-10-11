package com.nefeed.dingtalkrobot.pojo.model;

import com.nefeed.dingtalkrobot.enums.TaskScheduleTypeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 定时任务schedule对象
 *
 * @author nefeed@163.com
 * @version $Id: TaskSchedule.java, v 0.1 2019年10月11日 5:12 下午 章华隽 Exp $
 */
@Data
public class TaskSchedule implements Serializable {
    private static final long serialVersionUID = 7970918899712764984L;

    /**
     * 执行规则枚举
     */
    private TaskScheduleTypeEnum taskScheduleType;
    /** 某秒执行 */
    private Integer seconds;
    /** 某分钟执行 */
    private Integer minutes;
    /** 某小时执行 */
    private Integer hours;
    /** 月中某日执行 */
    private Integer dayOfMonth;
    /** 某月执行 */
    private Integer month;
    /** 星期中某日执行(0-7, 0和7都表示周日) */
    private Integer dayOfWeek;
    /** 某年执行 */
    private Integer year;

}