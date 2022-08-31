/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-08-31 13:51:59
 * @modify date 2022-08-31 13:51:59
 * @desc [description]
 */
package com.example.blog.controller.user;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RequestMapping("user/info")
@RestController()
public class UserInfoController {
  @GetMapping("/{id}")
  public String get(@PathVariable("id") String id){
    return id;
  }
  @PostMapping("")
  public String post() {
    return "1";
  }
  @DeleteMapping("/{id}")
  public String delete(@PathVariable("id") String id) {
    return id;
  }
  @PutMapping("")
  public String put() {
    return "1";
  }
}
