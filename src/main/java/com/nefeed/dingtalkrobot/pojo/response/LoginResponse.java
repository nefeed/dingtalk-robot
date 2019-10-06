package com.nefeed.dingtalkrobot.pojo.response;

import com.nefeed.dingtalkrobot.pojo.base.BaseResponse;
import lombok.Data;

import java.io.Serializable;

/**
 * 登录结果
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-06 11:39
 */
@Data
public class LoginResponse extends BaseResponse implements Serializable {
    private static final long serialVersionUID = 7777592130796553873L;

    private Integer lastLoginTime;
    private String lastLoginIp;
    private String accessToken;
}
