package com.nefeed.dingtalkrobot.controller;

import com.nefeed.dingtalkrobot.controller.base.BaseController;
import com.nefeed.dingtalkrobot.entity.UserInfo;
import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.enums.ResultCodeEnum;
import com.nefeed.dingtalkrobot.pojo.base.BaseResponse;
import com.nefeed.dingtalkrobot.pojo.response.LoginResponse;
import com.nefeed.dingtalkrobot.service.UserService;
import com.nefeed.dingtalkrobot.utils.DateUtil;
import com.nefeed.dingtalkrobot.utils.IpUtil;
import com.nefeed.dingtalkrobot.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Objects;

/**
 * 用户接口控制器
 *
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-05 18:38
 */
@RestController
@RequestMapping(value = {"/user"})
public class UserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/findUser"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public UserInfo findUser(@RequestParam Integer id) {
        LOGGER.info("查询用户,id: {}.", id);
        return userService.findByKey(id);
    }

    @RequestMapping(value = {"/findAll"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public List<UserInfo> findAllUsers() {
        LOGGER.info("遍历所有用户.");
        return userService.findAllUsers();
    }

    @RequestMapping(value = {"/login"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public BaseResponse login(HttpServletRequest request,
                              @RequestParam String account, @RequestParam String password) {
        LogUtil.info(ActionLogEventEnum.LOGIN, "account: {}.", account);
        UserInfo userInfo = userService.findByAccount(account);
        if (userInfo == null) {
            LogUtil.warn(ActionLogEventEnum.LOGIN, "账号不存在: {}.", account);
            return buildErrorResponse(ResultCodeEnum.ACCOUNT_NOT_EXISTS);
        }
        if (Objects.equals(userInfo.getPassword(), password)) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setLastLoginTime(userInfo.getLastLoginTime());
            loginResponse.setLastLoginIp(userInfo.getLastLoginIp());
            LogUtil.info(ActionLogEventEnum.LOGIN, "登录成功: {}, 上次登录时间: {}, 上次登录IP: {}.",
                    account, DateUtil.parseTimestamp(userInfo.getLastLoginTime()), userInfo.getLastLoginIp());
            String accessToken = userService.loginSuccess(userInfo, IpUtil.getIpAddr(request));
            loginResponse.setAccessToken(accessToken);
            initSuccessResponse(loginResponse);
            return loginResponse;
        }
        LogUtil.warn(ActionLogEventEnum.LOGIN, "密码错误: {}.", account);
        return buildErrorResponse(ResultCodeEnum.WRONG_PASSWORD);
    }
}
