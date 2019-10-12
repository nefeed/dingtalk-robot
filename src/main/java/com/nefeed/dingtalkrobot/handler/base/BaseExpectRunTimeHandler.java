package com.nefeed.dingtalkrobot.handler.base;

import com.nefeed.dingtalkrobot.pojo.model.TaskSchedule;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * 抽象的预期时间处理类
 *
 * @author nefeed@163.com
 * @version $Id: BaseExpectRunTimeHandler.java, v 0.1 2019年10月12日 6:33 下午 章华隽 Exp $
 */
public abstract class BaseExpectRunTimeHandler {

    /**
     * 计算下一个符合定时预期的时间
     *
     * @param date         日期
     * @param taskSchedule 定时规则
     * @return 符合预期的时间
     */
    public abstract Date calNextExpectRunTime(Date date, TaskSchedule taskSchedule) throws IOException;

    /**
     * 获取下一个符合定时预期的时间
     *
     * @param date         日期
     * @param taskSchedule 定时规则
     * @return 符合预期的时间
     */
    protected Date getNextDate(Date date, TaskSchedule taskSchedule) {
        if (taskSchedule.getCronExpression() == null) {
            // cron表达式构建异常, 则逐天计算合适时间
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DAY_OF_MONTH, 1);
            return c.getTime();
        } else {
            return taskSchedule.getCronExpression().getNextValidTimeAfter(date);
        }
    }
}