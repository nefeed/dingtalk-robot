package com.nefeed.dingtalkrobot.pojo.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 节假日信息
 *
 * @author nefeed@163.com
 * @version $Id: TimorHolidayInfo.java, v 0.1 2019年10月18日 6:01 下午 章华隽 Exp $
 */
@Data
public class TimorHolidayInfo implements Serializable {
    private static final long serialVersionUID = -125594676869740157L;
    /** 是否是节假日,false表示调休 */
    private boolean holiday;
    /** 节假日的名称,如果是调休,则是调休的中文名,如"国庆前调休" */
    private String name;
    /** 薪资倍数,1表示正常工资 */
    private Integer wage;
    /** 日期 */
    private String date;
    /** 只有调休有该字段,true表示放假后的调休,false表示放假前的调休 */
    private boolean after;
    /** 只有调休有该字段,表示为什么节日调休 */
    private String target;

}