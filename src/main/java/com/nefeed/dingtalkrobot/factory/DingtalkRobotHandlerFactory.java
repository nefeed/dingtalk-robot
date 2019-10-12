package com.nefeed.dingtalkrobot.factory;

import com.nefeed.dingtalkrobot.enums.TaskScheduleTypeEnum;
import com.nefeed.dingtalkrobot.handler.DingtalkRobotHandler;
import com.nefeed.dingtalkrobot.handler.time.*;
import org.springframework.beans.factory.FactoryBean;

import java.util.Objects;

/**
 * 预期执行时间的执行器工厂
 *
 * @author nefeed@163.com
 * @version $Id: DingtalkRobotHandlerFactory.java, v 0.1 2019年10月12日 6:52 下午 章华隽 Exp $
 */
public class DingtalkRobotHandlerFactory implements FactoryBean<DingtalkRobotHandler> {
    @Override
    public DingtalkRobotHandler getObject() {
        DingtalkRobotHandler dingtalkRobotHandler = new DingtalkRobotHandler();
        Objects.requireNonNull(dingtalkRobotHandler)
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.EVERYDAY,
                        new EverydayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandler)
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.WORKDAY,
                        new WorkdayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandler)
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.LAST_WORKDAY,
                        new LastWorkdayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandler)
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.HOLIDAY,
                        new HolidayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandler)
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.WEEKDAY,
                        new WeekdayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandler)
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.WEEKEND,
                        new WeekendExpectRunTimeHandler());
        return dingtalkRobotHandler;
    }

    @Override
    public Class<?> getObjectType() {
        return DingtalkRobotHandler.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}