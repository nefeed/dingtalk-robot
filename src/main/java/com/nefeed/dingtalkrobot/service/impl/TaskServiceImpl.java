package com.nefeed.dingtalkrobot.service.impl;

import com.nefeed.dingtalkrobot.dao.TaskInfoMapper;
import com.nefeed.dingtalkrobot.entity.RobotInfo;
import com.nefeed.dingtalkrobot.entity.TaskInfo;
import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.handler.DingtalkRobotHandler;
import com.nefeed.dingtalkrobot.pojo.model.BizContext;
import com.nefeed.dingtalkrobot.pojo.model.BizContextHolder;
import com.nefeed.dingtalkrobot.pojo.model.TaskSchedule;
import com.nefeed.dingtalkrobot.service.RobotService;
import com.nefeed.dingtalkrobot.service.TaskService;
import com.nefeed.dingtalkrobot.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 定时任务服务实现类
 *
 * @author nefeed@163.com
 * @version $Id: TaskServiceImpl.java, v 0.1 2019年10月10日 7:35 下午 章华隽 Exp $
 */
@Service(value = "taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskInfoMapper taskDao;
    @Autowired
    private RobotService robotService;
    @Autowired
    private DingtalkRobotHandler dingtalkRobotHandler;

    @Override
    public List<TaskInfo> findStandbyTaskList() {
        return taskDao.findStandbyTaskList(BizContextHolder.getUnixTimestamp());
    }

    @Override
    @Async("asyncServiceExecutor")
    public void runTask(BizContext preBizContext, TaskInfo task) {
        BizContextHolder.set(preBizContext);
        if (task.getRobotId() == null) {
            LogUtil.error(ActionLogEventEnum.RUN_TASK, "定时任务[%d]未绑定机器人.", task.getTaskId());
        }
        RobotInfo robot = robotService.findByKey(task.getRobotId());
        if (robot.getDel()) {
            LogUtil.warn(ActionLogEventEnum.RUN_TASK, "定时任务[%d]仍生效, 但机器人[%d]已禁用.", task.getTaskId(), robot.getRobotId());
        }
        try {
            boolean result = dingtalkRobotHandler.runRobotTask(robot, task.getTaskContent());
            if (!result) {
                LogUtil.error(ActionLogEventEnum.RUN_TASK, "定时任务[%d]执行机器人[%d]任务失败.", task.getTaskId(), robot.getRobotId());
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.error(ActionLogEventEnum.RUN_TASK, "定时任务[%d]执行机器人[%d]任务IO网络处理失败，失败原因: %s.", task.getTaskId(), robot.getRobotId(), e.toString());
            return;
        }

        afterRunTask(task);
    }

    /**
     * 执行定时任务后,更新定时任务信息
     *
     * @param task 定时任务
     */
    private void afterRunTask(TaskInfo task) {
        task.setRunTimes(task.getRunTimes() + 1);
        try {
            task.setExpectRunTime(calNextExpectRunTime(BizContextHolder.getTime(), task.getSchedule()));
        } catch (IOException e) {
            e.printStackTrace();
            LogUtil.error(ActionLogEventEnum.RUN_TASK, "定时任务[%d]计算下次执行时间失败, e: %s.", task.getTaskId(), e.toString());
            // 加上3分钟buffer, 避免过分打扰
            task.setExpectRunTime(task.getExpectRunTime() + 180);
        }
        task.setGmtModify(BizContextHolder.getUnixTimestamp());
        taskDao.updateByPrimaryKeySelective(task);
    }

    /**
     * 计算下次执行时间
     *
     * @param date             计算的起始时间
     * @param schedule         执行周期
     * @return 下次执行时间
     * @throws IOException IO异常
     */
    private int calNextExpectRunTime(Date date, String schedule) throws IOException {

        TaskSchedule taskSchedule = new TaskSchedule(schedule);
        date = dingtalkRobotHandler.calNextExpectRunTime(taskSchedule, date);
        return (int) (date.getTime() / 1000L);
    }

    /**
     * 计算下次执行时间
     *
     * @param preExpectRunTime 上次执行时间
     * @param schedule         执行周期
     * @return 下次执行时间
     * @throws IOException IO异常
     */
    @Override
    public int calNextExpectRunTime(Integer preExpectRunTime, String schedule) throws IOException {
        Date date = new Date(preExpectRunTime * 1000L);
        return calNextExpectRunTime(date, schedule);
    }

    private Date getNextDate(Date date, TaskSchedule taskSchedule) {
        if (taskSchedule.getCronExpression() == null) {
            // cron表达式构建异常, 则逐天计算合适时间
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DAY_OF_MONTH, 1);
            return c.getTime();
        } else {
            return taskSchedule.getCronExpression().getNextValidTimeAfter(date);
        }
    }
}