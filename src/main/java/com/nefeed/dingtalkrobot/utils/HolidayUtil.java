package com.nefeed.dingtalkrobot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nefeed.dingtalkrobot.enums.HolidayEnum;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 节假日工具类
 *
 * @author nefeed@163.com
 * @version $Id: HolidayUtil.java, v 0.1 2019年10月11日 5:26 下午 章华隽 Exp $
 */
@Slf4j
public class HolidayUtil {

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
        String httpUrl = "http://api.goseek.cn/Tools/holiday";
        JSONObject params = new JSONObject();
        params.put("date", date);
        int value = 0;
        String httpResult;
        try {
            httpResult = HttpUtil.get(httpUrl, params);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("请求节假日信息异常!", e);
            throw e;
        }
        JSONObject ob = JSONObject.parseObject(httpResult);
        if (ob != null) {
            value = Integer.parseInt(ob.getString("data"));
        }
        HolidayEnum holidayEnum = HolidayEnum.getByValue(value);
        if (holidayEnum == null) {
            log.error("获取节假日类型失败，枚举不包含value: {}", value);
            return null;
        }
        holidayMap.put(date, holidayEnum);
        log.info("获取节假日类型成功，Map新增内容: ({}, {})", date, holidayEnum);
        log.info("节假日记录Map完整内容: [{}]", JSON.toJSONString(holidayMap));
        return holidayEnum;
    }

    /**
     * 是否是工作日
     * @param date 日期
     * @return boolean
     */
    public static boolean isWorkday(Date date) throws IOException {
        HolidayEnum holidayEnum = getDateHolidayEnum(date);
        return isWorkday(holidayEnum);
    }

    /**
     * 是否是工作日
     * @param holiday 节假日枚举
     * @return boolean
     */
    public static boolean isWorkday(HolidayEnum holiday) {
        return HolidayEnum.LEGAL_WORKDAY == holiday || HolidayEnum.NORMAL_WORKDAY == holiday;
    }

    /**
     * 是否是节假日
     * @param date 日期
     * @return boolean
     */
    public static boolean isHoliday(Date date) throws IOException {
        HolidayEnum holidayEnum = getDateHolidayEnum(date);
        return isHoliday(holidayEnum);
    }

    /**
     * 是否是节假日
     * @param holiday 节假日枚举
     * @return boolean
     */
    public static boolean isHoliday(HolidayEnum holiday) {
        return HolidayEnum.LEGAL_HOLIDAY == holiday || HolidayEnum.NORMAL_HOLIDAY == holiday;
    }

    /**
     * 今天和昨天是工作日,明天是节假日,定义为每周最后一个工作日
     * @param timestamp 指定日期
     * @return 是否为最后一个工作日
     * @throws IOException io异常
     */
    public static boolean isLastWorkDay(int timestamp) throws IOException {
        return isLastWorkDay(new Date(timestamp * 1000L));
    }

    /**
     * 今天和昨天是工作日,明天是节假日,定义为每周最后一个工作日
     * @param date 指定日期
     * @return 是否为最后一个工作日
     * @throws IOException io异常
     */
    public static boolean isLastWorkDay(Date date) throws IOException {
        if (isHoliday(getDateHolidayEnum(date))) {
            return false;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = c.getTime();
        HolidayEnum tomorrowHolidayType = getDateHolidayEnum(tomorrow);
        if (isWorkday(tomorrowHolidayType)) {
            return false;
        }
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();
        HolidayEnum yesterdayHolidayType = getDateHolidayEnum(yesterday);
        return isWorkday(yesterdayHolidayType);
    }


    /**
     * 是否是周末
     * @param date 日期
     * @return boolean
     */
    public static boolean isWeekend(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
       return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }
}
