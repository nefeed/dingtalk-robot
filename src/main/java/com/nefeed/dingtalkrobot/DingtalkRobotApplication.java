package com.nefeed.dingtalkrobot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.nefeed.dingtalkrobot.dao")
@ComponentScan(basePackages = {"com.nefeed.dingtalkrobot.*"})
public class DingtalkRobotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DingtalkRobotApplication.class, args);
    }

}
