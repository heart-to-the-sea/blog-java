/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-21 13:15:45
 * @modify date 2022-09-21 13:15:45
 * @desc [description]
 */
package com.example.blog.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import feign.Logger.ErrorLogger;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class AsyncUserTaskConfig implements AsyncConfigurer{
  private final int corePoolSize=10;
  private final int maxPoolSize = 50;
  private final int queueCapacity = 20;
  private final int awaitTerminationSeconds = 5;
  private final String threadNamePrefix="asyncUserTaskExecutor";
  @Bean("asyncUserTaskExecutor")
  public ThreadPoolTaskExecutor executor () {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(corePoolSize);
    executor.setMaxPoolSize(maxPoolSize);
    executor.setQueueCapacity(queueCapacity);
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.setThreadNamePrefix(threadNamePrefix);
    executor.setWaitForTasksToCompleteOnShutdown(true);
    executor.setAwaitTerminationSeconds(awaitTerminationSeconds);
    executor.initialize();
    return executor;
  }
  @Override
  public Executor getAsyncExecutor() {
    return executor();
  }

  @Override
  public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
    return (ex,method,params)->{
      log.info(String.format("执行任务 %s", method));
    };
  }
  
}
