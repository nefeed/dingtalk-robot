package com.nefeed.dingtalkrobot.service;

import com.nefeed.dingtalkrobot.entity.UserInfo;

import java.util.List;

/**
 * 用户服务
 *
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:39
 */
public interface UserService {
    /**
     * 以主键查找对象
     *
     * @param key 主键
     * @return 用户
     */
    UserInfo findByKey(Integer key);

    /**
     * 遍历所有对象
     *
     * @return 用户队列
     */
    List<UserInfo> findAllUsers();

    /**
     * 根据账号查找用户
     */
    UserInfo findByAccount(String account);

    /**
     * 登录成功,更新用户
     *
     * @param userInfo 用户
     * @param ip       ip地址
     * @return 登录成功刷新的accessToken
     */
    String loginSuccess(UserInfo userInfo, String ip);
}
