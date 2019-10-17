package com.nefeed.dingtalkrobot.service;

import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;

/**
 * 活动日志服务
 *
 * @author nefeed@163.com
 * @version $Id: ActionLogService.java, v 0.1 2019年10月16日 11:11 下午 章华隽 Exp $
 */
public interface ActionLogService {

    /**
     * 注册活动日志
     *
     * @param event   事件
     * @param userId  用户id
     * @param teamId  团队id
     * @param robotId 机器人id
     * @param log     日志内容
     */
    void registerActionLog(ActionLogEventEnum event, Integer userId, Integer teamId,
                           Integer robotId, String log);
}