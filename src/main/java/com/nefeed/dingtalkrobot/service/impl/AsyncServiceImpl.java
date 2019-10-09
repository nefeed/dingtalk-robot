package com.nefeed.dingtalkrobot.service.impl;

import com.nefeed.dingtalkrobot.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步化服务实现
 *
 * @author nefeed@163.com
 * @version $Id: AsyncServiceImpl.java, v 0.1 2019年10月09日 10:30 上午 章华隽 Exp $
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        LOGGER.info("start executeAsync.");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("end executeAsync.");
    }
}