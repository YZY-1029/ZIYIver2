package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.Hash;

@SpringBootTest
public class Test_addUser {
	
	@Autowired // 自動對應
	UserRepository userRepository;
	
	@Test
	public void addUser() {
		
		String password = "aaaa5614";
		
		String salt = Hash.getSalt();
		String hashedPassword = Hash.getHash(password, salt);
		
		User user = new User();
		user.setUserName("胖虎");
		user.setUserEmail("aaaaaaaa@gmail.com");
		user.setSalt(salt);
		user.setUserPassword(hashedPassword);
		
		userRepository.save(user);
		
	}
	
}
