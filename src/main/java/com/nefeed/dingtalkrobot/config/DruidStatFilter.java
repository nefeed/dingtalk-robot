package com.nefeed.dingtalkrobot.config;

import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2019-10-06 10:33
 */
@WebFilter(filterName = "druidWebStatFilter", urlPatterns = "/*",

        initParams = {

                @WebInitParam(name = "exclusions", value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")

        }
)
public class DruidStatFilter extends WebStatFilter {
}
