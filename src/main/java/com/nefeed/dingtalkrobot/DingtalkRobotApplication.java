package com.nefeed.dingtalkrobot;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author nefeed@163.com
 */
@SpringBootApplication
@MapperScan("com.nefeed.dingtalkrobot.dao")
@ComponentScan(basePackages = {"com.nefeed.dingtalkrobot.*"})
@EnableAutoConfiguration(exclude = {DruidDataSourceAutoConfigure.class})
public class DingtalkRobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingtalkRobotApplication.class, args);
    }

}
