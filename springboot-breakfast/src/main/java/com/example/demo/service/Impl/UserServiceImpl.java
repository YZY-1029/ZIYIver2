package com.example.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Hash;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	
	
	@Override
	public String getUserEmail(Integer userId) {
		return userRepository.getUserEmail(userId);
	}

	@Override
	public void addUser(String userName, String userEmail, String userPassword) {
		// 產生鹽
		String salt = Hash.getSalt();
		// 加鹽後用 SHA-256 雜湊
		String hashedPassword = Hash.getHash(userPassword, salt);
		// 建立 User
		User user = new User();
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setSalt(salt);
		user.setUserPassword(hashedPassword);
		
		userRepository.save(user);
		
	}

}
