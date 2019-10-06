package com.nefeed.dingtalkrobot.pojo.base;

import lombok.Data;

import java.io.Serializable;

/**
 * 通用的返回
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-06 11:30
 */
@Data
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -2077048382428308517L;

    private BaseResult result;

}
