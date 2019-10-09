package com.nefeed.dingtalkrobot.config;

import com.alibaba.druid.util.StringUtils;
import com.nefeed.dingtalkrobot.service.CronService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;

/**
 * 动态定时任务
 *
 * @author nefeed@163.com
 * @version $Id: DynamicScheduleTask.java, v 0.1 2019年10月09日 7:53 下午 章华隽 Exp $
 */
@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamicScheduleTask.class);
    /**
     * 默认的cron按空格分隔长度
     */
    private static final int DEFAULT_CRON_LENGTH = 6;
    /**
     * 默认的cron配置
     */
    private static final String DEFAULT_CRON = "0 * * * * ?";

    @Autowired
    private CronService cronService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                () -> LOGGER.info("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                triggerContext -> {
                    String cron = cronService.findActiveCron();
                    if (StringUtils.isEmpty(cron)) {
                        LOGGER.error("无生效的定时任务执行配置!");
                        return new CronTrigger(DEFAULT_CRON).nextExecutionTime(triggerContext);
                    }
                    String[] temp = cron.split(" ");
                    if (temp.length != DEFAULT_CRON_LENGTH) {
                        LOGGER.error("定时任务配置格式有误!");
                        return new CronTrigger(DEFAULT_CRON).nextExecutionTime(triggerContext);
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}