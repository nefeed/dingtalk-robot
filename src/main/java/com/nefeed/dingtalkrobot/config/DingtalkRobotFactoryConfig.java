package com.nefeed.dingtalkrobot.config;

import com.nefeed.dingtalkrobot.enums.TaskScheduleTypeEnum;
import com.nefeed.dingtalkrobot.factory.DingtalkRobotHandlerFactory;
import com.nefeed.dingtalkrobot.handler.time.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * 应用的工厂类config
 *
 * @author nefeed@163.com
 * @version $Id: DingtalkRobotFactoryConfig.java, v 0.1 2019年10月12日 7:00 下午 章华隽 Exp $
 */
@Configuration
public class DingtalkRobotFactoryConfig {
    @Bean
    public DingtalkRobotHandlerFactory createDingtalkRobotHandlerFactory() {
        DingtalkRobotHandlerFactory dingtalkRobotHandlerFactory = new DingtalkRobotHandlerFactory();
        Objects.requireNonNull(dingtalkRobotHandlerFactory.getObject())
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.EVERYDAY,
                        new EverydayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandlerFactory.getObject())
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.WORKDAY,
                        new WorkdayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandlerFactory.getObject())
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.LAST_WORKDAY,
                        new LastWorkdayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandlerFactory.getObject())
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.HOLIDAY,
                        new HolidayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandlerFactory.getObject())
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.WEEKDAY,
                        new WeekdayExpectRunTimeHandler());
        Objects.requireNonNull(dingtalkRobotHandlerFactory.getObject())
                .putExpectRunTimeHandler(TaskScheduleTypeEnum.WEEKEND,
                        new WeekendExpectRunTimeHandler());
        return dingtalkRobotHandlerFactory;
    }
}