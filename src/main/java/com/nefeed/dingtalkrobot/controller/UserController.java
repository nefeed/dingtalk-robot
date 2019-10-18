package com.nefeed.dingtalkrobot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nefeed.dingtalkrobot.controller.base.BaseController;
import com.nefeed.dingtalkrobot.entity.UserInfo;
import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import com.nefeed.dingtalkrobot.enums.ResultCodeEnum;
import com.nefeed.dingtalkrobot.pojo.base.BaseResponse;
import com.nefeed.dingtalkrobot.pojo.response.LoginResponse;
import com.nefeed.dingtalkrobot.service.ActionLogService;
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
    @Autowired
    private ActionLogService actionLogService;

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
        LogUtil.info(ActionLogEventEnum.LOGIN, "account: %s.", account);
        UserInfo userInfo = userService.findByAccount(account);
        if (userInfo == null) {
            LogUtil.warn(ActionLogEventEnum.LOGIN, "账号不存在: %s.", account);
            return buildErrorResponse(ResultCodeEnum.ACCOUNT_NOT_EXISTS);
        }
        if (Objects.equals(userInfo.getPassword(), password)) {
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setLastLoginTime(userInfo.getLastLoginTime());
            loginResponse.setLastLoginIp(userInfo.getLastLoginIp());
            String log = String.format("用户%s[%s]登录成功, 上次登录时间: %s, 上次登录IP: %s.",
            userInfo.getUsername(), account, DateUtil.parseTimestamp(userInfo.getLastLoginTime()), userInfo.getLastLoginIp());
            LogUtil.info(ActionLogEventEnum.LOGIN, log);
            String accessToken = userService.loginSuccess(userInfo, IpUtil.getIpAddr(request));
            loginResponse.setAccessToken(accessToken);
            initSuccessResponse(loginResponse);
            actionLogService.registerActionLog(ActionLogEventEnum.LOGIN, userInfo.getUserId(),
                    null, null, log);
            return loginResponse;
        }
        LogUtil.warn(ActionLogEventEnum.LOGIN, "密码错误: %s.", account);
        return buildErrorResponse(ResultCodeEnum.WRONG_PASSWORD);
    }

    @RequestMapping(value = {"/info"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.GET)
    public JSONObject info() {
        LogUtil.info(ActionLogEventEnum.USER_INFO_QUERY, "mock /user/info返回");
        return JSON.parseObject(MOCK_USER_INFO_RESPONSE);
    }

    @RequestMapping(value = {"/logout"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public BaseResponse logout() {
        LogUtil.info(ActionLogEventEnum.LOGOUT, "mock /user/logout返回");
        BaseResponse successResponse = new BaseResponse();
        initSuccessResponse(successResponse);
        return successResponse;
    }

    @RequestMapping(value = {"/2step-code"}, produces = {"application/json;charset=UTF-8"}, method = RequestMethod.POST)
    public JSONObject get2Step() {
        LogUtil.info(ActionLogEventEnum.USER_INFO_QUERY, "mock /user/2step-code返回");
        return JSON.parseObject(MOCK_2_STEP_RESPONSE);
    }

    private static final String MOCK_2_STEP_RESPONSE = "{\"message\":\"\",\"timestamp\":1570537276808,\"result\":{\"stepCode\":1},\"code\":0}";

    private static final String MOCK_USER_INFO_RESPONSE = "{\"message\":\"\",\"timestamp\":1570536232357,\"result\":{\"id\":\"4291d7da9005377ec9aec4a71ea837f\",\"name\":\"天野远子\",\"username\":\"admin\",\"password\":\"\",\"avatar\":\"/avatar2.jpg\",\"status\":1,\"telephone\":\"\",\"lastLoginIp\":\"27.154.74.117\",\"lastLoginTime\":1534837621348,\"creatorId\":\"admin\",\"createTime\":1497160610259,\"merchantCode\":\"TLif2btpzg079h15bk\",\"deleted\":0,\"roleId\":\"admin\",\"role\":{\"id\":\"admin\",\"name\":\"管理员\",\"describe\":\"拥有所有权限\",\"status\":1,\"creatorId\":\"system\",\"createTime\":1497160610259,\"deleted\":0,\"permissions\":[{\"roleId\":\"admin\",\"permissionId\":\"dashboard\",\"permissionName\":\"仪表盘\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"query\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"查询\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"query\",\"describe\":\"查询\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"exception\",\"permissionName\":\"异常页面权限\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"query\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"查询\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"query\",\"describe\":\"查询\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"result\",\"permissionName\":\"结果权限\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"query\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"查询\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"query\",\"describe\":\"查询\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"profile\",\"permissionName\":\"详细页权限\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"query\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"查询\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"query\",\"describe\":\"查询\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"table\",\"permissionName\":\"表格权限\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"import\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"导入\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"import\",\"describe\":\"导入\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"form\",\"permissionName\":\"表单权限\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"query\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"查询\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"query\",\"describe\":\"查询\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"order\",\"permissionName\":\"订单管理\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"query\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"查询\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"query\",\"describe\":\"查询\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"permission\",\"permissionName\":\"权限管理\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"role\",\"permissionName\":\"角色管理\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"table\",\"permissionName\":\"桌子管理\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"query\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"查询\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"query\",\"describe\":\"查询\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"user\",\"permissionName\":\"用户管理\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"import\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"导入\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"},{\\\"action\\\":\\\"export\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"导出\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"import\",\"describe\":\"导入\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false},{\"action\":\"export\",\"describe\":\"导出\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null},{\"roleId\":\"admin\",\"permissionId\":\"support\",\"permissionName\":\"超级模块\",\"actions\":\"[{\\\"action\\\":\\\"add\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"新增\\\"},{\\\"action\\\":\\\"import\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"导入\\\"},{\\\"action\\\":\\\"get\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"详情\\\"},{\\\"action\\\":\\\"update\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"修改\\\"},{\\\"action\\\":\\\"delete\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"删除\\\"},{\\\"action\\\":\\\"export\\\",\\\"defaultCheck\\\":false,\\\"describe\\\":\\\"导出\\\"}]\",\"actionEntitySet\":[{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"import\",\"describe\":\"导入\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"详情\",\"defaultCheck\":false},{\"action\":\"update\",\"describe\":\"修改\",\"defaultCheck\":false},{\"action\":\"delete\",\"describe\":\"删除\",\"defaultCheck\":false},{\"action\":\"export\",\"describe\":\"导出\",\"defaultCheck\":false}],\"actionList\":null,\"dataAccess\":null}]}},\"code\":200,\"_headers\":{\"Custom-Header\":\"76F0f764-5E27-Ad63-e538-b3b2aA429Bb0\"}}";
}
