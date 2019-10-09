package com.nefeed.dingtalkrobot.service.impl;

import com.nefeed.dingtalkrobot.dao.CronInfoMapper;
import com.nefeed.dingtalkrobot.entity.CronInfo;
import com.nefeed.dingtalkrobot.service.CronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 定时执行器服务实现
 *
 * @author nefeed@163.com
 * @version $Id: CronServiceImpl.java, v 0.1 2019年10月09日 8:26 下午 章华隽 Exp $
 */
@Service("cronService")
public class CronServiceImpl implements CronService {

    @Autowired
    private CronInfoMapper cronDao;

    @Override
    public String findActiveCron() {
        CronInfo cronInfo = cronDao.findActiveOne();
        return Optional.ofNullable(cronInfo).orElse(new CronInfo()).getCron();
    }
}