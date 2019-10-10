package com.nefeed.dingtalkrobot.service;

import com.nefeed.dingtalkrobot.entity.TaskInfo;

import java.util.List;

/**
 * 任务服务
 *
 * @author nefeed@163.com
 * @version $Id: TaskService.java, v 0.1 2019年10月10日 3:28 下午 章华隽 Exp $
 */
public interface TaskService {

    /**
     * 查找所有待执行的任务
     * @return 待执行的任务队列
     */
    List<TaskInfo> findStandbyTaskList();

    /**
     * 执行任务
     * @param task 任务
     */
    void runTask(TaskInfo task);
}