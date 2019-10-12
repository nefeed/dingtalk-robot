package com.nefeed.dingtalkrobot.handler;

import com.nefeed.dingtalkrobot.enums.TaskScheduleTypeEnum;
import com.nefeed.dingtalkrobot.handler.base.BaseExpectRunTimeHandler;
import com.nefeed.dingtalkrobot.pojo.model.TaskSchedule;
import lombok.Data;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 钉钉机器人后台App的执行器
 *
 * @author nefeed@163.com
 * @version $Id: DingtalkRobotHandler.java, v 0.1 2019年10月12日 6:55 下午 章华隽 Exp $
 */
@Data
public class DingtalkRobotHandler {

    /** 预期执行时间的处理器 */
    private Map<TaskScheduleTypeEnum, BaseExpectRunTimeHandler> expectRunTimeHandlerMap;

    public DingtalkRobotHandler() {
        this.expectRunTimeHandlerMap = new HashMap<>(16);
    }

    public void putExpectRunTimeHandler(TaskScheduleTypeEnum taskScheduleTypeEnum,
                                        BaseExpectRunTimeHandler handler) {
        this.expectRunTimeHandlerMap.put(taskScheduleTypeEnum, handler);
    }

    public BaseExpectRunTimeHandler getExpectRunTimeHandler(TaskScheduleTypeEnum taskScheduleTypeEnum) {
        if (!expectRunTimeHandlerMap.containsKey(taskScheduleTypeEnum)) {
            // 默认返回每天的执行器
            taskScheduleTypeEnum = TaskScheduleTypeEnum.EVERYDAY;
        }
        return this.expectRunTimeHandlerMap.get(taskScheduleTypeEnum);
    }

    /**
     * 计算下一个符合定时预期的时间
     *
     * @param date         日期
     * @param taskSchedule 定时规则
     * @return 符合预期的时间
     */
    public Date calNextExpectRunTime(Date date, TaskSchedule taskSchedule) throws IOException {
        if (date == null || taskSchedule == null) {
            return new Date();
        }
        return getExpectRunTimeHandler(taskSchedule.getTaskScheduleType()).calNextExpectRunTime(date, taskSchedule);
    }
}