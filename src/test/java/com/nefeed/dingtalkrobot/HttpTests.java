package com.nefeed.dingtalkrobot;

import com.nefeed.dingtalkrobot.utils.HttpUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.nefeed.dingtalkrobot.utils.HolidayUtil.getDateHolidayEnum;

/**
 * Http的测试类
 *
 * @author nefeed@163.com
 * @version $Id: HttpTests.java, v 0.1 2019年10月12日 1:28 下午 章华隽 Exp $
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpTests {
    @Test
    public void testGet() {
        // test get
        try {
            System.out.println("TEST HTTP GET 结果 获取的假日类型: " + getDateHolidayEnum(new Date()));
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        }
    }

    @Test
    public void testPost() {
        // test post
        Map<String, Object> params = new HashMap<>(16);
        params.put("msgtype", "text");
        Map<String, Object> text = new HashMap<>(16);
        params.put("text", text);
        Map<String, Object> at = new HashMap<>(16);
        params.put("at", at);

        text.put("content", "测试自研钉钉机器人自助后台");
        at.put("isAtAll", false);

        String postResult = null;
        try {
            postResult = HttpUtil.post("https://oapi.dingtalk.com/robot/send?access_token=d7d1d6cd192115d520ed980b7d83233e2da9b010bf3850317a6dbe9a237e371d", params);
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.toString());
        }

        System.out.println("TEST HTTP POST 结果: " + postResult);
    }
}