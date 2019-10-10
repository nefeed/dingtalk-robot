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

    /**
     * logger
     */
    private static final Logger LOGGER_BIZ_SERVICE = LoggerFactory.getLogger("BIZ-SERVICE");

    /**
     * 通用日志
     *
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void info(ActionLogEventEnum actionLogEvent, String content, Object... args) {
        info(LOGGER_BIZ_SERVICE, actionLogEvent, content, args);
    }

    /**
     * 通用日志
     *
     * @param logger         日志对象
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void info(Logger logger, ActionLogEventEnum actionLogEvent, String content, Object... args) {
        logger.info("({}),([{}]{}),({})", BizContextHolder.getTraceId(), actionLogEvent.getCode(), actionLogEvent.getDescription(), formatContent(content, args));
    }

    /**
     * 通用日志
     *
     * @param logger  日志对象
     * @param content 日志内容
     * @param args    替换字符
     */
    public static void info(Logger logger, String content, Object... args) {
        logger.info("({}),({})", BizContextHolder.getTraceId(), formatContent(content, args));
    }

    /**
     * 警告日志
     *
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void warn(ActionLogEventEnum actionLogEvent, String content, Object... args) {
        warn(LOGGER_BIZ_SERVICE, actionLogEvent, content, args);
    }

    /**
     * 警告日志
     *
     * @param logger         日志对象
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void warn(Logger logger, ActionLogEventEnum actionLogEvent, String content, Object... args) {
        logger.warn("({}),([{}]{}),({})", BizContextHolder.getTraceId(), actionLogEvent.getCode(), actionLogEvent.getDescription(), formatContent(content, args));
    }

    /**
     * 警告日志
     *
     * @param content 日志内容
     * @param args    替换字符
     */
    public static void warn(Logger logger, String content, Object... args) {
        logger.warn("({}),({})", BizContextHolder.getTraceId(), formatContent(content, args));
    }

    /**
     * 错误日志
     *
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void error(ActionLogEventEnum actionLogEvent, String content, Object... args) {
        error(LOGGER_BIZ_SERVICE, actionLogEvent, content, args);
    }

    /**
     * 错误日志
     *
     * @param logger         日志对象
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void error(Logger logger, ActionLogEventEnum actionLogEvent, String content, Object... args) {
        logger.error("({}),([{}]{}),({})", BizContextHolder.getTraceId(), actionLogEvent.getCode(), actionLogEvent.getDescription(), formatContent(content, args));
    }

    /**
     * 错误日志
     *
     * @param logger  日志对象
     * @param content 日志内容
     * @param args    替换字符
     */
    public static void error(Logger logger, String content, Object... args) {
        logger.error("({}),({})", BizContextHolder.getTraceId(), formatContent(content, args));
    }

    /**
     * 调试日志
     *
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void debug(ActionLogEventEnum actionLogEvent, String content, Object... args) {
        debug(LOGGER_BIZ_SERVICE, actionLogEvent, content, args);
    }

    /**
     * 调试日志
     *
     * @param logger         日志对象
     * @param actionLogEvent 操作对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void debug(Logger logger, ActionLogEventEnum actionLogEvent, String content, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug("({}),([{}]{}),({})", BizContextHolder.getTraceId(), actionLogEvent.getCode(), actionLogEvent.getDescription(), formatContent(content, args));
        }
    }

    /**
     * 调试日志
     *
     * @param logger         日志对象
     * @param content        日志内容
     * @param args           替换字符
     */
    public static void debug(Logger logger, String content, Object... args) {
        if (logger.isDebugEnabled()) {
            logger.debug("({}),({})", BizContextHolder.getTraceId(), formatContent(content, args));
        }
    }

    /**
     * 格式化补充内容
     *
     * @param content 补充内容
     * @param args    补充内容的占位字符
     * @return 格式化输出
     */
    private static String formatContent(String content, Object... args) {
        if (args == null || args.length == 0) {
            return content;
        }
        return String.format(content, args);
    }
}