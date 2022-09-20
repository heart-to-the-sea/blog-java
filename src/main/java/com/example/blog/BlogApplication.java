/**
 * @author xingqiankun
 * @email 1911898144@qq.com
 * @create date 2022-08-31 13:52:19
 * @modify date 2022-08-31 13:52:19
 * @desc [description]
 */
package com.example.blog;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling	// 开启定时器
@MapperScan("com.example.blog.dao.mapper")
@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
		// log.error("");
		// log.warn("Hello World");
		// log.info("Hello World");
		// log.debug("Hello World");
		// log.trace("Hello World");
	}
}
