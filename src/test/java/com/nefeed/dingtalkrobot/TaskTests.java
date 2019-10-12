package com.nefeed.dingtalkrobot;

import com.nefeed.dingtalkrobot.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void testCalEveryDay() {
        String temp = "EVERYDAY 30 * * * * ?";
        String cron = temp.substring(temp.indexOf(" ") + 1);
        System.out.println("输出结果:" + cron);
    }
}