package com.example.demo.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Hash;


// 實作業務邏輯 (邏輯層)
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public String getUserEmail(Integer userId) {
		return userRepository.getUserEmail(userId);
	}

	@Override
	public boolean addUser(String userName, String userEmail, String userPassword) {
		// 當使用者註冊帳號傳到這邊來的時候, 先進行比對, 檢查資料庫是否有一樣的email(因email為唯一值)
		Optional<User> checkIfExcisting = userRepository.findEmailByUserEmail(userEmail);
		if(checkIfExcisting.isPresent()) {
			return false;
		}
		
		// 如果確認完後這帳號還沒被註冊過,則會在這邊幫牠的密碼進行加鹽雜湊後對進資料庫裡
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
		return true;
	}

}
