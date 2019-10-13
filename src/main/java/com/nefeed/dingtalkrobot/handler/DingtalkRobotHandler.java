package com.nefeed.dingtalkrobot.handler;

import com.nefeed.dingtalkrobot.entity.RobotInfo;
import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.enums.RobotTypeEnum;
import com.nefeed.dingtalkrobot.enums.TaskScheduleTypeEnum;
import com.nefeed.dingtalkrobot.handler.base.BaseExpectRunTimeHandler;
import com.nefeed.dingtalkrobot.handler.base.BaseRobotTaskHandler;
import com.nefeed.dingtalkrobot.pojo.model.TaskSchedule;
import com.nefeed.dingtalkrobot.utils.LogUtil;
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
    /** 机器人类型的执行器 */
    private Map<RobotTypeEnum, BaseRobotTaskHandler> robotTaskHandlerMap;

    public DingtalkRobotHandler() {
        this.expectRunTimeHandlerMap = new HashMap<>(16);
        this.robotTaskHandlerMap = new HashMap<>(16);
    }

    public void putExpectRunTimeHandler(TaskScheduleTypeEnum taskScheduleTypeEnum,
                                        BaseExpectRunTimeHandler handler) {
        this.expectRunTimeHandlerMap.put(taskScheduleTypeEnum, handler);
    }

    public BaseExpectRunTimeHandler getExpectRunTimeHandler(TaskScheduleTypeEnum taskScheduleTypeEnum) {
        if (!expectRunTimeHandlerMap.containsKey(taskScheduleTypeEnum)) {
            // 默认返回每天的执行器
            LogUtil.warn(ActionLogEventEnum.RUN_TASK, "未发现[%s]的预期执行时间执行器, 以Everyday默认执行.", taskScheduleTypeEnum);
            taskScheduleTypeEnum = TaskScheduleTypeEnum.EVERYDAY;
        }
        return this.expectRunTimeHandlerMap.get(taskScheduleTypeEnum);
    }

    public void putRobotTaskHandler(RobotTypeEnum robotTypeEnum,
                                    BaseRobotTaskHandler handler) {
        this.robotTaskHandlerMap.put(robotTypeEnum, handler);
    }

    public BaseRobotTaskHandler getRobotTaskHandler(RobotTypeEnum robotTypeEnum) {
        if (!robotTaskHandlerMap.containsKey(robotTypeEnum)) {
            // 默认返回POST
            LogUtil.warn(ActionLogEventEnum.RUN_TASK, "未发现[%s]的机器人任务执行器, 以POST默认执行.", robotTypeEnum);
            robotTypeEnum = RobotTypeEnum.POST;
        }
        return this.robotTaskHandlerMap.get(robotTypeEnum);
    }

    /**
     * 计算下一个符合定时预期的时间
     *
     * @param taskSchedule 定时规则
     * @param date         日期
     * @return 符合预期的时间
     */
    public Date calNextExpectRunTime(TaskSchedule taskSchedule, Date date) throws IOException {
        if (date == null || taskSchedule == null) {
            return new Date();
        }
        return getExpectRunTimeHandler(taskSchedule.getTaskScheduleType()).calNextExpectRunTime(date, taskSchedule);
    }

    /**
     * 执行机器人的任务
     * @param robot 机器人
     * @param taskContent 任务内容
     */
    public boolean runRobotTask(RobotInfo robot, String taskContent) throws IOException {
        if (robot == null) {
            return false;
        }
        RobotTypeEnum robotTypeEnum = RobotTypeEnum.getByCode(robot.getType());
        return getRobotTaskHandler(robotTypeEnum).runRobotTask(robot.getWebhook(), taskContent);
    }
}