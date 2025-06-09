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
	public void addMultipleUsers() {
	    // 使用者1
	    String password1 = "aaaa5614";
	    String salt1 = Hash.getSalt();
	    String hashedPassword1 = Hash.getHash(password1, salt1);

	    User user1 = new User();
	    user1.setUserName("胖虎");
	    user1.setUserEmail("fat_tiger@gmail.com");
	    user1.setSalt(salt1);
	    user1.setUserPassword(hashedPassword1);
	    user1.setActive(true);
	    user1.setRole("user");

	    // 使用者2
	    String password2 = "bbbb1234";
	    String salt2 = Hash.getSalt();
	    String hashedPassword2 = Hash.getHash(password2, salt2);

	    User user2 = new User();
	    user2.setUserName("小夫");
	    user2.setUserEmail("rich_kid@gmail.com");
	    user2.setSalt(salt2);
	    user2.setUserPassword(hashedPassword2);
	    user2.setActive(true);
	    user2.setRole("user");
	    
	    
	    // 使用者3
	    String password3 = "dddd";
	    String salt3 = Hash.getSalt();
	    String hashedPassword3 = Hash.getHash(password3, salt3);

	    User user3 = new User();
	    user3.setUserName("小叮叮");
	    user3.setUserEmail("dd@gmail.com");
	    user3.setSalt(salt3);
	    user3.setUserPassword(hashedPassword3);
	    user3.setActive(true);
	    user3.setRole("user");

	    // 一起儲存
	    userRepository.save(user1);
	    userRepository.save(user2);
	    userRepository.save(user3);
	}
}
