package com.nefeed.dingtalkrobot.service.impl;

import com.nefeed.dingtalkrobot.dao.RobotInfoMapper;
import com.nefeed.dingtalkrobot.entity.RobotInfo;
import com.nefeed.dingtalkrobot.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 机器人服务实现类
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:40
 */
@Service(value = "robotService")
public class RobotServiceImpl implements RobotService {

    @Autowired
    private RobotInfoMapper robotDao;

    @Override
    public RobotInfo findByKey(Integer key) {
        return robotDao.selectByPrimaryKey(key);
    }

    @Override
    public List<RobotInfo> findAllRobots(){
        return  robotDao.findAllRobots();
    }
}