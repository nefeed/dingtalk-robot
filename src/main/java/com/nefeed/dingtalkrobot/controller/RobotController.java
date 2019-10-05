package com.nefeed.dingtalkrobot.controller;

import com.nefeed.dingtalkrobot.entity.RobotInfo;
import com.nefeed.dingtalkrobot.service.RobotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 机器人接口控制器
 *
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:38
 */
@RestController
@RequestMapping(value = {"/robot"})
public class RobotController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobotController.class);

    @Autowired
    private RobotService robotService;

    @RequestMapping(value = {"/findRobot"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public RobotInfo findRobot(@RequestParam Integer id) {
        LOGGER.info("查询团队,id: {}.", id);
        return robotService.findByKey(id);
    }

    @RequestMapping(value = {"/findAll"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<RobotInfo> findAllRobots() {
        LOGGER.info("遍历所有机器人.");
        return robotService.findAllRobots();
    }
}
