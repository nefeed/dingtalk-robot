package com.nefeed.dingtalkrobot.factory;

import com.nefeed.dingtalkrobot.handler.DingtalkRobotHandler;
import org.springframework.beans.factory.FactoryBean;

/**
 * 预期执行时间的执行器工厂
 *
 * @author nefeed@163.com
 * @version $Id: DingtalkRobotHandlerFactory.java, v 0.1 2019年10月12日 6:52 下午 章华隽 Exp $
 */
public class DingtalkRobotHandlerFactory implements FactoryBean<DingtalkRobotHandler> {
    @Override
    public DingtalkRobotHandler getObject() {
        return new DingtalkRobotHandler();
    }

    @Override
    public Class<?> getObjectType() {
        return DingtalkRobotHandler.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}