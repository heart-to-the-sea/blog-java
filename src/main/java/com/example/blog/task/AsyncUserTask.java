/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-21 11:08:49
 * @modify date 2022-09-21 11:08:49
 * @desc [description]
 */
package com.example.blog.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import io.netty.util.concurrent.Future;

@Component
public class AsyncUserTask {
  @Async("asyncUserTaskExecutor")
  public void handleAsyncTask() throws InterruptedException {
    Thread.sleep(3000);
    System.out.println("asyncUserTask");
  }

  @Async
  public Future<String> handleAsyncTaskFuture() {
    Future<String> future;
    try {
      Thread.sleep(3000);
      future = (Future<String>) new AsyncResult<String>("handleAsyncTaskFuture");
    } catch (InterruptedException e) {
      future = (Future<String>) new AsyncResult<String>("handleAsyncTaskFuture-err" + e.toString());
    }
    return future;
  }
}
