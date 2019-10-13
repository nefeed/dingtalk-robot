package com.nefeed.dingtalkrobot.handler.robot;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nefeed.dingtalkrobot.handler.base.BaseRobotTaskHandler;
import com.nefeed.dingtalkrobot.utils.HttpUtil;

import java.io.IOException;

/**
 * POST请求的机器人任务执行器
 *
 * @author nefeed@163.com
 * @version $Id: PostRobotTaskHandler.java, v 0.1 2019年10月13日 10:52 下午 章华隽 Exp $
 */
public class GetRobotTaskHandler extends BaseRobotTaskHandler {

    @Override
    public boolean runRobotTask(String webhook, String content) throws IOException {
        JSONObject params = JSON.parseObject(content);
        String response = HttpUtil.get(webhook, params);
        JSONObject responseData = JSON.parseObject(response);
        boolean result = DINGTALK_ROBOT_SUCCESS_RESPONSE_ERRCODE.equals(responseData.getInteger("errcode"));
        if (!result) {
            logErrMsg("机器人任务GET请求返回失败：" + response);
        }
        return result;
    }
}