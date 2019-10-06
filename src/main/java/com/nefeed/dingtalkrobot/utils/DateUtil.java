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

    public static String parseTimestamp(Integer timestamp) {
        if (timestamp == null || timestamp == 0) {
            return null;
        }
        Date date = new Date(timestamp * 1000L);
        return NORMAL_FORMAT.format(date);
    }
}