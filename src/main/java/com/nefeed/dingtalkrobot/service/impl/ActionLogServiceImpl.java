package com.nefeed.dingtalkrobot.service.impl;

import com.nefeed.dingtalkrobot.constants.DingtalkRobotConstants;
import com.nefeed.dingtalkrobot.dao.ActionLogMapper;
import com.nefeed.dingtalkrobot.entity.ActionLog;
import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 活动日志服务类
 *
 * @author nefeed@163.com
 * @version $Id: ActionLogServiceImpl.java, v 0.1 2019年10月16日 11:13 下午 章华隽 Exp $
 */
@Service("actionLogService")
public class ActionLogServiceImpl implements ActionLogService {

    @Autowired
    private ActionLogMapper actionLogDao;

    @Override
    @Async("asyncServiceExecutor")
    public void registerActionLog(ActionLogEventEnum event, Integer userId, Integer teamId, Integer robotId, String log) {

        ActionLog actionLog = new ActionLog();
        actionLog.setEvent(event.getCode());
        actionLog.setUserId(Optional.ofNullable(userId).orElse(DingtalkRobotConstants.SYSTEM_USER_ID));
        actionLog.setTeamId(teamId);
        actionLog.setRobotId(robotId);
        actionLog.setLog(log);
        int now = (int) (System.currentTimeMillis() / 1000L);
        actionLog.setGmtCreate(now);
        actionLog.setGmtModify(now);
        actionLog.setDel(false);
        actionLogDao.insert(actionLog);
    }
}