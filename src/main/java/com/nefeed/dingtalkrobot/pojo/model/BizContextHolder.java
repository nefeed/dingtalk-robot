package com.nefeed.dingtalkrobot.pojo.model;

import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;

import java.util.Date;
import java.util.Map;

/**
 * 线程上下文
 *
 * @author nefeed@163.com
 * @version $Id: ThreadContent.java, v 0.1 2019年10月06日 12:32 下午 章华隽 Exp $
 */
public class BizContextHolder {

    /**
     * 当前线程
     */
    private static ThreadLocal<BizContext> contextLocal = new ThreadLocal<>();

    /**
     * 获取当前线程上下文
     */
    public static BizContext get() {
        return contextLocal.get();
    }

    /**
     * 获取当前线程上下文
     */
    public static void set(BizContext bizContext) {
        contextLocal.set(bizContext);
    }

    /**
     * 清空上下文
     */
    public static void clear() {
        if (null == get()) {
            return;
        }
        contextLocal.remove();
    }

    /**
     * traceId
     *
     * @return traceId
     */
    public static String getTraceId() {
        if (null == get()) {
            return null;
        }
        return get().getTraceId();
    }

    /**
     * 系统时间
     *
     * @return 系统时间
     */
    public static Date getTime() {
        if (null == get()) {
            return null;
        }
        return get().getTime();
    }

    /**
     * 操作类型
     *
     * @return 操作类型
     */
    public static ActionLogEventEnum getEvent() {
        if (null == get()) {
            return null;
        }
        return get().getEvent();
    }

    /**
     * map对象
     *
     * @return Map对象
     */
    public static Map<String, Object> getContext() {
        if (null == get()) {
            return null;
        }
        return get().getContext();
    }

    /**
     * 插入对象
     *
     * @return 操作类型
     */
    public static void putObject(String key, Object obj) throws Exception {
        if (null == get()) {
            throw new Exception("threadLocal don`t exists bizContext");
        }
        get().getContext().put(key, obj);
    }

    /**
     * 插入对象
     *
     * @return 操作类型
     */
    public static Object getObject(String key) throws Exception {
        if (null == get()) {
            throw new Exception("threadLocal don`t exists bizContext");
        }
        return get().getContext().get(key);
    }
}