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

	    // 使用者2
	    String password2 = "bbbb1234";
	    String salt2 = Hash.getSalt();
	    String hashedPassword2 = Hash.getHash(password2, salt2);

	    User user2 = new User();
	    user2.setUserName("小夫");
	    user2.setUserEmail("rich_kid@gmail.com");
	    user2.setSalt(salt2);
	    user2.setUserPassword(hashedPassword2);

	    // 一起儲存
	    userRepository.save(user1);
	    userRepository.save(user2);
	}
}
