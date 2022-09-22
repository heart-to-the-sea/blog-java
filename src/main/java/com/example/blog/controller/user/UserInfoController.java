/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-08-31 13:51:59
 * @modify date 2022-08-31 13:51:59
 * @desc [description]
 */
package com.example.blog.controller.user;

import com.example.blog.domain.entity.User;
import com.example.blog.generator2json.RestPath;
import com.example.blog.service.user.UserInfoService;
import com.example.blog.task.AsyncUserTask;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


 
@RequestMapping("user/info")
@RestController()
public class UserInfoController {
  @Autowired
  private UserInfoService userInfoService;
  @Autowired
  private AsyncUserTask userTask;
  @GetMapping("/all")
  @RestPath
  public List<User> getAllInfo()throws InterruptedException{
    List<User> list = userInfoService.getAllUserInfo();
    return list;
  }
  @GetMapping("/{id}")
  public User getInfo(@PathVariable Integer id)throws InterruptedException {
    User user = userInfoService.getUserById(id);
    System.out.println("执行异步县城");
    userTask.handleAsyncTask();
    System.out.println("异步县城执行完毕");
    return user;
  }
  @PostMapping("")
  public Integer save(@RequestBody User user) {
    return userInfoService.saveUserInfo(user);
  }
  @DeleteMapping("/{id}")
  public Integer delete(@PathVariable("id") Integer id) {
    return userInfoService.deleteUserInfo(id);
  }
  @PutMapping("")
  public String put() {
    return "1";
  }
}
