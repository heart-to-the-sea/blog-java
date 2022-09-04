/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-03 17:27:46
 * @modify date 2022-09-03 17:27:46
 * @desc [description]
 */
package com.example.blog.controller.logging;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.dto.LoginDto;
import com.example.blog.service.login.LoginService;

@RequestMapping("login")
@RestController
public class LoggingController {
  LoginService loginService;
  public LoggingController(LoginService loginService) {
    this.loginService = loginService;
  }
  @PostMapping("")
  public String login(@RequestBody LoginDto loginDto) {
    return loginService.login(loginDto);
  }
}