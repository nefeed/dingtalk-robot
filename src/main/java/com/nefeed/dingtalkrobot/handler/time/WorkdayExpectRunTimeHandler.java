package com.nefeed.dingtalkrobot.handler.time;

import com.nefeed.dingtalkrobot.handler.base.BaseExpectRunTimeHandler;
import com.nefeed.dingtalkrobot.pojo.model.TaskSchedule;
import com.nefeed.dingtalkrobot.utils.HolidayUtil;

import java.io.IOException;
import java.util.Date;

/**
 * 工作日执行的时间处理器
 *
 * @author nefeed@163.com
 * @version $Id: WorkdayExpectRunTimeHandler.java, v 0.1 2019年10月12日 6:41 下午 章华隽 Exp $
 */
public class WorkdayExpectRunTimeHandler extends BaseExpectRunTimeHandler {
    @Override
    public Date calNextExpectRunTime(Date date, TaskSchedule taskSchedule) throws IOException {
        do {
            date = getNextDate(date, taskSchedule);
        } while (HolidayUtil.isHoliday(date));
        return date;
    }
}