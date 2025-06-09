package com.example.demo.service;

import com.example.demo.model.dto.UserDto;

public interface UserService {
	
	public String getUserEmail(Integer userId);

	public boolean addUser(String userName, String userEmail, String userPassword);

}
	
	

