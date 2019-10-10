package com.nefeed.dingtalkrobot.service.impl;

import com.nefeed.dingtalkrobot.dao.TaskInfoMapper;
import com.nefeed.dingtalkrobot.entity.RobotInfo;
import com.nefeed.dingtalkrobot.entity.TaskInfo;
import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.pojo.model.BizContextHolder;
import com.nefeed.dingtalkrobot.service.RobotService;
import com.nefeed.dingtalkrobot.service.TaskService;
import com.nefeed.dingtalkrobot.utils.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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

    @Override
    public List<TaskInfo> findStandbyTaskList() {
        return taskDao.findStandbyTaskList(BizContextHolder.getUnixTimestamp());
    }

    @Override
    @Async("asyncServiceExecutor")
    public void runTask(TaskInfo task) {
        if (task.getRobotId() == null) {
            LogUtil.error(ActionLogEventEnum.RUN_TASK, "定时任务[%d]未绑定机器人.", task.getTaskId());
        }
        RobotInfo robot = robotService.findByKey(task.getRobotId());
        if (robot.getDel()) {
            LogUtil.error(ActionLogEventEnum.RUN_TASK, "机器人[%d]已禁用.", robot.getRobotId());
        }
    }
}