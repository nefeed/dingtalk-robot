package com.nefeed.dingtalkrobot.service;

import com.nefeed.dingtalkrobot.entity.RobotInfo;

import java.util.List;

/**
 * 用户服务
 *
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:39
 */
public interface RobotService {
    /**
     * 以主键查找对象
     *
     * @param key 主键
     *
     * @return 机器人
     */
    RobotInfo findByKey(Integer key);

    /**
     * 遍历所有机器人
     *
     * @return 机器人队列
     */
    List<RobotInfo> findAllRobots();
}
