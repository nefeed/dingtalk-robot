package com.nefeed.dingtalkrobot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 异步执行设置
 *
 * @author nefeed@163.com
 * @version $Id: ExecutorConfig.java, v 0.1 2019年10月09日 10:35 上午 章华隽 Exp $
 */
@Configuration
@EnableAsync
public class ExecutorConfig {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecutorConfig.class);

    @Bean
    public Executor asyncServiceExecutor() {
        LOGGER.info("start init asyncServiceExecutor.");

        ThreadPoolTaskExecutor executor = new VisibleThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(5);
        // 最大线程数
        executor.setMaxPoolSize(5);
        // 队列大小
        executor.setQueueCapacity(99999);
        // 线程名前缀
        executor.setThreadNamePrefix("async-service-");

        // rejection-policy: 当pool已经达到max size的时候, 如何处理新任务
        // CALLER_RUNS: 不在新线程中执行任务,而是调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        LOGGER.info("end init asyncServiceExecutor.");
        return executor;
    }
}