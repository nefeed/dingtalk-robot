package com.nefeed.dingtalkrobot.pojo.response;

import com.nefeed.dingtalkrobot.pojo.model.TimorHolidayInfo;
import com.nefeed.dingtalkrobot.pojo.model.TimorHolidayType;
import lombok.Data;

import java.io.Serializable;

/**
 * Timor公共节假日API的返回
 *
 * @author nefeed@163.com
 * @version $Id: TimorHolidayResponse.java, v 0.1 2019年10月18日 5:52 下午 章华隽 Exp $
 */
@Data
public class TimorHolidayResponse implements Serializable {
    private static final long serialVersionUID = 3999481703933730885L;

    /** 结果码 0成功 -1失败 */
    private Integer code;
    /** 节假日类型 */
    private TimorHolidayType type;
    /** 节假日信息或调休信息 */
    private TimorHolidayInfo holiday;

}