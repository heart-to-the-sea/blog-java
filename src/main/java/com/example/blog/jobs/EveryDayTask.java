/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-20 18:10:12
 * @modify date 2022-09-20 18:10:12
 * @desc [description]
 */
package com.example.blog.jobs;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EveryDayTask {
  /**
   * 每3S一次执行任务
   */
  @Scheduled(fixedRate=3000)
  public void scheduledTaskRate(){
    System.out.println("任务执行"+LocalDateTime.now());
  }
  /**
   * 每日上午10.15执行
   */
  @Scheduled(cron = "0 15 10 * * ? *")
  public void scheduledTaskCron(){
    System.out.println("任务执行"+LocalDateTime.now());
  }
}
