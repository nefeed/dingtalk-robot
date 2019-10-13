package com.nefeed.dingtalkrobot.factory;

import com.nefeed.dingtalkrobot.enums.RobotTypeEnum;
import com.nefeed.dingtalkrobot.enums.TaskScheduleTypeEnum;
import com.nefeed.dingtalkrobot.handler.DingtalkRobotHandler;
import com.nefeed.dingtalkrobot.handler.robot.GetRobotTaskHandler;
import com.nefeed.dingtalkrobot.handler.robot.PostRobotTaskHandler;
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
        // 填充预期执行时间计算执行器
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

        // 填充机器人任务执行器
        Objects.requireNonNull(dingtalkRobotHandler)
                .putRobotTaskHandler(RobotTypeEnum.GET,
                        new GetRobotTaskHandler());
        Objects.requireNonNull(dingtalkRobotHandler)
                .putRobotTaskHandler(RobotTypeEnum.POST,
                        new PostRobotTaskHandler());
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