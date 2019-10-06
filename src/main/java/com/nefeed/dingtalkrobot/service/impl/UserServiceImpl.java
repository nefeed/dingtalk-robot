package com.nefeed.dingtalkrobot.service.impl;

import com.nefeed.dingtalkrobot.dao.UserInfoMapper;
import com.nefeed.dingtalkrobot.entity.UserInfo;
import com.nefeed.dingtalkrobot.pojo.model.BizContextHolder;
import com.nefeed.dingtalkrobot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * 用户服务实现
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:40
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userDao;

    @Override
    public UserInfo findByKey(Integer key) {
        return userDao.selectByPrimaryKey(key);
    }

    @Override
    public List<UserInfo> findAllUsers(){
        return  userDao.findAllUsers();
    }

    @Override
    public UserInfo findByAccount(String account) {
        return userDao.selectByAccount(account);
    }

    @Override
    public String loginSuccess(UserInfo userInfo, String ip) {
        int now = (int) (Objects.requireNonNull(BizContextHolder.getTime()).getTime() / 1000L);
        userInfo.setGmtModify(now);
        userInfo.setLastLoginTime(now);
        userInfo.setLastLoginIp(ip);
        String accessToken = UUID.randomUUID().toString();
        userInfo.setUserAccessToken(accessToken);
        userDao.updateByPrimaryKeySelective(userInfo);
        return accessToken;
    }
}