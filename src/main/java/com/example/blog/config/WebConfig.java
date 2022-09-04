/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-03 23:48:38
 * @modify date 2022-09-03 23:48:38
 * @desc [description]
 */
package com.example.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer{
  
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    log.info("设置跨域");
    registry.addMapping("/**")
    .allowCredentials(false)
    .allowedOrigins("*")
    .allowedMethods( "GET", "POST", "PUT", "DELETE")
    .maxAge(3600);

  }
}
