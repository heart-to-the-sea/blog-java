package com.example.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.blog.domain.entity.User;

@SpringBootTest
class BlogApplicationTests {

	/**
	 * 
	 */
	@Test
	void contextLoads() {
		User user= new User();
		User user2 = new User();
		user2.setUsername("xingqiankun");
		user.setId(9999l);
		System.out.println("user ------->"+user.toString());
		System.out.println("user2 ------->"+user2.toString());

		BeanUtils.copyProperties(user, user2);
		System.out.println("user ------->"+user.toString());
		System.out.println("user2 ------->"+user2.toString());
	}

}
