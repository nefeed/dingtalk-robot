package com.nefeed.dingtalkrobot.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 服务切面
 *
 * @author nefeed@163.com
 * @version $Id: ServiceAspect.java, v 0.1 2019年10月06日 1:04 下午 章华隽 Exp $
 */
@Aspect
@Component
@Slf4j
public class ServiceAspect extends BaseAspect{
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceAspect.class);
    @Pointcut("execution(* com.nefeed.dingtalkrobot.service.impl.*.*(..))")
    public void Pointcut() {
    }
    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        StringBuilder sb = new StringBuilder();
        Object object = process(pjp, sb);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("service aspect result: " + sb.toString());
        }
        return object;
    }
}