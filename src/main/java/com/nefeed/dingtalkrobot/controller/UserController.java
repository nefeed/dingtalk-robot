package com.nefeed.dingtalkrobot.controller;

import com.nefeed.dingtalkrobot.entity.UserInfo;
import com.nefeed.dingtalkrobot.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:38
 */
@RestController
@RequestMapping(value = {"/user"})
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/findUser"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public UserInfo getUser(@RequestParam Integer id){
        LOGGER.info("查询用户,id: {}.", id);
        return userService.findByKey(id);
    }

    @RequestMapping(value = {"/findAll"},produces = {"application/json;charset=UTF-8"},method = RequestMethod.GET)
    public List<UserInfo> getAllUsers(){
        List<UserInfo> list =  userService.findAllUser();
        return list;
    }
}
