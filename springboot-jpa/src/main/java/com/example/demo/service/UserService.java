package com.example.demo.service;

import com.example.demo.model.dto.UserDto;

public interface UserService {

	public UserDto getUser(String username);
	public void addUser(String username, String password, String email, boolean active, String role);
	// 可以往下自訂 ... 如新增修改稱除 
	
}
