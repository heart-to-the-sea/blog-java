/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-01 21:08:06
 * @modify date 2022-09-01 21:08:06
 * @desc [description]
 */
package com.example.blog.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisController {
  private final RedisTemplate<String, String> redisTemplate;
  public RedisController (RedisTemplate<String, String> redisTemplate){
    this.redisTemplate = redisTemplate;
  }
  @GetMapping("save")
  public String save(String key,String value) {
    redisTemplate.opsForValue().set(key,value);
    return "";
  }
  @GetMapping("search")
  public Object search(String key) {
    return redisTemplate.opsForValue().get(key);
  }
}
