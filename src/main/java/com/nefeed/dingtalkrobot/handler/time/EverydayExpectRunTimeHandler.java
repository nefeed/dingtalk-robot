package com.nefeed.dingtalkrobot.handler.time;

import com.nefeed.dingtalkrobot.handler.base.BaseExpectRunTimeHandler;
import com.nefeed.dingtalkrobot.pojo.model.TaskSchedule;

import java.util.Date;

/**
 * 每天执行的时间处理器
 *
 * @author nefeed@163.com
 * @version $Id: EverydayExpectRunTimeHandler.java, v 0.1 2019年10月12日 6:39 下午 章华隽 Exp $
 */
public class EverydayExpectRunTimeHandler extends BaseExpectRunTimeHandler {
    @Override
    public Date calNextExpectRunTime(Date date, TaskSchedule taskSchedule) {
        return getNextDate(date, taskSchedule);
    }
}