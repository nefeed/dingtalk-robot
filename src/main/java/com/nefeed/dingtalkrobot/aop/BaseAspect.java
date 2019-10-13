package com.nefeed.dingtalkrobot.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author nefeed@163.com
 * @version $Id: BaseAspect.java, v 0.1 2019年10月06日 12:43 下午 章华隽 Exp $
 */
public abstract class BaseAspect {
    protected Object process(ProceedingJoinPoint pjp, StringBuilder sb) throws Throwable {
        //获取连接点目标类名
        String targetName = pjp.getTarget().getClass().getName();
        //获取连接点签名的方法名
        String methodName = pjp.getSignature().getName();
        //获取连接点参数
        Object[] args = pjp.getArgs();
        //序列化时过滤掉request和response
        List<Object> logArgs = streamOf(args)
                .filter(arg -> (!(arg instanceof HttpServletRequest) && !(arg instanceof HttpServletResponse)))
                .collect(Collectors.toList());
        //根据连接点类的名字获取指定类
        Class targetClass = Class.forName(targetName);
        //获取类里面的方法
        Method[] methods = targetClass.getMethods();
        Object object = pjp.proceed();
        sb.append(targetClass.getCanonicalName())
                .append("#")
                .append(methodName)
                .append(", 请求参数: ")
                .append(JSON.toJSONString(logArgs))
                .append(", 返回参数: ")
                .append(object);
        return object;
    }

    private static <T> Stream<T> streamOf(T[] array) {
        return array == null || array.length == 0 ? Stream.empty() : Arrays.asList(array).stream();
    }
}