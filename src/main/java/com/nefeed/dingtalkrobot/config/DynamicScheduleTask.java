package com.nefeed.dingtalkrobot.config;

import com.alibaba.druid.util.StringUtils;
import com.nefeed.dingtalkrobot.entity.TaskInfo;
import com.nefeed.dingtalkrobot.pojo.model.BizContext;
import com.nefeed.dingtalkrobot.pojo.model.BizContextHolder;
import com.nefeed.dingtalkrobot.service.CronService;
import com.nefeed.dingtalkrobot.service.TaskService;
import com.nefeed.dingtalkrobot.utils.DateUtil;
import com.nefeed.dingtalkrobot.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

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
    private static final Logger LOGGER_SCHEDULE_TASK = LoggerFactory.getLogger("SCHEDULE-TASK");
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
    @Autowired
    private TaskService taskService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                () -> {
                    BizContextHolder.set(new BizContext());
                    LogUtil.info(LOGGER_SCHEDULE_TASK, "Begin 执行动态定时任务.[%s]", DateUtil.parseDate(BizContextHolder.getTime()));
                    runScheduleTask();
                    LogUtil.info(LOGGER_SCHEDULE_TASK, "End 执行动态定时任务.[%s]", DateUtil.parseDate(new Date()));
                },
                triggerContext -> {
                    String cron = cronService.findActiveCron();
                    if (StringUtils.isEmpty(cron)) {
                        LOGGER_SCHEDULE_TASK.error("无生效的定时任务执行配置!");
                        return new CronTrigger(DEFAULT_CRON).nextExecutionTime(triggerContext);
                    }
                    String[] temp = cron.split(" ");
                    if (temp.length != DEFAULT_CRON_LENGTH) {
                        LOGGER_SCHEDULE_TASK.error("定时任务配置格式有误!");
                        return new CronTrigger(DEFAULT_CRON).nextExecutionTime(triggerContext);
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

    /**
     * 执行设定的定时任务
     */
    private void runScheduleTask() {
        List<TaskInfo> standByTaskList = taskService.findStandbyTaskList();
        if (CollectionUtils.isEmpty(standByTaskList)) {
            LogUtil.warn(LOGGER_SCHEDULE_TASK, "没有需要执行的定时任务!");
            return;
        }
        standByTaskList.forEach(it -> taskService.runTask(BizContextHolder.get(), it));
    }
}