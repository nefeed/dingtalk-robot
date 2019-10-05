package com.nefeed.dingtalkrobot.service;

import com.nefeed.dingtalkrobot.dao.UserInfoMapper;
import com.nefeed.dingtalkrobot.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}