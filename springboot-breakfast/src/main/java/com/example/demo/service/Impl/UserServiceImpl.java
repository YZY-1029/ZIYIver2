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
	public String getUserEmail(String userName) {
		return userRepository.getUserEmail(userName);
	}

	@Override
	public void addUser(String userEmail, String userName, String userPassword) {
		String salt = Hash.getSalt();
		String passwordHash = Hash.getHash(userPassword, salt);
		User user = new User(null, userEmail, userName, userPassword);
		userRepository.save(user);
		
	}

	@Override
	public void fixUserPassword(String userEmail, String userName, String userPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findUserPassWord(String userEmail, String userName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		
	}
	

	
	

}
