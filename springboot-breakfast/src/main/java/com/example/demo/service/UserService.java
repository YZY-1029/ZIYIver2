package com.example.demo.service;

import org.springframework.stereotype.Service;


public interface UserService {
	
	public String getUserEmail(Integer userId);

	public void addUser( String userName, String userEmail, String userPassword);
	
	
}
	
	

