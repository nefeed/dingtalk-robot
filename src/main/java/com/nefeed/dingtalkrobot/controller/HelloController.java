package com.nefeed.dingtalkrobot.controller;

import com.nefeed.dingtalkrobot.controller.base.BaseController;
import com.nefeed.dingtalkrobot.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 欢迎接口
 *
 * @author nefeed@163.com
 * @version $Id: HelloController.java, v 0.1 2019年10月09日 10:32 上午 章华隽 Exp $
 */
@RestController
@RequestMapping("/hello")
public class HelloController extends BaseController {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private AsyncService asyncService;

    @RequestMapping("/")
    public String submit() {
        LOGGER.info("start submit.");
        asyncService.executeAsync();
        LOGGER.info("end submit.");
        return "Hello World!";
    }
}