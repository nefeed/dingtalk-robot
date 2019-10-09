package com.nefeed.dingtalkrobot.service;

/**
 * 定时执行器服务
 *
 * @author nefeed@163.com
 * @version $Id: CronService.java, v 0.1 2019年10月09日 8:25 下午 章华隽 Exp $
 */
public interface CronService {

    /**
     * 查找最新生效的定时执行器配置
     * @return 定时执行器配置
     */
    String findActiveCron();
}