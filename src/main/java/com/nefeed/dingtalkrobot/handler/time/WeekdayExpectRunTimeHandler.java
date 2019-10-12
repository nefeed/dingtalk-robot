package com.nefeed.dingtalkrobot.handler.time;

import com.nefeed.dingtalkrobot.handler.base.BaseExpectRunTimeHandler;
import com.nefeed.dingtalkrobot.pojo.model.TaskSchedule;
import com.nefeed.dingtalkrobot.utils.HolidayUtil;

import java.io.IOException;
import java.util.Date;

/**
 * 非周末执行的时间处理器
 *
 * @author nefeed@163.com
 * @version $Id: WeekdayExpectRunTimeHandler.java, v 0.1 2019年10月12日 6:44 下午 章华隽 Exp $
 */
public class WeekdayExpectRunTimeHandler extends BaseExpectRunTimeHandler {
    @Override
    public Date calNextExpectRunTime(Date date, TaskSchedule taskSchedule) throws IOException {
        do {
            date = getNextDate(date, taskSchedule);
        } while (HolidayUtil.isWeekend(date));
        return date;
    }
}