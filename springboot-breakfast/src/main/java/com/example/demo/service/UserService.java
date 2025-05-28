package com.example.demo.service;



public interface UserService {
	
	public String getUserEmail(String userName);

	public void addUser(String userEmail, String userName, String userPassword);
	
	public void fixUserPassword(String userEmail,String userName, String userPassword);
	
	public void findUserPassWord(String userEmail, String userName);
	
	public void deleteUser(String userId);
	
}
	
	

