package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootTest
public class Test_addUser {
	
	@Autowired // 自動對應
	UserRepository userRepository;
	
	@Test
	public void addUser() {
		User user = new User();
		user.setUserName("大熊");
		user.setUserEmail("666666@gmai.com");
		user.setUserPassword("abcd1234");
		
		userRepository.save(user);
		
	}
	
}
