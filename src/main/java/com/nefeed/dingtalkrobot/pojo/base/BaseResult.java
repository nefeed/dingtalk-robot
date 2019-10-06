package com.nefeed.dingtalkrobot.pojo.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用结果
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-06 11:33
 */
@Data
public class BaseResult implements Serializable {

    private static final long serialVersionUID = -8119879318673087440L;

    private boolean success;
    private String resultCode;
    private String resultMsg;
}
