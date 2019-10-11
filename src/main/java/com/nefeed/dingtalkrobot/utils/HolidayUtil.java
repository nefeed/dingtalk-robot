package com.nefeed.dingtalkrobot.utils;

import com.alibaba.fastjson.JSONObject;
import com.nefeed.dingtalkrobot.enums.HolidayEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 节假日工具类
 *
 * @author nefeed@163.com
 * @version $Id: HolidayUtil.java, v 0.1 2019年10月11日 5:26 下午 章华隽 Exp $
 */
public class HolidayUtil {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(HolidayUtil.class);

    /**
     * 节假日Map
     * 0: 正常工作日
     * 1: 法定节假日
     * 2: 节假日调休补班
     * 3: 休息日
     */
    private static Map<String, HolidayEnum> holidayMap;

    static {
        holidayMap = new HashMap<>();
    }

    /**
     * 获取指定日期的类型
     * @param timestamp 时间戳(unixTimestamp秒数)
     * @return 指定日期的类型
     */
    public static HolidayEnum getDateHolidayEnum(int timestamp) throws IOException {
        return getDateHolidayEnum(new Date(timestamp * 1000L));
    }

    /**
     * 获取指定日期的类型
     * @param date 指定日期
     * @return 指定日期的类型
     */
    public static HolidayEnum getDateHolidayEnum(Date date) throws IOException {
        String ymd = DateUtil.parseDate(date, DateUtil.DATE_FORMAT_YMD);
        if (holidayMap.containsKey(ymd)) {
            return holidayMap.get(ymd);
        }
        return requestHolidayEnum(ymd);
    }

    /**
     * 请求公开接口获取节假日类型
     * @param date 指定年月日
     * @return 节假日类型
     */
    private static HolidayEnum requestHolidayEnum(String date) throws IOException {
        StringBuilder httpUrl = new StringBuilder("http://api.goseek.cn/Tools/holiday");
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl.append("?date=").append(date);

        int value = 0;
        try {
            URL url = new URL(httpUrl.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
            JSONObject ob = JSONObject.parseObject(result);
            if (ob != null) {
                value = Integer.parseInt(ob.getString("data"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("请求节假日信息异常!", e);
            throw e;
        }
        HolidayEnum holidayEnum = HolidayEnum.getByValue(value);
        if (holidayEnum == null) {
            LOGGER.error("获取节假日类型失败，枚举不包含value: {}", value);
            return null;
        }
        holidayMap.put(date, holidayEnum);
        LOGGER.info("获取节假日类型成功，map新增内容: ({}, {})", date, holidayEnum);
        return holidayEnum;
    }
}