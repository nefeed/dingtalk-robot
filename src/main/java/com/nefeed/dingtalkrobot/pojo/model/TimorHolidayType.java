package com.nefeed.dingtalkrobot.pojo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 节假日类型
 *
 * @author nefeed@163.com
 * @version $Id: TimorHolidayType.java, v 0.1 2019年10月18日 6:00 下午 章华隽 Exp $
 */
@Data
public class TimorHolidayType implements Serializable {
    private static final long serialVersionUID = -6673893301265293218L;
    /** 节假日类型: 0 工作日 1节假日或周末 */
    private Integer type;
    /** 节假日类型名称 */
    private String name;
    /** 周几 */
    private Integer week;
}