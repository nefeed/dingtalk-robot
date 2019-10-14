package com.nefeed.dingtalkrobot.service;

import com.nefeed.dingtalkrobot.entity.TaskInfo;
import com.nefeed.dingtalkrobot.pojo.model.BizContext;

import java.io.IOException;
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
     *
     * @return 待执行的任务队列
     */
    List<TaskInfo> findStandbyTaskList();

    /**
     * 执行任务
     *
     * @param preBizContext 调用异步执行task的上下文信息
     * @param task          任务
     */
    void runTask(BizContext preBizContext, TaskInfo task);

    /**
     * 计算下次执行时间
     *
     * @param preExpectRunTime 上次执行时间
     * @param schedule         执行周期
     * @return 下次执行时间
     * @throws IOException IO异常
     */
    int calNextExpectRunTime(Integer preExpectRunTime, String schedule) throws IOException;
}