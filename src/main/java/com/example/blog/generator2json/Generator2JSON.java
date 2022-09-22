package com.example.blog.generator2json;

import javax.annotation.PostConstruct;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Aspect
@Component
public class Generator2JSON {
  @Pointcut("@annotation(com.example.blog.generator2json.RestPath)")
  public void restMethod(){
    System.out.println("restMethod");
  }

  @Around("restMethod()")
  public Object around(ProceedingJoinPoint point) throws Throwable {
    System.out.println("---------------------------");
    Object result = point.proceed();
    return result;
  }
  @PostConstruct
  public void postConstruct (){
    System.out.println("----------------------------->>>>>>>>>>>>>>>>>>>");
  }
}
