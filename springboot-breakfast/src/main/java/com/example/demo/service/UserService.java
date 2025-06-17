package com.example.demo.service;

import org.springframework.data.repository.query.Param;



public interface UserService {
	
	public String getUserEmail(Integer userId);

	public boolean addUser(String userName, String userEmail, String userPassword);
	
	boolean emailConfirmOk(String userName);

}
	
	

