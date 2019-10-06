package com.nefeed.dingtalkrobot.aop;

import com.nefeed.dingtalkrobot.pojo.model.BizContext;
import com.nefeed.dingtalkrobot.pojo.model.BizContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 接口切面
 *
 * @author nefeed@163.com
 * @version $Id: ControllerAspect.java, v 0.1 2019年10月06日 1:00 下午 章华隽 Exp $
 */
@Aspect
@Component
@Slf4j
public class ControllerAspect extends BaseAspect {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);
    @Pointcut("execution(* com.nefeed.dingtalkrobot.controller.*.*(..))")
    public void Pointcut() {
    }
    @Around("Pointcut()")
    public Object Around(ProceedingJoinPoint pjp) throws Throwable {
        StringBuilder sb = new StringBuilder();
        BizContextHolder.set(new BizContext());
        Object result;
        try {
            result = process(pjp, sb);
        } finally {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("controller aspect result: " + sb.toString());
            }
            BizContextHolder.clear();
        }
        return result;
    }
}