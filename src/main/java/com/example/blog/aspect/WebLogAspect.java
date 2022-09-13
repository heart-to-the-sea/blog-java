/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-09-13 15:07:40
 * @modify date 2022-09-13 15:07:40
 * @desc [description]
 */
package com.example.blog.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.gson.Gson;

@Aspect
@Component
public class WebLogAspect {
  private final static Logger logger=LoggerFactory.getLogger(WebLogAspect.class);
  private final RedisTemplate<String, String> redisTemplate;
  public WebLogAspect (RedisTemplate<String,String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }
  @Pointcut("execution(public * com.example.blog.controller..*.*(..))")
  public void webLog() {}
  /**
   *  切点前织入
   * @param joinPoint
   * @throws Throwable
   */
  @Before("webLog()")
  public void doBefore(JoinPoint joinPoint)throws Throwable{
    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = attributes.getRequest();
    StringBuffer sBuffer = new StringBuffer();
    sBuffer.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>").append("\r\n")
    .append("URL                : " + request.getRequestURI().toString()).append("\r\n")
    .append("HTTP METHOD        : " + request.getMethod()).append("\r\n")
    .append("CLASS METHOD       : "+ joinPoint.getSignature().getDeclaringTypeName() + " -> " + joinPoint.getSignature().getName()).append("\r\n")
    .append("IP                 : "+ request.getRemoteAddr()).append("\r\n")
    .append("REQUEST ARGS          : "+ new Gson().toJson(joinPoint.getArgs())).append("\r\n");
    logger.info(sBuffer.toString());
    try {
      redisTemplate.opsForValue().set(Thread.currentThread().getId()+"webLog","");
      redisTemplate.opsForValue().set(Thread.currentThread().getId()+"webLog",redisTemplate.opsForValue().get(Thread.currentThread().getId()+"webLog")+sBuffer.toString());
    } catch (Exception e) {
      logger.error("{}", e);
    }
  }
  /**
   *  切点后织入
   * @param joinPoint
   */
  @After("webLog()")
  public void doAfter(JoinPoint joinPoint) {
    StringBuffer sBuffer = new StringBuffer();
    sBuffer.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<").append("\r\n")
    .append("Thread id : "+ Thread.currentThread().getId()).append("\r\n")
    .append("");
    logger.info(sBuffer.toString());

    try {
      redisTemplate.opsForValue().set(Thread.currentThread().getId()+"webLog",redisTemplate.opsForValue().get(Thread.currentThread().getId()+"webLog")+sBuffer.toString());
    } catch (Exception e) {
      logger.error("{}", e);
    }
  }
  /**
   * 环绕
   * @param proceedingJoinPoint
   * @return
   * @throws Throwable
   */
  @Around("webLog()")
  public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long startTime = System.currentTimeMillis();
    StringBuffer sBuffer = new StringBuffer();
    Object result = proceedingJoinPoint.proceed();
    sBuffer.append("Resoinse Args : "+new Gson().toJson(result)).append("\r\n")
    .append("Time-Consuming : "+ (System.currentTimeMillis()-startTime)).append("\r\n")
    .append("Thread id : "+ Thread.currentThread().getId()).append("\r\n");
    logger.info(sBuffer.toString());
    try {
      redisTemplate.opsForValue().set(Thread.currentThread().getId()+"webLog",redisTemplate.opsForValue().get(Thread.currentThread().getId()+"webLog")+sBuffer.toString());
    } catch (Exception e) {
      logger.error("{}", e);
    }
    return result;
  }
}
