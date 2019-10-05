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
public interface IUserService {
    /**
     * 以主键查找对象
     *
     * @param key 主键
     *
     * @return 用户
     */
    UserInfo findByKey(Integer key);

    /**
     * 遍历所有对象
     *
     * @return 用户队列
     */
    List findAllUser();
}
