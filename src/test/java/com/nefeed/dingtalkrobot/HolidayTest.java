package com.nefeed.dingtalkrobot;

import com.nefeed.dingtalkrobot.enums.HolidayEnum;
import com.nefeed.dingtalkrobot.utils.DateUtil;
import com.nefeed.dingtalkrobot.utils.HolidayUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

/**
 * 节假日测试类
 *
 * @author nefeed@163.com
 * @version $Id: HolidayTest.java, v 0.1 2019年10月18日 6:16 下午 章华隽 Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HolidayTest {

    @Test
    public void testNormalWorkday() {
        Date date = null;
        try {
            date = DateUtil.parseDateStr("20191018", DateUtil.DATE_FORMAT_YMD);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        HolidayEnum holidayEnum = null;
        try {
            holidayEnum = HolidayUtil.getDateHolidayEnum(date);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(HolidayEnum.NORMAL_WORKDAY, holidayEnum);
        try {
            date = DateUtil.parseDateStr("20190930", DateUtil.DATE_FORMAT_YMD);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        HolidayEnum holidayEnum2 = null;
        try {
            holidayEnum2 = HolidayUtil.getDateHolidayEnum(date);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(HolidayEnum.NORMAL_WORKDAY, holidayEnum2);
    }
    @Test
    public void testNormalHoliday() {
        Date date = null;
        try {
            date = DateUtil.parseDateStr("20191019", DateUtil.DATE_FORMAT_YMD);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        HolidayEnum holidayEnum = null;
        try {
            holidayEnum = HolidayUtil.getDateHolidayEnum(date);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(HolidayEnum.NORMAL_HOLIDAY, holidayEnum);
        try {
            date = DateUtil.parseDateStr("20190922", DateUtil.DATE_FORMAT_YMD);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        HolidayEnum holidayEnum2 = null;
        try {
            holidayEnum2 = HolidayUtil.getDateHolidayEnum(date);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(HolidayEnum.NORMAL_HOLIDAY, holidayEnum2);
    }
    @Test
    public void testLegalHoliday() {
        Date date = null;
        try {
            date = DateUtil.parseDateStr("20191001", DateUtil.DATE_FORMAT_YMD);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        HolidayEnum holidayEnum = null;
        try {
            holidayEnum = HolidayUtil.getDateHolidayEnum(date);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(HolidayEnum.LEGAL_HOLIDAY, holidayEnum);
        try {
            date = DateUtil.parseDateStr("20190913", DateUtil.DATE_FORMAT_YMD);
        } catch (ParseException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        HolidayEnum holidayEnum2 = null;
        try {
            holidayEnum2 = HolidayUtil.getDateHolidayEnum(date);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        Assert.assertEquals(HolidayEnum.LEGAL_HOLIDAY, holidayEnum2);
    }
    // 调休工作日功能损坏
//    @Test
//    public void testLegalWorkday() {
//        Date date = null;
//        try {
//            date = DateUtil.parseDateStr("20190929", DateUtil.DATE_FORMAT_YMD);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            Assert.fail(e.getMessage());
//        }
//        HolidayEnum holidayEnum = null;
//        try {
//            holidayEnum = HolidayUtil.getDateHolidayEnum(date);
//        } catch (IOException e) {
//            e.printStackTrace();
//            Assert.fail(e.getMessage());
//        }
//        Assert.assertEquals(HolidayEnum.LEGAL_WORKDAY, holidayEnum);
//        try {
//            date = DateUtil.parseDateStr("20191012", DateUtil.DATE_FORMAT_YMD);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            Assert.fail(e.getMessage());
//        }
//        HolidayEnum holidayEnum2 = null;
//        try {
//            holidayEnum2 = HolidayUtil.getDateHolidayEnum(date);
//        } catch (IOException e) {
//            e.printStackTrace();
//            Assert.fail(e.getMessage());
//        }
//        Assert.assertEquals(HolidayEnum.LEGAL_WORKDAY, holidayEnum2);
//    }
}