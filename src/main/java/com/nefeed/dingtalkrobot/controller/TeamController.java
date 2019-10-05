package com.nefeed.dingtalkrobot.controller;

import com.nefeed.dingtalkrobot.entity.TeamInfo;
import com.nefeed.dingtalkrobot.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 团队接口控制器
 *
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:38
 */
@RestController
@RequestMapping(value = {"/team"})
public class TeamController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = {"/findTeam"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public TeamInfo findTeam(@RequestParam Integer id) {
        LOGGER.info("查询团队,id: {}.", id);
        return teamService.findByKey(id);
    }

    @RequestMapping(value = {"/findAll"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<TeamInfo> findAllTeams() {
        LOGGER.info("遍历所有团队.");
        return teamService.findAllTeams();
    }
}
