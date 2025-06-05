package com.example.demo.service.Impl;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.CertException;
import com.example.demo.exception.PasswordInvalidException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CertService;
import com.example.demo.util.Hash;


@Service
public class CertServiceImpl implements CertService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserCert getCert(String email, String password) throws CertException {
		// 1. 先確定是否有這個人在資料庫
		User user = userRepository.findByUserEmail(email);
		if(user == null) {
			throw new UserNotFoundException("尚未註冊");
		}
		
		// 2. 如果有資料的話 這邊進行 hash 比對
		String passwordHash = Hash.getHash(password, user.getSalt());
		if(!passwordHash.equals(user.getUserPassword())) {
			throw new PasswordInvalidException("密碼錯誤");
		}
		
		// 3. 在前面比對嘉言過後的雜湊密碼為正確之後 這邊要給使用者發憑證
		UserCert userCert = new UserCert(user.getUserId(), user.getUserName(), user.getRole());
		
		return userCert;
	}
}
