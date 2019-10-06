package com.nefeed.dingtalkrobot.pojo.model;

import com.nefeed.dingtalkrobot.enums.ActionLogEventEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 业务上下文
 *
 * @author nefeed@163.com
 * @version $Id: BizContext.java, v 0.1 2019年10月06日 12:42 下午 章华隽 Exp $
 */
@Data
public class BizContext implements Serializable {
    private static final long serialVersionUID = -1562785123377175107L;
    private String traceId;
    private Date time;
    private ActionLogEventEnum event;
    private Map<String, Object> context;

    public BizContext() {
        this.traceId = UUID.randomUUID().toString();
        this.time = new Date();
        this.context = new HashMap<>();
    }
}