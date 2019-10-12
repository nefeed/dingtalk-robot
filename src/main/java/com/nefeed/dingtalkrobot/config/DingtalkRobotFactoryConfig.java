package com.nefeed.dingtalkrobot.config;

import com.nefeed.dingtalkrobot.factory.DingtalkRobotHandlerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 应用的工厂类config
 *
 * @author nefeed@163.com
 * @version $Id: DingtalkRobotFactoryConfig.java, v 0.1 2019年10月12日 7:00 下午 章华隽 Exp $
 */
@Configuration
public class DingtalkRobotFactoryConfig {
    @Bean
    public DingtalkRobotHandlerFactory createDingtalkRobotHandlerFactory() {
        return new DingtalkRobotHandlerFactory();
    }
}