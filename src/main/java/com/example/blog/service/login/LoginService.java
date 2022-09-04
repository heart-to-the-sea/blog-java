/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-03 18:13:33
 * @modify date 2022-09-03 18:13:33
 * @desc [description]
 */
package com.example.blog.service.login;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.blog.dto.LoginDto;
import com.example.blog.service.user.UserInfoService;

@Service
public class LoginService {
  RedisTemplate redisTemplate;
  UserInfoService userInfoService;
  public LoginService(RedisTemplate redisTemplate, UserInfoService userInfoService){
    this.redisTemplate = redisTemplate;
    this.userInfoService = userInfoService;
  }
  public String login(LoginDto loginDto){
    // redisTemplate.
    // if () {

    // }
    // return redisTemplate.opsForValue().get().toString();
    return "";
  }
}
