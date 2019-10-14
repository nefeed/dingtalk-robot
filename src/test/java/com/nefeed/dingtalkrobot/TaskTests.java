package com.nefeed.dingtalkrobot;

import com.nefeed.dingtalkrobot.service.TaskService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 定时任务用例
 *
 * @author nefeed@163.com
 * @version $Id: TaskTests.java, v 0.1 2019年10月12日 5:45 下午 章华隽 Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskTests {

    @Autowired
    private TaskService taskService;

    @Test
    public void testCalEveryday() throws IOException {
        // 2019-10-12 19:33:00
        Integer unixTimestamp = 1570879980;
        String schedule = "EVERYDAY 30 * * * * ?";
        int result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        Assert.assertEquals(result, unixTimestamp + 30);

        unixTimestamp = unixTimestamp + 24 * 60 * 60;
        result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        Assert.assertEquals(result, unixTimestamp + 30);
    }

    @Test
    public void testCalWorkday() throws IOException {
        // 2019-10-12 19:33:00 调休后的法定工作日
        Integer unixTimestamp = 1570879980;
        String schedule = "WORKDAY 30 * * * * ?";
        int result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        Assert.assertEquals(result, unixTimestamp + 30);

        unixTimestamp = unixTimestamp + 24 * 60 * 60;
        result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        // 2019-10-14 00:00:30
        Assert.assertEquals(result, 1570982430);
    }

    @Test
    public void testCalLasWorkday() throws IOException {
        // 2019-10-12 19:33:00 调休后的法定工作日
        Integer unixTimestamp = 1570879980;
        String schedule = "LAST_WORKDAY 30 * * * * ?";
        int result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        Assert.assertEquals(result, unixTimestamp + 30);

        unixTimestamp = unixTimestamp + 24 * 60 * 60;
        result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        // 2019-10-18 00:00:30
        Assert.assertEquals(result, 1571328030);
    }

    @Test
    public void testCalHoliday() throws IOException {
        // 2019-10-12 19:33:00 调休后的法定工作日
        Integer unixTimestamp = 1570879980;
        String schedule = "HOLIDAY 30 * * * * ?";
        int result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        // 2019-10-13 00:00:30
        Assert.assertEquals(result, 1570896030);

        unixTimestamp = unixTimestamp + 24 * 60 * 60;
        result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        // 2019-10-13 19:33:30
        Assert.assertEquals(result, 1570966410);
    }

    @Test
    public void testCalWeekday() throws IOException {
        // 2019-10-12 19:33:00 调休后的法定工作日 周六
        Integer unixTimestamp = 1570879980;
        String schedule = "WEEKDAY 30 * * * * ?";
        int result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        // 2019-10-14 00:00:30
        Assert.assertEquals(result, 1570982430);

        unixTimestamp = unixTimestamp + 24 * 60 * 60;
        result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        // 2019-10-14 00:00:30
        Assert.assertEquals(result, 1570982430);
    }

    @Test
    public void testCalWeekend() throws IOException {
        // 2019-10-12 19:33:00 调休后的法定工作日 周六
        Integer unixTimestamp = 1570879980;
        String schedule = "WEEKEND 30 * * * * ?";
        int result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        // 2019-10-12 19:33:30
        Assert.assertEquals(result, unixTimestamp + 30);

        unixTimestamp = unixTimestamp + 2 * 24 * 60 * 60;
        result = taskService.calNextExpectRunTime(unixTimestamp, schedule);
        // 2019-10-19 00:00:30
        Assert.assertEquals(result, 1571414430);
    }
}