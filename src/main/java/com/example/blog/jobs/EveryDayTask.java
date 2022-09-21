/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-20 18:10:12
 * @modify date 2022-09-20 18:10:12
 * @desc [description]
 */
package com.example.blog.jobs;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.blog.feign.UserFeign;

@Component
public class EveryDayTask {
  @Autowired
  private UserFeign userFeign;
  /**
   * 每1S一次执行任务
   */
  @Scheduled(fixedRate=1000)
  public void scheduledTaskRate(){
    System.out.println("每秒 任务执行"+LocalDateTime.now());
    // userFeign.getUserAll();
  }
  /**
   * 每日中午12点执行
   */
  @Scheduled(cron = "0 0 12 * * ?")
  public void scheduledTaskCron(){
    System.out.println("任务执行"+LocalDateTime.now());
  }
}
