package com.nefeed.dingtalkrobot.utils;

import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.pojo.model.BizContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日志工具类
 *
 * @author nefeed@163.com
 * @version $Id: LogUtil.java, v 0.1 2019年10月06日 12:23 下午 章华隽 Exp $
 */
public class LogUtil {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger("BIZ-SERVICE");

    /**
     * 通用日志
     *
     *
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void info(ActionLogEventEnum actionLogEvent, String content, String... args) {
        LOGGER.info("({}),({}),([{}]{}),(" + content, ")", BizContextHolder.getTraceId(), actionLogEvent.getCode(), actionLogEvent.getDescription(), args);
    }

    /**
     * 警告日志
     *
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void warn(ActionLogEventEnum actionLogEvent, String content, String... args) {
        LOGGER.warn("({}),({}),([{}]{}),(" + content, ")", BizContextHolder.getTraceId(), actionLogEvent.getCode(), actionLogEvent.getDescription(), args);
    }

    /**
     * 错误日志
     *
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void error(ActionLogEventEnum actionLogEvent, String content, String... args) {
        LOGGER.error("({}),({}),([{}]{}),(" + content, ")", BizContextHolder.getTraceId(), actionLogEvent.getCode(), actionLogEvent.getDescription(), args);
    }

    /**
     * 调试日志
     *
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void debug(ActionLogEventEnum actionLogEvent, String content, String... args) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("({}),({}),([{}]{}),(" + content, ")", BizContextHolder.getTraceId(), actionLogEvent.getCode(), actionLogEvent.getDescription(), args);
        }
    }
}