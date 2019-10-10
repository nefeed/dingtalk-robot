package com.nefeed.dingtalkrobot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author nefeed@163.com
 * @version $Id: DateUtil.java, v 0.1 2019年10月06日 2:27 下午 章华隽 Exp $
 */
public class DateUtil {

    private static final String DATE_FORMAT_NORMAL = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat NORMAL_FORMAT = new SimpleDateFormat(DATE_FORMAT_NORMAL);

    /**
     * 将Date转为默认的时间格式字符串
     * @param date 时间
     * @return 默认的时间格式字符串
     */
    public static String parseDate(Date date) {
        if (date == null) {
            return null;
        }
        return NORMAL_FORMAT.format(date);
    }

    /**
     * 将Date转为默认的时间格式字符串
     * @param timestamp 10位时间戳
     * @return 默认的时间格式字符串
     */
    public static String parseTimestamp(Integer timestamp) {
        if (timestamp == null || timestamp == 0) {
            return null;
        }
        Date date = new Date(timestamp * 1000L);
        return NORMAL_FORMAT.format(date);
    }
}