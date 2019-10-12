package com.nefeed.dingtalkrobot.pojo.model;

import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.enums.TaskScheduleTypeEnum;
import com.nefeed.dingtalkrobot.utils.LogUtil;
import lombok.Data;
import org.apache.logging.log4j.core.util.CronExpression;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Optional;

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
    private String seconds;
    /** 某分钟执行 */
    private String minutes;
    /** 某小时执行 */
    private String hours;
    /** 月中某日执行 */
    private String dayOfMonth;
    /** 某月执行 */
    private String month;
    /** 星期中某日执行(0-7, 0和7都表示周日) */
    private String dayOfWeek;
    /** crontab表达式(* * * * * ?) 秒 分钟 小时 天 月 星期 */
    private String crontab;
    /** crontab解析类 */
    private CronExpression cronExpression;

    public TaskSchedule() {
    }

    public TaskSchedule(String schedule) {
        String[] temp = schedule.split(" ");
        String[] arr = Arrays.copyOf(temp, 7);
        this.taskScheduleType = Optional.ofNullable(TaskScheduleTypeEnum.getByCode(arr[0])).orElse(TaskScheduleTypeEnum.EVERYDAY);
        this.seconds = arr[1];
        this.minutes = arr[2];
        this.hours = arr[3];
        this.dayOfMonth = arr[4];
        this.month = arr[5];
        this.dayOfWeek = arr[6];
        this.crontab = schedule.substring(schedule.indexOf(" ") + 1);
        try {
            this.cronExpression = new CronExpression(this.crontab);
        } catch (ParseException e) {
            e.printStackTrace();
            LogUtil.error(ActionLogEventEnum.RUN_TASK, "schedule: [%s], 解析crontab失败!", schedule);
        }
    }
}