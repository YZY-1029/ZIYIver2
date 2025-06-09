package com.example.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://localhost:5173/", allowCredentials = "true" )   // 允許跨域
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<?> register(@RequestBody UserDto userDto) {
		boolean result = userService.addUser(
				userDto.getUserName(),
				userDto.getUserEmail(),
				userDto.getUserPassword()
				);
		if (!result) {
			return ResponseEntity
				  .badRequest()
				  .body(Map.of("message","此信箱已被註冊過"));
		}
		return ResponseEntity.ok(Map.of("message","註冊成功"));
		
		
	}
	
	
}
