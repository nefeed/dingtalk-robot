package com.nefeed.dingtalkrobot.service;

import com.nefeed.dingtalkrobot.entity.TeamInfo;

import java.util.List;

/**
 * 团队服务
 *
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:39
 */
public interface TeamService {
    /**
     * 以主键查找对象
     *
     * @param key 主键
     *
     * @return 团队
     */
    TeamInfo findByKey(Integer key);

    /**
     * 遍历所有团队
     *
     * @return 用户队列
     */
    List<TeamInfo> findAllTeams();
}
