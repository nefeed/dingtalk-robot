package com.nefeed.dingtalkrobot.handler.base;

import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.utils.LogUtil;

import java.io.IOException;

/**
 * 抽象的机器人任务执行器
 *
 * @author nefeed@163.com
 * @version $Id: BaseExpectRunTimeHandler.java, v 0.1 2019年10月13日 6:33 下午 章华隽 Exp $
 */
public abstract class BaseRobotTaskHandler {

    /** 钉钉机器人请求的成功结果码 */
    protected static final Integer DINGTALK_ROBOT_SUCCESS_RESPONSE_ERRCODE = 0;

    /**
     * 执行机器人任务
     *
     * @param webhook 机器人webhook
     * @param params  请求参数
     * @return 执行结果
     */
    public abstract boolean runRobotTask(String webhook, String params) throws IOException;

    /**
     * 打印失败答应失败信息
     * @param errMsg 失败信息
     */
    protected void logErrMsg(String errMsg) {
        LogUtil.error(ActionLogEventEnum.RUN_TASK, "机器人任务执行失败，失败信息: %s.", errMsg);
    }

}