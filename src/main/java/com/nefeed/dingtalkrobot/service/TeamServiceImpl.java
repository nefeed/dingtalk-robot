package com.nefeed.dingtalkrobot.service;

import com.nefeed.dingtalkrobot.dao.TeamInfoMapper;
import com.nefeed.dingtalkrobot.entity.TeamInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 团队服务实现类
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:40
 */
@Service(value = "teamService")
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamInfoMapper teamDao;

    @Override
    public TeamInfo findByKey(Integer key) {
        return teamDao.selectByPrimaryKey(key);
    }

    @Override
    public List<TeamInfo> findAllTeams(){
        return  teamDao.findAllTeams();
    }
}